package uk.ac.sheffield.com1003.cafe;

import java.awt.Window.Type;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {

	public static void main(String[] args) {
		Cafe mycafe = new Cafe("My Cafe",10,100); //Create a new cafe
		
		//New esspresso recipe created with default amounts of ingredients 
		Recipe esspresso = new Recipe("Espresso",2.5,Recipe.Size.SMALL,2);
		try {
		  esspresso.addIngredient( new Coffee() );
		  esspresso.addIngredient(new Water() );
	    } catch (TooManyIngredientsException e) {
		System.out.print("Too many ingredients"); //Exception handler
	    }
		mycafe.addRecipe(esspresso);
		
		//Recipe doubleesspresso created
		Recipe doubleesspresso = new Recipe("Double Esspresso",2.2,Recipe.Size.REGULAR,2);
		try {
			doubleesspresso.addIngredient(new Coffee(15) ); //Default amounts of coffee and water overloaded
			doubleesspresso.addIngredient(new Water(50) );
		} catch (TooManyIngredientsException e) {
			System.out.print("Too many ingredients");
		}
		mycafe.addRecipe(doubleesspresso);
		
		//Recipe largesoy created
	    Recipe largesoylatte = new Recipe("Large Soy Latte",2.5,Recipe.Size.LARGE,2);
	    try {
		    largesoylatte.addIngredient(new Coffee(15) );
		    largesoylatte.addIngredient(new Milk(100, Milk.Type.SOY)); 
	    } catch (TooManyIngredientsException e) {
		    System.out.print("Too many ingredients");
	    }
	    mycafe.addRecipe(largesoylatte);
	    
	    mycafe.printMenu();
	}
}
		

