package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.*;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {

	public static void main(String[] args) {
		//instantiate new cafe
		Cafe cafe = new Cafe();
		//add recipes
		Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
		try {
			espresso.addIngredient(new Coffee());
			espresso.addIngredient(new Water());
		} catch (TooManyIngredientsException e) {
			e.printStackTrace();
		}
		cafe.addRecipe(espresso);
		
		Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
		try {
			doubleEspresso.addIngredient(new Coffee(15));
			doubleEspresso.addIngredient(new Water(50));
		} catch (TooManyIngredientsException e) {
			e.printStackTrace();
		}
		cafe.addRecipe(doubleEspresso);
		
		Recipe largeSoyLate = new Recipe("Large Soy Late", 2.5, Size.LARGE, 3);
		try {
			largeSoyLate.addIngredient(new Coffee(20));
			largeSoyLate.addIngredient(new Water(50));
			largeSoyLate.addIngredient(new Milk(50, Type.SOY));
		} catch (TooManyIngredientsException e) {
			e.printStackTrace();
		}
		cafe.addRecipe(largeSoyLate);
		
		cafe.printMenu();
	}

}
