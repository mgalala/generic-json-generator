/**
 * 
 */
package org.mgalala.builder;

import java.util.List;

import org.mgalala.builder.dto.Property;
import org.mgalala.builder.entity.FeedbackEntity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author mgalala
 *
 */
public class FeedbackArrayBuilder extends ArrayBuilder<FeedbackEntity> {

	public JsonNode build(Property config, ObjectNode node, List<FeedbackEntity> entity) {
		return null;
	}

}
