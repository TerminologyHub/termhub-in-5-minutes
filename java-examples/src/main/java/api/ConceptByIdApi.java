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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-03T12:36:52.969136900-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class ConceptByIdApi {
  private ApiClient apiClient;

  public ConceptByIdApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ConceptByIdApi(ApiClient apiClient) {
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
   * Find concept inverse relationships
   * Finds concept inverse relationships for the specified concept id.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param conceptId concept id, e.g. \&quot;uuid\&quot; (required)
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
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching concept inverse relationships </td><td>  -  </td></tr>
     </table>
   */
  public ResultListConceptRelationship findConceptInverseRelationships1(String idOrUriLabel, String conceptId, String query, Integer offset, Integer limit, Boolean ascending, String sort) throws ApiException {
    return findConceptInverseRelationships1WithHttpInfo(idOrUriLabel, conceptId, query, offset, limit, ascending, sort).getData();
  }

  /**
   * Find concept inverse relationships
   * Finds concept inverse relationships for the specified concept id.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param conceptId concept id, e.g. \&quot;uuid\&quot; (required)
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
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching concept inverse relationships </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListConceptRelationship> findConceptInverseRelationships1WithHttpInfo(String idOrUriLabel, String conceptId, String query, Integer offset, Integer limit, Boolean ascending, String sort) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling findConceptInverseRelationships1");
    }
    if (conceptId == null) {
      throw new ApiException(400, "Missing the required parameter 'conceptId' when calling findConceptInverseRelationships1");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{conceptId}/inverseRelationships"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{conceptId}", apiClient.escapeString(conceptId));

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
    return apiClient.invokeAPI("ConceptByIdApi.findConceptInverseRelationships1", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find concept relationships
   * Finds concept relationships for the specified concept id.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param conceptId concept id, e.g. \&quot;uuid\&quot; (required)
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
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public ResultListConceptRelationship findConceptRelationships1(String idOrUriLabel, String conceptId, String query, Integer offset, Integer limit, Boolean ascending, String sort) throws ApiException {
    return findConceptRelationships1WithHttpInfo(idOrUriLabel, conceptId, query, offset, limit, ascending, sort).getData();
  }

  /**
   * Find concept relationships
   * Finds concept relationships for the specified concept id.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param conceptId concept id, e.g. \&quot;uuid\&quot; (required)
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
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListConceptRelationship> findConceptRelationships1WithHttpInfo(String idOrUriLabel, String conceptId, String query, Integer offset, Integer limit, Boolean ascending, String sort) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling findConceptRelationships1");
    }
    if (conceptId == null) {
      throw new ApiException(400, "Missing the required parameter 'conceptId' when calling findConceptRelationships1");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{conceptId}/relationships"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{conceptId}", apiClient.escapeString(conceptId));

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
    return apiClient.invokeAPI("ConceptByIdApi.findConceptRelationships1", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find concept tree position children
   * Finds concept tree position children for the specified concept id.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param conceptId concept id, e.g. \&quot;uuid\&quot; (required)
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
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching concept tree position children </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public ResultListConceptTreePosition findTreePositionChildren1(String idOrUriLabel, String conceptId, String query, Integer offset, Integer limit, Boolean ascending, String sort) throws ApiException {
    return findTreePositionChildren1WithHttpInfo(idOrUriLabel, conceptId, query, offset, limit, ascending, sort).getData();
  }

  /**
   * Find concept tree position children
   * Finds concept tree position children for the specified concept id.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param conceptId concept id, e.g. \&quot;uuid\&quot; (required)
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
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching concept tree position children </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListConceptTreePosition> findTreePositionChildren1WithHttpInfo(String idOrUriLabel, String conceptId, String query, Integer offset, Integer limit, Boolean ascending, String sort) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling findTreePositionChildren1");
    }
    if (conceptId == null) {
      throw new ApiException(400, "Missing the required parameter 'conceptId' when calling findTreePositionChildren1");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{conceptId}/trees/children"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{conceptId}", apiClient.escapeString(conceptId));

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
    return apiClient.invokeAPI("ConceptByIdApi.findTreePositionChildren1", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find concept tree positions
   * Finds concept tree positions for the specified concept id.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param conceptId concept id, e.g. \&quot;uuid\&quot; (required)
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
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching concept tree positions </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public ResultListConceptTreePosition findTreePositions1(String idOrUriLabel, String conceptId, String query, Integer offset, Integer limit, Boolean ascending, String sort) throws ApiException {
    return findTreePositions1WithHttpInfo(idOrUriLabel, conceptId, query, offset, limit, ascending, sort).getData();
  }

  /**
   * Find concept tree positions
   * Finds concept tree positions for the specified concept id.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param conceptId concept id, e.g. \&quot;uuid\&quot; (required)
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
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Result list of matching concept tree positions </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResultListConceptTreePosition> findTreePositions1WithHttpInfo(String idOrUriLabel, String conceptId, String query, Integer offset, Integer limit, Boolean ascending, String sort) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling findTreePositions1");
    }
    if (conceptId == null) {
      throw new ApiException(400, "Missing the required parameter 'conceptId' when calling findTreePositions1");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{conceptId}/trees"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{conceptId}", apiClient.escapeString(conceptId));

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
    return apiClient.invokeAPI("ConceptByIdApi.findTreePositions1", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get concept by id
   * Gets concept for the specified id
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param conceptId concept id, e.g. \&quot;uuid\&quot; (required)
   * @param include Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;&#39;https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md&#39; target&#x3D;&#39;_blank&#39;&gt;See here for detailed information&lt;/a&gt;. (optional)
   * @return Concept
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Concept matching specified id in specified project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public Concept getConcept1(String idOrUriLabel, String conceptId, String include) throws ApiException {
    return getConcept1WithHttpInfo(idOrUriLabel, conceptId, include).getData();
  }

  /**
   * Get concept by id
   * Gets concept for the specified id
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param conceptId concept id, e.g. \&quot;uuid\&quot; (required)
   * @param include Indicator of how much data to return. Comma-separated list of any of the following values: minimal, summary, full, axioms, attributes, children, definitions, descendants, highlights, inverseRelationships, mapsets, parents, relationships, semanticTypes, subsets, terms, treePositions&lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;&#39;https://github.com/TerminologyHub/termhub-in-5-minutes/blob/main/doc/INCLUDE.md&#39; target&#x3D;&#39;_blank&#39;&gt;See here for detailed information&lt;/a&gt;. (optional)
   * @return ApiResponse&lt;Concept&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Concept matching specified id in specified project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Concept> getConcept1WithHttpInfo(String idOrUriLabel, String conceptId, String include) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling getConcept1");
    }
    if (conceptId == null) {
      throw new ApiException(400, "Missing the required parameter 'conceptId' when calling getConcept1");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{conceptId}"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{conceptId}", apiClient.escapeString(conceptId));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "include", include)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<Concept> localVarReturnType = new GenericType<Concept>() {};
    return apiClient.invokeAPI("ConceptByIdApi.getConcept1", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get concept diagram
   * Gets concept diagram for the specified concept.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param conceptId concept id, e.g. \&quot;uuid\&quot; (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Concept diagram </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
     </table>
   */
  public void getConceptDiagram1(String idOrUriLabel, String conceptId) throws ApiException {
    getConceptDiagram1WithHttpInfo(idOrUriLabel, conceptId);
  }

  /**
   * Get concept diagram
   * Gets concept diagram for the specified concept.
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param conceptId concept id, e.g. \&quot;uuid\&quot; (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Concept diagram </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> getConceptDiagram1WithHttpInfo(String idOrUriLabel, String conceptId) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling getConceptDiagram1");
    }
    if (conceptId == null) {
      throw new ApiException(400, "Missing the required parameter 'conceptId' when calling getConceptDiagram1");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{conceptId}/diagram"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{conceptId}", apiClient.escapeString(conceptId));

    String localVarAccept = apiClient.selectHeaderAccept("application/json", "image/png");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    return apiClient.invokeAPI("ConceptByIdApi.getConceptDiagram1", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get mappings to concept by id
   * Gets mappings to the specified concept
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param conceptId concept id, e.g. \&quot;uuid\&quot; (required)
   * @return List&lt;Mapping&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Mappings to the concept matching specified id in specified project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public List<Mapping> getConceptInverseMappings1(String idOrUriLabel, String conceptId) throws ApiException {
    return getConceptInverseMappings1WithHttpInfo(idOrUriLabel, conceptId).getData();
  }

  /**
   * Get mappings to concept by id
   * Gets mappings to the specified concept
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param conceptId concept id, e.g. \&quot;uuid\&quot; (required)
   * @return ApiResponse&lt;List&lt;Mapping&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Mappings to the concept matching specified id in specified project </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Mapping>> getConceptInverseMappings1WithHttpInfo(String idOrUriLabel, String conceptId) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling getConceptInverseMappings1");
    }
    if (conceptId == null) {
      throw new ApiException(400, "Missing the required parameter 'conceptId' when calling getConceptInverseMappings1");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{conceptId}/inverseMappings"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{conceptId}", apiClient.escapeString(conceptId));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<Mapping>> localVarReturnType = new GenericType<List<Mapping>>() {};
    return apiClient.invokeAPI("ConceptByIdApi.getConceptInverseMappings1", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get mappings from concept by id
   * Gets mappings from the specified concept
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param conceptId concept id, e.g. \&quot;uuid\&quot; (required)
   * @return List&lt;Mapping&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Mappings from the concept matching specified id in specified project </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public List<Mapping> getConceptMappings1(String idOrUriLabel, String conceptId) throws ApiException {
    return getConceptMappings1WithHttpInfo(idOrUriLabel, conceptId).getData();
  }

  /**
   * Get mappings from concept by id
   * Gets mappings from the specified concept
   * @param idOrUriLabel Project id or uriLabel, e.g. \&quot;sandbox\&quot; (required)
   * @param conceptId concept id, e.g. \&quot;uuid\&quot; (required)
   * @return ApiResponse&lt;List&lt;Mapping&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Mappings from the concept matching specified id in specified project </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Mapping>> getConceptMappings1WithHttpInfo(String idOrUriLabel, String conceptId) throws ApiException {
    // Check required parameters
    if (idOrUriLabel == null) {
      throw new ApiException(400, "Missing the required parameter 'idOrUriLabel' when calling getConceptMappings1");
    }
    if (conceptId == null) {
      throw new ApiException(400, "Missing the required parameter 'conceptId' when calling getConceptMappings1");
    }

    // Path parameters
    String localVarPath = "/project/{idOrUriLabel}/concept/{conceptId}/mappings"
            .replaceAll("\\{idOrUriLabel}", apiClient.escapeString(idOrUriLabel))
            .replaceAll("\\{conceptId}", apiClient.escapeString(conceptId));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<Mapping>> localVarReturnType = new GenericType<List<Mapping>>() {};
    return apiClient.invokeAPI("ConceptByIdApi.getConceptMappings1", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
