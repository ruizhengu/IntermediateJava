package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

/** App is the main class of the project. */
public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe("CafeFoo");

        // Task 1: Add three recipes
        try {
            Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            cafe.addRecipe(espresso);
            System.out.println("Added recipe: " + espresso.getName());
        } catch (TooManyIngredientsException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            cafe.addRecipe(doubleEspresso);
            System.out.println("Added recipe: " + doubleEspresso.getName());
        } catch (TooManyIngredientsException e) {
            System.out.println(e.getMessage());
        }

        try {
            Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
            largeSoyLatte.addIngredient(new Coffee(10));
            largeSoyLatte.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Milk(15, Milk.Type.SOY));
            cafe.addRecipe(largeSoyLatte);
            System.out.println("Added recipe: " + largeSoyLatte.getName());
        } catch (TooManyIngredientsException e) {
            System.out.println(e.getMessage());
        }

        // Task 2: Call printMenu
        cafe.printMenu();
    }
}
