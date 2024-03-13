package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.*;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.Order.*;
import uk.ac.sheffield.com1003.cafe.Cafe.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.*;


public class App {
	public static void main (String[] args) throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException {
		Cafe Cafe = new Cafe();
		Recipe espresso = new Recipe("Espresso",1.5,Size.SMALL,2);
		espresso.addIngredient(new Coffee());
		espresso.addIngredient(new Water());
		Cafe.addRecipe(espresso);
		Recipe doubleEspresso = new Recipe("Double Espresso",2.2,Size.REGULAR,2);
		doubleEspresso.addIngredient(new Coffee(15, false));
		doubleEspresso.addIngredient(new Water(50));
		Cafe.addRecipe(doubleEspresso);
		Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5,Size.LARGE,3);
		largeSoyLatte.addIngredient(new Coffee());
		largeSoyLatte.addIngredient(new Water());
		largeSoyLatte.addIngredient(new Milk(100, Type.SOY));
		Cafe.addRecipe(largeSoyLatte);
		Cafe.printMenu();
		Cafe.placeOrder("Espresso", "Arya",5);
		Cafe.serveOrder();
		Cafe.printPendingOrders();
		Cafe.removeRecipe("Espresso");
		Cafe.printMenu();
		
	}
	
}
