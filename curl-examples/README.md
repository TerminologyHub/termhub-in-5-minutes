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

The following examples can be types into the command line of any terminal that has cURL and jq installed.

- [Login](#login)
- [Get terminologies](#get-terminologies)
- [Get project terminologies](#get-project-terminologies)
- [Get specific terminology](#get-terminology)
- [Export terminology](#export-terminology)
- [Get concept by code](#get-concept-by-code)
- [Get concept by code with explicit include parameter](#get-concept-by-code-with-include)
- [Get concept relationships by code](#get-concept-relationships)
- [Get concept inverse relationships by code](#get-concept-inverse-relationships)
- [Get concept tree positions](#get-treepos)
- [Find concepts by search term (use paging to get only first 5 results)](#find-concepts)
- [Find concepts by search term and expression](#find-concepts-expr)

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
```

See sample payload data from this call in [`samples/login.txt`](samples/login.txt)

<a name="get-terminologies"/>

### Get terminologies

Return all loaded terminologies currently hosted by the API.  This call also takes
search parameters like query, limit, offset, sort, and ascending to allow searching
across available terminologies.

```
curl -H "Authorization: Bearer $token" "$API_URL/terminology" | jq
```

See sample payload data from this call in [`samples/get-terminologies.txt`](samples/get-terminologies.txt)

[Back to Top](#top)

<a name="get-project-terminologies"/>

### Get project terminologies

Return all terminologies for specific project identified by either projectId or projectLabel.

```
curl -H "Authorization: Bearer $token" "$API_URL/project/sandbox/terminology" | jq
```

See sample payload data from this call in [`samples/get-terminology-snomedct.txt`](samples/get-terminology-snomedct.txt)

[Back to Top](#top)

<a name="get-terminology"/>

### Get terminology
Return a specific terminology by its terminologyId. The UUID below is an example
that may or may not work.  The idea is to take one of the terminology ids returned
by the previous call and you can then look up terminology info for specifically that
UUID.

```
curl -H "Authorization: Bearer $token" "$API_URL/terminology/e6afba85-a4d8-42d9-9712-81faebc152b8" | jq
```

See sample payload data from this call in [`samples/get-terminology-snomedct.txt`](samples/get-terminology-snomedct.txt)

[Back to Top](#top)

<a name="export-terminology"/>

### Export terminology

Export zip file of a terminology in a particular format.  Currently only format=native is
supported.

```
curl -o SNOMEDCT.zip -H "Authorization: Bearer $token" "$API_URL/project/sandbox/terminology/SNOMEDCT/export?format=native"
```

No payload sample as the output is a .zip file.

[Back to Top](#top)

<a name="get-concept-by-code"/>

### Get concept by code

Look up concept information for a given terminology and code.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/73211009" | jq
```

See sample payload data from this call in [`samples/get-concept-by-code.txt`](samples/get-concept-by-code.txt)

[Back to Top](#top)

<a name="get-concept-by-code-with-include"/>

### Get concept by code with explicit include parameter

Look up concept information for a given terminology and code and use an explicit include parameter to control how much data to send back.  The include parameter has a few helpful shortcut values
(minimal, summary, full) and also allows you to individually select parts of the full concept model
that you are interested in.  For more information see [INCLUDE.md](../doc/INCLUDE.md "INCLUDE.md").

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/73211009?include=full" | jq
```

See sample payload data from this call in [`samples/get-concept-by-code-with-include.txt`](samples/get-concept-by-code-with-include.txt)

[Back to Top](#top)

<a name="get-concept-relationships"/>

### Get concept relationships by code

Get concept relationships for a terminology and code. In this case it resolves
relationships that originate "from" this concept code and contain information about
the concepts those relationships point "to" on the other side. For example, a child
concept pointing to its parent.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/73211009/relationships" | jq
```
See sample payload data from this call in [`samples/get-concept-relationsihps.txt`](samples/get-concept-relationships.txt)

[Back to Top](#top)

<a name="get-concept-inverse-relationships"/>

### Get concept inverse relationships by code

Get concept inverse relationships for a terminology and code. In this case it resolves
relationships that point "to" this concept code and contain information about concepts
those relationships originate "from" on the other side.  For example, a parent concept
being pointed to from a child.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/113331007/inverseRelationships" | jq
```
See sample payload data from this call in [`samples/get-concept-inverse-relationsihps.txt`](samples/get-concept-inverse-relationships.txt)

[Back to Top](#top)

<a name="get-treepos"/>

### Get concept tree positions

Get concept tree positions for a terminology and code. For classification
hierarchies, you would expect to see just a single tree position.  But for
more complex poly-hierarchies you likely expect to see multiple tree positions -
each one with a different path to the root concept.

```
curl -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/73211009/trees" | jq
```

See sample payload data from this call in [`samples/get-concept-treepos.txt`](samples/get-concept-treepos.txt)

[Back to Top](#top)

<a name="find-concepts"/>

### Find concepts by search term

Find concepts matching a search term within a specified terminology. This 
example uses paging to get only the first 5 results.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept?terminology=SNOMEDCT&query=diabetes&limit=5" | jq
```

See sample payload data from this call in [`samples/find-concepts-by-search-term.txt`](samples/find-concepts-by-search-term.txt)

[Back to Top](#top)

<a name="find-concepts-expr"/>

### Find concepts by search term and expression

Find concepts matching a search term within a specified terminology and constrain
the search results by an expression. This example uses paging to get only the first 
5 results.

NOTE: the expression we are using is <<64572001 (descendants-or-self of the "Disease"
concept in SNOMED).  To work properly, the expression value has to be url encoded 
(See https://www.urlencoder.org/ for an online URL encoder):

```
curl -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept?terminology=SNOMEDCT&query=diabetes&expression=%3C%3C64572001&offset=0&limit=10" | jq
```

See sample payload data from this call in [`samples/find-concepts-by-search-term-expr.txt`](samples/find-concepts-by-search-term-expr.txt)

[Back to Top](#top)




