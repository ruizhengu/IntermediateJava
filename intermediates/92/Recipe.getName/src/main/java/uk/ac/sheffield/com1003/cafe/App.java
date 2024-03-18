package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException {
        Cafe cafe = new Cafe();
        //Recipe 1
        Recipe recipe1 = new Recipe("Espresso",1.5, Recipe.Size.SMALL,2);
        Ingredient water_for_r1 = new Water();
        Ingredient coffee_for_r1 = new Coffee();
        recipe1.addIngredient(water_for_r1);
        recipe1.addIngredient(coffee_for_r1);
        cafe.addRecipe(recipe1);
        //Recipe 2
        Recipe recipe2 = new Recipe("Double Espresso",2.2, Recipe.Size.REGULAR,2);
        Ingredient water_for_r2 = new Water(50);
        Ingredient coffee_for_r2 = new Coffee(15);
        recipe2.addIngredient(water_for_r2);
        recipe2.addIngredient(coffee_for_r2);
        cafe.addRecipe(recipe2);
        //Recipe 3
        Recipe recipe3 = new Recipe("Large Soy Latte",2.5, Recipe.Size.LARGE,1);
        Ingredient milk_for_r3 = new Milk(20, Milk.Type.SOY);
        recipe3.addIngredient(milk_for_r3);
        cafe.addRecipe(recipe3);
        // print menu
        cafe.printMenu();
    }
}
