import os
import re
import shlex
import subprocess
import sys

"""This script reads the README.md file, extracts pytest commands and corresponding sample files, executes the pytest commands, checks that said commands run properly, and updates the sample files with the output."""

healthy_scripts = []
unhealthy_scripts = []
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
SCRIPTS_DIR = os.path.abspath(os.path.join(BASE_DIR, "..", "scripts"))
if SCRIPTS_DIR not in sys.path:
    sys.path.insert(0, SCRIPTS_DIR)

from process_output import print_process_failure
from termhub_auth import publish_credentials_from_args


README_PATH = os.path.join(BASE_DIR, "README.md")
TOKEN_PATH = os.path.join(BASE_DIR, "temp_token.txt")
COMMANDS = "commands"
FILES = "files"

def check_pytest_installation():
    """Verify pytest is available through the current Python interpreter."""
    try:
        subprocess.run([sys.executable, "-m", "pytest", "--version"], capture_output=True, check=True)
    except (FileNotFoundError, subprocess.CalledProcessError):
        print("pytest is not installed or not available in the current Python environment.", file=sys.stderr)
        print("Run `python -m pip install --user -r requirements.txt` from python-examples, or `make python-deps` from the project root.", file=sys.stderr)
        sys.exit(1)

def run_pytest_command(command):
    """Runs a pytest command and returns the raw output."""
    try:
        args = shlex.split(command)
        if args and args[0] == "pytest":
            args = [sys.executable, "-m", "pytest"] + args[1:]
        result = subprocess.run(args, cwd=BASE_DIR, capture_output=True, text=True)
        if result.returncode == 0:
            healthy_scripts.append(command)
            return result.stdout
        else:
            unhealthy_scripts.append(command)
            print(f"Error executing: {command}", file=sys.stderr)
            print_process_failure("pytest", result)
            return None
    except Exception as e:
        print(f"Exception running pytest: {e}", file=sys.stderr)
        return None

def process_markdown():
    """Parses README.md, extracts pytest commands and corresponding sample files."""
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
            if line.startswith("pytest "):
                pytest_command = line.strip()
                current_section[COMMANDS].append(pytest_command)

            file_matches = re.findall(r'`samples/([^`]+)`', line)
            for match in file_matches:
                current_section[FILES].append(f"samples/{match}")

    if in_section and current_section[COMMANDS]:
        sections.append(current_section)

    return sections

def load_saved_token():
    """Load the login test token so later pytest examples can reuse it."""
    if os.path.exists(TOKEN_PATH):
        with open(TOKEN_PATH, "r", encoding="utf-8") as token_file:
            os.environ["TOKEN"] = token_file.read().strip()


def remove_saved_token():
    """Remove the temporary token file produced during sample test runs."""
    if os.path.exists(TOKEN_PATH):
        os.remove(TOKEN_PATH)

def run_sections(sections):
    """Executes pytest commands and updates corresponding sample files."""
    for section in sections:
        sample_index = 0
        for pytest_command in section[COMMANDS]:
            print(f"Running: {pytest_command}")
            load_saved_token()
            response = run_pytest_command(pytest_command)
            if response and sample_index < len(section[FILES]):
                sample_path = os.path.join(BASE_DIR, section[FILES][sample_index])
                with open(sample_path, 'w', encoding='utf-8') as f:
                   f.write(response)
                print(f"Updated: {section[FILES][sample_index]}")
                sample_index += 1
    remove_saved_token()

def report_script_health():
    """Print a health summary for all pytest examples exercised in the run."""
    if(unhealthy_scripts):
        print("Healthy endpoint tests (count {}): ".format(len(healthy_scripts))) if healthy_scripts else None
        for script in healthy_scripts:
            print(script)
        print("Unhealthy endpoint tests (count {}):".format(len(unhealthy_scripts)))
        for script in unhealthy_scripts:
            print(script)
    else:
        print("\nAll " + str(len(healthy_scripts)) + " sample tests executed successfully and all endpoints are healthy.")

if __name__ == "__main__":
    publish_credentials_from_args(sys.argv[1:])
    check_pytest_installation()
    sections = process_markdown()
    run_sections(sections)
    report_script_health()
