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


class TestGetConceptWithIncludeParam:
    """
    Test case to get a concept by code with the include parameter. Make sure you have your authorization token by
    running test_login.py
    """
    
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)
    
    def test_get_concept_by_code_with_include_param(self, load_config):
        """
        Test the get concept by code endpoint with SNOMEDCT terminology and a code for diabetes in the sandbox
        project and an include parameter passed. This will call the termhub api and return the results
        """
        # SETUP
        api_url: str = load_config.get("default", "url")
        token: str = os.getenv("TOKEN")
        terminology: str = "SNOMEDCT"
        code: str = "73211009"
        project_id: str = "sandbox"
        params: dict[str, str] = {"inclue": "full"}
        
        # ACT
        self.logger.info(f"  Getting concept for {code} with full include...")
        headers: dict[str, str] = {"Authorization": f"Bearer {token}"}
        response: Response = requests.get(f"{api_url}/project/{project_id}/concept/{terminology}/{code}",
                                          headers=headers, params=params)
        
        # ASSERT
        assert response.status_code == 200, f"ERROR: GET call returned {response.status_code}, expected 200"
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(f"Concept with include set to full: {json.dumps(response.json(), indent=2)}")
