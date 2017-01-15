package com.tw.interview.homework.processor; 

import java.math.BigDecimal;

import com.tw.interview.homework.exception.InvalidRomanNumberException;
import com.tw.interview.homework.model.GalaxyLanguage;
import com.tw.interview.homework.model.Metal;
import com.tw.interview.homework.util.ProcessorStub;
import com.tw.interview.homework.util.RomanArabicNumberUtil; 

/**
 * glob glob Silver is 34 Credits
 * @author zhuyang
 *
 */
public class NumToUnitProcessor implements IProcessor { 
	
	public String process(String line) throws InvalidRomanNumberException { 
		String[] eq = line.split("\\s+is\\s+");
		String leftPart = eq[0];// glob glob Silver
		String rightPart = eq[1];//34 Credits
		String[] leftPartArr = leftPart.split("\\s+");//glob,glob,Silver
		String[] rightPartArr = rightPart.split("\\s+");//34,Credits
		String metalName = leftPartArr[leftPartArr.length-1];//Silver
		StringBuffer amountRomanNumber =new StringBuffer();
		for(int i=0;i<leftPartArr.length-1;i++ ){//glob,glob
			GalaxyLanguage gala = ProcessorStub.Entries.galaMap.get(leftPartArr[i]);//return GalaxyLanguage
			amountRomanNumber.append(gala.getRomanNumber());
		}
		// total cost for the metal
		String cost = rightPartArr[0];//34		
		//unit name
		String unitName = rightPartArr[rightPartArr.length-1];//Credits
		//create metal object
		Metal matal=new Metal();
		matal.setName(metalName);
		//get metal mount
		int amount = RomanArabicNumberUtil.translateRomanToArabic(amountRomanNumber.toString());
		matal.setUnitName(unitName);
		//get metal unit cose, cost/amount
		BigDecimal unitCost = BigDecimal.valueOf(Integer.parseInt(cost)).divide(BigDecimal.valueOf(amount));
		matal.setUnitCost(unitCost);
		//put metal object into map, key is metal name
		ProcessorStub.Entries.metalMap.put(metalName, matal);
		return null; 
} 

}