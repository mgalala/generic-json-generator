package org.home.builder.entity;

import java.util.Map;

public class FeedbackEntity {

	private String uuid;
	private Map<String, FeedbackFieldValueEntity> values;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Map<String, FeedbackFieldValueEntity> getValues() {
		return values;
	}

	public void setValues(Map<String, FeedbackFieldValueEntity> values) {
		this.values = values;
	}

	public FeedbackEntity withValues(Map<String, FeedbackFieldValueEntity> values) {
		setValues(values);
		return this;
	}

	public FeedbackEntity withUuid(String value) {
		setUuid(value);
		return this;
	}

}
