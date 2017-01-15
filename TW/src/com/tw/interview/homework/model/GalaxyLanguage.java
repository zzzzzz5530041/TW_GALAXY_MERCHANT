package com.tw.interview.homework.model;

import com.tw.interview.homework.exception.InvalidRomanNumberException;
import com.tw.interview.homework.util.RomanArabicNumberUtil;

public class GalaxyLanguage {
	private String galaxyNumber;// glob

	private String romanNumber;// I

	private int arabicNumber;// 1

	public String getGalaxyNumber() {
		return galaxyNumber;
	}

	public void setGalaxyNumber(String galaxyNumber) {
		this.galaxyNumber = galaxyNumber;
	}

	public String getRomanNumber() {
		return romanNumber;
	}

	public void setRomanNumber(String romanNumber) {
		this.romanNumber = romanNumber;
	}

	public int getArabicNumber() throws InvalidRomanNumberException {
		return RomanArabicNumberUtil.translateRomanToArabic(romanNumber);
	}

	

}