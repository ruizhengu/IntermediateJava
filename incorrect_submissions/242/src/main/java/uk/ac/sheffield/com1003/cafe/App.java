/**
 * This class represents an application that creates a Cafe instance
 * and adds three drink Recipe instances to it.
 *
 * The drink recipes are Espresso, Double Espresso, and Large Soy Latte.
 *
 * @see Cafe
 * @see Recipe
 * @see Coffee
 * @see Water
 * @see Milk
 */
package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;


public class App {

	public static void main(String[] args) {
		Cafe cafe = new Cafe();

	    // create Espresso recipe
	    Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
	    try {
	        espresso.addIngredient(new Coffee());
	        espresso.addIngredient(new Water());
	    } catch (TooManyIngredientsException e) {
	        System.err.println("Too many ingredients added to recipe.");
	    }
	    cafe.addRecipe(espresso);

	    // create Double Espresso recipe
	    Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
	    try {
	        doubleEspresso.addIngredient(new Coffee(15));
	        doubleEspresso.addIngredient(new Water(50));
	    } catch (TooManyIngredientsException e) {
	        System.err.println("Too many ingredients added to recipe.");
	    }
	    cafe.addRecipe(doubleEspresso);

	    // create Large Soy Latte recipe
	    Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
	    try {
	        largeSoyLatte.addIngredient(new Coffee(12));
	        largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
	        largeSoyLatte.addIngredient(new Water(28));
	    } catch (TooManyIngredientsException e) {
	        System.err.println("Too many ingredients added to recipe.");
	    }
	    cafe.addRecipe(largeSoyLatte);
	    
	    cafe.printMenu();

	}

}
