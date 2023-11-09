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
- [get-terminology.sh](#get-terminology-sh)
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
$ ./login.sh username "password"
-----------------------------------------------------
Starting ...Mon, Sep 11, 2023  7:14:20 PM
-----------------------------------------------------
url = https://api.terminologyhub.com
username = bacarlsen@example.com
password = ************

  token=eyJ0eXAi...9U0lwZknkQrug

-----------------------------------------------------
Finished ...Mon, Sep 11, 2023  7:14:21 PM
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
Starting ...Mon, Sep 11, 2023  7:15:45 PM
-----------------------------------------------------
url = https://api.terminologyhub.com

  Performing terminologies lookup
    count = 3

    {
      "total": 33,
      "parameters": {
        "query": "loaded:true",
        "limit": 10,
        "offset": 0
      },
      "items": [
        {
          "id": "7778a80f-8c2b-439b-86fd-955bb6c01d0e",
          "confidence": 0.012578782625496387,
          "modified": "2023-09-03T01:00:49.665+00:00",
          "created": "2023-09-03T01:00:49.665+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "abbreviation": "SNOMEDCT",
          "name": "Systematized Nomenclature of Medicine–Clinical Terminology",
          "version": "20230131",
          "publisher": "NLM",
          "latest": false,
          "loaded": true,
          "family": "SNOMEDCT",
          "releaseDate": "2023-01-31",
          "license": "UNRESTRICTED",
          "attributes": {
            "tree-positions": "true"
          },
          "conceptCt": 500356,
          "relationshipCt": 1219695,
          "treePositionCt": 13270514
        },
        ...
        {
          "id": "001c37aa-d414-492a-9278-5bb8163c806e",
          "confidence": 0.012578782625496387,
          "modified": "2023-09-06T01:20:28.876+00:00",
          "created": "2023-09-06T01:20:28.876+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "abbreviation": "SNOMEDCT_US",
          "name": "Systematized Nomenclature of Medicine–Clinical Terminology, US Edition",
          "version": "20230301",
          "publisher": "SANDBOX",
          "latest": true,
          "loaded": true,
          "family": "SNOMEDCT",
          "releaseDate": "2023-03-01",
          "license": "UNRESTRICTED",
          "attributes": {
            "tree-positions": "true"
          },
          "conceptCt": 416,
          "relationshipCt": 676,
          "treePositionCt": 2011
        }
      ]
    }

-----------------------------------------------------
Finished ...Mon, Sep 11, 2023  7:15:45 PM
-----------------------------------------------------
```

[Back to Top](#top)

<a name="get-terminology-sh"/>

### get-terminology.sh

Return all terminologies for specific project identified by either projectId or projectLabel.

```
$ ./get-terminology.sh --token $token --project demoProject
-----------------------------------------------------
Starting ...Tue Oct 31 19:27:08 CDT 2023
-----------------------------------------------------
url = https://api.terminologyhub.com

  Performing terminologies lookup
    count = 5

    [
      {
        "id": "7e8435c2-fec6-4184-8643-b108fdb0ace2",
        "confidence": 8.573763847351074,
        "modified": "2023-10-24T15:06:31.174+00:00",
        "created": "2023-10-24T15:06:31.174+00:00",
        "modifiedBy": "loader",
        "local": false,
        "active": true,
        "abbreviation": "ALLERGY",
        "name": "Simple ALLERGY terminology",
        "version": "3.0",
        "publisher": "TERMHUB",
        "latest": true,
        "loaded": true,
        "releaseDate": "2023-04-01",
        "family": "ALLERGY",
        "indexName": "allergy-termhub-30",
        "attributes": {
          "fhirUri": "https://terminologyhub.com/ALLERGY",
          "unidirectionalRels": "true",
          "hierarchical": "true",
          "fhirVersion": "3.0",
          "tree-positions": "true",
          "ecl": "true",
          "fhirId": "allergy_3.0"
        },
        "roots": [
          "root"
        ],
        "conceptCt": 12,
        "relationshipCt": 1,
        "treePositionCt": 2
      },
      
      . . .
      
      {
        "id": "df04af9d-ba0e-43f0-bdc9-886174cd8f48",
        "confidence": 5.35488748550415,
        "modified": "2023-09-28T22:21:20.890+00:00",
        "created": "2023-09-28T22:21:20.890+00:00",
        "modifiedBy": "loader",
        "local": false,
        "active": true,
        "abbreviation": "SNOMEDCT",
        "name": "Systematized Nomenclature of Medicine–Clinical Terminology",
        "version": "20230731",
        "publisher": "NLM",
        "latest": true,
        "loaded": true,
        "releaseDate": "2023-07-31",
        "family": "SNOMEDCT",
        "indexName": "snomedct-nlm-20230731",
        "attributes": {
          "description-logic-profile": "EL++",
          "polyhierarchy": "true",
          "hierarchical": "true",
          "description-logic-based": "true",
          "tree-positions": "true",
          "unidirectional-rels": "true",
          "ecl": "true"
        },
        "roots": [
          "138875005"
        ],
        "conceptCt": 505605,
        "relationshipCt": 1238782,
        "treePositionCt": 13925882
      }
    ]

-----------------------------------------------------
Finished ...Tue Oct 31 19:27:09 CDT 2023
-----------------------------------------------------
```
Return a specific terminology by its terminology id.

```
$ ./get-terminology.sh --token $token --id 166c6448-318e-4ddc-a6a8-374274e17e57
-----------------------------------------------------
Starting ...Tue Oct 31 19:31:03 CDT 2023
-----------------------------------------------------
url = https://api.terminologyhub.com

  Performing terminologies lookup
    count = 20

    {
      "id": "166c6448-318e-4ddc-a6a8-374274e17e57",
      "confidence": 0.011976190842688084,
      "modified": "2023-09-03T03:43:18.187+00:00",
      "created": "2023-09-03T03:43:18.187+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "abbreviation": "SNOMEDCT",
      "name": "Systematized Nomenclature of Medicine–Clinical Terminology",
      "version": "20220131",
      "publisher": "NLM",
      "latest": false,
      "loaded": true,
      "releaseDate": "2022-01-31",
      "family": "SNOMEDCT",
      "indexName": "snomedct-nlm-20220131",
      "attributes": {
        "tree-positions": "true"
      },
      "conceptCt": 490412,
      "relationshipCt": 1184330,
      "treePositionCt": 11574418
    }

-----------------------------------------------------
Finished ...Tue Oct 31 19:31:03 CDT 2023
-----------------------------------------------------
```

[Back to Top](#top)

<a name="get-terminologies-sh"/>

### export-terminology.sh

Exports a terminology for the given projectid, terminology, publisher and version. In this example, the exported terminology is placed in a zip file named ALLERGY-TERMHUB-3.0.zip

```
$ ./export-terminology.sh 1878ce91-ca3d-4c50-b7c4-bbed76261e72 ALLERGY TERMHUB 3.0
-----------------------------------------------------
Starting ...Tue Oct 31 21:02:42 CDT 2023
-----------------------------------------------------
url = https://api.terminologyhub.com

  Performing terminology export
-----------------------------------------------------
Finished ...Tue Oct 31 21:02:45 CDT 2023
-----------------------------------------------------
```

[Back to Top](#top)

<a name="get-concept-sh"/>

### get-concept.sh

Return summary concept information for a given terminology and code. The following example gets the 73211009 | Diabetes mellitus | concept in SNOMEDCT.

```
$ ./get-concept.sh demoProject SNOMEDCT 73211009 --token $token
-----------------------------------------------------
Starting ...Wed Nov  1 10:34:33 CDT 2023
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
project= demoProject
code = 73211009

  Get concept for SNOMEDCT 73211009:

    {
      "id": "0273d445-6803-4b21-9e44-19c15c64844d",
      "confidence": 12.395977020263672,
      "modified": "2002-01-31T00:00:00.000+00:00",
      "created": "2002-01-31T00:00:00.000+00:00",
      "modifiedBy": "loader",
      "local": false,
      "active": true,
      "name": "Diabetes mellitus",
      "code": "73211009",
      "terminology": "SNOMEDCT",
      "version": "20230731",
      "publisher": "NLM",
      "leaf": false,
      "defined": false,
      "normName": "diabetes mellitus",
      "stemName": "diabet mellitus",
      "terms": [
        {
          "id": "8cd94f7a-15eb-4806-b105-6c9386c992cf",
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
          "publisher": "NLM",
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
          "id": "2b7785d4-1e24-48e8-944f-073513d1a50d",
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
          "publisher": "NLM",
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
          "id": "df794abe-40a6-4f57-9e48-82b84194db7f",
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
          "publisher": "NLM",
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
          "id": "7030d440-130b-4ce3-9faa-1175576d1859",
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
          "publisher": "NLM",
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
Finished ...Wed Nov  1 10:34:34 CDT 2023
-----------------------------------------------------
```

[Back to Top](#top)

<a name="get-concept-relationships-sh"/>

### get-concept-relationships.sh

Get concept relationships for a terminology and code. In this case it resolves
relationships that originate "from" this concept code and contain information about
the concepts those relationships point "to" on the other side.

```
$ ./get-concept-relationships.sh demoProject SNOMEDCT 73211009 --token $token 
-----------------------------------------------------
Starting ...Wed Nov  1 10:55:32 CDT 2023
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
code = 73211009

  Get concept for SNOMEDCT 73211009:

    {
      "total": 3,
      "parameters": {
        "query": "terminology:SNOMEDCT AND from.code:73211009 AND *",
        "limit": 10,
        "offset": 0
      },
      "items": [
        {
          "id": "45410c2f-9197-4e0c-9501-ae824e0a6521",
          "confidence": 13.776877403259277,
          "modified": "2012-01-31T00:00:00.000+00:00",
          "created": "2012-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "NLM",
          "componentId": "4601709020",
          "type": "Is a",
          "additionalType": "116680003",
          "from": {
            "id": "0273d445-6803-4b21-9e44-19c15c64844d",
            "modified": "2002-01-31T00:00:00.000+00:00",
            "created": "2002-01-31T00:00:00.000+00:00",
            "modifiedBy": "loader",
            "local": false,
            "active": true,
            "name": "Diabetes mellitus",
            "code": "73211009",
            "terminology": "SNOMEDCT",
            "version": "20230731",
            "publisher": "NLM",
            "leaf": false
          },
          "to": {
            "id": "4c64e5f0-cb9a-4d35-bb0f-5c2394cec99a",
            "modified": "2002-01-31T00:00:00.000+00:00",
            "created": "2002-01-31T00:00:00.000+00:00",
            "modifiedBy": "loader",
            "local": false,
            "active": true,
            "name": "Disorder of endocrine system",
            "code": "362969004",
            "terminology": "SNOMEDCT",
            "version": "20230731",
            "publisher": "NLM",
            "leaf": false
          },
          "hierarchical": true,
          "asserted": true,
          "defining": true,
          "group": "0"
        },
        {
          "id": "7048cf21-9f9a-4df5-852a-30f4a7582adf",
          "confidence": 13.776877403259277,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "NLM",
          "componentId": "267149027",
          "type": "Is a",
          "additionalType": "116680003",
          "from": {
            "id": "0273d445-6803-4b21-9e44-19c15c64844d",
            "modified": "2002-01-31T00:00:00.000+00:00",
            "created": "2002-01-31T00:00:00.000+00:00",
            "modifiedBy": "loader",
            "local": false,
            "active": true,
            "name": "Diabetes mellitus",
            "code": "73211009",
            "terminology": "SNOMEDCT",
            "version": "20230731",
            "publisher": "NLM",
            "leaf": false
          },
          "to": {
            "id": "296192cc-f4ac-4dae-ada0-36072b2b9aef",
            "modified": "2002-01-31T00:00:00.000+00:00",
            "created": "2002-01-31T00:00:00.000+00:00",
            "modifiedBy": "loader",
            "local": false,
            "active": true,
            "name": "Disorder of glucose metabolism",
            "code": "126877002",
            "terminology": "SNOMEDCT",
            "version": "20230731",
            "publisher": "NLM",
            "leaf": false
          },
          "hierarchical": true,
          "asserted": true,
          "defining": true,
          "group": "0"
        },
        {
          "id": "0b16668d-509d-4d21-b614-ac66ab419ac4",
          "confidence": 13.776877403259277,
          "modified": "2019-07-31T00:00:00.000+00:00",
          "created": "2019-07-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "NLM",
          "componentId": "4601710026",
          "type": "other",
          "additionalType": "363698007",
          "from": {
            "id": "0273d445-6803-4b21-9e44-19c15c64844d",
            "modified": "2002-01-31T00:00:00.000+00:00",
            "created": "2002-01-31T00:00:00.000+00:00",
            "modifiedBy": "loader",
            "local": false,
            "active": true,
            "name": "Diabetes mellitus",
            "code": "73211009",
            "terminology": "SNOMEDCT",
            "version": "20230731",
            "publisher": "NLM",
            "leaf": false
          },
          "to": {
            "id": "69561486-aae5-4776-94e5-c4d2aeb9f55e",
            "modified": "2002-01-31T00:00:00.000+00:00",
            "created": "2002-01-31T00:00:00.000+00:00",
            "modifiedBy": "loader",
            "local": false,
            "active": true,
            "name": "Structure of endocrine system",
            "code": "113331007",
            "terminology": "SNOMEDCT",
            "version": "20230731",
            "publisher": "NLM",
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
Finished ...Wed Nov  1 10:55:33 CDT 2023
-----------------------------------------------------
```

[Back to Top](#top)

<a name="get-concept-treepos-sh"/>

### get-concept-treepos.sh

Return concept relationship information for a given terminology and code. The 
following example finds relationships for the 73211009 | Diabetes mellitus | concept in 
SNOMEDCT.  It limits the results to 5 entries and sorts by the "additionalType"
field.

```
$ ./get-concept-treepos.sh demoProject SNOMEDCT 73211009 --token $token
-----------------------------------------------------
Starting ...Wed Nov  1 11:17:36 CDT 2023
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
code = 73211009

  Get concept for SNOMEDCT 73211009:

    {
      "total": 2,
      "parameters": {
        "query": "terminology:SNOMEDCT AND concept.code:73211009 AND *",
        "limit": 10,
        "offset": 0
      },
      "items": [
        {
          "id": "663c1a87-671a-4473-a08c-0c0407ad12c0",
          "confidence": 32.087589263916016,
          "modified": "2023-09-28T23:45:02.854+00:00",
          "created": "2023-09-28T23:45:02.854+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "NLM",
          "concept": {
            "id": "1b14256e-1d02-4c9e-97b7-4caec5224c4a",
            "local": false,
            "active": true,
            "name": "SNOMED CT Concept",
            "code": "138875005",
            "leaf": false
          },
          "additionalType": "116680003",
          "childCt": 19,
          "children": [
            {
              "id": "a23974b7-d1c2-46c2-802b-1abdf3e15e5f",
              "confidence": 29.522640228271484,
              "modified": "2023-09-28T23:45:45.693+00:00",
              "created": "2023-09-28T23:45:45.693+00:00",
              "modifiedBy": "loader",
              "local": false,
              "active": true,
              "terminology": "SNOMEDCT",
              "version": "20230731",
              "publisher": "NLM",
              "concept": {
                "id": "06324473-868f-42ad-bca5-9ccdde97587a",
                "local": false,
                "active": true,
                "name": "Clinical finding",
                "code": "404684003",
                "leaf": false
              },
              "additionalType": "116680003",
              "ancestorPath": "138875005",
              "childCt": 169,
              "children": [
                {
                  "id": "a6e77561-2e51-49be-a26a-9a06584bcaab",
                  "confidence": 27.36020278930664,
                  "modified": "2023-09-28T23:48:48.720+00:00",
                  "created": "2023-09-28T23:48:48.720+00:00",
                  "modifiedBy": "loader",
                  "local": false,
                  "active": true,
                  "terminology": "SNOMEDCT",
                  "version": "20230731",
                  "publisher": "NLM",
                  "concept": {
                    "id": "b34111d1-ccdc-44b7-8865-4ff95cc009d0",
                    "local": false,
                    "active": true,
                    "name": "Disease",
                    "code": "64572001",
                    "leaf": false
                  },
                  "additionalType": "116680003",
                  "ancestorPath": "138875005~404684003",
                  "childCt": 161,
                  "children": [
                    {
                      "id": "bd8ba889-3834-4b21-babd-ae0ae8cc5b6f",
                      "confidence": 27.40854835510254,
                      "modified": "2023-09-28T23:48:48.770+00:00",
                      "created": "2023-09-28T23:48:48.770+00:00",
                      "modifiedBy": "loader",
                      "local": false,
                      "active": true,
                      "terminology": "SNOMEDCT",
                      "version": "20230731",
                      "publisher": "NLM",
                      "concept": {
                        "id": "194a90de-9cf7-410f-bd5b-82be3759c045",
                        "local": false,
                        "active": true,
                        "name": "Disorder of body system",
                        "code": "362965005",
                        "leaf": false
                      },
                      "additionalType": "116680003",
                      "ancestorPath": "138875005~404684003~64572001",
                      "childCt": 49,
                      "children": [
                        {
                          "id": "2838f495-00aa-45e4-96c1-e74b4e550492",
                          "confidence": 28.591081619262695,
                          "modified": "2023-09-28T23:49:57.666+00:00",
                          "created": "2023-09-28T23:49:57.666+00:00",
                          "modifiedBy": "loader",
                          "local": false,
                          "active": true,
                          "terminology": "SNOMEDCT",
                          "version": "20230731",
                          "publisher": "NLM",
                          "concept": {
                            "id": "4c64e5f0-cb9a-4d35-bb0f-5c2394cec99a",
                            "local": false,
                            "active": true,
                            "name": "Disorder of endocrine system",
                            "code": "362969004",
                            "leaf": false
                          },
                          "additionalType": "116680003",
                          "ancestorPath": "138875005~404684003~64572001~362965005",
                          "childCt": 50,
                          "children": [
                            {
                              "id": "739d7651-8099-432e-9320-977f93be6905",
                              "confidence": 28.060256958007812,
                              "modified": "2023-09-28T23:49:57.700+00:00",
                              "created": "2023-09-28T23:49:57.700+00:00",
                              "modifiedBy": "loader",
                              "local": false,
                              "active": true,
                              "terminology": "SNOMEDCT",
                              "version": "20230731",
                              "publisher": "NLM",
                              "concept": {
                                "id": "0273d445-6803-4b21-9e44-19c15c64844d",
                                "local": false,
                                "active": true,
                                "name": "Diabetes mellitus",
                                "code": "73211009",
                                "leaf": false
                              },
                              "additionalType": "116680003",
                              "ancestorPath": "138875005~404684003~64572001~362965005~362969004",
                              "childCt": 15
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
          "id": "663c1a87-671a-4473-a08c-0c0407ad12c0",
          "confidence": 32.087589263916016,
          "modified": "2023-09-28T23:45:02.854+00:00",
          "created": "2023-09-28T23:45:02.854+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "NLM",
          "concept": {
            "id": "1b14256e-1d02-4c9e-97b7-4caec5224c4a",
            "local": false,
            "active": true,
            "name": "SNOMED CT Concept",
            "code": "138875005",
            "leaf": false
          },
          "additionalType": "116680003",
          "childCt": 19,
          "children": [
            {
              "id": "a23974b7-d1c2-46c2-802b-1abdf3e15e5f",
              "confidence": 29.522640228271484,
              "modified": "2023-09-28T23:45:45.693+00:00",
              "created": "2023-09-28T23:45:45.693+00:00",
              "modifiedBy": "loader",
              "local": false,
              "active": true,
              "terminology": "SNOMEDCT",
              "version": "20230731",
              "publisher": "NLM",
              "concept": {
                "id": "06324473-868f-42ad-bca5-9ccdde97587a",
                "local": false,
                "active": true,
                "name": "Clinical finding",
                "code": "404684003",
                "leaf": false
              },
              "additionalType": "116680003",
              "ancestorPath": "138875005",
              "childCt": 169,
              "children": [
                {
                  "id": "a6e77561-2e51-49be-a26a-9a06584bcaab",
                  "confidence": 27.36020278930664,
                  "modified": "2023-09-28T23:48:48.720+00:00",
                  "created": "2023-09-28T23:48:48.720+00:00",
                  "modifiedBy": "loader",
                  "local": false,
                  "active": true,
                  "terminology": "SNOMEDCT",
                  "version": "20230731",
                  "publisher": "NLM",
                  "concept": {
                    "id": "b34111d1-ccdc-44b7-8865-4ff95cc009d0",
                    "local": false,
                    "active": true,
                    "name": "Disease",
                    "code": "64572001",
                    "leaf": false
                  },
                  "additionalType": "116680003",
                  "ancestorPath": "138875005~404684003",
                  "childCt": 161,
                  "children": [
                    {
                      "id": "3bd372ea-196e-494e-afbb-59df41095b69",
                      "confidence": 27.40854835510254,
                      "modified": "2023-09-28T23:56:06.302+00:00",
                      "created": "2023-09-28T23:56:06.302+00:00",
                      "modifiedBy": "loader",
                      "local": false,
                      "active": true,
                      "terminology": "SNOMEDCT",
                      "version": "20230731",
                      "publisher": "NLM",
                      "concept": {
                        "id": "d90cf392-edf9-4102-abdf-7fe31aeeb52a",
                        "local": false,
                        "active": true,
                        "name": "Metabolic disease",
                        "code": "75934005",
                        "leaf": false
                      },
                      "additionalType": "116680003",
                      "ancestorPath": "138875005~404684003~64572001",
                      "childCt": 46,
                      "children": [
                        {
                          "id": "c34e2088-b8aa-4e25-8089-367640e7dfe7",
                          "confidence": 28.653600692749023,
                          "modified": "2023-09-28T23:56:06.321+00:00",
                          "created": "2023-09-28T23:56:06.321+00:00",
                          "modifiedBy": "loader",
                          "local": false,
                          "active": true,
                          "terminology": "SNOMEDCT",
                          "version": "20230731",
                          "publisher": "NLM",
                          "concept": {
                            "id": "e6e95c54-5198-492c-96e4-f82c86904199",
                            "local": false,
                            "active": true,
                            "name": "Disorder of carbohydrate metabolism",
                            "code": "20957000",
                            "leaf": false
                          },
                          "additionalType": "116680003",
                          "ancestorPath": "138875005~404684003~64572001~75934005",
                          "childCt": 20,
                          "children": [
                            {
                              "id": "09a1fd22-80e2-413a-abf9-9e378cec9769",
                              "confidence": 29.47262954711914,
                              "modified": "2023-09-28T23:56:06.322+00:00",
                              "created": "2023-09-28T23:56:06.322+00:00",
                              "modifiedBy": "loader",
                              "local": false,
                              "active": true,
                              "terminology": "SNOMEDCT",
                              "version": "20230731",
                              "publisher": "NLM",
                              "concept": {
                                "id": "296192cc-f4ac-4dae-ada0-36072b2b9aef",
                                "local": false,
                                "active": true,
                                "name": "Disorder of glucose metabolism",
                                "code": "126877002",
                                "leaf": false
                              },
                              "additionalType": "116680003",
                              "ancestorPath": "138875005~404684003~64572001~75934005~20957000",
                              "childCt": 3,
                              "children": [
                                {
                                  "id": "0318af04-7d6a-4a91-b2e5-933888005eb1",
                                  "confidence": 30.72946548461914,
                                  "modified": "2023-09-28T23:56:06.322+00:00",
                                  "created": "2023-09-28T23:56:06.322+00:00",
                                  "modifiedBy": "loader",
                                  "local": false,
                                  "active": true,
                                  "terminology": "SNOMEDCT",
                                  "version": "20230731",
                                  "publisher": "NLM",
                                  "concept": {
                                    "id": "0273d445-6803-4b21-9e44-19c15c64844d",
                                    "local": false,
                                    "active": true,
                                    "name": "Diabetes mellitus",
                                    "code": "73211009",
                                    "leaf": false
                                  },
                                  "additionalType": "116680003",
                                  "ancestorPath": "138875005~404684003~64572001~75934005~20957000~126877002",
                                  "childCt": 15
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
Finished ...Wed Nov  1 11:17:36 CDT 2023
-----------------------------------------------------
```

[Back to Top](#top)

<a name="find-concepts-sh"/>

### find-concepts.sh

Used to perform text searches to find matching concepts. The following example
performs a text search for "diabetes mellitus" and limits search results to 5
entries.

```
$  ./find-concepts.sh demoProject SNOMEDCT "diabetes mellitus"  --token $token --limit 5
-----------------------------------------------------
Starting ...Wed Nov  1 12:29:00 CDT 2023
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
project = demoProject
query = diabetes mellitus
expr = 
offset = 0
limit = 5
sort = 
ascending = 

  Find concepts: (terminology:SNOMEDCT) AND diabetes mellitus

    {
      "total": 817,
      "parameters": {
        "query": "(terminology:SNOMEDCT) AND diabetes mellitus",
        "limit": 5,
        "offset": 0
      },
      "items": [
        {
          "id": "0273d445-6803-4b21-9e44-19c15c64844d",
          "confidence": 24.04080581665039,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Diabetes mellitus",
          "code": "73211009",
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "NLM",
          "leaf": false,
          "defined": false
        },
        {
          "id": "91386998-4228-4705-a7fb-10b57b09e5d7",
          "confidence": 23.253828048706055,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Gestational diabetes mellitus",
          "code": "11687002",
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "NLM",
          "leaf": false,
          "defined": false
        },
        {
          "id": "5ddd9a11-b60e-486f-929a-1094b17333b3",
          "confidence": 23.188446044921875,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Type 1 diabetes mellitus",
          "code": "46635009",
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "NLM",
          "leaf": false,
          "defined": false
        },
        {
          "id": "58c611c5-56c4-49f4-87c1-9fd83664c24c",
          "confidence": 23.023523330688477,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Brittle diabetes mellitus",
          "code": "11530004",
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "NLM",
          "leaf": false,
          "defined": false,
          "definitions": [
            {
              "id": "1e2944a5-f223-49c0-af64-ef404335dec9",
              "modified": "2019-07-31T00:00:00.000+00:00",
              "created": "2019-07-31T00:00:00.000+00:00",
              "modifiedBy": "loader",
              "local": false,
              "active": true,
              "definition": "Frequent, clinically significant fluctuations in blood glucose levels both above and below levels expected to be achieved by available therapies.",
              "terminology": "SNOMEDCT",
              "version": "20230731",
              "publisher": "NLM",
              "componentId": "3756600016",
              "localeMap": {
                "en_GB": true,
                "en": true
              },
              "attributes": {
                "caseSignificanceId": "900000000000017005",
                "moduleId": "900000000000207008"
              }
            },
            {
              "id": "5b666630-affd-4f09-8f0e-3b64c052905f",
              "modified": "2019-07-31T00:00:00.000+00:00",
              "created": "2019-07-31T00:00:00.000+00:00",
              "modifiedBy": "loader",
              "local": false,
              "active": false,
              "definition": "Diabetes mellitus in which there are frequent, clinically significant fluctuations in blood glucose levels both above and below levels expected to be achieved by available therapies.",
              "terminology": "SNOMEDCT",
              "version": "20230731",
              "publisher": "NLM",
              "componentId": "2884642011",
              "localeMap": {
                "en": false
              },
              "attributes": {
                "caseSignificanceId": "900000000000017005",
                "moduleId": "900000000000207008"
              }
            }
          ]
        },
        {
          "id": "38d0860a-0e0a-4f66-8674-e2a23903a2c2",
          "confidence": 22.9219913482666,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Type 2 diabetes mellitus",
          "code": "44054006",
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "NLM",
          "leaf": false,
          "defined": false
        }
      ]
    }

-----------------------------------------------------
Finished ...Wed Nov  1 12:29:01 CDT 2023
-----------------------------------------------------
```

This example performs a search that returns all descendants of the SNOMED
64572001 | Disease | concept that contain the word "system" with a maximum
of 5 results.

```
$ ./find-concepts.sh demoProject SNOMEDCT "system" --expr '<64572001' --token $token --limit 5
-----------------------------------------------------
Starting ...Wed Nov  1 12:31:08 CDT 2023
-----------------------------------------------------
url = https://api.terminologyhub.com
terminology = SNOMEDCT
project = demoProject
query = system
expr = <64572001
offset = 0
limit = 5
sort = 
ascending = 

  Find concepts: (terminology:SNOMEDCT) AND system

    {
      "total": 5373,
      "parameters": {
        "query": "(terminology:SNOMEDCT) AND system",
        "limit": 5,
        "offset": 0
      },
      "items": [
        {
          "id": "47b40957-d9e4-4fe8-91d9-2ca5f08ca6e9",
          "confidence": 16.94587516784668,
          "modified": "2022-06-30T00:00:00.000+00:00",
          "created": "2022-06-30T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "System",
          "code": "1231568003",
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "NLM",
          "leaf": true,
          "defined": false,
          "definitions": [
            {
              "id": "7705e91c-f146-4e57-83b2-cdd40283da5d",
              "modified": "2022-06-30T00:00:00.000+00:00",
              "created": "2022-06-30T00:00:00.000+00:00",
              "modifiedBy": "loader",
              "local": false,
              "active": true,
              "definition": "A solid dose form consisting of one or more components which together are used to deliver active substance(s) with a prolonged-release mechanism.",
              "terminology": "SNOMEDCT",
              "version": "20230731",
              "publisher": "NLM",
              "componentId": "5073445013",
              "localeMap": {
                "en_GB": true,
                "en": true
              },
              "attributes": {
                "caseSignificanceId": "900000000000017005",
                "moduleId": "900000000000207008"
              }
            }
          ]
        },
        {
          "id": "47a0f667-4ebc-438b-9966-5ff1bf82f616",
          "confidence": 16.94587516784668,
          "modified": "2011-01-31T00:00:00.000+00:00",
          "created": "2011-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "System",
          "code": "246333005",
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "NLM",
          "leaf": false,
          "defined": false
        },
        {
          "id": "751715cc-7c34-4229-9c53-78935bd12c04",
          "confidence": 16.94587516784668,
          "modified": "2017-07-31T00:00:00.000+00:00",
          "created": "2017-07-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "System",
          "code": "733021006",
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "NLM",
          "leaf": true,
          "defined": false
        },
        {
          "id": "8339b05c-0b4b-4f09-a336-7aafbaad8a30",
          "confidence": 16.724496841430664,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Systemic",
          "code": "31099001",
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "NLM",
          "leaf": false,
          "defined": false
        },
        {
          "id": "154d73df-c6f8-48cc-81fc-4615cdf5ad2d",
          "confidence": 10.225822448730469,
          "modified": "2002-01-31T00:00:00.000+00:00",
          "created": "2002-01-31T00:00:00.000+00:00",
          "modifiedBy": "loader",
          "local": false,
          "active": true,
          "name": "Hematopoietic system structure",
          "code": "57171008",
          "terminology": "SNOMEDCT",
          "version": "20230731",
          "publisher": "NLM",
          "leaf": false,
          "defined": false
        }
      ]
    }

-----------------------------------------------------
Finished ...Wed Nov  1 12:31:09 CDT 2023
-----------------------------------------------------
```

[Back to Top](#top)


