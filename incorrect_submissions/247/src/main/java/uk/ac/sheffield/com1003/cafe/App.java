package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.*;
import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {

	public static void main(String[] args) {
		Cafe myCafe = new Cafe("Little Italy");
		
		//Create three new recipe's with two ingredients each
		try {
			Recipe Espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
			Espresso.addIngredient(new Coffee());
			Espresso.addIngredient(new Water());
			myCafe.addRecipe(Espresso);
			
			Recipe DoubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
			DoubleEspresso.addIngredient(new Coffee(15));
			DoubleEspresso.addIngredient(new Water(50));
			myCafe.addRecipe(DoubleEspresso);
			
			Recipe StrongSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
			StrongSoyLatte.addIngredient(new Milk(30, Type.SOY));
			StrongSoyLatte.addIngredient(new Coffee(100));
			myCafe.addRecipe(StrongSoyLatte);
			
		}catch(TooManyIngredientsException e) {
			System.out.println("Too many ingredients");
		}
		
		myCafe.printMenu();
	}
}
