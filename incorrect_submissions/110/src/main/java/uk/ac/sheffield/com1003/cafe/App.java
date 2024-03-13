package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;

/**
 * App
 *
 */
public class App {
    public static void main(String[] args) {

        Cafe MyCafe = new Cafe("My Cafe");

        /* Menu */
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
        try {
            largeSoyLatte.addIngredient(new Coffee(8, true));
            largeSoyLatte.addIngredient(new Milk(100, Type.SOY));
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }

        /* Add to Menu */
        MyCafe.addRecipe(espresso);
        MyCafe.addRecipe(doubleEspresso);
        MyCafe.addRecipe(largeSoyLatte);

        /* Print Menu */
        MyCafe.printMenu();

    }
}
