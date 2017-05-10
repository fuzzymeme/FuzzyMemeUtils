package com.fuzzymeme.utils.io;

import java.io.*;

public class FileIO {
	
	public static void loadFileWithLineProcessor(String filename, LineProcessor processor) throws IOException
	{
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
		    String line = br.readLine();

		    while (line != null) {
		        processor.processLine(line);
		        line = br.readLine();
		    }
		}
		catch(Exception e){
			throw e;
		}		
	}
	
	public static String load(String filename) throws IOException
	{
		File file;
		FileReader reader = null;

		try{
			file = new File(filename);
			reader = new FileReader(file);
			int size = (int) file.length();
			char[] data = new char[size];
			int charsRead = 0;
			int ret = 1;
			while(charsRead < size && ret > 0){
				ret = reader.read(data, charsRead, size - charsRead);
				charsRead += ret;
			}
			//return new String(data).trim(); // returns from here if all well
			return new String(data); // returns from here if all well
		}
		catch(IOException e){
			throw e;
		}
		finally{
			try { 
				if (reader != null)
					reader.close();
			}
			catch(IOException e){
				throw e;
			}
		}
	}

	public static void save(String fileName, String contents)
	{
		save(fileName, contents, false);
	}

	public static void save(String fileName, String contents, boolean append)
	{
		try{
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bWriter = new BufferedWriter(fw);

			try{
				bWriter.write(contents);
				bWriter.flush();
			}
			catch(IOException e){
				System.err.println("Unable to write to: " + fileName + " " + e.getMessage());   
				e.printStackTrace();
			}
			fw.close();
		}
		catch (IOException e){
			System.err.println("Unable to save: " + fileName);            
			e.printStackTrace();
		}
	}
	
	public static byte[] loadBytes(String fileName) throws IOException
	{
		File file = new File(fileName);
		InputStream is = new FileInputStream(file);

		byte[] bytes = new byte[(int) file.length()];

		// Read in the bytes
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
			offset += numRead;
		}

		// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			is.close();
			throw new IOException("Could not completely read file "+file.getName());
		}

		// Close the input stream and return bytes
		is.close();
		return bytes;
	}
	
	public static void saveBytes(String fileName, byte[] bytes)
	{
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileName);
			fos.write(bytes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
