package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
	public static void main(String[] args) throws Exception {
		Cafe cafe = new Cafe();
		
		// Create default recipes with ingredients
		// Not handling exceptions as they are expected to be setup correctly
		Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
		espresso.addIngredient(new Coffee());
		espresso.addIngredient(new Water());

		
		Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
		doubleEspresso.addIngredient(new Coffee(15));
		doubleEspresso.addIngredient(new Water(50));
		
		Recipe soyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 1);
		soyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
		
		cafe.addRecipe(espresso);
		cafe.addRecipe(doubleEspresso);
		cafe.addRecipe(soyLatte);
		
		cafe.printMenu();
	}
}
