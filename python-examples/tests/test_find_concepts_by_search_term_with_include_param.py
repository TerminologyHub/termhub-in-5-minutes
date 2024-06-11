import configparser
import json
import logging
import os
import unittest

import requests


class TestFindConceptsByTermWithIncludeParam(unittest.TestCase):
    # Create a ConfigParser object & read the file
    config = configparser.ConfigParser()
    config.read("../config.ini")

    # Create a logger
    logger = logging.getLogger(__name__)
    logger.setLevel(logging.INFO)
    logging.basicConfig(level=logging.INFO)

    def test_get_concept_by_query_and_include_param(self):
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
            "include": "parents"
        }

        # ACT
        self.logger.info(f"  Getting {term} concept for {query} with parents...")
        headers = {"Authorization": f"Bearer {token}"}
        response = requests.get(f"{api_url}/project/{project_id}/concept",
                                headers=headers, params=params)

        # ASSERT
        self.assertEqual(response.status_code, 200,
                         f"ERROR: GET call returned {response.status_code}, expected 200")
        self.assertIsNotNone(response, "ERROR: Response is None")

        self.logger.info(f"Concept from search for {query} with parents included: " + json.dumps(response.json(), indent=2))


if __name__ == '__main__':
    unittest.main()
