package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {
	
	private char c;
	
	public RecipeNotFoundException(char c) {
		this.c = c;
	}

}
