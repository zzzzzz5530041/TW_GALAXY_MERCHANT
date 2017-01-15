package com.tw.interview.homework.factory;

import com.tw.interview.homework.exception.InvalidRomanNumberException;
import com.tw.interview.homework.model.RomanNumber;
/**
 * get RomanNumber instance by passed Roman number
 * @author zhuyang
 *
 */
public class RomanNumberFactory {

	private RomanNumberFactory() {
	}

	public static RomanNumber getRomanNumber(char romanNumberChar) throws InvalidRomanNumberException {

		RomanNumber result = null;

		String className = "com.tw.interview.homework.model.RomanNumber" + romanNumberChar;

		try {
			result = (RomanNumber) Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			System.err.println("Illegal character: " + romanNumberChar);
			throw new InvalidRomanNumberException();
		} catch (IllegalAccessException e) {
			System.err.println("Illegal character: " + romanNumberChar);
			throw new InvalidRomanNumberException();
		} catch (ClassNotFoundException e) {
			System.err.println("Illegal character: " + romanNumberChar);
			throw new InvalidRomanNumberException();
		}

		return result;

	}

}