import logging
import os
import sys
import configparser
import pytest


SCRIPTS_DIR = os.path.abspath(os.path.join(os.path.dirname(__file__), "..", "..", "scripts"))
if SCRIPTS_DIR not in sys.path:
    sys.path.insert(0, SCRIPTS_DIR)

from termhub_auth import first_present, request_access_token


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
        url: str = load_config.get("default", "url")
        username = first_present(
            os.getenv("TERMHUB_USER"),
            os.getenv("TERMHUB_USERNAME"),
            os.getenv("USER_NAME"),
            os.getenv("USERNAME"),
            load_config.get("default", "username"),
        )
        password = first_present(
            os.getenv("TERMHUB_PASSWORD"),
            os.getenv("PASSWORD"),
            load_config.get("default", "password"),
        )
        
        self.logger.info(f"username = {username}")
        self.logger.info(f"password = {password}")
        
        try:
            access_token = request_access_token(url, username, password)
        except RuntimeError as error:
            pytest.fail(str(error))
        
        self.logger.info(f"Authorization Token = {access_token}")

        token_path = os.path.abspath(os.path.join(os.path.dirname(__file__), "..", "temp_token.txt"))
        with open(token_path, "w", encoding="utf-8") as token_file:
            token_file.write(access_token)
