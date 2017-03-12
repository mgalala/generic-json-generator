/**
 * 
 */
package org.mgalala.builder.extractor;

import org.mgalala.builder.dto.Calculation;
import org.mgalala.builder.entity.FeedbackEntity;
import org.mgalala.builder.extractor.operation.DivisionOperationForFeedback;
import org.mgalala.builder.extractor.operation.IOperation;

/**
 * @author mgalala
 *
 */
public class FeedbackCalculatorPropertyValueExtractor implements IPropertyValueExtractor<Calculation, FeedbackEntity> {

	public ExtractedValue extract(Calculation calculation, FeedbackEntity entity) {
		IOperation<FeedbackEntity> operation = null;
		switch (calculation.getOperation()) {
		case "division":
			operation = new DivisionOperationForFeedback();
			break;
		default:
		}
		return operation.calculate(calculation, entity);
	}

}
