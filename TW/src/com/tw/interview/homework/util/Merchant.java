package com.tw.interview.homework.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tw.interview.homework.exception.InvalidRomanNumberException;
import com.tw.interview.homework.factory.ProcessorFactory;
import com.tw.interview.homework.model.PatternObject;
import com.tw.interview.homework.processor.IProcessor;

public class Merchant {

	private static final String NUM_NUM_EQ = "^([A-Za-z]+) is ([A-Za-z]+)$"; //glob is I 	
	private static final String NUM_UNIT_EQ = "^([A-Za-z]+)([A-Za-z\\s]*) is ([0-9]+) ([A-Za-z]+)$";//glob prok Gold is 57800 Credits
	private static final String GALAXY_TRANSLATE_QUESTION = "^how much is (([A-Za-z\\s])+)\\?$";//how much is pish tegj glob glob ?
	private static final String METAL_COST_QUESTION = "^how many ([A-Za-z]+) is (([A-Za-z\\s])+)\\?$";//how many Points is glob prok Silver ?
	private static PatternObject patterns[];
	private static List<String> outputs;
	public static void process(String line) throws InvalidRomanNumberException {
		/**get phrase type*/
		PatternObject.Type type = getType(line);
		/**get processor instance*/
		IProcessor processor = ProcessorFactory.INSTANCE.getProcessor(type);
		ProcessorStub stub = new ProcessorStub(processor);
		String out = stub.process(line);
		if (out != null && !"".equals(out.trim())) {
			outputs.add(out);
		}
	}

	private static PatternObject.Type getType(String line) {
		PatternObject.Type type = PatternObject.Type.NOIDEA;
		for (PatternObject p : patterns) {
			if (line.matches(p.getPattern())) {
				type = p.getType();
				break;
			}
		}
		return type;
	}

	static {
		outputs=new ArrayList<String>();
		patterns = new PatternObject[4];
		patterns[0] = new PatternObject(NUM_NUM_EQ, PatternObject.Type.NUM_NUM_EQ);
		patterns[1] = new PatternObject(NUM_UNIT_EQ, PatternObject.Type.NUM_UNIT_EQ);
		patterns[2] = new PatternObject(GALAXY_TRANSLATE_QUESTION, PatternObject.Type.GALAXY_TRANSLATE_QUESTION);
		patterns[3] = new PatternObject(METAL_COST_QUESTION, PatternObject.Type.METAL_COST_QUESTION);
	}

	public static List<String> calculate(String inputFilePath) {
		File inputFile = null;
		BufferedReader br = null;
		try {
			inputFile = new File(inputFilePath);
			br = new BufferedReader(new FileReader(inputFile));
			String line = "";
			while ((line = br.readLine()) != null && (!"".equals(line.trim()))) {
				process(line);
			}
			return outputs;
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		} catch (InvalidRomanNumberException e) {
			System.err.println(e);
		}
		return outputs;
		
		
	}
}