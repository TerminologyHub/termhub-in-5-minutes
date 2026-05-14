import sys


def print_process_failure(tool_name, result, stream=sys.stderr):
    """Print return code plus stderr/stdout for a failed subprocess."""
    print(f"{tool_name} exit code: {result.returncode}", file=stream)

    stderr = (result.stderr or "").rstrip()
    stdout = (result.stdout or "").rstrip()
    if stderr:
        print(f"{tool_name} stderr:", file=stream)
        print(stderr, file=stream)
    if stdout:
        print(f"{tool_name} stdout:", file=stream)
        print(stdout, file=stream)
    if not stderr and not stdout:
        print(f"{tool_name} produced no stdout or stderr.", file=stream)
