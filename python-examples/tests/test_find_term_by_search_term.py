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


class TestFindTermBySearchTerm:
    """
    Test case to find a term by search term. Make sure you have your authorization token by running test_login.py
    """
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)
    
    def test_find_terms_by_search_term(self, load_config):
        """
        Test the find term by search term endpoint with SNOMEDCT terminology and a query for diabetes in the sandbox
        project. This will call the termhub api and return the results
        """
        # SETUP
        api_url: str = load_config.get("default", "url")
        token: str = os.getenv("TOKEN")
        term: str = "SNOMEDCT"
        query: str = "diabetes"
        project_id: str = "sandbox"
        params: dict[str, int | str] = {
            "terminology": term,
            "query": query,
            "limit": 5,
        }
        
        # ACT
        self.logger.info(f"  Finding {term} term for {query}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {token}"}
        response: Response = requests.get(f"{api_url}/project/{project_id}/term",
                                          headers=headers, params=params)
        
        # ASSERT
        assert response.status_code == 200, f"ERROR: GET call returned {response.status_code}, expected 200"
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(f"Found term from search for {query} : {json.dumps(response.json(), indent=2)}")
