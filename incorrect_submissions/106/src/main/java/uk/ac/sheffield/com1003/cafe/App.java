package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.exceptions.*;

public class App {
    public static void main(String[] args) {
        // Create my cafe
        Cafe myCafe = new Cafe("Barista", 5, 2);

        // Add some beverages into the recipe class
        Recipe[] items = {
            new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2), // Coffee (default) and Water (default)
            new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2), // Coffee (15g) and Water (50ml)
            new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3) // Coffee (15g), Water (50ml) and Milk (100ml - Soy)
        };

        // Add recipes to the cafe
        for (Recipe recipe : items) {
            myCafe.addRecipe(recipe);
        }

        // Add ingredients to the recipes
        try {
            // Add ingredients to the Espresso recipe
            items[0].addIngredient(new Coffee());
            items[0].addIngredient(new Water());
            // Add ingredients to the Double Espresso recipe
            items[1].addIngredient(new Coffee(15));
            items[1].addIngredient(new Water(50));
            // Add ingredients to the Large Soy Latte recipe
            items[2].addIngredient(new Milk(15, Milk.Type.SOY));
            items[2].addIngredient(new Water(30));
            items[2].addIngredient(new Coffee(12));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients");
        }

        // Print out the menu
        myCafe.printMenu();

        // Place an order
        try {
            myCafe.placeOrder("Espresso", "John", 3);
        } catch (RecipeNotFoundException e) {
            System.out.println(e.getRecipeName() + " is not a valid recipe");
        } catch (CafeOutOfCapacityException e) {
            System.out.println(e.getMessage());
        }      
        
    }
}
