# ConceptApi

All URIs are relative to *https://dev.terminologyhub.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**exportConcepts**](ConceptApi.md#exportConcepts) | **GET** /project/{idOrUriLabel}/concept/export | Export concept search across all project terminologies |
| [**exportLookup**](ConceptApi.md#exportLookup) | **POST** /project/{idOrUriLabel}/concept/bulk/export | Export bulk find of concepts across specified project terminologies |
| [**findConcepts**](ConceptApi.md#findConcepts) | **GET** /project/{idOrUriLabel}/concept | Find concepts across project terminologies |
| [**lookup**](ConceptApi.md#lookup) | **POST** /project/{idOrUriLabel}/concept/bulk | Bulk find of concepts across specified project terminologies |



## exportConcepts

> String exportConcepts(idOrUriLabel, terminology, query, expression, sort, ascending, active, leaf)

Export concept search across all project terminologies

Export concept search matching specified search criteria.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptApi apiInstance = new ConceptApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel
        String terminology = "terminology_example"; // String | Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \"uuid1,uuid2\", \"SNOMEDCT,RXNORM\", or \"ICD10CM\".
        String query = "query_example"; // String | Search text (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\">See here for more info</a>)
        String expression = "expression_example"; // String | ECL-style expression (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/EXPRESSION.md\">See here for more info</a>)
        String sort = "sort_example"; // String | Comma-separated list of fields to sort on
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        Boolean active = true; // Boolean | <code>true</code> for active concepts only, <code>false</code> for inactive concepts only, <code>null</code> for both
        Boolean leaf = true; // Boolean | <code>true</code> for leaf nodes only, <code>false</code> for non-leaf nodes, <code>null</code> for either
        try {
            String result = apiInstance.exportConcepts(idOrUriLabel, terminology, query, expression, sort, ascending, active, leaf);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptApi#exportConcepts");
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
| **terminology** | **String**| Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. | |
| **query** | **String**| Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) | [optional] |
| **expression** | **String**| ECL-style expression (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/EXPRESSION.md\&quot;&gt;See here for more info&lt;/a&gt;) | [optional] |
| **sort** | **String**| Comma-separated list of fields to sort on | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |
| **active** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for active concepts only, &lt;code&gt;false&lt;/code&gt; for inactive concepts only, &lt;code&gt;null&lt;/code&gt; for both | [optional] |
| **leaf** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either | [optional] |

### Return type

**String**

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
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |
| **200** | Tab separated values file content for matching concepts |  -  |


## exportLookup

> String exportLookup(idOrUriLabel, body, terminology, expression, limit, active, leaf)

Export bulk find of concepts across specified project terminologies

Export bulk find of concepts matching specified search criteria.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptApi apiInstance = new ConceptApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel
        String body = heart
kidney
12738006; // String | Newline-separated lines of text, one line for each query
        String terminology = "terminology_example"; // String | Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \"uuid1,uuid2\", \"SNOMEDCT,RXNORM\", or \"ICD10CM\".
        String expression = "expression_example"; // String | ECL-style expression (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/EXPRESSION.md\">See here for more info</a>)
        Integer limit = 1; // Integer | Limit of results to return, max is 10
        Boolean active = true; // Boolean | <code>true</code> for active concepts only, <code>false</code> for inactive concepts only, <code>null</code> for both
        Boolean leaf = true; // Boolean | <code>true</code> for leaf nodes only, <code>false</code> for non-leaf nodes, <code>null</code> for either
        try {
            String result = apiInstance.exportLookup(idOrUriLabel, body, terminology, expression, limit, active, leaf);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptApi#exportLookup");
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
| **body** | **String**| Newline-separated lines of text, one line for each query | |
| **terminology** | **String**| Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. | [optional] |
| **expression** | **String**| ECL-style expression (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/EXPRESSION.md\&quot;&gt;See here for more info&lt;/a&gt;) | [optional] |
| **limit** | **Integer**| Limit of results to return, max is 10 | [optional] |
| **active** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for active concepts only, &lt;code&gt;false&lt;/code&gt; for inactive concepts only, &lt;code&gt;null&lt;/code&gt; for both | [optional] |
| **leaf** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either | [optional] |

### Return type

**String**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: text/plain
- **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **403** | Forbidden |  -  |
| **404** | Not found |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |
| **200** | Tab separated values file content for matching concepts |  -  |


## findConcepts

> ResultListConcept findConcepts(idOrUriLabel, terminology, query, expression, offset, limit, sort, ascending, active, leaf, include)

Find concepts across project terminologies

Finds concepts matching specified search criteria.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptApi apiInstance = new ConceptApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel
        String terminology = "terminology_example"; // String | Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \"uuid1,uuid2\", \"SNOMEDCT,RXNORM\", or \"ICD10CM\".
        String query = "query_example"; // String | Search text (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\">See here for more info</a>)
        String expression = "expression_example"; // String | ECL-style expression (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/EXPRESSION.md\">See here for more info</a>)
        Integer offset = 0; // Integer | Start index for search results
        Integer limit = 10; // Integer | Limit of results to return (hard limit of 1000 regardless of value)
        String sort = "sort_example"; // String | Comma-separated list of fields to sort on
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        Boolean active = true; // Boolean | <code>true</code> for active concepts only, <code>false</code> for inactive concepts only, <code>null</code> for both
        Boolean leaf = true; // Boolean | <code>true</code> for leaf nodes only, <code>false</code> for non-leaf nodes, <code>null</code> for either
        String include = "include_example"; // String | Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions<a target=\"_blank\" href='https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md' target='_blank'>See here for detailed information</a>.
        try {
            ResultListConcept result = apiInstance.findConcepts(idOrUriLabel, terminology, query, expression, offset, limit, sort, ascending, active, leaf, include);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptApi#findConcepts");
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
| **expression** | **String**| ECL-style expression (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/EXPRESSION.md\&quot;&gt;See here for more info&lt;/a&gt;) | [optional] |
| **offset** | **Integer**| Start index for search results | [optional] |
| **limit** | **Integer**| Limit of results to return (hard limit of 1000 regardless of value) | [optional] |
| **sort** | **String**| Comma-separated list of fields to sort on | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |
| **active** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for active concepts only, &lt;code&gt;false&lt;/code&gt; for inactive concepts only, &lt;code&gt;null&lt;/code&gt; for both | [optional] |
| **leaf** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either | [optional] |
| **include** | **String**| Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;&#39;https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md&#39; target&#x3D;&#39;_blank&#39;&gt;See here for detailed information&lt;/a&gt;. | [optional] |

### Return type

[**ResultListConcept**](ResultListConcept.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **403** | Forbidden |  -  |
| **200** | Result list of matching concepts |  -  |
| **404** | Not found |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **500** | Internal server error |  -  |


## lookup

> List&lt;ResultListConcept&gt; lookup(idOrUriLabel, body, terminology, expression, limit, active, leaf, include)

Bulk find of concepts across specified project terminologies

Bulk find of concepts matching specified search criteria.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.ConceptApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://dev.terminologyhub.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ConceptApi apiInstance = new ConceptApi(defaultClient);
        String idOrUriLabel = "idOrUriLabel_example"; // String | Project id or uriLabel
        String body = heart
kidney
12738006; // String | Newline-separated lines of text, one line for each query
        String terminology = "terminology_example"; // String | Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \"uuid1,uuid2\", \"SNOMEDCT,RXNORM\", or \"ICD10CM\".
        String expression = "expression_example"; // String | ECL-style expression (<a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/EXPRESSION.md\">See here for more info</a>)
        Integer limit = 1; // Integer | Limit of results to return, max is 10
        Boolean active = true; // Boolean | <code>true</code> for active concepts only, <code>false</code> for inactive concepts only, <code>null</code> for both
        Boolean leaf = true; // Boolean | <code>true</code> for leaf nodes only, <code>false</code> for non-leaf nodes, <code>null</code> for either
        String include = "include_example"; // String | Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions<a target=\"_blank\" href='https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md' target='_blank'>See here for detailed information</a>.
        try {
            List<ResultListConcept> result = apiInstance.lookup(idOrUriLabel, body, terminology, expression, limit, active, leaf, include);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConceptApi#lookup");
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
| **body** | **String**| Newline-separated lines of text, one line for each query | |
| **terminology** | **String**| Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. | [optional] |
| **expression** | **String**| ECL-style expression (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/EXPRESSION.md\&quot;&gt;See here for more info&lt;/a&gt;) | [optional] |
| **limit** | **Integer**| Limit of results to return, max is 10 | [optional] |
| **active** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for active concepts only, &lt;code&gt;false&lt;/code&gt; for inactive concepts only, &lt;code&gt;null&lt;/code&gt; for both | [optional] |
| **leaf** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either | [optional] |
| **include** | **String**| Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;&#39;https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md&#39; target&#x3D;&#39;_blank&#39;&gt;See here for detailed information&lt;/a&gt;. | [optional] |

### Return type

[**List&lt;ResultListConcept&gt;**](ResultListConcept.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: text/plain
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **403** | Forbidden |  -  |
| **404** | Not found |  -  |
| **401** | Unauthorized |  -  |
| **417** | Expectation failed |  -  |
| **200** | List of result lists of matching concepts for each query |  -  |
| **500** | Internal server error |  -  |

