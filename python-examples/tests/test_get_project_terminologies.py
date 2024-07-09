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


class TestGetProjectTerminologies:
    """
    Test case to get project terminologies. Make sure you have your authorization token by running test_login.py
    """
    
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)
    
    def test_get_project_terminologies(self, load_config):
        """
        Test the get project terminologies endpoint in the sandbox project. This will call the termhub api and return
        the results of the call
        """
        # SETUP
        # Define the URL, token, and id
        api_url: str = load_config.get("default", "url")
        token: str = os.getenv("TOKEN")
        project_id: str = "sandbox"
        
        # ACT & ASSERT
        # Send a GET request to the url
        self.logger.info("  Performing project terminologies lookup...")
        headers: dict[str, str] = {"Authorization": f"Bearer {token}"}
        response: Response = requests.get(f"{api_url}/project/{project_id}/terminology", headers=headers)
        
        # Check the status code of the response
        assert response.status_code == 200, f"ERROR: GET call returned {response.status_code}, expected 200"
        
        # Extract the response
        assert response is not None, "ERROR: Response is None"
        response_json = response.json()
        
        self.logger.info(f"Project Terminologies: {json.dumps(response_json, indent=2)}")
