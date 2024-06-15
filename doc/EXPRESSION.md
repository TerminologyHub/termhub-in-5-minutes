TermHub - Using the "expression" parameter
==========================================

The "find concept" API endpoints make use of an "expression" parameter that allows 
for some advanced searching capabilities.

### Using semantic type values for the expression

Semantic type values used by a terminology can be used as an effective way to "focus" a search result within a particular content area.  When looking at concepts in the TermHub browser, the
first section of that report shows the semantic types.  For SNOMEDCT these are values like
"finding", "disorder", "procedure", and so on.  For UMLS-originated terminologies, like RXNORM
the values can be more complex, like "Clinical Drug" or "Pharmacologic Substance".  

When performing a "find concepts" search, you can supply one or more semantic type values
(separated by a ";" character) and searches are limited to concepts that have the corresponding
semantic type assignments.

For a simple example, try searching "kidney" in SNOMEDCT with an expression of "disorder" vs
an expression of "procedure" and the differences shoudl be clear.

### Using expression constraint language values for the expression

It is also possible to make use of ECL expressions

For more information see:  [Using ECL - Expression Constraint Language](ECL.md)
