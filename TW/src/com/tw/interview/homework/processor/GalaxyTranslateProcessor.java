package com.tw.interview.homework.processor;

import com.tw.interview.homework.exception.InvalidRomanNumberException;
import com.tw.interview.homework.util.ProcessorStub;
import com.tw.interview.homework.util.RomanArabicNumberUtil;
/**
 * how much is pish tegj glob glob ?
 * process Galaxy number to arabic number and display 
 * @author zhuyang
 *
 */
public class GalaxyTranslateProcessor implements IProcessor {

	public String process(String line) throws InvalidRomanNumberException {
		StringBuffer out = new StringBuffer();
		String[] eq = line.split("\\s+is\\s+");
		String rightPart = eq[1];
		rightPart = rightPart.replaceAll("(\\?$)", "");// remove ? pish tegj  glob glob
		String[] keyWords = rightPart.split("\\s+");
		StringBuffer romanStr = new StringBuffer();
		for (int i = 0; i < keyWords.length; i++) {
			romanStr.append(ProcessorStub.Entries.galaMap.get(keyWords[i]).getRomanNumber());
			out.append(keyWords[i]).append(" ");
		}
		//get arabic number by roman number
		int arabicVal = RomanArabicNumberUtil.translateRomanToArabic(romanStr.toString());
		out.append("is ").append(arabicVal);
		return out.toString();
	}

}