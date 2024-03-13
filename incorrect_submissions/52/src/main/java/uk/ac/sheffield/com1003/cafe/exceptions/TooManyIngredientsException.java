package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {
    public TooManyIngredientsException() {
        System.out.println("There are too many ingredients in the recipe!");
    }

    public TooManyIngredientsException(String message) {
        super(message);
    }
}
