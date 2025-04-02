TermHub - Download Formats
=====================================

A variety of different download file formats are computed when terminologies are loaded into
TermHub.  This page documents those various formats and what to expect if you download content
from your project.

### Native

This option represents whatever content was used to actually load TermHub for a given terminology
or mapset.  Think of it as the original file format published by the Standards Development Organization (SDO) or publishing authority.

For SNOMEDCT, this means RF2 files. For data from the UMLS, this means the RRF format.  There are a wide variety of other formats available that reprsent LOINC, RXNORM, CVX, NDC, etc. 

### R4

FHIR R4 json file representing the content of the terminology or mapset. For more information, see the HL7 FHIR specification links below.  These files (generally) will be loadable into a HAPI reference FHIR R4 instance.
* https://hl7.org/fhir/R4/codesystem.html
* https://hl7.org/fhir/R4/conceptmap.html

### R5

FHIR R5 json file representing the content of the terminology or mapset. For more information, see the HL7 FHIR specification links below.  These files (generally) will be loadable into a HAPI reference FHIR R5 instance.
* https://hl7.org/fhir/R5/codesystem.html
* https://hl7.org/fhir/R5/conceptmap.html

### Simple

TermHub native "simple" relational format.  When you just need simple terminology data in a format that is easy to work with and can be loaded into a relational database, this is a good place to start.
* version.txt - provides version info and release date
* concepts.txt - one entry per concept
* synonyms.txt - one entry per term
* attributes.txt - one entry per concept attribute
* parChd.txt - one entry per parent/child relationship
* relationships.txt - one entry per non-parent/child relationship

