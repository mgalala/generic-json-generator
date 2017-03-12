/**
 * 
 */
package org.mgalala.builder;

import java.util.Collection;

import org.mgalala.builder.dto.Property;

/**
 * @author mgalala
 * @param <E>
 * @param <E>
 * @param <E>
 *
 */
public interface CollectionBuilder<T extends Collection<E>, E> extends IJsonBuilder<Property, T> {

}
