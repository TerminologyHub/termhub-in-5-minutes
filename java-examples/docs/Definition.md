

# Definition

Represents a textual definition of concept in a terminology

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
|**definition** | **String** | Text of the definition |  [optional] |
|**terminology** | **String** | Terminology abbreviation, e.g. \&quot;SNOMEDCT\&quot; |  [optional] |
|**version** | **String** | Terminology version, e.g. \&quot;20230901\&quot; |  [optional] |
|**publisher** | **String** | Terminology publisher, e.g. \&quot;SNOMEDCT\&quot; |  [optional] |
|**componentId** | **String** | Identifier for this object in the published source terminology |  [optional] |
|**localeMap** | **Map&lt;String, Boolean&gt;** | Map of language (optionally with locale) to true/false indicating whether this definition is the preferred definition in that language or not.  An entrywith true indicates that it is preferred in that language. An entry with false indicates that it is valid for that language but not preferred. |  [optional] |
|**attributes** | **Map&lt;String, String&gt;** | Key/value pairs associated with this object |  [optional] |



