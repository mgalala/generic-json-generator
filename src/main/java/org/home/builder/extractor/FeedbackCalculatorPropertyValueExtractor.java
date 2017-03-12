/**
 * 
 */
package org.home.builder.extractor;

import org.home.builder.dto.Calculation;
import org.home.builder.entity.FeedbackEntity;
import org.home.builder.extractor.operation.DivisionOperationForFeedback;
import org.home.builder.extractor.operation.IOperation;

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
