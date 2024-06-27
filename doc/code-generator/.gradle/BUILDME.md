<a name="top" />

EVSRESTAPI REGENERATE CLIENT SDKs
==================================
This is a how-to guide for rebuilding openapi generated code as updates to the swagger are implemented.

## Requirements

1. Java 17+
2. Gradle 8.2+

## How to Build a Single Client

If you need to regenerate a single client for a given language:

1. Open your terminal and cd to the dir. e.g. `evsrestapi-client-sdk/doc/code-gen`
2. Execute `gradle <nameOfTask>` in your terminal
3. The code will generate in a `build` dir. Navigate to the `build` dir.
4. From the `build` dir, copy the generated code files and any other files required to build the project to the
   corresponding "examples" folder.
    1. See [next steps](#tasks-to-regenerate-code--next-steps) for details based on your language generated

**[Back to top](#evsrestapi-generate-client-code)**

## How to Build All Clients

If you need to rebuild all the clients for all languages, typically after a big update to the `.yaml` file:

1. Open your terminal and cd to the project directory. e.g. `evsrestapi-client-sdk`
2. Execute `gradle buildDependentTasks`
3. All generated projects will be in a `build` folder. Navigate to the `build` folder to see the generated code
4. From the `build` folder, copy the generated code files and additional files needs to build/compile the project to the
   corresponding examples folder.
    1. See [next steps](#tasks-to-regenerate-code--next-steps) for details

**[Back to top](#evsrestapi-generate-client-code)**

## Tasks to Regenerate Code & Next Steps...

The following is a list of the available gradle tasks for each language the openapi code generator can generate. The
location the generated code is generated is also provided.

### All clients

To build generate clients for every supported language we have, run the `./gradlew buildClients` command in the
terminal.
For copying files, see the steps for the individual language below

### Java client

1. To generate the client code for java, run `./gradlew buildJavaSdk`
2. Find the generated client in `build/java`
3. Copy the new files generated from the `src/main` folder to the `java-examples/src/main` folder.
    1. **DO NOT** replace `ApiClient.java`

       a. `java-examples` uses `src/main/resources/url.properties` to set the basePath url in `ApiClient.java`.
       The url should be updated in the `url.properties` file only.

    2. **DO NOT** replace tests. Update tests to demo the new api calls or fix failing tests.

4. Verify the gradle files match between what was generated vs what exists in `java-examples`. Update as needed, but
   **don't** override.
5. Verify the project builds and the tests run successfully before pushing changes

[//]: # (### Python client)

[//]: # ()
[//]: # (1. To generate the client code for python, run `./gradlew buildPythonSdk`)

[//]: # (2. Find the generated client in `build/python`)

[//]: # (3. Copy the new files generated from the `build/python/python-examples/` folder to the `python-examples` folder.)

[//]: # (    1. **DO NOT** replace `__init__.py`, instead add the new file path to the list in this file.)

[//]: # (4. Make sure to update the imports. Opening the file in your IDE that supports python should underline the invalid)

[//]: # (   imports. The path may include parts that aren't necssary.)

[//]: # (    1. i.e. `from python-examples.models.application_version import ApplicationVersion` should be updated to `from)

[//]: # (       application_version import ApplicationVersion`)

[//]: # ()
[//]: # (**[Back to top]&#40;#evsrestapi-generate-client-code&#41;**)

## Resources

* https://github.com/int128/gradle-swagger-generator-plugin?tab=readme-ov-file#introduction
* https://stackoverflow.com/questions/66137846/how-to-use-the-open-api-3-gradle-plugin

## Current Contributors

- [Brian Carlsen](https://github.com/bcarlsenca)
- [Alicia Garcia](https://github.com/gaaliciA1990)
- [Other Contributors](https://github.com/NCIEVS/evsrestapi-client-SDK/graphs/contributors)

**[Back to top](#evsrestapi-generate-client-code)**