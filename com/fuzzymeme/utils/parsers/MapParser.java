package com.fuzzymeme.utils.parsers;

import java.util.HashMap;
import java.util.Map;

public class MapParser {

	public static Map<String, String> buildMapFromString(String stringToParse){
		return buildMapFromString(stringToParse, " ");
	}
	
	public static Map<String, String> buildMapFromString(String stringToParse, String separator){
		
		Map<String, String> map = new HashMap<>(); 
		String[] lines = stringToParse.split(separator);
		int index = 0;
		for(String line: lines){
			index = line.indexOf(":");
			if(index != -1){
				map.put(line.substring(0, index).trim(), line.substring(index + 1).trim());
			}
		}
		return map;
	}

	public static Map<String, Integer> buildStringIntegerMapFromString(String stringToParse){
		return buildStringIntegerMapFromString(stringToParse, " ");
	}
	
	public static Map<String, Integer> buildStringIntegerMapFromString(String stringToParse, String separator){
		
		Map<String, Integer> map = new HashMap<>(); 
		String[] lines = stringToParse.split(separator);
		int index = 0;
		for(String line: lines){
			index = line.indexOf(":");
			if(index != -1){
				int value = Integer.parseInt(line.substring(index + 1).trim());
				map.put(line.substring(0, index).trim(), value);
			}
		}
		return map;
	}

}
