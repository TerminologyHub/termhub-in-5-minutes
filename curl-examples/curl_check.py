import os
import re
import requests
import subprocess
import sys

# Define API_URL as a global variable
API_URL = "https://api.terminologyhub.com"
healthy_endpoints = []
unhealthy_endpoints = []

def check_jq():
    """Checks if jq is installed."""
    try:
        subprocess.run(["jq", "--version"], check = True, stdout = subprocess.DEVNULL, stderr = subprocess.DEVNULL)
    except subprocess.CalledProcessError:
        print("Error: jq is not installed. Please install jq to process JSON output.", file = sys.stderr)
        sys.exit(1)

def get_auth_token():
    credentials = {
        "grant_type": "username_password",
        "username": sys.argv[1],
        "password": sys.argv[2]
    }
    response = requests.post(f"{API_URL}/auth/token", json=credentials, headers={"Content-Type": "application/json"})
    
    if response.status_code != 200:
        raise Exception(f"Failed to get token: {response.status_code} {response.text}")
    if not response.json().get("access_token"):
        raise Exception("No token found in {API_URL}/auth/token response")
    return response.json().get("access_token")
    

def execute_curl(command, endpoint):
    """Runs a curl command and returns the raw output."""
    try:
        result = subprocess.run(command, shell = True, capture_output = True, text = True)
        if result.returncode == 0:
            # regex to extract the endpoint from the curl command
            healthy_endpoints.append(endpoint)
            return result.stdout
        else:
            print(f"Error executing: {command}", file = sys.stderr)
            print(f"Curl error: {result.stderr}", file = sys.stderr)
            unhealthy_endpoints.append(re.searchendpoint)
            return None
    except Exception as e:
        print(f"Exception running curl: {e}", file = sys.stderr)
        unhealthy_endpoints.append(endpoint)
        return None

def process_markdown(token):
    """Parses README.md, extracts curl commands and corresponding sample files."""
    if not os.path.exists("README.md"):
        print("Error: README.md not found.")
        sys.exit(1)
    
    with open("README.md", 'r', encoding='utf-8') as f:
        lines = f.readlines()
    
    sections = []
    # set up each section with commands and corresponding files
    current_section = {"curls": [], "files": []}
    in_section = False
    
    for line in lines:
        # each section that has curl commands and corresponding sample files starts with "### "
        if line.startswith("### ") and not in_section:
            current_section = {"curls": [], "files": []}
            in_section = True
            no_sample_section = False
            continue

        # sections end with a "[Back to Top]"
        if line.startswith("[Back to Top]") and in_section:
            in_section = False
            if current_section["curls"]:
                sections.append(current_section)
            continue
        
        if in_section:
            # found a curl command
            if line.startswith("curl -"):
                # processing command with API_URL
                curl_command = line.strip().replace("$API_URL", API_URL).replace("$token", token)
                current_section["curls"].append(curl_command)
            if no_sample_section:
                continue
            if line.startswith("No payload sample"):
                no_sample_section = True
                current_section["files"] = []
            # all sample files are in the samples directory, so look for that
            if(current_section["curls"] and "samples/" in line):
              file_matches = re.findall(r'`samples/([^`]+)`', line)
              for match in file_matches:
                  current_section["files"].append(f"samples/{match}")
    
    if current_section["curls"]:
        sections.append(current_section)
    
    return sections

def run_sections(sections):
    """Executes curl commands and updates corresponding sample files."""
    for section in sections:
        print(f"Processing section with {len(section['curls'])} curl commands and {len(section['files'])} sample files.")
        file_index = 0
        for curl_cmd in section["curls"]:
            endpoint = re.search(r'\"(https://[^\"]+)\"', curl_cmd).group(1)
            print(f"Running: {endpoint}")
            response = execute_curl(curl_cmd, endpoint)
            # ignore extra responses if there are more responses in a section than sample files
            if response and file_index < len(section["files"]):
                try:
                    jq_process = subprocess.run(["jq", "."], input = response, text = True, capture_output = True, check = True)
                    formatted_response = jq_process.stdout
                except subprocess.CalledProcessError:
                    print(f"Error processing JSON with jq: {curl_cmd}", file = sys.stderr)
                    formatted_response = response
                
                with open(section["files"][file_index], 'w', encoding='utf-8') as f:
                   f.write(formatted_response + "\n")
                print(f"Updated: {section['files'][file_index]}")
                file_index += 1

def report_endpoints():
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
    if(len(sys.argv) < 2):
        print("This script requires a termhub username/password.")
        print("\nUsage: python curl_check.py <username> <password>")
        sys.exit(1)
    check_jq()
    token = get_auth_token()
    sections = process_markdown(token)
    run_sections(sections)
    report_endpoints()
