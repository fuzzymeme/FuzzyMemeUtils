package com.fuzzymeme.utils.parsers;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

public class TokeniserTests extends TestCase {

	private Tokeniser tokeniser = new Tokeniser();
	
	@Test
	public void testTokenise() {
		
		// Test 1
		String input = "if(2>5)then\"Toby is a dog\"";
	
		Token[] tokenised = tokeniser.tokenise(input);
		
		System.out.println("Output:" + Arrays.toString(tokenised));
		assertTrue("Wrong number of elements generated:" + tokenised, tokenised.length == 13);

		// Test 2
		input = "if ( 2 >5)then\"Toby is a dog\"";
		
		tokenised = tokeniser.tokenise(input);
		
		System.out.println("Output:" + Arrays.toString(tokenised));
		assertTrue("Wrong number of elements generated:" + tokenised, tokenised.length == 13);


		// Test 3
		input = " if (     2 >5)then\"Toby is a dog\"  ";		
		tokenised = tokeniser.tokenise(input);
		
		System.out.println("Output:" + Arrays.toString(tokenised));
		assertTrue("Wrong number of elements generated:" + tokenised, tokenised.length == 13);
	
		// Test 4
		input = " if ((4*/+- >< !{}:5)\nthen\"Toby\"  ";		
		tokenised = tokeniser.tokenise(input);
		
		System.out.println("Output:" + Arrays.toString(tokenised));
		assertTrue("Wrong number of elements generated:" + tokenised, tokenised.length == 20);
		
		String[] expected = new String[]{"if", "(", "(", "4", "*", "/", "+", "-", ">", "<", "!", "{", "}", ":", "5", ")", "then", "\"", "Toby", "\""};
		String[] actual = new String[tokenised.length];
		int t = 0;
		for(Token token:tokenised){
			actual[t++] = token.getToken();
		}
		int i =0;
		for(String exp: expected){
			assertTrue("Missed token:" + actual[i], actual[i].equals(exp));
			i++;
		}
		
		input = "1 6\n #dog";		
		tokenised = tokeniser.tokenise(input);
		System.out.println("Output:" + Arrays.toString(tokenised));
		
		assertTrue("Line number is wrong", tokenised[1].getRow() == 0);

	}

}

