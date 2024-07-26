Termhub in 5 Minutes: python Tutorial
===================================================

This tutorial shows how to use Python programming language to access content from the TermHub Terminology API.
All the operations describes here perform a GET request.

Prerequisites
-------------

* Python 3.7+

* All libraries in 'requirements.txt' must be installed.
    * Run the command 'pip install -r requirements.txt' in a console window to check these libraries and install any
      that are not already installed.
    * If pip itself is not installed, run the command 'curl <https://bootstrap.pypa.io/get-pip.py> -o get-pip.py; python
      get-pip.py' to install it.

The various scripts make use of the `python-examples/config.ini` file to load necessary information that is uniform
across all tests.

Sample Python Calls
-----------------

The following examples are exhibited by various unit tests defined in the code in `python-examples`.
All commands to run these tests should be run from that directory.

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

### Login [MUST BE RUN FIRST]

Login and acquire an access token for a username and password.  
You will need to set your environment variable for `USER_NAME` and `PASSWORD`.  
The commands below will set a `token` variable equal to the access token. This token is used for the remaining tests.

```
pytest tests/test_login.py::TestLogin::test_login
```

Copy the `TOKEN` value and set this as an environment variable to run the remaining tests.

```
export TOKEN=generatedTokenValueHere
```

<a name="get-terminologies"/>

### Get terminologies

Return all loaded terminologies currently hosted by the API. This call also takes
search parameters such as query, limit, offset, sort, and ascending to allow searching
across available terminologies.

```
pytest tests/test_terminology_api.py::TestTerminologyApi::test_get_terminologies
```

[Back to Top](#top)

<a name="get-project-terminologies"/>

### Get project terminologies

Return all terminologies for the specified project identified by either projectId or projectLabel.

```
pytest tests/test_terminology_api.py::TestTerminologyApi::test_get_project_terminologies
```

[Back to Top](#top)

<a name="get-terminology"/>

### Get terminology

Return a specific terminology by its terminologyId. 

```
pytest tests/test_terminology_api.py::TestTerminologyApi::test_get_specific_terminology
```

[Back to Top](#top)

<a name="export-terminology"/>

### Export terminology

Export zip file of a terminology in a particular format. Currently only format=native is
supported.

```
pytest tests/test_terminology_api.py::TestTerminologyApi::test_export_terminologies
```

[Back to Top](#top)

<a name="get-concept-by-code"/>

### Get concept by code

Look up concept information for a given terminology and code.

```
pytest tests/test_concept_by_code_api.py::TestConceptByCodeApi::test_get_concept_by_code
```

[Back to Top](#top)

<a name="get-concept-by-code-with-include"/>

### Get concept by code with explicit include parameter

Look up concept information for a given terminology and code and use an explicit include parameter to control how much
data to send back. The include parameter has a few helpful shortcut values
(minimal, summary, full) and also allows you to individually select parts of the full concept model
that you are interested in. For more information see [INCLUDE.md](../doc/INCLUDE.md "INCLUDE.md").

```
pytest tests/test_concept_by_code_api.py::TestConceptByCodeApi::test_get_concept_by_code_with_include_param
```

[Back to Top](#top)

<a name="get-concept-relationships"/>

### Get concept relationships by code

Get concept relationships for a terminology and code. In this case it resolves
relationships that originate "from" this concept code and contains information about
the concepts those relationships point "to" on the other side. For example, a child
concept pointing to its parent.

```
pytest tests/test_concept_by_code_api.py::TestConceptByCodeApi::test_get_concept_relationships_by_code
```

[Back to Top](#top)

<a name="get-concept-inverse-relationships"/>

### Get concept inverse relationships by code

Get concept inverse relationships for a terminology and code. In this case it resolves
relationships that point "to" this concept code and contains information about concepts
those relationships originate "from" on the other side. For example, a parent concept
being pointed to from a child.

```
pytest tests/test_concept_by_code_api.py::TestConceptByCodeApi::test_get_concept_inverse_relationships_by_code
```

[Back to Top](#top)

<a name="get-treepos"/>

### Get concept tree positions

Get concept tree positions for a terminology and code. For classification
hierarchies, you would expect to see just a single tree position. But for
more complex poly-hierarchies you'd likely expect to see multiple tree positions -
each one with a different path to the root concept.

```
pytest tests/test_concept_by_code_api.py::TestConceptByCodeApi::test_get_concept_trees
```

[Back to Top](#top)

<a name="find-concepts"/>

### Find concepts by search term

Find concepts matching a search term within a specified terminology. This
example uses paging to get only the first 5 results.

```
pytest tests/test_concept_api.py::TestConceptApi::test_get_concept_by_search_term
```

[Back to Top](#top)

<a name="find-concepts"/>

### Find concepts by search term with explicit include parameter

This is the same as the example above but with the use of an explicit include
parameter to show that additional data can be loaded with searches.

```
pytest tests/test_concept_api.py::TestConceptApi::test_get_concept_by_query_and_include_param
```

[Back to Top](#top)

<a name="find-concepts-expr"/>

### Find concepts by search term and expression

Find concepts matching a search term within a specified terminology and constrain
the search results by an expression. This example uses paging to get only the first
10 results.

NOTE: the expression we are using is <<64572001 (descendants-or-self of the "Disease"
concept in SNOMED).

```
pytest tests/test_concept_api.py::TestConceptApi::test_get_concept_from_query_and_expression
```

[Back to Top](#top)

<a name="find-terms"/>

### Find terms by search term

Find terms matching a search term within a specified terminology. This
example uses paging to get only the first 5 results. While in many instances it
is most useful to directly find concepts with matching terms, this call allows
users to isolate exactly those terms that resolve from a search.

```
pytest tests/test_term_api.py::TestTermApi::test_find_terms_by_search_term
```

[Back to Top](#top)

<a name="autocomplete"/>

### Support autocomplete/typeahead for first few characters typed

To support an autocomplete or typeahead user interface feature for terminology
searching, there is an autocomplete end point that supports taking a few characters
and finding possible matches with only a few starting characters. The background
algorithm is based on edge ngrams.

```
pytest tests/test_term_api.py::TestTermApi::test_autocomplete_and_typeahead
```

[Back to Top](#top)

