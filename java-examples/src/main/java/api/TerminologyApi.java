package api;

import api.invoker.ApiException;
import api.invoker.ApiClient;
import api.invoker.ApiResponse;
import api.invoker.Configuration;
import api.invoker.Pair;

import jakarta.ws.rs.core.GenericType;

import api.model.ResultListTerminology;
import api.model.Terminology;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-26T15:47:59.449899600-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class TerminologyApi {
  private ApiClient apiClient;

  public TerminologyApi() {
    this(Configuration.getDefaultApiClient());
  }

  public TerminologyApi(ApiClient apiClient) {
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
   * Export terminology
   * Exports specified terminology in the specified format.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param format Requested download format, e.g. \&quot;native\&quot; (required)
   * @return byte[]
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Export terminology matching specified criteria </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public byte[] exportTerminology(String idOrUriLabel, String terminology, String format) throws ApiException {
    return exportTerminologyWithHttpInfo(idOrUriLabel, terminology, format).getData();
  }

  /**
   * Export terminology
   * Exports specified terminology in the specified format.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param format Requested download format, e.g. \&quot;native\&quot; (required)
   * @return ApiResponse&lt;byte[]&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Export terminology matching specified criteria </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<byte[]> exportTerminologyWithHttpInfo(String idOrUriLabel, String terminology, String format) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling exportTerminology");
    }
    if (terminology == null) {
      throw new ApiException(400, "Missing the required parameter 'terminology' when calling exportTerminology");
    }
    if (format == null) {
      throw new ApiException(400, "Missing the required parameter 'format' when calling exportTerminology");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/terminology/{terminology}/export"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{terminology}", apiClient.escapeString(terminology));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "format", format)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/octet-stream");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<byte[]> localVarReturnType = new GenericType<byte[]>() {};
    return apiClient.invokeAPI("TerminologyApi.exportTerminology", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find terminologies
   * Finds terminologies matching specified criteria.
   * @param query Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @return ResultListTerminology
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching terminologies </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ResultListTerminology findTerminologies(String query, Integer offset, Integer limit, String sort, Boolean ascending) throws ApiException {
    return findTerminologiesWithHttpInfo(query, offset, limit, sort, ascending).getData();
  }

  /**
   * Find terminologies
   * Finds terminologies matching specified criteria.
   * @param query Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param offset Start index for search results (optional)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @return ApiResponse&lt;ResultListTerminology&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching terminologies </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListTerminology> findTerminologiesWithHttpInfo(String query, Integer offset, Integer limit, String sort, Boolean ascending) throws ApiException {
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
    GenericType<ResultListTerminology> localVarReturnType = new GenericType<ResultListTerminology>() {};
    return apiClient.invokeAPI("TerminologyApi.findTerminologies", "/terminology", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get project terminologies
   * Gets terminology objects used by the specified project.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @return List&lt;Terminology&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Result list of project terminologies </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public List<Terminology> getProjectTerminologies(String idOrUriLabel) throws ApiException {
    return getProjectTerminologiesWithHttpInfo(idOrUriLabel).getData();
  }

  /**
   * Get project terminologies
   * Gets terminology objects used by the specified project.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @return ApiResponse&lt;List&lt;Terminology&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Result list of project terminologies </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Terminology>> getProjectTerminologiesWithHttpInfo(String idOrUriLabel) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling getProjectTerminologies");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/terminology"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<Terminology>> localVarReturnType = new GenericType<List<Terminology>>() {};
    return apiClient.invokeAPI("TerminologyApi.getProjectTerminologies", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get terminology by id
   * Gets terminology for the specified id
   * @param id Terminology id, e.g. \&quot;uuid\&quot; (required)
   * @return Terminology
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Terminology </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public Terminology getTerminology(String id) throws ApiException {
    return getTerminologyWithHttpInfo(id).getData();
  }

  /**
   * Get terminology by id
   * Gets terminology for the specified id
   * @param id Terminology id, e.g. \&quot;uuid\&quot; (required)
   * @return ApiResponse&lt;Terminology&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Terminology </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Terminology> getTerminologyWithHttpInfo(String id) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getTerminology");
    }

    // Path parameters
    String localVarPath = "/terminology/{id}"
            .replaceAll("\\{id}", apiClient.escapeString(id));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<Terminology> localVarReturnType = new GenericType<Terminology>() {};
    return apiClient.invokeAPI("TerminologyApi.getTerminology", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
