/**
 * 
 */
package org.mgalala.builder;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author mgalala
 *
 */
public interface IJsonBuilder<C, J extends JsonNode, E> {
	J build(C config, J node, E entity);
}
