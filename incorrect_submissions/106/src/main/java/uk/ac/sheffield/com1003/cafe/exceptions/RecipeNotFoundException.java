package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {

    private String recipeName;

    public RecipeNotFoundException(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeName() {
        return recipeName;
    }
    
}
