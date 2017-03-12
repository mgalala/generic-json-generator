
package org.home.builder.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attribute {

	@JsonProperty("blockType")
	private String blockType;
	@JsonProperty("dataType")
	private String dataType;
	@JsonProperty("name")
	private String name;
	@JsonProperty("mappedFrom")
	private MappedFrom mappedFrom;
	@JsonProperty("items")
	private List<Property> items = null;

	@JsonProperty("uuid")
	private String uuid;

	@JsonProperty("uuid")
	public String getUuid() {
		return uuid;
	}

	@JsonProperty("uuid")
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Attribute withUuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	@JsonProperty("blockType")
	public String getBlockType() {
		return blockType;
	}

	@JsonProperty("blockType")
	public void setBlockType(String blockType) {
		this.blockType = blockType;
	}

	public Attribute withBlockType(String blockType) {
		this.blockType = blockType;
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

	public Attribute withDataType(String dataType) {
		this.dataType = dataType;
		return this;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	public Attribute withName(String name) {
		this.name = name;
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

	public Attribute withMappedFrom(MappedFrom mappedFrom) {
		this.mappedFrom = mappedFrom;
		return this;
	}

	@JsonProperty("items")
	public List<Property> getItems() {
		return items;
	}

	@JsonProperty("items")
	public void setItems(List<Property> items) {
		this.items = items;
	}

	public Attribute withItems(List<Property> items) {
		this.items = items;
		return this;
	}

}
