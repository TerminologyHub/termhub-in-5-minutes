package api;

import api.invoker.ApiException;
import api.invoker.ApiClient;
import api.invoker.ApiResponse;
import api.invoker.Configuration;
import api.invoker.Pair;

import jakarta.ws.rs.core.GenericType;

import api.model.ConceptRef;
import java.io.File;
import api.model.Mapping;
import api.model.SubsetMember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-05-14T14:37:22.308097300-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class HistoryApi {
  private ApiClient apiClient;

  public HistoryApi() {
    this(Configuration.getDefaultApiClient());
  }

  public HistoryApi(ApiClient apiClient) {
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
   * Exports mapset mappings added since prior version
   * Exports mapping from/to/type for mappings added in the mapset since the specified older version
   * @param id Mapset id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior mapset version, e.g. \&quot;20240101\&quot; (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> File of mappings added since prior version </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public File exportMapsetHistoryNewMappings(String id, String priorVersion) throws ApiException {
    return exportMapsetHistoryNewMappingsWithHttpInfo(id, priorVersion).getData();
  }

  /**
   * Exports mapset mappings added since prior version
   * Exports mapping from/to/type for mappings added in the mapset since the specified older version
   * @param id Mapset id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior mapset version, e.g. \&quot;20240101\&quot; (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> File of mappings added since prior version </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> exportMapsetHistoryNewMappingsWithHttpInfo(String id, String priorVersion) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling exportMapsetHistoryNewMappings");
    }
    if (priorVersion == null) {
      throw new ApiException(400, "Missing the required parameter 'priorVersion' when calling exportMapsetHistoryNewMappings");
    }

    // Path parameters
    String localVarPath = "/mapset/{id}/history/{priorVersion}/mappings/new/export"
            .replaceAll("\\{id}", apiClient.escapeString(id))
            .replaceAll("\\{priorVersion}", apiClient.escapeString(priorVersion));

    String localVarAccept = apiClient.selectHeaderAccept("text/plain");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI("HistoryApi.exportMapsetHistoryNewMappings", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Exports mapset mappings retired since prior version
   * Exports mapping from/to/type for mappings retired in the mapset since the specified prior version
   * @param id Mapset id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior mapset version, e.g. \&quot;20240101\&quot; (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> File of mappings retired since prior version </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public File exportMapsetHistoryRetiredMappings(String id, String priorVersion) throws ApiException {
    return exportMapsetHistoryRetiredMappingsWithHttpInfo(id, priorVersion).getData();
  }

  /**
   * Exports mapset mappings retired since prior version
   * Exports mapping from/to/type for mappings retired in the mapset since the specified prior version
   * @param id Mapset id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior mapset version, e.g. \&quot;20240101\&quot; (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> File of mappings retired since prior version </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> exportMapsetHistoryRetiredMappingsWithHttpInfo(String id, String priorVersion) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling exportMapsetHistoryRetiredMappings");
    }
    if (priorVersion == null) {
      throw new ApiException(400, "Missing the required parameter 'priorVersion' when calling exportMapsetHistoryRetiredMappings");
    }

    // Path parameters
    String localVarPath = "/mapset/{id}/history/{priorVersion}/mappings/retired/export"
            .replaceAll("\\{id}", apiClient.escapeString(id))
            .replaceAll("\\{priorVersion}", apiClient.escapeString(priorVersion));

    String localVarAccept = apiClient.selectHeaderAccept("text/plain");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI("HistoryApi.exportMapsetHistoryRetiredMappings", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Exports subset members added since prior version
   * Exports member code/name for members added in the subset since the specified older version
   * @param id Subset id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior subset version, e.g. \&quot;20240101\&quot; (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> File of members added since prior version </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public File exportSubsetHistoryNewMembers(String id, String priorVersion) throws ApiException {
    return exportSubsetHistoryNewMembersWithHttpInfo(id, priorVersion).getData();
  }

  /**
   * Exports subset members added since prior version
   * Exports member code/name for members added in the subset since the specified older version
   * @param id Subset id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior subset version, e.g. \&quot;20240101\&quot; (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> File of members added since prior version </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> exportSubsetHistoryNewMembersWithHttpInfo(String id, String priorVersion) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling exportSubsetHistoryNewMembers");
    }
    if (priorVersion == null) {
      throw new ApiException(400, "Missing the required parameter 'priorVersion' when calling exportSubsetHistoryNewMembers");
    }

    // Path parameters
    String localVarPath = "/subset/{id}/history/{priorVersion}/members/new/export"
            .replaceAll("\\{id}", apiClient.escapeString(id))
            .replaceAll("\\{priorVersion}", apiClient.escapeString(priorVersion));

    String localVarAccept = apiClient.selectHeaderAccept("text/plain");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI("HistoryApi.exportSubsetHistoryNewMembers", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Exports subset members retired since prior version
   * Exports member code/name for members retired in the subset since the specified prior version
   * @param id Subset id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior subset version, e.g. \&quot;20240101\&quot; (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> File of members retired since prior version </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public File exportSubsetHistoryRetiredMembers(String id, String priorVersion) throws ApiException {
    return exportSubsetHistoryRetiredMembersWithHttpInfo(id, priorVersion).getData();
  }

  /**
   * Exports subset members retired since prior version
   * Exports member code/name for members retired in the subset since the specified prior version
   * @param id Subset id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior subset version, e.g. \&quot;20240101\&quot; (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> File of members retired since prior version </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> exportSubsetHistoryRetiredMembersWithHttpInfo(String id, String priorVersion) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling exportSubsetHistoryRetiredMembers");
    }
    if (priorVersion == null) {
      throw new ApiException(400, "Missing the required parameter 'priorVersion' when calling exportSubsetHistoryRetiredMembers");
    }

    // Path parameters
    String localVarPath = "/subset/{id}/history/{priorVersion}/members/retired/export"
            .replaceAll("\\{id}", apiClient.escapeString(id))
            .replaceAll("\\{priorVersion}", apiClient.escapeString(priorVersion));

    String localVarAccept = apiClient.selectHeaderAccept("text/plain");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI("HistoryApi.exportSubsetHistoryRetiredMembers", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Exports terminology concepts added since prior version
   * Exports concept code/name/semanticType for concepts added in the terminology since the specified older version
   * @param id Terminology id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior terminology version, e.g. \&quot;20240101\&quot; (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> File of concepts added since prior version </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public File exportTerminologyHistoryNewConcepts(String id, String priorVersion) throws ApiException {
    return exportTerminologyHistoryNewConceptsWithHttpInfo(id, priorVersion).getData();
  }

  /**
   * Exports terminology concepts added since prior version
   * Exports concept code/name/semanticType for concepts added in the terminology since the specified older version
   * @param id Terminology id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior terminology version, e.g. \&quot;20240101\&quot; (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> File of concepts added since prior version </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> exportTerminologyHistoryNewConceptsWithHttpInfo(String id, String priorVersion) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling exportTerminologyHistoryNewConcepts");
    }
    if (priorVersion == null) {
      throw new ApiException(400, "Missing the required parameter 'priorVersion' when calling exportTerminologyHistoryNewConcepts");
    }

    // Path parameters
    String localVarPath = "/terminology/{id}/history/{priorVersion}/concepts/new/export"
            .replaceAll("\\{id}", apiClient.escapeString(id))
            .replaceAll("\\{priorVersion}", apiClient.escapeString(priorVersion));

    String localVarAccept = apiClient.selectHeaderAccept("text/plain");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI("HistoryApi.exportTerminologyHistoryNewConcepts", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Exports terminology concepts retired since prior version
   * Exports concept code/name for concepts retired in the terminology since the specified prior version
   * @param id Terminology id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior terminology version, e.g. \&quot;20240101\&quot; (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> File of concepts retired since prior version </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public File exportTerminologyHistoryRetiredConcepts(String id, String priorVersion) throws ApiException {
    return exportTerminologyHistoryRetiredConceptsWithHttpInfo(id, priorVersion).getData();
  }

  /**
   * Exports terminology concepts retired since prior version
   * Exports concept code/name for concepts retired in the terminology since the specified prior version
   * @param id Terminology id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior terminology version, e.g. \&quot;20240101\&quot; (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> File of concepts retired since prior version </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> exportTerminologyHistoryRetiredConceptsWithHttpInfo(String id, String priorVersion) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling exportTerminologyHistoryRetiredConcepts");
    }
    if (priorVersion == null) {
      throw new ApiException(400, "Missing the required parameter 'priorVersion' when calling exportTerminologyHistoryRetiredConcepts");
    }

    // Path parameters
    String localVarPath = "/terminology/{id}/history/{priorVersion}/concepts/retired/export"
            .replaceAll("\\{id}", apiClient.escapeString(id))
            .replaceAll("\\{priorVersion}", apiClient.escapeString(priorVersion));

    String localVarAccept = apiClient.selectHeaderAccept("text/plain");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI("HistoryApi.exportTerminologyHistoryRetiredConcepts", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get mapset mappings added since prior version
   * Gets mapping from/to/type for new active mappings in the mapset since the specified prior version
   * @param id Mapset id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior mapset version, e.g. \&quot;20240101\&quot; (required)
   * @return List&lt;Mapping&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> List of mapping from/to/type that are new </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public List<Mapping> getMapsetHistoryNewMappings(String id, String priorVersion) throws ApiException {
    return getMapsetHistoryNewMappingsWithHttpInfo(id, priorVersion).getData();
  }

  /**
   * Get mapset mappings added since prior version
   * Gets mapping from/to/type for new active mappings in the mapset since the specified prior version
   * @param id Mapset id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior mapset version, e.g. \&quot;20240101\&quot; (required)
   * @return ApiResponse&lt;List&lt;Mapping&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> List of mapping from/to/type that are new </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Mapping>> getMapsetHistoryNewMappingsWithHttpInfo(String id, String priorVersion) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getMapsetHistoryNewMappings");
    }
    if (priorVersion == null) {
      throw new ApiException(400, "Missing the required parameter 'priorVersion' when calling getMapsetHistoryNewMappings");
    }

    // Path parameters
    String localVarPath = "/mapset/{id}/history/{priorVersion}/mappings/new"
            .replaceAll("\\{id}", apiClient.escapeString(id))
            .replaceAll("\\{priorVersion}", apiClient.escapeString(priorVersion));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<Mapping>> localVarReturnType = new GenericType<List<Mapping>>() {};
    return apiClient.invokeAPI("HistoryApi.getMapsetHistoryNewMappings", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get mapset mappings retired since prior version
   * Gets mapping from/to/type for mappings retired in the mapset since the specified prior version
   * @param id Mapset id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior mapset version, e.g. \&quot;20240101\&quot; (required)
   * @return List&lt;Mapping&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> List of mapping from/to/type that are now retired </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public List<Mapping> getMapsetHistoryRetiredMappings(String id, String priorVersion) throws ApiException {
    return getMapsetHistoryRetiredMappingsWithHttpInfo(id, priorVersion).getData();
  }

  /**
   * Get mapset mappings retired since prior version
   * Gets mapping from/to/type for mappings retired in the mapset since the specified prior version
   * @param id Mapset id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior mapset version, e.g. \&quot;20240101\&quot; (required)
   * @return ApiResponse&lt;List&lt;Mapping&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> List of mapping from/to/type that are now retired </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Mapping>> getMapsetHistoryRetiredMappingsWithHttpInfo(String id, String priorVersion) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getMapsetHistoryRetiredMappings");
    }
    if (priorVersion == null) {
      throw new ApiException(400, "Missing the required parameter 'priorVersion' when calling getMapsetHistoryRetiredMappings");
    }

    // Path parameters
    String localVarPath = "/mapset/{id}/history/{priorVersion}/mappings/retired"
            .replaceAll("\\{id}", apiClient.escapeString(id))
            .replaceAll("\\{priorVersion}", apiClient.escapeString(priorVersion));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<Mapping>> localVarReturnType = new GenericType<List<Mapping>>() {};
    return apiClient.invokeAPI("HistoryApi.getMapsetHistoryRetiredMappings", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get subset members added since prior version
   * Gets member code/name for new active members in the subset since the specified prior version
   * @param id Subset id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior subset version, e.g. \&quot;20240101\&quot; (required)
   * @return List&lt;SubsetMember&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> List of member code/name that are new </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public List<SubsetMember> getSubsetHistoryNewMembers(String id, String priorVersion) throws ApiException {
    return getSubsetHistoryNewMembersWithHttpInfo(id, priorVersion).getData();
  }

  /**
   * Get subset members added since prior version
   * Gets member code/name for new active members in the subset since the specified prior version
   * @param id Subset id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior subset version, e.g. \&quot;20240101\&quot; (required)
   * @return ApiResponse&lt;List&lt;SubsetMember&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> List of member code/name that are new </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<SubsetMember>> getSubsetHistoryNewMembersWithHttpInfo(String id, String priorVersion) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getSubsetHistoryNewMembers");
    }
    if (priorVersion == null) {
      throw new ApiException(400, "Missing the required parameter 'priorVersion' when calling getSubsetHistoryNewMembers");
    }

    // Path parameters
    String localVarPath = "/subset/{id}/history/{priorVersion}/members/new"
            .replaceAll("\\{id}", apiClient.escapeString(id))
            .replaceAll("\\{priorVersion}", apiClient.escapeString(priorVersion));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<SubsetMember>> localVarReturnType = new GenericType<List<SubsetMember>>() {};
    return apiClient.invokeAPI("HistoryApi.getSubsetHistoryNewMembers", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get subset members retired since prior version
   * Gets member code/name for members retired in the subset since the specified prior version
   * @param id Subset id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior subset version, e.g. \&quot;20240101\&quot; (required)
   * @return List&lt;SubsetMember&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> List of member code/name that are now retired </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public List<SubsetMember> getSubsetHistoryRetiredMembers(String id, String priorVersion) throws ApiException {
    return getSubsetHistoryRetiredMembersWithHttpInfo(id, priorVersion).getData();
  }

  /**
   * Get subset members retired since prior version
   * Gets member code/name for members retired in the subset since the specified prior version
   * @param id Subset id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior subset version, e.g. \&quot;20240101\&quot; (required)
   * @return ApiResponse&lt;List&lt;SubsetMember&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> List of member code/name that are now retired </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<SubsetMember>> getSubsetHistoryRetiredMembersWithHttpInfo(String id, String priorVersion) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getSubsetHistoryRetiredMembers");
    }
    if (priorVersion == null) {
      throw new ApiException(400, "Missing the required parameter 'priorVersion' when calling getSubsetHistoryRetiredMembers");
    }

    // Path parameters
    String localVarPath = "/subset/{id}/history/{priorVersion}/members/retired"
            .replaceAll("\\{id}", apiClient.escapeString(id))
            .replaceAll("\\{priorVersion}", apiClient.escapeString(priorVersion));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<SubsetMember>> localVarReturnType = new GenericType<List<SubsetMember>>() {};
    return apiClient.invokeAPI("HistoryApi.getSubsetHistoryRetiredMembers", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get terminology concepts added since prior version
   * Gets concept code/name for new active concepts in the terminology since the specified prior version
   * @param id Terminology id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior terminology version, e.g. \&quot;20240101\&quot; (required)
   * @return List&lt;ConceptRef&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> List of concept code/name that are new </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public List<ConceptRef> getTerminologyHistoryNewConcepts(String id, String priorVersion) throws ApiException {
    return getTerminologyHistoryNewConceptsWithHttpInfo(id, priorVersion).getData();
  }

  /**
   * Get terminology concepts added since prior version
   * Gets concept code/name for new active concepts in the terminology since the specified prior version
   * @param id Terminology id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior terminology version, e.g. \&quot;20240101\&quot; (required)
   * @return ApiResponse&lt;List&lt;ConceptRef&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> List of concept code/name that are new </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ConceptRef>> getTerminologyHistoryNewConceptsWithHttpInfo(String id, String priorVersion) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getTerminologyHistoryNewConcepts");
    }
    if (priorVersion == null) {
      throw new ApiException(400, "Missing the required parameter 'priorVersion' when calling getTerminologyHistoryNewConcepts");
    }

    // Path parameters
    String localVarPath = "/terminology/{id}/history/{priorVersion}/concepts/new"
            .replaceAll("\\{id}", apiClient.escapeString(id))
            .replaceAll("\\{priorVersion}", apiClient.escapeString(priorVersion));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<ConceptRef>> localVarReturnType = new GenericType<List<ConceptRef>>() {};
    return apiClient.invokeAPI("HistoryApi.getTerminologyHistoryNewConcepts", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get terminology concepts retired since prior version
   * Gets concept code/name/semanticType for concepts retired in the terminology since the specified prior version
   * @param id Terminology id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior terminology version, e.g. \&quot;20240101\&quot; (required)
   * @return List&lt;ConceptRef&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> List of concept code/name that are now retired </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public List<ConceptRef> getTerminologyHistoryRetiredConcepts(String id, String priorVersion) throws ApiException {
    return getTerminologyHistoryRetiredConceptsWithHttpInfo(id, priorVersion).getData();
  }

  /**
   * Get terminology concepts retired since prior version
   * Gets concept code/name/semanticType for concepts retired in the terminology since the specified prior version
   * @param id Terminology id, e.g. \&quot;uuid\&quot; (required)
   * @param priorVersion Prior terminology version, e.g. \&quot;20240101\&quot; (required)
   * @return ApiResponse&lt;List&lt;ConceptRef&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> List of concept code/name that are now retired </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ConceptRef>> getTerminologyHistoryRetiredConceptsWithHttpInfo(String id, String priorVersion) throws ApiException {
    // Check required parameters
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getTerminologyHistoryRetiredConcepts");
    }
    if (priorVersion == null) {
      throw new ApiException(400, "Missing the required parameter 'priorVersion' when calling getTerminologyHistoryRetiredConcepts");
    }

    // Path parameters
    String localVarPath = "/terminology/{id}/history/{priorVersion}/concepts/retired"
            .replaceAll("\\{id}", apiClient.escapeString(id))
            .replaceAll("\\{priorVersion}", apiClient.escapeString(priorVersion));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<ConceptRef>> localVarReturnType = new GenericType<List<ConceptRef>>() {};
    return apiClient.invokeAPI("HistoryApi.getTerminologyHistoryRetiredConcepts", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
