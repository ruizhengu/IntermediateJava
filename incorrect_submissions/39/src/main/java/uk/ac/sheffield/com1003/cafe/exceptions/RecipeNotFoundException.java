package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {
    private String recipe;
    public RecipeNotFoundException(String recipe){
        this.recipe = recipe;
    }
    public String getRecipe(){
        return recipe;
    }
}
