/**
 * 
 */
package org.mgalala.builder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author mgalala
 *
 */
public interface IJsonBuilder<C, E> {
	JsonNode build(C config, ObjectNode node, E entity);
}
