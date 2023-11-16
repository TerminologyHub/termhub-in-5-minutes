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

The following examples can be typed into the command line of any terminal that has bash, cURL and jq installed.  Run each script with no parameters for examples of how to call each one.

### login.sh

Login to TermHub via username and password.
When finished, copy/past the "token=..." to set a local variable that
can be easily used for further calls.

NOTE: for instances of the server that have login disabled, simply use "guest" as the token.

```
$ ./login.sh $username $password
-----------------------------------------------------
Starting ...Thu, Nov 16, 2023  8:57:24 AM
-----------------------------------------------------
url = https://api.terminologyhub.com
username = bcarlsen@westcoastinformatics.com
password = ************

  token=eyJ0eXAiOiJKV1QiLCJhbGciO...BpLSufu1w4ajDk

-----------------------------------------------------
Finished ...Thu, Nov 16, 2023  8:57:25 AM
-----------------------------------------------------
```

From the output, paste the "token=..." into your shell to set it as a variable for the following calls.

[Back to Top](#top)

<a name="get-terminologies-sh"/>

### get-terminologies.sh

Return all loaded terminologies currently hosted by the API.

```
$ ./get-terminologies.sh --token $token
-----------------------------------------------------
Starting ...Thu, Nov 16, 2023  8:58:33 AM
-----------------------------------------------------
url = https://api.terminologyhub.com
offset = 0
limit = 10
sort = 
ascending = 

  Performing terminologies lookup
    {
      "total": 37,
      "parameters": {
        "query": "loaded:true",
        "limit": 10,
        "offset": 0
      },
      "items": [
        {
          "id": "210dae53-7c62-48ba-8693-3da09b86b8fb",
          "confidence": 0.011696039699018002,
          "modified": "2023-10-23T19:29:45.812+00:00",
          "created": "2023-10-23T19:29:45.812+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "abbreviation": "ICD9CM",
          "name": "International Classification of Diseases, Ninth Revision, Clinical Modification, 2014",
          "version": "2014",
          "publisher": "NLM",
          "latest": true,
          "loaded": true,
          "releaseDate": "2023-05-01",
          "family": "ICD9CM",
          "attributes": {
            "fhirUri": "http://hl7.org/fhir/sid/icd-9-cm",
            "origin-version": "2023AA",
            "hierarchical": "true",
            "fhirVersion": "2014",
            "tree-positions": "true",
            "origin-terminology": "UMLS",
            "ecl": "true",
            "fhirId": "icd9cm_2014"
          },
          "roots": [
            "00-99.99",
            "E000-E999.9",
            "V01-V91.99",
            "001-999.99"
          ],
          "conceptCt": 22406,
          "relationshipCt": 44804,
          "treePositionCt": 22406
        },
        ...
        {
          "id": "3b5a1dd4-6d23-4b6c-852f-cce2dd3a58a9",
          "confidence": 0.011696039699018002,
          "modified": "2023-10-25T03:36:45.064+00:00",
          "created": "2023-10-25T03:36:45.064+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "abbreviation": "SNOMEDCT",
          "name": "Systematized Nomenclature of Medicine–Clinical Terminology",
          "version": "20220731",
          "publisher": "NLM",
          "latest": false,
          "loaded": true,
          "releaseDate": "2022-07-31",
          "family": "SNOMEDCT",
          "attributes": {
            "description-logic-profile": "EL++",
            "fhirUri": "http://snomed.info/sct",
            "polyhierarchy": "true",
            "hierarchical": "true",
            "fhirVersion": "http://snomed.info/sct/900000000000207008/version/20220731",
            "description-logic-based": "true",
            "tree-positions": "true",
            "unidirectional-rels": "true",
            "ecl": "true",
            "fhirId": "snomedct_900000000000207008_20220731"
          },
          "roots": [
            "138875005"
          ],
          "conceptCt": 495637,
          "relationshipCt": 1202507,
          "treePositionCt": 11966066
        }
      ]
    }

-----------------------------------------------------
Finished ...Thu, Nov 16, 2023  8:58:34 AM
-----------------------------------------------------
```

[Back to Top](#top)

<a name="get-project-terminologies-sh"/>

### get-terminologies.sh

Return all terminologies for specific project identified by either project id or project uriLabel.

```
$ ./get-terminology.sh --token $token --project sandbox
-----------------------------------------------------
Starting ...Thu, Nov 16, 2023  9:00:13 AM
-----------------------------------------------------
url = https://api.terminologyhub.com

  Performing terminologies lookup
    count = 4

    [
      {
        "id": "13b52fe9-3260-4115-b321-0c1d07e1677f",
        "confidence": 4.478757858276367,
        "modified": "2023-10-21T18:10:54.214+00:00",
        "created": "2023-10-21T18:10:54.214+00:00",
        "modifiedBy": "loader",
        "local": false,
        "active": true,
        "abbreviation": "ICD10CM",
        "name": "International Classification of Diseases, 10th Edition, Clinical Modification, 2023",
        "version": "2023",
        "publisher": "SANDBOX",
        "latest": true,
        "loaded": true,
        "releaseDate": "2022-11-07",
        "family": "ICD10CM",
        "indexName": "icd10cm-sandbox-2023",
        "attributes": {
          "fhirUri": "http://hl7.org/fhir/sid/icd-10-cm",
          "origin-version": "2022AB",
          "hierarchical": "true",
          "fhirVersion": "2023",
          "tree-positions": "true",
          "origin-terminology": "UMLS",
          "ecl": "true",
          "fhirId": "icd10cm_2023"
        },
        "roots": [
          "ICD-10-CM"
        ],
        "conceptCt": 6,
        "relationshipCt": 10,
        "treePositionCt": 6
      },
      ...
      {
        "id": "573d0360-3d48-4a43-a657-31372bac2fec",
        "confidence": 4.478757858276367,
        "modified": "2023-10-21T18:05:26.552+00:00",
        "created": "2023-10-21T18:05:26.552+00:00",
        "modifiedBy": "loader",
        "local": false,
        "active": true,
        "abbreviation": "SNOMEDCT",
        "name": "Systematized Nomenclature of Medicine–Clinical Terminology",
        "version": "20230731",
        "publisher": "SANDBOX",
        "latest": true,
        "loaded": true,
        "releaseDate": "2023-07-31",
        "family": "SNOMEDCT",
        "indexName": "snomedct-sandbox-20230731",
        "attributes": {
          "description-logic-profile": "EL++",
          "fhirUri": "http://snomed.info/sct",
          "polyhierarchy": "true",
          "hierarchical": "true",
          "fhirVersion": "http://snomed.info/sct/900000000000207008/version/20230731",
          "description-logic-based": "true",
          "tree-positions": "true",
          "unidirectional-rels": "true",
          "ecl": "true",
          "fhirId": "snomedct_900000000000207008_20230731"
        },
        "roots": [
          "138875005"
        ],
        "conceptCt": 409,
        "relationshipCt": 666,
        "treePositionCt": 1997
      }
    ]

-----------------------------------------------------
Finished ...Thu, Nov 16, 2023  9:00:14 AM
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
$ ./get-terminology.sh --token $token --id 573d0360-3d48-4a43-a657-31372bac2fec
-----------------------------------------------------
Starting ...Thu, Nov 16, 2023  9:02:57 AM
-----------------------------------------------------
url = https://api.terminologyhub.com

  Performing terminologies lookup
    count = 20

    {
      "id": "573d0360-3d48-4a43-a657-31372bac2fec",
      "confidence": 4.040700912475586,
      "modified": "2023-10-21T18:05:26.552+00:00",
      "created": "2023-10-21T18:05:26.552+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "abbreviation": "SNOMEDCT",
      "name": "Systematized Nomenclature of Medicine–Clinical Terminology",
      "version": "20230731",
      "publisher": "SANDBOX",
      "latest": true,
      "loaded": true,
      "releaseDate": "2023-07-31",
      "family": "SNOMEDCT",
      "attributes": {
        "description-logic-profile": "EL++",
        "fhirUri": "http://snomed.info/sct",
        "polyhierarchy": "true",
        "hierarchical": "true",
        "fhirVersion": "http://snomed.info/sct/900000000000207008/version/20230731",
        "description-logic-based": "true",
        "tree-positions": "true",
        "unidirectional-rels": "true",
        "ecl": "true",
        "fhirId": "snomedct_900000000000207008_20230731"
      },
      "roots": [
        "138875005"
      ],
      "conceptCt": 409,
      "relationshipCt": 666,
      "treePositionCt": 1997
    }

-----------------------------------------------------
Finished ...Thu, Nov 16, 2023  9:02:58 AM
-----------------------------------------------------
```

[Back to Top](#top)

<a name="export-terminology-sh"/>

### export-terminology.sh

Exports a terminology for the given project id (or uriLabel) and terminology

```
$ ./export-terminology.sh --token $token sandbox SNOMEDCT
-----------------------------------------------------
Starting ...Thu, Nov 16, 2023  9:06:14 AM
-----------------------------------------------------
url = https://api.terminologyhub.com

  Performing terminology export to file SNOMEDCT.zip
-----------------------------------------------------
Finished ...Thu, Nov 16, 2023  9:06:17 AM
-----------------------------------------------------
```

[Back to Top](#top)

<a name="get-concept-sh"/>

### get-concept.sh

Return summary concept information for a given terminology and code. The following example gets the 73211009 | Diabetes mellitus | concept in SNOMEDCT.

```
$ ./get-concept.sh sandbox SNOMEDCT 73211009 --token $token
-----------------------------------------------------
Starting ...Thu, Nov 16, 2023  9:08:02 AM
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
project= sandbox
code = 73211009

  Get concept for SNOMEDCT 73211009:

    {
      "id": "918434c6-9397-4120-b252-e8abecacd3ee",
      "confidence": 5.953243255615234,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Diabetes mellitus",
      "code": "73211009",
      "terminology": "SNOMEDCT",
      "version": "20230731",
      "publisher": "SANDBOX",
      "leaf": true,
      "defined": false,
      "terms": [
        {
          "id": "554ddced-a5b0-49c9-a895-ae103ca15c20",
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": false,
          "name": "Diabetes mellitus, NOS",
          "normName": "diabetes mellitus nos",
          "stemName": "diabet mellitus nos",
          "wordCt": 3,
          "terminology": "SNOMEDCT",
          "version": "20230731",
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
          "id": "56b6f00a-acd6-43d2-a3b2-329fc6239786",
          "modified": "2017-07-31T00:00:00.000+00:00",
          "created": "2017-07-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Diabetes mellitus",
          "normName": "diabetes mellitus",
          "stemName": "diabet mellitus",
          "wordCt": 2,
          "terminology": "SNOMEDCT",
          "version": "20230731",
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
          "id": "c39ce2eb-fceb-4644-84d1-b06c3b38e822",
          "modified": "2017-07-31T00:00:00.000+00:00",
          "created": "2017-07-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Diabetes mellitus (disorder)",
          "normName": "diabetes mellitus disorder",
          "stemName": "diabet mellitus disord",
          "wordCt": 3,
          "terminology": "SNOMEDCT",
          "version": "20230731",
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
        },
        {
          "id": "a3c954d0-8b2a-4e49-ab1e-a089169ebb6f",
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "DM - Diabetes mellitus",
          "normName": "dm diabetes mellitus",
          "stemName": "dm diabet mellitus",
          "wordCt": 3,
          "terminology": "SNOMEDCT",
          "version": "20230731",
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
Finished ...Thu, Nov 16, 2023  9:08:03 AM
-----------------------------------------------------
```

[Back to Top](#top)

<a name="get-concept-relationships-sh"/>

### get-concept-relationships.sh

Get concept relationships for a terminology and code. In this case it resolves
relationships that originate "from" this concept code and contain information about
the concepts those relationships point "to" on the other side.

```
$ ./get-concept-relationships.sh sandbox SNOMEDCT 73211009 --token $token 
-----------------------------------------------------
Starting ...Thu, Nov 16, 2023  9:08:27 AM
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
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
          "id": "2569d6b8-9e5d-4b8c-86f9-9df9e0b84110",
          "confidence": 6.250777244567871,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "SANDBOX",
          "componentId": "267149027",
          "type": "Is a",
          "additionalType": "116680003",
          "from": {
            "id": "918434c6-9397-4120-b252-e8abecacd3ee",
            "modified": "2002-01-31T00:00:00.000+00:00",
            "created": "2002-01-31T00:00:00.000+00:00",
            "modifiedBy": "loader",
            "local": false,
            "active": true,
            "name": "Diabetes mellitus",
            "code": "73211009",
            "terminology": "SNOMEDCT",
            "version": "20230731",
            "publisher": "SANDBOX",
            "leaf": false
          },
          "to": {
            "id": "a59b3858-803d-4947-8dc0-d2809c1f1e07",
            "modified": "2002-01-31T00:00:00.000+00:00",
            "created": "2002-01-31T00:00:00.000+00:00",
            "modifiedBy": "loader",
            "local": false,
            "active": true,
            "name": "Disorder of glucose metabolism",
            "code": "126877002",
            "terminology": "SNOMEDCT",
            "version": "20230731",
            "publisher": "SANDBOX",
            "leaf": false
          },
          "hierarchical": true,
          "asserted": true,
          "defining": true,
          "group": "0"
        },
        {
          "id": "73ceb387-95a5-43f0-bfe4-770267f737bc",
          "confidence": 6.250777244567871,
          "modified": "2012-01-31T00:00:00.000+00:00",
          "created": "2012-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "SANDBOX",
          "componentId": "4601709020",
          "type": "Is a",
          "additionalType": "116680003",
          "from": {
            "id": "918434c6-9397-4120-b252-e8abecacd3ee",
            "modified": "2002-01-31T00:00:00.000+00:00",
            "created": "2002-01-31T00:00:00.000+00:00",
            "modifiedBy": "loader",
            "local": false,
            "active": true,
            "name": "Diabetes mellitus",
            "code": "73211009",
            "terminology": "SNOMEDCT",
            "version": "20230731",
            "publisher": "SANDBOX",
            "leaf": false
          },
          "to": {
            "id": "7314a223-234c-4345-ac8b-87845c66f54b",
            "modified": "2002-01-31T00:00:00.000+00:00",
            "created": "2002-01-31T00:00:00.000+00:00",
            "modifiedBy": "loader",
            "local": false,
            "active": true,
            "name": "Disorder of endocrine system",
            "code": "362969004",
            "terminology": "SNOMEDCT",
            "version": "20230731",
            "publisher": "SANDBOX",
            "leaf": false
          },
          "hierarchical": true,
          "asserted": true,
          "defining": true,
          "group": "0"
        },
        {
          "id": "8491f354-5021-493b-b89d-884251669307",
          "confidence": 6.250777244567871,
          "modified": "2019-07-31T00:00:00.000+00:00",
          "created": "2019-07-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "SANDBOX",
          "componentId": "4601710026",
          "type": "other",
          "additionalType": "363698007",
          "from": {
            "id": "918434c6-9397-4120-b252-e8abecacd3ee",
            "modified": "2002-01-31T00:00:00.000+00:00",
            "created": "2002-01-31T00:00:00.000+00:00",
            "modifiedBy": "loader",
            "local": false,
            "active": true,
            "name": "Diabetes mellitus",
            "code": "73211009",
            "terminology": "SNOMEDCT",
            "version": "20230731",
            "publisher": "SANDBOX",
            "leaf": false
          },
          "to": {
            "id": "535af1a8-9b61-4d4e-8e6e-c99d4ec8d3bc",
            "modified": "2002-01-31T00:00:00.000+00:00",
            "created": "2002-01-31T00:00:00.000+00:00",
            "modifiedBy": "loader",
            "local": false,
            "active": true,
            "name": "Structure of endocrine system",
            "code": "113331007",
            "terminology": "SNOMEDCT",
            "version": "20230731",
            "publisher": "SANDBOX",
            "leaf": false
          },
          "hierarchical": false,
          "asserted": true,
          "defining": true,
          "group": "1"
        }
      ]
    }

-----------------------------------------------------
Finished ...Thu, Nov 16, 2023  9:08:28 AM
-----------------------------------------------------
```

[Back to Top](#top)

<a name="get-concept-treepos-sh"/>

### get-concept-treepos.sh

Return tree position information for a given terminology and code. The 
following example finds relationships for the 73211009 | Diabetes mellitus | concept in 
SNOMEDCT.  It limits the results to 5 entries and sorts by the "additionalType"
field.

```
$ ./get-concept-treepos.sh sandbox SNOMEDCT 73211009 --token $token
-----------------------------------------------------
Starting ...Thu, Nov 16, 2023  9:08:53 AM
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
          "id": "aa75a9e5-0472-439f-b322-d0dd7540cb7d",
          "confidence": 14.389875411987305,
          "modified": "2023-10-21T18:05:43.071+00:00",
          "created": "2023-10-21T18:05:43.071+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "SANDBOX",
          "concept": {
            "id": "efeed558-5cc1-45e9-972d-2278b814a333",
            "local": false,
            "active": true,
            "name": "SNOMED CT Concept",
            "code": "138875005",
            "leaf": false
          },
          "additionalType": "116680003",
          "childCt": 7,
          "children": [
            {
              "id": "e7fc5683-62dc-4184-a084-c4cf65f090d8",
              "confidence": 12.780436515808105,
              "modified": "2023-10-21T18:05:43.086+00:00",
              "created": "2023-10-21T18:05:43.086+00:00",
              "modifiedBy": "loader",
              "local": false,
              "active": true,
              "terminology": "SNOMEDCT",
              "version": "20230731",
              "publisher": "SANDBOX",
              "concept": {
                "id": "4868432a-9e56-47e7-8c3e-d24ad9b8996a",
                "local": false,
                "active": true,
                "name": "Clinical finding",
                "code": "404684003",
                "leaf": false
              },
              "additionalType": "116680003",
              "ancestorPath": "138875005",
              "childCt": 4,
              "children": [
                {
                  "id": "5e7adc17-cb5b-4133-a856-b4e74be4f171",
                  "confidence": 13.29126262664795,
                  "modified": "2023-10-21T18:05:43.087+00:00",
                  "created": "2023-10-21T18:05:43.087+00:00",
                  "modifiedBy": "loader",
                  "local": false,
                  "active": true,
                  "terminology": "SNOMEDCT",
                  "version": "20230731",
                  "publisher": "SANDBOX",
                  "concept": {
                    "id": "076d8ac2-cd28-441f-a427-356defa18388",
                    "local": false,
                    "active": true,
                    "name": "Disease",
                    "code": "64572001",
                    "leaf": false
                  },
                  "additionalType": "116680003",
                  "ancestorPath": "138875005~404684003",
                  "childCt": 5,
                  "children": [
                    {
                      "id": "57f32dac-d0eb-46e4-8416-4d96244dc253",
                      "confidence": 13.090592384338379,
                      "modified": "2023-10-21T18:05:43.087+00:00",
                      "created": "2023-10-21T18:05:43.087+00:00",
                      "modifiedBy": "loader",
                      "local": false,
                      "active": true,
                      "terminology": "SNOMEDCT",
                      "version": "20230731",
                      "publisher": "SANDBOX",
                      "concept": {
                        "id": "dab44a94-cf2b-47ad-a014-9821393bff3c",
                        "local": false,
                        "active": true,
                        "name": "Disorder of body system",
                        "code": "362965005",
                        "leaf": false
                      },
                      "additionalType": "116680003",
                      "ancestorPath": "138875005~404684003~64572001",
                      "childCt": 3,
                      "children": [
                        {
                          "id": "df76fa79-929a-4a90-9046-8f3306678a68",
                          "confidence": 13.542576789855957,
                          "modified": "2023-10-21T18:05:43.087+00:00",
                          "created": "2023-10-21T18:05:43.087+00:00",
                          "modifiedBy": "loader",
                          "local": false,
                          "active": true,
                          "terminology": "SNOMEDCT",
                          "version": "20230731",
                          "publisher": "SANDBOX",
                          "concept": {
                            "id": "7314a223-234c-4345-ac8b-87845c66f54b",
                            "local": false,
                            "active": true,
                            "name": "Disorder of endocrine system",
                            "code": "362969004",
                            "leaf": false
                          },
                          "additionalType": "116680003",
                          "ancestorPath": "138875005~404684003~64572001~362965005",
                          "childCt": 1,
                          "children": [
                            {
                              "id": "9413f7a3-07fe-4dbd-9fc3-e1e519ff14c7",
                              "confidence": 13.879049301147461,
                              "modified": "2023-10-21T18:05:43.087+00:00",
                              "created": "2023-10-21T18:05:43.087+00:00",
                              "modifiedBy": "loader",
                              "local": false,
                              "active": true,
                              "terminology": "SNOMEDCT",
                              "version": "20230731",
                              "publisher": "SANDBOX",
                              "concept": {
                                "id": "918434c6-9397-4120-b252-e8abecacd3ee",
                                "local": false,
                                "active": true,
                                "name": "Diabetes mellitus",
                                "code": "73211009",
                                "leaf": true
                              },
                              "additionalType": "116680003",
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
        },
        {
          "id": "aa75a9e5-0472-439f-b322-d0dd7540cb7d",
          "confidence": 14.389875411987305,
          "modified": "2023-10-21T18:05:43.071+00:00",
          "created": "2023-10-21T18:05:43.071+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "SANDBOX",
          "concept": {
            "id": "efeed558-5cc1-45e9-972d-2278b814a333",
            "local": false,
            "active": true,
            "name": "SNOMED CT Concept",
            "code": "138875005",
            "leaf": false
          },
          "additionalType": "116680003",
          "childCt": 7,
          "children": [
            {
              "id": "e7fc5683-62dc-4184-a084-c4cf65f090d8",
              "confidence": 12.780436515808105,
              "modified": "2023-10-21T18:05:43.086+00:00",
              "created": "2023-10-21T18:05:43.086+00:00",
              "modifiedBy": "loader",
              "local": false,
              "active": true,
              "terminology": "SNOMEDCT",
              "version": "20230731",
              "publisher": "SANDBOX",
              "concept": {
                "id": "4868432a-9e56-47e7-8c3e-d24ad9b8996a",
                "local": false,
                "active": true,
                "name": "Clinical finding",
                "code": "404684003",
                "leaf": false
              },
              "additionalType": "116680003",
              "ancestorPath": "138875005",
              "childCt": 4,
              "children": [
                {
                  "id": "5e7adc17-cb5b-4133-a856-b4e74be4f171",
                  "confidence": 13.29126262664795,
                  "modified": "2023-10-21T18:05:43.087+00:00",
                  "created": "2023-10-21T18:05:43.087+00:00",
                  "modifiedBy": "loader",
                  "local": false,
                  "active": true,
                  "terminology": "SNOMEDCT",
                  "version": "20230731",
                  "publisher": "SANDBOX",
                  "concept": {
                    "id": "076d8ac2-cd28-441f-a427-356defa18388",
                    "local": false,
                    "active": true,
                    "name": "Disease",
                    "code": "64572001",
                    "leaf": false
                  },
                  "additionalType": "116680003",
                  "ancestorPath": "138875005~404684003",
                  "childCt": 5,
                  "children": [
                    {
                      "id": "6acf9bc8-2724-4ea7-ad35-94ac7db0b9a2",
                      "confidence": 13.090592384338379,
                      "modified": "2023-10-21T18:05:43.087+00:00",
                      "created": "2023-10-21T18:05:43.087+00:00",
                      "modifiedBy": "loader",
                      "local": false,
                      "active": true,
                      "terminology": "SNOMEDCT",
                      "version": "20230731",
                      "publisher": "SANDBOX",
                      "concept": {
                        "id": "11b6494e-eee2-47ba-8790-50e530ba1d4f",
                        "local": false,
                        "active": true,
                        "name": "Metabolic disease",
                        "code": "75934005",
                        "leaf": false
                      },
                      "additionalType": "116680003",
                      "ancestorPath": "138875005~404684003~64572001",
                      "childCt": 1,
                      "children": [
                        {
                          "id": "73a634e5-0f9b-4c9c-85d4-211a52e33cad",
                          "confidence": 14.389875411987305,
                          "modified": "2023-10-21T18:05:43.087+00:00",
                          "created": "2023-10-21T18:05:43.087+00:00",
                          "modifiedBy": "loader",
                          "local": false,
                          "active": true,
                          "terminology": "SNOMEDCT",
                          "version": "20230731",
                          "publisher": "SANDBOX",
                          "concept": {
                            "id": "a95f2abd-715f-40d5-a5ee-31ba3b45ebea",
                            "local": false,
                            "active": true,
                            "name": "Disorder of carbohydrate metabolism",
                            "code": "20957000",
                            "leaf": false
                          },
                          "additionalType": "116680003",
                          "ancestorPath": "138875005~404684003~64572001~75934005",
                          "childCt": 1,
                          "children": [
                            {
                              "id": "8b090145-9268-4c21-a04a-6bcc9223c9c3",
                              "confidence": 14.389875411987305,
                              "modified": "2023-10-21T18:05:43.087+00:00",
                              "created": "2023-10-21T18:05:43.087+00:00",
                              "modifiedBy": "loader",
                              "local": false,
                              "active": true,
                              "terminology": "SNOMEDCT",
                              "version": "20230731",
                              "publisher": "SANDBOX",
                              "concept": {
                                "id": "a59b3858-803d-4947-8dc0-d2809c1f1e07",
                                "local": false,
                                "active": true,
                                "name": "Disorder of glucose metabolism",
                                "code": "126877002",
                                "leaf": false
                              },
                              "additionalType": "116680003",
                              "ancestorPath": "138875005~404684003~64572001~75934005~20957000",
                              "childCt": 1,
                              "children": [
                                {
                                  "id": "373ec7e9-87f1-49a3-b1e5-ddeab16fb795",
                                  "confidence": 13.879049301147461,
                                  "modified": "2023-10-21T18:05:43.087+00:00",
                                  "created": "2023-10-21T18:05:43.087+00:00",
                                  "modifiedBy": "loader",
                                  "local": false,
                                  "active": true,
                                  "terminology": "SNOMEDCT",
                                  "version": "20230731",
                                  "publisher": "SANDBOX",
                                  "concept": {
                                    "id": "918434c6-9397-4120-b252-e8abecacd3ee",
                                    "local": false,
                                    "active": true,
                                    "name": "Diabetes mellitus",
                                    "code": "73211009",
                                    "leaf": true
                                  },
                                  "additionalType": "116680003",
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
        }
      ]
    }

-----------------------------------------------------
Finished ...Thu, Nov 16, 2023  9:08:54 AM
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
Starting ...Thu, Nov 16, 2023  9:10:38 AM
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
      "total": 1,
      "parameters": {
        "query": "(terminology:SNOMEDCT) AND diabetes mellitus",
        "limit": 5,
        "offset": 0
      },
      "items": [
        {
          "id": "918434c6-9397-4120-b252-e8abecacd3ee",
          "confidence": 17.543197631835938,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Diabetes mellitus",
          "code": "73211009",
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "SANDBOX",
          "leaf": true,
          "defined": false
        }
      ]
    }

-----------------------------------------------------
Finished ...Thu, Nov 16, 2023  9:10:38 AM
-----------------------------------------------------
```

This example performs a search that returns all descendants of the SNOMED
64572001 | Disease | concept that contain the word "system" with a maximum
of 5 results.

```
$ ./find-concepts.sh sandbox SNOMEDCT "system" --expr "<64572001" --token $token --limit 5
-----------------------------------------------------
Starting ...Thu, Nov 16, 2023  9:10:54 AM
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
      "total": 22,
      "parameters": {
        "query": "(terminology:SNOMEDCT) AND system",
        "expression": "<64572001",
        "limit": 5,
        "offset": 0
      },
      "items": [
        {
          "id": "5bbd75ce-447c-4efc-be1c-1b40c76c8a8a",
          "confidence": 8.232234954833984,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Entire cardiovascular system",
          "code": "278198007",
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "SANDBOX",
          "leaf": true,
          "defined": false
        },
        {
          "id": "e4f53e67-dbcb-4201-947d-7fe598151106",
          "confidence": 8.022926330566406,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Structure of cardiovascular system",
          "code": "113257007",
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": false
        },
        {
          "id": "121f5e31-7ece-4fba-9b1b-2d9667a3802d",
          "confidence": 8.005145072937012,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Entire body system",
          "code": "278195005",
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": false
        },
        {
          "id": "085626cc-c01d-4c39-9f79-da50677cd617",
          "confidence": 8.005145072937012,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Body system structure",
          "code": "91689009",
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "SANDBOX",
          "leaf": false,
          "defined": false
        },
        {
          "id": "8e7ce8e2-fd13-445b-9bf3-1923af8b66d8",
          "confidence": 8.005145072937012,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Entire endocrine system",
          "code": "278876000",
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "SANDBOX",
          "leaf": true,
          "defined": false
        }
      ]
    }

-----------------------------------------------------
Finished ...Thu, Nov 16, 2023  9:10:55 AM
-----------------------------------------------------
```

[Back to Top](#top)



