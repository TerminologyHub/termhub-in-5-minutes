import json
import requests
import os
import configparser
import logging

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


class TestGetConceptTrees:
    """
    Test case to get a concept's trees by code. Make sure you have your authorization token by running test_login.py
    """
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)
    
    def test_get_concept_trees(self, load_config):
        """
        Test the get concept trees by code endpoint with SNOMEDCT terminology and a code for diabetes in the sandbox
        project. This will call the termhub api and return the results
        """
        # SETUP
        api_url: str = load_config.get("default", "url")
        token: str = os.getenv("TOKEN")
        terminology: str = "SNOMEDCT"
        code: str = "73211009"
        project_id: str = "sandbox"
        
        # ACT
        self.logger.info(f"  Getting {terminology} concept trees for {code}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {token}"}
        response: Response = requests.get(f"{api_url}/project/{project_id}/concept/{terminology}/{code}/trees",
                                   headers=headers)
        
        # ASSERT
        assert response.status_code == 200, f"ERROR: GET call returned {response.status_code}, expected 200"
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(f"Concepts Trees: {json.dumps(response.json(), indent=2)}")
