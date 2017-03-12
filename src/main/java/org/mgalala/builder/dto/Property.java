
package org.mgalala.builder.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "blockType", "name", "dataType", "mappedFrom" })
public class Property {

	@JsonProperty("name")
	private String name;

	@JsonProperty("blockType")
	private String blockType;

	@JsonProperty("dataType")
	private String dataType;

	@JsonProperty("mappedFrom")
	private MappedFrom mappedFrom;

	@JsonProperty("properties")
	private List<Property> properties = null;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	public Property withName(String name) {
		this.name = name;
		return this;
	}

	@JsonProperty("dataType")
	public String getDataType() {
		return dataType;
	}

	@JsonProperty("dataType")
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Property withDataType(String dataType) {
		this.dataType = dataType;
		return this;
	}

	@JsonProperty("mappedFrom")
	public MappedFrom getMappedFrom() {
		return mappedFrom;
	}

	@JsonProperty("mappedFrom")
	public void setMappedFrom(MappedFrom mappedFrom) {
		this.mappedFrom = mappedFrom;
	}

	public Property withMappedFrom(MappedFrom mappedFrom) {
		this.mappedFrom = mappedFrom;
		return this;
	}

	@JsonProperty("properties")
	public List<Property> getProperties() {
		return properties;
	}

	@JsonProperty("properties")
	public void setProperties(List<Property> items) {
		this.properties = items;
	}

	public Property withproperties(List<Property> items) {
		this.properties = items;
		return this;
	}

	public String getBlockType() {
		return blockType;
	}

	public void setBlockType(String blockType) {
		this.blockType = blockType;
	}

	public Property withBlockType(String type) {
		this.blockType = type;
		return this;
	}

}
