/**
 * 
 */
package org.mgalala.builder;

import org.mgalala.builder.dto.Property;

/**
 * @author mgalala <br/>
 *         iterate first on all feedbacks </br>
 *         for each iteration iterate over properties <br/>
 *         and pass the feedback and property and previously generated node to
 *         this class
 */
public abstract class FieldBuilder<E> implements IJsonBuilder<Property, E> {

}
