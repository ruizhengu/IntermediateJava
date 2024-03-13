/**
 * TooManyIngredientsException.java
 * Exception thrown when adding an ingredient to a Recipe when the max number of allowed ingredients has been reached.
 * @version 1.0 10/03/2023
 */
package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {
    /**
     * Constructs a new TooManyIngredientsException with the specified detail message.
     * @param message the detail message
     */
    public TooManyIngredientsException(String message) {
        super("Too many ingredients! Please reduce the number of ingredients.");
    }

}
    

