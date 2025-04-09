

# Concept

Represents a concept in a terminology

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | Unique identifier |  |
|**confidence** | **Double** | Confidence value (for use with search results) |  [optional] |
|**modified** | **OffsetDateTime** | Last modified date |  [optional] |
|**created** | **OffsetDateTime** | Created date |  [optional] |
|**modifiedBy** | **String** | Last modified by |  [optional] |
|**local** | **Boolean** | Indicates whether this data element is locally created |  [optional] |
|**active** | **Boolean** | Indicates whether or not the component is active |  [optional] |
|**name** | **String** | Concept name |  [optional] |
|**code** | **String** | Terminology code, typically representing a unit of meaning |  [optional] |
|**terminology** | **String** | Terminology abbreviation |  [optional] |
|**version** | **String** | Terminology version |  [optional] |
|**publisher** | **String** | Terminology publisher |  [optional] |
|**historical** | **String** | Historical relationship type (only used for concept descendants) |  [optional] |
|**leaf** | **Boolean** | Indicates whether or not this concept is a leaf node in its hierarchy |  [optional] |
|**defined** | **Boolean** | Indicates whether or not this concept has a logical definition with necessary and sufficient conditions |  [optional] |
|**level** | **Integer** | Level of depth |  [optional] |
|**terms** | [**List&lt;Term&gt;**](Term.md) | Terms associated with the concept |  [optional] |
|**indexTerms** | **List&lt;String&gt;** | Index terms associated with the concept (these exist for searchability but are not strictly content from the publisher) |  [optional] |
|**definitions** | [**List&lt;Definition&gt;**](Definition.md) | Textual definitions associated with the concept |  [optional] |
|**axioms** | [**List&lt;Axiom&gt;**](Axiom.md) | OwL/RDF axioms that express the logical definition |  [optional] |
|**identifiers** | [**List&lt;IdentifierRef&gt;**](IdentifierRef.md) | Alternate identifiers associated with the concept |  [optional] |
|**attributes** | **Map&lt;String, String&gt;** | Attribute key/value pairs associated with the concept |  [optional] |
|**semanticTypes** | **Set&lt;String&gt;** | High level semantic types associated with the concept |  [optional] |
|**labels** | **Set&lt;String&gt;** | Labels associated with the concept |  [optional] |
|**children** | [**List&lt;ConceptRef&gt;**](ConceptRef.md) | Children of the concept in the hierarchy |  [optional] |
|**parents** | [**List&lt;ConceptRef&gt;**](ConceptRef.md) | Parents of the concept in the hierarchy |  [optional] |
|**descendants** | [**List&lt;ConceptRef&gt;**](ConceptRef.md) | Descendants of the concept in the hierarchy |  [optional] |
|**ancestors** | [**List&lt;ConceptRef&gt;**](ConceptRef.md) | Ancestors of the concept in the hierarchy |  [optional] |
|**relationships** | [**List&lt;ConceptRelationship&gt;**](ConceptRelationship.md) | Relationships from this concept to other concepts |  [optional] |
|**inverseRelationships** | [**List&lt;ConceptRelationship&gt;**](ConceptRelationship.md) | Relationships from other concepts to this concept |  [optional] |
|**treePositions** | [**List&lt;ConceptTreePosition&gt;**](ConceptTreePosition.md) | Tree positions of the concept in the hierarchy |  [optional] |



