/**
* App.java
*
* @version 13/03/2023
*
* @author Artem Vakhutinskiy
*/

package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args) {
        // Task 1
        Cafe cafe = new Cafe();

        // Resipes
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, 
            Size.REGULAR, 2);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, 
            Size.LARGE, 3);
        
        // Ingredients
        Ingredient coffee = new Coffee();
        Ingredient water = new Water();
        Ingredient doubleCoffee = new Coffee(15, false);
        Ingredient doubleWater = new Water(50);
        Ingredient soyMilk = new Milk(180, Type.SOY);

        // Espresso
        try {
            espresso.addIngredient(coffee);
            espresso.addIngredient(water);
        } catch (TooManyIngredientsException e) {
            System.err.println("Too many ingredients in esspresso");
        }

        // Double Espresso
        try {
            doubleEspresso.addIngredient(doubleCoffee);
            doubleEspresso.addIngredient(doubleWater);
        } catch (TooManyIngredientsException e) {
            System.err.println("Too many ingredients in double esspresso");
        }

        // Large Soy Latte
        try {
            largeSoyLatte.addIngredient(coffee);
            largeSoyLatte.addIngredient(water);
            largeSoyLatte.addIngredient(soyMilk);
        } catch (TooManyIngredientsException e) {
            System.err.println("Too many ingredients in large soy latte");
        }

        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        System.out.println();
        System.out.println("Task 1");
        System.out.println("Cafe instance is created with the following three drink Recipe instances:");
        System.out.println("1. " + espresso.getName());
        System.out.println("2. " + doubleEspresso.getName());
        System.out.println("3. " + largeSoyLatte.getName());

        // Task 2
        System.out.println();
        System.out.println("Task 2");
        System.out.println("Menu: ");
        cafe.printMenu();

        
    }
}
