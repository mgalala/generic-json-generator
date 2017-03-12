
package org.home.builder.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "attribute" })
public class MappedFrom {

	@JsonProperty("attribute")
	private Attribute attribute;

	@JsonProperty("calculation")
	private Calculation calculation;

	@JsonProperty("calculation")
	public Calculation getCalculation() {
		return calculation;
	}

	@JsonProperty("calculation")
	public void setCalculation(Calculation calculation) {
		this.calculation = calculation;
	}

	@JsonProperty("attribute")
	public Attribute getAttribute() {
		return attribute;
	}

	@JsonProperty("attribute")
	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public MappedFrom withAttribute(Attribute attribute) {
		this.attribute = attribute;
		return this;
	}

	public MappedFrom withCalculation(Calculation calculation) {
		this.calculation = calculation;
		return this;
	}

}
