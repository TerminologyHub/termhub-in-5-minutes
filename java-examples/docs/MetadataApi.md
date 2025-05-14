# MetadataApi

All URIs are relative to *https://dev.terminologyhub.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**findMetadata**](MetadataApi.md#findMetadata) | **GET** /project/{idOrUriLabel}/metadata | Find project terminology metadata |
| [**getTerminologyMetadata**](MetadataApi.md#getTerminologyMetadata) | **GET** /terminology/{id}/metadata | Get terminology metadata |



## findMetadata

> ResultListMetadata findMetadata(idOrUriLabel, query, offset, limit, sort, ascending)

Find project terminology metadata

Find metadata for the terminologies of the specified project id or uri

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MetadataApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MetadataApi apiInstance = new MetadataApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String query = "query_example"; // String | Search text (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\">See here for more info</a>)
        Integer offset = 0; // Integer | Start index for search results
        Integer limit = 10; // Integer | Limit of results to return (hard limit of 1000 regardless of value)
        String sort = "sort_example"; // String | Comma-separated list of fields to sort on
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        try {
            ResultListMetadata result = apiInstance.findMetadata(idOrUriLabel, query, offset, limit, sort, ascending);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MetadataApi#findMetadata");
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
| **idOrUriLabel** | **String**| Project id or uriLabel, e.g. \&quot;sandbox\&quot; | |
| **query** | **String**| Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) | [optional] |
| **offset** | **Integer**| Start index for search results | [optional] [default to 0] |
| **limit** | **Integer**| Limit of results to return (hard limit of 1000 regardless of value) | [optional] [default to 10] |
| **sort** | **String**| Comma-separated list of fields to sort on | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |

### Return type

[**ResultListMetadata**](ResultListMetadata.md)

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
| **200** | Matadata for the specified project and query parameters |  -  |
| **401** | Unauthorized |  -  |
| **500** | Internal server error |  -  |


## getTerminologyMetadata

> List&lt;Metadata&gt; getTerminologyMetadata(id)

Get terminology metadata

Gets terminology metadata for the specified terminology id

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MetadataApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MetadataApi apiInstance = new MetadataApi(defaultClient);
        String id = "id_example"; // String | Terminology id, e.g. \"uuid\"
        try {
            List<Metadata> result = apiInstance.getTerminologyMetadata(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MetadataApi#getTerminologyMetadata");
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
| **id** | **String**| Terminology id, e.g. \&quot;uuid\&quot; | |

### Return type

[**List&lt;Metadata&gt;**](Metadata.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **403** | Forbidden |  -  |
| **200** | Terminology |  -  |
| **404** | Not Found |  -  |
| **401** | Unauthorized |  -  |
| **500** | Internal server error |  -  |

