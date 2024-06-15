TermHub - Using the "include" parameter
=======================================

Many of the API endpoints make use of an "include" parameter that controls
how much data the given call should return. The include parameter values of
"minimal", "summary", and "full" have special meaning, whereas the others simply
refer to features of the concept body that can be individually activated when needed.

### Special Include Values

The following special "include" values are for convenience:

 - **minimal**: indicates just top level concept fields such as "code", "name", and "terminology" should be included.
 - **summary**: indicates minimal information plus "terms", "definitions", "attributes", and "semanticTypes" should be included. Equivalent to using "terms,definitions,attributes,semanticTypes" as the "include" value. 
 - **full**: indicates to return all available concept parts listed below (never a default).

For API calls, the default "include" value is "minimal" if not specified.

### Concept Part Include Values

The remaining supported "include" values represent individual parts of the concept:

 - **ancestors**: indicates ancestor concept references should be included
 - **attributes**: indicates attributes should be included.
 - **children**: indicates child concepts should be included.
 - **definitions**: indicates definitions should be included.
 - **descendants**: indicates descendant concepts should be included.
 - **inverseRelationships**: indicates inverse relationships should be included.
 - **parents**: indicates parent concepts should be included.
 - **relationships**: indicates concept relationships should be included.
 - **semanticTypes**: indicates semantic types should be included.
 - **subsets**: indicates subsets should be included.
 - **terms**: indicates terms should be included.
 - **treePositions**: indicates treePositions should be included.

### Combining Special/Concept Include Values

It is possible to use multiple include values together (as a comma-separated list).  In that case, if any of the values indicate that concept features should be included in the response, then it will be included.  The information returned by "minimal" is **always** included, no matter how the parameter is specified.

The typical (and most useful) scenarios for the "include" parameter are as follows:

0. Default behavior (do not specify "include" value).
0. Use "minimal", "summary", or "full".
0. Use specifically needed features, such as "terms", "mapsets".
0. Combine "summary" with one or more of the relationship type features.  
 - e.g. "summary,parents,children"

