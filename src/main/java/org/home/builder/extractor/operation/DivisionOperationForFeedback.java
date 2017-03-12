/**
 * 
 */
package org.home.builder.extractor.operation;

import java.math.BigDecimal;

import org.home.builder.dto.Calculation;
import org.home.builder.entity.FeedbackEntity;
import org.home.builder.extractor.ExtractedValue;
import org.home.builder.extractor.FeedbackAttributePropertyValueExtractor;

/**
 * @author mgalala
 *
 */
public class DivisionOperationForFeedback implements IOperation<FeedbackEntity> {

	@Override
	public ExtractedValue calculate(Calculation calculation, FeedbackEntity entity) {
		BigDecimal dividend = getDividend(calculation, entity);
		BigDecimal divisor = getDivisor(calculation, entity);
		return new ExtractedValue().value(dividend.divide(divisor).toString());
	}

	private BigDecimal getDividend(Calculation calculation, FeedbackEntity entity) {
		BigDecimal dividend = BigDecimal.ZERO;
		if (null != calculation.getDividend().getAttribute()) {
			FeedbackAttributePropertyValueExtractor extractor = new FeedbackAttributePropertyValueExtractor();
			dividend = new BigDecimal(extractor.extract(calculation.getDividend().getAttribute(), entity).getValue());
		} else if (null != calculation.getDividend().getValue()) {
			dividend = new BigDecimal(calculation.getDividend().getValue());
		}
		return dividend;
	}

	private BigDecimal getDivisor(Calculation calculation, FeedbackEntity entity) {
		BigDecimal divisor = BigDecimal.ONE;
		if (null != calculation.getDivisor().getAttribute()) {
			FeedbackAttributePropertyValueExtractor extractor = new FeedbackAttributePropertyValueExtractor();
			divisor = new BigDecimal(extractor.extract(calculation.getDivisor().getAttribute(), entity).getValue());
		} else if (null != calculation.getDivisor().getValue()) {
			divisor = new BigDecimal(calculation.getDivisor().getValue());
			if (divisor.equals(BigDecimal.ZERO)) {
				divisor = BigDecimal.ONE;
			}
		}
		return divisor;
	}

}
