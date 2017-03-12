package org.mgalala.builder;

import java.util.HashMap;

import org.mgalala.builder.dto.Attribute;
import org.mgalala.builder.dto.Calculation;
import org.mgalala.builder.dto.Dividend;
import org.mgalala.builder.dto.Divisor;
import org.mgalala.builder.dto.MappedFrom;
import org.mgalala.builder.dto.Property;
import org.mgalala.builder.entity.FeedbackEntity;
import org.mgalala.builder.entity.FeedbackFieldValueEntity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BuildManager {
	private ObjectMapper objectMapper = new ObjectMapper();

	public JsonNode build() {
		HashMap<String, FeedbackFieldValueEntity> hashMap = new HashMap<String, FeedbackFieldValueEntity>();
		hashMap.put("nps-score-field-uuid",
				new FeedbackFieldValueEntity().withFieldUuid("nps-score-field-uuid").withValue("10"));
		hashMap.put("comment-field-uuid",
				new FeedbackFieldValueEntity().withFieldUuid("comment-field-uuid").withValue("super"));

		FeedbackFieldBuilder itemBuilder = new FeedbackFieldBuilder();

		Property simple = new Property().withName("v1").withBlockType("FIELD").withDataType("INTEGER")
				.withMappedFrom(new MappedFrom().withAttribute(new Attribute().withUuid("nps-score-field-uuid")));

		Property text = new Property().withName("v2").withBlockType("FIELD").withDataType("TEXT")
				.withMappedFrom(new MappedFrom().withAttribute(new Attribute().withUuid("comment-field-uuid")));

		Property complex = new Property().withName("v1_1").withBlockType("FIELD").withDataType("BIGDECIMAL")
				.withMappedFrom(new MappedFrom().withCalculation(new Calculation()
						.withDividend(new Dividend().withAttribute(new Attribute().withUuid("nps-score-field-uuid")))
						.withOperation("division").withDivisor(new Divisor().withValue(2))));

		FeedbackEntity feedback = new FeedbackEntity().withValues(hashMap).withUuid("feedback-uuid");

		JsonNode simpleNode = itemBuilder.build(simple, objectMapper.createObjectNode(), feedback);

		JsonNode textNode = itemBuilder.build(text, objectMapper.createObjectNode(), feedback);

		JsonNode complexNode = itemBuilder.build(complex, objectMapper.createObjectNode(), feedback);

		System.out.println(simpleNode.toString());

		System.out.println(textNode.toString());

		System.out.println(complexNode.toString());

		return null;
	}

	public static void main(String[] args) {
		BuildManager manager = new BuildManager();
		manager.build();
	}
}
