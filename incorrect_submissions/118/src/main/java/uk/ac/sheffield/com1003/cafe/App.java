package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;

import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

public class App {
	
	public static void main(String[] args) {
		
		Cafe cafe = new Cafe();
		
		/**
		 * Creation of espresso recipe 
		 */
		Recipe espresso = new Recipe("espresso", 1.5, Recipe.Size.SMALL, 2);
		
		try {
			espresso.addIngredient(new Coffee());
			espresso.addIngredient(new Water());
		}
		catch(TooManyIngredientsException e) {
			System.err.println("Too many ingredients");
		}
		cafe.addRecipe(espresso);
		
		
		/** 
		 * Creation of double espresso recipe 
		 */
		Recipe doubleespresso = new Recipe("double espresso", 2.2, Recipe.Size.REGULAR, 2);
		
		try {
			doubleespresso.addIngredient(new Coffee(15));
			doubleespresso.addIngredient(new Water(50));
		}
		catch(TooManyIngredientsException e) {
			System.err.println("Too many ingredients");
		}
		cafe.addRecipe(doubleespresso);
		
		
		/** 
		 * Creation of large soy latte recipe
		 */
		Recipe largesoylatte = new Recipe("large soy latte", 2.5, Recipe.Size.LARGE, 1);
		
		try {
			largesoylatte.addIngredient(new Milk(10));
			largesoylatte.addIngredient(new Water(10));
		}
		catch(TooManyIngredientsException e) {
			System.err.println("Too many ingredients");
		}
		cafe.addRecipe(largesoylatte);
		
		
		/** 
		 * PRINTING THE MENU 
		 */
		cafe.printMenu();
		
		
		
		/**
		TESTING THE equals() METHOD
		
		test case recipe (same as espresso)
		
		Recipe testcase = new Recipe("testcase", 1.5, Recipe.Size.SMALL, 2);
		
		try {
			testcase.addIngredient(new Coffee());
		    testcase.addIngredient(new Water());
		}
		catch(TooManyIngredientsException e) {
			System.err.println("Too many ingredients");
		}
		
		boolean same = testcase.equals(espresso);
		System.out.println(same); //returns TRUE
		
		boolean different = largesoylatte.equals(espresso);
		System.out.println(different); //returns FALSE 	
		*/
		
	}

}
