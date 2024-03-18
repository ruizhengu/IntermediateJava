package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String args[]) {
        Cafe cafe = new Cafe("Elliot's Cafe");
        // Create drink recipes
        Recipe espresso = new Recipe("Espresso", 1.50, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.20, Recipe.Size.REGULAR, 2);
        Recipe latte = new Recipe("Large Soy Latte", 2.50, Recipe.Size.LARGE, 2);
        // Create ingredient objects
        Ingredient normalCoffee = new Coffee();
        Ingredient normalWater = new Water();

        Ingredient doubleCoffee = new Coffee(15);
        Ingredient doubleWater = new Water(50);

        Ingredient largeMilk = new Milk(50, Milk.Type.SOY);
        Ingredient largeCoffee = new Coffee(40);
        // Add ingredients to recipes
        try {
            espresso.addIngredient(normalCoffee);
            espresso.addIngredient(normalWater);

            doubleEspresso.addIngredient(doubleCoffee);
            doubleEspresso.addIngredient(doubleWater);

            latte.addIngredient(largeMilk);
            latte.addIngredient(largeCoffee);
        } catch(TooManyIngredientsException e) {
            System.out.println("error");
            throw new RuntimeException(e);
        }
        // add recipes to cafe object
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(latte);
        cafe.printMenu();
        System.out.println(cafe.greeting());
    }
}
