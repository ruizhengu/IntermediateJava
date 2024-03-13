package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {
    String unknownRecipe;

    public RecipeNotFoundException(String unknownRecipe) {
        this.unknownRecipe = unknownRecipe;
    }

    public String getUnknownRecipe() {
        return unknownRecipe;
    }
}
