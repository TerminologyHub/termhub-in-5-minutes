import os
import re
import subprocess
import sys

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
SCRIPTS_DIR = os.path.abspath(os.path.join(BASE_DIR, "..", "scripts"))
if SCRIPTS_DIR not in sys.path:
    sys.path.insert(0, SCRIPTS_DIR)

from process_output import print_process_failure
from termhub_auth import DEFAULT_API_URL, require_credentials, request_access_token


API_URL = os.environ.get("API_URL", DEFAULT_API_URL)
README_PATH = os.path.join(BASE_DIR, "README.md")
healthy_endpoints = []
unhealthy_endpoints = []
COMMANDS = "commands"
FILES = "files"

def check_jq():
    """Checks if jq is installed."""
    try:
        subprocess.run(["jq", "--version"], check = True, stdout = subprocess.DEVNULL, stderr = subprocess.DEVNULL)
    except (FileNotFoundError, subprocess.CalledProcessError):
        print("Error: jq is not installed. Please install jq to process JSON output.", file = sys.stderr)
        sys.exit(1)

def get_auth_token():
    """Resolve credentials and request the bearer token used by README curls."""
    username, password = require_credentials(sys.argv[1:], "python curl_check.py <username> <password>")
    return request_access_token(API_URL, username, password)


def run_curl_command(command, endpoint):
    """Runs a curl command and returns the raw output."""
    try:
        result = subprocess.run(command, shell = True, cwd=BASE_DIR, capture_output = True, text = True)
        if result.returncode == 0:
            healthy_endpoints.append(endpoint)
            return result.stdout
        else:
            print(f"Error executing: {command}", file = sys.stderr)
            print_process_failure("curl", result)
            unhealthy_endpoints.append(endpoint)
            return None
    except Exception as e:
        print(f"Exception running curl: {e}", file = sys.stderr)
        unhealthy_endpoints.append(endpoint)
        return None

def process_markdown(token):
    """Parses README.md, extracts curl commands and corresponding sample files."""
    if not os.path.exists(README_PATH):
        print("Error: README.md not found.")
        sys.exit(1)

    with open(README_PATH, 'r', encoding='utf-8') as f:
        lines = f.readlines()

    sections = []
    current_section = {COMMANDS: [], FILES: []}
    in_section = False
    skip_sample_links = False

    for line in lines:
        if line.startswith("### ") and not in_section:
            current_section = {COMMANDS: [], FILES: []}
            in_section = True
            skip_sample_links = False
            continue

        if line.startswith("[Back to Top]") and in_section:
            in_section = False
            if current_section[COMMANDS]:
                sections.append(current_section)
            current_section = {COMMANDS: [], FILES: []}
            continue

        if in_section:
            if line.startswith("curl -"):
                curl_command = line.strip().replace("$API_URL", API_URL).replace("$token", token)
                current_section[COMMANDS].append(curl_command)
            if skip_sample_links:
                continue
            if line.startswith("No payload sample"):
                skip_sample_links = True
                current_section[FILES] = []
            if current_section[COMMANDS] and "samples/" in line:
                file_matches = re.findall(r'`samples/([^`]+)`', line)
                for match in file_matches:
                    current_section[FILES].append(f"samples/{match}")

    if in_section and current_section[COMMANDS]:
        sections.append(current_section)

    return sections

def run_sections(sections):
    """Executes curl commands and updates corresponding sample files."""
    for section in sections:
        print(f"Processing section with {len(section[COMMANDS])} curl commands and {len(section[FILES])} sample files.")
        sample_index = 0
        for curl_command in section[COMMANDS]:
            endpoint_match = re.search(r'\"(https?://[^\"]+)\"', curl_command)
            endpoint = endpoint_match.group(1) if endpoint_match else curl_command
            print(f"Running: {endpoint}")
            response = run_curl_command(curl_command, endpoint)
            if response and sample_index < len(section[FILES]):
                try:
                    jq_process = subprocess.run(["jq", "."], input = response, text = True, capture_output = True, check = True)
                    formatted_response = jq_process.stdout
                except subprocess.CalledProcessError:
                    print(f"Error processing JSON with jq: {curl_command}", file = sys.stderr)
                    formatted_response = response

                sample_path = os.path.join(BASE_DIR, section[FILES][sample_index])
                with open(sample_path, 'w', encoding='utf-8') as f:
                   f.write(formatted_response + "\n")
                print(f"Updated: {section[FILES][sample_index]}")
                sample_index += 1

def report_endpoints():
    """Print a health summary for all curl endpoints exercised in the run."""
    if unhealthy_endpoints:
      print("\nHealthy endpoints (total {}):".format(len(healthy_endpoints))) if healthy_endpoints else print("\nNo healthy endpoints found.")
      for endpoint in healthy_endpoints:
          print(endpoint)

      print("\nUnhealthy endpoints (total {}):".format(len(unhealthy_endpoints)))
      for endpoint in unhealthy_endpoints:
          print(endpoint)
    else:
      print("\nAll endpoints are healthy.")

if __name__ == "__main__":
    check_jq()
    token = get_auth_token()
    sections = process_markdown(token)
    run_sections(sections)
    report_endpoints()
