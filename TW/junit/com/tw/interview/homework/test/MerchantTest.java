package com.tw.interview.homework.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tw.interview.homework.exception.InvalidRomanNumberException;
import com.tw.interview.homework.util.Merchant;
import com.tw.interview.homework.util.RomanArabicNumberUtil;

public class MerchantTest {
	/**Input file path*/
	private static String INPUT_FILE_PATH = "";
	/**output file path*/
	private static String OUTPUT_FILE_PATH = "";
	/**store content from output file*/
	private List<String> expectedOutput;
	@Before
	public void setup() {
		INPUT_FILE_PATH = System.getProperty("user.dir") + "\\input.txt";
		OUTPUT_FILE_PATH = System.getProperty("user.dir") + "\\output.txt";
		expectedOutput = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(OUTPUT_FILE_PATH));
			String line = "";
			while ((line = br.readLine()) != null && (!"".equals(line.trim()))) {//store content from output file
				expectedOutput.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Test WRONG Roman Number Case
	 */
	public void romanNumberInValid() {
		String romanNumber = "IIII";
		try {
			boolean isValidRomanNumber = RomanArabicNumberUtil.isValidRomanNumber(romanNumber);
			assertFalse("Roman Number is not valid", isValidRomanNumber);
		} catch (InvalidRomanNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Test valid Roman Number Case
	 */
	public void romanNumberValid() {
		String romanNumber = "i";
		try {
			boolean isValidRomanNumber = RomanArabicNumberUtil.isValidRomanNumber(romanNumber);
			assertTrue("Roman Number is valid", isValidRomanNumber);
		} catch (InvalidRomanNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Test Roman Number translate to Arabic number case
	 */
	public void translateRomanNumber() {
		String romanNumber = "MMXI";
		try {
			int arabicNumber = RomanArabicNumberUtil.translateRomanToArabic(romanNumber);
			assertEquals("2011", String.valueOf(arabicNumber));
		} catch (InvalidRomanNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	/**
	 * test project functionality
	 * read input file and compare the result with the content of output file 
	 */
	public void calculate(){
			List<String> outputs = Merchant.calculate(INPUT_FILE_PATH);
			for (int i = 0; i < outputs.size(); i++) {
				assertEquals(expectedOutput.get(i), outputs.get(i));
			}

	}

}
