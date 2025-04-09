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


package api.model;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import api.model.SearchParameters;
import api.model.Term;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import api.invoker.JSON;


/**
 * Represents a list of terms returned from a find call
 */
@JsonPropertyOrder({
  ResultListTerm.JSON_PROPERTY_TOTAL,
  ResultListTerm.JSON_PROPERTY_PARAMETERS,
  ResultListTerm.JSON_PROPERTY_ITEMS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-04T13:11:42.646293800-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class ResultListTerm {
  public static final String JSON_PROPERTY_TOTAL = "total";
  private Long total;

  public static final String JSON_PROPERTY_PARAMETERS = "parameters";
  private SearchParameters parameters;

  public static final String JSON_PROPERTY_ITEMS = "items";
  private List<Term> items = new ArrayList<>();

  public ResultListTerm() { 
  }

  public ResultListTerm total(Long total) {
    this.total = total;
    return this;
  }

   /**
   * Total number of results (often this list represents just a single page)
   * @return total
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TOTAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getTotal() {
    return total;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTotal(Long total) {
    this.total = total;
  }


  public ResultListTerm parameters(SearchParameters parameters) {
    this.parameters = parameters;
    return this;
  }

   /**
   * Get parameters
   * @return parameters
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SearchParameters getParameters() {
    return parameters;
  }


  @JsonProperty(JSON_PROPERTY_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setParameters(SearchParameters parameters) {
    this.parameters = parameters;
  }


  public ResultListTerm items(List<Term> items) {
    this.items = items;
    return this;
  }

  public ResultListTerm addItemsItem(Term itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * items of the result list
   * @return items
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Term> getItems() {
    return items;
  }


  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setItems(List<Term> items) {
    this.items = items;
  }


  /**
   * Return true if this ResultListTerm object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResultListTerm resultListTerm = (ResultListTerm) o;
    return Objects.equals(this.total, resultListTerm.total) &&
        Objects.equals(this.parameters, resultListTerm.parameters) &&
        Objects.equals(this.items, resultListTerm.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, parameters, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResultListTerm {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

