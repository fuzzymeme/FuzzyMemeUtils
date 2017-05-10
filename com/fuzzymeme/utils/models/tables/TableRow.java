package com.fuzzymeme.utils.models.tables;

import java.util.Arrays;

/**
 * TODO Convert from String[] to List<String> 
 */
public class TableRow {
	
	
	private String[] items; 
		
	public TableRow(){}
	
	public TableRow(String[] itemsIn) {
		items = itemsIn;
	}
	
	public int size() {
		return items.length;
	}
	
	public void addItems(String[] itemsIn) {
		items = itemsIn;
	}
	
	public String get(int index) {
		return items[index];
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(items);
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
		TableRow other = (TableRow) obj;
		if (!Arrays.equals(items, other.items))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		for (String item: items) {
			buffer.append(item).append(", ");
		}
		
		String rowAsString = buffer.toString();
		if(rowAsString.length() > 0) {
			rowAsString = rowAsString.substring(0, rowAsString.length() - 2);
		}
		
		return rowAsString;
	}
}
