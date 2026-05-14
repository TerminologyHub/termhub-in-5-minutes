import json
import os
import sys
import urllib.error
import urllib.request


DEFAULT_API_URL = "https://api.terminologyhub.com"
TOKEN_ENV_VARS = ("TERMHUB_TOKEN", "TOKEN")
USERNAME_ENV_VARS = ("TERMHUB_USER", "TERMHUB_USERNAME", "USER_NAME", "USERNAME")
PASSWORD_ENV_VARS = ("TERMHUB_PASSWORD", "PASSWORD")


def first_present(*values):
    """Return the first non-empty value from CLI/config/env fallbacks."""
    return next((value for value in values if value), "")


def token_from_env():
    """Read an existing bearer token from the supported TermHub env vars."""
    return first_present(*(os.environ.get(name) for name in TOKEN_ENV_VARS))


def credentials_from_args(args):
    """Resolve TermHub username/password from positional args or env vars."""
    username = first_present(
        args[0] if len(args) > 0 else "",
        *(os.environ.get(name) for name in USERNAME_ENV_VARS),
    )
    password = first_present(
        args[1] if len(args) > 1 else "",
        *(os.environ.get(name) for name in PASSWORD_ENV_VARS),
    )
    return username, password


def credentials_from_env():
    """Resolve TermHub username/password from environment variables only."""
    return credentials_from_args(())


def publish_credentials_from_args(args):
    """Expose positional username/password args through the env vars tests expect."""
    if len(args) > 0 and args[0]:
        for name in USERNAME_ENV_VARS:
            os.environ.setdefault(name, args[0])
    if len(args) > 1 and args[1]:
        for name in PASSWORD_ENV_VARS:
            os.environ.setdefault(name, args[1])


def require_credentials(args, usage, stream=sys.stderr):
    """Resolve credentials or exit with a consistent usage message."""
    username, password = credentials_from_args(args)
    if username and password:
        return username, password

    print("This script requires a TermHub username/password.", file=stream)
    print(f"Usage: {usage}", file=stream)
    print("Or set TERMHUB_USER and TERMHUB_PASSWORD.", file=stream)
    raise SystemExit(1)


def request_access_token(api_url, username, password):
    """Request a TermHub access token using the username/password grant."""
    payload = {
        "grant_type": "username_password",
        "username": username,
        "password": password,
    }
    request = urllib.request.Request(
        f"{api_url}/auth/token",
        data=json.dumps(payload).encode("utf-8"),
        headers={"Content-Type": "application/json"},
        method="POST",
    )

    try:
        with urllib.request.urlopen(request) as response:
            body = json.loads(response.read().decode("utf-8"))
    except urllib.error.HTTPError as error:
        error_body = error.read().decode("utf-8", errors="replace")
        raise RuntimeError(f"Failed to get token: {error.code} {error_body}") from error
    except urllib.error.URLError as error:
        raise RuntimeError(f"Failed to get token: {error.reason}") from error

    access_token = body.get("access_token")
    if not access_token:
        raise RuntimeError(f"No access_token found in {api_url}/auth/token response.")
    return access_token
