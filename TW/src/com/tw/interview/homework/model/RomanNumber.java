package com.tw.interview.homework.model;

public interface RomanNumber {

	public static final String[] ROMAN_NUMBERS = { "I", "V", "X", "L", "C", "D", "M" };

	public String getRomanNumber();

	public int getArabicNumber();

	public int getMaxRepeat();

	public boolean isSubtractable(RomanNumber beSubStractNmumber);

}