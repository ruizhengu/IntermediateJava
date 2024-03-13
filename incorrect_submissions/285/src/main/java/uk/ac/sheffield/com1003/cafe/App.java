package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        // Create recipes and add them to menu

        // Espresso
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        // Create ingredients
        Coffee coffee = new Coffee();
        Water water = new Water();
        try {
            // Add ingredients to recipe
            espresso.addIngredient(coffee);
            espresso.addIngredient(water);
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
        cafe.addRecipe(espresso);

        // Double espresso
        Recipe double_espresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        // Create ingredients
        coffee = new Coffee(15);
        water = new Water(50);
        try {
            // Add ingredients to recipe
            double_espresso.addIngredient(coffee);
            double_espresso.addIngredient(water);
        } catch (Exception exception) {
            System.out.println(exception);
        }
        cafe.addRecipe(double_espresso);

        // Large Soy Latte
        Recipe latte = new Recipe("Large Soy Latte", 1.5, Size.LARGE, 3);
        Milk milk = new Milk(50, Type.SOY);
        // Create ingredients
        coffee = new Coffee(30);
        water = new Water(400);
        try {
            // Add ingredients to recipe
            latte.addIngredient(coffee);
            latte.addIngredient(water);
            latte.addIngredient(milk);
        } catch (Exception exception) {
            System.out.println(exception);
        }
        cafe.addRecipe(latte);
    }
}
