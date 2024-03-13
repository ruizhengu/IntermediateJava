package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;

/**
 * The App class is the main class of the program.
 * It creates a new cafe and adds some recipes to its menu.
 */


public class App {

    /**
     * The main method of the program.
     * It creates new recipes and adds them to the cafe's menu.
     * It then prints the cafe's menu.
     * @param args The command line arguments, which are not used in this program.
    */

    public static void main(String[] args) {
        // Create a new cafe
        Cafe cafe = new Cafe("Central Perk");

        // Create an Espresso recipe
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {
            System.out.println(e.getMessage());
        }

        // Create a Double Espresso recipe
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            System.out.println(e.getMessage());
        }

        // Create a Large Soy Latte recipe
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        try {
            largeSoyLatte.addIngredient(new Coffee());
            largeSoyLatte.addIngredient(new Milk(25, Type.SOY));
            largeSoyLatte.addIngredient(new Water(10));
        } catch (TooManyIngredientsException e) {
            System.out.println(e.getMessage());
        }

        // Add the recipes to the cafe's menu
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        // Print the cafe's menu
        cafe.printMenu();
    }
}
