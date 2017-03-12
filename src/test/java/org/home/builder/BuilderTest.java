/**
 * 
 */
package org.home.builder;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import org.mgalala.builder.FeedbackArrayBuilder;
import org.mgalala.builder.FeedbackFieldBuilder;
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
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * @author mgalala
 *
 */
public class BuilderTest {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void buildArray() {
		HashMap<String, FeedbackFieldValueEntity> hashMap = new HashMap<String, FeedbackFieldValueEntity>();
		hashMap.put("nps-score-field-uuid",
				new FeedbackFieldValueEntity().withFieldUuid("nps-score-field-uuid").withValue("10"));
		hashMap.put("comment-field-uuid",
				new FeedbackFieldValueEntity().withFieldUuid("comment-field-uuid").withValue("super"));

		FeedbackArrayBuilder builder = new FeedbackArrayBuilder();

		Property simple = new Property().withName("v1").withBlockType("FIELD").withDataType("INTEGER")
				.withMappedFrom(new MappedFrom().withAttribute(new Attribute().withUuid("nps-score-field-uuid")));

		Property text = new Property().withName("v2").withBlockType("FIELD").withDataType("TEXT")
				.withMappedFrom(new MappedFrom().withAttribute(new Attribute().withUuid("comment-field-uuid")));

		Property complex = new Property().withName("v1_1").withBlockType("FIELD").withDataType("BIGDECIMAL")
				.withMappedFrom(new MappedFrom().withCalculation(new Calculation()
						.withDividend(new Dividend().withAttribute(new Attribute().withUuid("nps-score-field-uuid")))
						.withOperation("division").withDivisor(new Divisor().withValue(2))));

		Property list = new Property().withName("feedbacks").withBlockType("collection").withDataType("array")
				.withproperties(Arrays.asList(simple, text, complex));

		FeedbackEntity feedback = new FeedbackEntity().withValues(hashMap).withUuid("feedback-uuid");

		ArrayNode feedbacks = builder.build(list, objectMapper.createArrayNode(), Arrays.asList(feedback));

		Assert.assertNotNull(feedbacks);

		Assert.assertEquals(1, feedbacks.size());

	}

	@Test
	public void buildField() {
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

		Assert.assertNotNull(simpleNode.toString());

		Assert.assertNotNull(textNode.toString());

		Assert.assertNotNull(complexNode.toString());
	}

}
