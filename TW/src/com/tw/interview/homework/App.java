package com.tw.interview.homework;

import java.io.IOException;
import java.util.List;

import com.tw.interview.homework.exception.InvalidRomanNumberException;
import com.tw.interview.homework.util.Merchant;

public class App {

	public static void main(String[] args) throws InvalidRomanNumberException, IOException {
		String inputFilePath = System.getProperty("user.dir") + "\\input.txt";
		List<String> outputs = Merchant.calculate(inputFilePath);
		for (String str : outputs)
			System.out.println(str);
	}

}