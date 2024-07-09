import configparser
import json
import logging
import os
import requests
from requests import Response
import pytest


@pytest.fixture(scope="module")
def load_config():
    """
    Load configuration settings
    """
    # Create a ConfigParser object & read the file
    config = configparser.ConfigParser()
    config.read("config.ini")
    return config


# Test GET Terminologies returns all terminologies
class TestGetTerminologies:
    """
    Test case to get all terminologies. Make sure you have your authorization token by running test_login.py
    """
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)
    
    def test_get_terminologies(self, load_config):
        """
        Test the get terminology endpoint with no project and params using default settings. This will call the
        termhub api and return the results
        """
        # SETUP
        # Define the URL, token, and id
        url: str = load_config.get("default", "url")
        token: str = os.getenv("TOKEN")
        
        # ACT & ASSERT
        # Send a GET request to the url
        self.logger.info("  Performing terminologies lookup...")
        headers: dict[str, str] = {"Authorization": f"Bearer {token}"}
        response: Response = requests.get(f"{url}/terminology", headers=headers)
        
        # Check the status code of the response
        assert response.status_code == 200, f"ERROR: GET call returned {response.status_code}, expected 200"
        
        # Extract the response
        assert response is not None, "ERROR: Response is None"
        assert response.json().get('total') >= 69
        
        self.logger.info(f"Terminologies: {json.dumps(response.json(), indent=2)}")
