package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;

public class App {
    public static void main(String[] args) {
        // Task 1 - Create cafe and set up the menu
        System.out.println("Welcome! Your cafe is being created.");
        Cafe cafe = new Cafe();

        // Create drinks
        Recipe expresso = new Recipe("Expresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            expresso.addIngredient(new Coffee());
            expresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {
            System.out.println("Tried adding too many ingredients to Expresso");
        }

        Recipe doubleExpresso = new Recipe("Double Expresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleExpresso.addIngredient(new Coffee(15));
            doubleExpresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            System.out.println("Tried adding too many ingredients to Double Expresso");
        }

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        try {
            largeSoyLatte.addIngredient(new Coffee(20));
            largeSoyLatte.addIngredient(new Water(60));
            largeSoyLatte.addIngredient(new Milk(360, Milk.Type.SOY));
        } catch (TooManyIngredientsException e) {
            System.out.println("Tried adding too many ingredients to Large Soy Latte");
        }

        // Add drinks to cafe
        if (!cafe.addRecipe(expresso))
            System.out.println("Expresso could not be added - The menu is full!");
        if (!cafe.addRecipe(doubleExpresso))
            System.out.println("Double Expresso could not be added - The menu is full!");
        if (!cafe.addRecipe(largeSoyLatte))
            System.out.println("Large Soy Latte could not be added - The menu is full!");

        System.out.println();
        System.out.println("Drinks added!");
        System.out.println();


        // Task 2 - Display the menu
        cafe.printMenu();
        System.out.println();
        System.out.println("Menu displayed!");
        System.out.println();
    }
}
