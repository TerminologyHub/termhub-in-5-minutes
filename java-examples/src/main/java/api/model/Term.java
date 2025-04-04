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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import api.invoker.JSON;


/**
 * Represents a name of a concept in a terminology with associated information
 */
@JsonPropertyOrder({
  Term.JSON_PROPERTY_ID,
  Term.JSON_PROPERTY_CONFIDENCE,
  Term.JSON_PROPERTY_MODIFIED,
  Term.JSON_PROPERTY_CREATED,
  Term.JSON_PROPERTY_MODIFIED_BY,
  Term.JSON_PROPERTY_LOCAL,
  Term.JSON_PROPERTY_ACTIVE,
  Term.JSON_PROPERTY_NAME,
  Term.JSON_PROPERTY_TERMINOLOGY,
  Term.JSON_PROPERTY_VERSION,
  Term.JSON_PROPERTY_PUBLISHER,
  Term.JSON_PROPERTY_COMPONENT_ID,
  Term.JSON_PROPERTY_CODE,
  Term.JSON_PROPERTY_CONCEPT_ID,
  Term.JSON_PROPERTY_DESCRIPTOR_ID,
  Term.JSON_PROPERTY_LOCALE_MAP,
  Term.JSON_PROPERTY_TYPE,
  Term.JSON_PROPERTY_ATTRIBUTES
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-03T12:36:52.969136900-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class Term {
  public static final String JSON_PROPERTY_ID = "id";
  private UUID id;

  public static final String JSON_PROPERTY_CONFIDENCE = "confidence";
  private Double confidence;

  public static final String JSON_PROPERTY_MODIFIED = "modified";
  private OffsetDateTime modified;

  public static final String JSON_PROPERTY_CREATED = "created";
  private OffsetDateTime created;

  public static final String JSON_PROPERTY_MODIFIED_BY = "modifiedBy";
  private String modifiedBy;

  public static final String JSON_PROPERTY_LOCAL = "local";
  private Boolean local;

  public static final String JSON_PROPERTY_ACTIVE = "active";
  private Boolean active;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_TERMINOLOGY = "terminology";
  private String terminology;

  public static final String JSON_PROPERTY_VERSION = "version";
  private String version;

  public static final String JSON_PROPERTY_PUBLISHER = "publisher";
  private String publisher;

  public static final String JSON_PROPERTY_COMPONENT_ID = "componentId";
  private String componentId;

  public static final String JSON_PROPERTY_CODE = "code";
  private String code;

  public static final String JSON_PROPERTY_CONCEPT_ID = "conceptId";
  private String conceptId;

  public static final String JSON_PROPERTY_DESCRIPTOR_ID = "descriptorId";
  private String descriptorId;

  public static final String JSON_PROPERTY_LOCALE_MAP = "localeMap";
  private Map<String, Boolean> localeMap = new HashMap<>();

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_ATTRIBUTES = "attributes";
  private Map<String, String> attributes = new HashMap<>();

  public Term() { 
  }

  public Term id(UUID id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier
   * @return id
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public UUID getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(UUID id) {
    this.id = id;
  }


  public Term confidence(Double confidence) {
    this.confidence = confidence;
    return this;
  }

   /**
   * Confidence value (for use with search results)
   * @return confidence
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getConfidence() {
    return confidence;
  }


  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConfidence(Double confidence) {
    this.confidence = confidence;
  }


  public Term modified(OffsetDateTime modified) {
    this.modified = modified;
    return this;
  }

   /**
   * Last modified date
   * @return modified
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MODIFIED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getModified() {
    return modified;
  }


  @JsonProperty(JSON_PROPERTY_MODIFIED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setModified(OffsetDateTime modified) {
    this.modified = modified;
  }


  public Term created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

   /**
   * Created date
   * @return created
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CREATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCreated() {
    return created;
  }


  @JsonProperty(JSON_PROPERTY_CREATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }


  public Term modifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
    return this;
  }

   /**
   * Last modified by
   * @return modifiedBy
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MODIFIED_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getModifiedBy() {
    return modifiedBy;
  }


  @JsonProperty(JSON_PROPERTY_MODIFIED_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }


  public Term local(Boolean local) {
    this.local = local;
    return this;
  }

   /**
   * Indicates whether this data element is locally created
   * @return local
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LOCAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getLocal() {
    return local;
  }


  @JsonProperty(JSON_PROPERTY_LOCAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocal(Boolean local) {
    this.local = local;
  }


  public Term active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * Indicates whether or not the component is active
   * @return active
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ACTIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getActive() {
    return active;
  }


  @JsonProperty(JSON_PROPERTY_ACTIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setActive(Boolean active) {
    this.active = active;
  }


  public Term name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name associated with this term
   * @return name
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }


  public Term terminology(String terminology) {
    this.terminology = terminology;
    return this;
  }

   /**
   * Terminology abbreviation, e.g. \&quot;SNOMEDCT\&quot;
   * @return terminology
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TERMINOLOGY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTerminology() {
    return terminology;
  }


  @JsonProperty(JSON_PROPERTY_TERMINOLOGY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTerminology(String terminology) {
    this.terminology = terminology;
  }


  public Term version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Terminology version, e.g. \&quot;20230901\&quot;
   * @return version
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getVersion() {
    return version;
  }


  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVersion(String version) {
    this.version = version;
  }


  public Term publisher(String publisher) {
    this.publisher = publisher;
    return this;
  }

   /**
   * Terminology publisher, e.g. \&quot;SNOMEDCT\&quot;
   * @return publisher
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PUBLISHER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPublisher() {
    return publisher;
  }


  @JsonProperty(JSON_PROPERTY_PUBLISHER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }


  public Term componentId(String componentId) {
    this.componentId = componentId;
    return this;
  }

   /**
   * Identifier for this object in the published source terminology
   * @return componentId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_COMPONENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getComponentId() {
    return componentId;
  }


  @JsonProperty(JSON_PROPERTY_COMPONENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setComponentId(String componentId) {
    this.componentId = componentId;
  }


  public Term code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Code of the concept containing this term
   * @return code
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCode() {
    return code;
  }


  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCode(String code) {
    this.code = code;
  }


  public Term conceptId(String conceptId) {
    this.conceptId = conceptId;
    return this;
  }

   /**
   * Concept id of the concept containing this term (typically this is the same as the code, but may be different for some terminologies)
   * @return conceptId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CONCEPT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getConceptId() {
    return conceptId;
  }


  @JsonProperty(JSON_PROPERTY_CONCEPT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConceptId(String conceptId) {
    this.conceptId = conceptId;
  }


  public Term descriptorId(String descriptorId) {
    this.descriptorId = descriptorId;
    return this;
  }

   /**
   * Descriptor id of the concept containing this term (only relevant for termionlogies that define descriptor codes)
   * @return descriptorId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DESCRIPTOR_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescriptorId() {
    return descriptorId;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTOR_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescriptorId(String descriptorId) {
    this.descriptorId = descriptorId;
  }


  public Term localeMap(Map<String, Boolean> localeMap) {
    this.localeMap = localeMap;
    return this;
  }

  public Term putLocaleMapItem(String key, Boolean localeMapItem) {
    if (this.localeMap == null) {
      this.localeMap = new HashMap<>();
    }
    this.localeMap.put(key, localeMapItem);
    return this;
  }

   /**
   * Map of language (optionally with locale) to true/false indicating whether this term is the preferred term in that language or not.  An entrywith true indicates that it is preferred in that language. An entry with false indicates that it is valid for that language but not preferred.
   * @return localeMap
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LOCALE_MAP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, Boolean> getLocaleMap() {
    return localeMap;
  }


  @JsonProperty(JSON_PROPERTY_LOCALE_MAP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocaleMap(Map<String, Boolean> localeMap) {
    this.localeMap = localeMap;
  }


  public Term type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Term type, e.g. \&quot;PT\&quot; or \&quot;900000000000013009\&quot;
   * @return type
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(String type) {
    this.type = type;
  }


  public Term attributes(Map<String, String> attributes) {
    this.attributes = attributes;
    return this;
  }

  public Term putAttributesItem(String key, String attributesItem) {
    if (this.attributes == null) {
      this.attributes = new HashMap<>();
    }
    this.attributes.put(key, attributesItem);
    return this;
  }

   /**
   * Key/value pairs associated with this object
   * @return attributes
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, String> getAttributes() {
    return attributes;
  }


  @JsonProperty(JSON_PROPERTY_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAttributes(Map<String, String> attributes) {
    this.attributes = attributes;
  }


  /**
   * Return true if this Term object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Term term = (Term) o;
    return Objects.equals(this.id, term.id) &&
        Objects.equals(this.confidence, term.confidence) &&
        Objects.equals(this.modified, term.modified) &&
        Objects.equals(this.created, term.created) &&
        Objects.equals(this.modifiedBy, term.modifiedBy) &&
        Objects.equals(this.local, term.local) &&
        Objects.equals(this.active, term.active) &&
        Objects.equals(this.name, term.name) &&
        Objects.equals(this.terminology, term.terminology) &&
        Objects.equals(this.version, term.version) &&
        Objects.equals(this.publisher, term.publisher) &&
        Objects.equals(this.componentId, term.componentId) &&
        Objects.equals(this.code, term.code) &&
        Objects.equals(this.conceptId, term.conceptId) &&
        Objects.equals(this.descriptorId, term.descriptorId) &&
        Objects.equals(this.localeMap, term.localeMap) &&
        Objects.equals(this.type, term.type) &&
        Objects.equals(this.attributes, term.attributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, confidence, modified, created, modifiedBy, local, active, name, terminology, version, publisher, componentId, code, conceptId, descriptorId, localeMap, type, attributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Term {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    modifiedBy: ").append(toIndentedString(modifiedBy)).append("\n");
    sb.append("    local: ").append(toIndentedString(local)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    terminology: ").append(toIndentedString(terminology)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    publisher: ").append(toIndentedString(publisher)).append("\n");
    sb.append("    componentId: ").append(toIndentedString(componentId)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    conceptId: ").append(toIndentedString(conceptId)).append("\n");
    sb.append("    descriptorId: ").append(toIndentedString(descriptorId)).append("\n");
    sb.append("    localeMap: ").append(toIndentedString(localeMap)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
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

