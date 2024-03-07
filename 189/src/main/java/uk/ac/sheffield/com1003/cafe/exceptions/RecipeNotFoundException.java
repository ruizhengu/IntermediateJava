package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {
    /* Outputs message if the given recipe doesn't exist */
    public RecipeNotFoundException(String message) {
        super(message);
    }
}
