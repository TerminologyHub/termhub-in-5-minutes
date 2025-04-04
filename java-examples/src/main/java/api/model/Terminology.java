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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import api.invoker.JSON;


/**
 * Represents a terminology abbreviation and associated metadata
 */
@JsonPropertyOrder({
  Terminology.JSON_PROPERTY_ID,
  Terminology.JSON_PROPERTY_CONFIDENCE,
  Terminology.JSON_PROPERTY_MODIFIED,
  Terminology.JSON_PROPERTY_CREATED,
  Terminology.JSON_PROPERTY_MODIFIED_BY,
  Terminology.JSON_PROPERTY_LOCAL,
  Terminology.JSON_PROPERTY_ACTIVE,
  Terminology.JSON_PROPERTY_ABBREVIATION,
  Terminology.JSON_PROPERTY_NAME,
  Terminology.JSON_PROPERTY_VERSION,
  Terminology.JSON_PROPERTY_PUBLISHER,
  Terminology.JSON_PROPERTY_LATEST,
  Terminology.JSON_PROPERTY_LOADED,
  Terminology.JSON_PROPERTY_RELEASE_DATE,
  Terminology.JSON_PROPERTY_FAMILY,
  Terminology.JSON_PROPERTY_URI,
  Terminology.JSON_PROPERTY_ATTRIBUTES,
  Terminology.JSON_PROPERTY_ROOTS,
  Terminology.JSON_PROPERTY_CONCEPT_CT,
  Terminology.JSON_PROPERTY_RELATIONSHIP_CT,
  Terminology.JSON_PROPERTY_TREE_POSITION_CT,
  Terminology.JSON_PROPERTY_STATISTICS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-04T13:11:42.646293800-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class Terminology {
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

  public static final String JSON_PROPERTY_RELEASE_DATE = "releaseDate";
  private String releaseDate;

  public static final String JSON_PROPERTY_FAMILY = "family";
  private String family;

  public static final String JSON_PROPERTY_URI = "uri";
  private String uri;

  public static final String JSON_PROPERTY_ATTRIBUTES = "attributes";
  private Map<String, String> attributes = new HashMap<>();

  public static final String JSON_PROPERTY_ROOTS = "roots";
  private List<String> roots = new ArrayList<>();

  public static final String JSON_PROPERTY_CONCEPT_CT = "conceptCt";
  private Long conceptCt;

  public static final String JSON_PROPERTY_RELATIONSHIP_CT = "relationshipCt";
  private Long relationshipCt;

  public static final String JSON_PROPERTY_TREE_POSITION_CT = "treePositionCt";
  private Long treePositionCt;

  public static final String JSON_PROPERTY_STATISTICS = "statistics";
  private Map<String, Integer> statistics = new HashMap<>();

  public Terminology() { 
  }

  public Terminology id(UUID id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier
   * @return id
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public UUID getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(UUID id) {
    this.id = id;
  }


  public Terminology confidence(Double confidence) {
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


  public Terminology modified(OffsetDateTime modified) {
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


  public Terminology created(OffsetDateTime created) {
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


  public Terminology modifiedBy(String modifiedBy) {
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


  public Terminology local(Boolean local) {
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


  public Terminology active(Boolean active) {
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


  public Terminology abbreviation(String abbreviation) {
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


  public Terminology name(String name) {
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


  public Terminology version(String version) {
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


  public Terminology publisher(String publisher) {
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


  public Terminology latest(Boolean latest) {
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


  public Terminology loaded(Boolean loaded) {
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


  public Terminology releaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

   /**
   * YYYY-MM-DD rendering of the release date
   * @return releaseDate
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_RELEASE_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getReleaseDate() {
    return releaseDate;
  }


  @JsonProperty(JSON_PROPERTY_RELEASE_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }


  public Terminology family(String family) {
    this.family = family;
    return this;
  }

   /**
   * Family of related terminologies this one belongs to
   * @return family
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FAMILY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFamily() {
    return family;
  }


  @JsonProperty(JSON_PROPERTY_FAMILY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFamily(String family) {
    this.family = family;
  }


  public Terminology uri(String uri) {
    this.uri = uri;
    return this;
  }

   /**
   * Uri for downloading the terminology
   * @return uri
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_URI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getUri() {
    return uri;
  }


  @JsonProperty(JSON_PROPERTY_URI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUri(String uri) {
    this.uri = uri;
  }


  public Terminology attributes(Map<String, String> attributes) {
    this.attributes = attributes;
    return this;
  }

  public Terminology putAttributesItem(String key, String attributesItem) {
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


  public Terminology roots(List<String> roots) {
    this.roots = roots;
    return this;
  }

  public Terminology addRootsItem(String rootsItem) {
    if (this.roots == null) {
      this.roots = new ArrayList<>();
    }
    this.roots.add(rootsItem);
    return this;
  }

   /**
   * Root codes in the hierarchy
   * @return roots
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ROOTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getRoots() {
    return roots;
  }


  @JsonProperty(JSON_PROPERTY_ROOTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoots(List<String> roots) {
    this.roots = roots;
  }


  public Terminology conceptCt(Long conceptCt) {
    this.conceptCt = conceptCt;
    return this;
  }

   /**
   * Count of number of concepts in the terminology
   * @return conceptCt
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CONCEPT_CT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getConceptCt() {
    return conceptCt;
  }


  @JsonProperty(JSON_PROPERTY_CONCEPT_CT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConceptCt(Long conceptCt) {
    this.conceptCt = conceptCt;
  }


  public Terminology relationshipCt(Long relationshipCt) {
    this.relationshipCt = relationshipCt;
    return this;
  }

   /**
   * Count of number of concept relationships in the terminology
   * @return relationshipCt
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_RELATIONSHIP_CT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getRelationshipCt() {
    return relationshipCt;
  }


  @JsonProperty(JSON_PROPERTY_RELATIONSHIP_CT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRelationshipCt(Long relationshipCt) {
    this.relationshipCt = relationshipCt;
  }


  public Terminology treePositionCt(Long treePositionCt) {
    this.treePositionCt = treePositionCt;
    return this;
  }

   /**
   * Count of number of concept tree positions in the terminology
   * @return treePositionCt
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TREE_POSITION_CT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getTreePositionCt() {
    return treePositionCt;
  }


  @JsonProperty(JSON_PROPERTY_TREE_POSITION_CT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTreePositionCt(Long treePositionCt) {
    this.treePositionCt = treePositionCt;
  }


  public Terminology statistics(Map<String, Integer> statistics) {
    this.statistics = statistics;
    return this;
  }

  public Terminology putStatisticsItem(String key, Integer statisticsItem) {
    if (this.statistics == null) {
      this.statistics = new HashMap<>();
    }
    this.statistics.put(key, statisticsItem);
    return this;
  }

   /**
   * Get statistics
   * @return statistics
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_STATISTICS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, Integer> getStatistics() {
    return statistics;
  }


  @JsonProperty(JSON_PROPERTY_STATISTICS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatistics(Map<String, Integer> statistics) {
    this.statistics = statistics;
  }


  /**
   * Return true if this Terminology object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Terminology terminology = (Terminology) o;
    return Objects.equals(this.id, terminology.id) &&
        Objects.equals(this.confidence, terminology.confidence) &&
        Objects.equals(this.modified, terminology.modified) &&
        Objects.equals(this.created, terminology.created) &&
        Objects.equals(this.modifiedBy, terminology.modifiedBy) &&
        Objects.equals(this.local, terminology.local) &&
        Objects.equals(this.active, terminology.active) &&
        Objects.equals(this.abbreviation, terminology.abbreviation) &&
        Objects.equals(this.name, terminology.name) &&
        Objects.equals(this.version, terminology.version) &&
        Objects.equals(this.publisher, terminology.publisher) &&
        Objects.equals(this.latest, terminology.latest) &&
        Objects.equals(this.loaded, terminology.loaded) &&
        Objects.equals(this.releaseDate, terminology.releaseDate) &&
        Objects.equals(this.family, terminology.family) &&
        Objects.equals(this.uri, terminology.uri) &&
        Objects.equals(this.attributes, terminology.attributes) &&
        Objects.equals(this.roots, terminology.roots) &&
        Objects.equals(this.conceptCt, terminology.conceptCt) &&
        Objects.equals(this.relationshipCt, terminology.relationshipCt) &&
        Objects.equals(this.treePositionCt, terminology.treePositionCt) &&
        Objects.equals(this.statistics, terminology.statistics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, confidence, modified, created, modifiedBy, local, active, abbreviation, name, version, publisher, latest, loaded, releaseDate, family, uri, attributes, roots, conceptCt, relationshipCt, treePositionCt, statistics);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Terminology {\n");
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
    sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
    sb.append("    family: ").append(toIndentedString(family)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    roots: ").append(toIndentedString(roots)).append("\n");
    sb.append("    conceptCt: ").append(toIndentedString(conceptCt)).append("\n");
    sb.append("    relationshipCt: ").append(toIndentedString(relationshipCt)).append("\n");
    sb.append("    treePositionCt: ").append(toIndentedString(treePositionCt)).append("\n");
    sb.append("    statistics: ").append(toIndentedString(statistics)).append("\n");
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

