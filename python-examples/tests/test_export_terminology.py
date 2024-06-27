import configparser
import logging
import os
import unittest

import requests


class TestExportTerminologies(unittest.TestCase):
    """
    Class to test the export terminologies endpoint. Make sure you have your authorization token by running test_login.py
    """
    # Create a ConfigParser object & read the file
    config = configparser.ConfigParser()
    config.read("../config.ini")

    # Create a logger
    logger = logging.getLogger(__name__)
    logger.setLevel(logging.INFO)
    logging.basicConfig(level=logging.INFO)

    def test_export_terminologies(self):
        """
        Test the export terminologies endpoint with SNOMEDCT terminology in the sandbox project. This will call the
        termhub api and return a HTTP code.
        """
        # SETUP
        api_url = self.config.get("default", "url")
        token = os.getenv("TOKEN")
        terminology = "SNOMEDCT"
        project_id = "sandbox"
        params = {"format": "native"}

        # ACT
        self.logger.info(f"  Exporting terminology {terminology}...")
        headers = {"Authorization": f"Bearer {token}"}
        response = requests.get(f"{api_url}/project/{project_id}/terminology/{terminology}/export",
                                headers=headers, params=params)
        # ASSERT
        self.assertEqual(response.status_code, 200,
                         f"ERROR: GET call returned {response.status_code}, expected 200")
        self.assertIsNotNone(response, "ERROR: Response is None")
        self.logger.info("Export completed successfully!")


if __name__ == '__main__':
    unittest.main()
