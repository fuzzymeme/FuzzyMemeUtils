package com.fuzzymeme.utils.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.fuzzymeme.utils.models.tables.Table;
import com.fuzzymeme.utils.models.tables.TableRow;

public class TableReader {
	
	public static Table loadTable(final String filename) throws IOException {
		return loadTable(filename, ",");
	}
	
	public static Table loadTable(final String filename, String separator) throws IOException {
		
		if(separator == null) {
			separator = ",";
		}
		
		String contents = FileIO.load(filename);
		
		Table table = parseTable(contents, separator);
				
		return table;
	}

	private static Table parseTable(final String tableAsString, final String separator){
		
		String[] lines = tableAsString.split("\n");
		
		Table table = new Table();
		boolean firstLine = true;
		for(String line: lines) {
			if(firstLine) {
				firstLine = false;
				List<String> headers = parseHeaders(line, separator);
				table.addHeaders(headers);
			} else {
				String[] newRow = parseRow(line, separator);
				table.addRow(new TableRow(newRow));
			}
		}
		
		return table;
	}

	private static String[] parseRow(final String line, final String separator) {
		String[] items = line.trim().split(Pattern.quote(separator));
		
		List<String> itemList = new ArrayList<>();
		for(String item: items) {
			if(!item.isEmpty()) {
				itemList.add(item.trim());
			}
		}
		
		return itemList.toArray(new String[itemList.size()]);		
	}

	private static List<String> parseHeaders(final String line, final String separator) {
		String[] headers = line.trim().split(Pattern.quote(separator));
		
		List<String> headerList = new ArrayList<>();
		for(String header: headers) {
			if(!header.isEmpty()) {
				headerList.add(header.trim());
			}
		}
		
		return headerList;
	}
	
	
}