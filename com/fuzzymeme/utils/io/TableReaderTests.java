package com.fuzzymeme.utils.io;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.fuzzymeme.utils.models.tables.Table;
import com.fuzzymeme.utils.models.tables.TableRow;

public class TableReaderTests {
	
	private final static TableRow exampleRowZero = new TableRow(new String[]{"a", "b", "c", "d", "e"});
	private final static TableRow exampleRowOne = new TableRow(new String[]{"f", "g", "h", "i", "j"});
	private final static String[] exampleHeaders = new String[]{"one", "two", "three", "four", "five"};

	@Test
	public void test_GivenFilename_WhenLoadsCommaSeparatedTestTable_ThenTableHasCorrectValues() {
		
		try {
			Table table = TableReader.loadTable("test_table.txt");
			assertEquals(exampleRowZero, table.getRow(0));
			assertEquals(exampleRowOne, table.getRow(1));
		} catch (IOException e) {
			e.printStackTrace();
			fail("Test threw an exception");
		}
	}

	@Test
	public void test_GivenFilename_WhenLoadsCommaSeparatedTestTable_ThenTableHasCorrectHeaders() {
		
		try {
			Table table = TableReader.loadTable("test_table.txt");
			assertEquals(exampleHeaders.length, table.getColumnCount());
			for(int i = 0; i < table.getColumnCount(); i++) {
				assertEquals(exampleHeaders[i], table.getHeader(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail("Test threw an exception");
		}
	}

	@Test
	public void test_GivenFilename_WhenLoadsSpaceSeparatedTestTable_ThenTableHasCorrectValues() {
		
		try {
			Table table = TableReader.loadTable("test_table_space_separated.txt", " ");
			assertEquals(exampleRowZero, table.getRow(0));
			assertEquals(exampleRowOne, table.getRow(1));
		} catch (IOException e) {
			e.printStackTrace();
			fail("Test threw an exception");
		}
	}

	@Test
	public void test_GivenFilename_WhenLoadsSpaceSeparatedTestTable_ThenTableHasCorrectHeaders() {
		
		try {
			Table table = TableReader.loadTable("test_table_space_separated.txt", " ");
			assertEquals(exampleHeaders.length, table.getColumnCount());
			for(int i = 0; i < table.getColumnCount(); i++) {
				assertEquals(exampleHeaders[i], table.getHeader(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail("Test threw an exception");
		}
	}

	@Test
	public void test_GivenFilename_WhenLoadsTABSeparatedTestTable_ThenTableHasCorrectValues() {
		
		try {
			Table table = TableReader.loadTable("test_table_tab_separated.txt", "\t");
			assertEquals(exampleRowZero, table.getRow(0));
			assertEquals(exampleRowOne, table.getRow(1));
		} catch (IOException e) {
			e.printStackTrace();
			fail("Test threw an exception");
		}
	}

	@Test
	public void test_GivenFilename_WhenLoadsTABSeparatedTestTable_ThenTableHasCorrectHeaders() {
		
		try {
			Table table = TableReader.loadTable("test_table_tab_separated.txt", "\t");
			assertEquals(exampleHeaders.length, table.getColumnCount());
			for(int i = 0; i < table.getColumnCount(); i++) {
				assertEquals(exampleHeaders[i], table.getHeader(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail("Test threw an exception");
		}
	}
	
	@Test
	public void test_GivenFilename_WhenLoadsTokenSeparatedTestTable_ThenTableHasCorrectValues() {
		
		try {
			Table table = TableReader.loadTable("test_table_token_separated.txt", "***");
			assertEquals(exampleRowZero, table.getRow(0));
			assertEquals(exampleRowOne, table.getRow(1));
		} catch (IOException e) {
			e.printStackTrace();
			fail("Test threw an exception");
		}
	}

	@Test
	public void test_GivenFilename_WhenLoadsTokenSeparatedTestTable_ThenTableHasCorrectHeaders() {
		
		try {
			Table table = TableReader.loadTable("test_table_token_separated.txt", "***");
			assertEquals(exampleHeaders.length, table.getColumnCount());
			for(int i = 0; i < table.getColumnCount(); i++) {
				assertEquals(exampleHeaders[i], table.getHeader(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail("Test threw an exception");
		}
	}	

}

