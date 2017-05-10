package com.fuzzymeme.utils.models.tables;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;

import org.junit.Before;

public class TableTester {
		
	private static Table table = new Table();
	private final static TableRow expectedRowOne = new TableRow(new String[]{"a", "b", "c", "d"});
	private final static TableRow expectedRowTwo = new TableRow(new String[]{"e", "f", "g", "h"});

	
	@Before
	public void setUp(){
		table = new Table();
	}

	@Test
	public void test_When4HeadersSet_ThenHas4Columns() {
		
		table.clear();
		table.addHeaders(Arrays.asList(new String[]{"one", "two", "three", "four"}));
		
		assertEquals(4, table.getColumnCount());
	}
	
	
	@Test
	public void test_When1RowAddedToNewTable_ThenHas1Row() {
		
		table.clear();
		table.addHeaders(Arrays.asList(new String[]{"one", "two", "three", "four"}));
		TableRow newRow = new TableRow(new String[]{"a", "b", "c", "d"});

		table.addRow(newRow);
		
		assertEquals(1, table.getRowCount());
	}
	
	@Test
	public void test_When2RowAddedToNewTable_ThenHas2Rows() {
		
		table.clear();

		table.addRow(new TableRow(new String[]{"a", "b", "c", "d"}));
		table.addRow(new TableRow(new String[]{"e", "f", "g", "h"}));
		
		assertEquals(2, table.getRowCount());
	}
	
	@Test
	public void test_GivenClearTable_When1RowAdded_ThenRowHasCorrectElements() {
		
		table.clear();
		TableRow newRow = new TableRow(new String[]{"a", "b", "c", "d"});

		table.addRow(newRow);
		
		assertEquals("a", table.getItem(0, 0));
		assertEquals("b", table.getItem(0, 1));
		assertEquals("c", table.getItem(0, 2));
		assertEquals("d", table.getItem(0, 3));
	}
	
	@Test
	public void test_GivenClearTable_When2RowsAdded_ThenEachRowHasCorrectElements() {
		
		table.clear();
		TableRow rowOne = new TableRow(new String[]{"a", "b", "c", "d"});
		TableRow rowTwo = new TableRow(new String[]{"e", "f", "g", "h"});

		table.addRow(rowOne);
		table.addRow(rowTwo);
		
		assertEquals(expectedRowOne, table.getRow(0));
		assertEquals(expectedRowTwo, table.getRow(1));
	}

	@Test
	public void test_GivenTwoIdentialTables_WhenCompared_ThenReturnsTrue() {
		
		Table tableOne = new Table();
		tableOne.addHeaders(Arrays.asList(new String[]{"one", "two", "three", "four"}));
		TableRow tableOneRowOne = new TableRow(new String[]{"a", "b", "c", "d"});
		TableRow tableOneRowTwo = new TableRow(new String[]{"e", "f", "g", "h"});
		tableOne.addRow(tableOneRowOne);
		tableOne.addRow(tableOneRowTwo);

		Table tableTwo = new Table();
		tableTwo.addHeaders(Arrays.asList(new String[]{"one", "two", "three", "four"}));
		TableRow tableTwoRowOne = new TableRow(new String[]{"a", "b", "c", "d"});
		TableRow tableTwoRowTwo = new TableRow(new String[]{"e", "f", "g", "h"});
		tableTwo.addRow(tableTwoRowOne);
		tableTwo.addRow(tableTwoRowTwo);

		assertEquals(tableOne, tableTwo);
	}

	@Test
	public void test_GivenTwoNonIdentialTablesDifferentByTableRowItem_WhenCompared_ThenReturnsFalse() {
		
		Table tableOne = new Table();
		tableOne.addHeaders(Arrays.asList(new String[]{"one", "two", "three", "four"}));
		TableRow tableOneRowOne = new TableRow(new String[]{"a", "b", "c", "d"});
		TableRow tableOneRowTwo = new TableRow(new String[]{"e", "f", "g", "help"});
		tableOne.addRow(tableOneRowOne);
		tableOne.addRow(tableOneRowTwo);

		Table tableTwo = new Table();
		tableTwo.addHeaders(Arrays.asList(new String[]{"one", "two", "three", "four"}));
		TableRow tableTwoRowOne = new TableRow(new String[]{"a", "b", "c", "d"});
		TableRow tableTwoRowTwo = new TableRow(new String[]{"e", "f", "g", "h"});
		tableTwo.addRow(tableTwoRowOne);
		tableTwo.addRow(tableTwoRowTwo);

		assertNotEquals(tableOne, tableTwo);
	}

	@Test
	public void test_GivenTwoNonIdentialTablesDifferentByHeaderItem_WhenCompared_ThenReturnsFalse() {
		
		Table tableOne = new Table();
		tableOne.addHeaders(Arrays.asList(new String[]{"one", "two", "three", "four"}));
		TableRow tableOneRowOne = new TableRow(new String[]{"a", "b", "c", "d"});
		TableRow tableOneRowTwo = new TableRow(new String[]{"e", "f", "g", "h"});
		tableOne.addRow(tableOneRowOne);
		tableOne.addRow(tableOneRowTwo);

		Table tableTwo = new Table();
		tableTwo.addHeaders(Arrays.asList(new String[]{"one", "two", "three", "fourty"}));
		TableRow tableTwoRowOne = new TableRow(new String[]{"a", "b", "c", "d"});
		TableRow tableTwoRowTwo = new TableRow(new String[]{"e", "f", "g", "h"});
		tableTwo.addRow(tableTwoRowOne);
		tableTwo.addRow(tableTwoRowTwo);

		assertNotEquals(tableOne, tableTwo);
	}

	@Test
	public void test_GivenTable_WhenAskedForAnItemByRowsAndHeaderNames_ThenReturnsCorrectItems() {
		
		Table table = getExampleTable();

		assertEquals("a", table.getItem(0, "one"));
		assertEquals("b", table.getItem(0, "two"));
		assertEquals("c", table.getItem(0, "three"));
		assertEquals("d", table.getItem(0, "four"));
		assertEquals("e", table.getItem(1, "one"));
		assertEquals("f", table.getItem(1, "two"));
		assertEquals("g", table.getItem(1, "three"));
		assertEquals("h", table.getItem(1, "four"));
	}
	
	
	//
	// Helpers
	//
	private Table getExampleTable() {
		Table exampleTable = new Table();
		exampleTable.addHeaders(Arrays.asList(new String[]{"one", "two", "three", "four"}));
		TableRow tableOneRowOne = new TableRow(new String[]{"a", "b", "c", "d"});
		TableRow tableOneRowTwo = new TableRow(new String[]{"e", "f", "g", "h"});
		exampleTable.addRow(tableOneRowOne);
		exampleTable.addRow(tableOneRowTwo);
		return exampleTable;
	}

}
