package api;

import api.invoker.ApiException;
import api.invoker.ApiClient;
import api.invoker.ApiResponse;
import api.invoker.Configuration;
import api.invoker.Pair;

import jakarta.ws.rs.core.GenericType;

import api.model.ResultListTerm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-03T12:36:52.969136900-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class TermApi {
  private ApiClient apiClient;

  public TermApi() {
    this(Configuration.getDefaultApiClient());
  }

  public TermApi(ApiClient apiClient) {
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
   * Suggest autocompletions for text while searching
   * Finds top ten strings matching input query.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param query Search text (required)
   * @param terminology Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> List of top ten matching strings </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public List<String> autocomplete(String idOrUriLabel, String query, String terminology, Integer limit) throws ApiException {
    return autocompleteWithHttpInfo(idOrUriLabel, query, terminology, limit).getData();
  }

  /**
   * Suggest autocompletions for text while searching
   * Finds top ten strings matching input query.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param query Search text (required)
   * @param terminology Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @return ApiResponse&lt;List&lt;String&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> List of top ten matching strings </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<String>> autocompleteWithHttpInfo(String idOrUriLabel, String query, String terminology, Integer limit) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling autocomplete");
    }
    if (query == null) {
      throw new ApiException(400, "Missing the required parameter 'query' when calling autocomplete");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/autocomplete"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "terminology", terminology)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "query", query));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<String>> localVarReturnType = new GenericType<List<String>>() {};
    return apiClient.invokeAPI("TermApi.autocomplete", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find terms across project terminologies
   * Finds terms matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param terminology Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. (optional)
   * @param query Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active terms only, &lt;code&gt;false&lt;/code&gt; for inactive terms only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @return ResultListTerm
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching terms </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public ResultListTerm findTerms(String idOrUriLabel, String terminology, String query, Integer offset, Integer limit, String sort, Boolean ascending, Boolean active) throws ApiException {
    return findTermsWithHttpInfo(idOrUriLabel, terminology, query, offset, limit, sort, ascending, active).getData();
  }

  /**
   * Find terms across project terminologies
   * Finds terms matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param terminology Comma-separated list of terminology ids or abbreviations (or null for all terminologies). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT,RXNORM\&quot;, or \&quot;ICD10CM\&quot;. (optional)
   * @param query Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active terms only, &lt;code&gt;false&lt;/code&gt; for inactive terms only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @return ApiResponse&lt;ResultListTerm&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching terms </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListTerm> findTermsWithHttpInfo(String idOrUriLabel, String terminology, String query, Integer offset, Integer limit, String sort, Boolean ascending, Boolean active) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling findTerms");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/term"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "terminology", terminology)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "query", query));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ascending", ascending));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<ResultListTerm> localVarReturnType = new GenericType<ResultListTerm>() {};
    return apiClient.invokeAPI("TermApi.findTerms", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
