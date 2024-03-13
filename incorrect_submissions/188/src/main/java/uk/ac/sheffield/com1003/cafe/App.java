package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
	public static void main(String args[])
	{
		//Defining and setting up recipes
		Recipe espresso = new Recipe("Espresso",1.5,Size.SMALL,2);
		Recipe doubleEspresso = new Recipe("Double Espresso",2.2,Size.REGULAR,2);
		Recipe soyLatteL = new Recipe("Large Soy Latte",2.5,Size.LARGE,2);
		try {
			espresso.addIngredient(new Coffee());
			espresso.addIngredient(new Water());
			doubleEspresso.addIngredient(new Coffee(15));
			doubleEspresso.addIngredient(new Water(50));
			soyLatteL.addIngredient(new Milk(100, Type.SOY));
			soyLatteL.addIngredient(new Coffee(20));
		} catch (TooManyIngredientsException e) {
			System.out.println("Too many ingredients.");
		}
		
		//Defining and setting up cafe
		Cafe com1003Cafe = new Cafe("COM1003 Cafe");
		com1003Cafe.addRecipe(espresso);
		com1003Cafe.addRecipe(doubleEspresso);
		com1003Cafe.addRecipe(soyLatteL);
		
		//Using cafe
		com1003Cafe.printMenu();
		try {
			com1003Cafe.placeOrder("Double Espresso", "Nahyan", 2.2);
		} catch (CafeOutOfCapacityException e) {
			System.out.println("Cafe out of capacity");
		} catch (RecipeNotFoundException e) {
			System.out.println("Recipe not in menu: Error 1.");
		}
		com1003Cafe.printPendingOrders();
		com1003Cafe.serveOrder();
		try {
			com1003Cafe.removeRecipe("Espresso");
		} catch (RecipeNotFoundException e) {
			System.out.println("Recipe not in menu: Error 2.");
		}
	}
}
