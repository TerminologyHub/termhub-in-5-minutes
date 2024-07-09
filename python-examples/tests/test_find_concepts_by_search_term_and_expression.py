import configparser
import json
import logging
import os
import requests
import pytest
from requests import Response


@pytest.fixture(scope="module")
def load_config():
    """
    Load configuration settings
    """
    # Create a ConfigParser object & read the file
    config = configparser.ConfigParser()
    config.read("config.ini")
    return config


class TestFindConceptBySearchTermAndExpression:
    """
    Test case to find a concept by search term and expression. Make sure you have your authorization token by running
    test_login.py
    """
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)
    
    def test_get_concept_from_query_and_expression(self, load_config):
        """
        Test the find concept by search term and expression endpoint with SNOMEDCT terminology, a query for diabetes,
        and an expression for diabetes mellitus in the sandbox project. This will call the termhub api and return the
        results of the search
        """
        # SETUP
        api_url: str = load_config.get("default", "url")
        token: str = os.getenv("TOKEN")
        term: str = "SNOMEDCT"
        query: str = "diabetes"
        expression: str = "<<64572001"
        project_id: str = "sandbox"
        params: dict[str, int | str] = {
            "terminology": term,
            "query": query,
            "expression": expression,
            "offset": 0,
            "limit": 10,
        }
        
        # ACT
        self.logger.info(f"  Getting {term} concept for {query} and {expression}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {token}"}
        response: Response = requests.get(f"{api_url}/project/{project_id}/concept",
                                          headers=headers, params=params)
        
        # ASSERT
        assert response.status_code == 200, f"ERROR: GET call returned {response.status_code}, expected 200"
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(f"Concept from search for {query} & {expression}: {json.dumps(response.json(), indent=2)}")
