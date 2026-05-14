import os
import re
import shlex
import subprocess
import sys

"""This script reads the README.md file, extracts java commands and corresponding sample files, executes the java commands, checks that said commands run properly, and updates the sample files with the output."""

healthy_scripts = []
unhealthy_scripts = []
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
SCRIPTS_DIR = os.path.abspath(os.path.join(BASE_DIR, "..", "scripts"))
if SCRIPTS_DIR not in sys.path:
    sys.path.insert(0, SCRIPTS_DIR)

from process_output import print_process_failure
from termhub_auth import credentials_from_env, publish_credentials_from_args


README_PATH = os.path.join(BASE_DIR, "README.md")
GRADLE_USER_HOME = os.path.join(BASE_DIR, ".gradle-user-home")
COMMANDS = "commands"
FILES = "files"

def check_java_installation():
    """Verify Java is available before running Gradle sample tests."""
    try:
        subprocess.run(["java", "--version"], capture_output=True, check=True)
    except (FileNotFoundError, subprocess.CalledProcessError):
        print("Java is not installed or not accessible.", file=sys.stderr)
        sys.exit(1)

def run_gradle_test(command):
    """Runs a java gradlew test command and returns the raw output."""
    try:
        os.makedirs(GRADLE_USER_HOME, exist_ok=True)
        gradle_env = os.environ.copy()
        gradle_env.setdefault("GRADLE_USER_HOME", GRADLE_USER_HOME)

        gradle_args = shlex.split(command, posix=sys.platform != "win32")
        if gradle_args and gradle_args[0] in ("./gradlew", "gradlew"):
            if sys.platform == "win32":
                gradle_args[0] = "gradlew.bat" if os.path.exists(os.path.join(BASE_DIR, "gradlew.bat")) else "gradlew"
            else:
                gradle_args[0] = "./gradlew"

        username, password = credentials_from_env()
        if username and password and not any(arg.startswith("-Pusername=") for arg in gradle_args):
            gradle_args.extend([f"-Pusername={username}", f"-Ppassword={password}"])

        result = subprocess.run(gradle_args, cwd=BASE_DIR, env=gradle_env, capture_output=True, text=True)
        if result.returncode == 0:
            healthy_scripts.append(command)
            return result.stdout
        else:
            unhealthy_scripts.append(command)
            print(f"Error executing: {command}", file=sys.stderr)
            print_process_failure("gradlew", result)
            return None
    except Exception as e:
        print(f"Exception running gradlew: {e}", file=sys.stderr)
        return None

def process_markdown():
    """Parses README.md, extracts java commands and corresponding sample files."""
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
            java_match = re.match(r'^`?(\./gradlew test[^`]*)`?$', line.strip())
            if java_match:
                current_section[COMMANDS].append(java_match.group(1))

            file_matches = re.findall(r'`samples/([^`]+)`', line)
            for match in file_matches:
                current_section[FILES].append(f"samples/{match}")

    if in_section and current_section[COMMANDS]:
        sections.append(current_section)

    return sections

def extract_standard_output(output):
    """Extract sample response text from Gradle's STANDARD_OUT blocks."""
    lines = re.findall(r"STANDARD_OUT\s+(.*?)\s+PASSED", output, re.DOTALL)
    return "".join(line for line in lines)

def run_sections(sections):
    """Executes java commands and updates corresponding sample files."""
    for section in sections:
        sample_index = 0
        for gradle_command in section[COMMANDS]:
            print(f"Running: {gradle_command}")
            response = run_gradle_test(gradle_command)
            if response and sample_index < len(section[FILES]):
                sample_path = os.path.join(BASE_DIR, section[FILES][sample_index])
                with open(sample_path, 'w', encoding='utf-8') as f:
                   f.write(extract_standard_output(response))
                print(f"Updated: {section[FILES][sample_index]}")
                sample_index += 1

def report_script_health():
    """Print a health summary for all Gradle tests exercised in the run."""
    if(unhealthy_scripts):
        print("Healthy scripts (count {}): ".format(len(healthy_scripts))) if healthy_scripts else None
        for script in healthy_scripts:
            print(script)
        print("Unhealthy scripts (count {}):".format(len(unhealthy_scripts)))
        for script in unhealthy_scripts:
            print(script)
    else:
        print("\nAll scripts executed successfully and all test endpoints are healthy.")

if __name__ == "__main__":
    publish_credentials_from_args(sys.argv[1:])
    check_java_installation()
    sections = process_markdown()
    run_sections(sections)
    report_script_health()
