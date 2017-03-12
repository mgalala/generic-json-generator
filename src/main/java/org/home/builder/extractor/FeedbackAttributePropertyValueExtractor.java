/**
 * 
 */
package org.home.builder.extractor;

import org.home.builder.dto.Attribute;
import org.home.builder.entity.FeedbackEntity;
import org.home.builder.entity.FeedbackFieldValueEntity;

/**
 * @author mgalala
 *
 */
public class FeedbackAttributePropertyValueExtractor implements IPropertyValueExtractor<Attribute, FeedbackEntity> {

	public ExtractedValue extract(Attribute attribute, FeedbackEntity entity) {
		FeedbackFieldValueEntity feedbackFieldValueEntity = entity.getValues().get(attribute.getUuid());
		return new ExtractedValue().value(feedbackFieldValueEntity.getValue());
	}

}
