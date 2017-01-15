package com.tw.interview.homework.processor;

import com.tw.interview.homework.exception.InvalidRomanNumberException;

public interface IProcessor {
	public String process (String line)throws InvalidRomanNumberException;
}
