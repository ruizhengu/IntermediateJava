package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {
    public RecipeNotFoundException(String recipeName) {
        super("Recipe " + recipeName + " not found in menu");
    }
}
