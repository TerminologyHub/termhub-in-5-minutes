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

class ConceptRelationship(BaseModel):
    """
    Represents a relationship between two concepts in a terminology
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
    component_id: Optional[StrictStr] = Field(default=None, description="Identifier for this object in the published source terminology", alias="componentId")
    type: Optional[StrictStr] = Field(default=None, description="Type of relationship in a broad sense, e.g. \"other\", \"broader\", \"narrower\".  Inspired by the REL field in the UMLS MRREL.RRF file, this field will typically have a Termhub-computed value for the high-level relationship type")
    additional_type: Optional[StrictStr] = Field(default=None, description="Type of relationship in a more specific sense, e.g. \"member_of\", \"has_finding_site\", \"363698007\".  Typically this fieldwill be used for the primary relationship type asserted in thepublished source data", alias="additionalType")
    var_from: Optional[ConceptRef] = Field(default=None, alias="from")
    to: Optional[ConceptRef] = None
    to_value: Optional[StrictStr] = Field(default=None, description="Literal value on the other side of the relationship (either \"to\" or \"toValue\" will be used but not both)", alias="toValue")
    hierarchical: Optional[StrictBool] = Field(default=None, description="Indicates whether this relationship represents a hierarchical or parent/child type of connection")
    historical: Optional[StrictBool] = Field(default=None, description="Indicates whether this relationship represents a historical type of connection from a retired concept to an active concept")
    asserted: Optional[StrictBool] = Field(default=None, description="Indicates whether or not this relationship is in the direction asserted by the terminology.")
    defining: Optional[StrictBool] = Field(default=None, description="Indicates whether or not this relationship is part of the logical definition of the from concept")
    group: Optional[StrictStr] = Field(default=None, description="Represents a value used to group relationships whose semantics are bound together.")
    attributes: Optional[Dict[str, StrictStr]] = Field(default=None, description="Key/value pairs associated with this object")
    __properties: ClassVar[List[str]] = ["id", "confidence", "modified", "created", "modifiedBy", "local", "active", "terminology", "version", "publisher", "componentId", "type", "additionalType", "from", "to", "toValue", "hierarchical", "historical", "asserted", "defining", "group", "attributes"]

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
        """Create an instance of ConceptRelationship from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of var_from
        if self.var_from:
            _dict['from'] = self.var_from.to_dict()
        # override the default output from pydantic by calling `to_dict()` of to
        if self.to:
            _dict['to'] = self.to.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of ConceptRelationship from a dict"""
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
            "componentId": obj.get("componentId"),
            "type": obj.get("type"),
            "additionalType": obj.get("additionalType"),
            "from": ConceptRef.from_dict(obj["from"]) if obj.get("from") is not None else None,
            "to": ConceptRef.from_dict(obj["to"]) if obj.get("to") is not None else None,
            "toValue": obj.get("toValue"),
            "hierarchical": obj.get("hierarchical"),
            "historical": obj.get("historical"),
            "asserted": obj.get("asserted"),
            "defining": obj.get("defining"),
            "group": obj.get("group"),
            "attributes": obj.get("attributes")
        })
        return _obj


