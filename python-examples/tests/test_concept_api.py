import configparser
import json
import logging
import os
import requests
import pytest
from requests import Response

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
    
    def test_get_concept_by_search_term(self, concept_api):
        """
        Test the find concept by search term endpoint with SNOMEDCT terminology, a query for diabetes, in the sandbox
        project. This will call the termhub api and return the results of the search
        """
        # SETUP
        token: str = os.getenv("TOKEN")
        term: str = "SNOMEDCT"
        query: str = "diabetes"
        project_id: str = "sandbox"
        limit: int = 5
        
        # ACT
        self.logger.info(f"  Getting {term} concept for {query}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {token}"}
        response: ResultListConcept = concept_api.find_concepts(project_id, term, query, None, None, limit, None, None,
                                                                None,None, None, _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(f"Concept from search for {query}: {response}")
    
    def test_get_concept_from_query_and_expression(self, concept_api):
        """
        Test the find concept by search term and expression endpoint with SNOMEDCT terminology, a query for diabetes,
        and an expression for diabetes mellitus in the sandbox project. This will call the termhub api and return the
        results of the search
        """
        # SETUP
        token: str = os.getenv("TOKEN")
        term: str = "SNOMEDCT"
        query: str = "diabetes"
        expression: str = "<<64572001"
        project_id: str = "sandbox"
        offset: int = 0
        limit: int = 10
        
        # ACT
        self.logger.info(f"  Getting {term} concept for {query} and {expression}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {token}"}
        response: ResultListConcept = concept_api.find_concepts(project_id, term, query, expression, offset, limit,
                                                                None, None, None, None, None, _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(f"Concept from search for {query}: {response}")
    
    def test_get_concept_by_query_and_include_param(self, concept_api):
        """
        Test the find concept by search term endpoint with SNOMEDCT terminology, a query for diabetes,
        and the include parameter set to parents in the sandbox project. This will call the termhub api and return
        the results
        """
        # SETUP
        token: str = os.getenv("TOKEN")
        term: str = "SNOMEDCT"
        query: str = "diabetes"
        project_id: str = "sandbox"
        limit: int = 5
        include: str = "parents"
    
        # ACT
        self.logger.info(f"  Getting {term} concept for {query} with include params...")
        headers: dict[str, str] = {"Authorization": f"Bearer {token}"}
        response: ResultListConcept = concept_api.find_concepts(project_id, term, query, None, None, limit,
                                                                None, None, None, None, include, _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(
            f"Concept from search for {query} with parents included: ")
    
    def test_find_terms_by_search_term(self, concept_api):
        """
        Test the find term by search term endpoint with SNOMEDCT terminology and a query for diabetes in the sandbox
        project. This will call the termhub api and return the results
        """
        # SETUP
        token: str = os.getenv("TOKEN")
        term: str = "SNOMEDCT"
        query: str = "diabetes"
        project_id: str = "sandbox"
        limit: int = 5
        
        # ACT
        self.logger.info(f"  Finding {term} term for {query}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {token}"}
        
        
        # ASSERT
        
        self.logger.info(f"Found term from search for {query}: ")
