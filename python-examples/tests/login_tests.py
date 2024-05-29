import os
import unittest
import requests
import json
import configparser


class TestLogin(unittest.TestCase):
    # Create a ConfigParser object & read the file
    config = configparser.ConfigParser()
    config.read('../config.ini')

    def test_login(self):
        # Define the URL, username, and password
        url = self.config.get('default', 'url')
        username = os.getenv('USERNAME')
        password = os.getenv('PASSWORD')

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
                         f"ERROR: POST /auth/token returned {response.status_code}, expected 200")

        # If the status code is 200, extract the access token from the response
        access_token = response.json().get('access_token')

        # Check if the access token is not None
        self.assertTrue(access_token is not None, "ERROR: Access token is None")


if __name__ == '__main__':
    unittest.main()
