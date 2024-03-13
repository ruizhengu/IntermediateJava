package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {
	public TooManyIngredientsException() {
		super("The number of ingredients has been exceeded");
	}

	public TooManyIngredientsException(String message) {
		super(message);
	}
}
