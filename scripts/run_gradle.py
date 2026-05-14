import os
import subprocess
import sys


def main():
    """Run a Gradle task with repo-local wrapper and cache paths."""
    if len(sys.argv) < 3:
        print("Usage: python scripts/run_gradle.py <project-dir> <gradle-task> [args...]", file=sys.stderr)
        return 1

    repo_root = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    project_dir = os.path.abspath(os.path.join(repo_root, sys.argv[1]))
    if not os.path.isdir(project_dir):
        print(f"Gradle project directory not found: {project_dir}", file=sys.stderr)
        return 1

    wrapper_path = os.path.join(project_dir, "gradlew.bat" if sys.platform == "win32" else "gradlew")
    if not os.path.exists(wrapper_path):
        gradle_command = "gradle"
    else:
        gradle_command = wrapper_path

    gradle_env = os.environ.copy()
    gradle_env.setdefault("GRADLE_USER_HOME", os.path.join(project_dir, ".gradle-user-home"))

    result = subprocess.run([gradle_command] + sys.argv[2:], cwd=project_dir, env=gradle_env)
    return result.returncode


if __name__ == "__main__":
    sys.exit(main())
