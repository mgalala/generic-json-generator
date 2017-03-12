/**
 * 
 */
package org.mgalala.builder;

import org.mgalala.builder.dto.Property;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author mgalala
 * @param <J>
 */
public abstract class FieldBuilder<E> implements IJsonBuilder<Property, ObjectNode, E> {

}
