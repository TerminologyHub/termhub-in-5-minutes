package api;

import api.invoker.ApiException;
import api.invoker.ApiClient;
import api.invoker.ApiResponse;
import api.invoker.Configuration;
import api.invoker.Pair;

import jakarta.ws.rs.core.GenericType;

import java.io.File;
import api.model.Mapset;
import api.model.ResultListMapping;
import api.model.ResultListMapset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-26T15:47:59.449899600-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class MapsetApi {
  private ApiClient apiClient;

  public MapsetApi() {
    this(Configuration.getDefaultApiClient());
  }

  public MapsetApi(ApiClient apiClient) {
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
   * Export mapset
   * Exports specified mapset in the specified format.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param mapset Mapset id or abbreviation e.g. \&quot;uuid1\&quot; or \&quot;CVX-NDC\&quot;. (required)
   * @param format Requested download format, e.g. \&quot;native\&quot; (required)
   * @return byte[]
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Export mapset matching specified criteria </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public byte[] exportMapset(String idOrUriLabel, String mapset, String format) throws ApiException {
    return exportMapsetWithHttpInfo(idOrUriLabel, mapset, format).getData();
  }

  /**
   * Export mapset
   * Exports specified mapset in the specified format.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param mapset Mapset id or abbreviation e.g. \&quot;uuid1\&quot; or \&quot;CVX-NDC\&quot;. (required)
   * @param format Requested download format, e.g. \&quot;native\&quot; (required)
   * @return ApiResponse&lt;byte[]&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Export mapset matching specified criteria </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<byte[]> exportMapsetWithHttpInfo(String idOrUriLabel, String mapset, String format) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling exportMapset");
    }
    if (mapset == null) {
      throw new ApiException(400, "Missing the required parameter 'mapset' when calling exportMapset");
    }
    if (format == null) {
      throw new ApiException(400, "Missing the required parameter 'format' when calling exportMapset");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/mapset/{mapset}/export"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{mapset}", apiClient.escapeString(mapset));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "format", format)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/octet-stream");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<byte[]> localVarReturnType = new GenericType<byte[]>() {};
    return apiClient.invokeAPI("MapsetApi.exportMapset", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Export mappings for project mapset
   * Exports mapping matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param mapset Comma-separated list of mapset ids or abbreviations (or null for all mapsets). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT_US-ICD10CM,CVX-NDC\&quot;. (required)
   * @param query Search text (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active mappings only, &lt;code&gt;false&lt;/code&gt; for inactive mappings only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @param leaf &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either (optional)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Tab separated values file content for matching mappings </td><td>  -  </td></tr>
     </table>
   */
  public File exportMapsetMappings(String idOrUriLabel, String mapset, String query, Boolean active, Boolean leaf) throws ApiException {
    return exportMapsetMappingsWithHttpInfo(idOrUriLabel, mapset, query, active, leaf).getData();
  }

  /**
   * Export mappings for project mapset
   * Exports mapping matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param mapset Comma-separated list of mapset ids or abbreviations (or null for all mapsets). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT_US-ICD10CM,CVX-NDC\&quot;. (required)
   * @param query Search text (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active mappings only, &lt;code&gt;false&lt;/code&gt; for inactive mappings only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @param leaf &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either (optional)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Tab separated values file content for matching mappings </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> exportMapsetMappingsWithHttpInfo(String idOrUriLabel, String mapset, String query, Boolean active, Boolean leaf) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling exportMapsetMappings");
    }
    if (mapset == null) {
      throw new ApiException(400, "Missing the required parameter 'mapset' when calling exportMapsetMappings");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/mapset/{mapset}/mappings/export"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{mapset}", apiClient.escapeString(mapset));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "query", query)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "leaf", leaf));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI("MapsetApi.exportMapsetMappings", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find mappings across project mapsets
   * Finds mapping matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param mapset Comma-separated list of mapset ids or abbreviations (or null for all mapsets). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT_US-ICD10CM,CVX-NDC\&quot;. (optional)
   * @param query Search text (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active mappings only, &lt;code&gt;false&lt;/code&gt; for inactive mappings only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @param leaf &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either (optional)
   * @return ResultListMapping
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching mappings </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ResultListMapping findMappings(String idOrUriLabel, String mapset, String query, Integer offset, Integer limit, String sort, Boolean ascending, Boolean active, Boolean leaf) throws ApiException {
    return findMappingsWithHttpInfo(idOrUriLabel, mapset, query, offset, limit, sort, ascending, active, leaf).getData();
  }

  /**
   * Find mappings across project mapsets
   * Finds mapping matching specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param mapset Comma-separated list of mapset ids or abbreviations (or null for all mapsets). e.g. \&quot;uuid1,uuid2\&quot;, \&quot;SNOMEDCT_US-ICD10CM,CVX-NDC\&quot;. (optional)
   * @param query Search text (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active mappings only, &lt;code&gt;false&lt;/code&gt; for inactive mappings only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @param leaf &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either (optional)
   * @return ApiResponse&lt;ResultListMapping&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching mappings </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListMapping> findMappingsWithHttpInfo(String idOrUriLabel, String mapset, String query, Integer offset, Integer limit, String sort, Boolean ascending, Boolean active, Boolean leaf) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling findMappings");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/mapping"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "mapset", mapset)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "query", query));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ascending", ascending));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "leaf", leaf));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<ResultListMapping> localVarReturnType = new GenericType<ResultListMapping>() {};
    return apiClient.invokeAPI("MapsetApi.findMappings", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find mappings for the specified mapset
   * Finds mapping for the specified mapset and the specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param mapset Mapset id or abbreviation e.g. \&quot;uuid1\&quot; or \&quot;CVX-NDC\&quot;. (required)
   * @param query Search text (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active mappings only, &lt;code&gt;false&lt;/code&gt; for inactive mappings only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @param leaf &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either (optional)
   * @return ResultListMapping
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching mappings </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ResultListMapping findMapsetMappings(String idOrUriLabel, String mapset, String query, Integer offset, Integer limit, String sort, Boolean ascending, Boolean active, Boolean leaf) throws ApiException {
    return findMapsetMappingsWithHttpInfo(idOrUriLabel, mapset, query, offset, limit, sort, ascending, active, leaf).getData();
  }

  /**
   * Find mappings for the specified mapset
   * Finds mapping for the specified mapset and the specified search criteria.
   * @param idOrUriLabel Project id or uriLabel (required)
   * @param mapset Mapset id or abbreviation e.g. \&quot;uuid1\&quot; or \&quot;CVX-NDC\&quot;. (required)
   * @param query Search text (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param active &lt;code&gt;true&lt;/code&gt; for active mappings only, &lt;code&gt;false&lt;/code&gt; for inactive mappings only, &lt;code&gt;null&lt;/code&gt; for both (optional)
   * @param leaf &lt;code&gt;true&lt;/code&gt; for leaf nodes only, &lt;code&gt;false&lt;/code&gt; for non-leaf nodes, &lt;code&gt;null&lt;/code&gt; for either (optional)
   * @return ApiResponse&lt;ResultListMapping&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching mappings </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListMapping> findMapsetMappingsWithHttpInfo(String idOrUriLabel, String mapset, String query, Integer offset, Integer limit, String sort, Boolean ascending, Boolean active, Boolean leaf) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling findMapsetMappings");
    }
    if (mapset == null) {
      throw new ApiException(400, "Missing the required parameter 'mapset' when calling findMapsetMappings");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/mapset/{mapset}/mappings"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{mapset}", apiClient.escapeString(mapset));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "query", query)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ascending", ascending));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "leaf", leaf));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<ResultListMapping> localVarReturnType = new GenericType<ResultListMapping>() {};
    return apiClient.invokeAPI("MapsetApi.findMapsetMappings", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find mapsets
   * Finds mapsets matching specified criteria.
   * @param query Search text (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @return ResultListMapset
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching mapsets </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ResultListMapset findMapsets(String query, Integer offset, Integer limit, String sort, Boolean ascending) throws ApiException {
    return findMapsetsWithHttpInfo(query, offset, limit, sort, ascending).getData();
  }

  /**
   * Find mapsets
   * Finds mapsets matching specified criteria.
   * @param query Search text (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @return ApiResponse&lt;ResultListMapset&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching mapsets </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListMapset> findMapsetsWithHttpInfo(String query, Integer offset, Integer limit, String sort, Boolean ascending) throws ApiException {
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
    GenericType<ResultListMapset> localVarReturnType = new GenericType<ResultListMapset>() {};
    return apiClient.invokeAPI("MapsetApi.findMapsets", "/mapset", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get mapset by id
   * Gets mapset for the specified id
   * @param id Mapset id, e.g. \&quot;uuid\&quot; (required)
   * @return Mapset
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Mapset </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public Mapset getMapset(String id) throws ApiException {
    return getMapsetWithHttpInfo(id).getData();
  }

  /**
   * Get mapset by id
   * Gets mapset for the specified id
   * @param id Mapset id, e.g. \&quot;uuid\&quot; (required)
   * @return ApiResponse&lt;Mapset&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Mapset </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Mapset> getMapsetWithHttpInfo(String id) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getMapset");
    }

    // Path parameters
    String localVarPath = "/mapset/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<Mapset> localVarReturnType = new GenericType<Mapset>() {};
    return apiClient.invokeAPI("MapsetApi.getMapset", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get project mapsets
   * Gets mapset objects used by the specified project.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @return List&lt;Mapset&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of project mapsets </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public List<Mapset> getProjectMapsets(String idOrUriLabel) throws ApiException {
    return getProjectMapsetsWithHttpInfo(idOrUriLabel).getData();
  }

  /**
   * Get project mapsets
   * Gets mapset objects used by the specified project.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @return ApiResponse&lt;List&lt;Mapset&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of project mapsets </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Mapset>> getProjectMapsetsWithHttpInfo(String idOrUriLabel) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling getProjectMapsets");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/mapset"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<Mapset>> localVarReturnType = new GenericType<List<Mapset>>() {};
    return apiClient.invokeAPI("MapsetApi.getProjectMapsets", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
