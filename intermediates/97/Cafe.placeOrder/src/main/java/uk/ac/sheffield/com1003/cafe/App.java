/**
 * This class uses the appropriate methods and adds a few specific recipes to the cafe's menu and prints(displays) them for the customers.
 * Also, applies the try-catch statement to handle the exceptions wherever required
 */

package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;


public class App {
	public static void main (String[] args) {
				
		Cafe coffeeShop = new Cafe();
		
		Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
		
		try {
			espresso.addIngredient(new Coffee());
			espresso.addIngredient(new Water());
			} 
		catch (TooManyIngredientsException e) {
			System.err.println("Too many ingredients for the recipe");
		}
		coffeeShop.addRecipe(espresso);
		
		
		Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
		
		try {
			doubleEspresso.addIngredient(new Coffee(15));
			doubleEspresso.addIngredient(new Water(50));
		}
		catch (TooManyIngredientsException e) {
			System.err.println("Too many ingredients for the recipe");
		}
		coffeeShop.addRecipe(doubleEspresso);
		
		
		Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
		
		try{
			largeSoyLatte.addIngredient(new Coffee(30));
			largeSoyLatte.addIngredient(new Milk(80, Milk.Type.SOY));
			largeSoyLatte.addIngredient(new Syrup());
		}
		catch (TooManyIngredientsException e) {
			System.err.println("Too many ingredients for the recipe");
		}
		coffeeShop.addRecipe(largeSoyLatte);
		
		
		coffeeShop.printMenu();
	}
}