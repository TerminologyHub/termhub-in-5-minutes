

# SearchParameters

Represents parameters for a 'find' call.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**terminology** | **String** | Terminology filter, e.g. &#39;SNOMEDCT&#39; |  [optional] |
|**query** | **String** | Search query, e.g. &#39;aspirin&#39; |  [optional] |
|**expression** | **String** | Search expression, e.g. &#39;&lt;&lt; 404684003&#39; |  [optional] |
|**filters** | **Map&lt;String, String&gt;** | Additional field level filters (to specify that certain fields must have certain values) |  [optional] |
|**limit** | **Integer** | Limit on number of results, e.g. 10 |  [optional] |
|**offset** | **Integer** | Starting index for results, e.g. 0 |  [optional] |
|**active** | **Boolean** | Specifically search for &#39;active only&#39; or &#39;inactive only&#39; |  [optional] |
|**sort** | **List&lt;String&gt;** | Field of the data model being searched to sort by |  [optional] |
|**ascending** | **Boolean** | Used with &#39;sort&#39; to indicate ascending or descending |  [optional] |
|**leaf** | **Boolean** | Specifically search for &#39;leaf only&#39; or &#39;leaf only&#39; |  [optional] |



