package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

public class App {
    public static void main(String [] args) {
        // Setup cafe
        Cafe cafe = new Cafe();

        // Setup recipes
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);

        // Add ingredients
        try {
            // Espresso
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

            // Double Espresso
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));

            // Large Soy Latte
            largeSoyLatte.addIngredient(new Coffee(30));
            largeSoyLatte.addIngredient(new Milk(50, Milk.Type.SOY));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients: " + e);
        }

        // Add recipes
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        // Print the menu
        cafe.printMenu();
    }
}
