# ConceptByCodeApi

All URIs are relative to *https://dev.terminologyhub.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**findConceptInverseRelationships**](ConceptByCodeApi.md#findConceptInverseRelationships) | **GET** /project/{idOrUriLabel}/concept/{terminology}/{code}/inverseRelationships | Find concept inverse relationships by terminology and code |
| [**findConceptRelationships**](ConceptByCodeApi.md#findConceptRelationships) | **GET** /project/{idOrUriLabel}/concept/{terminology}/{code}/relationships | Find concept relationships by terminology and code |
| [**findTreePositionChildren**](ConceptByCodeApi.md#findTreePositionChildren) | **GET** /project/{idOrUriLabel}/concept/{terminology}/{code}/trees/children | Find concept tree position children by terminology and code |
| [**findTreePositions**](ConceptByCodeApi.md#findTreePositions) | **GET** /project/{idOrUriLabel}/concept/{terminology}/{code}/trees | Find concept tree positions by terminology and code |
| [**getConcept**](ConceptByCodeApi.md#getConcept) | **GET** /project/{idOrUriLabel}/concept/{terminology}/{code} | Get concept by terminology and code |
| [**getConceptCodes**](ConceptByCodeApi.md#getConceptCodes) | **GET** /project/{idOrUriLabel}/concept/{terminology} | Get concepts by terminology and list of codes |
| [**getConceptDiagram**](ConceptByCodeApi.md#getConceptDiagram) | **GET** /project/{idOrUriLabel}/concept/{terminology}/{code}/diagram | Get concept diagram by terminology and code |
| [**getConceptInverseMappings**](ConceptByCodeApi.md#getConceptInverseMappings) | **GET** /project/{idOrUriLabel}/concept/{terminology}/{code}/inverseMappings | Get mappings to concept by terminology and code |
| [**getConceptMappings**](ConceptByCodeApi.md#getConceptMappings) | **GET** /project/{idOrUriLabel}/concept/{terminology}/{code}/mappings | Get mappings from concept by terminology and code |



## findConceptInverseRelationships

> ResultListConceptRelationship findConceptInverseRelationships(idOrUriLabel, terminology, code, query, offset, limit, ascending, sort)

Find concept inverse relationships by terminology and code

Finds concept inverse relationships for the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByCodeApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByCodeApi apiInstance = new ConceptByCodeApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String terminology = "terminology_example"; // String | Terminology id or abbreviation. e.g. \"uuid1\" or \"ICD10CM\".
        String code = "code_example"; // String | Terminology code, e.g. \"1119\", \"8867-4\", or \"64572001\"
        String query = "query_example"; // String | Search text (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\">See here for more info</a>)
        Integer offset = 0; // Integer | Start index for search results
        Integer limit = 10; // Integer | Limit of results to return (hard limit of 1000 regardless of value)
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        String sort = "sort_example"; // String | Comma-separated list of fields to sort on
        try {
            ResultListConceptRelationship result = apiInstance.findConceptInverseRelationships(idOrUriLabel, terminology, code, query, offset, limit, ascending, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByCodeApi#findConceptInverseRelationships");
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
| **code** | **String**| Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; | |
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
| **404** | Not found |  -  |
| **200** | Result list of matching concept inverse relationships |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |


## findConceptRelationships

> ResultListConceptRelationship findConceptRelationships(idOrUriLabel, terminology, code, query, offset, limit, ascending, sort)

Find concept relationships by terminology and code

Finds concept relationships for the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByCodeApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByCodeApi apiInstance = new ConceptByCodeApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String terminology = "terminology_example"; // String | Terminology id or abbreviation. e.g. \"uuid1\" or \"ICD10CM\".
        String code = "code_example"; // String | Terminology code, e.g. \"1119\", \"8867-4\", or \"64572001\"
        String query = "query_example"; // String | Search text (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\">See here for more info</a>)
        Integer offset = 0; // Integer | Start index for search results
        Integer limit = 10; // Integer | Limit of results to return (hard limit of 1000 regardless of value)
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        String sort = "sort_example"; // String | Comma-separated list of fields to sort on
        try {
            ResultListConceptRelationship result = apiInstance.findConceptRelationships(idOrUriLabel, terminology, code, query, offset, limit, ascending, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByCodeApi#findConceptRelationships");
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
| **code** | **String**| Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; | |
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
| **404** | Not found |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |


## findTreePositionChildren

> ResultListConceptTreePosition findTreePositionChildren(idOrUriLabel, terminology, code, query, offset, limit, ascending, sort)

Find concept tree position children by terminology and code

Finds concept tree position children for the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByCodeApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByCodeApi apiInstance = new ConceptByCodeApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String terminology = "terminology_example"; // String | Terminology id or abbreviation. e.g. \"uuid1\" or \"ICD10CM\".
        String code = "code_example"; // String | Terminology code, e.g. \"1119\", \"8867-4\", or \"64572001\"
        String query = "query_example"; // String | Search text (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\">See here for more info</a>)
        Integer offset = 0; // Integer | Start index for search results
        Integer limit = 10; // Integer | Limit of results to return (hard limit of 1000 regardless of value)
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        String sort = "sort_example"; // String | Comma-separated list of fields to sort on
        try {
            ResultListConceptTreePosition result = apiInstance.findTreePositionChildren(idOrUriLabel, terminology, code, query, offset, limit, ascending, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByCodeApi#findTreePositionChildren");
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
| **code** | **String**| Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; | |
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
| **404** | Not found |  -  |
| **200** | Result list of matching concept tree position children |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |


## findTreePositions

> ResultListConceptTreePosition findTreePositions(idOrUriLabel, terminology, code, query, offset, limit, ascending, sort)

Find concept tree positions by terminology and code

Finds concept tree positions for the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByCodeApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByCodeApi apiInstance = new ConceptByCodeApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String terminology = "terminology_example"; // String | Terminology id or abbreviation. e.g. \"uuid1\" or \"ICD10CM\".
        String code = "code_example"; // String | Terminology code, e.g. \"1119\", \"8867-4\", or \"64572001\"
        String query = "query_example"; // String | Search text (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\">See here for more info</a>)
        Integer offset = 0; // Integer | Start index for search results
        Integer limit = 10; // Integer | Limit of results to return (hard limit of 1000 regardless of value)
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        String sort = "sort_example"; // String | Comma-separated list of fields to sort on
        try {
            ResultListConceptTreePosition result = apiInstance.findTreePositions(idOrUriLabel, terminology, code, query, offset, limit, ascending, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByCodeApi#findTreePositions");
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
| **code** | **String**| Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; | |
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
| **404** | Not found |  -  |
| **200** | Result list of matching concept tree positions |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |


## getConcept

> Concept getConcept(idOrUriLabel, terminology, code, include)

Get concept by terminology and code

Gets concept for the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByCodeApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByCodeApi apiInstance = new ConceptByCodeApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String terminology = "terminology_example"; // String | Terminology id or abbreviation. e.g. \"uuid1\" or \"ICD10CM\".
        String code = "code_example"; // String | Terminology code, e.g. \"1119\", \"8867-4\", or \"64572001\"
        String include = "include_example"; // String | Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions<a target=\"_blank\" href='https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md' target='_blank'>See here for detailed information</a>.
        try {
            Concept result = apiInstance.getConcept(idOrUriLabel, terminology, code, include);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByCodeApi#getConcept");
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
| **code** | **String**| Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; | |
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
| **200** | Concept matching specified terminology and code in specified project |  -  |
| **404** | Not found |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |


## getConceptCodes

> List&lt;Concept&gt; getConceptCodes(idOrUriLabel, terminology, codes, include)

Get concepts by terminology and list of codes

Gets concepts for the specified terminology and list of codes. This call will not work for projects hosting multiple versions of the same terminology.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByCodeApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByCodeApi apiInstance = new ConceptByCodeApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String terminology = "terminology_example"; // String | Terminology id or abbreviation. e.g. \"uuid1\" or \"ICD10CM\".
        String codes = "codes_example"; // String | Comma-separated list of terminology codes, e.g. \"1119,1149\" or \"64572001,22298006 \"
        String include = "include_example"; // String | Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions<a target=\"_blank\" href='https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md' target='_blank'>See here for detailed information</a>.
        try {
            List<Concept> result = apiInstance.getConceptCodes(idOrUriLabel, terminology, codes, include);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByCodeApi#getConceptCodes");
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
| **codes** | **String**| Comma-separated list of terminology codes, e.g. \&quot;1119,1149\&quot; or \&quot;64572001,22298006 \&quot; | |
| **include** | **String**| Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;&#39;https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md&#39; target&#x3D;&#39;_blank&#39;&gt;See here for detailed information&lt;/a&gt;. | [optional] |

### Return type

[**List&lt;Concept&gt;**](Concept.md)

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
| **200** | Concepts mathcing code list in the specified project |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |


## getConceptDiagram

> getConceptDiagram(idOrUriLabel, terminology, code)

Get concept diagram by terminology and code

Gets concept diagram for the specified terminology and code.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByCodeApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByCodeApi apiInstance = new ConceptByCodeApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String terminology = "terminology_example"; // String | Terminology id or abbreviation. e.g. \"uuid1\" or \"ICD10CM\".
        String code = "code_example"; // String | Terminology code, e.g. \"1119\", \"8867-4\", or \"64572001\"
        try {
            apiInstance.getConceptDiagram(idOrUriLabel, terminology, code);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByCodeApi#getConceptDiagram");
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
| **code** | **String**| Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; | |

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


## getConceptInverseMappings

> List&lt;Mapping&gt; getConceptInverseMappings(idOrUriLabel, terminology, code)

Get mappings to concept by terminology and code

Gets mappings tothe concept with the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByCodeApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByCodeApi apiInstance = new ConceptByCodeApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String terminology = "terminology_example"; // String | Terminology id or abbreviation. e.g. \"uuid1\" or \"ICD10CM\".
        String code = "code_example"; // String | Terminology code, e.g. \"1119\", \"8867-4\", or \"64572001\"
        try {
            List<Mapping> result = apiInstance.getConceptInverseMappings(idOrUriLabel, terminology, code);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByCodeApi#getConceptInverseMappings");
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
| **code** | **String**| Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; | |

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
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |
| **200** | Mappings to the concept matching specified terminology and code |  -  |


## getConceptMappings

> List&lt;Mapping&gt; getConceptMappings(idOrUriLabel, terminology, code)

Get mappings from concept by terminology and code

Gets mappings from the concept with the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptByCodeApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptByCodeApi apiInstance = new ConceptByCodeApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel, e.g. \"sandbox\"
        String terminology = "terminology_example"; // String | Terminology id or abbreviation. e.g. \"uuid1\" or \"ICD10CM\".
        String code = "code_example"; // String | Terminology code, e.g. \"1119\", \"8867-4\", or \"64572001\"
        try {
            List<Mapping> result = apiInstance.getConceptMappings(idOrUriLabel, terminology, code);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptByCodeApi#getConceptMappings");
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
| **code** | **String**| Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; | |

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
| **200** | Mappings from the concept matching specified terminology and code |  -  |
| **403** | Forbidden |  -  |
| **404** | Not found |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |

