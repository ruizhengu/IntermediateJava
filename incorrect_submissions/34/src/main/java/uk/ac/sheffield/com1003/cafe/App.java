package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cafe newCafe = new Cafe("New Cafe");
		
		Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
		newCafe.addRecipe(espresso);
		
		try {
			espresso.addIngredient(new Coffee());
			espresso.addIngredient(new Water());
		} catch (TooManyIngredientsException e) {
			e.printStackTrace();
		}
		
		Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
		newCafe.addRecipe(doubleEspresso);
		
		try {
			doubleEspresso.addIngredient(new Coffee(15, false));
			doubleEspresso.addIngredient(new Water(50));
		} catch (TooManyIngredientsException e) {
			e.printStackTrace();
		}
		
		Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
		newCafe.addRecipe(largeSoyLatte);
		
		try {
			largeSoyLatte.addIngredient(new Coffee(15, false));
			largeSoyLatte.addIngredient(new Milk(30, Type.SOY));
		} catch (TooManyIngredientsException e) {
			e.printStackTrace();
		}
		
		newCafe.printMenu();
		
		try {
			
			newCafe.placeOrder("Espresso", "Dan", 1.5);
			
		} catch (RecipeNotFoundException e) {

		} catch (CafeOutOfCapacityException e) {

		}
		
		newCafe.printPendingOrders();
		
		System.out.println(doubleEspresso.equals(largeSoyLatte)); 
		
		System.out.println(new Syrup().toString());
		
		
		
		

	}

}
