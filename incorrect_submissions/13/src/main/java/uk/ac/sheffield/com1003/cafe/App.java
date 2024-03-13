package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main (String [] args) throws TooManyIngredientsException{

        Cafe myCafe = new Cafe("My Cafe");

        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());

        myCafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Coffee(15));
        doubleEspresso.addIngredient(new Water(50));

        myCafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        largeSoyLatte.addIngredient(new Coffee(15));
        largeSoyLatte.addIngredient(new Water(75));
        largeSoyLatte.addIngredient(new Milk(75, Milk.Type.SOY));

        myCafe.addRecipe(largeSoyLatte);

        /* Task 2: calling printMenu() from App.main */
        myCafe.printMenu();

    }
}
