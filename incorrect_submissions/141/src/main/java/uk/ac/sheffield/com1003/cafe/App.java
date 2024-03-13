package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;

public class App {

	//method which iteratively adds a group of ingredients to a recipe, added to clean up code
	public static void addIngredientsToRecipe(Recipe recipie, Ingredient[] ingredients) {
		try {
			for(int i = 0; i < ingredients.length; i++) {
				recipie.addIngredient(ingredients[i]);
			}
		}
		catch(TooManyIngredientsException e){
			System.out.println(e.getMessage());
		}	
	}
	
	//iteratively creates a menu for a specified cafe, using a given group of recipes. Added to clean up code
	public static void createMenu(Cafe cafe, Recipe[] recipes) {
		for(int i = 0; i < recipes.length; i++) {
			if(!cafe.addRecipe(recipes[i]))				
				System.out.print("No space in the menu of " + cafe.getName() + ". Recipe not added.");
		}
	}
	
	////////TASK 1////////////
	public static void main(String[] args) {
		
		
	//creating 3 groups of ingredients and 3 corresponding recipes: espresso, double espresso and large soy latte
	//uses addIngredientsToRecipe() to iteratively add each respective instantiated array of ingredients to its corresponding recipe
		Ingredient[] espressoIngredients = new Ingredient[] {
				new Coffee(8,false),
				new Water(),
				new Milk()
		};	
		Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
		addIngredientsToRecipe(espresso, espressoIngredients);
		
		Ingredient[] doubleEspressoIngredients = new Ingredient[] {
				new Coffee(15,false),
				new Water(50)
		};
		Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
		addIngredientsToRecipe(doubleEspresso, doubleEspressoIngredients);
		
		Ingredient[] LargeSoyLatteIngredients = new Ingredient[] {
				new Coffee(20,false),
				new Water(20),
				new Milk(75, Milk.Type.SOY)
		};
		Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
		addIngredientsToRecipe(largeSoyLatte, LargeSoyLatteIngredients);
		
		//creating a menu (group of recipes) using the previously defined recipes, for a newly defined cafe
		Recipe[] recipes = new Recipe[] {
				espresso,
				doubleEspresso,
				largeSoyLatte
		};
		
		Cafe cafeAmor = new Cafe("Cafe Amor");
		createMenu(cafeAmor, recipes);
		/////////////////////////////
		
		
		/////TASK 2/////////
		cafeAmor.printMenu();
		

	}

}
