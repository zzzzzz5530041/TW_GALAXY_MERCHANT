package com.tw.interview.homework.model;

public class PatternObject {
	private Type type;
	private String pattern;

	public PatternObject(String pattern, Type type) {
		super();
		this.type = type;
		this.pattern = pattern;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	/**
	 * 
	 * @author zhuyang
	 */
	public static enum Type {
		NUM_NUM_EQ, NUM_UNIT_EQ,GALAXY_TRANSLATE_QUESTION,METAL_COST_QUESTION,NOIDEA
	}
}