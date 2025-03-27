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
import api.model.ResultListConcept;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ConceptApi
 */
public class ConceptApiTest {

    private final ConceptApi api = new ConceptApi();

    /**
     * Export concept search across all project terminologies
     *
     * Export concept search matching specified search criteria.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void exportConceptsTest() throws ApiException {
        //String idOrUriLabel = null;
        //String terminology = null;
        //String query = null;
        //String expression = null;
        //String sort = null;
        //Boolean ascending = null;
        //Boolean active = null;
        //Boolean leaf = null;
        //String response = api.exportConcepts(idOrUriLabel, terminology, query, expression, sort, ascending, active, leaf);
        // TODO: test validations
    }

    /**
     * Export bulk find of concepts across specified project terminologies
     *
     * Export bulk find of concepts matching specified search criteria.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void exportLookupTest() throws ApiException {
        //String idOrUriLabel = null;
        //String body = null;
        //String terminology = null;
        //String expression = null;
        //Integer limit = null;
        //Boolean active = null;
        //Boolean leaf = null;
        //String response = api.exportLookup(idOrUriLabel, body, terminology, expression, limit, active, leaf);
        // TODO: test validations
    }

    /**
     * Find concepts across project terminologies
     *
     * Finds concepts matching specified search criteria.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void findConceptsTest() throws ApiException {
        //String idOrUriLabel = null;
        //String terminology = null;
        //String query = null;
        //String expression = null;
        //Integer offset = null;
        //Integer limit = null;
        //String sort = null;
        //Boolean ascending = null;
        //Boolean active = null;
        //Boolean leaf = null;
        //String include = null;
        //ResultListConcept response = api.findConcepts(idOrUriLabel, terminology, query, expression, offset, limit, sort, ascending, active, leaf, include);
        // TODO: test validations
    }

    /**
     * Bulk find of concepts across specified project terminologies
     *
     * Bulk find of concepts matching specified search criteria.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void lookupTest() throws ApiException {
        //String idOrUriLabel = null;
        //String body = null;
        //String terminology = null;
        //String expression = null;
        //Integer limit = null;
        //Boolean active = null;
        //Boolean leaf = null;
        //String include = null;
        //List<ResultListConcept> response = api.lookup(idOrUriLabel, body, terminology, expression, limit, active, leaf, include);
        // TODO: test validations
    }

}
