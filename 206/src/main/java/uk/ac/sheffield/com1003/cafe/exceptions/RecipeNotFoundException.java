package uk.ac.sheffield.com1003.cafe.exceptions;

import uk.ac.sheffield.com1003.cafe.Recipe;

public class RecipeNotFoundException extends Exception{
    private String recipeName;
    public RecipeNotFoundException(){
        this.recipeName = null;
    }

    public RecipeNotFoundException(String recipe){
        this.recipeName = recipe;
    }

    public String getRecipe(){
        return recipeName;
    }
}
