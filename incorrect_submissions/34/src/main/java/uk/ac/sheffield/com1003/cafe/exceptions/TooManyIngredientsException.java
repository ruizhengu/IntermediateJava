package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {
	
	public void errorMessage() {
		System.out.println("The number of ingredients for this recipe has been exceeded");
	}

    
}
