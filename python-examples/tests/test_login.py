import logging
import os
import unittest
from datetime import datetime
import requests
import json
import configparser


# This test is to get the authToken
class TestLogin(unittest.TestCase):
    """
    Test case to get the authorization token from a valid account. You will need to run this class first to get your
    Authorization token, which is used in the other tests to pass the bearer token. Save the return authorization token
    and pass this as an environment variable
    """
    # Create a ConfigParser object & read the file
    config = configparser.ConfigParser()
    config.read("../config.ini")

    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)

    # This tests your login credentials and return an access token in the console
    def test_login(self):
        """
        Test the login endpoint. This will call the termhub api and return the authentication token
        """
        # Define the URL, username, and password
        url = self.config.get("default", "url")
        username = os.getenv("USERNAME")
        password = os.getenv("PASSWORD")

        # Create a dictionary for the payload
        payload = {
            "grant_type": "username_password",
            "username": username,
            "password": password
        }

        # Send a POST request to the URL with the payload
        response = requests.post(url + "/auth/token", data=json.dumps(payload),
                                 headers={"Content-type": "application/json"})

        # Check the status code of the response
        self.assertEqual(response.status_code, 200,
                         f"ERROR: POST call returned {response.status_code}, expected 200")

        # If the status code is 200, extract the access token from the response
        access_token = response.json().get("access_token")

        # Check if the access token is not None
        self.assertTrue(access_token is not None, "ERROR: Access token is None")
        self.logger.info(f"Authorization Token = {access_token}")



if __name__ == '__main__':
    unittest.main()
