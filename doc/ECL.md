<a name="top" />

TermHub - Using ECL - Expression Constraint Language
====================================================

The Expression Constraint Language is a specification developed by the SNOMED International
community and is documented in detail here: https://confluence.ihtsdotools.org/display/DOCECL
(TL;DR)

TermHub supports a subset of the ECL specification (for the things that 99% of users want to be
able to do), but it supports it across all the terminologies.  It is a simple query language
that allows for expression-based "semantic" searching across a terminology to support a number
of very common use cases, like searching within a subtree.

Following are some examples of ECL that can be used with different terminologies

## ECL with SNOMEDCT_US

Following are some examples of descendant, child, ancestor, parent and relationship-related queries.

### Descendants of "Diabetes mellitus"

* `< 73211009`
* `< 73211009 |Diabetes mellitus|`

### Descendants (and self) of "Diabetes mellitus"

* `<< 73211009`
* `<< 73211009 |Diabetes mellitus|`

### Children of "Diabetes mellitus"

* `<! 73211009`
* `<! 73211009 |Diabetes mellitus|`

### Ancestors of "Diabetes mellitus"

* `> 73211009`
* `> 73211009 |Diabetes mellitus|`

### Ancestors (and self) of "Diabetes mellitus"

* `>> 73211009`
* `>> 73211009 |Diabetes mellitus|`

### Parents of "Diabetes mellitus"

* `>! 73211009`
* `>! 73211009 |Diabetes mellitus|`

### MINUS: Descendants of "Diabetes mellitus" that are not descendants of "Complication of injury"

* `< 73211009 MINUS < 116225000`
* `< 73211009 |Diabetes mellitus| MINUS < 116225000 |Complication of injury|`

### AND: Descendants of "Diabetes mellitus" that are also descendants of "Complication of injury"

* `< 73211009 AND < 116225000`
* `< 73211009 |Diabetes mellitus| AND < 116225000 |Complication of injury|`

### Descendants of "Diabetes mellitus" with any kind of finding site

* `< 73211009 : 363698007 = *`
* `< 73211009 |Diabetes mellitus| : 363698007 | Finding site | = *`

### Descendants of "Diabetes mellitus" with a finding site of "Pituitary structure"

* `< 73211009 : 363698007 = 56329008`
* `< 73211009 |Diabetes mellitus| : 363698007 | Finding site | = 56329008 | Pituitary structure |`

### Descendants of "Diabetes mellitus" with a finding site of descendants of "Structure of endocrine system"

* `< 73211009 : 363698007 = <113331007`
* `< 73211009 |Diabetes mellitus| : 363698007 | Finding site | = < 113331007 |Structure of endocrine system|`


## ECL with ICD10CM

Following are some examples of descendant, child, ancestor, and parent queries.

### Descendants of "Type 2 diabetes mellitus"

* `< E11`
* `< E11 |Type 2 diabetes mellitus|`

### Descendants (and self) of "Type 2 diabetes mellitus"

* `<< E11`
* `<< E11 |Type 2 diabetes mellitus|`

### Children of "Type 2 diabetes mellitus"

* `<! E11`
* `<! E11 |Type 2 diabetes mellitus|`

### Ancestors of "Type 2 diabetes mellitus"

* `> E11`
* `> E11 |Type 2 diabetes mellitus|`

### Ancestors (and self) of "Type 2 diabetes mellitus"

* `>> E11`
* `>> E11 |Type 2 diabetes mellitus|`

### Parents of "Type 2 diabetes mellitus"

* `>! E11`
* `>! E11 |Type 2 diabetes mellitus|`


## ECL with RXNORM

Following are some examples relationship-related queries (since RXNORM does not have a hierarchy).  In general the "ECL-supported" relationships in RXNORM are those that point
to more specific things.  In general these are the "has_xxx" relationships instead of the
"xxx_of" relationships. The one notable exception is "tradename_of" which is supported 
instead of "has_tradename".

### Concepts with an ingredient of "Aspirin"

* `* : has_ingredient = 1191`
* `* : has_ingredient = 1191 |Aspirin|`

### Concepts with with a precise form of of "acetylsalicylate sodium"

* `* : has_form = 314293`
* `* : has_form = 314293 |acetylsalicylate sodium|`

### Concepts that are tradenames of "aspirin"

* `* : tradename_of = 1191`
* `* : tradename_of = 1191 |Aspirin|`






