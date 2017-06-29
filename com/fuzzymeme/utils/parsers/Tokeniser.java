package com.fuzzymeme.utils.parsers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Code to tokenise an input string so that it can be parsed.
 * Splits the input string into an array of Strings with one token in each element.
 * 
 * TODO Return a structured object that not only includes the string[], but also maps the tokens to line and line-position, 
 * so that the parser can point the user to problems with the parse. 
 *   
 */
public class Tokeniser {

	private char[] pass1Sep = new char[]{' ', '(', ')', '*', '+', '-', '/', '"', '{', '}', '>', '<', '!', '=', ':', '\n', '\t', ',' ,'\''};
	
	public Token[] tokenise(String input){
		
		Token[] pass1 = pass1(input);
				
		Token[] pass2 = pass2(pass1);
		return pass2;
	}
	
	private Token[] pass1(String input){
		
		return retainingSplit(input, pass1Sep);
	}
	
	/**
	 * Second level pass to make further adjustments, such as removing "", merging "=" with "<" (if paired) 
	 * @param input
	 * @return
	 */
	private Token[] pass2(Token[] input){
		
		List<Token> out = new LinkedList<Token>();
		
		for(Token item:input){
			// Remove ""
			if(!"".equals(item.getToken())){
				out.add(item);
			}
		}
			
		return out.toArray(new Token[out.size()]);
	}
	
    private static Token[] retainingSplit(String input, char[] separators){
    	
    	String string = new String(input);
    	int lastSplit = 0;
		char letter;
    	List<Token> segments = new ArrayList<Token>();
    	int row = 0;
    	int col = 0;
    	int i = 0;
		for(i = 0; i < string.length(); i++){
    		letter = string.charAt(i);  
    		col++;
    		
    		// If its one of the separators then split it out.
    		if(isSeparator(letter, separators)){
    			if(lastSplit == 0 && i == 0){
    				String orginal = string.substring(i, i + 1);
        			segments.add(new Token(orginal.trim(), orginal, row, col, lastSplit));	
    			}
    			else{
    				String prev = string.substring(lastSplit, i);
    				if(prev.trim().length() > 0){
    					segments.add(new Token(prev.trim(), prev, row, col, lastSplit));
    				}
    				String orginal = string.substring(i, i + 1);
    				segments.add(new Token(orginal.trim(), orginal, row, col, lastSplit));
    			}
				lastSplit = i + 1;
    		}
    		if(letter == '\n'){
    			row++;
    			col = 0;
    		}
    	}
		
		// Include the last one if not already done so
		if(lastSplit <= (string.length() -1) && string.substring(lastSplit).trim().length() > 0){
			String subString = string.substring(lastSplit);
			segments.add(new Token(subString.trim(), subString, row, col, lastSplit));
		}
		// If not separator found then the return should be the entire input
		if(segments.size() == 0){
			segments.add(new Token(string.trim(), string, row, col, lastSplit));
		}
		
		return segments.toArray(new Token[]{});
    }

    // TODO Change to hash table for quicker lookup
    public static boolean isSeparator(char letter, char[] separators){

    	for(char sep: separators){
    		if(letter == sep){
    			return true;
    		}
    	}
    	return false;
    }

}
