package uk.ac.sheffield.com1003.cafe.exceptions;

/** Represents an invalid ingredient addition to a recipe.
 * @author Samuel Taseff
 */
public class TooManyIngredientsException extends Exception {
    public TooManyIngredientsException(String msg) {
        super(msg);
    }
    
}
