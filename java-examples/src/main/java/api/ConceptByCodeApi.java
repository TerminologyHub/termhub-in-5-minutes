package api;

import api.invoker.ApiException;
import api.invoker.ApiClient;
import api.invoker.ApiResponse;
import api.invoker.Configuration;
import api.invoker.Pair;

import jakarta.ws.rs.core.GenericType;

import api.model.Concept;
import api.model.Mapping;
import api.model.ResultListConceptRelationship;
import api.model.ResultListConceptTreePosition;
import api.model.SubsetMember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-08-12T13:13:49.637811500-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class ConceptByCodeApi {
  private ApiClient apiClient;

  public ConceptByCodeApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ConceptByCodeApi(ApiClient apiClient) {
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
   * Find concept inverse relationships by terminology and code
   * Finds concept inverse relationships for the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @param query Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param offset Start index for search results (optional, default to 0)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional, default to 10)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @return ResultListConceptRelationship
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching concept inverse relationships </td><td>  -  </td></tr>
     </table>
   */
  public ResultListConceptRelationship findConceptInverseRelationships(String idOrUriLabel, String terminology, String code, String query, Integer offset, Integer limit, Boolean ascending, String sort) throws ApiException {
    return findConceptInverseRelationshipsWithHttpInfo(idOrUriLabel, terminology, code, query, offset, limit, ascending, sort).getData();
  }

  /**
   * Find concept inverse relationships by terminology and code
   * Finds concept inverse relationships for the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @param query Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param offset Start index for search results (optional, default to 0)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional, default to 10)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @return ApiResponse&lt;ResultListConceptRelationship&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching concept inverse relationships </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListConceptRelationship> findConceptInverseRelationshipsWithHttpInfo(String idOrUriLabel, String terminology, String code, String query, Integer offset, Integer limit, Boolean ascending, String sort) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling findConceptInverseRelationships");
    }
    if (terminology == null) {
      throw new ApiException(400, "Missing the required parameter 'terminology' when calling findConceptInverseRelationships");
    }
    if (code == null) {
      throw new ApiException(400, "Missing the required parameter 'code' when calling findConceptInverseRelationships");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{terminology}/{code}/inverseRelationships"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{terminology}", apiClient.escapeString(terminology))
            .replaceAll("\\{code}", apiClient.escapeString(code));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "query", query)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ascending", ascending));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<ResultListConceptRelationship> localVarReturnType = new GenericType<ResultListConceptRelationship>() {};
    return apiClient.invokeAPI("ConceptByCodeApi.findConceptInverseRelationships", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find concept relationships by terminology and code
   * Finds concept relationships for the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @param query Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param offset Start index for search results (optional, default to 0)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional, default to 10)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @return ResultListConceptRelationship
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Result list of matching concept relationships </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ResultListConceptRelationship findConceptRelationships(String idOrUriLabel, String terminology, String code, String query, Integer offset, Integer limit, Boolean ascending, String sort) throws ApiException {
    return findConceptRelationshipsWithHttpInfo(idOrUriLabel, terminology, code, query, offset, limit, ascending, sort).getData();
  }

  /**
   * Find concept relationships by terminology and code
   * Finds concept relationships for the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @param query Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param offset Start index for search results (optional, default to 0)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional, default to 10)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @return ApiResponse&lt;ResultListConceptRelationship&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Result list of matching concept relationships </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListConceptRelationship> findConceptRelationshipsWithHttpInfo(String idOrUriLabel, String terminology, String code, String query, Integer offset, Integer limit, Boolean ascending, String sort) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling findConceptRelationships");
    }
    if (terminology == null) {
      throw new ApiException(400, "Missing the required parameter 'terminology' when calling findConceptRelationships");
    }
    if (code == null) {
      throw new ApiException(400, "Missing the required parameter 'code' when calling findConceptRelationships");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{terminology}/{code}/relationships"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{terminology}", apiClient.escapeString(terminology))
            .replaceAll("\\{code}", apiClient.escapeString(code));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "query", query)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ascending", ascending));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<ResultListConceptRelationship> localVarReturnType = new GenericType<ResultListConceptRelationship>() {};
    return apiClient.invokeAPI("ConceptByCodeApi.findConceptRelationships", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find concept tree position children by terminology and code
   * Finds concept tree position children for the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @param query Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param offset Start index for search results (optional, default to 0)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional, default to 10)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @return ResultListConceptTreePosition
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching concept tree position children </td><td>  -  </td></tr>
     </table>
   */
  public ResultListConceptTreePosition findTreePositionChildren(String idOrUriLabel, String terminology, String code, String query, Integer offset, Integer limit, Boolean ascending, String sort) throws ApiException {
    return findTreePositionChildrenWithHttpInfo(idOrUriLabel, terminology, code, query, offset, limit, ascending, sort).getData();
  }

  /**
   * Find concept tree position children by terminology and code
   * Finds concept tree position children for the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @param query Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param offset Start index for search results (optional, default to 0)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional, default to 10)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @return ApiResponse&lt;ResultListConceptTreePosition&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching concept tree position children </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListConceptTreePosition> findTreePositionChildrenWithHttpInfo(String idOrUriLabel, String terminology, String code, String query, Integer offset, Integer limit, Boolean ascending, String sort) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling findTreePositionChildren");
    }
    if (terminology == null) {
      throw new ApiException(400, "Missing the required parameter 'terminology' when calling findTreePositionChildren");
    }
    if (code == null) {
      throw new ApiException(400, "Missing the required parameter 'code' when calling findTreePositionChildren");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{terminology}/{code}/trees/children"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{terminology}", apiClient.escapeString(terminology))
            .replaceAll("\\{code}", apiClient.escapeString(code));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "query", query)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ascending", ascending));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<ResultListConceptTreePosition> localVarReturnType = new GenericType<ResultListConceptTreePosition>() {};
    return apiClient.invokeAPI("ConceptByCodeApi.findTreePositionChildren", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find concept tree positions by terminology and code
   * Finds concept tree positions for the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @param query Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param offset Start index for search results (optional, default to 0)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional, default to 10)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @return ResultListConceptTreePosition
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching concept tree positions </td><td>  -  </td></tr>
     </table>
   */
  public ResultListConceptTreePosition findTreePositions(String idOrUriLabel, String terminology, String code, String query, Integer offset, Integer limit, Boolean ascending, String sort) throws ApiException {
    return findTreePositionsWithHttpInfo(idOrUriLabel, terminology, code, query, offset, limit, ascending, sort).getData();
  }

  /**
   * Find concept tree positions by terminology and code
   * Finds concept tree positions for the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @param query Search text (&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes/blob/master/doc/SEARCH.md\&quot;&gt;See here for more info&lt;/a&gt;) (optional)
   * @param offset Start index for search results (optional, default to 0)
   * @param limit Limit of results to return (hard limit of 1000 regardless of value) (optional, default to 10)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @param sort Comma-separated list of fields to sort on (optional)
   * @return ApiResponse&lt;ResultListConceptTreePosition&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching concept tree positions </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListConceptTreePosition> findTreePositionsWithHttpInfo(String idOrUriLabel, String terminology, String code, String query, Integer offset, Integer limit, Boolean ascending, String sort) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling findTreePositions");
    }
    if (terminology == null) {
      throw new ApiException(400, "Missing the required parameter 'terminology' when calling findTreePositions");
    }
    if (code == null) {
      throw new ApiException(400, "Missing the required parameter 'code' when calling findTreePositions");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{terminology}/{code}/trees"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{terminology}", apiClient.escapeString(terminology))
            .replaceAll("\\{code}", apiClient.escapeString(code));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "query", query)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ascending", ascending));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<ResultListConceptTreePosition> localVarReturnType = new GenericType<ResultListConceptTreePosition>() {};
    return apiClient.invokeAPI("ConceptByCodeApi.findTreePositions", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get concept by terminology and code
   * Gets concept for the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @param include Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;&#39;https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md&#39; target&#x3D;&#39;_blank&#39;&gt;See here for detailed information&lt;/a&gt;. (optional)
   * @return Concept
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Concept matching specified terminology and code in specified project </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public Concept getConcept(String idOrUriLabel, String terminology, String code, String include) throws ApiException {
    return getConceptWithHttpInfo(idOrUriLabel, terminology, code, include).getData();
  }

  /**
   * Get concept by terminology and code
   * Gets concept for the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @param include Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;&#39;https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md&#39; target&#x3D;&#39;_blank&#39;&gt;See here for detailed information&lt;/a&gt;. (optional)
   * @return ApiResponse&lt;Concept&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Concept matching specified terminology and code in specified project </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Concept> getConceptWithHttpInfo(String idOrUriLabel, String terminology, String code, String include) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling getConcept");
    }
    if (terminology == null) {
      throw new ApiException(400, "Missing the required parameter 'terminology' when calling getConcept");
    }
    if (code == null) {
      throw new ApiException(400, "Missing the required parameter 'code' when calling getConcept");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{terminology}/{code}"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{terminology}", apiClient.escapeString(terminology))
            .replaceAll("\\{code}", apiClient.escapeString(code));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "include", include)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<Concept> localVarReturnType = new GenericType<Concept>() {};
    return apiClient.invokeAPI("ConceptByCodeApi.getConcept", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get concepts by terminology and list of codes
   * Gets concepts for the specified terminology and list of codes. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param codes Comma-separated list of terminology codes, e.g. \&quot;1119,1149\&quot; or \&quot;64572001,22298006 \&quot; (required)
   * @param include Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;&#39;https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md&#39; target&#x3D;&#39;_blank&#39;&gt;See here for detailed information&lt;/a&gt;. (optional)
   * @return List&lt;Concept&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Concepts mathcing code list in the specified project </td><td>  -  </td></tr>
     </table>
   */
  public List<Concept> getConceptCodes(String idOrUriLabel, String terminology, String codes, String include) throws ApiException {
    return getConceptCodesWithHttpInfo(idOrUriLabel, terminology, codes, include).getData();
  }

  /**
   * Get concepts by terminology and list of codes
   * Gets concepts for the specified terminology and list of codes. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param codes Comma-separated list of terminology codes, e.g. \&quot;1119,1149\&quot; or \&quot;64572001,22298006 \&quot; (required)
   * @param include Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;&#39;https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md&#39; target&#x3D;&#39;_blank&#39;&gt;See here for detailed information&lt;/a&gt;. (optional)
   * @return ApiResponse&lt;List&lt;Concept&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Concepts mathcing code list in the specified project </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Concept>> getConceptCodesWithHttpInfo(String idOrUriLabel, String terminology, String codes, String include) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling getConceptCodes");
    }
    if (terminology == null) {
      throw new ApiException(400, "Missing the required parameter 'terminology' when calling getConceptCodes");
    }
    if (codes == null) {
      throw new ApiException(400, "Missing the required parameter 'codes' when calling getConceptCodes");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{terminology}"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{terminology}", apiClient.escapeString(terminology));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "codes", codes)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "include", include));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<Concept>> localVarReturnType = new GenericType<List<Concept>>() {};
    return apiClient.invokeAPI("ConceptByCodeApi.getConceptCodes", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get concept diagram by terminology and code
   * Gets concept diagram for the specified terminology and code.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Concept diagram </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
     </table>
   */
  public void getConceptDiagram(String idOrUriLabel, String terminology, String code) throws ApiException {
    getConceptDiagramWithHttpInfo(idOrUriLabel, terminology, code);
  }

  /**
   * Get concept diagram by terminology and code
   * Gets concept diagram for the specified terminology and code.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Concept diagram </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> getConceptDiagramWithHttpInfo(String idOrUriLabel, String terminology, String code) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling getConceptDiagram");
    }
    if (terminology == null) {
      throw new ApiException(400, "Missing the required parameter 'terminology' when calling getConceptDiagram");
    }
    if (code == null) {
      throw new ApiException(400, "Missing the required parameter 'code' when calling getConceptDiagram");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{terminology}/{code}/diagram"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{terminology}", apiClient.escapeString(terminology))
            .replaceAll("\\{code}", apiClient.escapeString(code));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "image/png");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    return apiClient.invokeAPI("ConceptByCodeApi.getConceptDiagram", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get mappings to concept by terminology and code
   * Gets mappings tothe concept with the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @return List&lt;Mapping&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Mappings to the concept matching specified terminology and code </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public List<Mapping> getConceptInverseMappings(String idOrUriLabel, String terminology, String code) throws ApiException {
    return getConceptInverseMappingsWithHttpInfo(idOrUriLabel, terminology, code).getData();
  }

  /**
   * Get mappings to concept by terminology and code
   * Gets mappings tothe concept with the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @return ApiResponse&lt;List&lt;Mapping&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Mappings to the concept matching specified terminology and code </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Mapping>> getConceptInverseMappingsWithHttpInfo(String idOrUriLabel, String terminology, String code) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling getConceptInverseMappings");
    }
    if (terminology == null) {
      throw new ApiException(400, "Missing the required parameter 'terminology' when calling getConceptInverseMappings");
    }
    if (code == null) {
      throw new ApiException(400, "Missing the required parameter 'code' when calling getConceptInverseMappings");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{terminology}/{code}/inverseMappings"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{terminology}", apiClient.escapeString(terminology))
            .replaceAll("\\{code}", apiClient.escapeString(code));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<Mapping>> localVarReturnType = new GenericType<List<Mapping>>() {};
    return apiClient.invokeAPI("ConceptByCodeApi.getConceptInverseMappings", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get mappings from concept by terminology and code
   * Gets mappings from the concept with the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @return List&lt;Mapping&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Mappings from the concept matching specified terminology and code </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public List<Mapping> getConceptMappings(String idOrUriLabel, String terminology, String code) throws ApiException {
    return getConceptMappingsWithHttpInfo(idOrUriLabel, terminology, code).getData();
  }

  /**
   * Get mappings from concept by terminology and code
   * Gets mappings from the concept with the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @return ApiResponse&lt;List&lt;Mapping&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Mappings from the concept matching specified terminology and code </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Mapping>> getConceptMappingsWithHttpInfo(String idOrUriLabel, String terminology, String code) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling getConceptMappings");
    }
    if (terminology == null) {
      throw new ApiException(400, "Missing the required parameter 'terminology' when calling getConceptMappings");
    }
    if (code == null) {
      throw new ApiException(400, "Missing the required parameter 'code' when calling getConceptMappings");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{terminology}/{code}/mappings"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{terminology}", apiClient.escapeString(terminology))
            .replaceAll("\\{code}", apiClient.escapeString(code));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<Mapping>> localVarReturnType = new GenericType<List<Mapping>>() {};
    return apiClient.invokeAPI("ConceptByCodeApi.getConceptMappings", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get subset members from concept by terminology and code
   * Gets subset members from the concept with the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @return List&lt;SubsetMember&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Subset members from the concept matching specified terminology and code </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public List<SubsetMember> getConceptMembers(String idOrUriLabel, String terminology, String code) throws ApiException {
    return getConceptMembersWithHttpInfo(idOrUriLabel, terminology, code).getData();
  }

  /**
   * Get subset members from concept by terminology and code
   * Gets subset members from the concept with the specified terminology and code. This call will not work for projects hosting multiple versions of the same terminology.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param terminology Terminology id or abbreviation. e.g. \&quot;uuid1\&quot; or \&quot;ICD10CM\&quot;. (required)
   * @param code Terminology code, e.g. \&quot;1119\&quot;, \&quot;8867-4\&quot;, or \&quot;64572001\&quot; (required)
   * @return ApiResponse&lt;List&lt;SubsetMember&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Subset members from the concept matching specified terminology and code </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<SubsetMember>> getConceptMembersWithHttpInfo(String idOrUriLabel, String terminology, String code) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling getConceptMembers");
    }
    if (terminology == null) {
      throw new ApiException(400, "Missing the required parameter 'terminology' when calling getConceptMembers");
    }
    if (code == null) {
      throw new ApiException(400, "Missing the required parameter 'code' when calling getConceptMembers");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{terminology}/{code}/members"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{terminology}", apiClient.escapeString(terminology))
            .replaceAll("\\{code}", apiClient.escapeString(code));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<SubsetMember>> localVarReturnType = new GenericType<List<SubsetMember>>() {};
    return apiClient.invokeAPI("ConceptByCodeApi.getConceptMembers", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
