<a name="top" />

Termhub in 5 Minutes: Curl Tutorial
===================================================


This tutorial shows how to use raw cURL commands to access content from the TermHub Terminology API.
All the operations described here perform a GET request.

Prerequisites
-------------
* curl must be installled ([Download cURL](https://curl.haxx.se/dlwiz/))
* jq must be installed ([Download jq](https://stedolan.github.io/jq/download/))

The API URL for the TermHub is:

`export API_URL=https://api.terminologyhub.com`

Run this command before the sample curl calls below as they expect $API_URL to be set.

When using an API_URL that points to an instance (such as https://api.terminologyhub.com) that
requires authentication, the login call must first be used to obtain an access token.   


Sample cURL Calls
-----------------

The following examples can be typed into the command line of any terminal that has cURL and jq installed.

- [Login](#login)
- [Get terminologies](#get-terminologies)
- [Get project terminologies](#get-project-terminologies)
- [Get specific terminology](#get-terminology)
- [Export terminology](#export-terminology)
- [Get concept by code](#get-concept-by-code)
- [Get concept by code with explicit include parameter](#get-concept-by-code-with-include)
- [Get concept relationships by code](#get-concept-relationships)
- [Get concept inverse relationships by code](#get-concept-inverse-relationships)
- [Get concept trees](#get-treepos)
- [Find concepts by search term (use paging to get only first 5 results)](#find-concepts)
- [Find concepts by search term with explicit include parameter](#find-concepts-include)
- [Find concepts by search term and expression](#find-concepts-expr)
- [Find terms by search term](#find-terms)
- [Support autocomplete/typeahead for first few characters typed](#autocomplete)

<a name="login"/>

### Login

Login and acquire an access token for a username and password.  
Replace <username> with your username and <password> with your password.  
The commands below will set a `token` variable equal to the access token.

```
cat > /tmp/auth.txt << EOF
{ "grant_type": "username_password", "username": "<username>", "password": "<password>"}
EOF
token=`curl -X POST "$API_URL/auth/token" -d "@/tmp/auth.txt" -H "Content-type: application/json" | jq -r '.access_token'`
/bin/rm -f /tmp/auth.txt


# Bash
# Define the API URL and credentials
API_URL="your_api_url_here"
USERNAME="your_username_here"
PASSWORD="your_password_here"

cat > /tmp/auth.txt << EOF
{ "grant_type": "username_password", "username": "$USERNAME", "password": "$PASSWORD" }
EOF

token=$(curl -X POST "$API_URL/auth/token" -d "@/tmp/auth.txt" -H "Content-type: application/json" | jq -r '.access_token')

/bin/rm -f /tmp/auth.txt

echo "token=$token"
```

See sample payload data from this call in [`samples/login.txt`](samples/login.txt)

<a name="get-terminologies"/>

### Get all terminologies in TermHub
Via $API_URL/terminology

Return all loaded terminologies currently hosted by the API.  This call also takes
search parameters such as query, limit, offset, sort, and ascending to allow searching
across available terminologies.

```
curl -H "Authorization: Bearer $token" "$API_URL/terminology" | jq | head -20
```

See sample payload data from this call in [`samples/get-terminologies.txt`](samples/get-terminologies.txt)

[Back to Top](#top)

<a name="get-project-terminologies"/>

### Get all terminologies (for project)
Via $API_URL/project/sandbox/terminology

Return all terminologies for the specified project identified by either projectId or projectLabel.

```
curl -H "Authorization: Bearer $token" "$API_URL/project/sandbox/terminology" | jq
```

See sample payload data from this call in [`samples/get-terminologies-sandbox.txt`](samples/get-terminologies-sandbox.txt)

[Back to Top](#top)

<a name="get-terminology"/>

### Get terminology (for terminology id)
Via $API_URL/terminology/<terminologyId>

Return a specific terminology by its terminologyId. The UUID below is an example
that may or may not work.  The idea is to take one of the terminology ids returned
by one of the previous calls and you can then look up terminology info for specifically that
UUID.

```
curl -H "Authorization: Bearer $token" "$API_URL/terminology/a2bc43ec-ba1b-47c0-9ff0-8379a02f8136" | jq
```

See sample payload data from this call in [`samples/get-terminology-snomedct.txt`](samples/get-terminology-snomedct.txt)

[Back to Top](#top)

<a name="export-terminology"/>

### Export a terminology
Via $API_URL/project/sandbox/terminology/<terminology>/export

Export zip file of a terminology in a particular format.  Currently only format=native is
supported.

```
curl -o SNOMEDCT-CURL.zip -H "Authorization: Bearer $token" "$API_URL/project/sandbox/terminology/SNOMEDCT/export?format=native"
```

No payload sample as the output is a .zip file.

[Back to Top](#top)

<a name="get-concept-by-code"/>

### Get concept summary (for concept id)
Via $API_URL/project/sandbox/concept/<terminology>/<conceptId>

Return summary concept information for a given terminology and code. The following example gets the 73211009 | Diabetes mellitus | concept in SNOMEDCT. For more information see
[INCLUDE.md](../doc/INCLUDE.md "INCLUDE.md").

Look up concept information for a given terminology and code.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/73211009" | jq
```

See sample payload data from this call in [`samples/get-concept-by-code.txt`](samples/get-concept-by-code.txt)

[Back to Top](#top)

<a name="get-concept-by-code-with-include"/>

### Get full concept information (for concept id)
Via $API_URL/project/sandbox/concept/<terminology>/<conceptId>?include=full

Look up concept information for a given terminology and code and use an explicit include parameter to control how much data to send back.  The include parameter has a few helpful shortcut values
(minimal, summary, full) and also allows you to individually select parts of the full concept model
that you are interested in.  For more information see [INCLUDE.md](../doc/INCLUDE.md "INCLUDE.md").

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/73211009?include=full" | jq
```

See sample payload data from this call in [`samples/get-concept-by-code-with-include.txt`](samples/get-concept-by-code-with-include.txt)

[Back to Top](#top)

<a name="get-concept-relationships"/>

### Get concept relationship information (for concept id)
Via $API_URL/project/sandbox/concept/<terminology>/<conceptId>/relationships

Get concept relationships for a terminology and code. In this case it resolves
relationships that originate "from" this concept code and contains information about
the concepts those relationships point "to" on the other side. For example, a child
concept pointing to its parent.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/73211009/relationships" | jq
```

See sample payload data from this call in [`samples/get-concept-relationsihps.txt`](samples/get-concept-relationships.txt)

[Back to Top](#top)

<a name="get-concept-inverse-relationships"/>

### Get inverse concept relationship information (for concept id)
Via $API_URL/project/sandbox/concept/<terminology>/<conceptId>/inverseRelationships

This same script can be used to get inverse concept relationships for a terminology
and code. In this case it resolves relationships that originate "from" another
concept and point "to" this concept code. For this mode, use the `--inverse` parameter.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/113331007/inverseRelationships" | jq
```

See sample payload data from this call in [`samples/get-concept-inverse-relationsihps.txt`](samples/get-concept-inverse-relationships.txt)

[Back to Top](#top)

<a name="get-treepos"/>

### Get concept tree positions (for concept id)
Via $API_URL/project/sandbox/concept/<terminology>/<conceptId>/trees

Get concept tree positions for a terminology and code. For classification hierarchies, you would expect to see just a single tree position. But for more complex poly-hierarchies you'd likely expect to see multiple tree positions - each one with a different path to the root concept.

Get concept tree positions for a terminology and code. For classification
hierarchies, you would expect to see just a single tree position.  But for
more complex poly-hierarchies you'd likely expect to see multiple tree positions -
each one with a different path to the root concept.

```
curl -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/73211009/trees" | jq
```

See sample payload data from this call in [`samples/get-concept-treepos.txt`](samples/get-concept-treepos.txt)

[Back to Top](#top)

<a name="find-concepts"/>

### Get concept summaries (search by string)
Via $API_URL/project/sandbox/concept?terminology=<terminology>&query=<string>

Used to perform text searches to find matching concepts. The following example
performs a text search for "diabetes mellitus" and limits search results to 5
entries.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept?terminology=SNOMEDCT&query=diabetes%20mellitus&limit=5" | jq
```

See sample payload data from this call in [`samples/find-concepts-by-search-term.txt`](samples/find-concepts-by-search-term.txt)

[Back to Top](#top)

<a name="find-concepts"/>

### Get full concept information (search by string)
Via $API_URL/project/sandbox/concept?terminology=<terminology>&query=<string>&include=full

This is the same as the example above but with the use of an explicit include
parameter to show that additional data can be loaded with searches. The include parameter 
has a few helpful shortcut values (minimal, summary, full) and also allows you to individually 
select parts of the full concept model that you are interested in. For more information see
[INCLUDE.md](../doc/INCLUDE.md "INCLUDE.md").

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept?terminology=SNOMEDCT&query=diabetes%20mellitus&limit=2&include=full" | jq
```

See sample payload data from this call in [`samples/find-concepts-by-search-term-include.txt`](samples/find-concepts-by-search-term-include.txt)

[Back to Top](#top)

<a name="find-concepts-expr"/>

### Get concept summaries including parents (search by string and ECL expression)
Via $API_URL/project/sandbox/concept?terminology=<terminology>&query=<string>&expression=<ecl>&include=full

This example performs a search that returns the full concept information for those concepts returned from the specified ecl express contain the word "system" with a maximum of 5 results.

NOTE: the expression we are using is <<64572001 (descendants-or-self of the "Disease"
concept in SNOMED).  To work properly, the expression value has to be url encoded 
(See https://www.urlencoder.org/ for an online URL encoder):

```
curl -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept?terminology=SNOMEDCT&query=system&expression=%3C64572001&offset=0&limit=5&include=parents" | jq
```

See sample payload data from this call in [`samples/find-concepts-by-search-term-expr.txt`](samples/find-concepts-by-search-term-expr.txt)

[Back to Top](#top)

<a name="find-terms"/>


### Get concept summaries (search by ECL expression)
Via $API_URL/project/sandbox/concept?terminology=<terminology>&query="*"&expression=<ecl>

Used to perform text searches to find terms matching a particular terminology.  
While in many instances it is most useful to directly find concepts with matching 
terms, this call allows users to isolate exactly those terms that resolve from a search.


```
curl -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept?terminology=SNOMEDCT&query=*&expression=%3C64572001&offset=0&limit=5" | jq
```

See sample payload data from this call in [`samples/find-terms-by-search-term.txt`](samples/find-terms-by-search-term.txt)

[Back to Top](#top)

<a name="autocomplete"/>

### Demonstrate capabilities autocomplete, aka type-ahead
Via $API_URL/project/sandbox/autocomplete?terminology=<terminology>&query=<string>

This script demonstrates an autocomplete or typeahead for a user interface feature 
to find potential search terms for a few starting characters.  By default it produces
10 results.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/autocomplete?terminology=SNOMEDCT&query=diab" | jq
```

See sample payload data from this call in [`samples/autocomplete-search-term.txt`](samples/autocomplete-search-term.txt)

[Back to Top](#top)


