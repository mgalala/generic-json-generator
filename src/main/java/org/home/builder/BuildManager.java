package org.home.builder;

import java.util.HashMap;

import org.home.builder.dto.Attribute;
import org.home.builder.dto.Calculation;
import org.home.builder.dto.Dividend;
import org.home.builder.dto.Divisor;
import org.home.builder.dto.Property;
import org.home.builder.dto.MappedFrom;
import org.home.builder.entity.FeedbackEntity;
import org.home.builder.entity.FeedbackFieldValueEntity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BuildManager {
	private ObjectMapper objectMapper = new ObjectMapper();

	public JsonNode build() {
		HashMap<String, FeedbackFieldValueEntity> hashMap = new HashMap<String, FeedbackFieldValueEntity>();
		hashMap.put("nps-score-field-uuid",
				new FeedbackFieldValueEntity().withFieldUuid("nps-score-field-uuid").withValue("10"));

		ItemBuilder itemBuilder = new ItemBuilder();
		Property simple = new Property().withName("v1").withDataType("INTEGER")
				.withMappedFrom(new MappedFrom().withAttribute(new Attribute().withUuid("nps-score-field-uuid")));

		Property complex = new Property().withName("v1_1").withDataType("BIGDECIMAL")
				.withMappedFrom(new MappedFrom().withCalculation(new Calculation()
						.withDividend(new Dividend().withAttribute(new Attribute().withUuid("nps-score-field-uuid")))
						.withOperation("division").withDivisor(new Divisor().withValue(2))));

		FeedbackEntity feedback = new FeedbackEntity().withValues(hashMap).withUuid("feedback-uuid");
		JsonNode simpleNode = itemBuilder.build(simple, objectMapper.createObjectNode(), feedback);

		JsonNode complexNode = itemBuilder.build(complex, objectMapper.createObjectNode(), feedback);

		System.out.println(simpleNode.toString());

		System.out.println(complexNode.toString());

		return null;
	}

	public static void main(String[] args) {
		BuildManager manager = new BuildManager();
		manager.build();
	}
}
