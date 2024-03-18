package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args) {
        //Creates a new instance of Cafe
        Cafe cafe = new Cafe("Central Perk");

        //3 recipes for the Cafe
        Recipe recipe1 = new Recipe("Espresso", 1.50, Recipe.Size.SMALL, 2);
        Recipe recipe2 = new Recipe("Double Espresso", 2.20, Recipe.Size.REGULAR, 2);
        Recipe recipe3 = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 4);

        //Ingredients
        Coffee smallCoffee = new Coffee();
        Coffee regularCoffee = new Coffee(15, false);
        Coffee largeCoffee = new Coffee(25, false);
        Water smallWater = new Water();
        Water regularWater = new Water(50);
        Water largeWater = new Water(75);
        Milk milk = new Milk();
        Milk soy = new Milk(150, Milk.Type.SOY);
        Syrup maple = new Syrup(30, "Maple");

        //Adding ingredients to recipes
        try {
            recipe2.addIngredient(regularWater);
            recipe3.addIngredient(soy);
            recipe3.addIngredient(largeCoffee);
            recipe3.addIngredient(largeWater);
            recipe3.addIngredient(maple);
            recipe2.addIngredient(regularCoffee);
            recipe1.addIngredient(smallWater);
            recipe1.addIngredient(smallCoffee);
        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }

        //Adding recipe to cafe menu
        cafe.addRecipe(recipe1);
        cafe.addRecipe(recipe2);
        cafe.addRecipe(recipe3);

        cafe.printMenu();

        try {
            cafe.removeRecipe("Large Soy Latte");
        } catch (RecipeNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            cafe.placeOrder("Espresso", "Jose", 3);
        } catch (RecipeNotFoundException | CafeOutOfCapacityException e) {
            throw new RuntimeException(e);
        }
        cafe.printPendingOrders();

    }
}
