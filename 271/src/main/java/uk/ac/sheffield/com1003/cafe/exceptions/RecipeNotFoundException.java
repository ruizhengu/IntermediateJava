package uk.ac.sheffield.com1003.cafe.exceptions;

/** Thrown when an operation is attempted on a non-existent recipe. */
public class RecipeNotFoundException extends Exception {
    public RecipeNotFoundException() {
        super();
    }
}
