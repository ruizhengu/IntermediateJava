package uk.ac.sheffield.com1003.cafe.exceptions;

import uk.ac.sheffield.com1003.cafe.Cafe;
import uk.ac.sheffield.com1003.cafe.Recipe;


public class RecipeNotFoundException extends Exception {
	public RecipeNotFoundException(String message) {
		super(message);
	}

}
