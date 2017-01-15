package com.tw.interview.homework.util;

import com.tw.interview.homework.exception.InvalidRomanNumberException;
import com.tw.interview.homework.factory.RomanNumberFactory;
import com.tw.interview.homework.model.RomanNumber;
/**
 * RomanArabicNumberUtil
 * used to validation RomanNumber and translate Roman Number to Arabic number
 * @author zhuyang
 *
 */
public class RomanArabicNumberUtil {

	private RomanArabicNumberUtil() {
	}

	public static int translateRomanToArabic(String romanNumber) throws InvalidRomanNumberException {
		//since roman number from input can be lowercase, so we need to make it uppercase
		romanNumber = romanNumber.toUpperCase();
		//to char eg:MCMXLIV
		char[] romanChars = romanNumber.toCharArray();
		//RomanNumber Instance array
		RomanNumber[] romanNumberObjectArray = getRomanNumberObjects(romanChars);
		if(!isValidRomanNumber(romanNumber)){// if Roman Number is not valid,throw exception
			throw new InvalidRomanNumberException();
		}
		int result = translateRomanToArabic(romanNumberObjectArray);
		return result;
	}
	//MCMXLIV 
	//1000+(1000-100)+(50-10)+(5-1) =  1944
	public static int translateRomanToArabic(RomanNumber[] romanNumberObjectArray) throws InvalidRomanNumberException {
		int result = 0;
		int lastNumber = Integer.MAX_VALUE;
		for (int i = 0; i < romanNumberObjectArray.length; i++) {
			// Not the last number and the number can be subtracted by the following number
			if (i < (romanNumberObjectArray.length - 1) && romanNumberObjectArray[i].isSubtractable(romanNumberObjectArray[i + 1])) {
				int current = romanNumberObjectArray[i + 1].getArabicNumber() - romanNumberObjectArray[i].getArabicNumber();
				if (lastNumber < current) {
					System.err.println("Incorrect order");
					throw new InvalidRomanNumberException();
				}
				result += current;
				lastNumber = current;
				++i;
			} else {
				if (lastNumber < romanNumberObjectArray[i].getArabicNumber()) {
					System.err.println("Incorrect order");
					throw new InvalidRomanNumberException();
				}
				result += romanNumberObjectArray[i].getArabicNumber();
				lastNumber = romanNumberObjectArray[i].getArabicNumber();
			}
		}
		return result;
	}
	public static boolean isValidRomanNumber(String romanNumber)throws InvalidRomanNumberException{
		boolean result = true;
		romanNumber = romanNumber.toUpperCase();
		char[] romanChars = romanNumber.toCharArray();
		//RomanNumber Instance array
		RomanNumber[] romanNumberObjectArray = getRomanNumberObjects(romanChars);
		result =isValidRomanNumber(romanNumberObjectArray);
		return result;
	}
	public static boolean isValidRomanNumber(RomanNumber[] romanNumberObjectArray) {
		boolean result = true;

		// Order validation
		for (int i = 0; i < (romanNumberObjectArray.length - 1); i++) {
			// if current value < next value, and current value can't be subtrated by next value.
			if ((romanNumberObjectArray[i].getArabicNumber() < romanNumberObjectArray[i + 1].getArabicNumber())&& !romanNumberObjectArray[i].isSubtractable(romanNumberObjectArray[i + 1])) {
				System.err.println(romanNumberObjectArray[i].getRomanNumber() + " followed with "
						+ romanNumberObjectArray[i + 1].getRomanNumber() + " is invalid!!!");
				result = false;
			}
		}

		// Max repeat times validation
		for (int i = 0; i < romanNumberObjectArray.length; i++) {//XXXIX
			int repeatTimes = getRepeatTimes(romanNumberObjectArray, romanNumberObjectArray[i].getRomanNumber(), i);
			if (repeatTimes > romanNumberObjectArray[i].getMaxRepeat()) {//if repeat times > currently roman char repeat  times
				System.err.println(romanNumberObjectArray[i].getRomanNumber() + " repeated " + repeatTimes + " times");
				result = false;
			}
		}

		return result;
	}

	private static int getRepeatTimes(RomanNumber[] romanNumberObjectArray, String repeatChar, int startIndex) {
		int repeatTimes = 0;

		if (startIndex == (romanNumberObjectArray.length - 1)|| !repeatChar.equals(romanNumberObjectArray[startIndex + 1].getRomanNumber())) {
			repeatTimes = 1;
		} else {
			repeatTimes++;
			repeatTimes += getRepeatTimes(romanNumberObjectArray, repeatChar, ++startIndex);
		}

		return repeatTimes;
	}
	/**
	 *  
	 * @param romanChars
	 * @return RomanNumber Instance array
	 * @throws InvalidRomanNumberException
	 */
	public static RomanNumber[] getRomanNumberObjects(char[] romanChars) throws InvalidRomanNumberException {
		RomanNumber[] romanNumberObjectArray = new RomanNumber[romanChars.length];

		for (int i = 0; i < romanChars.length; i++) {
			char splitedChar = romanChars[i];
			RomanNumber romanNumberObject = RomanNumberFactory.getRomanNumber(splitedChar);
			romanNumberObjectArray[i] = romanNumberObject;
		}

		return romanNumberObjectArray;
	}

}