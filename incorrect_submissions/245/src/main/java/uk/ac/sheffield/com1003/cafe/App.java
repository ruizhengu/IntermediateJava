package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;


public class App {
	public static void main(String[] args) {
		Cafe cafe = new Cafe();
		
		//Creates a new espresso recipe and adds it to the menu.
		Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
		try {
			espresso.addIngredient(new Coffee());
			espresso.addIngredient(new Water());
		} catch (TooManyIngredientsException e) {
			System.out.println("Too many ingredients!");
		}
		cafe.addRecipe(espresso);
		
		//Creates a new double espresso recipe and adds it to the menu.
		Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
		try {
		doubleEspresso.addIngredient(new Coffee(15,false));
		doubleEspresso.addIngredient(new Water(50));
		} catch (TooManyIngredientsException e) {
			System.out.println("Too many ingredients!");
		}
		cafe.addRecipe(doubleEspresso);
		
		//Creates a new soy latte recipe and adds it to the menu.
		Recipe soyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
		try {
		soyLatte.addIngredient(new Coffee(20,false));
		soyLatte.addIngredient(new Milk(70,Type.SOY));
		} catch (TooManyIngredientsException e) {
			System.out.println("Too many ingredients!");
		}
		cafe.addRecipe(soyLatte);
	}

}
