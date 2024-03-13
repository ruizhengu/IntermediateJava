package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {
    private String recipeName;
    //tells you which recipe could not be found so catcher can use this information

    public RecipeNotFoundException(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeName() {
        return recipeName;
    }
}
