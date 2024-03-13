package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {
	
	public void errorMessage() {
		System.out.println("Recipe does not exist");
	}

}
