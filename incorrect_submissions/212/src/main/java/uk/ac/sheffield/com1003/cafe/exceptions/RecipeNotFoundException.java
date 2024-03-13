package uk.ac.sheffield.com1003.cafe.exceptions;


public class RecipeNotFoundException extends Exception {


    /**
     * @param recipeName refers to the invalid recipeName entered by user which resulting the recipeName is not found.
     * printing the error message will cause the problem to fix.
     */
    public RecipeNotFoundException(String recipeName) {
        System.out.println("Invalid recipe name entered. Recipe for " + "'" + recipeName + "'" + " is not found.");
    }
}
