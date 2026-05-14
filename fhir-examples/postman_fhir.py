import json
import os
import shutil
import subprocess
import sys
import tempfile


BASE_DIR = os.path.dirname(os.path.abspath(__file__))
SCRIPTS_DIR = os.path.abspath(os.path.join(BASE_DIR, "..", "scripts"))
if SCRIPTS_DIR not in sys.path:
    sys.path.insert(0, SCRIPTS_DIR)

from termhub_auth import (
    DEFAULT_API_URL,
    credentials_from_args,
    first_present,
    request_access_token,
    token_from_env,
)


COLLECTIONS = {
    "R4": "Termhub-FHIR-R4.postman_collection.json",
    "R5": "Termhub-FHIR-R5.postman_collection.json",
}


def get_auth_token(api_url, auth_args):
    """Use an existing token or request one for Newman FHIR checks."""
    existing_token = token_from_env()
    if existing_token:
        return existing_token

    username, password = credentials_from_args(auth_args)
    if not username or not password:
        print("FHIR checks require TERMHUB_TOKEN or a TermHub username/password.", file=sys.stderr)
        print("Usage: python postman_fhir.py R4 <username> <password>", file=sys.stderr)
        print("Or set TERMHUB_USER and TERMHUB_PASSWORD.", file=sys.stderr)
        return None

    try:
        return request_access_token(api_url, username, password)
    except RuntimeError as error:
        print(str(error), file=sys.stderr)
        return None


def newman_runner_command():
    """Find Newman directly or through npx for cross-platform FHIR runs."""
    newman = shutil.which("newman")
    if newman:
        return [newman]

    npx = shutil.which("npx")
    if npx:
        return [npx, "--yes", "newman"]

    print("Newman is not installed, and npx is not available to run it.", file=sys.stderr)
    print("Install Node.js and Newman, then retry: npm install -g newman", file=sys.stderr)
    return None


def write_bearer_collection(collection_file, token):
    """Write a temporary Postman collection with bearer auth injected."""
    with open(collection_file, "r", encoding="utf-8") as handle:
        collection = json.load(handle)

    collection["auth"] = {
        "type": "bearer",
        "bearer": [
            {
                "key": "token",
                "value": token,
                "type": "string",
            }
        ],
    }

    temp_file = tempfile.NamedTemporaryFile(
        mode="w",
        encoding="utf-8",
        suffix=".postman_collection.json",
        delete=False,
    )
    with temp_file:
        json.dump(collection, temp_file)
    return temp_file.name


def run_collection(version, api_url, project, token):
    """Run one FHIR Postman collection with TermHub runtime variables."""
    collection_name = COLLECTIONS[version]
    collection_file = os.path.join(BASE_DIR, collection_name)
    if not os.path.exists(collection_file):
        print(f"Collection file not found: {collection_file}", file=sys.stderr)
        return 1

    command = newman_runner_command()
    if command is None:
        return 1

    bearer_collection_path = write_bearer_collection(collection_file, token)
    env = os.environ.copy()
    env.setdefault("NODE_OPTIONS", "--dns-result-order=ipv4first")
    try:
        print(f"Running {collection_name} with baseUrl={api_url} and idOrUriLabel={project}")
        result = subprocess.run(
            command
            + [
                "run",
                bearer_collection_path,
                "--env-var",
                f"baseUrl={api_url}",
                "--env-var",
                f"idOrUriLabel={project}",
            ],
            cwd=BASE_DIR,
            env=env,
        )
        return result.returncode
    finally:
        try:
            os.remove(bearer_collection_path)
        except OSError:
            pass


def selected_versions(raw_version):
    """Map the requested FHIR version argument to collection versions."""
    if raw_version in ("", "ALL"):
        return ["R4", "R5"]
    version = raw_version.upper()
    if version not in COLLECTIONS:
        print("Invalid FHIR version. Use R4, R5, or ALL.", file=sys.stderr)
        return []
    return [version]


def main():
    """Parse CLI/env settings and run the selected FHIR collections."""
    raw_version = sys.argv[1].upper() if len(sys.argv) > 1 else "ALL"
    versions = selected_versions(raw_version)
    if not versions:
        return 1

    auth_args = sys.argv[2:]
    api_url = os.environ.get("API_URL", DEFAULT_API_URL)
    project = first_present(
        os.environ.get("PROJECT"),
        os.environ.get("TERMHUB_PROJECT"),
        os.environ.get("ID_OR_URI_LABEL"),
        "sandbox",
    )
    token = get_auth_token(api_url, auth_args)
    if not token:
        return 1

    status = 0
    for version in versions:
        status = run_collection(version, api_url, project, token) or status
    return status


if __name__ == "__main__":
    sys.exit(main())
