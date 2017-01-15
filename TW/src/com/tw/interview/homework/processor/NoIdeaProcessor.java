package com.tw.interview.homework.processor;

public class NoIdeaProcessor implements IProcessor {

	@Override
	public String process(String line) {

		return "I have no idea what you are talking about";
	}

}