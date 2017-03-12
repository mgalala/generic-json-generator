
package org.home.builder.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "value" })
public class Divisor {

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

	public Divisor withAttribute(Attribute value) {
		this.attribute = value;
		return this;
	}

	public Divisor withValue(Integer value) {
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
