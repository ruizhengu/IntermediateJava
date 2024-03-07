package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {
    public TooManyIngredientsException() {
        super("Cannot add more ingredients to this recipe, limit reached.");
    }
}
