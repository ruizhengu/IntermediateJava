package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
		public static void main(String[] args) {
			Cafe drink = new Cafe("Nedjm's cafe ",10,100);	
			Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
			Recipe doubleEspresso = new Recipe("DoubleEspresso", 2.2, Size.REGULAR, 2);
			Recipe  largeSoyLatte= new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
			drink.addRecipe(espresso);
			drink.addRecipe(doubleEspresso);
			drink.addRecipe(largeSoyLatte);
			
			try {
		    espresso.addIngredient(new Coffee());
		    espresso.addIngredient(new Water());
		    doubleEspresso.addIngredient(new Coffee(15));
		    doubleEspresso.addIngredient(new Water(50));
		    largeSoyLatte.addIngredient(new Coffee(40));
		    largeSoyLatte.addIngredient(new Milk(100));
		    }
			catch(TooManyIngredientsException exeption){
				System.out.println("There is an exception !! Too many ingredients");
				}
			drink.printMenu();
		    drink.printPendingOrders();
			
			}
}
