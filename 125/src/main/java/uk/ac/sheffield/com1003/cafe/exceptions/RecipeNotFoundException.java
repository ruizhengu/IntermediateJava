package uk.ac.sheffield.com1003.cafe.exceptions;

/** Represents an error due to a non-existent recipe.
 * @author Samuel Taseff
 */
public class RecipeNotFoundException extends Exception {
    public RecipeNotFoundException(String msg) {
        super(msg);
    }
}
