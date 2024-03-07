package uk.ac.sheffield.com1003.cafe.exceptions;

/**
 * This exception is thrown when a customer attempts to order a recipe that is
 * not on the menu
 */
public class RecipeNotFoundException extends Exception {

    @Override
    public String toString() {
        return "The recipe you are looking for is not on our menu currently";
    }

}
