import os
import logging
import pytest

from termhub import Concept, ConceptByCodeApi, ResultListConceptRelationship, ResultListConceptTreePosition


@pytest.fixture(scope="module")
def concept_by_code_api():
    """
    Fixture to return a ConceptByCodeApi object
    """
    return ConceptByCodeApi()


class TestConceptByCodeApi:
    """
    Test case to get a concept's trees by code. Make sure you have your authorization token by running test_login.py
    """
    # Create logger from pytest.ini settings
    logger = logging.getLogger(__name__)
    terminology: str = "SNOMEDCT"
    project_id: str = "sandbox"
    token: str = os.getenv("TOKEN")
    
    def test_get_concept_trees(self, concept_by_code_api):
        """
        Test the get concept trees by code endpoint with SNOMEDCT terminology and a code for diabetes in the sandbox
        project. This will call the termhub api and return the results
        """
        # SETUP
        code: str = "73211009"
        
        # ACT
        self.logger.info(f"  Getting {self.terminology} concept trees for {code}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}"}
        response: ResultListConceptTreePosition = concept_by_code_api.find_tree_positions(self.project_id,
                                                                                          self.terminology, code, None,
                                                                                          None, None, None, None,
                                                                                          _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(f"Concepts Trees: {response}")
    
    def test_get_concept_by_code(self, concept_by_code_api):
        """
        Test the get concept by code endpoint with SNOMEDCT terminology and a code for diabetes in the sandbox
        project. This will call the termhub api and return the results
        """
        # SETUP
        code: str = "73211009"
        
        # ACT
        self.logger.info(f"  Getting {self.terminology} concept for {code}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}"}
        response: Concept = concept_by_code_api.get_concept(self.project_id, self.terminology, code, None,
                                                            _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(f"Concept: {response} ")
    
    def test_get_concept_by_code_with_include_param(self, concept_by_code_api):
        """
        Test the get concept by code endpoint with SNOMEDCT terminology and a code for diabetes in the sandbox
        project and an include parameter passed. This will call the termhub api and return the results
        """
        # SETUP
        code: str = "73211009"
        include: str = "full"
        
        # ACT
        self.logger.info(f"  Getting concept for {code} with full include...")
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}"}
        response: Concept = concept_by_code_api.get_concept(self.project_id, self.terminology, code, include,
                                                            _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(f"Concept with include set to full: {response}")
    
    def test_get_concept_inverse_relationships_by_code(self, concept_by_code_api):
        """
        Test the get concept inverse relationships by code endpoint with SNOMEDCT terminology and a code for diabetes in
        the sandbox project. This will call the termhub api and return the results
        """
        # SETUP
        code: str = "113331007"
        
        # ACT
        self.logger.info(f"  Getting {self.terminology} concept inverse relationships for {code}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}"}
        response: ResultListConceptRelationship = concept_by_code_api.find_concept_inverse_relationships(
            self.project_id,
            self.terminology, code, None,
            None, None, None, None,
            _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        
        self.logger.info(f"Concepts Inverse Relationships: {response}")
    
    def test_get_concept_relationships_by_code(self, concept_by_code_api):
        """
        Test the get concept relationships by code endpoint with SNOMEDCT terminology and a code for diabetes in
        the sandbox project. This will call the termhub api and return the results
        """
        # SETUP
        code: str = "73211009"
        
        # ACT
        self.logger.info(f"  Getting {self.terminology} concept relationships for {code}...")
        headers: dict[str, str] = {"Authorization": f"Bearer {self.token}"}
        response: ResultListConceptRelationship = concept_by_code_api.find_concept_relationships(self.project_id, self.terminology, code,
                                                                            None, None, None, None, None,
                                                                            _headers=headers)
        
        # ASSERT
        assert response is not None, "ERROR: Response is None"
        self.logger.info(f"Concept Relationships: ")
