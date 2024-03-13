package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.*;
import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;


public class App{
    public static void main(String[] args) {

    	Cafe cafe = new Cafe();
        try {
        	Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
			espresso.addIngredient(new Coffee());
			espresso.addIngredient(new Water());
			cafe.addRecipe(espresso);
			
			Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
	        doubleEspresso.addIngredient(new Coffee(15, false));
	        doubleEspresso.addIngredient(new Water(50));
			cafe.addRecipe(doubleEspresso);
			
			Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
	        largeSoyLatte.addIngredient(new Coffee(15, false));
	        largeSoyLatte.addIngredient(new Water(50));
	        largeSoyLatte.addIngredient(new Milk(50, Type.SOY));
	        cafe.addRecipe(largeSoyLatte);
	        
	        
        } catch (TooManyIngredientsException e) {
			// TODO Auto-generated catch block
			System.out.println("There are too many Ingredients!");
		}
        cafe.printMenu();     
    }
    
}
