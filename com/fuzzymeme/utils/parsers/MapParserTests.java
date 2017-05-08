package com.fuzzymeme.utils.parsers;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapParserTests {

	@Test
	public void test_ParsingOfStringStringMap() {
		
		Map<String, String> expected = new HashMap<>();
		expected.put("a", "alpha");
		expected.put("b", "bravo");
		expected.put("c", "charlie");
		expected.put("d", "delta");

		Map<String, String> actual = MapParser.buildMapFromString("a:alpha b:bravo c:charlie d:delta");
		
		assertEquals(expected, actual);		
	}
	
	@Test
	public void test_ParsingOfStringStringMap_WithDifferentSeparator() {
		
		Map<String, String> expected = new HashMap<>();
		expected.put("a", "alpha");
		expected.put("b", "bravo");
		expected.put("c", "charlie");
		expected.put("d", "delta");

		Map<String, String> actual = MapParser.buildMapFromString("a:alpha, b:bravo, c:charlie, d:delta", ",");
		
		assertEquals(expected, actual);		
	}
	
	@Test
	public void test_ParsingOfStringIntegerMap() {
		
		Map<String, Integer> expected = new HashMap<>();
		expected.put("a", 1);
		expected.put("b", 2);
		expected.put("c", 3);
		expected.put("d", 4);

		Map<String, Integer> actual = MapParser.buildStringIntegerMapFromString("a:1 b:2 c:3 d:4");
		
		assertEquals(expected, actual);		
	}

}
