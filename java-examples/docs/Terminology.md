

# Terminology

Represents a terminology abbreviation and associated metadata

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
|**abbreviation** | **String** | Terminology abbreviation, e.g. \&quot;SNOMEDCT\&quot; |  [optional] |
|**name** | **String** |  |  [optional] |
|**version** | **String** | Terminology version, e.g. \&quot;20230901\&quot; |  [optional] |
|**publisher** | **String** | Terminology publisher, e.g. \&quot;SNOMEDCT\&quot; |  [optional] |
|**latest** | **Boolean** | Indicates whether this is the latest version of the terminology |  [optional] |
|**loaded** | **Boolean** | Indicates whether this is the version of the terminology is loaded |  [optional] |
|**releaseDate** | **String** | YYYY-MM-DD rendering of the release date |  [optional] |
|**family** | **String** | Family of related terminologies this one belongs to |  [optional] |
|**uri** | **String** | Uri for downloading the terminology |  [optional] |
|**attributes** | **Map&lt;String, String&gt;** | Key/value pairs associated with this object |  [optional] |
|**roots** | **List&lt;String&gt;** | Root codes in the hierarchy |  [optional] |
|**conceptCt** | **Long** | Count of number of concepts in the terminology |  [optional] |
|**relationshipCt** | **Long** | Count of number of concept relationships in the terminology |  [optional] |
|**treePositionCt** | **Long** | Count of number of concept tree positions in the terminology |  [optional] |
|**statistics** | **Map&lt;String, Integer&gt;** |  |  [optional] |



