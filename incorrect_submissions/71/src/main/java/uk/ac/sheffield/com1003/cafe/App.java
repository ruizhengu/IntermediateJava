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
		Cafe cafe1 = new Cafe();
		
		
		Recipe espresso = new Recipe("Espresso",1.5,Size.SMALL,2);
		try {
			espresso.addIngredient(new Coffee());
			espresso.addIngredient(new Water());
		} catch (TooManyIngredientsException e) {
			System.out.println("Too many ingredients!");
		}
		cafe1.addRecipe(espresso);
		
		
		
		Recipe doubleEspresso = new Recipe("Double Espresso",2.2,Size.REGULAR,2);
		try {
			doubleEspresso.addIngredient(new Coffee(15));
			doubleEspresso.addIngredient(new Water(50));
		} catch (TooManyIngredientsException e) {
			System.out.println("Too many ingredients!");
		}
		cafe1.addRecipe(doubleEspresso);
		
		
		
		Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5,Size.LARGE,3);
		try {
			largeSoyLatte.addIngredient(new Coffee(15));
			largeSoyLatte.addIngredient(new Water(30));
			largeSoyLatte.addIngredient(new Milk(45,Type.SOY));
		} catch (TooManyIngredientsException e) {
			System.out.println("Too many ingredients!");
		}
		cafe1.addRecipe(largeSoyLatte);
		
		
		cafe1.printMenu();
	}

}
