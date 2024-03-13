package uk.ac.sheffield.com1003.cafe.exceptions;

import uk.ac.sheffield.com1003.cafe.Recipe;

/**
 * Exception thrown whenever recipe mentioned doesn't exist in menu.
 * @author milan
 */
public class RecipeNotFoundException extends Exception {
    public RecipeNotFoundException() {
        System.out.println("Recipe name entered does not exist in menu");
    }
}
