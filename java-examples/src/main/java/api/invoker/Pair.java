/*
 * Terminology Hub Terminology Terminology API
 * API documentation for the interacting with terminologies and concepts. <p>For a guided tour of using this API, see our github project <a target=\"_blank\" href=\"https://github.com/terminologyhub/termhub-in-5-minutes\">https://github.com/terminologyhub/termhub-in-5-minutes</a></p>
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: info@terminologyhub.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package api.invoker;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-26T15:47:59.449899600-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class Pair {
    private String name = "";
    private String value = "";

    public Pair (String name, String value) {
        setName(name);
        setValue(value);
    }

    private void setName(String name) {
        if (!isValidString(name)) {
            return;
        }

        this.name = name;
    }

    private void setValue(String value) {
        if (!isValidString(value)) {
            return;
        }

        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    private boolean isValidString(String arg) {
        if (arg == null) {
            return false;
        }

        return true;
    }
}
