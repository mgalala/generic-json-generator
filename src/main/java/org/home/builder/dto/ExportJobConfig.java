
package org.home.builder.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "attributes" })
public class ExportJobConfig {

	@JsonProperty("attributes")
	private List<Attribute> attributes = null;

	@JsonProperty("attributes")
	public List<Attribute> getAttributes() {
		return attributes;
	}

	@JsonProperty("attributes")
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public ExportJobConfig withAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
		return this;
	}

}
