package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main (String [] args) {

        //Task 1

        Cafe cafe = new Cafe();

        // Creating and adding the Espresso Recipe (task 1)
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);

        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            cafe.addRecipe(espresso);
        } catch (TooManyIngredientsException error) {
            System.out.println("Too many ingredients in espresso. Failed to add recipe.");
        }

        // Creating and adding the  Double Espresso Recipe (task 1)

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);

        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            cafe.addRecipe(doubleEspresso);
        } catch (TooManyIngredientsException error) {
            System.out.println("Too many ingredients in doubleEspresso. Failed to add recipe.");
        }

        // Creating and adding the Large Soy Latte Recipe (task 1)

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);

        try {
            largeSoyLatte.addIngredient(new Coffee(15));
            largeSoyLatte.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Milk(250, Milk.Type.SOY));
            cafe.addRecipe(largeSoyLatte);
        } catch (TooManyIngredientsException error) {
            System.out.println("Too many ingredients in largeSoyLatte. Failed to add recipe.");
        }

        // Task 2

        cafe.printMenu();
    }
}
