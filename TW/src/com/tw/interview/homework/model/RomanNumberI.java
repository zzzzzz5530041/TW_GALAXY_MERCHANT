package com.tw.interview.homework.model;

public class RomanNumberI implements RomanNumber {

	private final static String ROMAN_NUMBER = "I";

	private final static int ARABIC_NUMBER = 1;

	private final static int MAX_REPEAT = 3;

	private final static Class[] SUBTRACT_ENABLE = { RomanNumberV.class, RomanNumberX.class };

	public String getRomanNumber() {
		return ROMAN_NUMBER;
	}

	public int getArabicNumber() {
		return ARABIC_NUMBER;
	}

	public int getMaxRepeat() {
		return MAX_REPEAT;
	}

	public boolean isSubtractable(RomanNumber beSubStractNmumber) {
		for (int i = 0; i < SUBTRACT_ENABLE.length; i++) {
			if (beSubStractNmumber.getClass().equals(SUBTRACT_ENABLE[i])) {
				return true;
			}
		}

		return false;
	}

}