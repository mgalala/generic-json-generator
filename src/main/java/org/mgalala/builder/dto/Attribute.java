/**
 * 
 */
package org.mgalala.builder.dto;

/**
 * @author mgalala
 *
 */
public class Attribute {

	private String uuid;

	private String name;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Attribute withUuid(String value) {
		setUuid(value);
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Attribute withName(String name) {
		setName(name);
		return this;
	}
}
