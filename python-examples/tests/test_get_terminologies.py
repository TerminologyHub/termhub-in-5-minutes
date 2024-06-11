import configparser
import json
import logging
import os
import unittest
from datetime import datetime

import requests


# Test GET Terminologies returns all terminologies
class TestGetTerminologies(unittest.TestCase):
    # Create a ConfigParser object & read the file
    config = configparser.ConfigParser()
    config.read("../config.ini")

    # Create a logger
    logger = logging.getLogger(__name__)
    logger.setLevel(logging.INFO)
    logging.basicConfig(level=logging.INFO)

    def test_get_terminologies(self):
        # SETUP
        # Define the URL, token, and id
        url = self.config.get("default", "url")
        token = os.getenv("TOKEN")
        limit = 10
        offset = 0
        ascending = False
        sort = None
        # Set up the params
        params = {
            "limit": limit,
            "offset": offset,
            "ascending": ascending,
            "sort": sort
        }

        # ACT & ASSERT
        # Send a GET request to the url
        self.logger.info("  Performing terminologies lookup...")
        headers = {"Authorization": f"Bearer {token}"}
        response = requests.get(f"{url}/terminology", headers=headers, params=params)

        # Check the status code of the response
        self.assertEqual(response.status_code, 200,
                         f"ERROR: GET call returned {response.status_code}, expected 200")

        # Extract the response
        self.assertIsNotNone(response, "ERROR: Response is None")
        self.assertEqual(69, response.json().get('total'))

        self.logger.info("Terminologies: " + json.dumps(response.json(), indent=2))


if __name__ == '__main__':
    unittest.main()
