package api;

import api.invoker.ApiException;
import api.invoker.ApiClient;
import api.invoker.ApiResponse;
import api.invoker.Configuration;
import api.invoker.Pair;

import jakarta.ws.rs.core.GenericType;

import java.io.File;
import api.model.ResultListSubset;
import api.model.ResultListSubsetMember;
import api.model.Subset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-08-12T13:13:49.637811500-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class SubsetApi {
  private ApiClient apiClient;

  public SubsetApi() {
    this(Configuration.getDefaultApiClient());
  }

  public SubsetApi(ApiClient apiClient) {
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
   * Export project subset
   * Exports specified project subset in the specified format.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param subset Subset id or abbreviation e.g. \&quot;uuid1\&quot; or \&quot;CVX-NDC\&quot;. (required)
   * @param format Requested download format, e.g. \&quot;native\&quot; (required)
   * @return byte[]
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Export project subset matching specified criteria </td><td>  -  </td></tr>
     </table>
   */
  public byte[] exportProjectSubset(String idOrUriLabel, String subset, String format) throws ApiException {
    return exportProjectSubsetWithHttpInfo(idOrUriLabel, subset, format).getData();
  }

  /**
   * Export project subset
   * Exports specified project subset in the specified format.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param subset Subset id or abbreviation e.g. \&quot;uuid1\&quot; or \&quot;CVX-NDC\&quot;. (required)
   * @param format Requested download format, e.g. \&quot;native\&quot; (required)
   * @return ApiResponse&lt;byte[]&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Export project subset matching specified criteria </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<byte[]> exportProjectSubsetWithHttpInfo(String idOrUriLabel, String subset, String format) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling exportProjectSubset");
    }
    if (subset == null) {
      throw new ApiException(400, "Missing the required parameter 'subset' when calling exportProjectSubset");
    }
    if (format == null) {
      throw new ApiException(400, "Missing the required parameter 'format' when calling exportProjectSubset");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/subset/{subset}/export"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{subset}", apiClient.escapeString(subset));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "format", format)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/octet-stream");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<byte[]> localVarReturnType = new GenericType<byte[]>() {};
    return apiClient.invokeAPI("SubsetApi.exportProjectSubset", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Export members for project subset
   * Exports members matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param subset Comma-separated list of subset ids or abbreviations (or null for all subsets). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT_US-EXTENSION\&quot;. (required)
   * @param query Search text (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active members only, &lt;code&gt;false&lt;/code&gt; for inactive members only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Tab separated values file content for matching subset members </td><td>  -  </td></tr>
     </table>
   */
  public File exportProjectSubsetMembers(String idOrUriLabel, String subset, String query, Boolean active) throws ApiException {
    return exportProjectSubsetMembersWithHttpInfo(idOrUriLabel, subset, query, active).getData();
  }

  /**
   * Export members for project subset
   * Exports members matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param subset Comma-separated list of subset ids or abbreviations (or null for all subsets). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT_US-EXTENSION\&quot;. (required)
   * @param query Search text (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active members only, &lt;code&gt;false&lt;/code&gt; for inactive members only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Tab separated values file content for matching subset members </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> exportProjectSubsetMembersWithHttpInfo(String idOrUriLabel, String subset, String query, Boolean active) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling exportProjectSubsetMembers");
    }
    if (subset == null) {
      throw new ApiException(400, "Missing the required parameter 'subset' when calling exportProjectSubsetMembers");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/subset/{subset}/member/export"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{subset}", apiClient.escapeString(subset));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "query", query)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI("SubsetApi.exportProjectSubsetMembers", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Export members for subset
   * Exports members matching specified search criteria.
   * @param id Subset id, e.g. \&quot;uuid\&quot; (required)
   * @param query Search text (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active members only, &lt;code&gt;false&lt;/code&gt; for inactive members only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Tab separated values file content for matching subset members </td><td>  -  </td></tr>
     </table>
   */
  public File exportSubsetMembers(String id, String query, Boolean active) throws ApiException {
    return exportSubsetMembersWithHttpInfo(id, query, active).getData();
  }

  /**
   * Export members for subset
   * Exports members matching specified search criteria.
   * @param id Subset id, e.g. \&quot;uuid\&quot; (required)
   * @param query Search text (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active members only, &lt;code&gt;false&lt;/code&gt; for inactive members only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Tab separated values file content for matching subset members </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> exportSubsetMembersWithHttpInfo(String id, String query, Boolean active) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling exportSubsetMembers");
    }

    // Path parameters
    String localVarPath = "/subset/{id}/member/export"
            .replaceAll("\\{id}", apiClient.escapeString(id));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "query", query)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI("SubsetApi.exportSubsetMembers", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find members across project subsets
   * Finds members matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param subset Comma-separated list of subset ids or abbreviations (or null for all subsets). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT_US-EXTENSION\&quot;. (optional)
   * @param query Search text (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active members only, &lt;code&gt;false&lt;/code&gt; for inactive mappings only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @return ResultListSubsetMember
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching members </td><td>  -  </td></tr>
     </table>
   */
  public ResultListSubsetMember findProjectMembers(String idOrUriLabel, String subset, String query, Integer offset, Integer limit, String sort, Boolean ascending, Boolean active) throws ApiException {
    return findProjectMembersWithHttpInfo(idOrUriLabel, subset, query, offset, limit, sort, ascending, active).getData();
  }

  /**
   * Find members across project subsets
   * Finds members matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param subset Comma-separated list of subset ids or abbreviations (or null for all subsets). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT_US-EXTENSION\&quot;. (optional)
   * @param query Search text (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active members only, &lt;code&gt;false&lt;/code&gt; for inactive mappings only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @return ApiResponse&lt;ResultListSubsetMember&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching members </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListSubsetMember> findProjectMembersWithHttpInfo(String idOrUriLabel, String subset, String query, Integer offset, Integer limit, String sort, Boolean ascending, Boolean active) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling findProjectMembers");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/member"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "subset", subset)
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
    GenericType<ResultListSubsetMember> localVarReturnType = new GenericType<ResultListSubsetMember>() {};
    return apiClient.invokeAPI("SubsetApi.findProjectMembers", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find members for the specified project subset
   * Finds members for the specified project subset and the specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param subset Subset id or abbreviation e.g. \&quot;uuid1\&quot; or \&quot;SNOMEDCT_US-EXTENSION\&quot;. (required)
   * @param query Search text (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active members only, &lt;code&gt;false&lt;/code&gt; for inactive members only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @return ResultListSubsetMember
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching subset members </td><td>  -  </td></tr>
     </table>
   */
  public ResultListSubsetMember findProjectSubsetMembers(String idOrUriLabel, String subset, String query, Integer offset, Integer limit, String sort, Boolean ascending, Boolean active) throws ApiException {
    return findProjectSubsetMembersWithHttpInfo(idOrUriLabel, subset, query, offset, limit, sort, ascending, active).getData();
  }

  /**
   * Find members for the specified project subset
   * Finds members for the specified project subset and the specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param subset Subset id or abbreviation e.g. \&quot;uuid1\&quot; or \&quot;SNOMEDCT_US-EXTENSION\&quot;. (required)
   * @param query Search text (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active members only, &lt;code&gt;false&lt;/code&gt; for inactive members only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @return ApiResponse&lt;ResultListSubsetMember&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching subset members </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListSubsetMember> findProjectSubsetMembersWithHttpInfo(String idOrUriLabel, String subset, String query, Integer offset, Integer limit, String sort, Boolean ascending, Boolean active) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling findProjectSubsetMembers");
    }
    if (subset == null) {
      throw new ApiException(400, "Missing the required parameter 'subset' when calling findProjectSubsetMembers");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/subset/{subset}/member"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{subset}", apiClient.escapeString(subset));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "query", query)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ascending", ascending));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<ResultListSubsetMember> localVarReturnType = new GenericType<ResultListSubsetMember>() {};
    return apiClient.invokeAPI("SubsetApi.findProjectSubsetMembers", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find members for the specified subset
   * Finds members for the specified subset and the specified search criteria.
   * @param id Subset id,  e.g. \&quot;uuid1\&quot; (required)
   * @param query Search text (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active members only, &lt;code&gt;false&lt;/code&gt; for inactive members only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @return ResultListSubsetMember
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching subset members </td><td>  -  </td></tr>
     </table>
   */
  public ResultListSubsetMember findSubsetMembers(String id, String query, Integer offset, Integer limit, String sort, Boolean ascending, Boolean active) throws ApiException {
    return findSubsetMembersWithHttpInfo(id, query, offset, limit, sort, ascending, active).getData();
  }

  /**
   * Find members for the specified subset
   * Finds members for the specified subset and the specified search criteria.
   * @param id Subset id,  e.g. \&quot;uuid1\&quot; (required)
   * @param query Search text (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active members only, &lt;code&gt;false&lt;/code&gt; for inactive members only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @return ApiResponse&lt;ResultListSubsetMember&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching subset members </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListSubsetMember> findSubsetMembersWithHttpInfo(String id, String query, Integer offset, Integer limit, String sort, Boolean ascending, Boolean active) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling findSubsetMembers");
    }

    // Path parameters
    String localVarPath = "/subset/{id}/member"
            .replaceAll("\\{id}", apiClient.escapeString(id));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "query", query)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ascending", ascending));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<ResultListSubsetMember> localVarReturnType = new GenericType<ResultListSubsetMember>() {};
    return apiClient.invokeAPI("SubsetApi.findSubsetMembers", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find subsets
   * Finds subsets matching specified criteria.
   * @param query Search text (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @return ResultListSubset
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching subsets </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ResultListSubset findSubsets(String query, Integer offset, Integer limit, String sort, Boolean ascending) throws ApiException {
    return findSubsetsWithHttpInfo(query, offset, limit, sort, ascending).getData();
  }

  /**
   * Find subsets
   * Finds subsets matching specified criteria.
   * @param query Search text (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @return ApiResponse&lt;ResultListSubset&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching subsets </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListSubset> findSubsetsWithHttpInfo(String query, Integer offset, Integer limit, String sort, Boolean ascending) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "query", query)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ascending", ascending));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<ResultListSubset> localVarReturnType = new GenericType<ResultListSubset>() {};
    return apiClient.invokeAPI("SubsetApi.findSubsets", "/subset", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get project subsets
   * Gets subset objects used by the specified project.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @return List&lt;Subset&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of project subsets </td><td>  -  </td></tr>
     </table>
   */
  public List<Subset> getProjectSubsets(String idOrUriLabel) throws ApiException {
    return getProjectSubsetsWithHttpInfo(idOrUriLabel).getData();
  }

  /**
   * Get project subsets
   * Gets subset objects used by the specified project.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @return ApiResponse&lt;List&lt;Subset&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of project subsets </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Subset>> getProjectSubsetsWithHttpInfo(String idOrUriLabel) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling getProjectSubsets");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/subset"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<Subset>> localVarReturnType = new GenericType<List<Subset>>() {};
    return apiClient.invokeAPI("SubsetApi.getProjectSubsets", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get subset by id
   * Gets subset for the specified id
   * @param id Subset id, e.g. \&quot;uuid\&quot; (required)
   * @return Subset
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Subset </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public Subset getSubset(String id) throws ApiException {
    return getSubsetWithHttpInfo(id).getData();
  }

  /**
   * Get subset by id
   * Gets subset for the specified id
   * @param id Subset id, e.g. \&quot;uuid\&quot; (required)
   * @return ApiResponse&lt;Subset&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Subset </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Subset> getSubsetWithHttpInfo(String id) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getSubset");
    }

    // Path parameters
    String localVarPath = "/subset/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<Subset> localVarReturnType = new GenericType<Subset>() {};
    return apiClient.invokeAPI("SubsetApi.getSubset", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
