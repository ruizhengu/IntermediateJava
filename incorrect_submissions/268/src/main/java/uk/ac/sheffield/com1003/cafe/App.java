package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {

    /**
     * This is the main starting point of the application.
     * @param args
     * @throws TooManyIngredientsException
     */
    public static void main(String[] args) throws TooManyIngredientsException {
        // Create a new cafe
        Cafe cafe = new Cafe("Central Perk");

        // Espresso
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        cafe.addRecipe(espresso);

        // Double Espresso
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Coffee(15));
        doubleEspresso.addIngredient(new Water(50));
        cafe.addRecipe(doubleEspresso);

        // Large Soy Latte
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        largeSoyLatte.addIngredient(new Coffee(10));
        largeSoyLatte.addIngredient(new Milk(200, Milk.Type.SOY));
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();
    }
}

