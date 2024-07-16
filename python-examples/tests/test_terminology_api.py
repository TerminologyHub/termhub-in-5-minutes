import configparser
import json
import logging
import os
import requests
from requests import Response
import pytest

from termhub import TerminologyApi


@pytest.fixture(scope="module")
def terminology_api():
    """
    Fixture to return a TerminologyApi object
    """
    return TerminologyApi()


# Test GET Terminologies returns all terminologies
class TestTerminologyApi:
    """
    Test case to get all terminologies. Make sure you have your authorization token by running test_login.py
    """
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)
    
    def test_get_terminologies(self, terminology_api):
        """
        Test the get terminology endpoint with no project and params using default settings. This will call the
        termhub api and return the results
        """
        # SETUP
        # Define the URL, token, and id
        url: str = terminology_api.get("default", "url")
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
    
    # Test getting a terminology from a term id. NOTE: MAKE SURE TO UPDATE YOUR AUTH TOKE BY RUNNING `test_login.py`
    def test_get_specific_terminology(self, terminology_api):
        """
        Test the get specific terminology endpoint in the sandbox project. This will call the termhub api and return
        the results
        """
        # SETUP
        # Define the URL, token, and id
        url: str = terminology_api.get("default", "url")
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
    
    def test_get_project_terminologies(self, terminology_api):
        """
        Test the get project terminologies endpoint in the sandbox project. This will call the termhub api and return
        the results of the call
        """
        # SETUP
        # Define the URL, token, and id
        api_url: str = terminology_api.get("default", "url")
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
    
    def test_export_terminologies(self, terminology_api):
        """
        Test the export terminologies endpoint with SNOMEDCT terminology in the sandbox project. This will call the
        termhub api and return a HTTP code.
        """
        # SETUP
        
        token: str = os.getenv("TOKEN")
        terminology: str = "SNOMEDCT"
        project_id: str = "sandbox"
        params: dict[str, str] = {"format": "native"}
        
        # ACT
        self.logger.info(f"  Exporting terminology {terminology}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {token}"}
        response: str = terminology_api.export_terminology(project_id, terminology, None, None, None, None,
                                                           None, None, _headers=headers)
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        self.logger.info("Export completed successfully!")
