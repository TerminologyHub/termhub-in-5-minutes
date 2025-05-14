# TermApi

All URIs are relative to *https://dev.terminologyhub.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**autocomplete**](TermApi.md#autocomplete) | **GET** /project/{idOrUriLabel}/autocomplete | Suggest autocompletions for text while searching |
| [**findTerms**](TermApi.md#findTerms) | **GET** /project/{idOrUriLabel}/term | Find terms across project terminologies |



## autocomplete

> List&lt;String&gt; autocomplete(idOrUriLabel, query, terminology, limit)

Suggest autocompletions for text while searching

Finds top ten strings matching input query.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TermApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TermApi apiInstance = new TermApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel
        String query = "query_example"; // String | Search text
        String terminology = "terminology_example"; // String | Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \"uuid1,uuid2\", \"SNOMEDCT,RXNORM\", or \"ICD10CM\".
        Integer limit = 10; // Integer | Limit of results to return (hard limit of 1000 regardless of value)
        try {
            List<String> result = apiInstance.autocomplete(idOrUriLabel, query, terminology, limit);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TermApi#autocomplete");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **idOrUriLabel** | **String**| Project id or uriLabel | |
| **query** | **String**| Search text | |
| **terminology** | **String**| Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. | [optional] |
| **limit** | **Integer**| Limit of results to return (hard limit of 1000 regardless of value) | [optional] |

### Return type

**List&lt;String&gt;**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of top ten matching strings |  -  |
| **403** | Forbidden |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |


## findTerms

> ResultListTerm findTerms(idOrUriLabel, terminology, query, offset, limit, sort, ascending, active)

Find terms across project terminologies

Finds terms matching specified search criteria.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TermApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TermApi apiInstance = new TermApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel
        String terminology = "terminology_example"; // String | Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \"uuid1,uuid2\", \"SNOMEDCT,RXNORM\", or \"ICD10CM\".
        String query = "query_example"; // String | Search text (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\">See here for more info</a>)
        Integer offset = 0; // Integer | Start index for search results
        Integer limit = 10; // Integer | Limit of results to return (hard limit of 1000 regardless of value)
        String sort = "sort_example"; // String | Comma-separated list of fields to sort on
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        Boolean active = true; // Boolean | <code>true</code> for active terms only, <code>false</code> for inactive terms only, <code>null</code> for both
        try {
            ResultListTerm result = apiInstance.findTerms(idOrUriLabel, terminology, query, offset, limit, sort, ascending, active);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TermApi#findTerms");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **idOrUriLabel** | **String**| Project id or uriLabel | |
| **terminology** | **String**| Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. | [optional] |
| **query** | **String**| Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) | [optional] |
| **offset** | **Integer**| Start index for search results | [optional] |
| **limit** | **Integer**| Limit of results to return (hard limit of 1000 regardless of value) | [optional] |
| **sort** | **String**| Comma-separated list of fields to sort on | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |
| **active** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for active terms only, &lt;code&gt;false&lt;/code&gt; for inactive terms only, &lt;code&gt;null&lt;/code&gt; for both | [optional] |

### Return type

[**ResultListTerm**](ResultListTerm.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **403** | Forbidden |  -  |
| **404** | Not found |  -  |
| **200** | Result list of matching terms |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |

