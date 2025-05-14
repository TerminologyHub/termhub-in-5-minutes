package api;

import api.invoker.ApiException;
import api.invoker.ApiClient;
import api.invoker.ApiResponse;
import api.invoker.Configuration;
import api.invoker.Pair;

import jakarta.ws.rs.core.GenericType;

import api.model.ResultListConcept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-03T12:36:52.969136900-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class ConceptApi {
  private ApiClient apiClient;

  public ConceptApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ConceptApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Get the API client
   *
   * @return API client
   */
  public ApiClient getApiClient() {
    return apiClient;
  }

  /**
   * Set the API client
   *
   * @param apiClient an instance of API client
   */
  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Export concept search across all project terminologies
   * Export concept search matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param terminology Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. (required)
   * @param query Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param expression ECL-style expression (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/EXPRESSION.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active concepts only, &lt;code&gt;false&lt;/code&gt; for inactive concepts only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @param leaf &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either (optional)
   * @return String
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Tab separated values file content for matching concepts </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public String exportConcepts(String idOrUriLabel, String terminology, String query, String expression, String sort, Boolean ascending, Boolean active, Boolean leaf) throws ApiException {
    return exportConceptsWithHttpInfo(idOrUriLabel, terminology, query, expression, sort, ascending, active, leaf).getData();
  }

  /**
   * Export concept search across all project terminologies
   * Export concept search matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param terminology Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. (required)
   * @param query Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param expression ECL-style expression (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/EXPRESSION.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active concepts only, &lt;code&gt;false&lt;/code&gt; for inactive concepts only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @param leaf &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either (optional)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Tab separated values file content for matching concepts </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<String> exportConceptsWithHttpInfo(String idOrUriLabel, String terminology, String query, String expression, String sort, Boolean ascending, Boolean active, Boolean leaf) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling exportConcepts");
    }
    if (terminology == null) {
      throw new ApiException(400, "Missing the required parameter 'terminology' when calling exportConcepts");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/export"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "terminology", terminology)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "query", query));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "expression", expression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ascending", ascending));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "leaf", leaf));

    String localVarAccept = apiClient.selectHeaderAccept("text/plain");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI("ConceptApi.exportConcepts", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Export bulk find of concepts across specified project terminologies
   * Export bulk find of concepts matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param body Newline-separated lines of text, one line for each query (required)
   * @param terminology Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. (optional)
   * @param expression ECL-style expression (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/EXPRESSION.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param limit Limit of results to return, max is 10 (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active concepts only, &lt;code&gt;false&lt;/code&gt; for inactive concepts only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @param leaf &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either (optional)
   * @return String
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Tab separated values file content for matching concepts </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public String exportLookup(String idOrUriLabel, String body, String terminology, String expression, Integer limit, Boolean active, Boolean leaf) throws ApiException {
    return exportLookupWithHttpInfo(idOrUriLabel, body, terminology, expression, limit, active, leaf).getData();
  }

  /**
   * Export bulk find of concepts across specified project terminologies
   * Export bulk find of concepts matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param body Newline-separated lines of text, one line for each query (required)
   * @param terminology Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. (optional)
   * @param expression ECL-style expression (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/EXPRESSION.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param limit Limit of results to return, max is 10 (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active concepts only, &lt;code&gt;false&lt;/code&gt; for inactive concepts only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @param leaf &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either (optional)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Tab separated values file content for matching concepts </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<String> exportLookupWithHttpInfo(String idOrUriLabel, String body, String terminology, String expression, Integer limit, Boolean active, Boolean leaf) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling exportLookup");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling exportLookup");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/bulk/export"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "terminology", terminology)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "expression", expression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "leaf", leaf));

    String localVarAccept = apiClient.selectHeaderAccept("text/plain");
    String localVarContentType = apiClient.selectHeaderContentType("text/plain");
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI("ConceptApi.exportLookup", localVarPath, "POST", localVarQueryParams, body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find concepts across project terminologies
   * Finds concepts matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param terminology Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. (optional)
   * @param query Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param expression ECL-style expression (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/EXPRESSION.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active concepts only, &lt;code&gt;false&lt;/code&gt; for inactive concepts only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @param leaf &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either (optional)
   * @param include Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;&#39;https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md&#39; target&#x3D;&#39;_blank&#39;&gt;See here for detailed information&lt;/a&gt;. (optional)
   * @return ResultListConcept
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching concepts </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public ResultListConcept findConcepts(String idOrUriLabel, String terminology, String query, String expression, Integer offset, Integer limit, String sort, Boolean ascending, Boolean active, Boolean leaf, String include) throws ApiException {
    return findConceptsWithHttpInfo(idOrUriLabel, terminology, query, expression, offset, limit, sort, ascending, active, leaf, include).getData();
  }

  /**
   * Find concepts across project terminologies
   * Finds concepts matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param terminology Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. (optional)
   * @param query Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param expression ECL-style expression (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/EXPRESSION.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active concepts only, &lt;code&gt;false&lt;/code&gt; for inactive concepts only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @param leaf &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either (optional)
   * @param include Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;&#39;https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md&#39; target&#x3D;&#39;_blank&#39;&gt;See here for detailed information&lt;/a&gt;. (optional)
   * @return ApiResponse&lt;ResultListConcept&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching concepts </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListConcept> findConceptsWithHttpInfo(String idOrUriLabel, String terminology, String query, String expression, Integer offset, Integer limit, String sort, Boolean ascending, Boolean active, Boolean leaf, String include) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling findConcepts");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "terminology", terminology)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "query", query));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "expression", expression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ascending", ascending));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "leaf", leaf));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "include", include));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<ResultListConcept> localVarReturnType = new GenericType<ResultListConcept>() {};
    return apiClient.invokeAPI("ConceptApi.findConcepts", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Bulk find of concepts across specified project terminologies
   * Bulk find of concepts matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param body Newline-separated lines of text, one line for each query (required)
   * @param terminology Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. (optional)
   * @param expression ECL-style expression (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/EXPRESSION.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param limit Limit of results to return, max is 10 (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active concepts only, &lt;code&gt;false&lt;/code&gt; for inactive concepts only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @param leaf &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either (optional)
   * @param include Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;&#39;https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md&#39; target&#x3D;&#39;_blank&#39;&gt;See here for detailed information&lt;/a&gt;. (optional)
   * @return List&lt;ResultListConcept&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> List of result lists of matching concepts for each query </td><td>  -  </td></tr>
     </table>
   */
  public List<ResultListConcept> lookup(String idOrUriLabel, String body, String terminology, String expression, Integer limit, Boolean active, Boolean leaf, String include) throws ApiException {
    return lookupWithHttpInfo(idOrUriLabel, body, terminology, expression, limit, active, leaf, include).getData();
  }

  /**
   * Bulk find of concepts across specified project terminologies
   * Bulk find of concepts matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param body Newline-separated lines of text, one line for each query (required)
   * @param terminology Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. (optional)
   * @param expression ECL-style expression (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/EXPRESSION.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param limit Limit of results to return, max is 10 (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active concepts only, &lt;code&gt;false&lt;/code&gt; for inactive concepts only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @param leaf &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either (optional)
   * @param include Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;&#39;https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md&#39; target&#x3D;&#39;_blank&#39;&gt;See here for detailed information&lt;/a&gt;. (optional)
   * @return ApiResponse&lt;List&lt;ResultListConcept&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> List of result lists of matching concepts for each query </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ResultListConcept>> lookupWithHttpInfo(String idOrUriLabel, String body, String terminology, String expression, Integer limit, Boolean active, Boolean leaf, String include) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling lookup");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling lookup");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/bulk"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "terminology", terminology)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "expression", expression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "leaf", leaf));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "include", include));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("text/plain");
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<ResultListConcept>> localVarReturnType = new GenericType<List<ResultListConcept>>() {};
    return apiClient.invokeAPI("ConceptApi.lookup", localVarPath, "POST", localVarQueryParams, body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
