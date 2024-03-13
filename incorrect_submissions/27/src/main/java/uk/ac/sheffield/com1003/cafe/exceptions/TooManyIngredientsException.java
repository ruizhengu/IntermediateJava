package uk.ac.sheffield.com1003.cafe.exceptions;

import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class TooManyIngredientsException extends Exception {
    private Ingredient ingredient;
    
    public TooManyIngredientsException(Ingredient ingredient) {
    	this.ingredient = ingredient;
    }
    
    public Ingredient getIngredient() {
    	return ingredient;
    }
}
