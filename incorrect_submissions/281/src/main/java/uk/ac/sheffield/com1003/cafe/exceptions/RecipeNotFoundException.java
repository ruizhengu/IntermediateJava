package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {
    public RecipeNotFoundException(String recipeName) {
        super("Could not find recipe with name \"" + recipeName + "\"");
    }
}
