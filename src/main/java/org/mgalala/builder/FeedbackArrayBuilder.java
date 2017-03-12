/**
 * 
 */
package org.mgalala.builder;

import java.util.List;

import org.mgalala.builder.dto.Property;
import org.mgalala.builder.entity.FeedbackEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author mgalala
 *
 */
public class FeedbackArrayBuilder extends ArrayBuilder<FeedbackEntity> {

	private ObjectMapper mapper = new ObjectMapper();

	public ArrayNode build(Property property, ArrayNode node, List<FeedbackEntity> entities) {
		if (null == node) {
			node = mapper.createArrayNode();
		}

		if (!"array".equalsIgnoreCase(property.getDataType())) {
			throw new RuntimeException();
		}

		ObjectNode mappedFeedback = null;
		FeedbackFieldBuilder builder = new FeedbackFieldBuilder();
		for (FeedbackEntity feedbackEntity : entities) {
			mappedFeedback = mapper.createObjectNode();
			for (Property fieldProperty : property.getProperties()) {
				builder.build(fieldProperty, mappedFeedback, feedbackEntity);
			}
			node.add(mappedFeedback);
		}
		return node;
	}

}
