package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
	public static void main(String[] args) {

		Cafe cafe = new Cafe("Cafe", 3, 100);
		// Initalize recipies
		Recipe espressoRecipe = new Recipe("Espresso", 1.50, Size.SMALL, 2);
		Recipe doubleEspressoRecipe = new Recipe("Double Espresso", 2.20, Size.REGULAR, 2);
		Recipe largeSoyLatteRecipe = new Recipe("Large Soy Latte", 2.50, Size.LARGE, 3);

		try {
			// Add ingredients to recipies
			espressoRecipe.addIngredient(new Coffee(8));
			espressoRecipe.addIngredient(new Water(30));

			doubleEspressoRecipe.addIngredient(new Coffee(15));
			doubleEspressoRecipe.addIngredient(new Water(50));

			largeSoyLatteRecipe.addIngredient(new Coffee(12));
			largeSoyLatteRecipe.addIngredient(new Water(40));
			largeSoyLatteRecipe.addIngredient(new Milk(10, Milk.Type.SOY));
		} catch (TooManyIngredientsException ex) {
			System.out.println("Initalization of one or more recipies' ingredients failed. Expected less ingredients");
			ex.printStackTrace();
			System.exit(0);
		} 

		cafe.addRecipe(espressoRecipe);
		cafe.addRecipe(doubleEspressoRecipe);
		cafe.addRecipe(largeSoyLatteRecipe);
		
		try {
			cafe.placeOrder("Double Espresso", "matt", 3);
			cafe.placeOrder("asdsa", "matt", 3);
			cafe.serveOrder();
		} catch (CafeOutOfCapacityException ex) {
			System.out.println(ex);
		} catch (RecipeNotFoundException ex) {
			System.out.println(ex);
		}

		cafe.printMenu();
		cafe.printPendingOrders();

	}
}
