package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
public class App {
    public static void main(String[] args) throws TooManyIngredientsException {
        // create a new cafe instance
        Cafe cafe = new Cafe();

        // Create Espresso Recipe
        Recipe espresso = new Recipe("Espresso", 1.5);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());

        // Create Double Espresso Recipe
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2);
        doubleEspresso.addIngredient(new Coffee(15, false));
        doubleEspresso.addIngredient(new Water(50));

        // Create Large Soy Latte Recipe
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5);
        largeSoyLatte.addIngredient(new Coffee());
        largeSoyLatte.addIngredient(new Water());

        // Add Recipes to Cafe
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        // Print the menu
        cafe.printMenu();


    }
}
