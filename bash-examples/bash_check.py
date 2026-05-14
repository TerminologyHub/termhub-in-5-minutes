import os
import re
import shutil
import subprocess
import sys

"""This script reads the README.md file, extracts bash commands and corresponding sample files, executes the bash commands, checks that said commands run properly, and updates the sample files with the output. The use of f-strings in processing the commands requires Python 3.6 or later."""

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
SCRIPTS_DIR = os.path.abspath(os.path.join(BASE_DIR, "..", "scripts"))
if SCRIPTS_DIR not in sys.path:
    sys.path.insert(0, SCRIPTS_DIR)

from process_output import print_process_failure
from termhub_auth import DEFAULT_API_URL, require_credentials, request_access_token


API_URL = os.environ.get("API_URL", DEFAULT_API_URL)
README_PATH = os.path.join(BASE_DIR, "README.md")
healthy_scripts = []
unhealthy_scripts = []
COMMANDS = "commands"
FILES = "files"
BASH_EXECUTABLE = None

def is_wsl_bash(path):
    """Identify the Windows WSL bash launcher, which can inherit bad PATH entries."""
    if sys.platform != "win32" or not path:
        return False
    normalized = os.path.normcase(os.path.abspath(path))
    return normalized.endswith(os.path.normcase(r"\Windows\System32\bash.exe"))


def windows_bash_candidates():
    """Return Windows-native Bash candidates before PATH-discovered launchers."""
    candidates = [
        os.environ.get("BASH"),
        r"C:\Program Files\Git\bin\bash.exe",
        r"C:\Program Files\Git\usr\bin\bash.exe",
        r"C:\Program Files (x86)\Git\bin\bash.exe",
        r"C:\Program Files (x86)\Git\usr\bin\bash.exe",
        r"C:\cygwin64\bin\bash.exe",
        r"C:\cygwin\bin\bash.exe",
        r"C:\msys64\usr\bin\bash.exe",
        r"C:\Program Files (x86)\Gow\bin\bash.exe",
        shutil.which("bash.exe"),
        shutil.which("bash"),
    ]
    return [candidate for candidate in candidates if candidate]


def resolve_bash():
    """Find a Bash executable that can run the README shell examples."""
    if sys.platform == "win32":
        existing_candidates = [path for path in windows_bash_candidates() if os.path.exists(path)]
        for path in existing_candidates:
            if not is_wsl_bash(path):
                return path
        if existing_candidates:
            raise RuntimeError(
                "Only the WSL bash launcher was found. Install Git Bash or set BASH "
                "to a Windows-native bash.exe path before running bash examples."
            )
        raise RuntimeError("Bash is not installed or not accessible.")

    return os.environ.get("BASH") or shutil.which("bash") or "bash"


def bash_executable():
    """Resolve Bash once so all sample commands run in the same shell."""
    global BASH_EXECUTABLE
    if BASH_EXECUTABLE is None:
        BASH_EXECUTABLE = resolve_bash()
    return BASH_EXECUTABLE

def check_bash_installation():
    """Checks if bash is installed and exits with an error if not."""
    try:
        subprocess.run([bash_executable(), "--version"], capture_output=True, check=True)
    except (FileNotFoundError, subprocess.CalledProcessError, RuntimeError) as error:
        print(error, file=sys.stderr)
        sys.exit(1)

def get_auth_context():
    """Resolve credentials and token once for all README bash examples."""
    credentials = require_credentials(sys.argv[1:], "python bash_check.py <username> <password>")
    token = request_access_token(API_URL, *credentials)
    return credentials, token


def run_bash_command(command, token, credentials):
    """Runs a bash command and returns the raw output."""
    try:
        display_command = command
        print(f"Running: {display_command}")
        if "(username)" in command and "(password)" in command:
            username, password = credentials
            command = command.replace("(username)", username).replace("(password)", password)
        command = command.replace("$token", token)
        result = subprocess.run([bash_executable(), "-c", command], cwd=BASE_DIR, capture_output=True, text=True)
        if result.returncode == 0:
            healthy_scripts.append(display_command)
            return result.stdout
        else:
            unhealthy_scripts.append(display_command)
            escaped_command = display_command.replace('"', r'\"')
            print(f'{bash_executable()} -c "{escaped_command}"')
            print(f"Error executing: {escaped_command}", file=sys.stderr)
            print_process_failure("bash", result)
            return None
    except Exception as e:
        print(f"Exception running bash: {e}", file=sys.stderr)
        return None

def process_markdown():
    """Parses README.md, extracts bash commands and corresponding sample files."""
    if not os.path.exists(README_PATH):
        print("Error: README.md not found.")
        sys.exit(1)

    with open(README_PATH, 'r', encoding='utf-8') as f:
        lines = f.readlines()

    sections = []
    # set up each section with commands and corresponding files
    current_section = {COMMANDS: [], FILES: []}
    in_section = False

    for line in lines:
        if line.startswith("### ") and not in_section:
            current_section = {COMMANDS: [], FILES: []}
            in_section = True
            continue

        if line.startswith("[Back to Top]") and in_section:
            in_section = False
            if current_section[COMMANDS]:
                sections.append(current_section)
            current_section = {COMMANDS: [], FILES: []}
            continue

        if in_section:
            if line.startswith("$ ./"):
                bash_command = line.strip().replace("$API_URL", API_URL)
                current_section[COMMANDS].append(bash_command[2:])

            file_matches = re.findall(r'`samples/([^`]+)`', line)
            for match in file_matches:
                current_section[FILES].append(f"samples/{match}")

    if in_section and current_section[COMMANDS]:
        sections.append(current_section)

    return sections

def run_sections(sections, token, credentials):
    """Executes bash commands and updates corresponding sample files."""
    for section in sections:
        sample_index = 0
        for bash_command in section[COMMANDS]:
            response = run_bash_command(bash_command, token, credentials)
            if response and sample_index < len(section[FILES]):
                sample_path = os.path.join(BASE_DIR, section[FILES][sample_index])
                with open(sample_path, 'w', encoding='utf-8') as f:
                   f.write(response + "\n")
                sample_index += 1

def report_script_health():
    """Print a health summary for all bash scripts exercised in the run."""
    if(unhealthy_scripts):
        print("Healthy scripts (count {}): ".format(len(healthy_scripts))) if healthy_scripts else None
        for script in healthy_scripts:
            print(script)
        print("Unhealthy scripts (count {}):".format(len(unhealthy_scripts)))
        for script in unhealthy_scripts:
            print(script)
    else:
        print("\nAll scripts executed successfully.")

if __name__ == "__main__":
    check_bash_installation()
    credentials, token = get_auth_context()
    sections = process_markdown()
    run_sections(sections, token, credentials)
    report_script_health()
