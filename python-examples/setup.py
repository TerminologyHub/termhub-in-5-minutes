# coding: utf-8

"""
    Terminology Hub Terminology Terminology API

    API documentation for the interacting with terminologies and concepts. <p>For a guided tour of using this API, see our github project <a href=\"https://github.com/terminologyhub/termhub-in-5-minutes\">https://github.com/terminologyhub/termhub-in-5-minutes</a></p>

    The version of the OpenAPI document: 1.0.0
    Contact: info@terminologyhub.com
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from setuptools import setup, find_packages  # noqa: H301

# To install the library, run the following
#
# python setup.py install
#
# prerequisite: setuptools
# http://pypi.python.org/pypi/setuptools
NAME = "termhub"
VERSION = "1.0.0"
PYTHON_REQUIRES = ">=3.7"
REQUIRES = [
    "urllib3 >= 1.25.3, < 2.1.0",
    "python-dateutil",
    "pydantic >= 2",
    "typing-extensions >= 4.7.1",
]

setup(
    name=NAME,
    version=VERSION,
    description="Terminology Hub Terminology Terminology API",
    author="API Support",
    author_email="info@terminologyhub.com",
    url="",
    keywords=["OpenAPI", "OpenAPI-Generator", "Terminology Hub Terminology Terminology API"],
    install_requires=REQUIRES,
    packages=find_packages(exclude=["test", "tests"]),
    include_package_data=True,
    long_description_content_type='text/markdown',
    long_description="""\
    API documentation for the interacting with terminologies and concepts. &lt;p&gt;For a guided tour of using this API, see our github project &lt;a href&#x3D;\&quot;https://github.com/terminologyhub/termhub-in-5-minutes\&quot;&gt;https://github.com/terminologyhub/termhub-in-5-minutes&lt;/a&gt;&lt;/p&gt;
    """,  # noqa: E501
    package_data={"termhub": ["py.typed"]},
)