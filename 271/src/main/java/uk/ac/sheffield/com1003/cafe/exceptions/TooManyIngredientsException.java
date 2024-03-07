package uk.ac.sheffield.com1003.cafe.exceptions;

/** Thrown when trying to add an ingredient to a recipe which already
 * has the maximum number of ingredients.
 */
public class TooManyIngredientsException extends Exception {
    public TooManyIngredientsException() {
    	super();
    }
}
