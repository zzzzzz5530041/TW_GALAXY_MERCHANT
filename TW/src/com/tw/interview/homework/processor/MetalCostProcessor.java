package com.tw.interview.homework.processor;

import java.math.BigDecimal;

import com.tw.interview.homework.exception.InvalidRomanNumberException;
import com.tw.interview.homework.model.GalaxyLanguage;
import com.tw.interview.homework.model.Metal;
import com.tw.interview.homework.util.ProcessorStub;
import com.tw.interview.homework.util.RomanArabicNumberUtil;
/**
 * how many Credits is glob prok Silver ?
 * process MetalCost 
 * @author zhuyang
 *
 */
public class MetalCostProcessor implements IProcessor {

	public String process(String line) throws InvalidRomanNumberException {
		StringBuffer out = new StringBuffer();
		String[] eq = line.split("\\s+is\\s+");
		String rightPart = eq[1];
		rightPart = rightPart.replaceAll("(\\?$)", "");//remove "?"-->  glob prok Silver 
		String [] keyWords = rightPart.split("\\s+");
		//get metal name
		String metalName = keyWords[keyWords.length-1];
		StringBuffer amountRomanNumber =new StringBuffer();//store amount roman number
		for(int i=0;i<keyWords.length-1;i++ ){//glob,prok
			GalaxyLanguage gala = ProcessorStub.Entries.galaMap.get(keyWords[i]);//return GalaxyLanguage
			amountRomanNumber.append(gala.getRomanNumber());
			out.append(keyWords[i]).append(" ");
		} 
		//get metal object by metal name from map 
		Metal metal = ProcessorStub.Entries.metalMap.get(metalName);
		//get metal unit cost
		BigDecimal unitCost = metal.getUnitCost();
		//get amount arabic number
		int amount = RomanArabicNumberUtil.translateRomanToArabic(amountRomanNumber.toString());
		//total cost = unitCost*amount
		BigDecimal cost = unitCost.multiply(BigDecimal.valueOf(amount));
		//glob prok Silver is 68 Credits
		String costStr = cost.toString();
		if(costStr.endsWith(".0"))costStr=costStr.substring(0, costStr.lastIndexOf('.'));
		out.append("is ").append(costStr).append(" ").append(metal.getUnitName());
		return out.toString();

	}

}