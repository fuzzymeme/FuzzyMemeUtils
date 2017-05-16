package com.fuzzymeme.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
	
	private static char[] punctuations = new char[]{'\'', '.',',',';','?','(',')','!',':','"','/', '{','}','[',']','-','_','$','%'};
	private static char[] nonAlphabetCharacters = new char[]{'"','~','/', '{','}','[',']','$', '%','&','*','@','#','<','>','-','+','=','^'};
	private static char[] spaceCharacters = new char[]{' ','\t','\n'};	

	public final static char[] standardSeparators;

	static{
		standardSeparators = concat(punctuations, concat(nonAlphabetCharacters, spaceCharacters));
	}
	
	public static char[] concat(char[] a, char[] b) {
		int aLen = a.length;
		int bLen = b.length;
		char[] c= new char[aLen+bLen];
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);
		return c;
	}
	
	public static String listToSeparatedString(List<String> list, String separator){

		if(list == null){
			return "";  
		}

		StringBuffer buffer = new StringBuffer();

		int i = 0; 
		for(String word: list){
			buffer.append(word);
			if(i < list.size() - 1) {
				buffer.append(separator);
			}
			i++;
		}
		return buffer.toString().trim();
	}
	
	public static String captialiseFirstCharacter(String in){

		if(in == null || in.length() == 0) {
			return in;
		}
		return in.substring(0, 1).toUpperCase() + in.substring(1);
	}
	
	/**
	 * Splits the string into component parts. The splits are made where-ever a separator is found. 
	 * The array returned also includes the separators. For example the string " a + boo foo * c" with the
	 * separators "+" and "*" would return {" a ","+"," boo foo ","*"," c"}.
	 * Keeps spaces around returned words (if space is not a separator) and no spaces around the 
	 * returned separators.
	 * @param input
	 * @param separators
	 * @return
	 */
	public static String[] retainingSplit(String input, char[] separators){

		String string = new String(input);
		int lastSplit = 0;
		char letter;
		List<String> segments = new ArrayList<String>();
		for(int i = 0; i < string.length(); i++){
			letter = string.charAt(i);            
			// If its one of the separators then split it out.
			if(isSeparator(letter, separators)){
				if(lastSplit == 0 && i == 0){
					segments.add(string.substring(i, i + 1));	
				}
				else{
					String prev = string.substring(lastSplit, i);
					if(prev.length() > 0){
						segments.add(prev);
					}
					segments.add(string.substring(i, i + 1));
				}
				lastSplit = i + 1;
			}
		}    	
		// Include the last one if not already done so
		//System.out.println("lastSplit:" + lastSplit + ", string.length:" + string.length());
		if(lastSplit <= (string.length() -1) && string.substring(lastSplit).trim().length() > 0){
			//System.out.println("Adding last item:>" + string.substring(lastSplit).trim() + "<");
			segments.add(string.substring(lastSplit));
		}
		// If not separator found then the return should be the entire input
		if(segments.size() == 0){
			segments.add(string);
		}

		return segments.toArray(new String[]{});
	}
	
	public static boolean isSeparator(char letter, char[] separators){

		for(char sep: separators){
			if(letter == sep){
				return true;
			}
		}
		return false;
	}
	
	/** 
	 * Pads out the given string to the given width with spaces added to the right of the string
	 * @param string
	 * @param width
	 * @return padded out string with the padding to the right
	 */
	public static String padRight(String string, int width){

		if(string.length() >= width){
			return string;
		}

		StringBuilder builder = new StringBuilder(string);
		for(int i = string.length(); i < width; i++){
			builder.append(" ");
		}
		return builder.toString();
	}

	/**
	 * Pad to the left with the given character. Give it ("fish", 6, "*") get "**fish"
	 * @param count the length to make it up to 
	 * @param the string to use in the pad
	 * @return a string made up of 'count' number of spaces
	 */
	public static String padLeft(String toPad, int count, String padString){

		int padLength = count - toPad.length();
		if(padLength < 0){
			return toPad;
		}

		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < padLength; i++){
			buffer.append(padString);
		}
		return buffer.toString() + toPad;
	}
	
	/**
	 * Create an indentation of a given number of spaces.
	 * @param count
	 * @return a string made up of 'count' number of spaces
	 */
	public static String indent(int count){
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < count; i++){
			buffer.append(" ");
		}
		return buffer.toString();
	}
	
	public static boolean isNumber(String string){

		try {
			Double.parseDouble(string);
			return true;
		} catch (Exception e) {
		}		

		return false;
	}
	
	public static boolean isPuntuation(char letter){

		for(char punt: punctuations){
			if(letter == punt){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isNonAlphabetCharacter(char letter){

		for(char punt: nonAlphabetCharacters){
			if(letter == punt){
				return true;
			}
		}
		return false;
	}	
	
	public static List<String> getValuesFromCSVString(String csvString){
		
		List<String> values = new ArrayList<String>();
		String[] splitString = csvString.split(",");
		for(String value: splitString){
			values.add(value.trim());
		}
		return values;
	}
	
	/**
	 * Keep replacing the given string until they are all gone - a multi-pass rather than 
	 * the normal single pass of replaceAll
	 * 
	 * @param string
	 * @param doomed
	 * @param newbie
	 * @return The string with all the doomed strings replaced with the newbie strings
	 */
	public static String repeatedlyReplace(String string, String doomed, String newbie){

		String cleaned = string.replaceAll(doomed, newbie);
		while(cleaned.length() != string.length()){
			string = cleaned;
			cleaned = string.replaceAll(doomed, newbie);
		}
		return cleaned;
	}
		
	public static String minimiseSpaces(String input){

		return repeatedlyReplace(input, "  ", " ");
	}
}
