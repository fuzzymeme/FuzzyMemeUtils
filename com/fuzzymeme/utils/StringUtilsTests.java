package com.fuzzymeme.utils;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StringUtilsTests {

	@Test
	public void test_concat_withTwoSimpleArrays() {
		char[] foo = new char[]{'f', 'o', 'o', ' '};
		char[] bar = new char[]{'b', 'a', 'r'};
		char[] expected = new char[]{'f', 'o', 'o', ' ', 'b', 'a', 'r'};

		assertTrue(Arrays.equals(expected, StringUtils.concat(foo, bar)));		
	}
	
	@Test
	public void test_concat_withOneSimpleArrayAndOneEmptyArray() {
		char[] foo = new char[]{'f', 'o', 'o', ' '};
		char[] bar = new char[]{};
		char[] expected = new char[]{'f', 'o', 'o', ' '};

		assertTrue(Arrays.equals(expected, StringUtils.concat(foo, bar)));		
	}
	
	
	@Test
	public void test_listToSeparatedString_withStringAndSeparator() {

		List<String> inputString = Arrays.asList("The", "next", "time", "I", "write", "this", "code", "will", "be", "the", "last");
		String separator = "*";
		String expectedString = "The*next*time*I*write*this*code*will*be*the*last";
		assertEquals(expectedString, StringUtils.listToSeparatedString(inputString, separator));
	}
	
	@Test
	public void test_captialiseFirstCharacter() {

		assertEquals("Foo", StringUtils.captialiseFirstCharacter("foo"));
		assertEquals("Bar", StringUtils.captialiseFirstCharacter("bar"));

		assertEquals("Foo", StringUtils.captialiseFirstCharacter("Foo"));
		assertEquals("Bar", StringUtils.captialiseFirstCharacter("Bar"));

		assertEquals(null, StringUtils.captialiseFirstCharacter(null));
		assertEquals("", StringUtils.captialiseFirstCharacter(""));
	}
	
	
	@Test
	public void test_retainingSplit() {

		String givenString = " a + boo foo * c";
		char[] separators = new char[]{'+', '*'};
		String[] expected = new String[]{" a ","+"," boo foo ","*"," c"};
	
		assertTrue(Arrays.equals(expected, StringUtils.retainingSplit(givenString, separators)));
	}
	
	@Test
	public void test_minimiseSpaces() {
		assertEquals(" a b c ", StringUtils.minimiseSpaces("   a  b     c  "));				
		assertEquals("a b c", StringUtils.minimiseSpaces("a   b   c"));
	}


}
