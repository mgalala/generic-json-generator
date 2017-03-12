/**
 * 
 */
package org.home.builder;

import org.home.builder.dto.Attribute;
import org.home.builder.dto.Calculation;
import org.home.builder.dto.Property;
import org.home.builder.entity.FeedbackEntity;
import org.home.builder.extractor.ExtractedValue;
import org.home.builder.extractor.FeedbackAttributePropertyValueExtractor;
import org.home.builder.extractor.FeedbackCalculatorPropertyValueExtractor;
import org.home.builder.extractor.IPropertyValueExtractor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author mgalala <br/>
 *         iterate first on all feedbacks </br>
 *         for each iteration iterate over properties <br/>
 *         and pass the feedback and property and previously generated node to
 *         this class
 */
public class ItemBuilder implements IJsonBuilder<Property, FeedbackEntity> {

	public JsonNode build(Property property, ObjectNode node, FeedbackEntity entity) {
		if (null == property || null == node || null == entity) {
			return null;
		}
		ExtractedValue extractedValue = null;

		if (property.getMappedFrom().getAttribute() != null) {
			// standard attribute mapping
			IPropertyValueExtractor<Attribute, FeedbackEntity> extractor = new FeedbackAttributePropertyValueExtractor();
			extractedValue = extractor.extract(property.getMappedFrom().getAttribute(), entity);
		} else if (property.getMappedFrom().getCalculation() != null) {
			// it is based on calculation
			IPropertyValueExtractor<Calculation, FeedbackEntity> extractor = new FeedbackCalculatorPropertyValueExtractor();
			extractedValue = extractor.extract(property.getMappedFrom().getCalculation(), entity);
		}

		// if (property.getDataType().equalsIgnoreCase("integer")) {
		// node.put(property.getName(), extractedValue.asInteger());
		// } else if (property.getDataType().equalsIgnoreCase("BIGDECIMAL")) {
		// node.put(property.getName(), extractedValue.asBigDecimal());
		// } else if (property.getDataType().equalsIgnoreCase("TEXT")) {
		// node.put(property.getName(), extractedValue.asText());
		// }

		node.putPOJO(property.getName(), extractedValue.as(property.getDataType()));
		return node;
	}

}
