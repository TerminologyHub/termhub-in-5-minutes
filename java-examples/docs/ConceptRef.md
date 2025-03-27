

# ConceptRef

Represents enough information to uniquely reference a concept in a terminology

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
|**name** | **String** | Concept name |  [optional] |
|**code** | **String** | Terminology code, typically representing a unit of meaning |  [optional] |
|**terminology** | **String** | Terminology abbreviation |  [optional] |
|**version** | **String** | Terminology version |  [optional] |
|**publisher** | **String** | Terminology publisher |  [optional] |
|**historical** | **String** | Historical relationship type (only used for concept descendants) |  [optional] |
|**leaf** | **Boolean** | Indicates whether or not this concept is a leaf node in its hierarchy |  [optional] |
|**defined** | **Boolean** | Indicates whether or not this concept has a logical definition with necessary and sufficient conditions |  [optional] |
|**level** | **Integer** | Level of depth |  [optional] |



