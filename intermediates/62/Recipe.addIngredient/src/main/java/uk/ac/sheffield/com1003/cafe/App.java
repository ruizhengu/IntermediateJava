package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;


public class App {
	public void main(String[] args) throws TooManyIngredientsException {
		/* Adding a new cafe with Espresso, Double Espresso and Large Soy Latte */
		Cafe cafe1 = new Cafe();
		
		Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
		espresso.addIngredient(new Water());
		espresso.addIngredient(new Coffee());
		
		Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
		espresso.addIngredient(new Water(50));
		espresso.addIngredient(new Coffee(15));
		
		
		Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
		espresso.addIngredient(new Water(15));
		espresso.addIngredient(new Coffee(15));
		espresso.addIngredient(new Milk(30, Type.SOY));
		
		cafe1.addRecipe(espresso);
		cafe1.addRecipe(doubleEspresso);
		cafe1.addRecipe(largeSoyLatte);
		
		cafe1.printMenu();
	}

}
