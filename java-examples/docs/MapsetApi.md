# MapsetApi

All URIs are relative to *https://dev.terminologyhub.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**exportMapset**](MapsetApi.md#exportMapset) | **GET** /project/{idOrUriLabel}/mapset/{mapset}/export | Export mapset |
| [**exportMapsetMappings**](MapsetApi.md#exportMapsetMappings) | **GET** /project/{idOrUriLabel}/mapset/{mapset}/mappings/export | Export mappings for project mapset |
| [**findMappings**](MapsetApi.md#findMappings) | **GET** /project/{idOrUriLabel}/mapping | Find mappings across project mapsets |
| [**findMapsetMappings**](MapsetApi.md#findMapsetMappings) | **GET** /project/{idOrUriLabel}/mapset/{mapset}/mappings | Find mappings for the specified mapset |
| [**findMapsets**](MapsetApi.md#findMapsets) | **GET** /mapset | Find mapsets |
| [**getMapset**](MapsetApi.md#getMapset) | **GET** /mapset/{id} | Get mapset by id |
| [**getProjectMapsets**](MapsetApi.md#getProjectMapsets) | **GET** /project/{idOrUriLabel}/mapset | Get project mapsets |



## exportMapset

> byte[] exportMapset(idOrUriLabel, mapset, format)

Export mapset

Exports specified mapset in the specified format.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MapsetApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MapsetApi apiInstance = new MapsetApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String mapset = "mapset_example"; // String | Mapset id or abbreviation e.g. \"uuid1\" or \"CVX-NDC\".
        String format = "format_example"; // String | Requested download format, e.g. \"native\"
        try {
            byte[] result = apiInstance.exportMapset(idOrUriLabel, mapset, format);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MapsetApi#exportMapset");
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
| **mapset** | **String**| Mapset id or abbreviation e.g. \&quot;uuid1\&quot; or \&quot;CVX-NDC\&quot;. | |
| **format** | **String**| Requested download format, e.g. \&quot;native\&quot; | |

### Return type

**byte[]**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **403** | Forbidden |  -  |
| **200** | Export mapset matching specified criteria |  -  |
| **401** | Unauthorized |  -  |
| **500** | Internal server error |  -  |


## exportMapsetMappings

> File exportMapsetMappings(idOrUriLabel, mapset, query, active, leaf)

Export mappings for project mapset

Exports mapping matching specified search criteria.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MapsetApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MapsetApi apiInstance = new MapsetApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel
        String mapset = "mapset_example"; // String | Comma-separated list of mapset ids or abbreviations (or null for all mapsets). e.g. \"uuid1,uuid2\", \"SNOMEDCT_US-ICD10CM,CVX-NDC\".
        String query = "query_example"; // String | Search text
        Boolean active = true; // Boolean | <code>true</code> for active mappings only, <code>false</code> for inactive mappings only, <code>null</code> for both
        Boolean leaf = true; // Boolean | <code>true</code> for leaf nodes only, <code>false</code> for non-leaf nodes, <code>null</code> for either
        try {
            File result = apiInstance.exportMapsetMappings(idOrUriLabel, mapset, query, active, leaf);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MapsetApi#exportMapsetMappings");
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
| **mapset** | **String**| Comma-separated list of mapset ids or abbreviations (or null for all mapsets). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT_US-ICD10CM,CVX-NDC\&quot;. | |
| **query** | **String**| Search text | [optional] |
| **active** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for active mappings only, &lt;code&gt;false&lt;/code&gt; for inactive mappings only, &lt;code&gt;null&lt;/code&gt; for both | [optional] |
| **leaf** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either | [optional] |

### Return type

[**File**](File.md)

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
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |
| **200** | Tab separated values file content for matching mappings |  -  |


## findMappings

> ResultListMapping findMappings(idOrUriLabel, mapset, query, offset, limit, sort, ascending, active, leaf)

Find mappings across project mapsets

Finds mapping matching specified search criteria.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MapsetApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MapsetApi apiInstance = new MapsetApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel
        String mapset = "mapset_example"; // String | Comma-separated list of mapset ids or abbreviations (or null for all mapsets). e.g. \"uuid1,uuid2\", \"SNOMEDCT_US-ICD10CM,CVX-NDC\".
        String query = "query_example"; // String | Search text
        Integer offset = 0; // Integer | Start index for search results
        Integer limit = 10; // Integer | Limit of results to return (hard limit of 1000 regardless of value)
        String sort = "sort_example"; // String | Comma-separated list of fields to sort on
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        Boolean active = true; // Boolean | <code>true</code> for active mappings only, <code>false</code> for inactive mappings only, <code>null</code> for both
        Boolean leaf = true; // Boolean | <code>true</code> for leaf nodes only, <code>false</code> for non-leaf nodes, <code>null</code> for either
        try {
            ResultListMapping result = apiInstance.findMappings(idOrUriLabel, mapset, query, offset, limit, sort, ascending, active, leaf);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MapsetApi#findMappings");
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
| **mapset** | **String**| Comma-separated list of mapset ids or abbreviations (or null for all mapsets). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT_US-ICD10CM,CVX-NDC\&quot;. | [optional] |
| **query** | **String**| Search text | [optional] |
| **offset** | **Integer**| Start index for search results | [optional] |
| **limit** | **Integer**| Limit of results to return (hard limit of 1000 regardless of value) | [optional] |
| **sort** | **String**| Comma-separated list of fields to sort on | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |
| **active** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for active mappings only, &lt;code&gt;false&lt;/code&gt; for inactive mappings only, &lt;code&gt;null&lt;/code&gt; for both | [optional] |
| **leaf** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either | [optional] |

### Return type

[**ResultListMapping**](ResultListMapping.md)

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
| **200** | Result list of matching mappings |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |


## findMapsetMappings

> ResultListMapping findMapsetMappings(idOrUriLabel, mapset, query, offset, limit, sort, ascending, active, leaf)

Find mappings for the specified mapset

Finds mapping for the specified mapset and the specified search criteria.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MapsetApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MapsetApi apiInstance = new MapsetApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel
        String mapset = "mapset_example"; // String | Mapset id or abbreviation e.g. \"uuid1\" or \"CVX-NDC\".
        String query = "query_example"; // String | Search text
        Integer offset = 0; // Integer | Start index for search results
        Integer limit = 10; // Integer | Limit of results to return (hard limit of 1000 regardless of value)
        String sort = "sort_example"; // String | Comma-separated list of fields to sort on
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        Boolean active = true; // Boolean | <code>true</code> for active mappings only, <code>false</code> for inactive mappings only, <code>null</code> for both
        Boolean leaf = true; // Boolean | <code>true</code> for leaf nodes only, <code>false</code> for non-leaf nodes, <code>null</code> for either
        try {
            ResultListMapping result = apiInstance.findMapsetMappings(idOrUriLabel, mapset, query, offset, limit, sort, ascending, active, leaf);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MapsetApi#findMapsetMappings");
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
| **mapset** | **String**| Mapset id or abbreviation e.g. \&quot;uuid1\&quot; or \&quot;CVX-NDC\&quot;. | |
| **query** | **String**| Search text | [optional] |
| **offset** | **Integer**| Start index for search results | [optional] |
| **limit** | **Integer**| Limit of results to return (hard limit of 1000 regardless of value) | [optional] |
| **sort** | **String**| Comma-separated list of fields to sort on | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |
| **active** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for active mappings only, &lt;code&gt;false&lt;/code&gt; for inactive mappings only, &lt;code&gt;null&lt;/code&gt; for both | [optional] |
| **leaf** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either | [optional] |

### Return type

[**ResultListMapping**](ResultListMapping.md)

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
| **200** | Result list of matching mappings |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |


## findMapsets

> ResultListMapset findMapsets(query, offset, limit, sort, ascending)

Find mapsets

Finds mapsets matching specified criteria.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MapsetApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MapsetApi apiInstance = new MapsetApi(defaultClient);
        String query = "query_example"; // String | Search text
        Integer offset = 0; // Integer | Start index for search results
        Integer limit = 10; // Integer | Limit of results to return (hard limit of 1000 regardless of value)
        String sort = "sort_example"; // String | Comma-separated list of fields to sort on
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        try {
            ResultListMapset result = apiInstance.findMapsets(query, offset, limit, sort, ascending);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MapsetApi#findMapsets");
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
| **query** | **String**| Search text | [optional] |
| **offset** | **Integer**| Start index for search results | [optional] |
| **limit** | **Integer**| Limit of results to return (hard limit of 1000 regardless of value) | [optional] |
| **sort** | **String**| Comma-separated list of fields to sort on | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |

### Return type

[**ResultListMapset**](ResultListMapset.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **403** | Forbidden |  -  |
| **200** | Result list of matching mapsets |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |


## getMapset

> Mapset getMapset(id)

Get mapset by id

Gets mapset for the specified id

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MapsetApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MapsetApi apiInstance = new MapsetApi(defaultClient);
        String id = "id_example"; // String | Mapset id, e.g. \"uuid\"
        try {
            Mapset result = apiInstance.getMapset(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MapsetApi#getMapset");
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
| **id** | **String**| Mapset id, e.g. \&quot;uuid\&quot; | |

### Return type

[**Mapset**](Mapset.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **200** | Mapset |  -  |
| **401** | Unauthorized |  -  |
| **500** | Internal server error |  -  |


## getProjectMapsets

> List&lt;Mapset&gt; getProjectMapsets(idOrUriLabel)

Get project mapsets

Gets mapset objects used by the specified project.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MapsetApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MapsetApi apiInstance = new MapsetApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        try {
            List<Mapset> result = apiInstance.getProjectMapsets(idOrUriLabel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MapsetApi#getProjectMapsets");
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

### Return type

[**List&lt;Mapset&gt;**](Mapset.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **403** | Forbidden |  -  |
| **200** | Result list of project mapsets |  -  |
| **404** | Not found |  -  |
| **401** | Unauthorized |  -  |
| **500** | Internal server error |  -  |

