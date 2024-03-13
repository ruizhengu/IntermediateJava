package uk.ac.sheffield.com1003.cafe.exceptions;

//basic exception with a String param used to inform the name of the recipe which was invalid

public class RecipeNotFoundException extends Exception{
	
	String invalidRecipe;
	
	public RecipeNotFoundException(String invalidRecipe) {
		this.invalidRecipe = invalidRecipe;
	}
	
	public String getInvalidRecipe() {
		return invalidRecipe;
	}
	
	public String getMessage() {
		return this.getInvalidRecipe() + " is not on the menu";
	}
}
