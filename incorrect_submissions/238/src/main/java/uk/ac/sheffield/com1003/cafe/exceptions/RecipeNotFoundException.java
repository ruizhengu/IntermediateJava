/**
 * RecipeNotFoundException.java
 * This class defines a custom exception, RecipeNotFoundException, which is thrown when a recipe cannot be found.
 * @version 1.0 10/03/2023
 * @author Unknown
 */

package uk.ac.sheffield.com1003.cafe.exceptions;
public class RecipeNotFoundException extends Exception {

    /**
     * Constructs a new RecipeNotFoundException with the specified detail message.
     * @param message the detail message
     */
    public RecipeNotFoundException(String message) {
        super(message);
    }
}