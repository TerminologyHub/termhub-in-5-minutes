import logging
import os
import pytest
from termhub import ConceptApi, ResultListConcept


@pytest.fixture(scope="module")
def concept_api():
    """
    Fixture to return a ConceptApi object
    """
    return ConceptApi()


class TestConceptApi:
    """
    Class to tests the find concept by search term endpoint. Make sure you have your authorization token by running
    test_login.py
    """
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)
    
    term: str = "SNOMEDCT"
    query: str = "diabetes"
    project_id: str = "sandbox"
    token: str = os.getenv("TOKEN")
    
    def test_get_concept_by_search_term(self, concept_api):
        """
        Test the find concept by search term endpoint with SNOMEDCT terminology, a query for diabetes, in the sandbox
        project. This will call the termhub api and return the results of the search
        """
        # SETUP - Using global vars unless otherwise listed below
        limit: int = 5
        
        # ACT
        self.logger.info(f"  Getting {self.term} concept for {self.query}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}"}
        response: ResultListConcept = concept_api.find_concepts(self.project_id, self.term, self.query, None, None,
                                                                limit,
                                                                None, None,
                                                                None, None, None, _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(f"Concept from search for {self.query}: {response}")
    
    def test_get_concept_from_query_and_expression(self, concept_api):
        """
        Test the find concept by search term and expression endpoint with SNOMEDCT terminology, a query for diabetes,
        and an expression for diabetes mellitus in the sandbox project. This will call the termhub api and return the
        results of the search
        """
        # SETUP - Using global vars unless otherwise listed below
        token: str = os.getenv("TOKEN")
        expression: str = "<<64572001"
        offset: int = 0
        limit: int = 10
        
        # ACT
        self.logger.info(f"  Getting {self.term} concept for {self.query} and {expression}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {token}"}
        response: ResultListConcept = concept_api.find_concepts(self.project_id, self.term, self.query, expression,
                                                                offset, limit, None, None, None, None, None,
                                                                _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(f"Concept from search for {self.query}: {response}")
    
    def test_get_concept_by_term_and_include_param(self, concept_api):
        """
        Test the find concept by search term endpoint with SNOMEDCT terminology, a query for diabetes,
        and the include parameter set to parents in the sandbox project. This will call the termhub api and return
        the results
        """
        # SETUP - Using global vars unless otherwise listed below
        limit: int = 5
        include: str = "parents"
        
        # ACT
        self.logger.info(f"  Getting {self.term} concept for {self.query} with include params...")
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}"}
        response: ResultListConcept = concept_api.find_concepts(self.project_id, self.term, self.query, None, None,
                                                                limit, None, None, None, None, include,
                                                                _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(
            f"Concept from search for {self.query} with parents included: ")
