package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {
	public RecipeNotFoundException() {
		super("A recipe was not found");
	}

	public RecipeNotFoundException(String message) {
		super(message);
	}
}
