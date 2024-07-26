import logging
import os
from typing import Optional

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
    project_id: str = "sandbox"
    
    def test_get_terminologies(self, terminology_api):
        """
        Test the get terminology endpoint with no project and params using default settings. This will call the
        termhub api and return the results
        """
        # SETUP - using global variable unless otherwise stated below
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}"}
        
        # ACT
        self.logger.info("  Performing terminologies lookup...")
        response: ResultListTerminology = terminology_api.find_terminologies(None, None, None, None, None,
                                                                             _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        assert response.total >= 69
        
        self.logger.info(f"Terminologies: {response}")
    
    # Test getting a terminology from a term id. NOTE: MAKE SURE TO UPDATE YOUR AUTH TOKE BY RUNNING `test_login.py`
    def test_get_specific_terminology(self, terminology_api):
        """
        Test the get specific terminology endpoint in the sandbox project. The term_id below is an example that may or
        may not work. The idea is to take one of the terminology ids returned by the previous call and you can then
        look up terminology info specifically for that UUID.
        """
        # SETUP - using global variable unless otherwise stated below
        term_id: str = "a2bc43ec-ba1b-47c0-9ff0-8379a02f8136"
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}"}
        
        # ACT & ASSERT
        self.logger.info(f"  Performing terminology lookup for {term_id}...")
        response: Terminology = terminology_api.get_terminology(term_id, _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(f"Terminology results for {term_id}: {response}")
    
    def test_get_project_terminologies(self, terminology_api):
        """
        Test the get project terminologies endpoint in the sandbox project. This will call the termhub api and return
        the results of the call
        """
        # SETUP - using global variable unless otherwise stated below
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}"}
        
        # ACT
        self.logger.info("  Performing project terminologies lookup...")
        response: [Terminology] = terminology_api.get_project_terminologies(self.project_id, _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(f"Project Terminologies: {response}")
    
    def test_export_terminologies(self, terminology_api):
        """
        Test the export terminologies endpoint with SNOMEDCT terminology in the sandbox project. This will call the
        termhub api and return an HTTP code.
        """
        # SETUP
        terminology: str = "SNOMEDCT"
        format_type: str = "native"
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}", "accept": "*/*"}
        
        # ACT
        try:
            self.logger.info(f"  Exporting terminology {terminology}...")
            response: Optional[bytes] = terminology_api.export_terminology(self.project_id, terminology, format_type,
                                                                 _headers=headers)
            if response:
                file_path = f"{terminology}.zip"
                with open(file_path, "wb") as file:
                    file.write(response)
                self.logger.info(f"Exported terminology {terminology} save to {file_path}")
            else:
                self.logger.info("Failed to export terminology. No data returned")
        except Exception as e:
            self.logger.error(f"An error occurred while exporting {terminology}: {e}")
        
        self.logger.info("Export completed successfully!")
