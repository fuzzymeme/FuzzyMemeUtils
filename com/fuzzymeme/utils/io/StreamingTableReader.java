package com.fuzzymeme.utils.io;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.fuzzymeme.utils.models.tables.Table;
import com.fuzzymeme.utils.models.tables.TableRow;

public class StreamingTableReader implements LineProcessor {
	
	private boolean hasAlreadyProcessedHeaders = false;
	private String separator = ",";
	private Table table = new Table();
	
	public StreamingTableReader() {
		this(",");
	}

	public StreamingTableReader(String givenSeparator) {
		super();
		if(givenSeparator != null) {
			this.separator = givenSeparator;
		}
	}
	
	public Table loadTable(String filename) throws IOException {
		
		table = new Table();
		FileIO.loadFileWithLineProcessor(filename, this);			
		
		return table;
	}

	@Override
	public void processLine(String line) {
		if(line == null || line.isEmpty() || line.startsWith("#")){
			return;
		}
		
		if(!hasAlreadyProcessedHeaders) {
			processHeaders(line);
			return;
		}
		
		processTableRow(line);
	}
	
	private void processHeaders(String headersString) {
		String[] headers = headersString.split(Pattern.quote(separator));
		
		List<String> headerList = new ArrayList<>();
		for(String header: headers) {
			if(!header.isEmpty()) {
				headerList.add(header.trim());
			}
		}

		table.addHeaders(headerList);
		hasAlreadyProcessedHeaders = true;
	}
	
	private void processTableRow(String row) {
		
		String[] items = row.trim().split(Pattern.quote(separator));
		
		List<String> itemList = new ArrayList<>();
		for(String item: items) {
			if(!item.isEmpty()) {
				itemList.add(item.trim());
			}
		}
		
		table.addRow(new TableRow(itemList.toArray(new String[itemList.size()])));	
	}	
}

