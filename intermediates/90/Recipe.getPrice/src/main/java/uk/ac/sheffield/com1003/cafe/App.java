package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {

	/**
	 * Makes the recipe's -> Adds recipe to menu -> Prints menu -> Adds an order -> Prints pending orders
	 * @param args
	 */
	public static void main(String[] args) {
		Cafe Luca = new Cafe ("Luca's Cafe");

		Recipe espresso = new Recipe ("Espresso", 1.5, Size.SMALL, 2);
		Recipe doubleEspresso = new Recipe ("Double Espresso", 2.2, Size.REGULAR, 2);
		Recipe largeSoyLatte = new Recipe ("Large Soy Latte", 2.5, Size.LARGE, 3);

		try {
			espresso.addIngredient(new Coffee());
			espresso.addIngredient(new Water());
			System.out.println("Espresso recipe finished");
		} catch (TooManyIngredientsException e) {
			System.out.println("Espresso has reached it's ingredients limit");
		}

		try {
			doubleEspresso.addIngredient(new Coffee(15));
			doubleEspresso.addIngredient(new Water(50));
			System.out.println("Double Espresso recipe finished");
		} catch (TooManyIngredientsException e) {
			System.out.println("Double espresso has reached it's ingredients limit");
		}

		try {
			largeSoyLatte.addIngredient(new Coffee(30));
			largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
			largeSoyLatte.addIngredient(new Syrup("Chocolate"));
			System.out.println("Large Soy recipe finished");
		} catch (TooManyIngredientsException e) {
			System.out.println("Large Soy Latte has reached it's ingredients limit");
		}

		Luca.addRecipe(espresso);
		Luca.addRecipe(doubleEspresso);
		Luca.addRecipe(largeSoyLatte);

		System.out.println("Recipe's added to Cafe");

		Luca.printMenu();

		try {
			Order newOrder1 = new Order(largeSoyLatte, "Luca", 3, "Heart shape on top");
			Luca.placeOrder(largeSoyLatte.getName(), "Luca", 3);
			System.out.println("Here is your receipt");
			newOrder1.printReceipt();
		} catch (CafeOutOfCapacityException e) {
			System.out.println("Our cafe has reached it's capacity");
		} catch (RecipeNotFoundException e) {
			System.out.println("That recipe cannot be found");
		}

		Luca.printPendingOrders();
	}
}
