package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String args[]) {
    	Cafe myCafe = new Cafe();
    	
    	Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
    	try {
			espresso.addIngredient(new Coffee());
		} catch (TooManyIngredientsException e) {
			System.out.println("Too many ingredients");
		}
    	try {
			espresso.addIngredient(new Water());
		} catch (TooManyIngredientsException e) {
			System.out.println("Too many ingredients");
		}
    	myCafe.addRecipe(espresso);
    	
    	Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
    	try {
			doubleEspresso.addIngredient(new Coffee(15));
		} catch (TooManyIngredientsException e) {
			System.out.println("Too many ingredients");
		}
    	try {
			doubleEspresso.addIngredient(new Water(50));
		} catch (TooManyIngredientsException e) {
			System.out.println("Too many ingredients");
		}
    	myCafe.addRecipe(doubleEspresso);
    	
    	Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
    	try {
			largeSoyLatte.addIngredient(new Coffee(20));
		} catch (TooManyIngredientsException e) {
			System.out.println("Too many ingredients");
		}
    	try {
			largeSoyLatte.addIngredient(new Milk(60, Milk.Type.SOY));
		} catch (TooManyIngredientsException e) {
			System.out.println("Too many ingredients");
		}
    	myCafe.addRecipe(largeSoyLatte);
    	
    	myCafe.printMenu();
    }
}
