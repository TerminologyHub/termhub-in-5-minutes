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
import api.model.ResultListTerminology;
import api.model.Terminology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TerminologyApi
 */
public class TerminologyApiTest {

    private final TerminologyApi api = new TerminologyApi();

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
     * Export terminology
     *
     * Exports specified terminology in the specified format.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void exportTerminologyTest() throws ApiException {
        //String idOrUriLabel = null;
        //String terminology = null;
        //String format = null;
        //byte[] response = api.exportTerminology(idOrUriLabel, terminology, format);
        // TODO: test validations
    }

    /**
     * Find terminologies
     *
     * Finds terminologies matching specified criteria.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void findTerminologiesTest() throws ApiException {
        //String query = null;
        //Integer offset = null;
        //Integer limit = null;
        //String sort = null;
        //Boolean ascending = null;
        //ResultListTerminology response = api.findTerminologies(query, offset, limit, sort, ascending);
        // TODO: test validations
    }

    /**
     * Get project terminologies
     *
     * Gets terminology objects used by the specified project.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getProjectTerminologiesTest() throws ApiException {
        //String idOrUriLabel = null;
        //List<Terminology> response = api.getProjectTerminologies(idOrUriLabel);
        // TODO: test validations
    }

    /**
     * Get terminology by id
     *
     * Gets terminology for the specified id
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getTerminologyTest() throws ApiException {
        //String id = null;
        //Terminology response = api.getTerminology(id);
        // TODO: test validations
    }

}
