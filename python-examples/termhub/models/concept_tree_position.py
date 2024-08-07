# coding: utf-8

"""
    Terminology Hub Terminology Terminology API

    API documentation for the interacting with terminologies and concepts. <p>For a guided tour of using this API, see our github project <a href=\"https://github.com/terminologyhub/termhub-in-5-minutes\">https://github.com/terminologyhub/termhub-in-5-minutes</a></p>

    The version of the OpenAPI document: 1.0.0
    Contact: info@terminologyhub.com
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json

from datetime import datetime
from pydantic import BaseModel, ConfigDict, Field, StrictBool, StrictFloat, StrictInt, StrictStr
from typing import Any, ClassVar, Dict, List, Optional, Union
from termhub.models.concept_ref import ConceptRef
from typing import Optional, Set
from typing_extensions import Self

class ConceptTreePosition(BaseModel):
    """
    Represents a tree position in the terminology hierarchy for a concept
    """ # noqa: E501
    id: Optional[StrictStr] = Field(default=None, description="Unique identifier")
    confidence: Optional[Union[StrictFloat, StrictInt]] = Field(default=None, description="Confidence value (for use with search results)")
    modified: Optional[datetime] = Field(default=None, description="Last modified date")
    created: Optional[datetime] = Field(default=None, description="Created date")
    modified_by: Optional[StrictStr] = Field(default=None, description="Last modified by", alias="modifiedBy")
    local: Optional[StrictBool] = Field(default=None, description="Indicates whether this data element is locally created")
    active: Optional[StrictBool] = Field(default=None, description="Indicates whether or not the component is active")
    terminology: Optional[StrictStr] = Field(default=None, description="Terminology abbreviation, e.g. \"SNOMEDCT\"")
    version: Optional[StrictStr] = Field(default=None, description="Terminology version, e.g. \"20230901\"")
    publisher: Optional[StrictStr] = Field(default=None, description="Terminology publisher, e.g. \"SNOMEDCT\"")
    concept: Optional[ConceptRef] = None
    additional_type: Optional[StrictStr] = Field(default=None, description="Type of relationship in a more specific sense, e.g. \"is_a\", \"116680003\".  Typically this fieldwill be used for the hierarchical relationship type asserted in thepublished source data", alias="additionalType")
    ancestor_path: Optional[StrictStr] = Field(default=None, description="Dot-separated chain of codes from the root of the tree to the parent code of this node", alias="ancestorPath")
    child_ct: Optional[StrictInt] = Field(default=None, description="Count of child nodes", alias="childCt")
    level: Optional[StrictInt] = Field(default=None, description="Level of depth in the hierarchy")
    children: Optional[List[ConceptTreePosition]] = Field(default=None, description="Child tree position nodes")
    __properties: ClassVar[List[str]] = ["id", "confidence", "modified", "created", "modifiedBy", "local", "active", "terminology", "version", "publisher", "concept", "additionalType", "ancestorPath", "childCt", "level", "children"]

    model_config = ConfigDict(
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
    )


    def to_str(self) -> str:
        """Returns the string representation of the model using alias"""
        return pprint.pformat(self.model_dump(by_alias=True))

    def to_json(self) -> str:
        """Returns the JSON representation of the model using alias"""
        # TODO: pydantic v2: use .model_dump_json(by_alias=True, exclude_unset=True) instead
        return json.dumps(self.to_dict())

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of ConceptTreePosition from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias.

        This has the following differences from calling pydantic's
        `self.model_dump(by_alias=True)`:

        * `None` is only added to the output dict for nullable fields that
          were set at model initialization. Other fields with value `None`
          are ignored.
        """
        excluded_fields: Set[str] = set([
        ])

        _dict = self.model_dump(
            by_alias=True,
            exclude=excluded_fields,
            exclude_none=True,
        )
        # override the default output from pydantic by calling `to_dict()` of concept
        if self.concept:
            _dict['concept'] = self.concept.to_dict()
        # override the default output from pydantic by calling `to_dict()` of each item in children (list)
        _items = []
        if self.children:
            for _item in self.children:
                if _item:
                    _items.append(_item.to_dict())
            _dict['children'] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of ConceptTreePosition from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "id": obj.get("id"),
            "confidence": obj.get("confidence"),
            "modified": obj.get("modified"),
            "created": obj.get("created"),
            "modifiedBy": obj.get("modifiedBy"),
            "local": obj.get("local"),
            "active": obj.get("active"),
            "terminology": obj.get("terminology"),
            "version": obj.get("version"),
            "publisher": obj.get("publisher"),
            "concept": ConceptRef.from_dict(obj["concept"]) if obj.get("concept") is not None else None,
            "additionalType": obj.get("additionalType"),
            "ancestorPath": obj.get("ancestorPath"),
            "childCt": obj.get("childCt"),
            "level": obj.get("level"),
            "children": [ConceptTreePosition.from_dict(_item) for _item in obj["children"]] if obj.get("children") is not None else None
        })
        return _obj

# TODO: Rewrite to not use raise_errors
ConceptTreePosition.model_rebuild(raise_errors=False)

