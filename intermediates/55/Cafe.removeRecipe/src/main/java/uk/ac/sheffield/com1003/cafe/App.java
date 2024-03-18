package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.ingredients.Unit;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;



public class App {
	public static void main(String[] args) throws RecipeNotFoundException, CafeOutOfCapacityException, TooManyIngredientsException {
		Cafe cafe = new Cafe();
		
		//Recipe for Espresso Task-1
		Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2) ;
		Coffee coffee = new Coffee("Coffee", Unit.GR, 8);
		espresso.addIngredient(coffee);
		Water water = new Water("Water", Unit.ML, 30);
		espresso.addIngredient(water);
		//Check if the ingredients are added successfully
		//System.out.println(espresso.isReady());
		//returns true
		
		//Recipe for Double Espresso Task-1	
		Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
		//Coffee coffee2 = new Coffee("Coffee", Unit.GR, 15);
		Coffee coffee2 = new Coffee(15);
		doubleEspresso.addIngredient(coffee2);
		//Water water2 = new Water("Water", Unit.ML, 50);
		Water water2 = new Water(50);
		doubleEspresso.addIngredient(water2);
		//Check if the ingredients are added successfully
		//System.out.println(doubleEspresso.isReady());
		//returns true
		
		//Recipe for Large Soy Latte Task-1
		Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
		Milk milk = new Milk(Type.SOY);
		largeSoyLatte.addIngredient(milk);
		Coffee coffee3 = new Coffee("Coffee", Unit.GR, 10);
		largeSoyLatte.addIngredient(coffee3);
		Water water3 = new Water("Water", Unit.ML, 20);
		largeSoyLatte.addIngredient(water3);
		//Check if the ingredients are added successfully
		//System.out.println(largeSoyLatte.isReady());
		//return true
		
		
		
		//Adding recipes to the menu for Task-1
		cafe.addRecipe(espresso);
		cafe.addRecipe(doubleEspresso);
		cafe.addRecipe(largeSoyLatte);
		//Check if the recipes are succeffully added to the menu
		//System.out.println(cafe.addRecipe(espresso));  //returns true
		//System.out.println(cafe.addRecipe(doubleEspresso));   //returns true
		//System.out.println(cafe.addRecipe(largeSoyLatte));   //returns true
		
		
		

		//Printing menu for Task-2
		cafe.printMenu() ;
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		
		
		//Place order for Task-3
		cafe.placeOrder("Espresso", "Jose", 3);
		cafe.serveOrder();
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		
		
		//Print pending orders for task-4
		cafe.printPendingOrders();
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		
		//Checking if 2 recipes are equal for Task-5
		//Sample recipe for testing compareRecipes
		Recipe americano = new Recipe("Americano", 1.5, Size.SMALL, 2);
		Coffee coffee4 = new Coffee("Coffee", Unit.GR, 8);
		americano.addIngredient(coffee4);
		Water water4 = new Water("Water", Unit.ML, 30);
		americano.addIngredient(water4);
		//System.out.println(americano.isReady());    //returns true
		System.out.println(espresso.compareRecipes(espresso, americano));
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		
		
		//Created a class called Syrup.java under ingredients for Task-6
		
		
		//Task-7 Removing a given recipe from the menu and throwing RecipeNotFoundException
		cafe.removeRecipe("Double Espresso");
		
		
		
	}
}
