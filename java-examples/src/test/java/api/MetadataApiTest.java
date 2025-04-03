/*
 * Terminology Hub Terminology Terminology API
 * API documentation for the interacting with terminologies and concepts. <p>For a guided tour of using this API, see our github project <a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes\">https://github.com/terminologyhub/termhub-in-5-minutes</a></p>
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: info@terminologyhub.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package api;

import api.invoker.*;
import api.invoker.auth.*;
import api.model.Metadata;
import api.model.ResultListMetadata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for MetadataApi
 */
public class MetadataApiTest {

    private final MetadataApi api = new MetadataApi();

    @BeforeEach
    public void setUp() {
        // Set up the API client with authentication
        String grantType = "username_password";
        String username = System.getProperty("username");
        String password = System.getProperty("password");
        String accessToken = null;
        try {
            AuthResponse response = new AuthApi().auth(grantType, username, password);
            accessToken = response.getAccessToken();
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("Failed to authenticate: " + e.getMessage());
        }
        api.getApiClient().setAccessToken(accessToken);
    }

    /**
     * Find project terminology metadata
     *
     * Find metadata for the terminologies of the specified project id or uri
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void findMetadataTest() throws ApiException {
        //String idOrUriLabel = null;
        //String query = null;
        //Integer offset = null;
        //Integer limit = null;
        //String sort = null;
        //Boolean ascending = null;
        //ResultListMetadata response = api.findMetadata(idOrUriLabel, query, offset, limit, sort, ascending);
        // TODO: test validations
    }

    /**
     * Get terminology metadata
     *
     * Gets terminology metadata for the specified terminology id
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getTerminologyMetadataTest() throws ApiException {
        //String id = null;
        //List<Metadata> response = api.getTerminologyMetadata(id);
        // TODO: test validations
    }

}
