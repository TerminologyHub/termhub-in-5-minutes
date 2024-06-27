import configparser
import json
import logging
import os
import unittest

import requests


class TestGetConceptByCode(unittest.TestCase):
    """
    Test case to get a concept by code. Make sure you have your authorization token by running test_login.py
    """
    # Create a ConfigParser object & read the file
    config = configparser.ConfigParser()
    config.read("../config.ini")

    # Create a logger
    logger = logging.getLogger(__name__)
    logger.setLevel(logging.INFO)
    logging.basicConfig(level=logging.INFO)

    def test_get_concept_by_code(self):
        """
        Test the get concept by code endpoint with SNOMEDCT terminology and a code for diabetes in the sandbox
        project. This will call the termhub api and return the results
        """
        # SETUP
        api_url = self.config.get("default", "url")
        token = os.getenv("TOKEN")
        terminology = "SNOMEDCT"
        code = "73211009"
        project_id = "sandbox"

        # ACT
        self.logger.info(f"  Getting {terminology} concept for {code}...")
        headers = {"Authorization": f"Bearer {token}"}
        response = requests.get(f"{api_url}/project/{project_id}/concept/{terminology}/{code}",
                                headers=headers)

        # ASSERT
        self.assertEqual(response.status_code, 200,
                         f"ERROR: GET call returned {response.status_code}, expected 200")
        self.assertIsNotNone(response, "ERROR: Response is None")

        self.logger.info("Concept: " + json.dumps(response.json(), indent=2))


if __name__ == '__main__':
    unittest.main()
