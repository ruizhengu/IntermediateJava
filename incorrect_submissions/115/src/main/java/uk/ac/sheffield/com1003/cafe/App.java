package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {

	public static void main(String[] args) throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException {
		Cafe c = new Cafe();
		
		Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
		Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
		Recipe largeSoyLatte = new Recipe("Large Soy Latte", 3.5, Size.LARGE, 3);
		
		Coffee coffee1 = new Coffee();
		Water water1 = new Water();
		espresso.addIngredient(coffee1);
		espresso.addIngredient(water1);
		
		Coffee coffee2 = new Coffee(15);
		Water water2 = new Water(50);
		doubleEspresso.addIngredient(coffee2);
		doubleEspresso.addIngredient(water2);
		
		Coffee coffee3 = new Coffee(20);
		Water water3 = new Water(20);
		Milk milk1 = new Milk(60, Type.SOY);
		largeSoyLatte.addIngredient(coffee3);
		largeSoyLatte.addIngredient(water3);
		largeSoyLatte.addIngredient(milk1);

		c.addRecipe(espresso);
		c.addRecipe(doubleEspresso);
		c.addRecipe(largeSoyLatte);
		
		c.printMenu();
	}

}
