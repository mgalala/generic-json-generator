/**
 * 
 */
package org.home.builder.extractor.operation;

import org.home.builder.dto.Calculation;
import org.home.builder.extractor.ExtractedValue;

/**
 * @author mgalala
 *
 */
public interface IOperation<E> {
	ExtractedValue calculate(Calculation calculation, E entity);

}
