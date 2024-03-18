package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.exceptions.*;

public class App {
	
	public static void main(String[] args) {
		
		Cafe myCafe = new Cafe("My Place",3,5);
		Recipe espresso = new Recipe("Espresso",1.50,Size.SMALL,2);
		Recipe doubleEspresso = new Recipe("Double Espresso",2.20,Size.REGULAR,2);
		Recipe lSoyLatte = new Recipe("Large Soy Latte",2.50,Size.LARGE,2);
		try {
			espresso.addIngredient(new Coffee());
			espresso.addIngredient(new Water());
			doubleEspresso.addIngredient(new Coffee(15));
			doubleEspresso.addIngredient(new Water(50));
			lSoyLatte.addIngredient(new Coffee());
			lSoyLatte.addIngredient(new Milk());
			
		}catch(TooManyIngredientsException e) {
			System.err.println("Too many ingredients added");
		}
		myCafe.addRecipe(espresso);
		myCafe.addRecipe(doubleEspresso);
		myCafe.addRecipe(lSoyLatte);
		try {
			myCafe.removeRecipe("Large Soy Latte");
		}catch(RecipeNotFoundException e) {
			System.err.println("Recipe not found");
		}
		myCafe.printMenu();
		try {
			myCafe.placeOrder("Espresso","John", 0.0); 
		}catch(CafeOutOfCapacityException e) {
			System.err.println("Cafe cannot receive more orders");
		}catch(RecipeNotFoundException e) {
			System.err.println("Recipe not found");
		}
        myCafe.printPendingOrders();
		espresso.testing(doubleEspresso);
	}

}
