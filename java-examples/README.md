# Termhub client SDK: Java Tutorial

This tutorial shows how to use a locally defined Java client to interact with the EVSREST API.

## Prerequisites

- JDK 11+ must be installed
- Gradle (7.2+)

The API URL for the TermHub is:

`export API_URL=https://api.terminologyhub.com`

Run this command before the sample curl calls below as they expect $API_URL to be set.

## Building the Code

Building the java-examples should be as simple as running the following command from
this directory.

```
./gradlew clean build
```

This will invoke Gradle to build the model objects and the clients themselves and then
will also run the unit tests which demonstrate use of the client to make actual API
calls against Termhub.

If you only want to build (for example to run the tests separately) then run:

```
./gradlew clean build -x test
```

This will build the model objects and clients, while not running the tests.

Sample Java tests
-----------------

The following examples can be typed into the command line of any terminal that has cURL and jq installed.

- [Login](#login)
- [Get terminologies](#get-terminologies)
- [Get project terminologies](#get-project-terminologies)
- [Get specific terminology](#get-terminology)
- [Export terminology](#export-terminology)
- [Get concept by code](#get-concept-by-code)
- [Get concept by code with explicit include parameter](#get-concept-by-code-with-explicit-include-parameter)
- [Get concept relationships by code](#get-concept-relationships-by-code)
- [Get concept inverse relationships by code](#get-concept-inverse-relationships-by-code)
- [Get concept trees](#get-concept-trees)
- [Find concepts by search term (use paging to get only first 5 results)](#find-concepts-by-search-term)
- [Find concepts by search term with explicit include parameter](#find-concepts-by-search-term-with-explicit-include-parameter)
- [Find concepts by search term and expression](#find-concepts-by-search-term-and-expression)
- [Find terms by search term](#find-terms-by-search-term)
- [Support autocomplete/typeahead for first few characters typed](#support-autocomplete-typeahead-for-first-few-characters-typed)
- [Get mapsets](#get-mapsets)
- [Get project mapsets](#get-project-mapsets)
- [Get specific mapset](#get-mapset)
- [Export mapset](#export-mapset)
- [Get concept mappings by code](#get-concept-mappings-by-code)
- [Find project mappings for mapset](#find-project-mappings-for-mapset)
- [Find project mappings](#find-project-mappings)