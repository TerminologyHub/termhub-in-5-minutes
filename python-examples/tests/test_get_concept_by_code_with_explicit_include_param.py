import configparser
import json
import logging
import os
import unittest

import requests


class TestGetConceptWithIncludeParam(unittest.TestCase):
    # Create a ConfigParser object & read the file
    config = configparser.ConfigParser()
    config.read("../config.ini")

    # Create a logger
    logger = logging.getLogger(__name__)
    logger.setLevel(logging.INFO)
    logging.basicConfig(level=logging.INFO)

    def test_get_concept_by_code_with_include_param(self):
        # SETUP
        api_url = self.config.get("default", "url")
        token = os.getenv("TOKEN")
        terminology = "SNOMEDCT"
        code = "73211009"
        project_id = "sandbox"
        params = {"inclue": "full"}

        # ACT
        self.logger.info(f"  Getting concept for {code} with full include...")
        headers = {"Authorization": f"Bearer {token}"}
        response = requests.get(f"{api_url}/project/{project_id}/concept/{terminology}/{code}",
                                headers=headers, params=params)

        # ASSERT
        self.assertEqual(response.status_code, 200,
                         f"ERROR: GET call returned {response.status_code}, expected 200")
        self.assertIsNotNone(response, "ERROR: Response is None")

        self.logger.info("Concept with include params: " + json.dumps(response.json(), indent=2))


if __name__ == '__main__':
    unittest.main()
