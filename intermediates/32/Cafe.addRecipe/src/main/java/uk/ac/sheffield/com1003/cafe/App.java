package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

/**
 * This class creates a Cafe instance with 3 drink Recipe instances added.
 * The menu is then printed.
 */

public class App {
    public static void main(String args[]) throws TooManyIngredientsException {
        Cafe myCafe = new Cafe("Central Perk");
        System.out.println("Created cafe " + myCafe.getName());
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.
                SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        myCafe.addRecipe(espresso);

        Recipe dblEspresso = new Recipe("Double Espresso", 2.2, 
                Recipe.Size.REGULAR, 2);
        dblEspresso.addIngredient(new Coffee(15));
        dblEspresso.addIngredient(new Water(50));
        myCafe.addRecipe(dblEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, 
                Recipe.Size.LARGE, 2);
        largeSoyLatte.addIngredient(new Coffee());
        largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
        myCafe.addRecipe(largeSoyLatte);

        myCafe.printMenu();
    }
}
