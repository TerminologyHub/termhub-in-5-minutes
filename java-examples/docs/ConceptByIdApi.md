# ConceptByIdApi

All URIs are relative to *https://dev.terminologyhub.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**findConceptInverseRelationships1**](ConceptByIdApi.md#findConceptInverseRelationships1) | **GET** /project/{idOrUriLabel}/concept/{conceptId}/inverseRelationships | Find concept inverse relationships |
| [**findConceptRelationships1**](ConceptByIdApi.md#findConceptRelationships1) | **GET** /project/{idOrUriLabel}/concept/{conceptId}/relationships | Find concept relationships |
| [**findTreePositionChildren1**](ConceptByIdApi.md#findTreePositionChildren1) | **GET** /project/{idOrUriLabel}/concept/{conceptId}/trees/children | Find concept tree position children |
| [**findTreePositions1**](ConceptByIdApi.md#findTreePositions1) | **GET** /project/{idOrUriLabel}/concept/{conceptId}/trees | Find concept tree positions |
| [**getConcept1**](ConceptByIdApi.md#getConcept1) | **GET** /project/{idOrUriLabel}/concept/{conceptId} | Get concept by id |
| [**getConceptDiagram1**](ConceptByIdApi.md#getConceptDiagram1) | **GET** /project/{idOrUriLabel}/concept/{conceptId}/diagram | Get concept diagram |
| [**getConceptInverseMappings1**](ConceptByIdApi.md#getConceptInverseMappings1) | **GET** /project/{idOrUriLabel}/concept/{conceptId}/inverseMappings | Get mappings to concept by id |
| [**getConceptMappings1**](ConceptByIdApi.md#getConceptMappings1) | **GET** /project/{idOrUriLabel}/concept/{conceptId}/mappings | Get mappings from concept by id |



## findConceptInverseRelationships1

> ResultListConceptRelationship findConceptInverseRelationships1(idOrUriLabel, conceptId, query, offset, limit, ascending, sort)

Find concept inverse relationships

Finds concept inverse relationships for the specified concept id.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByIdApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByIdApi apiInstance = new ConceptByIdApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String conceptId = "conceptId_example"; // String | concept id, e.g. \"uuid\"
        String query = "query_example"; // String | Search text (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\">See here for more info</a>)
        Integer offset = 0; // Integer | Start index for search results
        Integer limit = 10; // Integer | Limit of results to return (hard limit of 1000 regardless of value)
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        String sort = "sort_example"; // String | Comma-separated list of fields to sort on
        try {
            ResultListConceptRelationship result = apiInstance.findConceptInverseRelationships1(idOrUriLabel, conceptId, query, offset, limit, ascending, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByIdApi#findConceptInverseRelationships1");
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
| **conceptId** | **String**| concept id, e.g. \&quot;uuid\&quot; | |
| **query** | **String**| Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) | [optional] |
| **offset** | **Integer**| Start index for search results | [optional] [default to 0] |
| **limit** | **Integer**| Limit of results to return (hard limit of 1000 regardless of value) | [optional] [default to 10] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |
| **sort** | **String**| Comma-separated list of fields to sort on | [optional] |

### Return type

[**ResultListConceptRelationship**](ResultListConceptRelationship.md)

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
| **200** | Result list of matching concept inverse relationships |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |


## findConceptRelationships1

> ResultListConceptRelationship findConceptRelationships1(idOrUriLabel, conceptId, query, offset, limit, ascending, sort)

Find concept relationships

Finds concept relationships for the specified concept id.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByIdApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByIdApi apiInstance = new ConceptByIdApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String conceptId = "conceptId_example"; // String | concept id, e.g. \"uuid\"
        String query = "query_example"; // String | Search text (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\">See here for more info</a>)
        Integer offset = 0; // Integer | Start index for search results
        Integer limit = 10; // Integer | Limit of results to return (hard limit of 1000 regardless of value)
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        String sort = "sort_example"; // String | Comma-separated list of fields to sort on
        try {
            ResultListConceptRelationship result = apiInstance.findConceptRelationships1(idOrUriLabel, conceptId, query, offset, limit, ascending, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByIdApi#findConceptRelationships1");
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
| **conceptId** | **String**| concept id, e.g. \&quot;uuid\&quot; | |
| **query** | **String**| Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) | [optional] |
| **offset** | **Integer**| Start index for search results | [optional] [default to 0] |
| **limit** | **Integer**| Limit of results to return (hard limit of 1000 regardless of value) | [optional] [default to 10] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |
| **sort** | **String**| Comma-separated list of fields to sort on | [optional] |

### Return type

[**ResultListConceptRelationship**](ResultListConceptRelationship.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Result list of matching concept relationships |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |


## findTreePositionChildren1

> ResultListConceptTreePosition findTreePositionChildren1(idOrUriLabel, conceptId, query, offset, limit, ascending, sort)

Find concept tree position children

Finds concept tree position children for the specified concept id.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByIdApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByIdApi apiInstance = new ConceptByIdApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String conceptId = "conceptId_example"; // String | concept id, e.g. \"uuid\"
        String query = "query_example"; // String | Search text (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\">See here for more info</a>)
        Integer offset = 0; // Integer | Start index for search results
        Integer limit = 10; // Integer | Limit of results to return (hard limit of 1000 regardless of value)
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        String sort = "sort_example"; // String | Comma-separated list of fields to sort on
        try {
            ResultListConceptTreePosition result = apiInstance.findTreePositionChildren1(idOrUriLabel, conceptId, query, offset, limit, ascending, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByIdApi#findTreePositionChildren1");
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
| **conceptId** | **String**| concept id, e.g. \&quot;uuid\&quot; | |
| **query** | **String**| Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) | [optional] |
| **offset** | **Integer**| Start index for search results | [optional] [default to 0] |
| **limit** | **Integer**| Limit of results to return (hard limit of 1000 regardless of value) | [optional] [default to 10] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |
| **sort** | **String**| Comma-separated list of fields to sort on | [optional] |

### Return type

[**ResultListConceptTreePosition**](ResultListConceptTreePosition.md)

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
| **200** | Result list of matching concept tree position children |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |


## findTreePositions1

> ResultListConceptTreePosition findTreePositions1(idOrUriLabel, conceptId, query, offset, limit, ascending, sort)

Find concept tree positions

Finds concept tree positions for the specified concept id.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByIdApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByIdApi apiInstance = new ConceptByIdApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String conceptId = "conceptId_example"; // String | concept id, e.g. \"uuid\"
        String query = "query_example"; // String | Search text (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\">See here for more info</a>)
        Integer offset = 0; // Integer | Start index for search results
        Integer limit = 10; // Integer | Limit of results to return (hard limit of 1000 regardless of value)
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        String sort = "sort_example"; // String | Comma-separated list of fields to sort on
        try {
            ResultListConceptTreePosition result = apiInstance.findTreePositions1(idOrUriLabel, conceptId, query, offset, limit, ascending, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByIdApi#findTreePositions1");
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
| **conceptId** | **String**| concept id, e.g. \&quot;uuid\&quot; | |
| **query** | **String**| Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) | [optional] |
| **offset** | **Integer**| Start index for search results | [optional] [default to 0] |
| **limit** | **Integer**| Limit of results to return (hard limit of 1000 regardless of value) | [optional] [default to 10] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |
| **sort** | **String**| Comma-separated list of fields to sort on | [optional] |

### Return type

[**ResultListConceptTreePosition**](ResultListConceptTreePosition.md)

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
| **200** | Result list of matching concept tree positions |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |


## getConcept1

> Concept getConcept1(idOrUriLabel, conceptId, include)

Get concept by id

Gets concept for the specified id

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByIdApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByIdApi apiInstance = new ConceptByIdApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String conceptId = "conceptId_example"; // String | concept id, e.g. \"uuid\"
        String include = "include_example"; // String | Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions<a target=\"_blank\" href='https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md' target='_blank'>See here for detailed information</a>.
        try {
            Concept result = apiInstance.getConcept1(idOrUriLabel, conceptId, include);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByIdApi#getConcept1");
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
| **conceptId** | **String**| concept id, e.g. \&quot;uuid\&quot; | |
| **include** | **String**| Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;&#39;https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md&#39; target&#x3D;&#39;_blank&#39;&gt;See here for detailed information&lt;/a&gt;. | [optional] |

### Return type

[**Concept**](Concept.md)

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
| **200** | Concept matching specified id in specified project |  -  |
| **401** | Unauthorized |  -  |
| **500** | Internal server error |  -  |


## getConceptDiagram1

> getConceptDiagram1(idOrUriLabel, conceptId)

Get concept diagram

Gets concept diagram for the specified concept.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByIdApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByIdApi apiInstance = new ConceptByIdApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String conceptId = "conceptId_example"; // String | concept id, e.g. \"uuid\"
        try {
            apiInstance.getConceptDiagram1(idOrUriLabel, conceptId);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByIdApi#getConceptDiagram1");
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
| **conceptId** | **String**| concept id, e.g. \&quot;uuid\&quot; | |

### Return type

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, image/png

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **404** | Not found |  -  |
| **417** | Not found |  -  |
| **200** | Concept diagram |  -  |
| **500** | Internal server error |  -  |
| **403** | Forbidden |  -  |
| **401** | Unauthorized |  -  |


## getConceptInverseMappings1

> List&lt;Mapping&gt; getConceptInverseMappings1(idOrUriLabel, conceptId)

Get mappings to concept by id

Gets mappings to the specified concept

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByIdApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByIdApi apiInstance = new ConceptByIdApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String conceptId = "conceptId_example"; // String | concept id, e.g. \"uuid\"
        try {
            List<Mapping> result = apiInstance.getConceptInverseMappings1(idOrUriLabel, conceptId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByIdApi#getConceptInverseMappings1");
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
| **conceptId** | **String**| concept id, e.g. \&quot;uuid\&quot; | |

### Return type

[**List&lt;Mapping&gt;**](Mapping.md)

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
| **200** | Mappings to the concept matching specified id in specified project |  -  |
| **401** | Unauthorized |  -  |
| **500** | Internal server error |  -  |


## getConceptMappings1

> List&lt;Mapping&gt; getConceptMappings1(idOrUriLabel, conceptId)

Get mappings from concept by id

Gets mappings from the specified concept

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByIdApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByIdApi apiInstance = new ConceptByIdApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String conceptId = "conceptId_example"; // String | concept id, e.g. \"uuid\"
        try {
            List<Mapping> result = apiInstance.getConceptMappings1(idOrUriLabel, conceptId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByIdApi#getConceptMappings1");
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
| **conceptId** | **String**| concept id, e.g. \&quot;uuid\&quot; | |

### Return type

[**List&lt;Mapping&gt;**](Mapping.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **403** | Forbidden |  -  |
| **200** | Mappings from the concept matching specified id in specified project |  -  |
| **404** | Not found |  -  |
| **401** | Unauthorized |  -  |
| **500** | Internal server error |  -  |

