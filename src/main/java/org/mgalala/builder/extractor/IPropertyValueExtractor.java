/**
 * 
 */
package org.mgalala.builder.extractor;

/**
 * @author mgalala
 *
 */
public interface IPropertyValueExtractor<T, E> {
	ExtractedValue extract(T attribute, E entity);
}
