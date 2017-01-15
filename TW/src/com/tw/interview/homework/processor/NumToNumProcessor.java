package com.tw.interview.homework.processor;

import com.tw.interview.homework.model.GalaxyLanguage;
import com.tw.interview.homework.util.ProcessorStub;
/**
 * glob is I
 *  
 * @author zhuyang
 *
 */
public class NumToNumProcessor implements IProcessor {

	
	public String process(String line) {
		String[] eq = line.split("\\s+is\\s+");
		String galaNumber = eq[0];// glob
		String galaRomanNumber = eq[1];// I
		GalaxyLanguage gala = new GalaxyLanguage();
		gala.setGalaxyNumber(galaNumber);
		gala.setRomanNumber(galaRomanNumber);
		/**put @GalaxyLanguage into a map,key is the galaxy number name*/
		ProcessorStub.Entries.galaMap.put(galaNumber, gala);
		return null;
	}

}