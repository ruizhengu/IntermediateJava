package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

/** Main App class for personal cafe creation */

public class App {

    public static void main(String[] args) {
        // Create Cafe (10 menu items and 100 order capacity)
        Cafe georgesAmazingCafe = new Cafe("George's Amazing Cafe");

        // Create Espresso recipe
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Water());
            espresso.addIngredient(new Coffee());
        } catch (TooManyIngredientsException e) {
            System.out.println("There are too many ingredients added to the Espresso recipe");
        }

        // Create Double Espresso recipe
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Water(50));
            doubleEspresso.addIngredient(new Coffee(15));
        } catch (TooManyIngredientsException e) {
            System.out.println("There are too many ingredients added to the Double Espresso recipe");
        }

        // Create the Large Soy Latte recipe
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        try {
            largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Coffee(15));
        } catch (TooManyIngredientsException e) {
            System.out.println("There are too many ingredients added to the Large Soy Latte recipe");
        }

        // Add the recipes to the cafe
        georgesAmazingCafe.addRecipe(espresso);
        georgesAmazingCafe.addRecipe(doubleEspresso);
        georgesAmazingCafe.addRecipe(largeSoyLatte);

        // Print the menu
        georgesAmazingCafe.printMenu();
    }

}
