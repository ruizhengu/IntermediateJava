package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App{
	public static void main(String[] args) throws TooManyIngredientsException {
		
		//Create cafe object
		
		Cafe myCafe = new Cafe("Central Perk");
		
		
		//add recipes and handle possible exception
		
		Recipe Espresso = new Recipe("Espresso",1.5, Size.SMALL,2);
		myCafe.addRecipe(Espresso);
		Ingredient coffee = new Coffee(8,false);
		Ingredient water = new Water();
		Espresso.addIngredient(coffee);
		Espresso.addIngredient(water);
		
		Recipe DoubleEspresso = new Recipe("Double Espresso",2.2,Size.REGULAR,
				2);
		myCafe.addRecipe(DoubleEspresso);
		Ingredient doubleCoffee = new Coffee(16,false);
		Ingredient doubleWater = new Water(50);
		Espresso.addIngredient(doubleCoffee);
		Espresso.addIngredient(doubleWater);
		
		Recipe LSoyLatte = new Recipe("Large Soy Latte",2.5,Size.LARGE,3);
		myCafe.addRecipe(LSoyLatte);
		Ingredient LSLWater = new Water(200);
		Ingredient LSLMilk = new Milk(30,Type.SOY);

		LSoyLatte.addIngredient(LSLMilk);
		LSoyLatte.addIngredient(LSLWater);
		LSoyLatte.addIngredient(coffee);
		
		//print menu
		
		myCafe.printMenu();
	}
}