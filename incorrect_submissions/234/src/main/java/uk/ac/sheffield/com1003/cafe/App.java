package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args) {
        Cafe newCafe = new Cafe();

        // making 3 new Recipes
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe despresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe soy_latte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);

        // adding Ingredients to the Recipes, and catching errors when too many
        // ingredients are added
        try {
            // espresso with coffee and water
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

            // double espresso with more coffee and water
            despresso.addIngredient(new Coffee(15));
            despresso.addIngredient(new Water(50));

            // soy latte with coffee water and soy milk
            soy_latte.addIngredient(new Milk(100, Milk.Type.SOY));
            soy_latte.addIngredient(new Coffee());
            soy_latte.addIngredient(new Water(75));
            
        } catch (TooManyIngredientsException e) {
            error_msg("adding ingredients failed, too many ingredients");
        }

        // finally adding Recipes to the menu if nothing goes wrong
        newCafe.addRecipe(espresso);
        newCafe.addRecipe(despresso);
        newCafe.addRecipe(soy_latte);
    }

    public static void error_msg(String error_msg) {
        System.out.println("Error: " + error_msg);
    }
}