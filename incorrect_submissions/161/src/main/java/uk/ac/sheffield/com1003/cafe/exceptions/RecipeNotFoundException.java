package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {
    private String recName;

    public RecipeNotFoundException(String recName) {
        this.recName = recName;
    }

    // method to return the recipe name, DO I NEED THIS????????
    public String getRecName() {
        return recName;
    }
}
