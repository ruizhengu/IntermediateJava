package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {
    public TooManyIngredientsException() {
        // Prints the error message
        super("Too many ingredients");
    }
}
