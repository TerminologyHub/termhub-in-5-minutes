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

### Authentication

IMPORTANT: Termhub API requires a Bearer Token authentication, which you have two ways of setting up:

1. At the end of each `./gradlew test` run, add these two parameters `-Pusername=<username> -Ppassword=<password>`, where your termhub account username replaces <username> and your termhub account password replaces <password>.
2. In `java-examples/build.gradle`, find the test section:
```
test {
    useJUnitPlatform()
    testLogging {
        events "passed", "skipped", "failed"
        showStandardStreams = true
    }
    systemProperty 'username', project.findProperty('username') ?: 'defaultUsername'
    systemProperty 'password', project.findProperty('password') ?: 'defaultPassword'
}
```
Replace 'defaultUsername` with your username, and 'defaultPassword' with your password.


Note that failure to properly set up this authentication <b>will result in all calls to the Termhub API failing with a 403 error.</b>

### Sample Java tests
-----------------

The following examples can be typed into the command line of any terminal that has cURL and jq installed. It will assume that you have set your default username and password in the build.gradle (except for the login endpoint where those are explicit parameters).

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

### Login

Login and acquire an access token for a username and password.  

```
./gradlew test --tests api.AuthApiTest.authTest
```

Return all loaded terminologies currently hosted by the API.  This call also takes
search parameters such as query, limit, offset, sort, and ascending to allow searching
across available terminologies.

```
./gradlew test --tests api.TerminologyApiTest.findTerminologiesTest
```

See sample payload data from this call in [`samples/get-terminologies.txt`](samples/get-terminologies.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Get project terminologies

Return all terminologies for the specified project identified by either projectId or projectLabel.

```
./gradlew test --tests api.TerminologyApiTest.getProjectTerminologiesTest
```

See sample payload data from this call in [`samples/get-terminologies-sandbox.txt`](samples/get-terminologies-sandbox.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Get terminology

Return a specific terminology by its terminologyId. The UUID below is an example
that may or may not work.  The idea is to take one of the terminology ids returned
by the previous call and you can then look up terminology info specifically for that
UUID.

```
./gradlew test --tests api.TerminologyApiTest.getTerminologyTest
```

See sample payload data from this call in [`samples/get-terminology-snomedct.txt`](samples/get-terminology-snomedct.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Export terminology

Export zip file of a terminology in a particular format.  Currently only format=native is
supported.

```
./gradlew test --tests api.TerminologyApiTest.exportTerminologyTest
```

No payload sample as the output is a .zip file.

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Get concept by code

Look up concept information for a given terminology and code. This call will return only the most basic information on the concept.

```
./gradlew test --tests api.ConceptByCodeApiTest.getMinimalConceptTest
```

See sample payload data from this call in [`samples/get-concept-by-code.txt`](samples/get-concept-by-code.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Get concept by code with explicit include parameter

Look up concept information for a given terminology and code and use an explicit include parameter to control how much data to send back.  The include parameter has a few helpful shortcut values
(minimal, summary, full) and also allows you to individually select parts of the full concept model
that you are interested in.  For more information see [INCLUDE.md](../doc/INCLUDE.md "INCLUDE.md").

```
./gradlew test --tests api.ConceptByCodeApiTest.getFullConceptTest
```

See sample payload data from this call in [`samples/get-concept-by-code-with-include.txt`](samples/get-concept-by-code-with-include.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Get concept relationships by code

Get concept relationships for a terminology and code. In this case it resolves
relationships that originate "from" this concept code and contains information about
the concepts those relationships point "to" on the other side. For example, a child
concept pointing to its parent.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/73211009/relationships" | jq
```

See sample payload data from this call in [`samples/get-concept-relationships.txt`](samples/get-concept-relationships.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Get concept inverse relationships by code

Get concept inverse relationships for a terminology and code. In this case it resolves
relationships that point "to" this concept code and contains information about concepts
those relationships originate "from" on the other side.  For example, a parent concept
being pointed to from a child.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/113331007/inverseRelationships" | jq
```

See sample payload data from this call in [`samples/get-concept-inverse-relationships.txt`](samples/get-concept-inverse-relationships.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Get concept trees

Get concept tree positions for a terminology and code. For classification
hierarchies, you would expect to see just a single tree position.  But for
more complex poly-hierarchies you'd likely expect to see multiple tree positions -
each one with a different path to the root concept.

```
curl -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/73211009/trees" | jq
```

See sample payload data from this call in [`samples/get-concept-treepos.txt`](samples/get-concept-treepos.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Find concepts by search term

Find concepts matching a search term within a specified terminology. This 
example uses paging to get only the first 5 results.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept?terminology=SNOMEDCT&query=diabetes&limit=5" | jq
```

See sample payload data from this call in [`samples/find-concepts-by-search-term.txt`](samples/find-concepts-by-search-term.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Find concepts by search term with explicit include parameter

This is the same as the example above but with the use of an explicit include
parameter to show that additional data can be loaded with searches.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept?terminology=SNOMEDCT&query=diabetes&limit=5&include=parents" | jq
```

See sample payload data from this call in [`samples/find-concepts-by-search-term-include.txt`](samples/find-concepts-by-search-term-include.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Find concepts by search term and expression

Find concepts matching a search term within a specified terminology and constrain
the search results by an expression. This example uses paging to get only the first 
10 results.

NOTE: the expression we are using is <<64572001 (descendants-or-self of the "Disease"
concept in SNOMED).  To work properly, the expression value has to be url encoded 
(See https://www.urlencoder.org/ for an online URL encoder):

```
curl -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept?terminology=SNOMEDCT&query=diabetes&expression=%3C%3C64572001&offset=0&limit=10" | jq
```

See sample payload data from this call in [`samples/find-concepts-by-search-term-expr.txt`](samples/find-concepts-by-search-term-expr.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Find terms by search term

Find terms matching a search term within a specified terminology. This 
example uses paging to get only the first 5 results.  While in many instances it
is most useful to directly find concepts with matching terms, this call allows
users to isolate exactly those terms that resolve from a search.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/term?terminology=SNOMEDCT&query=diabetes&limit=5" | jq
```

See sample payload data from this call in [`samples/find-terms-by-search-term.txt`](samples/find-terms-by-search-term.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Support autocomplete/typeahead for first few characters typed

To support an autocomplete or typeahead user interface feature for terminology
searching, there is an autocomplete end point that supports taking a few characters
and finding possible matches with only a few starting characters. The background
algorithm is based on edge ngrams.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/autocomplete?terminology=SNOMEDCT&query=diab&limit=10" | jq
```

See sample payload data from this call in [`samples/autocomplete-search-term.txt`](samples/autocomplete-search-term.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Get mapsets

Return all loaded mapsets currently hosted by the API.  This call also takes
search parameters such as query, limit, offset, sort, and ascending to allow searching
across available mapsets.

```
curl -H "Authorization: Bearer $token" "$API_URL/mapset" | jq
```

See sample payload data from this call in [`samples/get-mapsets.txt`](samples/get-mapsets.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Get project mapsets

Return all mapsets for the specified project identified by either projectId or projectLabel.

```
curl -H "Authorization: Bearer $token" "$API_URL/project/sandbox/mapset" | jq
```

See sample payload data from this call in [`samples/get-mapsets-sandbox.txt`](samples/get-mapsets-sandbox.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)


### Get mapset

Return a specific mapset by its id. The UUID below is an example
that may or may not work.  The idea is to take one of the mapset ids returned
by the previous call and you can then look up mapset info specifically for that
UUID.

```
curl -H "Authorization: Bearer $token" "$API_URL/mapset/2a545e12-04eb-48ee-b988-c17346b4e05f" | jq
```

See sample payload data from this call in [`samples/get-mapset-snomedct_us-icd10cm.txt`](samples/get-mapset-snomedct_us-icd10cm.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Export mapset

Export zip file of a mapset in a particular format.  Currently only format=native is
supported.

```
curl -o SNOMEDCT_US-ICD10CM.zip -H "Authorization: Bearer $token" "$API_URL/project/sandbox/mapset/SNOMEDCT_US-ICD10CM/export?format=native"
```

No payload sample as the output is a .zip file.

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Get concept mappings by code

Get concept mappings for a terminology and code. In this case it resolves
mappings that originate "from" this concept code and contains information about
the concepts those mappings point "to" on the other side.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT_US/73211009/mappings" | jq
```

See sample payload data from this call in [`samples/get-concept-mappings.txt`](samples/get-concept-mappings.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Find project mappings for mapset

Find mappings matching a query within a specified project and specified mapset. This 
example uses paging to get only the first 5 results.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/mapset/SNOMEDCT_US-ICD10CM/mappings?query=to.name:diabetes&limit=5" | jq
```

See sample payload data from this call in [`samples/find-mapset-mappings-by-query.txt`](samples/find-mapset-mappings-by-query.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)

### Find project mappings

Find mappings matching a query within a specified project across all mapsets. This 
example uses paging to get only the first 5 results.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/mapping?query=to.name:diabetes&limit=5" | jq
```

See sample payload data from this call in [`samples/find-mappings-by-query.txt`](samples/find-mappings-by-query.txt)

[Back to Top](#termhub-in-5-minutes-java-tutorial)