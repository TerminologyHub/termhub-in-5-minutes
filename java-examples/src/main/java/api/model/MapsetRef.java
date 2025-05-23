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
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import api.invoker.JSON;


/**
 * MapsetRef
 */
@JsonPropertyOrder({
  MapsetRef.JSON_PROPERTY_ID,
  MapsetRef.JSON_PROPERTY_CONFIDENCE,
  MapsetRef.JSON_PROPERTY_MODIFIED,
  MapsetRef.JSON_PROPERTY_CREATED,
  MapsetRef.JSON_PROPERTY_MODIFIED_BY,
  MapsetRef.JSON_PROPERTY_LOCAL,
  MapsetRef.JSON_PROPERTY_ACTIVE,
  MapsetRef.JSON_PROPERTY_ABBREVIATION,
  MapsetRef.JSON_PROPERTY_NAME,
  MapsetRef.JSON_PROPERTY_VERSION,
  MapsetRef.JSON_PROPERTY_PUBLISHER,
  MapsetRef.JSON_PROPERTY_LATEST,
  MapsetRef.JSON_PROPERTY_LOADED,
  MapsetRef.JSON_PROPERTY_CODE,
  MapsetRef.JSON_PROPERTY_FROM_PUBLISHER,
  MapsetRef.JSON_PROPERTY_FROM_TERMINOLOGY,
  MapsetRef.JSON_PROPERTY_FROM_VERSION,
  MapsetRef.JSON_PROPERTY_TO_PUBLISHER,
  MapsetRef.JSON_PROPERTY_TO_TERMINOLOGY,
  MapsetRef.JSON_PROPERTY_TO_VERSION
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-04T13:11:42.646293800-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class MapsetRef {
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

  public static final String JSON_PROPERTY_ABBREVIATION = "abbreviation";
  private String abbreviation;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_VERSION = "version";
  private String version;

  public static final String JSON_PROPERTY_PUBLISHER = "publisher";
  private String publisher;

  public static final String JSON_PROPERTY_LATEST = "latest";
  private Boolean latest;

  public static final String JSON_PROPERTY_LOADED = "loaded";
  private Boolean loaded;

  public static final String JSON_PROPERTY_CODE = "code";
  private String code;

  public static final String JSON_PROPERTY_FROM_PUBLISHER = "fromPublisher";
  private String fromPublisher;

  public static final String JSON_PROPERTY_FROM_TERMINOLOGY = "fromTerminology";
  private String fromTerminology;

  public static final String JSON_PROPERTY_FROM_VERSION = "fromVersion";
  private String fromVersion;

  public static final String JSON_PROPERTY_TO_PUBLISHER = "toPublisher";
  private String toPublisher;

  public static final String JSON_PROPERTY_TO_TERMINOLOGY = "toTerminology";
  private String toTerminology;

  public static final String JSON_PROPERTY_TO_VERSION = "toVersion";
  private String toVersion;

  public MapsetRef() { 
  }

  public MapsetRef id(UUID id) {
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


  public MapsetRef confidence(Double confidence) {
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


  public MapsetRef modified(OffsetDateTime modified) {
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


  public MapsetRef created(OffsetDateTime created) {
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


  public MapsetRef modifiedBy(String modifiedBy) {
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


  public MapsetRef local(Boolean local) {
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


  public MapsetRef active(Boolean active) {
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


  public MapsetRef abbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
    return this;
  }

   /**
   * Terminology abbreviation, e.g. \&quot;SNOMEDCT\&quot;
   * @return abbreviation
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ABBREVIATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAbbreviation() {
    return abbreviation;
  }


  @JsonProperty(JSON_PROPERTY_ABBREVIATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }


  public MapsetRef name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
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


  public MapsetRef version(String version) {
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


  public MapsetRef publisher(String publisher) {
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


  public MapsetRef latest(Boolean latest) {
    this.latest = latest;
    return this;
  }

   /**
   * Indicates whether this is the latest version of the terminology
   * @return latest
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LATEST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getLatest() {
    return latest;
  }


  @JsonProperty(JSON_PROPERTY_LATEST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLatest(Boolean latest) {
    this.latest = latest;
  }


  public MapsetRef loaded(Boolean loaded) {
    this.loaded = loaded;
    return this;
  }

   /**
   * Indicates whether this is the version of the terminology is loaded
   * @return loaded
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LOADED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getLoaded() {
    return loaded;
  }


  @JsonProperty(JSON_PROPERTY_LOADED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLoaded(Boolean loaded) {
    this.loaded = loaded;
  }


  public MapsetRef code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Mapset code
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


  public MapsetRef fromPublisher(String fromPublisher) {
    this.fromPublisher = fromPublisher;
    return this;
  }

   /**
   * Get fromPublisher
   * @return fromPublisher
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FROM_PUBLISHER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFromPublisher() {
    return fromPublisher;
  }


  @JsonProperty(JSON_PROPERTY_FROM_PUBLISHER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFromPublisher(String fromPublisher) {
    this.fromPublisher = fromPublisher;
  }


  public MapsetRef fromTerminology(String fromTerminology) {
    this.fromTerminology = fromTerminology;
    return this;
  }

   /**
   * Terminology abbreviation that maps in this set are mapped from, e.g. \&quot;SNOMEDCT\&quot;
   * @return fromTerminology
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FROM_TERMINOLOGY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFromTerminology() {
    return fromTerminology;
  }


  @JsonProperty(JSON_PROPERTY_FROM_TERMINOLOGY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFromTerminology(String fromTerminology) {
    this.fromTerminology = fromTerminology;
  }


  public MapsetRef fromVersion(String fromVersion) {
    this.fromVersion = fromVersion;
    return this;
  }

   /**
   * Terminology version that maps in this set are mapped from, e.g. \&quot;20230901\&quot;
   * @return fromVersion
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FROM_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFromVersion() {
    return fromVersion;
  }


  @JsonProperty(JSON_PROPERTY_FROM_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFromVersion(String fromVersion) {
    this.fromVersion = fromVersion;
  }


  public MapsetRef toPublisher(String toPublisher) {
    this.toPublisher = toPublisher;
    return this;
  }

   /**
   * Get toPublisher
   * @return toPublisher
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TO_PUBLISHER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getToPublisher() {
    return toPublisher;
  }


  @JsonProperty(JSON_PROPERTY_TO_PUBLISHER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setToPublisher(String toPublisher) {
    this.toPublisher = toPublisher;
  }


  public MapsetRef toTerminology(String toTerminology) {
    this.toTerminology = toTerminology;
    return this;
  }

   /**
   * Terminology abbreviation that maps in this set are mapped to, e.g. \&quot;SNOMEDCT\&quot;
   * @return toTerminology
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TO_TERMINOLOGY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getToTerminology() {
    return toTerminology;
  }


  @JsonProperty(JSON_PROPERTY_TO_TERMINOLOGY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setToTerminology(String toTerminology) {
    this.toTerminology = toTerminology;
  }


  public MapsetRef toVersion(String toVersion) {
    this.toVersion = toVersion;
    return this;
  }

   /**
   * Terminology version that maps in this set are mapped to, e.g. \&quot;20230901\&quot;
   * @return toVersion
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TO_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getToVersion() {
    return toVersion;
  }


  @JsonProperty(JSON_PROPERTY_TO_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setToVersion(String toVersion) {
    this.toVersion = toVersion;
  }


  /**
   * Return true if this MapsetRef object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MapsetRef mapsetRef = (MapsetRef) o;
    return Objects.equals(this.id, mapsetRef.id) &&
        Objects.equals(this.confidence, mapsetRef.confidence) &&
        Objects.equals(this.modified, mapsetRef.modified) &&
        Objects.equals(this.created, mapsetRef.created) &&
        Objects.equals(this.modifiedBy, mapsetRef.modifiedBy) &&
        Objects.equals(this.local, mapsetRef.local) &&
        Objects.equals(this.active, mapsetRef.active) &&
        Objects.equals(this.abbreviation, mapsetRef.abbreviation) &&
        Objects.equals(this.name, mapsetRef.name) &&
        Objects.equals(this.version, mapsetRef.version) &&
        Objects.equals(this.publisher, mapsetRef.publisher) &&
        Objects.equals(this.latest, mapsetRef.latest) &&
        Objects.equals(this.loaded, mapsetRef.loaded) &&
        Objects.equals(this.code, mapsetRef.code) &&
        Objects.equals(this.fromPublisher, mapsetRef.fromPublisher) &&
        Objects.equals(this.fromTerminology, mapsetRef.fromTerminology) &&
        Objects.equals(this.fromVersion, mapsetRef.fromVersion) &&
        Objects.equals(this.toPublisher, mapsetRef.toPublisher) &&
        Objects.equals(this.toTerminology, mapsetRef.toTerminology) &&
        Objects.equals(this.toVersion, mapsetRef.toVersion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, confidence, modified, created, modifiedBy, local, active, abbreviation, name, version, publisher, latest, loaded, code, fromPublisher, fromTerminology, fromVersion, toPublisher, toTerminology, toVersion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MapsetRef {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    modifiedBy: ").append(toIndentedString(modifiedBy)).append("\n");
    sb.append("    local: ").append(toIndentedString(local)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    abbreviation: ").append(toIndentedString(abbreviation)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    publisher: ").append(toIndentedString(publisher)).append("\n");
    sb.append("    latest: ").append(toIndentedString(latest)).append("\n");
    sb.append("    loaded: ").append(toIndentedString(loaded)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    fromPublisher: ").append(toIndentedString(fromPublisher)).append("\n");
    sb.append("    fromTerminology: ").append(toIndentedString(fromTerminology)).append("\n");
    sb.append("    fromVersion: ").append(toIndentedString(fromVersion)).append("\n");
    sb.append("    toPublisher: ").append(toIndentedString(toPublisher)).append("\n");
    sb.append("    toTerminology: ").append(toIndentedString(toTerminology)).append("\n");
    sb.append("    toVersion: ").append(toIndentedString(toVersion)).append("\n");
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

