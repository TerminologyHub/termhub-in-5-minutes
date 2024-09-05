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

```
./login.sh bcarlsen@westcoastinformatics.com *********
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  4:32:17 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
username = bcarlsen@westcoastinformatics.com
password = ************

  token=eyJ0eX...O8XA-k1SXI9

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  4:32:17 PM
-----------------------------------------------------
```

From the output, paste the "token=..." into your shell to set it as a variable for the following calls.

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-terminologies" />Get terminologies - find-terminologies.sh

Return all loaded terminologies currently hosted by the API.

```
$ ./find-terminologies.sh --token $token
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  3:05:19 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
query =
offset = 0
limit = 10
sort =
ascending =

  Performing terminologies lookup
    {
      "total": 88,
      "parameters": {
        "query": "loaded:true",
        "limit": 10,
        "offset": 0
      },
      "items": [
        {
          "id": "fda9bef2-df80-40d6-b31b-6cb3a1cd38c3",
          "confidence": 0.00501254154369235,
          "modified": "2024-05-11T20:13:11.499+00:00",
          "created": "2024-05-11T20:13:11.499+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "abbreviation": "SNOMEDCT_US",
...
-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  3:05:19 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-project-terminologies" />Get project terminologies - find-terminologies.sh

Return all terminologies for specific project identified by either project id or project uriLabel.

```
$ ./find-terminologies.sh --token $token --project sandbox
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  4:33:01 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
project = sandbox

  Performing terminologies lookup
    [
      {
        "id": "177f2263-fe04-4f1f-b0e6-9b351ab8baa9",
        "confidence": 7.666106700897217,
        "modified": "2024-08-23T02:03:54.059+00:00",
        "created": "2024-08-23T02:03:54.059+00:00",
        "modifiedBy": "loader",
        "local": false,
        "active": true,
        "abbreviation": "ICD10CM",
        "name": "Mini version of ICD10CM for testing purposes",
        "version": "2023",
        "publisher": "SANDBOX",
        "latest": false,
        "loaded": true,
        "releaseDate": "2023-05-01",
        "family": "ICD10CM",
        "indexName": "icd10cm-sandbox-2023",
        "attributes": {
          "fhirUri": "http://hl7.org/fhir/sid/icd-10-cm",
          "origin-version": "2023AA",
          "autocomplete": "true",
          "hierarchical": "true",
          "fhirVersion": "2023",
          "tree-positions": "true",
          "origin-terminology": "UMLS",
          "ecl": "true",
          "fhirId": "icd10cm_2023",
          "fhirCompositional": "false"
        },
        "roots": [
          "ICD-10-CM"
        ],
        "statistics": {
          "termsInactive": 0,
          "childrenInactive": 0,
          "relationships": 18,
          "concepts": 10,
          "terms": 22,
          "parentsInactive": 0,
          "termsActive": 22,
          "parentsActive": 9,
          "definitions": 0,
          "treePositions": 10,
          "conceptsActive": 10,
          "childrenActive": 9
        }
      },
      ...
      {
        "id": "d1aba666-39bf-48ea-b524-c5a47ab1dcf1",
        "confidence": 8.621618270874023,
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
      }
    ]

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  4:33:02 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-terminology" />Get specific terminology - find-terminologies.sh

Return a specific terminology by its terminology id.  The UUID below is an example
that may or may not work.  The idea is to take one of the terminology ids returned
by one of the previous calls and you can then look up terminology info for specifically that
UUID.

```
$ ./find-terminologies.sh --token $token --id 1e523c73-dfe8-4299-92ee-b7a8ece57769
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  4:35:02 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
query =
offset = 0
limit = 10
sort =
ascending =
id = 1e523c73-dfe8-4299-92ee-b7a8ece57769

  Performing terminologies lookup
    {
      "id": "1e523c73-dfe8-4299-92ee-b7a8ece57769",
      "confidence": 7.352961540222168,
      "modified": "2024-08-23T02:06:30.814+00:00",
      "created": "2024-08-23T02:06:30.814+00:00",
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
      "attributes": {
        "autocomplete": "true",
        "description-logic-based": "true",
        "tree-positions": "true",
        "unidirectional-rels": "true",
        "has-relationship-directionality": "true",
        "ecl": "true",
        "description-logic-profile": "EL++",
        "fhirUri": "http://snomed.info/sct",
        "show-sty": "true",
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
        "childrenActive": 611
      }
    }

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  4:35:02 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="export-terminology" />Export terminology - export-terminology.sh

Export terminology for the given project id (or uriLabel) and terminology

```
$ ./export-terminology.sh --token $token sandbox SNOMEDCT
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  4:42:51 PM
-----------------------------------------------------
url = https://api.terminologyhub.com

  Performing terminology export to file SNOMEDCT.zip
-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  4:42:54 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-concept-by-code" />Get concept by code - get-concept.sh

Return summary concept information for a given terminology and code. 
The following example gets the 73211009 | Diabetes mellitus | concept in SNOMEDCT.

```
$ ./get-concept.sh sandbox SNOMEDCT 73211009 --token $token
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  4:43:47 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
project= sandbox
code = 73211009
include = summary

  Get concept for SNOMEDCT 73211009:

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

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  4:43:47 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-concept-by-code-with-explicit-include-parameter" />Get concept by code with explicit include parameter - get-concept.sh

Return summary concept information for a given terminology and code and use --include to
specify exactly which parts of the concept to return.
The following example gets the 73211009 | Diabetes mellitus | concept in SNOMEDCT with "parents".

For more information see [INCLUDE.md](../doc/INCLUDE.md "INCLUDE.md").

```
$ ./get-concept.sh sandbox SNOMEDCT 73211009 --include parents --token $token
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  4:45:15 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
project= sandbox
code = 73211009
include = parents

  Get concept for SNOMEDCT 73211009:

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
    }

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  4:45:15 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-concept-relationships-by-code" />Get concept relationships by code - get-concept-relationships.sh

Return concept relationships for a given terminology and code.  This resolves
relationships that originate "from" this concept code and contains information about
the concepts those relationships point "to" on the other side.  The following example gets
relationships for the 73211009 | Diabetes mellitus | concept in SNOMEDCT.

```
$ ./get-concept-relationships.sh sandbox SNOMEDCT 73211009 --token $token
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  4:46:23 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
code = 73211009
code = 73211009

  Get concept relationships for SNOMEDCT 73211009:

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

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  4:46:23 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-concept-inverse-relationships-by-code" />Get concept inverse relationships by code - get-concept-relationships.sh

Return inverse concept relationships for a given terminology and code.  This resolves
relationships that point "to" this concept code and contains information about
the concepts those relationships originate "from" on the other side.  The following example gets
inverse relationships for the 73211009 | Diabetes mellitus | concept in SNOMEDCT.

```
$ -----------------------------------------------------
Starting ...Mon, Aug 26, 2024  4:47:40 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
code = 113331007
inverse = true
code = 113331007

  Get concept relationships for SNOMEDCT 113331007:

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

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  4:47:40 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-concept-trees" />Get concept trees - get-concept-treepos.sh

Return concept tree positions for a given terminology and code. For classification hierarchies, you would expect to see just a single tree position. But for more complex poly-hierarchies you'd likely expect to see multiple tree positions - each one with a different path to the root concept. The  following example finds tree positions for the 73211009 | Diabetes mellitus | concept in SNOMEDCT. 

```
$ -----------------------------------------------------
Starting ...Mon, Aug 26, 2024  4:49:24 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
code = 73211009

  Get concept tree positions for SNOMEDCT 73211009:

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

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  4:49:25 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="find-concepts-by-search-term" />Find concepts by search term (use paging to get only first 5 results - find-concepts.sh

Return concepts matching a given text search for a given terminology. The following example
performs a text search for "diabetes mellitus" in SNOMEDCT and limits search results to 5
entries.

```
$ ./find-concepts.sh sandbox SNOMEDCT "diabetes mellitus"  --token $token --limit 5
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  4:50:57 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
project = sandbox
query = diabetes mellitus
expr =
offset = 0
limit = 5
sort =
ascending =

  Find concepts: (terminology:SNOMEDCT) AND diabetes mellitus

    {
      "total": 8,
      "parameters": {
        "query": "(terminology:SNOMEDCT) AND diabetes mellitus",
        "limit": 5,
        "offset": 0
      },
      "items": [
        {
          "id": "1ff90ce3-66c1-444e-ab67-e34ac53fc2c0",
          "confidence": 22.559518814086914,
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
          "defined": false
        },
        {
          "id": "3476ebc2-744b-4155-b1ee-23daf2af6283",
          "confidence": 13.333757400512695,
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
          "confidence": 13.333757400512695,
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
          "confidence": 11.25459098815918,
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
          "confidence": 10.627035140991211,
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

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  4:50:57 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="find-concepts-by-search-term-with-explicit-include-parameter" />Find concepts by search term with explicit include parameter - find-concepts.sh

Return concepts matching a given text search for a given terminology and use --include to
specify exactly which parts of the concept to return. The following example
performs a text search for "diabetes mellitus" in SNOMEDCT and limits search results to 5
entries and includes information about "parent" concepts.

For more information see [INCLUDE.md](../doc/INCLUDE.md "INCLUDE.md").

```
$ ./find-concepts.sh sandbox SNOMEDCT "system" --token $token --limit 5 --include parents
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  5:22:02 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
project = sandbox
query = system
expr =
offset = 0
limit = 5
sort =
ascending =

  Find concepts: (terminology:SNOMEDCT) AND system

    {
      "total": 133,
      "parameters": {
        "query": "(terminology:SNOMEDCT) AND system",
        "limit": 5,
        "offset": 0
      },
      "items": [
        {
          "id": "d3a32967-ded2-44f2-bb28-00b76aafd33b",
          "confidence": 5.855079650878906,
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
          "id": "817af3af-8008-4566-8b9a-75c6ee125749",
          "confidence": 5.840748310089111,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Structure of cardiovascular system",
          "code": "113257007",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": false,
          "parents": [
            {
              "local": false,
              "active": true,
              "name": "Body system structure",
              "code": "91689009",
              "terminology": "SNOMEDCT",
              "version": "20240101",
              "publisher": "SANDBOX",
              "leaf": false,
              "defined": false
            }
          ]
        },
        {
          "id": "fa06a994-af25-4656-9a59-1e74758c900d",
          "confidence": 5.827065944671631,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Entire cardiovascular system",
          "code": "278198007",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": true,
          "defined": false,
          "parents": [
            {
              "local": false,
              "active": true,
              "name": "Structure of cardiovascular system",
              "code": "113257007",
              "terminology": "SNOMEDCT",
              "version": "20240101",
              "publisher": "SANDBOX",
              "leaf": false,
              "defined": false
            },
            {
              "local": false,
              "active": true,
              "name": "Entire body system",
              "code": "278195005",
              "terminology": "SNOMEDCT",
              "version": "20240101",
              "publisher": "SANDBOX",
              "leaf": false,
              "defined": false
            }
          ]
        },
        {
          "id": "5d18a92d-b2bc-4d03-a6df-423a9c9dcb26",
          "confidence": 5.664218425750732,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Structure of endocrine system",
          "code": "113331007",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": false,
          "parents": [
            {
              "local": false,
              "active": true,
              "name": "Structure of breast and/or endocrine system",
              "code": "305072005",
              "terminology": "SNOMEDCT",
              "version": "20240101",
              "publisher": "SANDBOX",
              "leaf": false,
              "defined": false
            }
          ]
        },
        {
          "id": "8c2c7c69-d19d-4d20-adf9-80b13ec6d6e2",
          "confidence": 5.627072334289551,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Procedure on body system",
          "code": "118664000",
          "terminology": "SNOMEDCT",
          "version": "20240101",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": true,
          "parents": [
            {
              "local": false,
              "active": true,
              "name": "Procedure by site",
              "code": "362958002",
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

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  5:22:03 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="find-concepts-by-search-term-and-expression" />Find concepts by search term and expression - find-concepts.sh

Return concepts matching a given text search for a given terminology and only match concepts
that resolve for a given ECL expression. The following example
performs a text search for "diabetes mellitus" in SNOMEDCT for the ECL expression "<64572001" 
and limits search results to 5 entries.

For more information see [ECL.md](../doc/ECL.md "ECL.md").

```
$ ./find-concepts.sh sandbox SNOMEDCT "system" --expr "<64572001" --token $token --limit 5
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  5:19:29 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
project = sandbox
query = system
expr = <64572001
offset = 0
limit = 5
sort =
ascending =

  Find concepts: (terminology:SNOMEDCT) AND system

    {
      "total": 7,
      "parameters": {
        "query": "(terminology:SNOMEDCT) AND system",
        "expression": "<64572001",
        "limit": 5,
        "offset": 0
      },
      "items": [
        {
          "id": "d3a32967-ded2-44f2-bb28-00b76aafd33b",
          "confidence": 10.569323539733887,
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
          "defined": true
        },
        {
          "id": "510b444c-1f96-4776-8be8-ceb0c4d8d83a",
          "confidence": 10.095866203308105,
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
          "defined": true
        },
        {
          "id": "2d35dd1d-fc59-449e-9bda-a74e922c2514",
          "confidence": 10.052236557006836,
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
          "id": "1ff90ce3-66c1-444e-ab67-e34ac53fc2c0",
          "confidence": 6.616611480712891,
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
          "defined": false
        },
        {
          "id": "018d243d-3ecb-4a46-b180-73ca38191330",
          "confidence": 6.48627233505249,
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
          "defined": true
        }
      ]
    }

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  5:19:30 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="find-terms-by-search-term" />Find terms by search term - find-terms.sh

Return terms matching a given text search for a given terminology.  
While in many instances it is most useful to directly find concepts with matching 
terms, this call allows users to isolate exactly those terms that resolve from a search.

The following example performs a text search for "diabetes" in SNOMEDCT.

```
$ ./find-terms.sh sandbox SNOMEDCT diabetes --token $token
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  4:55:14 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
project = sandbox
query = diabetes
offset = 0
limit = 10
sort =
ascending =

  Find terms: diabetes

    {
      "total": 4,
      "parameters": {
        "query": "diabetes",
        "limit": 10,
        "offset": 0
      },
      "items": [
        {
          "id": "a4ca02f7-96d5-4984-82ab-c50932dc5c78",
          "confidence": 9.246849060058594,
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
          "id": "d62b0b75-5588-467f-a794-1f6c0a5cfc6a",
          "confidence": 9.246849060058594,
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
          "id": "62da178f-4bb7-4a13-aa2d-e243798f8025",
          "confidence": 8.964832305908203,
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
          "id": "c0b184ba-bb0c-4fe7-ad9c-b1b4801543f7",
          "confidence": 8.964832305908203,
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
      ]
    }

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  4:55:14 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="support-autocompletetypeahead-for-first-few-characters-typed" />Support autocomplete/typeahead for first few characters typed - autocomplete.sh

Return autocompletions or typeaheads given a partial text string for a given terminology.
This is primarily intended to support a user interface completion feature and identify 
to potential search terms based on a few starting characters.  The following example yields 
potentially matching strings in SNOMEDCT for the string "diab".

```
$ ./autocomplete.sh sandbox SNOMEDCT diab --token $token
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  4:56:14 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
project = sandbox
limit = 10

  Find terms: diab

    [
      "Diabetic monitoring",
      "Diabetes mellitus",
      "DM - Diabetes mellitus",
      "Diabetic monitoring (procedure)",
      "Diabetes mellitus, NOS",
      "Diabetes mellitus (disorder)",
      "Diabetic monitoring (regime/therapy)"
    ]

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  4:56:14 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-mapsets" />Get mapsets - find-mapsets.sh

Return all loaded mapsets currently hosted by the API (limited to 2 entries). This supports offset, limit,
sort, and ascending parameters to control amount and order of mapset information.

```
$ ./find-mapsets.sh  --token $token --limit 2
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  4:57:40 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
query =
offset = 0
limit = 2
sort =
ascending =

  Performing mapsets lookup
    {
      "total": 11,
      "parameters": {
        "query": "loaded:true",
        "limit": 2,
        "offset": 0
      },
      "items": [
        {
          "id": "0280502a-7fe2-49f5-a1bb-2fb7e030c3c5",
          "confidence": 0.03922070935368538,
          "modified": "2024-08-21T17:28:00.583+00:00",
          "created": "2024-08-21T17:28:00.583+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "abbreviation": "NDC-CVX",
          "name": "Mapset from NDC 20240704 to CVX 20240806",
          "version": "20240806",
          "publisher": "CDC",
          "latest": true,
          "loaded": true,
          "code": "NDC-CVX",
          "fromPublisher": "FDA",
          "fromTerminology": "NDC",
          "fromVersion": "20240704",
          "toPublisher": "CDC",
          "toTerminology": "CVX",
          "toVersion": "20240806",
          "terminology": "CVX",
          "description": "Mapset from NDC 20240704 to CVX 20240806",
          "releaseDate": "2024-08-06",
          "attributes": {
            "complexity": "simple",
            "fhirUri": "http://hl7.org/fhir/sid/cvx?fhir_cm=NDC-CVX",
            "fhirFromTerminologyUri": "http://hl7.org/fhir/sid/ndc",
            "origin-version": "20240806",
            "fhirToTerminologyUri": "http://hl7.org/fhir/sid/cvx",
            "fhirToTerminologyVersion": "20240806",
            "fhirVersion": "20240806",
            "fhirFromTerminologyVersion": "20240704",
            "origin-terminology": "CVX",
            "cardinality": "N-1",
            "fhirId": "cdc_ndc-cvx_20240806"
          },
          "statistics": {
            "mappings": 169,
            "uniqueFromCodes": 169,
            "mappingsEmptyTarget": 0,
            "mappingsActive": 169,
            "uniqueToCodes": 85
          }
        },
        {
          "id": "145e8ada-d079-420f-af9d-783a9b3a5c29",
          "confidence": 0.03922070935368538,
          "modified": "2024-08-21T17:26:41.670+00:00",
          "created": "2024-08-21T17:26:41.670+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "abbreviation": "NDC-CVX",
          "name": "Mapset from NDC 20240704 to CVX 20240729",
          "version": "20240729",
          "publisher": "CDC",
          "latest": false,
          "loaded": true,
          "code": "NDC-CVX",
          "fromPublisher": "FDA",
          "fromTerminology": "NDC",
          "fromVersion": "20240704",
          "toPublisher": "CDC",
          "toTerminology": "CVX",
          "toVersion": "20240729",
          "terminology": "CVX",
          "description": "Mapset from NDC 20240704 to CVX 20240729",
          "releaseDate": "2024-07-29",
          "attributes": {
            "complexity": "simple",
            "fhirUri": "http://hl7.org/fhir/sid/cvx?fhir_cm=NDC-CVX",
            "fhirFromTerminologyUri": "http://hl7.org/fhir/sid/ndc",
            "origin-version": "20240729",
            "fhirToTerminologyUri": "http://hl7.org/fhir/sid/cvx",
            "fhirToTerminologyVersion": "20240729",
            "fhirVersion": "20240729",
            "fhirFromTerminologyVersion": "20240704",
            "origin-terminology": "CVX",
            "cardinality": "N-1",
            "fhirId": "cdc_ndc-cvx_20240729"
          },
          "statistics": {
            "mappings": 169,
            "uniqueFromCodes": 169,
            "mappingsEmptyTarget": 0,
            "mappingsActive": 169,
            "uniqueToCodes": 85
          }
        }
      ]
    }

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  4:57:40 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-project-mapsets" />Get project mapsets - find-mapsets.sh

Return all mapsets for specific project identified by either project id or project uriLabel.

```
$ ./find-mapsets.sh --token $token --project sandbox
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  4:58:47 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
project = sandbox

  Performing mapsets lookup
    [
      {
        "id": "2a545e12-04eb-48ee-b988-c17346b4e05f",
        "confidence": 4.5325422286987305,
        "modified": "2024-08-23T18:59:26.487+00:00",
        "created": "2024-08-23T18:59:26.487+00:00",
        "modifiedBy": "loader",
        "local": false,
        "active": true,
        "abbreviation": "SNOMEDCT_US-ICD10CM",
        "name": "Mapset from SNOMEDCT_US 20240301 to ICD10CM 2023",
        "version": "20240301",
        "publisher": "SANDBOX",
        "latest": true,
        "loaded": true,
        "code": "6011000124106",
        "fromPublisher": "SANDBOX",
        "fromTerminology": "SNOMEDCT_US",
        "fromVersion": "20240301",
        "toPublisher": "SANDBOX",
        "toTerminology": "ICD10CM",
        "toVersion": "2023",
        "terminology": "SNOMEDCT_US",
        "description": "ICD-10-CM complex map reference set",
        "releaseDate": "2024-03-01",
        "attributes": {
          "complexity": "complex",
          "fhirUri": "http://snomed.info/sct?fhir_cm=6011000124106",
          "fhirFromTerminologyUri": "http://snomed.info/sct",
          "origin-version": "20240301",
          "fhirToTerminologyUri": "http://hl7.org/fhir/sid/icd-10-cm",
          "fhirToTerminologyVersion": "2023",
          "fhirVersion": "20240301",
          "fhirFromTerminologyVersion": "20240301",
          "origin-terminology": "SNOMEDCT_US",
          "cardinality": "N-N",
          "fhirId": "sandbox_snomedct_us-icd10cm_20240301"
        },
        "statistics": {
          "mappings": 64,
          "uniqueFromCodes": 41,
          "mappingsEmptyTarget": 15,
          "mappingsActive": 64,
          "uniqueToCodes": 35
        }
      }
    ]

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  4:58:47 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-mapset" />Get specific mapset - find-mapsets.sh

Return a specific mapset by its mapset id.  The UUID below is an example
that may or may not work.  The idea is to take one of the mapset ids returned
by one of the previous calls and you can then look up mapset info for specifically that
UUID.

```
$ ./find-mapsets.sh --token $token --id 2a545e12-04eb-48ee-b988-c17346b4e05f
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  5:00:13 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
query =
offset = 0
limit = 10
sort =
ascending =
id = 2a545e12-04eb-48ee-b988-c17346b4e05f

  Performing mapsets lookup
    {
      "id": "2a545e12-04eb-48ee-b988-c17346b4e05f",
      "confidence": 3.220355987548828,
      "modified": "2024-08-23T18:59:26.487+00:00",
      "created": "2024-08-23T18:59:26.487+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "abbreviation": "SNOMEDCT_US-ICD10CM",
      "name": "Mapset from SNOMEDCT_US 20240301 to ICD10CM 2023",
      "version": "20240301",
      "publisher": "SANDBOX",
      "latest": true,
      "loaded": true,
      "code": "6011000124106",
      "fromPublisher": "SANDBOX",
      "fromTerminology": "SNOMEDCT_US",
      "fromVersion": "20240301",
      "toPublisher": "SANDBOX",
      "toTerminology": "ICD10CM",
      "toVersion": "2023",
      "terminology": "SNOMEDCT_US",
      "description": "ICD-10-CM complex map reference set",
      "releaseDate": "2024-03-01",
      "attributes": {
        "complexity": "complex",
        "fhirUri": "http://snomed.info/sct?fhir_cm=6011000124106",
        "fhirFromTerminologyUri": "http://snomed.info/sct",
        "origin-version": "20240301",
        "fhirToTerminologyUri": "http://hl7.org/fhir/sid/icd-10-cm",
        "fhirToTerminologyVersion": "2023",
        "fhirVersion": "20240301",
        "fhirFromTerminologyVersion": "20240301",
        "origin-terminology": "SNOMEDCT_US",
        "cardinality": "N-N",
        "fhirId": "sandbox_snomedct_us-icd10cm_20240301"
      },
      "statistics": {
        "mappings": 64,
        "uniqueFromCodes": 41,
        "mappingsEmptyTarget": 15,
        "mappingsActive": 64,
        "uniqueToCodes": 35
      }
    }

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  5:00:14 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="export-mapset" />Export mapset - export-mapsets.sh

Export a mapset for the given project id (or uriLabel) and mapset abbreviation or id.

```
$ ./export-mapset.sh --token $token sandbox SNOMEDCT_US-ICD10CM
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  5:01:21 PM
-----------------------------------------------------
url = https://api.terminologyhub.com

  Performing mapset export to file SNOMEDCT_US-ICD10CM.zip
-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  5:01:24 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="get-concept-mappings-by-code" />Get concept mappings by code - find-mappings.sh

Return concept mappings for a given terminology and code.  This resolves
mappings that originate "from" this concept code and contains information about
the concepts those mappings point "to" on the other side.  The following example gets
mappings for the 73211009 | Diabetes mellitus | concept in SNOMEDCT.

```
$ ./get-concept-mappings.sh sandbox SNOMEDCT_US 73211009 --token $token
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  5:34:01 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT_US
code = 73211009

  Get concept mappings for SNOMEDCT_US 73211009:

    [
      {
        "id": "f012f377-2d76-408e-a107-66378e26fc46",
        "confidence": 29.986011505126953,
        "modified": "2024-08-23T18:59:26.845+00:00",
        "created": "2024-08-23T18:59:26.845+00:00",
        "modifiedBy": "loader",
        "local": false,
        "active": true,
        "terminology": "SNOMEDCT_US",
        "version": "20240301",
        "publisher": "SANDBOX",
        "componentId": "48160c75-415b-5ead-8160-f215b8274218",
        "mapset": {
          "local": false,
          "active": true,
          "abbreviation": "SNOMEDCT_US-ICD10CM",
          "version": "20240301",
          "publisher": "SANDBOX",
          "code": "6011000124106"
        },
        "from": {
          "local": false,
          "active": true,
          "name": "Diabetes mellitus",
          "code": "73211009",
          "terminology": "SNOMEDCT_US",
          "version": "20240301",
          "publisher": "SANDBOX",
          "leaf": true,
          "defined": false
        },
        "to": {
          "local": false,
          "active": true,
          "name": "Type 1 diabetes mellitus without complications",
          "code": "E10.9",
          "terminology": "ICD10CM",
          "version": "2023",
          "publisher": "SANDBOX",
          "leaf": true
        },
        "group": "1",
        "priority": "1",
        "rule": "IFA 445518008 | Age at onset of clinical finding (observable entity) | >= 1.0 year AND IFA 445518008 | Age at onset of clinical finding (observable entity) | < 18.0 years",
        "advice": [
          "IF AGE AT ONSET OF CLINICAL FINDING ON OR AFTER 1.0 YEAR AND IF AGE AT ONSET OF CLINICAL FINDING BEFORE 18.0 YEARS CHOOSE E10.9",
          "DESCENDANTS NOT EXHAUSTIVELY MAPPED",
          "MAP OF SOURCE CONCEPT IS CONTEXT DEPENDENT"
        ]
      },
      {
        "id": "8e05c2bd-7f77-4cd1-9edd-1c4185d2e818",
        "confidence": 29.986011505126953,
        "modified": "2024-08-23T18:59:26.844+00:00",
        "created": "2024-08-23T18:59:26.844+00:00",
        "modifiedBy": "loader",
        "local": false,
        "active": true,
        "terminology": "SNOMEDCT_US",
        "version": "20240301",
        "publisher": "SANDBOX",
        "componentId": "e32ce76e-74df-504f-9a21-03e528c5e7d7",
        "mapset": {
          "local": false,
          "active": true,
          "abbreviation": "SNOMEDCT_US-ICD10CM",
          "version": "20240301",
          "publisher": "SANDBOX",
          "code": "6011000124106"
        },
        "from": {
          "local": false,
          "active": true,
          "name": "Diabetes mellitus",
          "code": "73211009",
          "terminology": "SNOMEDCT_US",
          "version": "20240301",
          "publisher": "SANDBOX",
          "leaf": true,
          "defined": false
        },
        "to": {
          "local": false,
          "active": true,
          "name": "Type 2 diabetes mellitus without complications",
          "code": "E11.9",
          "terminology": "ICD10CM",
          "version": "2023",
          "publisher": "SANDBOX",
          "leaf": true
        },
        "group": "1",
        "priority": "2",
        "rule": "OTHERWISE TRUE",
        "advice": [
          "ALWAYS E11.9",
          "CONSIDER ADDITIONAL CODE TO IDENTIFY SPECIFIC CONDITION OR DISEASE",
          "DESCENDANTS NOT EXHAUSTIVELY MAPPED"
        ]
      }
    ]

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  5:34:02 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="find-project-mapset-mappings" />Find project mappings for mapset - find-mappings.sh

Return mappings matching a given text search. The following example
performs a text search in the "to" concept name for "diabetes" and limits search results to 5
entries.  It searches across all mapsets in the project.

```
$ ./find-mappings.sh sandbox "to.name:diabetes"  --token $token --limit 5
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  5:04:33 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
project = sandbox
mapset =
query = to.name:diabetes
offset = 0
limit = 5
sort =
ascending =

  Find mappings: to.name:diabetes

    {
      "total": 2,
      "parameters": {
        "query": "to.name:diabetes",
        "limit": 5,
        "offset": 0
      },
      "items": [
        {
          "id": "f012f377-2d76-408e-a107-66378e26fc46",
          "confidence": 14.933408737182617,
          "modified": "2024-08-23T18:59:26.845+00:00",
          "created": "2024-08-23T18:59:26.845+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT_US",
          "version": "20240301",
          "publisher": "SANDBOX",
          "componentId": "48160c75-415b-5ead-8160-f215b8274218",
          "mapset": {
            "local": false,
            "active": true,
            "abbreviation": "SNOMEDCT_US-ICD10CM",
            "version": "20240301",
            "publisher": "SANDBOX",
            "code": "6011000124106"
          },
          "from": {
            "local": false,
            "active": true,
            "name": "Diabetes mellitus",
            "code": "73211009",
            "terminology": "SNOMEDCT_US",
            "version": "20240301",
            "publisher": "SANDBOX",
            "leaf": true,
            "defined": false
          },
          "to": {
            "local": false,
            "active": true,
            "name": "Type 1 diabetes mellitus without complications",
            "code": "E10.9",
            "terminology": "ICD10CM",
            "version": "2023",
            "publisher": "SANDBOX",
            "leaf": true
          },
          "group": "1",
          "priority": "1",
          "rule": "IFA 445518008 | Age at onset of clinical finding (observable entity) | >= 1.0 year AND IFA 445518008 | Age at onset of clinical finding (observable entity) | < 18.0 years",
          "advice": [
            "IF AGE AT ONSET OF CLINICAL FINDING ON OR AFTER 1.0 YEAR AND IF AGE AT ONSET OF CLINICAL FINDING BEFORE 18.0 YEARS CHOOSE E10.9",
            "DESCENDANTS NOT EXHAUSTIVELY MAPPED",
            "MAP OF SOURCE CONCEPT IS CONTEXT DEPENDENT"
          ]
        },
        {
          "id": "8e05c2bd-7f77-4cd1-9edd-1c4185d2e818",
          "confidence": 14.933408737182617,
          "modified": "2024-08-23T18:59:26.844+00:00",
          "created": "2024-08-23T18:59:26.844+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT_US",
          "version": "20240301",
          "publisher": "SANDBOX",
          "componentId": "e32ce76e-74df-504f-9a21-03e528c5e7d7",
          "mapset": {
            "local": false,
            "active": true,
            "abbreviation": "SNOMEDCT_US-ICD10CM",
            "version": "20240301",
            "publisher": "SANDBOX",
            "code": "6011000124106"
          },
          "from": {
            "local": false,
            "active": true,
            "name": "Diabetes mellitus",
            "code": "73211009",
            "terminology": "SNOMEDCT_US",
            "version": "20240301",
            "publisher": "SANDBOX",
            "leaf": true,
            "defined": false
          },
          "to": {
            "local": false,
            "active": true,
            "name": "Type 2 diabetes mellitus without complications",
            "code": "E11.9",
            "terminology": "ICD10CM",
            "version": "2023",
            "publisher": "SANDBOX",
            "leaf": true
          },
          "group": "1",
          "priority": "2",
          "rule": "OTHERWISE TRUE",
          "advice": [
            "ALWAYS E11.9",
            "CONSIDER ADDITIONAL CODE TO IDENTIFY SPECIFIC CONDITION OR DISEASE",
            "DESCENDANTS NOT EXHAUSTIVELY MAPPED"
          ]
        }
      ]
    }

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  5:04:33 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="find-project-mapset-mappings" />Find project mappings for mapset - find-mappings.sh

Return mappings matching a given text search for a given mapset. The following example
performs a text search in the "to" concept name for "diabetes" and limits search results to 5
entries.  It searches only within the SNOMEDCT_US-ICD10CM mapset in the specified project.

```
$ ./find-mappings.sh sandbox to.name:diabetes --mapset SNOMEDCT_US-ICD10CM --token $token
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  5:08:10 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
project = sandbox
mapset = SNOMEDCT_US-ICD10CM
query = to.name:diabetes
offset = 0
limit = 10
sort =
ascending =

  Find mappings: to.name:diabetes

    {
      "total": 2,
      "parameters": {
        "query": "to.name:diabetes",
        "limit": 10,
        "offset": 0
      },
      "items": [
        {
          "id": "f012f377-2d76-408e-a107-66378e26fc46",
          "confidence": 14.933408737182617,
          "modified": "2024-08-23T18:59:26.845+00:00",
          "created": "2024-08-23T18:59:26.845+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT_US",
          "version": "20240301",
          "publisher": "SANDBOX",
          "componentId": "48160c75-415b-5ead-8160-f215b8274218",
          "mapset": {
            "local": false,
            "active": true,
            "abbreviation": "SNOMEDCT_US-ICD10CM",
            "version": "20240301",
            "publisher": "SANDBOX",
            "code": "6011000124106"
          },
          "from": {
            "local": false,
            "active": true,
            "name": "Diabetes mellitus",
            "code": "73211009",
            "terminology": "SNOMEDCT_US",
            "version": "20240301",
            "publisher": "SANDBOX",
            "leaf": true,
            "defined": false
          },
          "to": {
            "local": false,
            "active": true,
            "name": "Type 1 diabetes mellitus without complications",
            "code": "E10.9",
            "terminology": "ICD10CM",
            "version": "2023",
            "publisher": "SANDBOX",
            "leaf": true
          },
          "group": "1",
          "priority": "1",
          "rule": "IFA 445518008 | Age at onset of clinical finding (observable entity) | >= 1.0 year AND IFA 445518008 | Age at onset of clinical finding (observable entity) | < 18.0 years",
          "advice": [
            "IF AGE AT ONSET OF CLINICAL FINDING ON OR AFTER 1.0 YEAR AND IF AGE AT ONSET OF CLINICAL FINDING BEFORE 18.0 YEARS CHOOSE E10.9",
            "DESCENDANTS NOT EXHAUSTIVELY MAPPED",
            "MAP OF SOURCE CONCEPT IS CONTEXT DEPENDENT"
          ]
        },
        {
          "id": "8e05c2bd-7f77-4cd1-9edd-1c4185d2e818",
          "confidence": 14.933408737182617,
          "modified": "2024-08-23T18:59:26.844+00:00",
          "created": "2024-08-23T18:59:26.844+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT_US",
          "version": "20240301",
          "publisher": "SANDBOX",
          "componentId": "e32ce76e-74df-504f-9a21-03e528c5e7d7",
          "mapset": {
            "local": false,
            "active": true,
            "abbreviation": "SNOMEDCT_US-ICD10CM",
            "version": "20240301",
            "publisher": "SANDBOX",
            "code": "6011000124106"
          },
          "from": {
            "local": false,
            "active": true,
            "name": "Diabetes mellitus",
            "code": "73211009",
            "terminology": "SNOMEDCT_US",
            "version": "20240301",
            "publisher": "SANDBOX",
            "leaf": true,
            "defined": false
          },
          "to": {
            "local": false,
            "active": true,
            "name": "Type 2 diabetes mellitus without complications",
            "code": "E11.9",
            "terminology": "ICD10CM",
            "version": "2023",
            "publisher": "SANDBOX",
            "leaf": true
          },
          "group": "1",
          "priority": "2",
          "rule": "OTHERWISE TRUE",
          "advice": [
            "ALWAYS E11.9",
            "CONSIDER ADDITIONAL CODE TO IDENTIFY SPECIFIC CONDITION OR DISEASE",
            "DESCENDANTS NOT EXHAUSTIVELY MAPPED"
          ]
        }
      ]
    }

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  5:08:10 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)

### <a id="find-project-mappings" />Find project mappings - find-mappings.sh

Return mappings matching a given text search for a given mapset. The following example
performs a text search in the "to" concept name for "diabetes" and limits search results to 5
entries. It searches across all mapsets in the project.  It produces the same results as
the previous call because this is the only mapset configured in the sandbox project.

```
$ ./find-mappings.sh sandbox "to.name:diabetes"  --token $token --limit 5
-----------------------------------------------------
Starting ...Mon, Aug 26, 2024  5:08:41 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
project = sandbox
mapset =
query = to.name:diabetes
offset = 0
limit = 5
sort =
ascending =

  Find mappings: to.name:diabetes

    {
      "total": 2,
      "parameters": {
        "query": "to.name:diabetes",
        "limit": 5,
        "offset": 0
      },
      "items": [
        {
          "id": "f012f377-2d76-408e-a107-66378e26fc46",
          "confidence": 14.933408737182617,
          "modified": "2024-08-23T18:59:26.845+00:00",
          "created": "2024-08-23T18:59:26.845+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT_US",
          "version": "20240301",
          "publisher": "SANDBOX",
          "componentId": "48160c75-415b-5ead-8160-f215b8274218",
          "mapset": {
            "local": false,
            "active": true,
            "abbreviation": "SNOMEDCT_US-ICD10CM",
            "version": "20240301",
            "publisher": "SANDBOX",
            "code": "6011000124106"
          },
          "from": {
            "local": false,
            "active": true,
            "name": "Diabetes mellitus",
            "code": "73211009",
            "terminology": "SNOMEDCT_US",
            "version": "20240301",
            "publisher": "SANDBOX",
            "leaf": true,
            "defined": false
          },
          "to": {
            "local": false,
            "active": true,
            "name": "Type 1 diabetes mellitus without complications",
            "code": "E10.9",
            "terminology": "ICD10CM",
            "version": "2023",
            "publisher": "SANDBOX",
            "leaf": true
          },
          "group": "1",
          "priority": "1",
          "rule": "IFA 445518008 | Age at onset of clinical finding (observable entity) | >= 1.0 year AND IFA 445518008 | Age at onset of clinical finding (observable entity) | < 18.0 years",
          "advice": [
            "IF AGE AT ONSET OF CLINICAL FINDING ON OR AFTER 1.0 YEAR AND IF AGE AT ONSET OF CLINICAL FINDING BEFORE 18.0 YEARS CHOOSE E10.9",
            "DESCENDANTS NOT EXHAUSTIVELY MAPPED",
            "MAP OF SOURCE CONCEPT IS CONTEXT DEPENDENT"
          ]
        },
        {
          "id": "8e05c2bd-7f77-4cd1-9edd-1c4185d2e818",
          "confidence": 14.933408737182617,
          "modified": "2024-08-23T18:59:26.844+00:00",
          "created": "2024-08-23T18:59:26.844+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT_US",
          "version": "20240301",
          "publisher": "SANDBOX",
          "componentId": "e32ce76e-74df-504f-9a21-03e528c5e7d7",
          "mapset": {
            "local": false,
            "active": true,
            "abbreviation": "SNOMEDCT_US-ICD10CM",
            "version": "20240301",
            "publisher": "SANDBOX",
            "code": "6011000124106"
          },
          "from": {
            "local": false,
            "active": true,
            "name": "Diabetes mellitus",
            "code": "73211009",
            "terminology": "SNOMEDCT_US",
            "version": "20240301",
            "publisher": "SANDBOX",
            "leaf": true,
            "defined": false
          },
          "to": {
            "local": false,
            "active": true,
            "name": "Type 2 diabetes mellitus without complications",
            "code": "E11.9",
            "terminology": "ICD10CM",
            "version": "2023",
            "publisher": "SANDBOX",
            "leaf": true
          },
          "group": "1",
          "priority": "2",
          "rule": "OTHERWISE TRUE",
          "advice": [
            "ALWAYS E11.9",
            "CONSIDER ADDITIONAL CODE TO IDENTIFY SPECIFIC CONDITION OR DISEASE",
            "DESCENDANTS NOT EXHAUSTIVELY MAPPED"
          ]
        }
      ]
    }

-----------------------------------------------------
Finished ...Mon, Aug 26, 2024  5:08:41 PM
-----------------------------------------------------
```

[Back to Top](#termhub-in-5-minutes-bash-tutorial)
