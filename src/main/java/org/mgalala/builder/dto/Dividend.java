
package org.mgalala.builder.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dividend {

	@JsonProperty("attribute")
	private Attribute attribute;

	@JsonProperty("value")
	private Integer value;

	@JsonProperty("attribute")
	public Attribute getAttribute() {
		return attribute;
	}

	@JsonProperty("uuid")
	public void setAttribute(Attribute uuid) {
		this.attribute = uuid;
	}

	public Dividend withAttribute(Attribute value) {
		this.attribute = value;
		return this;
	}

	public Dividend value(Integer value) {
		setValue(value);
		return this;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
