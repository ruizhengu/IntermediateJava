package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException {
        Cafe cafe = new Cafe("The Cafe");
        Recipe espresso = new Recipe("Espresso", 1.50, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.20, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.50, Recipe.Size.LARGE, 3);

        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {
            // Prints an error message when there are too many ingredients and rethrows the exception
            System.err.println(e + ": The recipe " + espresso.getName() + " has too many ingredients");
            throw e;
        }

        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            // Prints an error message when there are too many ingredients and rethrows the exception
            System.err.println(e + ": The recipe " + doubleEspresso.getName() + " has too many ingredients");
            throw e;
        }
        try {
            largeSoyLatte.addIngredient(new Milk(40, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Water(40));
            largeSoyLatte.addIngredient(new Coffee(8));
            largeSoyLatte.addIngredient(new Syrup());
        } catch (TooManyIngredientsException e) {
            // Prints an error message when there are too many ingredients and rethrows the exception
            System.err.println(e + ": The recipe " + largeSoyLatte.getName() + " has too many ingredients");
            throw e;
        }

        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();
    }
}
