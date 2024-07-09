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


class TestGetSpecificTerminology:
    """
    Test case to get a specific terminology. Make sure you have your authorization token by running test_login.py
    """
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)
    
    # Test getting a terminology from a term id. NOTE: MAKE SURE TO UPDATE YOUR AUTH TOKE BY RUNNING `test_login.py`
    def test_get_specific_terminology(self, load_config):
        """
        Test the get specific terminology endpoint in the sandbox project. This will call the termhub api and return
        the results
        """
        # SETUP
        # Define the URL, token, and id
        url: str = load_config.get("default", "url")
        token: str = os.getenv("TOKEN")
        term_id: str = "a2bc43ec-ba1b-47c0-9ff0-8379a02f8136"
        
        # ACT & ASSERT
        # Send a GET request to the URL
        self.logger.info(f"  Performing terminology lookup for {term_id}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {token}"}
        response: Response = requests.get(f"{url}/terminology/{term_id}", headers=headers)
        
        # Check the status code of the response
        assert response.status_code == 200, f"ERROR: GET call returned {response.status_code}, expected 200"
        
        # Check if the response is not None
        assert response is not None, "ERROR: Response is None"
        
        # print the response
        self.logger.info(f"Terminology results for {term_id}: {json.dumps(response.json(), indent=2)}")
