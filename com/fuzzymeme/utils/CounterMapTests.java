package com.fuzzymeme.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CounterMapTests {

	private CounterMap<String> counter;

	
	@Before
	public void setup() {
		counter = new CounterMap<>();
	}

	@Test
	public void test_AddingOneItem() {		

		assertEquals(0, counter.size());
		assertEquals(0, counter.get("foo"));
		assertEquals(false, counter.containsKey("foo"));

		counter.inc("foo");
		
		assertEquals(1, counter.size());
		assertEquals(1, counter.get("foo"));
		assertEquals(true, counter.containsKey("foo"));		
	}
	
	@Test
	public void test_AddingOneItemThenIncrementing() {		

		counter.inc("foo");
		counter.inc("foo");
		
		assertEquals(1, counter.size());
		assertEquals(2, counter.get("foo"));		
	}

	@Test
	public void test_AddingMultipleItemsThenIncrementing() {		

		counter.inc("foo");
		counter.inc("foo");
		counter.inc("foo");
		counter.inc("bar");
		counter.inc("bar");
		counter.inc("bar");
		counter.inc("bar");
		
		assertEquals(2, counter.size());
		assertEquals(3, counter.get("foo"));
		assertEquals(4, counter.get("bar"));	
	}

	@Test
	public void test_SettingAValueDirectly() {		

		counter.set("foo", 16);
		
		assertEquals(1, counter.size());
		assertEquals(16, counter.get("foo"));		
	}

	@Test
	public void test_GettingTheKeySet() {		

		counter.set("foo", 16);
		counter.set("bar", 16);
		counter.set("fiz", 16);
		
		assertEquals(3, counter.size());
		assertTrue(counter.containsKey("foo"));		
		assertTrue(counter.containsKey("bar"));		
		assertTrue(counter.containsKey("fiz"));		
	}

	@Test
	public void test_RemovingKey() {		

		counter.set("foo", 16);
		counter.set("bar", 16);
		counter.set("fiz", 16);
		
		counter.remove("bar");
			
		assertEquals(2, counter.size());		
		assertTrue(counter.containsKey("foo"));		
		assertTrue(counter.containsKey("fiz"));		
	}
	
	@Test
	public void test_AddingBackAKeyAfterRemoval() {		

		counter.set("foo", 16);
		counter.set("bar", 16);
		counter.set("fiz", 16);
		
		counter.remove("bar");
		counter.inc("bar");
		
		assertEquals(3, counter.size());		
		assertEquals(16, counter.get("foo"));		
		assertEquals(1, counter.get("bar"));		
		assertEquals(16, counter.get("fiz"));		
	}

}
