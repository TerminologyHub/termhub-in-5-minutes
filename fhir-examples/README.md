Termhub in 5 Minutes: FHIR Tutorial
===================================

This tutorial shows how to interact with the FHIR R4 and R5 APIs through use of a Postman collection.

Prerequisites
-------------
* Postman must be installed (with a version capable of importing a v2.1 collection)
* The [Termhub-FHIR-R4.postman_collection.json](Termhub-FHIR-R4.postman_collection.json) file must be loaded into Postman using File->Iimport to access the R4 FHIR APIs
* The [Termhub-FHIR-R5.postman_collection.json](Termhub-FHIR-R5.postman_collection.json) file must be loaded into Postman using File->Iimport to access the R5 FHIR APIs

Using the Postman Files
-----------------------
Once imported, there are a number of steps to "set up" use of the postman file that you need
to take into consideration.  TermHub uses a multi-tenant FHIR server to offer FHIR-based access
to exactly the content available in a given project. All of the examples are configured by default 
to use the "sandbox" project, which is public and available to all authenticated users. 

1. The API URL used for all calls is specified by a `baseUrl` parameter, which is set in the "Variables" tab for the collection. The default value is `https://api.terminologyhub.com` and does not need to be changed.
2. The TermHub project used for all calls is specified by a `idOrUriLabel` parameter, which is set in the "Variables" tab for the collection. The default value is `sandbox` and can be changed to the id or uriLabel for any project the user has access to.
3. For calls to work, the user must first log in.  This is done in the "Authorization" tab for the collection.  Keep all the settings as they are in the collection and fill out "username" and "password" for your account credentials.  Then click the "Get New Access Token" button at the bottom of the page and you should be logged in.  Postman uses the refresh flow to keep you logged in over time so this should be a one-time operation unless your password changes.

FHIR Swagger APIs are also available for these end points.
 - https://api.terminologyhub.com/r4/swagger-ui/index.html
 - https://api.terminologyhub.com/r5/swagger-ui/index.html


Sample FHIR Calls
-----------------
Once loaded in, you will see the calls divided into four sections.

- [CodeSystem](#codesystem)
- [ValueSet](#valueset)
- [ConceptMap](#conceptmap)
- [Server capability statement](#server-capability-statement)

### CodeSystem

*Get all code systems*

Returns a bundle of all code systems for the specified proejct.

*Get code system by id*

Returns the code system for the specified `_id` parameter.\

*Find code systems by id*

Returns a bundle containing the code system for the specified `_id` parameter.

*Find code systems by url*

Returns a bundle containing the code system for the specified `url` parameter.

*Find code systems - default search by fields*

Returns a bundle containing the code system matching the various search fields.  This is provided as an example of "default" search of a number of different fields.  The combination of parameters finds exactly one code system in the sandbox project.

*Find code systems - contains search by fields*

Returns a bundle containing the code system matching the various search fields.  This is provided as an example of "contains" search of a number of different fields.  The combination of parameters finds exactly one code system in the sandbox project.

*Find code systems - startsWith  search by fields*

Returns a bundle containing the code system matching the various search fields.  This is provided as an example of "startsWith" search of a number of different fields.  The combination of parameters finds exactly one code system in the sandbox project.

*Find code systems - exact search by fields*

Returns a bundle containing the code system matching the various search fields.  This is provided as an example of "exact" search of a number of different fields.  The combination of parameters finds exactly one code system in the sandbox project.

*Lookup a SNOMEDCT code*

Returns the result of looking up a SNOMEDCT code by system and code.

*Lookup a SNOMEDCT code with specific properties*

Returns the result of looking up a SNOMEDCT code by system and code for only a few properties.  The default lookup provides information on all properties.

*Lookup a LOINC code*

Returns the result of looking up a LOINC code by system and code.

*Test for SNOMEDCT concept subsumption*

Returns a result for testing subsumption of two SNOMEDCT codes.  Try switching the codes, making them the same, or changing them to see how the outcome changes.

*Validate a SNOMEDCT code*

Validates that a SNOMEDCT code is present.  Try adding a digit to the code (making it invalid) to see how the outcome changes. Also try adding a `display` parameter with a fake name like `abc` to see how it reports that the code is found but not with a matching designation.

*Validate a LOINC code*

Same as the prior call but for a LOINC code.

[Back to Top](#termhub-in-5-minutes-fhir-tutorial)

### ValueSet

*Get all value sets*

Returns a bundle of all value sets for the specified project.  TermHub always returns value sets in this call that represent all of the codes of the terminology.  Thus, there will always be at least one value set for each code system in the project.

*Get value set by id*

Returns the value set for the specified `_id` parameter.

*Find value sets by id*

Returns a bundle containing the value set for the specified `_id` parameter.

*Find value sets by url*

Returns a bundle containing the value set for the specified `url` parameter.

*Find value sets - default search by fields*

Returns a bundle containing the value sets matching the various search fields.  This is provided as an example of "default" search of a number of different fields.  The combination of parameters finds exactly one value set in the sandbox project.  Additional examples for "contains", "startsWith", and "exact" search are not provided here, but the examples in the code system section should provide a basis for how to do similar things.

*Validate code (versioned uri)*

Validates that a code is in a specified value set.  In this case, the value set is specified using a versioned form of the value set URL.  Try changing the code to see how it affects the result.

*Validate code*

Validates that a code is in a specified value set.  In this case, the value set is specified using the value set URL representing all of SNOMEDCT. Try changing the code to see how it affects the result.

*Perform a concept term search*

Returns a value set containing the results of performing the search as part of an expansion.  This is the primary way FHIR can be
used to perform text searching against a code system.   The idea is to use a value set that represents the entirety of the code system and then a `filter` parameter to find things within that set. 

*Get descendants of a given code*

Returns a value set containing an expansion of all descendants of the specifed code.  This is accomplished by use of an implied value set URL that makes  use of `isa/$code` to indicate that a descendants computation should occur.

*Run an ECL query*

Returns a value set containing an expansion of performing an ECL query against SNOMEDCT.  In TermHub ECL is supported for all code systems, not just SNOMEDCT with the same basic syntax.

*Run an ECL query with term search*

Returns a value set containing an expansion of performing an ECL query against SNOMEDCT in conjunction with use of a text filter.  In TermHub ECL is supported for all code systems, not just SNOMEDCT with the same basic syntax.

*Run an ECL query and include all English names*

Returns a value set containing an expansion of performing an ECL query against SNOMEDCT and including all of the English language designations for each result.  In TermHub ECL is supported for all code systems, not just SNOMEDCT with the same basic syntax.

[Back to Top](#termhub-in-5-minutes-fhir-tutorial)

### ConceptMap

*Get all concept maps*

Returns a bundle of all concept maps for the specified project.

*Get concept map by id*

Returns the concept map for the specified `_id` parameter.

*Find concept maps by id*

Returns a bundle containing the concept map for the specified `_id` parameter.

*Find concept maps by url*

Returns a bundle containing the concept map for the specified `url` parameter.

*Find concept maps - default search by fields*

Returns a bundle containing the concept maps matching the various search fields.  This is provided as an example of "default" search of a number of different fields.  The combination of parameters finds exactly one value set in the sandbox project.  Additional examples for "contains", "startsWith", and "exact" search are not provided here, but the examples in the code system section should provide a basis for how to do similar things.

*Translate code by system+code (or Translate source code)

Returns matching target codes for the specified source system and code across all concept maps in the project.
This call makes use of the "version" parameter because the project contains both SNOMEDCT and SNOMEDCT_US which
share the same FHIR code system URI. Thus, the version parameter is necessary to differentiate between them.

*Translate code by system+code (or Translate source code) for a specified concept map

Returns matching target codes for the specified source system and code for the specified concept map in the project.

*Translate code by targetSystem+code (or Translate targetcode)

Returns matching source codes for the specified target system and code across all concept maps in the project.

[Back to Top](#termhub-in-5-minutes-fhir-tutorial)

### Server capability statement

This is the FHIR metadata call that describes the capabilities of the server deployment.

[Back to Top](#termhub-in-5-minutes-fhir-tutorial)
