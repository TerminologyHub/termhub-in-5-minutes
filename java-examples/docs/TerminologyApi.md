# TerminologyApi

All URIs are relative to *https://dev.terminologyhub.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**exportTerminology**](TerminologyApi.md#exportTerminology) | **GET** /project/{idOrUriLabel}/terminology/{terminology}/export | Export terminology |
| [**findTerminologies**](TerminologyApi.md#findTerminologies) | **GET** /terminology | Find terminologies |
| [**getProjectTerminologies**](TerminologyApi.md#getProjectTerminologies) | **GET** /project/{idOrUriLabel}/terminology | Get project terminologies |
| [**getTerminology**](TerminologyApi.md#getTerminology) | **GET** /terminology/{id} | Get terminology by id |



## exportTerminology

> byte[] exportTerminology(idOrUriLabel, terminology, format)

Export terminology

Exports specified terminology in the specified format.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String terminology = "terminology_example"; // String | Terminology id or abbreviation. e.g. \"uuid1\" or \"ICD10CM\".
        String format = "format_example"; // String | Requested download format, e.g. \"native\"
        try {
            byte[] result = apiInstance.exportTerminology(idOrUriLabel, terminology, format);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#exportTerminology");
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
| **terminology** | **String**| Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. | |
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
| **200** | Export terminology matching specified criteria |  -  |
| **401** | Unauthorized |  -  |
| **500** | Internal server error |  -  |


## findTerminologies

> ResultListTerminology findTerminologies(query, offset, limit, sort, ascending)

Find terminologies

Finds terminologies matching specified criteria.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String query = "query_example"; // String | Search text (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\">See here for more info</a>)
        Integer offset = 0; // Integer | Start index for search results
        Integer limit = 10; // Integer | Limit of results to return (hard limit of 1000 regardless of value)
        String sort = "sort_example"; // String | Comma-separated list of fields to sort on
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        try {
            ResultListTerminology result = apiInstance.findTerminologies(query, offset, limit, sort, ascending);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#findTerminologies");
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
| **query** | **String**| Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) | [optional] |
| **offset** | **Integer**| Start index for search results | [optional] |
| **limit** | **Integer**| Limit of results to return (hard limit of 1000 regardless of value) | [optional] |
| **sort** | **String**| Comma-separated list of fields to sort on | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |

### Return type

[**ResultListTerminology**](ResultListTerminology.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **403** | Forbidden |  -  |
| **200** | Result list of matching terminologies |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |


## getProjectTerminologies

> List&lt;Terminology&gt; getProjectTerminologies(idOrUriLabel)

Get project terminologies

Gets terminology objects used by the specified project.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        try {
            List<Terminology> result = apiInstance.getProjectTerminologies(idOrUriLabel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#getProjectTerminologies");
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

[**List&lt;Terminology&gt;**](Terminology.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Result list of project terminologies |  -  |
| **403** | Forbidden |  -  |
| **404** | Not found |  -  |
| **401** | Unauthorized |  -  |
| **500** | Internal server error |  -  |


## getTerminology

> Terminology getTerminology(id)

Get terminology by id

Gets terminology for the specified id

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String id = "id_example"; // String | Terminology id, e.g. \"uuid\"
        try {
            Terminology result = apiInstance.getTerminology(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#getTerminology");
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

[**Terminology**](Terminology.md)

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

