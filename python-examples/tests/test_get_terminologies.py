import configparser
import json
import logging
import os
import unittest
from datetime import datetime

import requests


# Test GET Terminologies returns all terminologies
class TestGetTerminologies(unittest.TestCase):
    """
    Test case to get all terminologies. Make sure you have your authorization token by running test_login.py
    """
    # Create a ConfigParser object & read the file
    config = configparser.ConfigParser()
    config.read("../config.ini")
    
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)

    def test_get_terminologies(self):
        """
        Test the get terminology endpoint with no project and params using default settings. This will call the
        termhub api and return the results
        """
        # SETUP
        # Define the URL, token, and id
        url = self.config.get("default", "url")
        token = os.getenv("TOKEN")


        # ACT & ASSERT
        # Send a GET request to the url
        self.logger.info("  Performing terminologies lookup...")
        headers = {"Authorization": f"Bearer {token}"}
        response = requests.get(f"{url}/terminology", headers=headers)

        # Check the status code of the response
        self.assertEqual(response.status_code, 200,
                         f"ERROR: GET call returned {response.status_code}, expected 200")

        # Extract the response
        self.assertIsNotNone(response, "ERROR: Response is None")
        self.assertTrue(response.json().get('total') >= 69)

        self.logger.info("Terminologies: " + json.dumps(response.json(), indent=2))


if __name__ == '__main__':
    unittest.main()
