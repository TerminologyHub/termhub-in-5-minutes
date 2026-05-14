import argparse
import os
import shutil
import subprocess
import sys


PROJECT_ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))


def resolve_path(path):
    """Resolve a CLI path relative to the project root."""
    if os.path.isabs(path):
        return path
    return os.path.abspath(os.path.join(PROJECT_ROOT, path))


def ensure_under_root(path):
    """Reject generated Trivy paths that would write outside this project."""
    real_path = os.path.realpath(path)
    real_root = os.path.realpath(PROJECT_ROOT)
    if os.path.commonpath([real_root, real_path]) != real_root:
        raise ValueError(f"Refusing to write outside project root: {path}")


def run_checked(command):
    """Run a subprocess from the project root and fail on errors."""
    subprocess.run(command, cwd=PROJECT_ROOT, check=True)


def main():
    """Install Python deps into a scan directory and freeze exact versions."""
    parser = argparse.ArgumentParser(description="Prepare resolved Python dependency metadata for Trivy.")
    parser.add_argument("--site-dir", required=True, help="Directory where dependencies should be installed.")
    parser.add_argument("--output-dir", required=True, help="Directory where Trivy-readable requirements.txt is written.")
    parser.add_argument(
        "--requirements",
        action="append",
        required=True,
        help="Requirements file to install. Can be provided more than once.",
    )
    args = parser.parse_args()

    install_dir = resolve_path(args.site_dir)
    lock_output_dir = resolve_path(args.output_dir)
    for path in (install_dir, lock_output_dir):
        ensure_under_root(path)

    requirements_files = [resolve_path(path) for path in args.requirements]
    for path in requirements_files:
        if not os.path.exists(path):
            raise FileNotFoundError(path)

    if os.path.exists(install_dir):
        shutil.rmtree(install_dir)
    os.makedirs(install_dir, exist_ok=True)
    os.makedirs(lock_output_dir, exist_ok=True)

    install_command = [
        sys.executable,
        "-m",
        "pip",
        "install",
        "--disable-pip-version-check",
        "--upgrade",
        "--target",
        install_dir,
    ]
    for requirements_file in requirements_files:
        install_command.extend(["-r", requirements_file])
    run_checked(install_command)

    freeze_result = subprocess.run(
        [sys.executable, "-m", "pip", "freeze", "--path", install_dir],
        cwd=PROJECT_ROOT,
        check=True,
        capture_output=True,
        text=True,
    )
    with open(os.path.join(lock_output_dir, "requirements.txt"), "w", encoding="utf-8") as handle:
        handle.write(freeze_result.stdout)


if __name__ == "__main__":
    main()
