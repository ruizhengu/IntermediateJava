package uk.ac.sheffield.com1003.cafe.exceptions;

import uk.ac.sheffield.com1003.cafe.Recipe;

public class TooManyIngredientsException extends Exception {
    
    private Recipe recipe;
    
    public TooManyIngredientsException(Recipe recipe) {
        this.recipe = recipe;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}
