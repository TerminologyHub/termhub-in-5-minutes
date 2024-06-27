import configparser
import json
import logging
import os
import unittest

import requests


class TestFindTermBySearchTerm(unittest.TestCase):
    """
    Test case to find a term by search term. Make sure you have your authorization token by running test_login.py
    """
    # Create a ConfigParser object & read the file
    config = configparser.ConfigParser()
    config.read("../config.ini")

    # Create a logger
    logger = logging.getLogger(__name__)
    logger.setLevel(logging.INFO)
    logging.basicConfig(level=logging.INFO)

    def test_find_terms_by_search_term(self):
        """
        Test the find term by search term endpoint with SNOMEDCT terminology and a query for diabetes in the sandbox
        project. This will call the termhub api and return the results
        """
        # SETUP
        api_url = self.config.get("default", "url")
        token = os.getenv("TOKEN")
        term = "SNOMEDCT"
        query = "diabetes"
        project_id = "sandbox"
        params = {
            "terminology": term,
            "query": query,
            "limit": 5,
        }

        # ACT
        self.logger.info(f"  Finding {term} term for {query}...")
        headers = {"Authorization": f"Bearer {token}"}
        response = requests.get(f"{api_url}/project/{project_id}/term",
                                headers=headers, params=params)

        # ASSERT
        self.assertEqual(response.status_code, 200,
                         f"ERROR: GET call returned {response.status_code}, expected 200")
        self.assertIsNotNone(response, "ERROR: Response is None")

        self.logger.info(f"Found term from search for {query} : " + json.dumps(response.json(), indent=2))


if __name__ == '__main__':
    unittest.main()
