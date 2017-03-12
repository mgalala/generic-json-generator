/**
 * 
 */
package org.mgalala.builder.extractor.operation;

import org.mgalala.builder.dto.Calculation;
import org.mgalala.builder.extractor.ExtractedValue;

/**
 * @author mgalala
 *
 */
public interface IOperation<E> {
	ExtractedValue calculate(Calculation calculation, E entity);

}
