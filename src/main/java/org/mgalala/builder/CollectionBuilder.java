/**
 * 
 */
package org.mgalala.builder;

import java.util.Collection;

import org.mgalala.builder.dto.Property;

import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * @author mgalala
 * @param <E>
 * @param <E>
 * @param <E>
 *
 */
public interface CollectionBuilder<T extends Collection<E>, E> extends IJsonBuilder<Property, ArrayNode, T> {

}
