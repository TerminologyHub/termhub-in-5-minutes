TermHub - Clinical Classes
==========================

TermHub uses an entity model for describing the types of content that may exist in 
underlying terminology data.  This model is inspired by FHIR, by the Semantic Types
in the UMLS, by "semantic tags" in SNOMEDCT, and by working with real-world data
in both the clinical and life sciences space.

It takes the perspective that there are certain "top level" entity types that 
have subtypes and then various of these types have supporting attributes. Following
is a (hierarchical) listing of entity types and of attribute types.  This list is
a work in progress.

### Entity Types

These represent the key "types" of information in healthcare data

* **Condition** - condition
	* **Allergy** - allergy
	* **Family History** - familyHistory
	* **Social History** - socialHistory
* **Medication** (ingredients, brand names, with or without strengths and dose/route) - medication
	* **Vaccine** - vaccine
	* **Pack** - medicationPack
* **Procedure** - procedure
	* **Diagnostic Procedure** - diagnosticProcedure
	* **Therapeutic Procedure** - therapeuticProcedure
	* **Administrative Procedure** - administrativeProcedure
	* **Evaluation Procedure** - evaluationProcedure
	* **Immunization** - immunization
* **Observation**
	* **Lab Panel** - labPanel
		* **Vital Sign Panel** - vitalSignPanel
	* **Lab Order** - labOrder
		* **Vital Sign Order** - vitalSignOrder
	* **Lab Result** - labResult
		* **Vital Sign** - vitalSign
* **Device** - device

### Attribute Types

These represent the "supporting" content that helps define the key types.

* **Body part** - bodyPart
* **Course** (chronic, acute) - course
* **Duration**
* **Grade** - grade
* **Frequency**
* **Laterality** (left, right, unilateral, bilateral) - laterality
* **Occurrence** (congenital, acquired, period of life) - occurrence
* **Route**
* **Severity** (mild, moderate, severe) - severity
* **Specimen** - specimen
* **Substance** - substance
* **Stage** - stage
* **Units** - units
	* **Lab result units** - labResultUnits
	* **Medication units** - medicationUnits
* Other modeling needed to support all the various FHIR attribute code situations
  
### Context Entity Types

These represent aspects of qualifying information about the context or setting
or situation of a particular entity type

* **Subject of record** (patient, family member, coworker, friend) - subjectOfRecord
* **Time aspect** (specified time, past, future) - timeAspect
* **Finding context** (known true, known false, likely, suspected, …) - findingContext
* **Procedure context** (completed, refused, planned, etc.) - procedureContext



 
