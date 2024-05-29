<a name="top"/>

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

### Login

Login and acquire an access token for a username and password.  
Replace <username> with your username and <password> with your password.  
The commands below will set a `token` variable equal to the access token.

```
TOOD:ADD CODE
```

<a name="get-terminologies"/>

### Get terminologies

Return all loaded terminologies currently hosted by the API.  This call also takes
search parameters such as query, limit, offset, sort, and ascending to allow searching
across available terminologies.

```
TOOD:ADD CODE

```

[Back to Top](#top)

<a name="get-project-terminologies"/>

### Get project terminologies

Return all terminologies for the specified project identified by either projectId or projectLabel.

```
TOOD:ADD CODE
```

[Back to Top](#top)

<a name="get-terminology"/>

### Get terminology
Return a specific terminology by its terminologyId. The UUID below is an example
that may or may not work.  The idea is to take one of the terminology ids returned
by the previous call and you can then look up terminology info specifically for that
UUID.

```
TOOD:ADD CODE
```

[Back to Top](#top)

<a name="export-terminology"/>

### Export terminology

Export zip file of a terminology in a particular format.  Currently only format=native is
supported.

```
TOOD:ADD CODE
```

[Back to Top](#top)

<a name="get-concept-by-code"/>

### Get concept by code

Look up concept information for a given terminology and code.

```
TOOD:ADD CODE
```

[Back to Top](#top)

<a name="get-concept-by-code-with-include"/>

### Get concept by code with explicit include parameter

Look up concept information for a given terminology and code and use an explicit include parameter to control how much data to send back.  The include parameter has a few helpful shortcut values
(minimal, summary, full) and also allows you to individually select parts of the full concept model
that you are interested in.  For more information see [INCLUDE.md](../doc/INCLUDE.md "INCLUDE.md").

```
TOOD:ADD CODE
```

[Back to Top](#top)

<a name="get-concept-relationships"/>

### Get concept relationships by code

Get concept relationships for a terminology and code. In this case it resolves
relationships that originate "from" this concept code and contains information about
the concepts those relationships point "to" on the other side. For example, a child
concept pointing to its parent.

```
TOOD:ADD CODE
```

[Back to Top](#top)

<a name="get-concept-inverse-relationships"/>

### Get concept inverse relationships by code

Get concept inverse relationships for a terminology and code. In this case it resolves
relationships that point "to" this concept code and contains information about concepts
those relationships originate "from" on the other side.  For example, a parent concept
being pointed to from a child.

```
TOOD:ADD CODE
```

[Back to Top](#top)

<a name="get-treepos"/>

### Get concept tree positions

Get concept tree positions for a terminology and code. For classification
hierarchies, you would expect to see just a single tree position.  But for
more complex poly-hierarchies you'd likely expect to see multiple tree positions -
each one with a different path to the root concept.

```
TOOD:ADD CODE
```

[Back to Top](#top)

<a name="find-concepts"/>

### Find concepts by search term

Find concepts matching a search term within a specified terminology. This
example uses paging to get only the first 5 results.

```
TOOD:ADD CODE
```

[Back to Top](#top)

<a name="find-concepts"/>

### Find concepts by search term with explicit include parameter

This is the same as the example above but with the use of an explicit include
parameter to show that additional data can be loaded with searches.

```
TOOD:ADD CODE
```

[Back to Top](#top)

<a name="find-concepts-expr"/>

### Find concepts by search term and expression

Find concepts matching a search term within a specified terminology and constrain
the search results by an expression. This example uses paging to get only the first
10 results.

NOTE: the expression we are using is <<64572001 (descendants-or-self of the "Disease"
concept in SNOMED).  To work properly, the expression value has to be url encoded
(See https://www.urlencoder.org/ for an online URL encoder):

```
TOOD:ADD CODE
```

[Back to Top](#top)

<a name="find-terms"/>

### Find terms by search term

Find terms matching a search term within a specified terminology. This
example uses paging to get only the first 5 results.  While in many instances it
is most useful to directly find concepts with matching terms, this call allows
users to isolate exactly those terms that resolve from a search.

```
TOOD:ADD CODE
```

[Back to Top](#top)

<a name="autocomplete"/>

### Support autocomplete/typeahead for first few characters typed

To support an autocomplete or typeahead user interface feature for terminology
searching, there is an autocomplete end point that supports taking a few characters
and finding possible matches with only a few starting characters. The background
algorithm is based on edge ngrams.

```
TOOD:ADD CODE
```

[Back to Top](#top)

