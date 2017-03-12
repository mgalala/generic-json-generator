/**
 * 
 */
package org.mgalala.builder.extractor;

import org.mgalala.builder.dto.Attribute;
import org.mgalala.builder.entity.FeedbackEntity;
import org.mgalala.builder.entity.FeedbackFieldValueEntity;

/**
 * @author mgalala
 *
 */
public class FeedbackAttributePropertyValueExtractor implements IPropertyValueExtractor<Attribute, FeedbackEntity> {

	public ExtractedValue extract(Attribute attribute, FeedbackEntity entity) {
		FeedbackFieldValueEntity feedbackFieldValueEntity = entity.getValues().get(attribute.getUuid());
		return new ExtractedValue()
				.value(feedbackFieldValueEntity == null ? null : feedbackFieldValueEntity.getValue());
	}

}
