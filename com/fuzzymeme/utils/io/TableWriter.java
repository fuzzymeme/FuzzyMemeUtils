package com.fuzzymeme.utils.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.fuzzymeme.utils.models.tables.Table;
import com.fuzzymeme.utils.models.tables.TableRow;

/**
 *  TODO Needs testing !!
 */
public class TableWriter {
	
	public void write(String fileName, Table table) {
		write(fileName, table, ",");
	}

	public void write(String fileName, Table table, String separator) {

		try{
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bWriter = new BufferedWriter(fw);

			try{
				writeHeaders(bWriter, table, separator);
				for(int i = 0; i < table.getRowCount(); i++) {
					writeTableRow(bWriter, table.getRow(i), separator);
				}
				bWriter.flush();
			}
			catch(IOException e){
				System.err.println("Unable to write to: " + fileName);            
			}
			fw.close();
		}
		catch (IOException e){
			System.err.println("Unable to save: " + fileName);            
		}
	}    
	
	private void writeHeaders(BufferedWriter bWriter, Table table, String separator) throws IOException{
		if(table.getColumnCount() == 0) {
			return;
		}
		
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < table.getColumnCount() - 1 ; i++) {
			buffer.append(table.getHeader(i)).append(separator);
		}
		buffer.append(table.getHeader(table.getColumnCount() - 1));
				
		bWriter.write(buffer.toString() + "\n");
	}	
	
	private void writeTableRow(BufferedWriter bWriter, TableRow row, String separator) throws IOException {
		if(row.size() == 0) {
			return;
		}
		
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < row.size() - 1; i++) {
			buffer.append(row.get(i)).append(separator);
		}
		buffer.append(row.get(row.size() - 1));
		bWriter.write(buffer.toString() + "\n");
	}

	public static void main(String[] args) {

		TableWriter writer = new TableWriter();

		Table table = new Table();
		table.addHeaders(Arrays.asList(new String[]{"one", "two", "three", "four", "five"}));
		TableRow row = new TableRow(new String[]{"a", "b", "c", "d"});
		TableRow rowTwo = new TableRow(new String[]{"e", "f", "g", "h"});
		table.addRow(row);
		table.addRow(rowTwo);
		
		writer.write("foo.txt", table, ", ");
	}


}
