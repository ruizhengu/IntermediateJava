package uk.ac.sheffield.com1003.cafe;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.stream.Stream;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

/**
 * The main class of the program. Creates instances of the {@link Cafe} and
 * {@link Recipe} classes,
 * adds ingredients to the recipes, adds the recipes to the menu of the cafe and
 * prints the menu.
 * Handles exceptions that might occur during the process.
 */
public class App {

    public static void main(String[] args)
            throws TooManyIngredientsException, RecipeNotFoundException,
            CafeOutOfCapacityException {

        // Cafe instance and Recipe instances
        Cafe cafe = new Cafe();
        Recipe espresso = new Recipe(
                "Espresso",
                1.5,
                Recipe.Size.SMALL,
                2);

        Recipe doubleEspresso = new Recipe(
                "Double Espresso",
                2.2,
                Recipe.Size.REGULAR,
                2);

        Recipe largeSoyLatte = new Recipe(
                "Large Soy Latte",
                2.5,
                Recipe.Size.LARGE,
                2);

        // Code to add ingredients to recipes
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());

        doubleEspresso.addIngredient(new Coffee(15));
        doubleEspresso.addIngredient(new Water(50));

        largeSoyLatte.addIngredient(new Milk(30, Milk.Type.SOY));
        largeSoyLatte.addIngredient(new Water(20));

        // Code to add recipes to the menu
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);
        cafe.printMenu();
    }
}
