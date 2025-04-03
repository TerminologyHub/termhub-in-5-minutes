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
import api.model.Concept;
import api.model.Mapping;
import api.model.ResultListConceptRelationship;
import api.model.ResultListConceptTreePosition;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ConceptByIdApi
 */
public class ConceptByIdApiTest {

    private final ConceptByIdApi api = new ConceptByIdApi();

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
     * Find concept inverse relationships
     *
     * Finds concept inverse relationships for the specified concept id.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void findConceptInverseRelationships1Test() throws ApiException {
        //String idOrUriLabel = null;
        //String conceptId = null;
        //String query = null;
        //Integer offset = null;
        //Integer limit = null;
        //Boolean ascending = null;
        //String sort = null;
        //ResultListConceptRelationship response = api.findConceptInverseRelationships1(idOrUriLabel, conceptId, query, offset, limit, ascending, sort);
        // TODO: test validations
    }

    /**
     * Find concept relationships
     *
     * Finds concept relationships for the specified concept id.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void findConceptRelationships1Test() throws ApiException {
        //String idOrUriLabel = null;
        //String conceptId = null;
        //String query = null;
        //Integer offset = null;
        //Integer limit = null;
        //Boolean ascending = null;
        //String sort = null;
        //ResultListConceptRelationship response = api.findConceptRelationships1(idOrUriLabel, conceptId, query, offset, limit, ascending, sort);
        // TODO: test validations
    }

    /**
     * Find concept tree position children
     *
     * Finds concept tree position children for the specified concept id.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void findTreePositionChildren1Test() throws ApiException {
        //String idOrUriLabel = null;
        //String conceptId = null;
        //String query = null;
        //Integer offset = null;
        //Integer limit = null;
        //Boolean ascending = null;
        //String sort = null;
        //ResultListConceptTreePosition response = api.findTreePositionChildren1(idOrUriLabel, conceptId, query, offset, limit, ascending, sort);
        // TODO: test validations
    }

    /**
     * Find concept tree positions
     *
     * Finds concept tree positions for the specified concept id.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void findTreePositions1Test() throws ApiException {
        //String idOrUriLabel = null;
        //String conceptId = null;
        //String query = null;
        //Integer offset = null;
        //Integer limit = null;
        //Boolean ascending = null;
        //String sort = null;
        //ResultListConceptTreePosition response = api.findTreePositions1(idOrUriLabel, conceptId, query, offset, limit, ascending, sort);
        // TODO: test validations
    }

    /**
     * Get concept by id
     *
     * Gets concept for the specified id
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getConcept1Test() throws ApiException {
        //String idOrUriLabel = null;
        //String conceptId = null;
        //String include = null;
        //Concept response = api.getConcept1(idOrUriLabel, conceptId, include);
        // TODO: test validations
    }

    /**
     * Get concept diagram
     *
     * Gets concept diagram for the specified concept.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getConceptDiagram1Test() throws ApiException {
        //String idOrUriLabel = null;
        //String conceptId = null;
        //api.getConceptDiagram1(idOrUriLabel, conceptId);
        // TODO: test validations
    }

    /**
     * Get mappings to concept by id
     *
     * Gets mappings to the specified concept
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getConceptInverseMappings1Test() throws ApiException {
        //String idOrUriLabel = null;
        //String conceptId = null;
        //List<Mapping> response = api.getConceptInverseMappings1(idOrUriLabel, conceptId);
        // TODO: test validations
    }

    /**
     * Get mappings from concept by id
     *
     * Gets mappings from the specified concept
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getConceptMappings1Test() throws ApiException {
        //String idOrUriLabel = null;
        //String conceptId = null;
        //List<Mapping> response = api.getConceptMappings1(idOrUriLabel, conceptId);
        // TODO: test validations
    }

}
