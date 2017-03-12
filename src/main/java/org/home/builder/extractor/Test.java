package org.home.builder.extractor;

public class Test {
	public static void main(String[] args) {
		ExtractedValue ex = new ExtractedValue().value("5");
		System.out.println(ex.as(Integer.class));
	}
}
