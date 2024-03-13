package uk.ac.sheffield.com1003.cafe.exceptions;

import uk.ac.sheffield.com1003.cafe.Recipe;

public class RecipeNotFoundException extends Exception {	
	    //instance variable
		private String notARecipe;
		
		//constructor
		public RecipeNotFoundException(String notARecipe) {
			this.notARecipe = notARecipe;
		}
		
		//accessor method
		public String getNotARecipe() {
			return notARecipe;
		}
}
