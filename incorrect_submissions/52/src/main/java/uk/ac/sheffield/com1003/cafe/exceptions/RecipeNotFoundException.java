package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {
    public RecipeNotFoundException() {
        System.out.println("The recipe has not been found!");
    }

    public RecipeNotFoundException(String message) {
        super(message);
    }
}
