import configparser
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


class TestExportTerminologies:
    """
    Class to tests the export terminologies endpoint. Make sure you have your authorization token by running test_login.py
    """
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)
    
    def test_export_terminologies(self, load_config):
        """
        Test the export terminologies endpoint with SNOMEDCT terminology in the sandbox project. This will call the
        termhub api and return a HTTP code.
        """
        # SETUP
        api_url: str = load_config.get("default", "url")
        token: str = os.getenv("TOKEN")
        terminology: str = "SNOMEDCT"
        project_id: str = "sandbox"
        params: dict[str, str] = {"format": "native"}
        
        # ACT
        self.logger.info(f"  Exporting terminology {terminology}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {token}"}
        response: Response = requests.get(f"{api_url}/project/{project_id}/terminology/{terminology}/export",
                                          headers=headers, params=params)
        # ASSERT
        assert response.status_code == 200, f"ERROR: GET call returned {response.status_code}, expected 200"
        assert response is not None, "ERROR: Response is None"
        self.logger.info("Export completed successfully!")
