package api;

import api.invoker.ApiException;
import api.invoker.ApiClient;
import api.invoker.ApiResponse;
import api.invoker.Configuration;
import api.invoker.Pair;

import jakarta.ws.rs.core.GenericType;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-05-14T14:37:22.308097300-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class SyndicationApi {
  private ApiClient apiClient;

  public SyndicationApi() {
    this(Configuration.getDefaultApiClient());
  }

  public SyndicationApi(ApiClient apiClient) {
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
   * Syndication feed XML file
   * Syndication feed XML.
   * @param idOrUriLabel Project id or uriLabel if not specified by a project api key, e.g. \&quot;sandbox\&quot; (optional)
   * @param style Syndication style - empty defaults to &#39;default&#39; or ontoserver (optional)
   * @param jsonOnly If true, adds jsonOnly&#x3D;true parameter to FHIR R4 and R5 format links in the syndication feed (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Syndication feed XML </td><td>  -  </td></tr>
     </table>
   */
  public void getSyndication(String idOrUriLabel, String style, Boolean jsonOnly) throws ApiException {
    getSyndicationWithHttpInfo(idOrUriLabel, style, jsonOnly);
  }

  /**
   * Syndication feed XML file
   * Syndication feed XML.
   * @param idOrUriLabel Project id or uriLabel if not specified by a project api key, e.g. \&quot;sandbox\&quot; (optional)
   * @param style Syndication style - empty defaults to &#39;default&#39; or ontoserver (optional)
   * @param jsonOnly If true, adds jsonOnly&#x3D;true parameter to FHIR R4 and R5 format links in the syndication feed (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> Syndication feed XML </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> getSyndicationWithHttpInfo(String idOrUriLabel, String style, Boolean jsonOnly) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "idOrUriLabel", idOrUriLabel)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "style", style));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "jsonOnly", jsonOnly));

    String localVarAccept = apiClient.selectHeaderAccept("application/xml");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    return apiClient.invokeAPI("SyndicationApi.getSyndication", "/terminology/syndication/feed", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
