package com.fuzzymeme.utils;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PairTests {

	@Test
	public void test_ConstructingAPairConstructsTheCorrectObject() {
		
		List<Integer> list1 = getList(0, 1, 2);
		List<Integer> list2 = getList(5, 12, 8);

		List<Integer> expectedlist1 = getList(0, 1, 2);
		List<Integer> expectedlist2 = getList(5, 12, 8);
		
		
		Pair<List<Integer>> listPair = new Pair<>(list1, list2);
		
		assertEquals(expectedlist1, listPair.getOne());
		assertEquals(expectedlist2, listPair.getOther());		
	}

	@Test
	public void test_Equals_PassesWithMatchingLists() {
		
		List<Integer> list1 = getList(0, 1, 2);
		List<Integer> list2 = getList(5, 12, 8);

		List<Integer> list3 = getList(0, 1, 2);
		List<Integer> list4 = getList(5, 12, 8);
		
		Pair<List<Integer>> listPair1 = new Pair<>(list1, list2);
		Pair<List<Integer>> listPair2 = new Pair<>(list3, list4);
		
		assertEquals(listPair1, listPair2);
		assertEquals(listPair1, listPair1);
		assertEquals(listPair2, listPair2);
	}
	
	@Test
	public void test_Equals_FailsWithNonMatchingLists() {
		
		List<Integer> list1 = getList(0, 1, 2);
		List<Integer> list2 = getList(5, 12, 9);

		List<Integer> list3 = getList(0, 1, 2);
		List<Integer> list4 = getList(5, 12, 8);
		
		Pair<List<Integer>> listPair1 = new Pair<>(list1, list2);
		Pair<List<Integer>> listPair2 = new Pair<>(list3, list4);
		
		assertNotEquals(listPair1, listPair2);
	}
	
	@Test
	public void test_Equals_FailsWithDifferentTypesOfPairs() {
		
		Pair<String> pair1 = new Pair<>("Foo", "Bar");
		Pair<Integer> pair2 = new Pair<>(2, 4);
		
		assertNotEquals(pair1, pair2);
	}
	
	//
	// Helpers
	//
	private List<Integer> getList(Integer ... array) {
		return Arrays.asList(array);
	}

}
