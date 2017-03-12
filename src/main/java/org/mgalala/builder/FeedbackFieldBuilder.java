/**
 * 
 */
package org.mgalala.builder;

import org.mgalala.builder.dto.Attribute;
import org.mgalala.builder.dto.Calculation;
import org.mgalala.builder.dto.Property;
import org.mgalala.builder.entity.FeedbackEntity;
import org.mgalala.builder.extractor.ExtractedValue;
import org.mgalala.builder.extractor.FeedbackAttributePropertyValueExtractor;
import org.mgalala.builder.extractor.FeedbackCalculatorPropertyValueExtractor;
import org.mgalala.builder.extractor.IPropertyValueExtractor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author mgalala <br/>
 *         iterate first on all feedbacks </br>
 *         for each iteration iterate over properties <br/>
 *         and pass the feedback and property and previously generated node to
 *         this class
 */
public class FeedbackFieldBuilder extends FieldBuilder<FeedbackEntity> {

	private ObjectMapper mapper = new ObjectMapper();

	public ObjectNode build(Property property, ObjectNode node, FeedbackEntity entity) {
		if (null == property || null == entity) {
			return null;
		}
		if (null == node) {
			node = mapper.createObjectNode();
		}

		ExtractedValue extractedValue = null;

		if (property.getMappedFrom().getAttribute() != null) {
			// standard property mapping
			IPropertyValueExtractor<Attribute, FeedbackEntity> extractor = new FeedbackAttributePropertyValueExtractor();
			extractedValue = extractor.extract(property.getMappedFrom().getAttribute(), entity);
		} else if (property.getMappedFrom().getCalculation() != null) {
			// it is based on calculation
			IPropertyValueExtractor<Calculation, FeedbackEntity> extractor = new FeedbackCalculatorPropertyValueExtractor();
			extractedValue = extractor.extract(property.getMappedFrom().getCalculation(), entity);
		}

		if (property.getDataType().equalsIgnoreCase("integer")) {
			node.put(property.getName(), extractedValue.asInteger());
		} else if (property.getDataType().equalsIgnoreCase("BIGDECIMAL")) {
			node.put(property.getName(), extractedValue.asBigDecimal());
		} else if (property.getDataType().equalsIgnoreCase("TEXT")) {
			node.put(property.getName(), extractedValue.asText());
		}

		// node.putPOJO(property.getName(),
		// extractedValue.as(property.getDataType()));
		return node;
	}

}
