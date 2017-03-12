package org.mgalala.builder.entity;

public class FeedbackFieldValueEntity {

	private String fieldUuid;
	private String value;

	public FeedbackFieldValueEntity withFieldUuid(String fieldUuid) {
		setFieldUuid(fieldUuid);
		return this;
	}

	public FeedbackFieldValueEntity withValue(String value) {
		setValue(value);
		return this;
	}

	public String getFieldUuid() {
		return fieldUuid;
	}

	public void setFieldUuid(String fieldUuid) {
		this.fieldUuid = fieldUuid;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
