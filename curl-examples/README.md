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

<a name="get-terminologies"/>

### Get all terminologies in TermHub
Via $API_URL/terminology

Return all loaded terminologies currently hosted by the API.  This call also takes
search parameters such as query, limit, offset, sort, and ascending to allow searching
across available terminologies.

```
$ curl -H "Authorization: Bearer $token" "$API_URL/terminology" | jq | head -20
{
  "total": 64,
  "parameters": {
    "query": "loaded:true",
    "limit": 10,
    "offset": 0
  },
  "items": [
    {
      "id": "fda9bef2-df80-40d6-b31b-6cb3a1cd38c3",
      "confidence": 0.006968668662011623,
      "modified": "2024-05-11T20:13:11.499+00:00",
      "created": "2024-05-11T20:13:11.499+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "abbreviation": "SNOMEDCT_US",
      "name": "Systematized Nomenclature of Medicine–Clinical Terminology, US Edition",
      "version": "20230301",
      "publisher": "NLM",

```

[Back to Top](#top)

<a name="get-project-terminologies"/>

### Get all terminologies (for project)
Via $API_URL/project/sandbox/terminology

Return all terminologies for the specified project identified by either projectId or projectLabel.

```
$ curl -H "Authorization: Bearer $token" "$API_URL/project/sandbox/terminology" | jq
[
  {
    "id": "a2bc43ec-ba1b-47c0-9ff0-8379a02f8136",
    "confidence": 6.273220062255859,
    "modified": "2024-05-13T18:27:49.865+00:00",
    "created": "2024-05-13T18:27:49.865+00:00",
    "modifiedBy": "loader",
    "local": false,
    "active": true,
    "abbreviation": "SNOMEDCT",
    "name": "Mini version of SNOMEDCT For testing purposes",
    "version": "20240101",
    "publisher": "SANDBOX",
    "latest": true,
    "loaded": true,
    "releaseDate": "2024-01-01",
    "family": "SNOMEDCT",
    "indexName": "snomedct-sandbox-20240101",
    "attributes": {
      "autocomplete": "true",
      "description-logic-based": "true",
      "tree-positions": "true",
      "unidirectional-rels": "true",
      "has-relationship-directionality": "true",
      "ecl": "true",
      "description-logic-profile": "EL++",
      "fhirUri": "http://snomed.info/sct",
      "polyhierarchy": "true",
      "hierarchical": "true",
      "fhirVersion": "http://snomed.info/sct/900000000000207008/version/20240101",
      "fhirId": "snomedct_900000000000207008_20240101"
    },
    "roots": [
      "138875005"
    ],
    "statistics": {
      "parentsInactive": 0,
      "parentsActive": 592,
      "treePositions": 2152,
      "termsInactive": 353,
      "childrenInactive": 0,
      "relationships": 743,
      "concepts": 434,
      "terms": 1534,
      "conceptsInactive": 3,
      "termsActive": 1181,
      "definitions": 19,
      "conceptsActive": 431,
      "childrenActive": 592
    }
  },
  {
    "id": "34c23127-6acc-48ba-8b1e-cba378feb7cc",
    "confidence": 7.456092834472656,
    "modified": "2024-05-13T18:28:54.409+00:00",
    "created": "2024-05-13T18:28:54.409+00:00",
    "modifiedBy": "loader",
    "local": false,
    "active": true,
    "abbreviation": "SNOMEDCT_US",
    "name": "Mini version of SNOMEDCT_US For testing purposes",
    "version": "20240301",
    "publisher": "SANDBOX",
    "latest": true,
    "loaded": true,
    "releaseDate": "2024-03-01",
    "family": "SNOMEDCT",
    "indexName": "snomedctus-sandbox-20240301",
    "attributes": {
      "autocomplete": "true",
      "description-logic-based": "true",
      "tree-positions": "true",
      "unidirectional-rels": "true",
      "has-relationship-directionality": "true",
      "ecl": "true",
      "description-logic-profile": "EL++",
      "fhirUri": "http://snomed.info/sct",
      "polyhierarchy": "true",
      "hierarchical": "true",
      "fhirVersion": "http://snomed.info/sct/731000124108/version/20240301",
      "fhirId": "snomedct_us_731000124108_20240301"
    },
    "roots": [
      "138875005"
    ],
    "statistics": {
      "parentsInactive": 0,
      "parentsActive": 598,
      "treePositions": 2158,
      "termsInactive": 355,
      "childrenInactive": 0,
      "relationships": 749,
      "concepts": 440,
      "terms": 1549,
      "conceptsInactive": 3,
      "termsActive": 1194,
      "definitions": 19,
      "conceptsActive": 437,
      "childrenActive": 598
    }
  },
  {
    "id": "b9c18dcd-8e75-44c4-ba27-d1aa1737e38b",
    "confidence": 7.312992095947266,
    "modified": "2024-05-13T18:29:48.953+00:00",
    "created": "2024-05-13T18:29:48.953+00:00",
    "modifiedBy": "loader",
    "local": false,
    "active": true,
    "abbreviation": "RXNORM",
    "name": "Mini version of RXNORM for testing purposes",
    "version": "04012024",
    "publisher": "SANDBOX",
    "latest": true,
    "loaded": true,
    "releaseDate": "2024-04-01",
    "family": "RXNORM",
    "indexName": "rxnorm-sandbox-04012024",
    "attributes": {
      "fhirUri": "http://www.nlm.nih.gov/research/umls/rxnorm",
      "autocomplete": "true",
      "fhirVersion": "04012024",
      "ecl": "true",
      "fhirId": "rxnorm_04012024",
      "fhirCompositional": "false"
    },
    "statistics": {
      "parentsInactive": 0,
      "parentsActive": 0,
      "treePositions": 0,
      "termsInactive": 403,
      "childrenInactive": 0,
      "relationships": 7428,
      "concepts": 816,
      "terms": 1975,
      "conceptsInactive": 198,
      "termsActive": 1572,
      "definitions": 0,
      "conceptsActive": 618,
      "childrenActive": 0
    }
  },
  {
    "id": "d1aba666-39bf-48ea-b524-c5a47ab1dcf1",
    "confidence": 6.634233474731445,
    "modified": "2024-05-13T18:30:45.195+00:00",
    "created": "2024-05-13T18:30:45.195+00:00",
    "modifiedBy": "loader",
    "local": false,
    "active": true,
    "abbreviation": "LNC",
    "name": "Mini version of LOINC for testing purposes",
    "version": "277",
    "publisher": "SANDBOX",
    "latest": true,
    "loaded": true,
    "releaseDate": "2024-05-06",
    "family": "LOINC",
    "indexName": "lnc-sandbox-277",
    "attributes": {
      "fhirUri": "http://loinc.org",
      "origin-version": "2024AA",
      "polyhierarchy": "true",
      "autocomplete": "true",
      "hierarchical": "true",
      "fhirVersion": "277",
      "tree-positions": "true",
      "origin-terminology": "UMLS",
      "ecl": "true",
      "fhirId": "lnc_277",
      "fhirCompositional": "false"
    },
    "roots": [
      "MTHU000998",
      "MTHU000999"
    ],
    "statistics": {
      "termsInactive": 0,
      "childrenInactive": 0,
      "relationships": 326,
      "concepts": 114,
      "terms": 226,
      "parentsInactive": 0,
      "termsActive": 226,
      "parentsActive": 90,
      "definitions": 0,
      "treePositions": 93,
      "conceptsActive": 114,
      "childrenActive": 90
    }
  },
  {
    "id": "7ba6a4e7-8d3d-4242-a174-f9883d48a08b",
    "confidence": 7.004107475280762,
    "modified": "2024-05-13T18:30:55.473+00:00",
    "created": "2024-05-13T18:30:55.473+00:00",
    "modifiedBy": "loader",
    "local": false,
    "active": true,
    "abbreviation": "ICD10CM",
    "name": "Mini version of ICD10CM for testing purposes",
    "version": "2024",
    "publisher": "SANDBOX",
    "latest": true,
    "loaded": true,
    "releaseDate": "2024-05-06",
    "family": "ICD10CM",
    "indexName": "icd10cm-sandbox-2024",
    "attributes": {
      "fhirUri": "http://hl7.org/fhir/sid/icd-10-cm",
      "origin-version": "2024AA",
      "autocomplete": "true",
      "hierarchical": "true",
      "fhirVersion": "2024",
      "tree-positions": "true",
      "origin-terminology": "UMLS",
      "ecl": "true",
      "fhirId": "icd10cm_2024",
      "fhirCompositional": "false"
    },
    "roots": [
      "ICD-10-CM"
    ],
    "statistics": {
      "termsInactive": 0,
      "childrenInactive": 0,
      "relationships": 12,
      "concepts": 7,
      "terms": 12,
      "parentsInactive": 0,
      "termsActive": 12,
      "parentsActive": 6,
      "definitions": 0,
      "treePositions": 7,
      "conceptsActive": 7,
      "childrenActive": 6
    }
  }
]
```

[Back to Top](#top)

<a name="get-terminology"/>

### Get terminology (for terminology id)
Via $API_URL/terminology/<terminologyId>

Return a specific terminology by its terminologyId. The UUID below is an example
that may or may not work.  The idea is to take one of the terminology ids returned
by one of the previous calls and you can then look up terminology info for specifically that
UUID.

```
$ curl -H "Authorization: Bearer $token" "$API_URL/terminology/a2bc43ec-ba1b-47c0-9ff0-8379a02f8136" | jq
{
  "id": "a2bc43ec-ba1b-47c0-9ff0-8379a02f8136",
  "confidence": 6.93645715713501,
  "modified": "2024-05-13T18:27:49.865+00:00",
  "created": "2024-05-13T18:27:49.865+00:00",
  "modifiedBy": "loader",
  "local": false,
  "active": true,
  "abbreviation": "SNOMEDCT",
  "name": "Mini version of SNOMEDCT For testing purposes",
  "version": "20240101",
  "publisher": "SANDBOX",
  "latest": true,
  "loaded": true,
  "releaseDate": "2024-01-01",
  "family": "SNOMEDCT",
  "attributes": {
    "autocomplete": "true",
    "description-logic-based": "true",
    "tree-positions": "true",
    "unidirectional-rels": "true",
    "has-relationship-directionality": "true",
    "ecl": "true",
    "description-logic-profile": "EL++",
    "fhirUri": "http://snomed.info/sct",
    "polyhierarchy": "true",
    "hierarchical": "true",
    "fhirVersion": "http://snomed.info/sct/900000000000207008/version/20240101",
    "fhirId": "snomedct_900000000000207008_20240101"
  },
  "roots": [
    "138875005"
  ],
  "statistics": {
    "parentsInactive": 0,
    "parentsActive": 592,
    "treePositions": 2152,
    "termsInactive": 353,
    "childrenInactive": 0,
    "relationships": 743,
    "concepts": 434,
    "terms": 1534,
    "conceptsInactive": 3,
    "termsActive": 1181,
    "definitions": 19,
    "conceptsActive": 431,
    "childrenActive": 592
  }
}
```

[Back to Top](#top)

<a name="export-terminology"/>

### Export a terminology
Via $API_URL/project/sandbox/terminology/<terminology>/export

Export zip file of a terminology in a particular format.  Currently only format=native is
supported.

```
$ curl -o SNOMEDCT-CURL.zip -H "Authorization: Bearer $token" "$API_URL/project/sandbox/terminology/SNOMEDCT/export?format=native"

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
$ curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/73211009" | jq
{
  "id": "1ff90ce3-66c1-444e-ab67-e34ac53fc2c0",
  "confidence": 5.673330783843994,
  "modified": "2002-01-31T00:00:00.000+00:00",
  "created": "2002-01-31T00:00:00.000+00:00",
  "modifiedBy": "loader",
  "local": false,
  "active": true,
  "name": "Diabetes mellitus",
  "code": "73211009",
  "terminology": "SNOMEDCT",
  "version": "20240101",
  "publisher": "SANDBOX",
  "leaf": true,
  "defined": false,
  "terms": [
    {
      "id": "a4ca02f7-96d5-4984-82ab-c50932dc5c78",
      "modified": "2017-07-31T00:00:00.000+00:00",
      "created": "2017-07-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Diabetes mellitus",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "121589010",
      "code": "73211009",
      "conceptId": "73211009",
      "localeMap": {
        "en_GB": true,
        "en": true
      },
      "type": "900000000000013009",
      "attributes": {
        "caseSignificanceId": "900000000000448009",
        "moduleId": "900000000000207008"
      }
    },
    {
      "id": "62da178f-4bb7-4a13-aa2d-e243798f8025",
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": false,
      "name": "Diabetes mellitus, NOS",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "121590018",
      "code": "73211009",
      "conceptId": "73211009",
      "localeMap": {
        "en": false
      },
      "type": "900000000000013009",
      "attributes": {
        "caseSignificanceId": "900000000000020002",
        "moduleId": "900000000000207008"
      }
    },
    {
      "id": "d62b0b75-5588-467f-a794-1f6c0a5cfc6a",
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "DM - Diabetes mellitus",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "502372015",
      "code": "73211009",
      "conceptId": "73211009",
      "localeMap": {
        "en_GB": false,
        "en": false
      },
      "type": "900000000000013009",
      "attributes": {
        "caseSignificanceId": "900000000000017005",
        "moduleId": "900000000000207008"
      }
    },
    {
      "id": "c0b184ba-bb0c-4fe7-ad9c-b1b4801543f7",
      "modified": "2017-07-31T00:00:00.000+00:00",
      "created": "2017-07-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Diabetes mellitus (disorder)",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "813575016",
      "code": "73211009",
      "conceptId": "73211009",
      "localeMap": {
        "en_GB": true,
        "en": true
      },
      "type": "900000000000003001",
      "attributes": {
        "caseSignificanceId": "900000000000448009",
        "moduleId": "900000000000207008"
      }
    }
  ],
  "attributes": {
    "definitionStatusId": "900000000000074008",
    "moduleId": "900000000000207008"
  },
  "semanticTypes": [
    "disorder"
  ]
}

```

[Back to Top](#top)

<a name="get-concept-by-code-with-include"/>

### Get full concept information (for concept id)
Via $API_URL/project/sandbox/concept/<terminology>/<conceptId>?include=full

Look up concept information for a given terminology and code and use an explicit include parameter to control how much data to send back.  The include parameter has a few helpful shortcut values
(minimal, summary, full) and also allows you to individually select parts of the full concept model
that you are interested in.  For more information see [INCLUDE.md](../doc/INCLUDE.md "INCLUDE.md").

```
$ curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/73211009?include=full" | jq
{
  "id": "1ff90ce3-66c1-444e-ab67-e34ac53fc2c0",
  "confidence": 5.673330783843994,
  "modified": "2002-01-31T00:00:00.000+00:00",
  "created": "2002-01-31T00:00:00.000+00:00",
  "modifiedBy": "loader",
  "local": false,
  "active": true,
  "name": "Diabetes mellitus",
  "code": "73211009",
  "terminology": "SNOMEDCT",
  "version": "20240101",
  "publisher": "SANDBOX",
  "leaf": true,
  "defined": false,
  "terms": [
    {
      "id": "a4ca02f7-96d5-4984-82ab-c50932dc5c78",
      "modified": "2017-07-31T00:00:00.000+00:00",
      "created": "2017-07-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Diabetes mellitus",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "121589010",
      "code": "73211009",
      "conceptId": "73211009",
      "localeMap": {
        "en_GB": true,
        "en": true
      },
      "type": "900000000000013009",
      "attributes": {
        "caseSignificanceId": "900000000000448009",
        "moduleId": "900000000000207008"
      }
    },
    {
      "id": "62da178f-4bb7-4a13-aa2d-e243798f8025",
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": false,
      "name": "Diabetes mellitus, NOS",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "121590018",
      "code": "73211009",
      "conceptId": "73211009",
      "localeMap": {
        "en": false
      },
      "type": "900000000000013009",
      "attributes": {
        "caseSignificanceId": "900000000000020002",
        "moduleId": "900000000000207008"
      }
    },
    {
      "id": "d62b0b75-5588-467f-a794-1f6c0a5cfc6a",
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "DM - Diabetes mellitus",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "502372015",
      "code": "73211009",
      "conceptId": "73211009",
      "localeMap": {
        "en_GB": false,
        "en": false
      },
      "type": "900000000000013009",
      "attributes": {
        "caseSignificanceId": "900000000000017005",
        "moduleId": "900000000000207008"
      }
    },
    {
      "id": "c0b184ba-bb0c-4fe7-ad9c-b1b4801543f7",
      "modified": "2017-07-31T00:00:00.000+00:00",
      "created": "2017-07-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Diabetes mellitus (disorder)",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "813575016",
      "code": "73211009",
      "conceptId": "73211009",
      "localeMap": {
        "en_GB": true,
        "en": true
      },
      "type": "900000000000003001",
      "attributes": {
        "caseSignificanceId": "900000000000448009",
        "moduleId": "900000000000207008"
      }
    }
  ],
  "attributes": {
    "definitionStatusId": "900000000000074008",
    "moduleId": "900000000000207008"
  },
  "semanticTypes": [
    "disorder"
  ],
  "parents": [
    {
      "local": false,
      "active": true,
      "name": "Disorder of endocrine system",
      "code": "362969004",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": false,
      "defined": true
    },
    {
      "local": false,
      "active": true,
      "name": "Disorder of glucose metabolism",
      "code": "126877002",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": false,
      "defined": false
    }
  ],
  "relationships": [
    {
      "id": "eb340aa3-a5c8-4656-9ff4-767b4e2a1a55",
      "confidence": 5.359277725219727,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "267149027",
      "type": "Is a",
      "additionalType": "116680003",
      "from": {
        "local": false,
        "active": false,
        "name": "Diabetes mellitus",
        "code": "73211009",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": true,
        "defined": false
      },
      "to": {
        "local": false,
        "active": false,
        "name": "Disorder of glucose metabolism",
        "code": "126877002",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": false,
        "defined": false
      },
      "hierarchical": true,
      "asserted": true,
      "defining": true,
      "group": "0",
      "attributes": {
        "modifierId": "900000000000451002",
        "characteristicTypeId": "900000000000011006",
        "moduleId": "900000000000207008"
      }
    },
    {
      "id": "9b8d43b5-01c8-416c-9d18-3e71130cf472",
      "confidence": 5.359277725219727,
      "modified": "2012-01-31T00:00:00.000+00:00",
      "created": "2012-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "4601709020",
      "type": "Is a",
      "additionalType": "116680003",
      "from": {
        "local": false,
        "active": false,
        "name": "Diabetes mellitus",
        "code": "73211009",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": true,
        "defined": false
      },
      "to": {
        "local": false,
        "active": false,
        "name": "Disorder of endocrine system",
        "code": "362969004",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": false,
        "defined": true
      },
      "hierarchical": true,
      "asserted": true,
      "defining": true,
      "group": "0",
      "attributes": {
        "modifierId": "900000000000451002",
        "characteristicTypeId": "900000000000011006",
        "moduleId": "900000000000207008"
      }
    },
    {
      "id": "3b332709-c111-46bb-8922-661677a3001d",
      "confidence": 5.359277725219727,
      "modified": "2019-07-31T00:00:00.000+00:00",
      "created": "2019-07-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "4601710026",
      "type": "other",
      "additionalType": "363698007",
      "from": {
        "local": false,
        "active": false,
        "name": "Diabetes mellitus",
        "code": "73211009",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": true,
        "defined": false
      },
      "to": {
        "local": false,
        "active": false,
        "name": "Structure of endocrine system",
        "code": "113331007",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": false,
        "defined": false
      },
      "hierarchical": false,
      "asserted": true,
      "defining": true,
      "group": "1",
      "attributes": {
        "modifierId": "900000000000451002",
        "characteristicTypeId": "900000000000011006",
        "moduleId": "900000000000207008"
      }
    }
  ]
}
```

[Back to Top](#top)

<a name="get-concept-relationships"/>

### Get concept relationship information (for concept id)
Via $API_URL/project/sandbox/concept/<terminology>/<conceptId>/relationships

Get concept relationships for a terminology and code. In this case it resolves
relationships that originate "from" this concept code and contains information about
the concepts those relationships point "to" on the other side. For example, a child
concept pointing to its parent.

```
$ curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/73211009/relationships" | jq
{
  "total": 3,
  "parameters": {
    "query": "terminology:SNOMEDCT AND from.code:73211009 AND *",
    "limit": 10,
    "offset": 0
  },
  "items": [
    {
      "id": "eb340aa3-a5c8-4656-9ff4-767b4e2a1a55",
      "confidence": 6.359950065612793,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "267149027",
      "type": "Is a",
      "additionalType": "116680003",
      "from": {
        "local": false,
        "active": false,
        "name": "Diabetes mellitus",
        "code": "73211009",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": true,
        "defined": false
      },
      "to": {
        "local": false,
        "active": false,
        "name": "Disorder of glucose metabolism",
        "code": "126877002",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": false,
        "defined": false
      },
      "hierarchical": true,
      "asserted": true,
      "defining": true,
      "group": "0",
      "attributes": {
        "modifierId": "900000000000451002",
        "characteristicTypeId": "900000000000011006",
        "moduleId": "900000000000207008"
      }
    },
    {
      "id": "9b8d43b5-01c8-416c-9d18-3e71130cf472",
      "confidence": 6.359950065612793,
      "modified": "2012-01-31T00:00:00.000+00:00",
      "created": "2012-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "4601709020",
      "type": "Is a",
      "additionalType": "116680003",
      "from": {
        "local": false,
        "active": false,
        "name": "Diabetes mellitus",
        "code": "73211009",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": true,
        "defined": false
      },
      "to": {
        "local": false,
        "active": false,
        "name": "Disorder of endocrine system",
        "code": "362969004",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": false,
        "defined": true
      },
      "hierarchical": true,
      "asserted": true,
      "defining": true,
      "group": "0",
      "attributes": {
        "modifierId": "900000000000451002",
        "characteristicTypeId": "900000000000011006",
        "moduleId": "900000000000207008"
      }
    },
    {
      "id": "3b332709-c111-46bb-8922-661677a3001d",
      "confidence": 6.359950065612793,
      "modified": "2019-07-31T00:00:00.000+00:00",
      "created": "2019-07-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "4601710026",
      "type": "other",
      "additionalType": "363698007",
      "from": {
        "local": false,
        "active": false,
        "name": "Diabetes mellitus",
        "code": "73211009",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": true,
        "defined": false
      },
      "to": {
        "local": false,
        "active": false,
        "name": "Structure of endocrine system",
        "code": "113331007",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": false,
        "defined": false
      },
      "hierarchical": false,
      "asserted": true,
      "defining": true,
      "group": "1",
      "attributes": {
        "modifierId": "900000000000451002",
        "characteristicTypeId": "900000000000011006",
        "moduleId": "900000000000207008"
      }
    }
  ]
}
```

[Back to Top](#top)

<a name="get-concept-inverse-relationships"/>

### Get inverse concept relationship information (for concept id)
Via $API_URL/project/sandbox/concept/<terminology>/<conceptId>/inverseRelationships

This same script can be used to get inverse concept relationships for a terminology
and code. In this case it resolves relationships that originate "from" another
concept and point "to" this concept code. For this mode, use the `--inverse` parameter.

```
$ curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/113331007/inverseRelationships" | jq
{
  "total": 3,
  "parameters": {
    "query": "terminology:SNOMEDCT AND to.code:113331007 AND *",
    "limit": 10,
    "offset": 0
  },
  "items": [
    {
      "id": "da1cffea-38f7-4288-9753-6f6e4c1758d1",
      "confidence": 6.359950065612793,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "97229020",
      "type": "Is a",
      "additionalType": "116680003",
      "from": {
        "local": false,
        "active": false,
        "name": "Entire endocrine system",
        "code": "278876000",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": true,
        "defined": false
      },
      "to": {
        "local": false,
        "active": false,
        "name": "Structure of endocrine system",
        "code": "113331007",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": false,
        "defined": false
      },
      "hierarchical": true,
      "asserted": true,
      "defining": true,
      "group": "0",
      "attributes": {
        "modifierId": "900000000000451002",
        "characteristicTypeId": "900000000000011006",
        "moduleId": "900000000000207008"
      }
    },
    {
      "id": "5b96de01-bbe3-4f04-8697-58d7abfb8757",
      "confidence": 6.359950065612793,
      "modified": "2019-07-31T00:00:00.000+00:00",
      "created": "2019-07-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "933154024",
      "type": "other",
      "additionalType": "363698007",
      "from": {
        "local": false,
        "active": false,
        "name": "Disorder of endocrine system",
        "code": "362969004",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": false,
        "defined": true
      },
      "to": {
        "local": false,
        "active": false,
        "name": "Structure of endocrine system",
        "code": "113331007",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": false,
        "defined": false
      },
      "hierarchical": false,
      "asserted": true,
      "defining": true,
      "group": "1",
      "attributes": {
        "modifierId": "900000000000451002",
        "characteristicTypeId": "900000000000011006",
        "moduleId": "900000000000207008"
      }
    },
    {
      "id": "3b332709-c111-46bb-8922-661677a3001d",
      "confidence": 6.359950065612793,
      "modified": "2019-07-31T00:00:00.000+00:00",
      "created": "2019-07-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "componentId": "4601710026",
      "type": "other",
      "additionalType": "363698007",
      "from": {
        "local": false,
        "active": false,
        "name": "Diabetes mellitus",
        "code": "73211009",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": true,
        "defined": false
      },
      "to": {
        "local": false,
        "active": false,
        "name": "Structure of endocrine system",
        "code": "113331007",
        "terminology": "SNOMEDCT",
        "version": "20240101",
        "publisher": "SANDBOX",
        "leaf": false,
        "defined": false
      },
      "hierarchical": false,
      "asserted": true,
      "defining": true,
      "group": "1",
      "attributes": {
        "modifierId": "900000000000451002",
        "characteristicTypeId": "900000000000011006",
        "moduleId": "900000000000207008"
      }
    }
  ]
}
```

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
$ curl -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept/SNOMEDCT/73211009/trees" | jq
{
  "total": 2,
  "parameters": {
    "query": "terminology:SNOMEDCT AND concept.code:73211009 AND *",
    "limit": 10,
    "offset": 0
  },
  "items": [
    {
      "id": "d04ada33-189c-49bd-a50d-b0c854255468",
      "confidence": 14.539000511169434,
      "modified": "2024-05-13T18:27:51.309+00:00",
      "created": "2024-05-13T18:27:51.309+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "concept": {
        "local": false,
        "active": true,
        "name": "SNOMED CT Concept",
        "code": "138875005",
        "terminology": "SNOMEDCT",
        "publisher": "SANDBOX",
        "leaf": false
      },
      "childCt": 7,
      "children": [
        {
          "id": "3ece9cda-d26e-4718-a53d-94cc1eee4aa2",
          "confidence": 12.92956256866455,
          "modified": "2024-05-13T18:27:51.374+00:00",
          "created": "2024-05-13T18:27:51.374+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "concept": {
            "local": false,
            "active": true,
            "name": "Clinical finding",
            "code": "404684003",
            "terminology": "SNOMEDCT",
            "publisher": "SANDBOX",
            "leaf": false
          },
          "ancestorPath": "138875005",
          "childCt": 8,
          "children": [
            {
              "id": "c141ae1e-7846-4dab-9769-83d6473c5916",
              "confidence": 12.804399490356445,
              "modified": "2024-05-13T18:27:51.405+00:00",
              "created": "2024-05-13T18:27:51.405+00:00",
              "modifiedBy": "loader",
              "local": false,
              "active": true,
              "terminology": "SNOMEDCT",
              "version": "20240101",
              "publisher": "SANDBOX",
              "concept": {
                "local": false,
                "active": true,
                "name": "Disease",
                "code": "64572001",
                "terminology": "SNOMEDCT",
                "publisher": "SANDBOX",
                "leaf": false
              },
              "ancestorPath": "138875005~404684003",
              "childCt": 5,
              "children": [
                {
                  "id": "8fa4aab3-fb19-482d-b601-dd7347e757f6",
                  "confidence": 13.239718437194824,
                  "modified": "2024-05-13T18:27:51.426+00:00",
                  "created": "2024-05-13T18:27:51.426+00:00",
                  "modifiedBy": "loader",
                  "local": false,
                  "active": true,
                  "terminology": "SNOMEDCT",
                  "version": "20240101",
                  "publisher": "SANDBOX",
                  "concept": {
                    "local": false,
                    "active": true,
                    "name": "Metabolic disease",
                    "code": "75934005",
                    "terminology": "SNOMEDCT",
                    "publisher": "SANDBOX",
                    "leaf": false
                  },
                  "ancestorPath": "138875005~404684003~64572001",
                  "childCt": 1,
                  "children": [
                    {
                      "id": "7d6fff05-23bb-47c2-adb3-3fc7a7500d89",
                      "confidence": 14.539000511169434,
                      "modified": "2024-05-13T18:27:51.318+00:00",
                      "created": "2024-05-13T18:27:51.318+00:00",
                      "modifiedBy": "loader",
                      "local": false,
                      "active": true,
                      "terminology": "SNOMEDCT",
                      "version": "20240101",
                      "publisher": "SANDBOX",
                      "concept": {
                        "local": false,
                        "active": true,
                        "name": "Disorder of carbohydrate metabolism",
                        "code": "20957000",
                        "terminology": "SNOMEDCT",
                        "publisher": "SANDBOX",
                        "leaf": false
                      },
                      "ancestorPath": "138875005~404684003~64572001~75934005",
                      "childCt": 1,
                      "children": [
                        {
                          "id": "b9bcad85-f461-4841-9ddb-087b71b038c1",
                          "confidence": 14.539000511169434,
                          "modified": "2024-05-13T18:27:51.295+00:00",
                          "created": "2024-05-13T18:27:51.295+00:00",
                          "modifiedBy": "loader",
                          "local": false,
                          "active": true,
                          "terminology": "SNOMEDCT",
                          "version": "20240101",
                          "publisher": "SANDBOX",
                          "concept": {
                            "local": false,
                            "active": true,
                            "name": "Disorder of glucose metabolism",
                            "code": "126877002",
                            "terminology": "SNOMEDCT",
                            "publisher": "SANDBOX",
                            "leaf": false
                          },
                          "ancestorPath": "138875005~404684003~64572001~75934005~20957000",
                          "childCt": 1,
                          "children": [
                            {
                              "id": "128d3443-00fd-4206-bdd7-a56e99be23d8",
                              "confidence": 14.028175354003906,
                              "modified": "2024-05-13T18:27:51.423+00:00",
                              "created": "2024-05-13T18:27:51.423+00:00",
                              "modifiedBy": "loader",
                              "local": false,
                              "active": true,
                              "terminology": "SNOMEDCT",
                              "version": "20240101",
                              "publisher": "SANDBOX",
                              "concept": {
                                "local": false,
                                "active": true,
                                "name": "Diabetes mellitus",
                                "code": "73211009",
                                "terminology": "SNOMEDCT",
                                "publisher": "SANDBOX",
                                "leaf": true
                              },
                              "ancestorPath": "138875005~404684003~64572001~75934005~20957000~126877002",
                              "childCt": 0
                            }
                          ]
                        }
                      ]
                    }
                  ]
                }
              ]
            }
          ]
        }
      ]
    },
    {
      "id": "d04ada33-189c-49bd-a50d-b0c854255468",
      "confidence": 14.539000511169434,
      "modified": "2024-05-13T18:27:51.309+00:00",
      "created": "2024-05-13T18:27:51.309+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "concept": {
        "local": false,
        "active": true,
        "name": "SNOMED CT Concept",
        "code": "138875005",
        "terminology": "SNOMEDCT",
        "publisher": "SANDBOX",
        "leaf": false
      },
      "childCt": 7,
      "children": [
        {
          "id": "3ece9cda-d26e-4718-a53d-94cc1eee4aa2",
          "confidence": 12.92956256866455,
          "modified": "2024-05-13T18:27:51.374+00:00",
          "created": "2024-05-13T18:27:51.374+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "concept": {
            "local": false,
            "active": true,
            "name": "Clinical finding",
            "code": "404684003",
            "terminology": "SNOMEDCT",
            "publisher": "SANDBOX",
            "leaf": false
          },
          "ancestorPath": "138875005",
          "childCt": 8,
          "children": [
            {
              "id": "c141ae1e-7846-4dab-9769-83d6473c5916",
              "confidence": 12.804399490356445,
              "modified": "2024-05-13T18:27:51.405+00:00",
              "created": "2024-05-13T18:27:51.405+00:00",
              "modifiedBy": "loader",
              "local": false,
              "active": true,
              "terminology": "SNOMEDCT",
              "version": "20240101",
              "publisher": "SANDBOX",
              "concept": {
                "local": false,
                "active": true,
                "name": "Disease",
                "code": "64572001",
                "terminology": "SNOMEDCT",
                "publisher": "SANDBOX",
                "leaf": false
              },
              "ancestorPath": "138875005~404684003",
              "childCt": 5,
              "children": [
                {
                  "id": "bd811ac6-b790-49f7-93d4-85a6260ad3eb",
                  "confidence": 13.239718437194824,
                  "modified": "2024-05-13T18:27:51.358+00:00",
                  "created": "2024-05-13T18:27:51.358+00:00",
                  "modifiedBy": "loader",
                  "local": false,
                  "active": true,
                  "terminology": "SNOMEDCT",
                  "version": "20240101",
                  "publisher": "SANDBOX",
                  "concept": {
                    "local": false,
                    "active": true,
                    "name": "Disorder of body system",
                    "code": "362965005",
                    "terminology": "SNOMEDCT",
                    "publisher": "SANDBOX",
                    "leaf": false
                  },
                  "ancestorPath": "138875005~404684003~64572001",
                  "childCt": 3,
                  "children": [
                    {
                      "id": "d77cd05b-9ad6-45ce-bcf6-9a56099fc770",
                      "confidence": 13.691702842712402,
                      "modified": "2024-05-13T18:27:51.359+00:00",
                      "created": "2024-05-13T18:27:51.359+00:00",
                      "modifiedBy": "loader",
                      "local": false,
                      "active": true,
                      "terminology": "SNOMEDCT",
                      "version": "20240101",
                      "publisher": "SANDBOX",
                      "concept": {
                        "local": false,
                        "active": true,
                        "name": "Disorder of endocrine system",
                        "code": "362969004",
                        "terminology": "SNOMEDCT",
                        "publisher": "SANDBOX",
                        "leaf": false
                      },
                      "ancestorPath": "138875005~404684003~64572001~362965005",
                      "childCt": 1,
                      "children": [
                        {
                          "id": "5b6781a3-9ddc-4dac-8a64-79eb1ac96ce5",
                          "confidence": 14.028175354003906,
                          "modified": "2024-05-13T18:27:51.423+00:00",
                          "created": "2024-05-13T18:27:51.423+00:00",
                          "modifiedBy": "loader",
                          "local": false,
                          "active": true,
                          "terminology": "SNOMEDCT",
                          "version": "20240101",
                          "publisher": "SANDBOX",
                          "concept": {
                            "local": false,
                            "active": true,
                            "name": "Diabetes mellitus",
                            "code": "73211009",
                            "terminology": "SNOMEDCT",
                            "publisher": "SANDBOX",
                            "leaf": true
                          },
                          "ancestorPath": "138875005~404684003~64572001~362965005~362969004",
                          "childCt": 0
                        }
                      ]
                    }
                  ]
                }
              ]
            }
          ]
        }
      ]
    }
  ]
}
```

[Back to Top](#top)

<a name="find-concepts"/>

### Get concept summaries (search by string)
Via $API_URL/project/sandbox/concept?terminology=<terminology>&query=<string>

Used to perform text searches to find matching concepts. The following example
performs a text search for "diabetes mellitus" and limits search results to 5
entries.

```
$ curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept?terminology=SNOMEDCT&query=diabetes%20mellitus&limit=5" | jq
{
  "total": 8,
  "parameters": {
    "query": "diabetes mellitus",
    "limit": 5,
    "offset": 0
  },
  "items": [
    {
      "id": "1ff90ce3-66c1-444e-ab67-e34ac53fc2c0",
      "confidence": 22.558368682861328,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Diabetes mellitus",
      "code": "73211009",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": true,
      "defined": false,
      "highlights": {
        "Diabetes mellitus": "<em>Diabetes</em> <em>mellitus</em>"
      }
    },
    {
      "id": "3476ebc2-744b-4155-b1ee-23daf2af6283",
      "confidence": 13.33260726928711,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Disorder of glucose metabolism",
      "code": "126877002",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": false,
      "defined": false
    },
    {
      "id": "2d35dd1d-fc59-449e-9bda-a74e922c2514",
      "confidence": 13.33260726928711,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Disorder of endocrine system",
      "code": "362969004",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": false,
      "defined": true
    },
    {
      "id": "c37c396d-5afe-4749-a71b-7aa90af7d540",
      "confidence": 11.253440856933594,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Disorder of carbohydrate metabolism",
      "code": "20957000",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": false,
      "defined": false
    },
    {
      "id": "fd3e144a-ca04-470e-8fa6-f55071faa104",
      "confidence": 10.625885009765625,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Metabolic disease",
      "code": "75934005",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": false,
      "defined": false
    }
  ]
}
```

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
$ curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept?terminology=SNOMEDCT&query=diabetes%20mellitus&limit=2&include=full" | jq
{
  "total": 8,
  "parameters": {
    "query": "diabetes mellitus",
    "limit": 2,
    "offset": 0
  },
  "items": [
    {
      "id": "1ff90ce3-66c1-444e-ab67-e34ac53fc2c0",
      "confidence": 22.558368682861328,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Diabetes mellitus",
      "code": "73211009",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": true,
      "defined": false,
      "terms": [
        {
          "id": "a4ca02f7-96d5-4984-82ab-c50932dc5c78",
          "modified": "2017-07-31T00:00:00.000+00:00",
          "created": "2017-07-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Diabetes mellitus",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "componentId": "121589010",
          "code": "73211009",
          "conceptId": "73211009",
          "localeMap": {
            "en_GB": true,
            "en": true
          },
          "type": "900000000000013009",
          "attributes": {
            "caseSignificanceId": "900000000000448009",
            "moduleId": "900000000000207008"
          }
        },
        {
          "id": "62da178f-4bb7-4a13-aa2d-e243798f8025",
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": false,
          "name": "Diabetes mellitus, NOS",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "componentId": "121590018",
          "code": "73211009",
          "conceptId": "73211009",
          "localeMap": {
            "en": false
          },
          "type": "900000000000013009",
          "attributes": {
            "caseSignificanceId": "900000000000020002",
            "moduleId": "900000000000207008"
          }
        },
        {
          "id": "d62b0b75-5588-467f-a794-1f6c0a5cfc6a",
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "DM - Diabetes mellitus",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "componentId": "502372015",
          "code": "73211009",
          "conceptId": "73211009",
          "localeMap": {
            "en_GB": false,
            "en": false
          },
          "type": "900000000000013009",
          "attributes": {
            "caseSignificanceId": "900000000000017005",
            "moduleId": "900000000000207008"
          }
        },
        {
          "id": "c0b184ba-bb0c-4fe7-ad9c-b1b4801543f7",
          "modified": "2017-07-31T00:00:00.000+00:00",
          "created": "2017-07-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Diabetes mellitus (disorder)",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "componentId": "813575016",
          "code": "73211009",
          "conceptId": "73211009",
          "localeMap": {
            "en_GB": true,
            "en": true
          },
          "type": "900000000000003001",
          "attributes": {
            "caseSignificanceId": "900000000000448009",
            "moduleId": "900000000000207008"
          }
        }
      ],
      "attributes": {
        "definitionStatusId": "900000000000074008",
        "moduleId": "900000000000207008"
      },
      "semanticTypes": [
        "disorder"
      ],
      "parents": [
        {
          "local": false,
          "active": true,
          "name": "Disorder of endocrine system",
          "code": "362969004",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": true
        },
        {
          "local": false,
          "active": true,
          "name": "Disorder of glucose metabolism",
          "code": "126877002",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": false
        }
      ],
      "relationships": [
        {
          "id": "eb340aa3-a5c8-4656-9ff4-767b4e2a1a55",
          "confidence": 5.359277725219727,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "componentId": "267149027",
          "type": "Is a",
          "additionalType": "116680003",
          "from": {
            "local": false,
            "active": false,
            "name": "Diabetes mellitus",
            "code": "73211009",
            "terminology": "SNOMEDCT",
            "version": "20240101",
            "publisher": "SANDBOX",
            "leaf": true,
            "defined": false
          },
          "to": {
            "local": false,
            "active": false,
            "name": "Disorder of glucose metabolism",
            "code": "126877002",
            "terminology": "SNOMEDCT",
            "version": "20240101",
            "publisher": "SANDBOX",
            "leaf": false,
            "defined": false
          },
          "hierarchical": true,
          "asserted": true,
          "defining": true,
          "group": "0",
          "attributes": {
            "modifierId": "900000000000451002",
            "characteristicTypeId": "900000000000011006",
            "moduleId": "900000000000207008"
          }
        },
        {
          "id": "9b8d43b5-01c8-416c-9d18-3e71130cf472",
          "confidence": 5.359277725219727,
          "modified": "2012-01-31T00:00:00.000+00:00",
          "created": "2012-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "componentId": "4601709020",
          "type": "Is a",
          "additionalType": "116680003",
          "from": {
            "local": false,
            "active": false,
            "name": "Diabetes mellitus",
            "code": "73211009",
            "terminology": "SNOMEDCT",
            "version": "20240101",
            "publisher": "SANDBOX",
            "leaf": true,
            "defined": false
          },
          "to": {
            "local": false,
            "active": false,
            "name": "Disorder of endocrine system",
            "code": "362969004",
            "terminology": "SNOMEDCT",
            "version": "20240101",
            "publisher": "SANDBOX",
            "leaf": false,
            "defined": true
          },
          "hierarchical": true,
          "asserted": true,
          "defining": true,
          "group": "0",
          "attributes": {
            "modifierId": "900000000000451002",
            "characteristicTypeId": "900000000000011006",
            "moduleId": "900000000000207008"
          }
        },
        {
          "id": "3b332709-c111-46bb-8922-661677a3001d",
          "confidence": 5.359277725219727,
          "modified": "2019-07-31T00:00:00.000+00:00",
          "created": "2019-07-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "componentId": "4601710026",
          "type": "other",
          "additionalType": "363698007",
          "from": {
            "local": false,
            "active": false,
            "name": "Diabetes mellitus",
            "code": "73211009",
            "terminology": "SNOMEDCT",
            "version": "20240101",
            "publisher": "SANDBOX",
            "leaf": true,
            "defined": false
          },
          "to": {
            "local": false,
            "active": false,
            "name": "Structure of endocrine system",
            "code": "113331007",
            "terminology": "SNOMEDCT",
            "version": "20240101",
            "publisher": "SANDBOX",
            "leaf": false,
            "defined": false
          },
          "hierarchical": false,
          "asserted": true,
          "defining": true,
          "group": "1",
          "attributes": {
            "modifierId": "900000000000451002",
            "characteristicTypeId": "900000000000011006",
            "moduleId": "900000000000207008"
          }
        }
      ]
    },
    {
      "id": "3476ebc2-744b-4155-b1ee-23daf2af6283",
      "confidence": 13.33260726928711,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Disorder of glucose metabolism",
      "code": "126877002",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": false,
      "defined": false,
      "terms": [
        {
          "id": "d3d321cf-a906-4d2b-89a9-e4eaceed07b4",
          "modified": "2017-07-31T00:00:00.000+00:00",
          "created": "2017-07-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Disorder of glucose metabolism",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "componentId": "165018",
          "code": "126877002",
          "conceptId": "126877002",
          "localeMap": {
            "en_GB": true,
            "en": true
          },
          "type": "900000000000013009",
          "attributes": {
            "caseSignificanceId": "900000000000448009",
            "moduleId": "900000000000207008"
          }
        },
        {
          "id": "8ab76f5d-bd3a-4c11-8568-85ac5622ec13",
          "modified": "2017-07-31T00:00:00.000+00:00",
          "created": "2017-07-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Disorder of glucose metabolism (disorder)",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "componentId": "730899016",
          "code": "126877002",
          "conceptId": "126877002",
          "localeMap": {
            "en_GB": true,
            "en": true
          },
          "type": "900000000000003001",
          "attributes": {
            "caseSignificanceId": "900000000000448009",
            "moduleId": "900000000000207008"
          }
        }
      ],
      "attributes": {
        "definitionStatusId": "900000000000074008",
        "moduleId": "900000000000207008"
      },
      "semanticTypes": [
        "disorder"
      ],
      "children": [
        {
          "local": false,
          "active": true,
          "name": "Diabetes mellitus",
          "code": "73211009",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": true,
          "defined": false
        }
      ],
      "parents": [
        {
          "local": false,
          "active": true,
          "name": "Disorder of carbohydrate metabolism",
          "code": "20957000",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": false
        }
      ],
      "relationships": [
        {
          "id": "f547b786-3864-4c8a-af75-610c2fd37f7d",
          "confidence": 6.206575870513916,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "componentId": "161242021",
          "type": "Is a",
          "additionalType": "116680003",
          "from": {
            "local": false,
            "active": false,
            "name": "Disorder of glucose metabolism",
            "code": "126877002",
            "terminology": "SNOMEDCT",
            "version": "20240101",
            "publisher": "SANDBOX",
            "leaf": false,
            "defined": false
          },
          "to": {
            "local": false,
            "active": false,
            "name": "Disorder of carbohydrate metabolism",
            "code": "20957000",
            "terminology": "SNOMEDCT",
            "version": "20240101",
            "publisher": "SANDBOX",
            "leaf": false,
            "defined": false
          },
          "hierarchical": true,
          "asserted": true,
          "defining": true,
          "group": "0",
          "attributes": {
            "modifierId": "900000000000451002",
            "characteristicTypeId": "900000000000011006",
            "moduleId": "900000000000207008"
          }
        }
      ],
      "inverseRelationships": [
        {
          "id": "eb340aa3-a5c8-4656-9ff4-767b4e2a1a55",
          "confidence": 6.206575870513916,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "componentId": "267149027",
          "type": "Is a",
          "additionalType": "116680003",
          "from": {
            "local": false,
            "active": false,
            "name": "Diabetes mellitus",
            "code": "73211009",
            "terminology": "SNOMEDCT",
            "version": "20240101",
            "publisher": "SANDBOX",
            "leaf": true,
            "defined": false
          },
          "to": {
            "local": false,
            "active": false,
            "name": "Disorder of glucose metabolism",
            "code": "126877002",
            "terminology": "SNOMEDCT",
            "version": "20240101",
            "publisher": "SANDBOX",
            "leaf": false,
            "defined": false
          },
          "hierarchical": true,
          "asserted": true,
          "defining": true,
          "group": "0",
          "attributes": {
            "modifierId": "900000000000451002",
            "characteristicTypeId": "900000000000011006",
            "moduleId": "900000000000207008"
          }
        }
      ]
    }
  ]
}
```

[Back to Top](#top)

<a name="find-concepts-expr"/>

### Get concept summaries including parents (search by string and ECL expression)
Via $API_URL/project/sandbox/concept?terminology=<terminology>&query=<string>&expression=<ecl>&include=full

This example performs a search that returns the full concept information for those concepts returned from the specified ecl express contain the word "system" with a maximum of 5 results.

NOTE: the expression we are using is <<64572001 (descendants-or-self of the "Disease"
concept in SNOMED).  To work properly, the expression value has to be url encoded 
(See https://www.urlencoder.org/ for an online URL encoder):

```
$ curl -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept?terminology=SNOMEDCT&query=system&expression=%3C64572001&offset=0&limit=5&include=parents" | jq
{
  "total": 7,
  "parameters": {
    "query": "system",
    "expression": "<64572001",
    "limit": 5,
    "offset": 0
  },
  "items": [
    {
      "id": "d3a32967-ded2-44f2-bb28-00b76aafd33b",
      "confidence": 10.5681734085083,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Disorder of cardiovascular system",
      "code": "49601007",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": true,
      "defined": true,
      "parents": [
        {
          "local": false,
          "active": true,
          "name": "Disorder of body system",
          "code": "362965005",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": true
        },
        {
          "local": false,
          "active": true,
          "name": "Cardiovascular finding",
          "code": "106063007",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": true
        }
      ]
    },
    {
      "id": "510b444c-1f96-4776-8be8-ceb0c4d8d83a",
      "confidence": 10.09471607208252,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Disorder of body system",
      "code": "362965005",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": false,
      "defined": true,
      "parents": [
        {
          "local": false,
          "active": true,
          "name": "Disease",
          "code": "64572001",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": false
        }
      ]
    },
    {
      "id": "2d35dd1d-fc59-449e-9bda-a74e922c2514",
      "confidence": 10.05108642578125,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Disorder of endocrine system",
      "code": "362969004",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": false,
      "defined": true,
      "parents": [
        {
          "local": false,
          "active": true,
          "name": "Disorder of body system",
          "code": "362965005",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": true
        }
      ]
    },
    {
      "id": "1ff90ce3-66c1-444e-ab67-e34ac53fc2c0",
      "confidence": 6.615461349487305,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Diabetes mellitus",
      "code": "73211009",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": true,
      "defined": false,
      "parents": [
        {
          "local": false,
          "active": true,
          "name": "Disorder of endocrine system",
          "code": "362969004",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": true
        },
        {
          "local": false,
          "active": true,
          "name": "Disorder of glucose metabolism",
          "code": "126877002",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": false
        }
      ]
    },
    {
      "id": "018d243d-3ecb-4a46-b180-73ca38191330",
      "confidence": 6.485122203826904,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Disorder of breast",
      "code": "79604008",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": false,
      "defined": true,
      "parents": [
        {
          "local": false,
          "active": true,
          "name": "Disorder of body system",
          "code": "362965005",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": true
        },
        {
          "local": false,
          "active": true,
          "name": "Disorder of thorax",
          "code": "118946009",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": true
        },
        {
          "local": false,
          "active": true,
          "name": "Breast finding",
          "code": "116339002",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": true
        }
      ]
    }
  ]
}
```

[Back to Top](#top)

<a name="find-terms"/>


### Get concept summaries (search by ECL expression)
Via $API_URL/project/sandbox/concept?terminology=<terminology>&query="*"&expression=<ecl>

Used to perform text searches to find terms matching a particular terminology.  
While in many instances it is most useful to directly find concepts with matching 
terms, this call allows users to isolate exactly those terms that resolve from a search.


```
$ curl -H "Authorization: Bearer $token" "$API_URL/project/sandbox/concept?terminology=SNOMEDCT&query=*&expression=%3C64572001&offset=0&limit=5" | jq
{
  "total": 22,
  "parameters": {
    "query": "*",
    "expression": "<64572001",
    "limit": 5,
    "offset": 0
  },
  "items": [
    {
      "id": "82e35a8c-d17c-47c0-b737-f2dd34ac3258",
      "confidence": 5.7142438888549805,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Disorder of thorax",
      "code": "118946009",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": false,
      "defined": true
    },
    {
      "id": "0605b56f-d75f-40dc-a5a8-50d947430c9e",
      "confidence": 5.7142438888549805,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Neoplasm of trunk",
      "code": "126637008",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": false,
      "defined": true
    },
    {
      "id": "3476ebc2-744b-4155-b1ee-23daf2af6283",
      "confidence": 5.7142438888549805,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Disorder of glucose metabolism",
      "code": "126877002",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": false,
      "defined": false
    },
    {
      "id": "e10fcd8b-483d-41e0-8bb2-91ecbc3ab052",
      "confidence": 5.7142438888549805,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Neoplasm of breast",
      "code": "126926005",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": true,
      "defined": true
    },
    {
      "id": "8426e589-67b6-4b2a-8744-823fc69d2f60",
      "confidence": 5.7142438888549805,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Disorder of trunk",
      "code": "128121009",
      "terminology": "SNOMEDCT",
      "version": "20240101",
      "publisher": "SANDBOX",
      "leaf": false,
      "defined": true
    }
  ]
}
```

[Back to Top](#top)

<a name="autocomplete"/>

### Demonstrate capabilities autocomplete, aka type-ahead
Via $API_URL/project/sandbox/autocomplete?terminology=<terminology>&query=<string>

This script demonstrates an autocomplete or typeahead for a user interface feature 
to find potential search terms for a few starting characters.  By default it produces
10 results.

```
$ curl -s -H "Authorization: Bearer $token" "$API_URL/project/sandbox/autocomplete?terminology=SNOMEDCT&query=diab" | jq
[
  "Diabetic monitoring",
  "Diabetes mellitus",
  "DM - Diabetes mellitus",
  "Diabetic monitoring (procedure)",
  "Diabetes mellitus, NOS",
  "Diabetes mellitus (disorder)",
  "Diabetic monitoring (regime/therapy)"
]
```

[Back to Top](#top)


