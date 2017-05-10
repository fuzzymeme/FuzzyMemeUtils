package com.fuzzymeme.utils.models.tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
	
	private List<String> headers = new ArrayList<String>();
	private Map<String, Integer> headersToIndexMap = new HashMap<>();
	private List<TableRow> rows = new ArrayList<>();

	public void clear() {
		headers.clear();;
		rows.clear();
	}
	
	public String getHeader(int index) {
		return headers.get(index);
	}
	
	public TableRow getRow(int rowNumber) {
		return rows.get(rowNumber);
	}
	
	public String getItem(int row, int column) {
		return rows.get(row).get(column);
	}

	public String getItem(int row, String columnName) {
		return rows.get(row).get(headersToIndexMap.get(columnName));
	}

	public void addRow(TableRow newRow) {
		rows.add(newRow);
	}

	public void addHeaders(List<String> headersIn) {
		headers.clear();
		headersToIndexMap.clear();
		headers.addAll(headersIn);
		int i = 0;
		for(String header: headers) {
			headersToIndexMap.put(header, i++);
		}
	}
	
	public int getRowCount() {
		return rows.size();
	}
	
	public int getColumnCount() {
		return headers.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((headers == null) ? 0 : headers.hashCode());
		result = prime * result + ((rows == null) ? 0 : rows.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Table other = (Table) obj;
		if (headers == null) {
			if (other.headers != null)
				return false;
		} else if (!headers.equals(other.headers))
			return false;
		if (rows == null) {
			if (other.rows != null)
				return false;
		} else if (!rows.equals(other.rows))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		drawLine(buffer);
		
		for (String header: headers) {
			buffer.append(header).append(" ");
		}
		buffer.append("\n");
		drawLine(buffer);
		
		for (TableRow row: rows) {
			buffer.append(row).append("\n");
		}

		drawLine(buffer);

		return buffer.toString();
	}

	private void drawLine(StringBuffer buffer) {
		for(int i = 0; i < headers.size(); i++) {
			buffer.append("---");			
		}
		buffer.append("\n");
	}
	
}
