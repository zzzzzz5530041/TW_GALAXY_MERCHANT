package com.tw.interview.homework.util;

import java.util.HashMap;
import java.util.Map;

import com.tw.interview.homework.exception.InvalidRomanNumberException;
import com.tw.interview.homework.model.GalaxyLanguage;
import com.tw.interview.homework.model.Metal;
import com.tw.interview.homework.processor.IProcessor;
/**
 * stub holds Processor instance
 * @author zhuyang
 *
 */
public class ProcessorStub {
	private IProcessor processor;

	public ProcessorStub(IProcessor processor) {
		this.processor = processor;
	}
	/**
	 * 
	 * @param line
	 * @return output
	 * @throws InvalidRomanNumberException
	 */
	public String process(String line) throws InvalidRomanNumberException {
		return this.processor.process(line);
	}
	/**
	 * to store GalaxyLanguage and Metal object
	 * @author zhuyang
	 *
	 */
	public static class Entries {
		public static Map<String, GalaxyLanguage> galaMap = new HashMap<String, GalaxyLanguage>();
		public static Map<String, Metal> metalMap = new HashMap<String, Metal>();
	}
}
