

# Mapping

Represents a mapping between a code in one terminology and code in another terminology

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
|**mapset** | [**MapsetRef**](MapsetRef.md) |  |  [optional] |
|**from** | [**ConceptRef**](ConceptRef.md) |  |  [optional] |
|**to** | [**ConceptRef**](ConceptRef.md) |  |  [optional] |
|**group** | **String** | Grouping mechanism for a set of maps |  [optional] |
|**priority** | **String** | Priority indicator within a map group |  [optional] |
|**rule** | **String** | Machine-readable rule for when the map should be applied |  [optional] |
|**advice** | **List&lt;String&gt;** | Human-readable advice for how to use the map |  [optional] |
|**type** | **String** | Type of mapping between the \&quot;from\&quot; and \&quot;to\&quot; concepts. Often this is something like \&quot;equivalent\&quot;, \&quot;broader\&quot;, or \&quot;narrower\&quot; |  [optional] |
|**attributes** | **Map&lt;String, String&gt;** | Key/value pairs associated with this object |  [optional] |



