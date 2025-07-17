# Termhub in 5 Minutes Tutorial

This is an easy-to-use tutorial for accessing TermHub APIs through api.terminologyhub.com.
[TermHub](https://www.terminologyhub.com) is a cloud healthcare terminology server offering 
access to a large library of code systems, value sets, and concept mappings along with standard 
developer-friendly mechansims for interacting with that content (such as FHIR® terminology services).

[Tutorial Training Video](https://youtu.be/Vto42DIMw2U)

**Reference deployments**

To test against our TermHub terminology servers, you must first create an account by signing up at https://app.terminologyhub.com/signup.

## Table of Contents

1. [Tutorials by Language](#tutorials-by-language)
2. [Use Cases](#use-cases)
3. [Resources](#resources)
4. [Contributing](#contributing)
5. [License](#license)

## Tutorials by Language

- [Click for Bash examples.](../master/bash-examples/ "Bash Examples")
- [Click for Curl examples.](../master/curl-examples/ "Curl Examples")
- [Click for Go examples.](../master/go-examples/ "Go Examples")
- [Click for FHIR examples.](../master/fhir-examples/ "FHIR Examples")
- [Click for Java examples.](../master/java-examples/ "Java Examples")
- [Click for JavaScript examples.](../master/javascript-examples/ "JavaScript Examples")
- [Click for Postman examples.](../master/postman-examples/ "Postman Examples")
- [Click for Python examples.](../master/python-examples/ "Python Examples")


**[Back to top](#table-of-contents)**

## Use Cases

The following cases will be used to demonstrate accessing the TermHub Terminology API.  These are
the standard kinds of questions that a terminology server supports for interacting with code systems.

- Login
- Get terminologies
- Get project terminologies
- Get specific terminology
- Export terminology
- Get concept by code
- Get concept by code with explicit include parameter
- Get concept relationships by code
- Get concept inverse relationships by code
- Get concept trees
- Find concepts by search term (use paging to get only first 5 results)
- Find concepts by search term with explicit include parameter
- Find concepts by search term and expression
- Find terms by search term
- Support autocomplete/typeahead for first few characters typed
- Get mapsets
- Get project mapsets
- Get specific mapset
- Export mapset
- Get mappings for concept by code
- Find project mappings for mapset
- Find project mappings
- Coming Soon: compute "new" or "retired" codes across terminology versions

All of the tutorials use an environment variable for the API URL of the deployment:

- API_URL=https://api.terminologyhub.com

**[Back to top](#table-of-contents)**


## Resources

- API Documentation - https://api.terminologyhub.com/terminology/doc/swagger-ui/index.html
- [Additional Documentation](../master/doc/)


**[Back to top](#table-of-contents)**

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request

**[Back to top](#table-of-contents)**

## Current Contributors

- [Brian Carlsen](https://github.com/bcarlsenca)
- [Other Contributors](https://github.com/WestCoastInformatics/termhub-in-5-minutes/graphs/contributors)

**[Back to top](#table-of-contents)**

## License

See the included [`LICENSE.txt`](LICENSE.txt) file for details.

**[Back to top](#table-of-contents)**

