import configparser
import json
import logging
import os
import unittest

import requests


class TestGetProjectTerminologies(unittest.TestCase):
    """
    Test case to get project terminologies. Make sure you have your authorization token by running test_login.py
    """
    # Create a ConfigParser object & read the file
    config = configparser.ConfigParser()
    config.read("../config.ini")
    
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)

    def test_get_project_terminologies(self):
        """
        Test the get project terminologies endpoint in the sandbox project. This will call the termhub api and return
        the results of the call
        """
        # SETUP
        # Define the URL, token, and id
        api_url = self.config.get("default", "url")
        token = os.getenv("TOKEN")
        project_id = "sandbox"


        # ACT & ASSERT
        # Send a GET request to the url
        self.logger.info("  Performing project terminologies lookup...")
        headers = {"Authorization": f"Bearer {token}"}
        response = requests.get(f"{api_url}/project/{project_id}/terminology", headers=headers)

        # Check the status code of the response
        self.assertEqual(response.status_code, 200,
                         f"ERROR: GET call returned {response.status_code}, expected 200")

        # Extract the response
        self.assertIsNotNone(response, "ERROR: Response is None")
        response_json = response.json()

        self.logger.info("Project Terminologies: " + json.dumps( response_json, indent=2))


if __name__ == '__main__':
    unittest.main()
