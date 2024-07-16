<a name="top" />

TERMHUB REGENERATE CLIENT SDKs
==================================
This is a how-to guide for rebuilding openapi generated code as updates to the swagger are implemented.

## Requirements

1. Java 17+

## How to Build a Single Client

If you need to regenerate a single client for a given language:

1. Open your terminal and cd to the dir. e.g. `termhub-in-5-minutes/doc/code-generator`
2. Execute `gradle <nameOfTask>` in your terminal
3. The code will generate in a `build` dir. Navigate to the `build` dir.
4. From the `build` dir, copy the generated code files and any other files required to build the project to the
   corresponding "examples" folder.
    1. See [next steps](#tasks-to-regenerate-code--next-steps) for details based on your language generated

**[Back to top](#evsrestapi-generate-client-code)**

## How to Build All Clients

If you need to rebuild all the clients for all languages, typically after a big update to the `.yaml` file or
swagger documentation url:

1. Open your terminal and cd to the project directory. e.g. `termhub-in-5-minutes/doc/code-generator`
2. Execute `gradle buildClients`
3. All generated projects will be in a `build` folder. Navigate to the `build` folder to see the generated code
4. From the `build` folder, copy the generated code files and additional files needs to build/compile the project to the
   corresponding examples folder.
    1. See [next steps](#tasks-to-regenerate-code--next-steps) for details

**[Back to top](#evsrestapi-generate-client-code)**

## Tasks to Regenerate Code & Next Steps...

The following is a list of the available gradle tasks for each language the openapi code generator can generate. The
location the code is generated to is also provided. Follow the steps for each language on what files to copy to the
corresponding `[language]-examples` directory

### Java client

1. To generate the client code for java, run `./gradlew buildJavaSdk`
2. Find the generated client in `build/java`
3. Copy the new files generated from the `src/main` folder to the `java-examples/src/main` folder.
    1. 🚫🚫 **DO NOT** replace `ApiClient.java`
        1. `java-examples` uses `src/main/resources/url.properties` to set the basePath url in `ApiClient.java`. The url
           should be updated in the `url.properties` file only.
    2. 🚫🚫 **DO NOT** replace tests. Update tests to demo the new api calls or fix failing tests.
4. Verify the gradle files match between what was generated vs what exists in `java-examples`. Update as needed, but
   **don't** override.
5. Verify the project builds and the tests run successfully before pushing changes

### Python client

1. To generate the client code for python, run `./gradlew buildPythonSdk`
2. Find the generated client in `build/python`
3. Copy the new files generated from the `build/python/termhub/` folder to the `python-examples` folder. It's
   recommended to only copy the files updated to avoid excessive refactoring (see step 4)
    1. 🚫🚫 **DO NOT** replace `api_client.py`,
        1. `python-examples` uses `config.ini` to set the basePath url in `api_client.py`. The url should be updated in
           the `config.ini` files only. Compare the generated `api_client.py` with the already existing one to determine
           if anything is missing. Add sections as needed.
    2. 🚫🚫 **DO NOT** replace `requirements.txt`, or `test-requirements.txt`.
        1. We have additional requirements added that aren't part of the generated requirements files. Compare the
           generated `requirements.txt` and `test-requirements.txt` to the existing ones and add new reqs as needed
4. 🚫🚫 **DO NOT** replace tests. Update tests to demo the new api calls or fix failing tests.
5. ⚠️⚠️ Update imports for `.__init__.py` to add `termhub.` as a prefix in the `from` statement. The
   generated code doesn't include the root package in the imports in these files which will cause the tests to fail.
6. Verify the tests run successfully in the IDE and the terminal before pushing changes.

**[Back to top](#evsrestapi-generate-client-code)**

## Resources

* https://github.com/int128/gradle-swagger-generator-plugin?tab=readme-ov-file#introduction
* https://stackoverflow.com/questions/66137846/how-to-use-the-open-api-3-gradle-plugin

## Current Contributors

- [Brian Carlsen](https://github.com/bcarlsenca)
- [Alicia Garcia](https://github.com/gaaliciA1990)
- [Other Contributors](https://github.com/NCIEVS/evsrestapi-client-SDK/graphs/contributors)

**[Back to top](#evsrestapi-generate-client-code)**