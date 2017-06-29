package com.fuzzymeme.utils.parsers;

public class Token {

	private String token;
	private String original;
	private int row;
	private int col;
	private int originalLength;
	private int pos;

	public Token(String token, String original, int row, int col, int pos) {

		this.token = token;
		this.original = original;
		this.row = row;
		this.col = col;
		this.originalLength = original.length();
		this.pos = pos;
	}

	public String getToken() {
		return token;
	}

	public String getOriginal() {
		return original;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int getOrginialLength() {
		return originalLength;
	}

	public int getPos(){
		return pos;
	}

	public boolean isVariant(){
		return token.startsWith("#") || token.startsWith("$");
	}

	@Override
	public String toString() {
		return "Token [token=" + token + ", original=" + original + ", row="
				+ row + ", col=" + col + ", originalLength=" + originalLength
				+ ", pos=" + pos + "]";
	}
}