import pytest
import logging
import os

from termhub import ResultListTerm, TermApi


@pytest.fixture
def term_api():
    """
    Fixture to return a TermApi object
    """
    return TermApi()


class TestTermApi:
    """
    Class to tests the autocomplete endpoint. Make sure you have your authorization token by running test_login.py
    """
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)
    token: str = os.getenv("TOKEN")
    term: str = "SNOMEDCT"
    query: str = "diabetes"
    project_id: str = "sandbox"
    
    def test_find_terms_by_search_term(self, term_api):
        """
        Test the find term by search term endpoint with SNOMEDCT terminology and a query for diabetes in the sandbox
        project. This will call the termhub api and return the results
        """
        # SETUP - Using global vars unless otherwise listed below
        limit: int = 5
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}"}
        
        # ACT
        self.logger.info(f"  Finding {self.term} term for {self.query}...")
        response: ResultListTerm = term_api.find_terms(self.project_id, self.term, self.query, None, limit, None, None,
                                                   None,
                                       _headers=headers)
        
        # ASSERT
        assert response is not None
        self.logger.info(f"Found term from search for {self.query}: {response}")
    
    def test_autocomplete_and_typeahead(self, term_api):
        """
        Test the autocomplete endpoint with SNOMEDCT terminology, a query for diabetes but partially typed, in the
        sandbox project. This will call the termhub api and return the results of the search
        """
        # SETUP
        query: str = "diab"
        limit: int = 10
        expected_result: str = "Diabetes"
        contains_expected: bool = False
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}"}
        
        # ACT
        self.logger.info(f"  Submitting autocomplete search...")
        response: [str] = term_api.autocomplete(self.project_id, query, self.term, limit, _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        for term in response:
            assert term is not None
            if term.__contains__(expected_result):
                contains_expected = True
                break
        assert contains_expected is True
        
        self.logger.info(f"Autocomplete Results: {response}")
