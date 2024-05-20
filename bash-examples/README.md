<a name="top"/>

Termhub in 5 Minutes: bash Tutorial
===================================================

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
- [login.sh](#login-sh)
- [get-terminologies.sh](#get-terminologies-sh)
- [get-project-terminologies.sh](#get-terminologies-sh)
- [get-terminology.sh](#get-terminology-sh)
- [export-terminology.sh](#export-terminology-sh)
- [get-concept.sh](#get-concept-sh)
- [get-concept-relationships.sh](#get-concept-relationships-sh)
- [get-concept-treepos.sh](#get-concept-treepos-sh)
- [find-concepts.sh](#find-concepts-sh)
- [find-terms.sh](#find-terms-sh)
- [autocomplete.sh](#autocomplete-sh)

The following examples can be typed into the command line of any terminal that has bash, cURL and jq installed.  Run each script with no parameters for examples of how to call each one.

### login.sh

Login to TermHub via username and password.
When finished, copy/past the "token=..." to set a local variable that
can be easily used for further calls.

NOTE: for instances of the server that have login disabled, simply use "guest" as the token.

```
./login.sh bcarlsen@westcoastinformatics.com *********
-----------------------------------------------------
Starting ...Thu, May 16, 2024 10:22:49 AM
-----------------------------------------------------
url = https://api.terminologyhub.com
username = bcarlsen@westcoastinformatics.com
password = ************

  token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUz...8UbB49vRoFOEXqUBIa8-0

-----------------------------------------------------
Finished ...Thu, May 16, 2024 10:22:50 AM
-----------------------------------------------------
```

From the output, paste the "token=..." into your shell to set it as a variable for the following calls.

[Back to Top](#top)

<a name="get-terminologies-sh"/>

### get-terminologies.sh

Return all loaded terminologies currently hosted by the API.

```
$ ./get-terminologies.sh --token $token | head -30
-----------------------------------------------------
Starting ...Thu, May 16, 2024  6:31:02 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
offset = 0
limit = 10
sort =
ascending =

  Performing terminologies lookup
    {
      "total": 61,
      "parameters": {
        "query": "loaded:true",
        "limit": 10,
        "offset": 0
      },
      "items": [
        {
          "id": "fda9bef2-df80-40d6-b31b-6cb3a1cd38c3",
          "confidence": 0.007272759452462196,
          "modified": "2024-05-11T20:13:11.499+00:00",
          "created": "2024-05-11T20:13:11.499+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "abbreviation": "SNOMEDCT_US",
          "name": "Systematized Nomenclature of Medicine–Clinical Terminology, US Edition",
          "version": "20230301",
          "publisher": "NLM",...
...
-----------------------------------------------------
Finished ...Thu, May 16, 2024  6:31:03 PM
-----------------------------------------------------
```

[Back to Top](#top)

<a name="get-project-terminologies-sh"/>

### get-terminologies.sh

Return all terminologies for specific project identified by either project id or project uriLabel.

```
$ ./get-terminology.sh --token $token --project sandbox
-----------------------------------------------------
Starting ...Thu, May 16, 2024  6:32:02 PM
-----------------------------------------------------
url = https://api.terminologyhub.com

  Performing terminologies lookup
    count = 5

    [
      {
        "id": "a2bc43ec-ba1b-47c0-9ff0-8379a02f8136",
        "confidence": 6.159998893737793,
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
      ...
      {
        "id": "7ba6a4e7-8d3d-4242-a174-f9883d48a08b",
        "confidence": 7.258610725402832,
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

-----------------------------------------------------
Finished ...Thu, May 16, 2024  6:32:03 PM
-----------------------------------------------------
```

[Back to Top](#top)

<a name="get-terminology-sh"/>

### get-terminology.sh

Return a specific terminology by its terminology id.  The UUID below is an example
that may or may not work.  The idea is to take one of the terminology ids returned
by one of the previous calls and you can then look up terminology info for specifically that
UUID.

```
$ ./get-terminology.sh --token $token --id a2bc43ec-ba1b-47c0-9ff0-8379a02f8136
-----------------------------------------------------
Starting ...Thu, May 16, 2024  6:33:00 PM
-----------------------------------------------------
url = https://api.terminologyhub.com

  Performing terminologies lookup
    count = 18

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

-----------------------------------------------------
Finished ...Thu, May 16, 2024  6:33:02 PM
-----------------------------------------------------
```

[Back to Top](#top)

<a name="export-terminology-sh"/>

### export-terminology.sh

Exports a terminology for the given project id (or uriLabel) and terminology

```
$ ./export-terminology.sh --token $token sandbox SNOMEDCT
-----------------------------------------------------
Starting ...Thu, May 16, 2024  6:33:19 PM
-----------------------------------------------------
url = https://api.terminologyhub.com

  Performing terminology export to file SNOMEDCT.zip
-----------------------------------------------------
Finished ...Thu, May 16, 2024  6:33:22 PM
-----------------------------------------------------
```

[Back to Top](#top)

<a name="get-concept-sh"/>

### get-concept.sh

Return summary concept information for a given terminology and code. The following example gets the 73211009 | Diabetes mellitus | concept in SNOMEDCT.

```
$ ./get-concept.sh sandbox SNOMEDCT 73211009 --token $token
-----------------------------------------------------
Starting ...Thu, May 16, 2024  6:33:36 PM
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
Finished ...Thu, May 16, 2024  6:33:37 PM
-----------------------------------------------------
```

The get-concept.sh script also supports use of the "include" parameter to specify the 
amount of concept data to return. The example below performs the search from the prior
example but brings back only concept info plus parents.  For more information see
[INCLUDE.md](../doc/INCLUDE.md "INCLUDE.md").

```
$ ./get-concept.sh sandbox SNOMEDCT 73211009 --include parents --token $token
-----------------------------------------------------
Starting ...Thu, May 16, 2024  6:34:00 PM
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
Finished ...Thu, May 16, 2024  6:34:01 PM
-----------------------------------------------------
```

[Back to Top](#top)

<a name="get-concept-relationships-sh"/>

### get-concept-relationships.sh

Get concept relationships for a terminology and code. In this case it resolves
relationships that originate "from" this concept code and contains information about
the concepts those relationships point "to" on the other side.

```
$ ./get-concept-relationships.sh sandbox SNOMEDCT 73211009 --token $token
-----------------------------------------------------
Starting ...Thu, May 16, 2024  6:34:14 PM
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
Finished ...Thu, May 16, 2024  6:34:15 PM
-----------------------------------------------------
```

This same script can be used to get inverse concept relationships for a terminology
and code. In this case it resolves relationships that originate "from" another
concept and point "to" this concept code. For this mode, use the `--inverse` parameter.

```
$ ./get-concept-relationships.sh sandbox SNOMEDCT 113331007 --inverse --token $token
-----------------------------------------------------
Starting ...Thu, May 16, 2024  6:34:33 PM
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
Finished ...Thu, May 16, 2024  6:34:34 PM
-----------------------------------------------------
```

[Back to Top](#top)

<a name="get-concept-treepos-sh"/>

### get-concept-treepos.sh

Get concept tree positions for a terminology and code. For classification hierarchies, you would expect to see just a single tree position. But for more complex poly-hierarchies you likely expect to see multiple tree positions - each one with a different path to the root concept.
Return tree position information for a given terminology and code. The 
following example finds relationships for the 73211009 | Diabetes mellitus | concept in 
SNOMEDCT. 


```
$ ./get-concept-treepos.sh sandbox SNOMEDCT 73211009 --token $token
-----------------------------------------------------
Starting ...Thu, May 16, 2024  6:35:02 PM
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
Finished ...Thu, May 16, 2024  6:35:03 PM
-----------------------------------------------------
```

[Back to Top](#top)

<a name="find-concepts-sh"/>

### find-concepts.sh

Used to perform text searches to find matching concepts. The following example
performs a text search for "diabetes mellitus" and limits search results to 5
entries.

```
$ ./find-concepts.sh sandbox SNOMEDCT "diabetes mellitus"  --token $token --limit 5
-----------------------------------------------------
Starting ...Thu, May 16, 2024  6:35:28 PM
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
Finished ...Thu, May 16, 2024  6:35:29 PM
-----------------------------------------------------
```

This example performs a search that returns all descendants of the SNOMED
64572001 | Disease | concept that contain the word "system" with a maximum
of 5 results.

```
$ ./find-concepts.sh sandbox SNOMEDCT "system" --expr "<64572001" --token $token --limit 5
-----------------------------------------------------
Starting ...Thu, May 16, 2024  6:35:47 PM
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
Finished ...Thu, May 16, 2024  6:35:48 PM
-----------------------------------------------------
```

The find-concepts.sh script also supports use of the "include" parameter to specify the 
amount of concept data to return.  The include parameter has a few helpful shortcut values (minimal, summary, full) and also allows you to individually select parts of the full concept model that you are interested in. 

The example below performs the search from the prior
example but brings back concept info plus parents.  For more information see
[INCLUDE.md](../doc/INCLUDE.md "INCLUDE.md").

```
$ ./find-concepts.sh sandbox SNOMEDCT "system" --expr "<64572001" --token $token --limit 5 --include parents
-----------------------------------------------------
Starting ...Thu, May 16, 2024  6:36:03 PM
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

-----------------------------------------------------
Finished ...Thu, May 16, 2024  6:36:05 PM
-----------------------------------------------------
```

[Back to Top](#top)

<a name="find-terms-sh"/>

### find-terms.sh

Used to perform text searches to find terms matching a particular terminology.  
While in many instances it is most useful to directly find concepts with matching 
terms, this call allows users to isolate exactly those terms that resolve from a search.

```
$ ./find-terms.sh sandbox SNOMEDCT diabetes --token $token
-----------------------------------------------------
Starting ...Thu, May 16, 2024  6:36:26 PM
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
Finished ...Thu, May 16, 2024  6:36:27 PM
-----------------------------------------------------
```

[Back to Top](#top)

<a name="autocomplete-sh"/>

### autocomplete.sh

This script demonstrates an autocomplete or typeahead for a user interface feature 
to find potential search terms for a few starting characters.  By default it produces
10 results.

```
$ ./autocomplete.sh sandbox SNOMEDCT diab --token $token
-----------------------------------------------------
Starting ...Thu, May 16, 2024  4:01:54 PM
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
Finished ...Thu, May 16, 2024  4:01:56 PM
-----------------------------------------------------
```

[Back to Top](#top)
