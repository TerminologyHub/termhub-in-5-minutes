

# Term

Represents a name of a concept in a terminology with associated information

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
|**name** | **String** | Name associated with this term |  [optional] |
|**terminology** | **String** | Terminology abbreviation, e.g. \&quot;SNOMEDCT\&quot; |  [optional] |
|**version** | **String** | Terminology version, e.g. \&quot;20230901\&quot; |  [optional] |
|**publisher** | **String** | Terminology publisher, e.g. \&quot;SNOMEDCT\&quot; |  [optional] |
|**componentId** | **String** | Identifier for this object in the published source terminology |  [optional] |
|**code** | **String** | Code of the concept containing this term |  [optional] |
|**conceptId** | **String** | Concept id of the concept containing this term (typically this is the same as the code, but may be different for some terminologies) |  [optional] |
|**descriptorId** | **String** | Descriptor id of the concept containing this term (only relevant for termionlogies that define descriptor codes) |  [optional] |
|**localeMap** | **Map&lt;String, Boolean&gt;** | Map of language (optionally with locale) to true/false indicating whether this term is the preferred term in that language or not.  An entrywith true indicates that it is preferred in that language. An entry with false indicates that it is valid for that language but not preferred. |  [optional] |
|**type** | **String** | Term type, e.g. \&quot;PT\&quot; or \&quot;900000000000013009\&quot; |  [optional] |
|**attributes** | **Map&lt;String, String&gt;** | Key/value pairs associated with this object |  [optional] |



