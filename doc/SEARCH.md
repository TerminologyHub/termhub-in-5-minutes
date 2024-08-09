TermHub - Using the "query" parameter
=====================================

The "find" API endpoints make use of a "query" parameter that supports
simple search phrases as well as more complicated introspection into the domain model.
The following searches can be performed in the "SNOMEDCT_US Latest" project by using
"snomedct_us" as the idOrUriLabel parameter.

## Searching Concepts

### Simple keyword searching

query=diabetes
query=diabetes mellitus 
query="diabetes mellitus"

### Searching only concept preferred names

query=name:diabetes
query=name:"diabetes mellitus"

### Searching only concept preferred names (normalized search)

query=normName:diabetes
query=normName:"diabetes mellitus"

### Searching only concept preferred names (stem search)

query=stemName:diabetes
query=stemName:"diabetes mellitus"

## Searching Concept Relationships

COMING SOON

## Searching Concept Tree Positions

COMING SOON

### Searching by concept code
### Searching by concept name
### Searching by by ancestorPath
