

# ConceptTreePosition

Represents a tree position in the terminology hierarchy for a concept

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
|**concept** | [**ConceptRef**](ConceptRef.md) |  |  [optional] |
|**additionalType** | **String** | Type of relationship in a more specific sense, e.g. \&quot;is_a\&quot;, \&quot;116680003\&quot;.  Typically this fieldwill be used for the hierarchical relationship type asserted in thepublished source data |  [optional] |
|**ancestorPath** | **String** | Dot-separated chain of codes from the root of the tree to the parent code of this node |  [optional] |
|**childCt** | **Integer** | Count of child nodes |  [optional] |
|**level** | **Integer** | Level of depth in the hierarchy |  [optional] |
|**children** | [**List&lt;ConceptTreePosition&gt;**](ConceptTreePosition.md) | Child tree position nodes |  [optional] |



