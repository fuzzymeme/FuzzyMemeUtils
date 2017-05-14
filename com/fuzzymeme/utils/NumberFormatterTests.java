package com.fuzzymeme.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberFormatterTests {

	@Test
	public void test_SimpleDoubleFormattedToTwoDecimalPlaces() {		
		NumberFormatter formatter = new NumberFormatter();
		assertEquals("0.23", formatter.format(0.233));
		assertEquals("1.23", formatter.format(1.233));
		assertEquals("101.23", formatter.format(101.233));
	}

	@Test
	public void test_CommasInTheRightPlaces() {		
		NumberFormatter formatter = new NumberFormatter();
		assertEquals("1,234", formatter.format(1234));
		assertEquals("1,234,001", formatter.format(1234001));
		assertEquals("123,400,100", formatter.format(123400100));
	}

	@Test
	public void test_ScientificNotation() {		
		NumberFormatter formatter = new NumberFormatter();
		assertEquals("1.234E9", formatter.format(1234001000));
	}

}
