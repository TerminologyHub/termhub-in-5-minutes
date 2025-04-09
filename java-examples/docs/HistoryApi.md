# HistoryApi

All URIs are relative to *https://dev.terminologyhub.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**exportTerminologyHistoryNewConcepts**](HistoryApi.md#exportTerminologyHistoryNewConcepts) | **GET** /terminology/{id}/history/{priorVersion}/concepts/new/export | Exports terminology concepts added since prior version |
| [**exportTerminologyHistoryRetiredConcepts**](HistoryApi.md#exportTerminologyHistoryRetiredConcepts) | **GET** /terminology/{id}/history/{priorVersion}/concepts/retired/export | Exports terminology concepts retired since prior version |
| [**getTerminologyHistoryNewConcepts**](HistoryApi.md#getTerminologyHistoryNewConcepts) | **GET** /terminology/{id}/history/{priorVersion}/concepts/new | Get terminology concepts added since prior version |
| [**getTerminologyHistoryRetiredConcepts**](HistoryApi.md#getTerminologyHistoryRetiredConcepts) | **GET** /terminology/{id}/history/{priorVersion}/concepts/retired | Get terminology concepts retired since prior version |



## exportTerminologyHistoryNewConcepts

> File exportTerminologyHistoryNewConcepts(id, priorVersion)

Exports terminology concepts added since prior version

Exports concept code/name/semanticType for concepts added in the terminology since the specified older version

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.HistoryApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        HistoryApi apiInstance = new HistoryApi(defaultClient);
        String id = "id_example"; // String | Terminology id, e.g. \"uuid\"
        String priorVersion = "priorVersion_example"; // String | Prior terminology version, e.g. \"20240101\"
        try {
            File result = apiInstance.exportTerminologyHistoryNewConcepts(id, priorVersion);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling HistoryApi#exportTerminologyHistoryNewConcepts");
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
| **priorVersion** | **String**| Prior terminology version, e.g. \&quot;20240101\&quot; | |

### Return type

[**File**](File.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **200** | File of concepts added since prior version |  -  |
| **401** | Unauthorized |  -  |
| **500** | Internal server error |  -  |


## exportTerminologyHistoryRetiredConcepts

> File exportTerminologyHistoryRetiredConcepts(id, priorVersion)

Exports terminology concepts retired since prior version

Exports concept code/name for concepts retired in the terminology since the specified prior version

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.HistoryApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        HistoryApi apiInstance = new HistoryApi(defaultClient);
        String id = "id_example"; // String | Terminology id, e.g. \"uuid\"
        String priorVersion = "priorVersion_example"; // String | Prior terminology version, e.g. \"20240101\"
        try {
            File result = apiInstance.exportTerminologyHistoryRetiredConcepts(id, priorVersion);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling HistoryApi#exportTerminologyHistoryRetiredConcepts");
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
| **priorVersion** | **String**| Prior terminology version, e.g. \&quot;20240101\&quot; | |

### Return type

[**File**](File.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **200** | File of concepts retired since prior version |  -  |
| **401** | Unauthorized |  -  |
| **500** | Internal server error |  -  |


## getTerminologyHistoryNewConcepts

> List&lt;ConceptRef&gt; getTerminologyHistoryNewConcepts(id, priorVersion)

Get terminology concepts added since prior version

Gets concept code/name for new active concepts in the terminology since the specified prior version

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.HistoryApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        HistoryApi apiInstance = new HistoryApi(defaultClient);
        String id = "id_example"; // String | Terminology id, e.g. \"uuid\"
        String priorVersion = "priorVersion_example"; // String | Prior terminology version, e.g. \"20240101\"
        try {
            List<ConceptRef> result = apiInstance.getTerminologyHistoryNewConcepts(id, priorVersion);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling HistoryApi#getTerminologyHistoryNewConcepts");
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
| **priorVersion** | **String**| Prior terminology version, e.g. \&quot;20240101\&quot; | |

### Return type

[**List&lt;ConceptRef&gt;**](ConceptRef.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of concept code/name that are new |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **401** | Unauthorized |  -  |
| **500** | Internal server error |  -  |


## getTerminologyHistoryRetiredConcepts

> List&lt;ConceptRef&gt; getTerminologyHistoryRetiredConcepts(id, priorVersion)

Get terminology concepts retired since prior version

Gets concept code/name/semanticType for concepts retired in the terminology since the specified prior version

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.HistoryApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        HistoryApi apiInstance = new HistoryApi(defaultClient);
        String id = "id_example"; // String | Terminology id, e.g. \"uuid\"
        String priorVersion = "priorVersion_example"; // String | Prior terminology version, e.g. \"20240101\"
        try {
            List<ConceptRef> result = apiInstance.getTerminologyHistoryRetiredConcepts(id, priorVersion);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling HistoryApi#getTerminologyHistoryRetiredConcepts");
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
| **priorVersion** | **String**| Prior terminology version, e.g. \&quot;20240101\&quot; | |

### Return type

[**List&lt;ConceptRef&gt;**](ConceptRef.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of concept code/name that are now retired |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **401** | Unauthorized |  -  |
| **500** | Internal server error |  -  |

