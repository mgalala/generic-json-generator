/**
 * 
 */
package org.home.builder.extractor;

import java.math.BigDecimal;

/**
 * @author mgalala
 *
 */
public class ExtractedValue {
	private String value;

	public ExtractedValue value(String value) {
		setValue(value);
		return this;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@SuppressWarnings("unchecked")
	public <T> T as(Class<T> clazz) {
		if (null == clazz) {
			return null;
		}
		if (Integer.class == clazz) {
			return (T) new Integer(getValue());
		} else if (BigDecimal.class == clazz) {
			return (T) new BigDecimal(getValue());
		} else if (String.class == clazz) {
			return (T) getValue();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> T as(String dataType) {
		Class<?> classOf = classOf(dataType);
		return (T) as(classOf);
	}

	public Integer asInteger() {
		return new Integer(value);
	}

	public BigDecimal asBigDecimal() {
		return new BigDecimal(value);
	}

	public String asText() {
		return value;
	}

	private Class<?> classOf(String dataType) {
		if (null == dataType) {
			return null;
		}
		if (dataType.equalsIgnoreCase("integer")) {
			return Integer.class;
		} else if (dataType.equalsIgnoreCase("BIGDECIMAL")) {
			return BigDecimal.class;
		} else if (dataType.equalsIgnoreCase("TEXT")) {
			return String.class;
		}
		return null;
	}

}
