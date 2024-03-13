package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

/**
 * This class is the entry point to the program.
 * Its main method creates a cafe, makes some recipes and adds them to the cafes menu
 * It then displays the menu
 */
public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe("Bob's cafe");

        /* Create the three recipe objects and a list of ingredients to be added to each of them */

        // Espresso
        Recipe espressoRecipe = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Ingredient[] espressoIngredients = {new Coffee(), new Water()};

        // Double Espresso
        Recipe doubleEspressoRecipe = new Recipe("Double Espresso",
                2.2, Recipe.Size.REGULAR, 2);
        Ingredient[]  doubleEspressoIngredients = {new Coffee(15), new Water(50)};

        // Large Soy Latte
        Recipe largeSoyLatteRecipe = new Recipe("Large Soy Latte",
                2.5, Recipe.Size.LARGE, 3);
        Ingredient[] largeSoyLatteIngredients = {new Milk(10, Milk.Type.SOY),
                new Water(), new Coffee(12)};


        /* Create a list of the recipes and a list of the ingredients for each of them, a 2d array called
         * ingredients_lists. These make it easy to add the ingredients to the recipes without repeated code.
         */
        Recipe[] recipes = {espressoRecipe, doubleEspressoRecipe, largeSoyLatteRecipe};
        Ingredient[][] ingredient_lists = {espressoIngredients, doubleEspressoIngredients, largeSoyLatteIngredients};

        /* Go through every recipe adding every ingredient in its respective ingredient list
         * Catch the exception thrown if too many ingredients are added. Add the new recipe to the cafe's menu
         */

        for (int i = 0; i < recipes.length; i++) {
            for (Ingredient ingredient : ingredient_lists[i]) {
                try {
                    recipes[i].addIngredient(ingredient);
                    System.out.println("ingredient " + ingredient.getName() +
                            " added to the recipe " + recipes[i].getName());
                } catch (TooManyIngredientsException e) {
                    System.out.println(e + " Too many ingredients have been added to the recipe " +
                            recipes[i].getName());
                }
            }
            cafe.addRecipe(recipes[i]);
            System.out.println("recipe " + recipes[i].getName() + " has been added to to the menu");
            System.out.println();
        }

        cafe.printMenu();

    }
}