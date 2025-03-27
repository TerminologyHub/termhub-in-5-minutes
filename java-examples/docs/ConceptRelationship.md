

# ConceptRelationship

Represents a relationship between two concepts in a terminology

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | Unique identifier |  [optional] |
|**confidence** | **Double** | Confidence value (for use with search results) |  [optional] |
|**modified** | **OffsetDateTime** | Last modified date |  [optional] |
|**created** | **OffsetDateTime** | Created date |  [optional] |
|**modifiedBy** | **String** | Last modified by |  [optional] |
|**local** | **Boolean** | Indicates whether this data element is locally created |  [optional] |
|**active** | **Boolean** | Indicates whether or not the component is active |  [optional] |
|**terminology** | **String** | Terminology abbreviation, e.g. \&quot;SNOMEDCT\&quot; |  [optional] |
|**version** | **String** | Terminology version, e.g. \&quot;20230901\&quot; |  [optional] |
|**publisher** | **String** | Terminology publisher, e.g. \&quot;SNOMEDCT\&quot; |  [optional] |
|**componentId** | **String** | Identifier for this object in the published source terminology |  [optional] |
|**type** | **String** | Type of relationship in a broad sense, e.g. \&quot;other\&quot;, \&quot;broader\&quot;, \&quot;narrower\&quot;.  Inspired by the REL field in the UMLS MRREL.RRF file, this field will typically have a Termhub-computed value for the high-level relationship type |  [optional] |
|**additionalType** | **String** | Type of relationship in a more specific sense, e.g. \&quot;member_of\&quot;, \&quot;has_finding_site\&quot;, \&quot;363698007\&quot;.  Typically this fieldwill be used for the primary relationship type asserted in thepublished source data |  [optional] |
|**from** | [**ConceptRef**](ConceptRef.md) |  |  [optional] |
|**to** | [**ConceptRef**](ConceptRef.md) |  |  [optional] |
|**toValue** | **String** | Literal value on the other side of the relationship (either \&quot;to\&quot; or \&quot;toValue\&quot; will be used but not both) |  [optional] |
|**hierarchical** | **Boolean** | Indicates whether this relationship represents a hierarchical or parent/child type of connection |  [optional] |
|**historical** | **Boolean** | Indicates whether this relationship represents a historical type of connection from a retired concept to an active concept |  [optional] |
|**asserted** | **Boolean** | Indicates whether or not this relationship is in the direction asserted by the terminology. |  [optional] |
|**defining** | **Boolean** | Indicates whether or not this relationship is part of the logical definition of the from concept |  [optional] |
|**group** | **String** | Represents a value used to group relationships whose semantics are bound together. |  [optional] |
|**attributes** | **Map&lt;String, String&gt;** | Key/value pairs associated with this object |  [optional] |



