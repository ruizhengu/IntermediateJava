package uk.ac.sheffield.com1003.cafe.exceptions;

import uk.ac.sheffield.com1003.cafe.Cafe;
import uk.ac.sheffield.com1003.cafe.Recipe;
import java.lang.Exception;

/**
 * Exception thrown whenever # of ingredients added to a recipe exceeds number of required ingredients.
 * @author milan
 */
public class TooManyIngredientsException extends Exception {
    public TooManyIngredientsException () {
        System.out.println("Too many ingredients added to this recipe");
    }
}
