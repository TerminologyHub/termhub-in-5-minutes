

# Metadata

Represents metadata about a terminology component

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | Unique identifier |  [optional] |
|**confidence** | **Double** | Confidence value (for use with search results) |  [optional] |
|**modified** | **OffsetDateTime** | Last modified date |  [optional] |
|**created** | **OffsetDateTime** | Created date |  [optional] |
|**modifiedBy** | **String** | Last modified by |  [optional] |
|**local** | **Boolean** | Indicates whether this data element is locally created |  [optional] |
|**active** | **Boolean** | Indicates whether or not the component is active |  [optional] |
|**terminology** | **String** | Terminology abbreviation, e.g. \&quot;SNOMEDCT\&quot; |  [optional] |
|**version** | **String** | Terminology version, e.g. \&quot;20230901\&quot; |  [optional] |
|**publisher** | **String** | Terminology publisher, e.g. \&quot;SNOMEDCT\&quot; |  [optional] |
|**model** | [**ModelEnum**](#ModelEnum) | Model object that this applies to |  [optional] |
|**field** | [**FieldEnum**](#FieldEnum) | Field of model object that this applies to |  [optional] |
|**code** | **String** | Abbreviated code for a metadata item that has a longer name, e.g. \&quot;PT\&quot; for \&quot;Preferred term\&quot; |  [optional] |
|**name** | **String** | Longer name of a metadata item |  [optional] |
|**rank** | **Integer** | Rank of this relative to other similar kinds of metadata (primarily used for term type ranking) |  [optional] |
|**attributes** | **Map&lt;String, String&gt;** | Attribute key/value pairs associated with the concept |  [optional] |



## Enum: ModelEnum

| Name | Value |
|---- | -----|
| CONCEPT | &quot;concept&quot; |
| TERM | &quot;term&quot; |
| INDEXTERM | &quot;indexTerm&quot; |
| DEFINITION | &quot;definition&quot; |
| RELATIONSHIP | &quot;relationship&quot; |
| TREEPOSITION | &quot;treePosition&quot; |
| MAPPING | &quot;mapping&quot; |
| SUBSET | &quot;subset&quot; |
| MAPSET | &quot;mapset&quot; |
| SEMANTICTYPE | &quot;semanticType&quot; |
| SUBSETMEMBER | &quot;subsetMember&quot; |
| AXIOM | &quot;axiom&quot; |
| INACTIVECONCEPT | &quot;inactiveConcept&quot; |
| INACTIVETERM | &quot;inactiveTerm&quot; |



## Enum: FieldEnum

| Name | Value |
|---- | -----|
| LANGUAGE | &quot;language&quot; |
| TYPE | &quot;type&quot; |
| ADDITIONALTYPE | &quot;additionalType&quot; |
| ATTRIBUTE | &quot;attribute&quot; |
| SEMANTICTYPE | &quot;semanticType&quot; |
| PRECEDENCE | &quot;precedence&quot; |
| CATEGORY | &quot;category&quot; |
| ENTITYTYPE | &quot;entityType&quot; |
| UILABEL | &quot;uiLabel&quot; |
| OTHER | &quot;other&quot; |



