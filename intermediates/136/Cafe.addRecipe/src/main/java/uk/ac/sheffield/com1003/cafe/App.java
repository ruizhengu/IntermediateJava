package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException {
		// creates a cafe
        Cafe myCafe = new Cafe("Tammys Cafe");

        //creates a recipe for Espresso
		Recipe esp = new Recipe("Espresso",1.5,Size.SMALL,2);
        esp.addIngredient(new Coffee());
        esp.addIngredient(new Water());
        myCafe.addRecipe(esp);

        //creates another recipe for doubleEspresso
        Recipe doubleEsp = new Recipe("Double Espresso",2.2,Size.REGULAR,2);
        doubleEsp.addIngredient(new Coffee(15));
        doubleEsp.addIngredient(new Water(50));
        myCafe.addRecipe(doubleEsp);

        //creates another recipe for Large Soy Latte
        Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5,Size.LARGE,3);
        largeSoyLatte.addIngredient(new Milk(Type.SOY));
        largeSoyLatte.addIngredient(new Coffee());
        largeSoyLatte.addIngredient(new Water());
		myCafe.addRecipe(largeSoyLatte);

        // prints the Cafe menu
        myCafe.printMenu();

	}
}
