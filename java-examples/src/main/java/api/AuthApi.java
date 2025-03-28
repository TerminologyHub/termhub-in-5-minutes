package api;

import api.invoker.ApiException;
import api.invoker.ApiClient;
import api.invoker.ApiResponse;
import api.invoker.Configuration;
import api.invoker.Pair;

import jakarta.ws.rs.core.GenericType;

import api.model.AuthResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-28T13:45:03.072174-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class AuthApi {
  private ApiClient apiClient;

  public AuthApi() {
    this(Configuration.getDefaultApiClient());
  }

  public AuthApi(ApiClient apiClient) {
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
   * Authorize user
   * Used to log into the platform and obtain an access token for future API calls.
   * @param grantType  (required)
   * @param username  (required)
   * @param password  (required)
   * @return AuthResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Successful authorization, payload contains access_token </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public AuthResponse auth(String grantType, String username, String password) throws ApiException {
    return authWithHttpInfo(grantType, username, password).getData();
  }

  /**
   * Authorize user
   * Used to log into the platform and obtain an access token for future API calls.
   * @param grantType  (required)
   * @param username  (required)
   * @param password  (required)
   * @return ApiResponse&lt;AuthResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Successful authorization, payload contains access_token </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 417 </td><td> Expectation failed </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<AuthResponse> authWithHttpInfo(String grantType, String username, String password) throws ApiException {
    // Check required parameters
    if (grantType == null) {
      throw new ApiException(400, "Missing the required parameter 'grantType' when calling auth");
    }
    if (username == null) {
      throw new ApiException(400, "Missing the required parameter 'username' when calling auth");
    }
    if (password == null) {
      throw new ApiException(400, "Missing the required parameter 'password' when calling auth");
    }

    // Form parameters
    Map<String, Object> localVarFormParams = new LinkedHashMap<>();
    localVarFormParams.put("grant_type", grantType);
    localVarFormParams.put("username", username);
    localVarFormParams.put("password", password);

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/x-www-form-urlencoded", "application/json");
    GenericType<AuthResponse> localVarReturnType = new GenericType<AuthResponse>() {};
    return apiClient.invokeAPI("AuthApi.auth", "/auth/token", "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               null, localVarReturnType, false);
  }
}
