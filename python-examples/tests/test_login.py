import logging
import os
import requests
import json
import configparser
import pytest
from requests import Response


@pytest.fixture(scope="module")
def load_config():
    """
    Load configuration settings
    """
    config_path = os.path.join(os.path.dirname(__file__), '..', 'config.ini')
    # Create a ConfigParser object & read the file
    config = configparser.ConfigParser()
    config.read(config_path)
    return config


class TestLogin:
    """
    Test case to get the authorization token from a valid account. You will need to run this class first to get your
    Authorization token, which is used in the other tests to pass the bearer token. Save the return authorization token
    and pass this as an environment variable
    """
    
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)
    
    # This tests your login credentials and return an access token in the console
    def test_login(self, load_config):
        """
        Test the login endpoint. This will call the termhub api and return the authentication token
        """
        # Define the URL, username, and password
        url: str = load_config.get("default", "url")
        username: str = os.getenv("USER_NAME")
        password: str = os.getenv("PASSWORD")
        headers: dict[str, str] = {"Content-type": "application/json"}
        
        self.logger.info(f"username = {username}")
        self.logger.info(f"password = {password}")
        
        # Create a dictionary for the payload
        payload:  dict[str, str | None] = {
            "grant_type": "username_password",
            "username": username,
            "password": password
        }
        
        # Send a POST request to the URL with the payload
        response: Response = requests.post(url + "/auth/token", data=json.dumps(payload), headers=headers)
        
        # Check the status code of the response
        assert response.status_code == 200, f"ERROR: POST call returned {response.status_code}, expected 200"
        
        # If the status code is 200, extract the access token from the response
        access_token = response.json().get("access_token")
        
        # Check if the access token is not None
        assert access_token is not None, "ERROR: Access token is None"
        self.logger.info(f"Authorization Token = {access_token}")
