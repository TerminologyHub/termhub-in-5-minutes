Termhub in 5 Minutes: bash Tutorial
===================================

This tutorial shows how to use bash scripts to access content from the TermHub Terminology API.

Prerequisites
-------------
* curl must be installed ([Download cURL](https://curl.haxx.se/dlwiz/))
* jq must be installed ([Download jq](https://stedolan.github.io/jq/download/))
* bash must be installed

The various scripts make use of the local `url.env` file to define the API URL.

When using a url.env that points to an instance (such as https://api.terminologyhub.com) that
requires authentication, the login.sh script must first be used to obtain an access
token. All scripts accept a --help flag with additional examples.

Test Scripts
------------
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
- [Support autocomplete/typeahead for first few characters typed](#support-autocompletetypeahead-for-first-few-characters-typed)
- [Get mapsets](#get-mapsets)
- [Get project mapsets](#get-project-mapsets)
- [Get specific mapset](#get-mapset)
- [Export mapset](#export-mapset)
- [Get concept mappings by code](#get-concept-mappings-by-code)
- [Find project mappings for mapset](#find-project-mapset-mappings)
- [Find project mappings](#find-project-mappings)

The following examples can be typed into the command line of any terminal that has bash, cURL and jq installed.  Run each script with no parameters for examples of how to call each one.


### <a id="login" />Login - login.sh

Login to TermHub via username and password.
When finished, copy/past the "token=..." to set a local variable that
can be easily used for further calls.

NOTE: for instances of the server that have login disabled, simply use "guest" as the token.

```bash
$ ./login.sh (username) (password)
```

From the output, paste the "token=..." into your shell to set it as a variable for the following calls.

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-terminologies" />Get terminologies - find-terminologies.sh

Return all loaded terminologies currently hosted by the API.

```bash
$ ./find-terminologies.sh --token $token
```

See sample payload data from this call in [`samples/find-terminologies.txt`](samples/find-terminologies.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-project-terminologies" />Get project terminologies - find-terminologies.sh

Return all terminologies for specific project identified by either project id or project uriLabel.

```bash
$ ./find-terminologies.sh --token $token --project sandbox
```

See sample payload data from this call in [`samples/find-terminologies-by-project.txt`](samples/find-terminologies-by-project.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-terminology" />Get specific terminology - find-terminologies.sh

Return a specific terminology by its terminology id.  The UUID below is an example
that may or may not work.  The idea is to take one of the terminology ids returned
by one of the previous calls and you can then look up terminology info for specifically that
UUID.

```bash
$ ./find-terminologies.sh --token $token --id a1d1e426-26a6-4326-b18b-c54c154079b5
```

See sample payload data from this call in [`samples/find-terminologies-by-id.txt`](samples/find-terminologies-by-id.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="export-terminology" />Export terminology - export-terminology.sh

Export terminology for the given project id (or uriLabel) and terminology

```bash
$ ./export-terminology.sh --token $token sandbox SNOMEDCT
```

No payload sample as the output is a .zip file.

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-concept-by-code" />Get concept by code - get-concept.sh

Return summary concept information for a given terminology and code. 
The following example gets the 73211009 | Diabetes mellitus | concept in SNOMEDCT.

```bash
$ ./get-concept.sh sandbox SNOMEDCT 73211009 --token $token
```

See sample payload data from this call in [`samples/get-concept-by-code.txt`](samples/get-concept-by-code.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-concept-by-code-with-explicit-include-parameter" />Get concept by code with explicit include parameter - get-concept.sh

Return summary concept information for a given terminology and code and use --include to
specify exactly which parts of the concept to return.
The following example gets the 73211009 | Diabetes mellitus | concept in SNOMEDCT with "parents".

For more information see [INCLUDE.md](../doc/INCLUDE.md "INCLUDE.md").

```bash
$ ./get-concept.sh sandbox SNOMEDCT 73211009 --include parents --token $token
```

See sample payload data from this call in [`samples/get-concept-by-code-with-include.txt`](samples/get-concept-by-code-with-include.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-concept-relationships-by-code" />Get concept relationships by code - get-concept-relationships.sh

Return concept relationships for a given terminology and code.  This resolves
relationships that originate "from" this concept code and contains information about
the concepts those relationships point "to" on the other side.  The following example gets
relationships for the 73211009 | Diabetes mellitus | concept in SNOMEDCT.

```bash
$ ./get-concept-relationships.sh sandbox SNOMEDCT 73211009 --token $token
```

See sample payload data from this call in [`samples/get-concept-relationship.txt`](samples/get-concept-relationship.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-concept-inverse-relationships-by-code" />Get concept inverse relationships by code - get-concept-relationships.sh

Return inverse concept relationships for a given terminology and code.  This resolves
relationships that point "to" this concept code and contains information about
the concepts those relationships originate "from" on the other side.  The following example gets
inverse relationships for the 73211009 | Diabetes mellitus | concept in SNOMEDCT.

```bash
$ ./get-concept-relationships.sh sandbox SNOMEDCT 113331007 --inverse --token $token
```

See sample payload data from this call in [`samples/get-concept-inverse-relationships-by-code.txt`](samples/get-concept-inverse-relationships-by-code.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-concept-trees" />Get concept trees - get-concept-treepos.sh

Return concept tree positions for a given terminology and code. For classification hierarchies, you would expect to see just a single tree position. But for more complex poly-hierarchies you'd likely expect to see multiple tree positions - each one with a different path to the root concept. The  following example finds tree positions for the 73211009 | Diabetes mellitus | concept in SNOMEDCT. 

```bash
$ ./get-concept-treepos.sh sandbox SNOMEDCT 73211009 --token $token
```

See sample payload data from this call in [`samples/get-concept-treepos.txt`](samples/get-concept-treepos.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="find-concepts-by-search-term" />Find concepts by search term (use paging to get only first 5 results - find-concepts.sh

Return concepts matching a given text search for a given terminology. The following example
performs a text search for "diabetes mellitus" in SNOMEDCT and limits search results to 5
entries.

```bash
$ ./find-concepts.sh sandbox SNOMEDCT "diabetes mellitus" --token $token --limit 5
```

See sample payload data from this call in [`samples/get-concepts-by-search-term.txt`](samples/get-concepts-by-search-term.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="find-concepts-by-search-term-with-explicit-include-parameter" />Find concepts by search term with explicit include parameter - find-concepts.sh

Return concepts matching a given text search for a given terminology and use --include to
specify exactly which parts of the concept to return. The following example
performs a text search for "diabetes mellitus" in SNOMEDCT and limits search results to 5
entries and includes information about "parent" concepts.

For more information see [INCLUDE.md](../doc/INCLUDE.md "INCLUDE.md").

```bash
$ ./find-concepts.sh sandbox SNOMEDCT "system" --token $token --limit 5 --include parents
```

See sample payload data from this call in [`samples/get-concepts-by-search-term-with-include.txt`](samples/get-concepts-by-search-term-with-include.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="find-concepts-by-search-term-and-expression" />Find concepts by search term and expression - find-concepts.sh

Return concepts matching a given text search for a given terminology and only match concepts
that resolve for a given ECL expression. The following example
performs a text search for "diabetes mellitus" in SNOMEDCT for the ECL expression "<64572001" 
and limits search results to 5 entries.

For more information see [ECL.md](../doc/ECL.md "ECL.md").

```bash
$ ./find-concepts.sh sandbox SNOMEDCT "system" --expr "<64572001" --token $token --limit 5
```

See sample payload data from this call in [`samples/get-concepts-by-search-term-and-expression.txt`](samples/get-concepts-by-search-term-and-expression.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="find-terms-by-search-term" />Find terms by search term - find-terms.sh

Return terms matching a given text search for a given terminology.  
While in many instances it is most useful to directly find concepts with matching 
terms, this call allows users to isolate exactly those terms that resolve from a search.

The following example performs a text search for "diabetes" in SNOMEDCT.

```bash
$ ./find-terms.sh sandbox SNOMEDCT diabetes --token $token
```

See sample payload data from this call in [`samples/get-terms-by-search-term.txt`](samples/get-terms-by-search-term.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="support-autocompletetypeahead-for-first-few-characters-typed" />Support autocomplete/typeahead for first few characters typed - autocomplete.sh

Return autocompletions or typeaheads given a partial text string for a given terminology.
This is primarily intended to support a user interface completion feature and identify 
to potential search terms based on a few starting characters.  The following example yields 
potentially matching strings in SNOMEDCT for the string "diab".

```bash
$ ./autocomplete.sh sandbox SNOMEDCT diab --token $token
```

See sample payload data from this call in [`samples/get-autocomplete-results.txt`](samples/get-autocomplete-results.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-mapsets" />Get mapsets - find-mapsets.sh

Return all loaded mapsets currently hosted by the API (limited to 2 entries). This supports offset, limit,
sort, and ascending parameters to control amount and order of mapset information.

```bash
$ ./find-mapsets.sh  --token $token --limit 2
```

See sample payload data from this call in [`samples/get-mapsets.txt`](samples/get-mapsets.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-project-mapsets" />Get project mapsets - find-mapsets.sh

Return all mapsets for specific project identified by either project id or project uriLabel.

```bash
$ ./find-mapsets.sh --token $token --project sandbox
```

See sample payload data from this call in [`samples/get-mapsets-by-project.txt`](samples/get-mapsets-by-project.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-mapset" />Get specific mapset - find-mapsets.sh

Return a specific mapset by its mapset id.  The UUID below is an example
that may or may not work.  The idea is to take one of the mapset ids returned
by one of the previous calls and you can then look up mapset info for specifically that
UUID.

```bash
$ ./find-mapsets.sh --token $token --id 2a545e12-04eb-48ee-b988-c17346b4e05f
```

See sample payload data from this call in [`samples/get-mapsets-by-id.txt`](samples/get-mapsets-by-id.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="export-mapset" />Export mapset - export-mapsets.sh

Export a mapset for the given project id (or uriLabel) and mapset abbreviation or id.

```bash
$ ./export-mapset.sh --token $token sandbox SNOMEDCT_US-ICD10CM
```

No payload sample as the output is a .zip file.

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-concept-mappings-by-code" />Get concept mappings by code - find-mappings.sh

Return concept mappings for a given terminology and code.  This resolves
mappings that originate "from" this concept code and contains information about
the concepts those mappings point "to" on the other side.  The following example gets
mappings for the 73211009 | Diabetes mellitus | concept in SNOMEDCT.

```bash
$ ./get-concept-mappings.sh sandbox SNOMEDCT_US 73211009 --token $token
```

See sample payload data from this call in [`samples/get-concept-mappings-by-code.txt`](samples/get-concept-mappings-by-code.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="find-project-mapset-mappings" />Find project mappings - find-mappings.sh

Return mappings matching a given text search. The following example
performs a text search in the "to" concept name for "diabetes" and limits search results to 5
entries.  It searches across all mapsets in the project.

```bash
$ ./find-mappings.sh sandbox "to.name:diabetes"  --token $token --limit 5
```

See sample payload data from this call in [`samples/get-mappings-by-text.txt`](samples/get-mappings-by-text.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="find-project-mapset-mappings" />Find project mappings for mapset - find-mappings.sh

Return mappings matching a given text search for a given mapset. The following example
performs a text search in the "to" concept name for "diabetes" and limits search results to 5
entries.  It searches only within the SNOMEDCT_US-ICD10CM mapset in the specified project.

```bash
$ ./find-mappings.sh sandbox to.name:diabetes --mapset SNOMEDCT_US-ICD10CM --token $token
```

See sample payload data from this call in [`samples/get-mappings-by-mapset-and-text.txt`](samples/get-mappings-by-mapset-and-text.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="find-project-mappings" />Find project mappings - find-mappings.sh

Return mappings matching a given text search for a given mapset. The following example
performs a text search in the "to" concept name for "diabetes" and limits search results to 5
entries. It searches across all mapsets in the project.  It produces the same results as
the previous call because this is the only mapset configured in the sandbox project.

```bash
$ ./find-mappings.sh sandbox "to.name:diabetes"  --token $token --limit 5
```

See sample payload data from this call in [`samples/get-mappings-by-text2.txt`](samples/get-mappings-by-text2.txt)

[Back to Top](#termhub-in-5-minutes-bash-tutorial)
