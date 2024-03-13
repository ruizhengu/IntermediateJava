package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
	
	public static void main(String[] args) {
		
		Cafe cafe = new Cafe("Nero");

		try {
			Recipe espresso = new Recipe("Espresso", 1.5,Size.SMALL,2);
			espresso.addIngredient(new Coffee());
			espresso.addIngredient(new Water());
			cafe.addRecipe(espresso);
			
			Recipe doubleEspresso = new Recipe("Double Espresso", 2.2,Size.REGULAR, 2);
			doubleEspresso.addIngredient(new Coffee(15));
			doubleEspresso.addIngredient(new Water(50));
			cafe.addRecipe(doubleEspresso);
			
			Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5,Size.LARGE,3);
			largeSoyLatte.addIngredient(new Coffee());
			largeSoyLatte.addIngredient(new Water());
			largeSoyLatte.addIngredient(new Milk(100,Type.SOY));
			cafe.addRecipe(largeSoyLatte);
		} catch (TooManyIngredientsException e) {
			e.printStackTrace();
		}
		
		cafe.printMenu();
		

	}

}
