package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {
    
	String recipeName;
	int maxIngredients;
	
	public TooManyIngredientsException(String recipeName, int maxIngredients) {
		this.recipeName = recipeName;
		this.maxIngredients = maxIngredients;
	}
	
	public String getRecipeName() {
		return recipeName;
	}
	
	public int getMaxIngredients() {
		return maxIngredients;
	}
	
	public String getMessage() {
		return "Too many ingredients. Number of ingredients for " + getRecipeName() + " is " + getMaxIngredients();
	}
}
