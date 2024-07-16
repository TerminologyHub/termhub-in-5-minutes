import logging
import os
import pytest

from termhub import ResultListTerminology, Terminology, TerminologyApi


@pytest.fixture(scope="module")
def terminology_api():
    """
    Fixture to return a TerminologyApi object
    """
    return TerminologyApi()


# Test GET Terminologies returns all terminologies
class TestTerminologyApi:
    """
    Test case to get all terminologies. Make sure you have your authorization token by running test_login.py
    """
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)
    
    token: str = os.getenv("TOKEN")
    
    def test_get_terminologies(self, terminology_api):
        """
        Test the get terminology endpoint with no project and params using default settings. This will call the
        termhub api and return the results
        """
        # SETUP
        
        # ACT
        self.logger.info("  Performing terminologies lookup...")
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}"}
        response: ResultListTerminology = terminology_api.find_terminologies(None, None, None, None, None, _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        assert response.total >= 69
        
        self.logger.info(f"Terminologies: {response}")
    
    # Test getting a terminology from a term id. NOTE: MAKE SURE TO UPDATE YOUR AUTH TOKE BY RUNNING `test_login.py`
    def test_get_specific_terminology(self, terminology_api):
        """
        Test the get specific terminology endpoint in the sandbox project. This will call the termhub api and return
        the results
        """
        # SETUP
        # Define the URL, token, and id
        term_id: str = "a2bc43ec-ba1b-47c0-9ff0-8379a02f8136"
        
        # ACT & ASSERT
        self.logger.info(f"  Performing terminology lookup for {term_id}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}"}
        response: Terminology = terminology_api.get_terminology(term_id, _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(f"Terminology results for {term_id}: {response}")
    
    def test_get_project_terminologies(self, terminology_api):
        """
        Test the get project terminologies endpoint in the sandbox project. This will call the termhub api and return
        the results of the call
        """
        # SETUP
        # Define the URL, token, and id
        project_id: str = "sandbox"
        
        # ACT
        self.logger.info("  Performing project terminologies lookup...")
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}"}
        response: [Terminology] = terminology_api.get_project_terminologies(project_id, _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(f"Project Terminologies: {response}")
    
    def test_export_terminologies(self, terminology_api):
        """
        Test the export terminologies endpoint with SNOMEDCT terminology in the sandbox project. This will call the
        termhub api and return a HTTP code.
        """
        # SETUP
        terminology: str = "SNOMEDCT"
        project_id: str = "sandbox"
        format_type: str = "native"
        
        # ACT
        self.logger.info(f"  Exporting terminology {terminology}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}"}
        terminology_api.export_terminology(project_id, terminology, format_type, _headers=headers)
        
        # ASSERT
        self.logger.info("Export completed successfully!")
