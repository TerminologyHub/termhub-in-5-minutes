import json
import unittest
import requests
import os
import configparser
from datetime import datetime
import logging


class TestGetSpecificTerminology(unittest.TestCase):
    """
    Test case to get a specific terminology. Make sure you have your authorization token by running test_login.py
    """
    # Create a ConfigParser object & read the file
    config = configparser.ConfigParser()
    config.read("../config.ini")

    # Create a logger
    logger = logging.getLogger(__name__)
    logger.setLevel(logging.INFO)
    logging.basicConfig(level=logging.INFO)

    # Test getting a terminology from a term id. NOTE: MAKE SURE TO UPDATE YOUR AUTH TOKE BY RUNNING `test_login.py`
    def test_get_specific_terminology(self):
        """
        Test the get specific terminology endpoint in the sandbox project. This will call the termhub api and return
        the results
        """
        # SETUP
        # Define the URL, token, and id
        url = self.config.get("default", "url")
        token = os.getenv("TOKEN")
        term_id = "a2bc43ec-ba1b-47c0-9ff0-8379a02f8136"

        # ACT & ASSERT
        # Send a GET request to the URL
        self.logger.info(f"  Performing terminology lookup for {term_id}...")
        headers = {"Authorization": f"Bearer {token}"}
        response = requests.get(f"{url}/terminology/{term_id}", headers=headers)

        # Check the status code of the response
        self.assertEqual(response.status_code, 200,
                         f"ERROR: GET call returned {response.status_code}, expected 200")

        # Check if the response is not None
        self.assertIsNotNone(response, "ERROR: Response is None")

        # print the response
        self.logger.info(f"Terminology results for {term_id}: " + json.dumps(response.json(), indent=2))


if __name__ == '__main__':
    unittest.main()