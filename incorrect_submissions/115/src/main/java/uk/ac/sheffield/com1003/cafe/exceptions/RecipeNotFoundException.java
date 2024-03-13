package uk.ac.sheffield.com1003.cafe.exceptions;

@SuppressWarnings("serial")
public class RecipeNotFoundException extends Exception {
	String recipeName;
	
	public RecipeNotFoundException(String recipeName) {
		this.recipeName = recipeName;
	}
	
	public String getName() {
		return recipeName;
	}
}
