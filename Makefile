VERSION ?= 1.0.0
BUILD_DIR ?= ./build
PYTHON ?= python
TRIVY_BUILD_DIR ?= $(BUILD_DIR)/trivy
TRIVY_FLAGS ?=

API_URL ?= https://api.terminologyhub.com
PROJECT ?= sandbox
TERMHUB_USERNAME ?= $(TERMHUB_USER)

export API_URL
export PROJECT
export TERMHUB_USER
export TERMHUB_USERNAME
export TERMHUB_PASSWORD
export TERMHUB_TOKEN
export TOKEN

.PHONY: help all resample samples check test check-curl check-bash check-python check-java fhir check-fhir-r4 check-fhir-r5 python-deps install-python-deps scan scan-strict scan-source scan-deps scan-prepare scan-prepare-java scan-prepare-python scan-java scan-python regenerate regenerate-java regenerate-python clean

help:
	@echo "TermHub in 5 Minutes maintenance targets"
	@echo "  make resample          Recreate curl, bash, and Java sample outputs"
	@echo "  make check             Run curl, bash, Python, Java, and FHIR checks"
	@echo "  make fhir              Run both FHIR Postman collections with Newman"
	@echo "  make scan              Run Trivy source and dependency scans"
	@echo "  make scan-strict       Run Trivy scans and fail if vulnerabilities are found"
	@echo "  make scan-prepare      Generate resolved dependency inputs for Trivy"
	@echo "  make regenerate        Regenerate Java and Python clients into doc/code-generator/build"
	@echo "  make python-deps       Install Python generated-client dependencies for the current user"
	@echo ""
	@echo "Credentials: set TERMHUB_USER and TERMHUB_PASSWORD, or TERMHUB_TOKEN for FHIR."

all: check

# Generate updated samples.
resample: check-curl check-bash check-java

samples: resample

# Re-run tests across runnable examples.
check: check-curl check-bash check-python check-java fhir

test: check

check-curl:
	cd curl-examples && $(PYTHON) curl_check.py

check-bash:
	cd bash-examples && $(PYTHON) bash_check.py

check-python:
	cd python-examples && $(PYTHON) python_check.py

check-java:
	cd java-examples && $(PYTHON) java_check.py

fhir: check-fhir-r4 check-fhir-r5

check-fhir-r4:
	cd fhir-examples && $(PYTHON) postman_fhir.py R4

check-fhir-r5:
	cd fhir-examples && $(PYTHON) postman_fhir.py R5

python-deps:
	cd python-examples && $(PYTHON) -m pip install --user -r requirements.txt

install-python-deps: python-deps

scan: scan-source scan-deps

scan-strict: TRIVY_FLAGS := --exit-code 1
scan-strict: scan

scan-source:
	trivy fs $(TRIVY_FLAGS) --scanners vuln,secret,misconfig --skip-dirs .git --skip-dirs build --skip-dirs doc/code-generator/build --skip-dirs node_modules --skip-files java-examples/gradle.lockfile .

scan-deps: scan-java scan-python

scan-prepare: scan-prepare-java scan-prepare-python

scan-prepare-java:
	$(PYTHON) scripts/run_gradle.py java-examples resolveAndLockAll --write-locks

scan-prepare-python:
	$(PYTHON) scripts/prepare_trivy_python.py --site-dir $(TRIVY_BUILD_DIR)/python-site --output-dir $(TRIVY_BUILD_DIR)/python --requirements python-examples/requirements.txt --requirements python-examples/test-requirements.txt

scan-java: scan-prepare-java
	trivy fs $(TRIVY_FLAGS) --scanners vuln java-examples

scan-python: scan-prepare-python
	trivy fs $(TRIVY_FLAGS) --scanners vuln $(TRIVY_BUILD_DIR)/python

regenerate:
	$(PYTHON) scripts/run_gradle.py doc/code-generator buildClients

regenerate-java:
	$(PYTHON) scripts/run_gradle.py doc/code-generator buildJavaSdk

regenerate-python:
	$(PYTHON) scripts/run_gradle.py doc/code-generator buildPythonSdk

clean:
	@echo "Cleaning ${BUILD_DIR} directory if it exists"
