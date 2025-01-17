TermHub - Using the "query" parameter
=====================================

The "find" API endpoints make use of a "query" parameter that supports
simple search phrases as well as more complicated introspection into the domain model.
The following searches can be performed in the "SNOMEDCT_US Latest" project by using
"snomedct_us" as the idOrUriLabel parameter.  

Keep in mind when using the query parameter to URL encode the value after the equals sign.

## Searching Concepts

The following sections provide examples of using the query parameter when searching for concepts.

### Simple keyword searching

The query parameter takes a simple search value without any special semantics.  In the background, this turns into a more complex query that attempts to match to what the user is looking for. This includes things like stemming and automatic wildcard searching for each word.  Following are a few examples of using the query parameter without specifying any fields

* Search for a code value: `query=73211009`
* Search for a single word: `query=diabetes`
* Search for multiple words: `query=diabetes mellitus`
* Search for the first part of one or more words: `query=dia mel`
* Search for a phrase: `query="diabetes mellitus"`

### Searching using the fielded searches

There are now more sophisticated ways of searching where you can specify fields in the TermHub `Concept` model that you want to specifically search.  Following are a few examples

* Search for only concepts matching a code: `query=code:73211009`
* Search for concepts with a name containing a word: `query=name:diabetes`
* Search for concepts with a name containing a phrase: `query=name:"diabetes mellitus"`
* Search for concepts with terms having a name containing a word: `query=terms.name:diabetes`
* Search for concepts with terms having a name containing a phrase: `query=terms.name:"diabetes mellitus"`

The name searches above can also be done with "stem" names.

* Search for concepts with a name containing a word: `query=stemName:diabetes`
* Search for concepts with a name containing a phrase: `query=stemName:"diabetes mellitus"`
* Search for concepts with terms having a name containing a word: `query=terms.stemName:diabetes`
* Search for concepts with terms having a name containing a phrase: `query=terms.stemName:"diabetes mellitus"`

Various combinations can be combined in boolean logic as well.  for example, the following query parameter will find concepts having a stem name match to a particular word that are also leaf node concepts.

`query=terms.name:diabetes AND leaf:true`

## Searching Concept Relationships

The following sections provide examples of using the query parameter when searching for concept relationships.

### Searching for Concept Relationships by "from code" or "to code"

To find relationships "from" a particular code, use `query=from.code:73211009`.  This finds all concept relationships from 73211009 pointing to other concepts.

To find relationships "to" a particular code, use `query=to.code:73211009`.  This finds all concept relationships from other concepts pointing to 73211009.

### Searching for Concept Relationships by "from name" or "to name"

To find relationships "from" a particular code, use `query=from.name:diabetes`.  This finds all concept relationships from concepts whose name matches `diabetes` pointing to other concepts.

To find relationships "to" a particular code, use `query=to.code:73211009`.  This finds all concept relationships from other concepts pointing to concepts whose name matches `diabetes`.

## Searching Concept Tree Positions

The following sections provide examples of using the query parameter when searching for concept tree positions.

### Searching by concept code

To search for tree positions for a particular code, use `query=concept.code:73211009`.  This finds all tree positions for the code 73211009.

### Searching by concept name

To search for tree positions matching a name, use `query=concept.name:diabetes`. This finds all tree positions for concepts whose name contains the word "diabetes".

### Searching by by ancestorPath

To search for tree positions matching a particular ancestor path, use `query=ancestorPath:138875005~404684003~64572001`.  This will find children of of the node with the specified chain of ancestor concepts shown.

