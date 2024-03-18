/**
 * App.java
 * The App class represents the main class of the cafe application.
 * Uses other classes including Cafe, Recipe, Coffee, Water, Milk, and their respective exceptions.
 * @version 1.0 10/03/2023
 * @author Unknown
 */

package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {

    /**
     * Main method that initializes the Cafe object, adds recipes to its menu, and prints the menu to the console.
     * @param args array of command-line arguments
     */
    public static void main(String[] args) {
        Cafe cafe = new Cafe("Moonbucks");

        try {
            Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2 );
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            cafe.addRecipe(espresso);

            Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));
            cafe.addRecipe(doubleEspresso);

            Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
            largeSoyLatte.addIngredient(new Coffee(60, false));
            largeSoyLatte.addIngredient(new Milk(300, Milk.Type.SOY));
            cafe.addRecipe(largeSoyLatte);

        } catch (TooManyIngredientsException e) {
            System.out.println(e.getMessage());
        }

        cafe.printMenu();
    }
}
