# Termhub in 5 Minutes Tutorial

This is an easy-to-use tutorial for accessing TermHub APIs through api.terminologyhub.com.
[TermHub](https://www.terminologyhub.com) is a cloud healthcare terminology server offering 
access to a large library of code systems, value sets, and concept mappings along with standard 
developer-friendly mechansims for interacting with that content (such as FHIR® terminology services).

[Tutorial Training Video](https://youtu.be/Vto42DIMw2U)

**Reference deployments**

To test against our TermHub terminology servers, you must first create an account by signing up at https://app.terminologyhub.com/signup.

## Table of Contents

1. [Tutorials by Language](#tutorials-by-language)
2. [Use Cases](#use-cases)
3. [Maintenance Commands](#maintenance-commands)
4. [Resources](#resources)
5. [Contributing](#contributing)
6. [License](#license)

## Tutorials by Language

- [Click for Bash examples.](../master/bash-examples/ "Bash Examples")
- [Click for Curl examples.](../master/curl-examples/ "Curl Examples")
- [Click for Go examples.](../master/go-examples/ "Go Examples")
- [Click for FHIR examples.](../master/fhir-examples/ "FHIR Examples")
- [Click for Java examples.](../master/java-examples/ "Java Examples")
- [Click for JavaScript examples.](../master/javascript-examples/ "JavaScript Examples")
- [Click for Postman examples.](../master/postman-examples/ "Postman Examples")
- [Click for Python examples.](../master/python-examples/ "Python Examples")


**[Back to top](#table-of-contents)**

## Use Cases

The following cases will be used to demonstrate accessing the TermHub Terminology API.  These are
the standard kinds of questions that a terminology server supports for interacting with code systems.

- Login
- Get terminologies
- Get project terminologies
- Get specific terminology
- Export terminology
- Get concept by code
- Get concept by code with explicit include parameter
- Get concept relationships by code
- Get concept inverse relationships by code
- Get concept trees
- Find concepts by search term (use paging to get only first 5 results)
- Find concepts by search term with explicit include parameter
- Find concepts by search term and expression
- Find terms by search term
- Support autocomplete/typeahead for first few characters typed
- Get mapsets
- Get project mapsets
- Get specific mapset
- Export mapset
- Get mappings for concept by code
- Find project mappings for mapset
- Find project mappings
- Get subsets
- Get project subsets
- Get specific subset
- Export subset
- Get subset members for project subset
- Coming Soon: compute "new" or "retired" codes across terminology versions

All of the tutorials use an environment variable for the API URL of the deployment:

- API_URL=https://api.terminologyhub.com

**[Back to top](#table-of-contents)**

## Maintenance Commands

The project includes a root `Makefile` for the common upkeep workflow. Run these commands from the
`termhub-in-5-minutes` directory.

Set credentials once in your shell before running checks that call authenticated TermHub endpoints:

```bash
export TERMHUB_USER=<username>
export TERMHUB_PASSWORD=<password>
```

On Windows PowerShell:

```powershell
$env:TERMHUB_USER="<username>"
$env:TERMHUB_PASSWORD="<password>"
```

For the bash examples on Windows, install Git for Windows or set `BASH` to a Windows-native
`bash.exe`. The runner avoids WSL's `C:\Windows\System32\bash.exe` because WSL can fail when
the Windows `PATH` contains drive paths it cannot translate.

```powershell
$env:BASH="C:\Program Files\Git\bin\bash.exe"
```

Common targets:

```bash
make resample       # recreate curl, bash, and Java sample files
make check          # run curl, bash, Python, Java, and FHIR checks
make fhir           # run both FHIR Postman collections with Newman
make scan           # run Trivy source and resolved dependency scans
make scan-strict    # same scan, but fail when vulnerabilities are found
make scan-prepare   # generate resolved dependency inputs under build/trivy
make regenerate     # regenerate Java and Python clients into doc/code-generator/build
make python-deps    # install generated Python client dependencies for the current user
```

The curl, bash, FHIR runner, and check orchestration scripts use only Python standard-library modules.
The generated Python client still needs its generated dependencies; use `make python-deps` when running
the Python client tests on a fresh machine.
The Trivy dependency scan is prepared before it runs. For Python, it installs requirements into
`build/trivy/python-site` and writes a pinned `build/trivy/python/requirements.txt`; for Java, it
resolves Gradle dependencies and updates `java-examples/gradle.lockfile`.

Use `API_URL`, `PROJECT`, and `PYTHON` to override defaults, for example:

```bash
make check API_URL=https://dev.terminologyhub.com PROJECT=sandbox PYTHON=python3
```

The curl and bash checks print the `API_URL` they are using. If you see a connection refused
error, check whether your shell has an old `API_URL` pointing at a stopped local instance.
You can also set `TERMHUB_TOKEN` or `TOKEN` to reuse an existing bearer token.

**[Back to top](#table-of-contents)**


## Resources

- API Documentation - https://api.terminologyhub.com/terminology/doc/swagger-ui/index.html
- [Additional Documentation](../master/doc/)


**[Back to top](#table-of-contents)**

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request

**[Back to top](#table-of-contents)**

## Current Contributors

- [Brian Carlsen](https://github.com/bcarlsenca)
- [Other Contributors](https://github.com/WestCoastInformatics/termhub-in-5-minutes/graphs/contributors)

**[Back to top](#table-of-contents)**

## License

See the included [`LICENSE.txt`](LICENSE.txt) file for details.

**[Back to top](#table-of-contents)**
