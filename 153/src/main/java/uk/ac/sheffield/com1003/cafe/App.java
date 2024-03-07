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

	public static void main (String[]args){
		Cafe cafe = new Cafe();
		Recipe espresso = new Recipe ("Espresso", 1.5, Size.SMALL, 2);
		Recipe despresso = new Recipe("Double Espresso", 2.2, Size.REGULAR,2);
		Recipe soylatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE,3);
		cafe.addRecipe(espresso);
		cafe.addRecipe(despresso);
		cafe.addRecipe(soylatte);
		try {
			espresso.addIngredient(new Coffee());
			espresso.addIngredient(new Water());
			despresso.addIngredient(new Coffee(15));
			despresso.addIngredient(new Water(50));
			soylatte.addIngredient(new Coffee());
			soylatte.addIngredient(new Milk(50,Type.SOY));
			soylatte.addIngredient(new Syrup());
			cafe.placeOrder("Double Espresso","Zach" ,5);
		} catch (TooManyIngredientsException e) {
			System.out.println("Too many Ingredients.");
		} catch (CafeOutOfCapacityException e) {
			
		} catch (RecipeNotFoundException e) {
			
		}
		cafe.printMenu();
		cafe.printPendingOrders();

	}
}
