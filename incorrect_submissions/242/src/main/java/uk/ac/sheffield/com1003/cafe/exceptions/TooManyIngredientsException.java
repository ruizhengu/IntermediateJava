package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {
	public TooManyIngredientsException(String message) {
        super(message);
    }

	public TooManyIngredientsException() {
		super("Too many ingredients added to recipe.");
	}
}
