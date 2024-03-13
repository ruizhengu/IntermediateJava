package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

/**
 * Café program entry point.
 */
public class App {

    public static void main(String[] args) {
        Cafe cafe = new Cafe();

        Ingredient[] espressoIngredients = {
                new Coffee(),
                new Water()
        };
        Recipe espresso = createRecipe("Espresso", 1.5, Recipe.Size.SMALL, espressoIngredients);

        Ingredient[] doubleEspressoIngredients = {
                new Coffee(15),
                new Water(50)
        };
        Recipe doubleEspresso = createRecipe("Double Espresso", 2.2, Recipe.Size.REGULAR,
                doubleEspressoIngredients);

        Ingredient[] largeSoyLatteIngredients = {
                new Milk(200, Milk.Type.SOY),
                new Coffee(40)
        };
        Recipe largeSoyLatte = createRecipe("Large Soy Latte", 2.5, Recipe.Size.LARGE,
                largeSoyLatteIngredients);
    }


    private static Recipe createRecipe(String name, double price, Recipe.Size size, Ingredient[] ingredients) {
        Recipe newRecipe = new Recipe(name, price, size, ingredients.length);
        try {
            // Add each ingredient from list to the new recipe
            for (Ingredient ingredient : ingredients) {
                newRecipe.addIngredient(ingredient);
            }
        }
        catch (TooManyIngredientsException ex) {
            System.out.println("Too Many Ingredients: Failed to add >=1 ingredient to " + name + ".");
        }
        return newRecipe;
    }

}
