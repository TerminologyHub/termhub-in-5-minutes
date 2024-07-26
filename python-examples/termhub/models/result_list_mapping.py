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

from pydantic import BaseModel, ConfigDict, Field, StrictInt
from typing import Any, ClassVar, Dict, List, Optional
from termhub.models.mapping import Mapping
from termhub.models.search_parameters import SearchParameters
from typing import Optional, Set
from typing_extensions import Self

class ResultListMapping(BaseModel):
    """
    Represents a list of mappings returned from a find call
    """ # noqa: E501
    total: Optional[StrictInt] = Field(default=None, description="Total number of results (often this list represents just a single page)")
    parameters: Optional[SearchParameters] = None
    items: Optional[List[Mapping]] = Field(default=None, description="items of the result list")
    __properties: ClassVar[List[str]] = ["total", "parameters", "items"]

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
        """Create an instance of ResultListMapping from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of parameters
        if self.parameters:
            _dict['parameters'] = self.parameters.to_dict()
        # override the default output from pydantic by calling `to_dict()` of each item in items (list)
        _items = []
        if self.items:
            for _item in self.items:
                if _item:
                    _items.append(_item.to_dict())
            _dict['items'] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of ResultListMapping from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "total": obj.get("total"),
            "parameters": SearchParameters.from_dict(obj["parameters"]) if obj.get("parameters") is not None else None,
            "items": [Mapping.from_dict(_item) for _item in obj["items"]] if obj.get("items") is not None else None
        })
        return _obj


