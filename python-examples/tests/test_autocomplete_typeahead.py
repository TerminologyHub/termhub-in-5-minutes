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


class TestAutocompletedTypeahead:
    """
    Class to tests the autocomplete endpoint. Make sure you have your authorization token by running test_login.py
    """
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)
    
    def test_autocomplete_and_typeahead(self, load_config):
        """
        Test the autocomplete endpoint with SNOMEDCT terminology, a query for diabetes but partially typed, in the
        sandbox project. This will call the termhub api and return the results of the search
        """
        # SETUP
        api_url: str = load_config.get("default", "url")
        token: str = os.getenv("TOKEN")
        terminology: str = "SNOMEDCT"
        query: str = "diab"
        project_id: str = "sandbox"
        params: dict[str, int | str] = {
            "terminology": terminology,
            "query": query,
            "limit": 10,
        }
        
        # ACT
        self.logger.info(f"  Submitting autocomplete search...")
        headers: dict[str, str] = {"Authorization": f"Bearer {token}"}
        response: Response = requests.get(f"{api_url}/project/{project_id}/autocomplete",
                                          headers=headers, params=params)
        # ASSERT
        assert response.status_code == 200, f"ERROR: GET call returned {response.status_code}, expected 200"
        assert response is not None, "ERROR: Response is None"
        self.logger.info(f"Autocomplete Results: {json.dumps(response.json(), indent=2)}")
