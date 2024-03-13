package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;

public class App {
	public static void main (String[] args) {

		Cafe myCafe = new Cafe();
		// create recipe objects
		Recipe[] myRecipies = {
			new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2),
			new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2),
			new Recipe("Large Soy Late", 2.5, Recipe.Size.LARGE, 3)};

		// add ingredients to recipies
		try{
			myRecipies[0].addIngredient(new Coffee());
			myRecipies[0].addIngredient(new Water());
			myRecipies[1].addIngredient(new Coffee(15, false));
			myRecipies[1].addIngredient(new Water(50));
			myRecipies[2].addIngredient(new Coffee(15, false));
			myRecipies[2].addIngredient(new Water(50));
			myRecipies[2].addIngredient(new Milk(200, Type.SOY));
		} catch (TooManyIngredientsException e){
			System.out.println("too many ingredients!!");
		}
		
		//add recipies to cafe
		for (Recipe r : myRecipies) {
			myCafe.addRecipe(r);
			}

		// print menu
		myCafe.printMenu();


	}
}
