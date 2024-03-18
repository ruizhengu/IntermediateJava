package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;            

public class App {
	
	// Main method with an exception
	public static void main(String[] args) throws TooManyIngredientsException {
		
		/**
		 * Adding 4 new recipes
		 * Then we add ingredients to the recipe and their sizes and amounts 
		 * Checking the equality between two recipes
		 * Adding the recipes onto the cafe menu
		 * Print the menu 
		 * Then we serve the order
		 * Print the pending orders 
		*/
		Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2 ); 
		espresso.addIngredient(new Coffee());  
		espresso.addIngredient(new Water());
		
		Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2 ); 
		doubleEspresso.addIngredient(new Coffee(15));
		doubleEspresso.addIngredient(new Water(50));
		
		Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3 ); 
		largeSoyLatte.addIngredient(new Milk(20, Type.WHOLE));
		largeSoyLatte.addIngredient(new Coffee());  
		largeSoyLatte.addIngredient(new Water()); 
		
		Recipe largeSoyLatte1 = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3 ); 
		largeSoyLatte1.addIngredient(new Milk(20, Type.SOY));
		largeSoyLatte1.addIngredient(new Coffee());  
		largeSoyLatte1.addIngredient(new Water());
		
		System.out.println( "Recipe Equality : " + largeSoyLatte.equals(largeSoyLatte1));
		
		Cafe cafe = new Cafe("Central Perk"); 
		
		cafe.addRecipe(espresso);
		cafe.addRecipe(doubleEspresso);
		cafe.addRecipe(largeSoyLatte);
		
		cafe.printMenu();
		try {
			cafe.removeRecipe("Espresso");
		} catch (RecipeNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cafe.printMenu();
		
		try {
			cafe.placeOrder("Espresso", "Anurag", 2.5);
			cafe.placeOrder("Large Soy Latte", "Anurag", 5.5);
		} catch (RecipeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CafeOutOfCapacityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		cafe.serveOrder();
		cafe.serveOrder();
	
		
		cafe.printPendingOrders(); 
		
	}
		  
}
