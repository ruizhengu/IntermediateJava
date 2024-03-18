/**
 * Recipe.java
 *
 * @version 1.0 15/03/2023
 * @author Naseem Hoque
 */

package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    private String name;
    private double price;
    private Size size;
    private Ingredient[] ingredients;
    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
    }

    public Recipe(String name, double price, Size size, int numberOfIngredients) {
        this.name = name;
        this.price = price;
        this.size = size;
        ingredients = new Ingredient[numberOfIngredients];
    }

    /**
     * Add ingredient to recipe if it does not already exist.
     * If ingredient with the same name already exists, replace it with the new one.
     *
     * @param ingredient Ingredient to be added to recipe.
     * @throws TooManyIngredientsException if the number of ingredients in the recipe would be exceeded
     */
    public void addIngredient(Ingredient ingredient) throws TooManyIngredientsException {
        int i = 0;
        while (i < ingredients.length) {
            if (ingredients[i] == null || ingredients[i].equals(ingredient)) {
                ingredients[i] = ingredient;
                return;
            } else
                i++;
        }
        if (i < ingredients.length)
            ingredients[i] = ingredient;
        else
            throw new TooManyIngredientsException();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Checks whether recipe is ready to be used.
     *
     * @return True if all ingredients of the recipe have been added and false otherwise
     */
    public boolean isReady() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient == null) return false;
        }
        return true;
    }

    /**
     * Compare a recipe with another recipe to see if they are the same.
     * Two recipes are equal if they are the same size, all ingredients are set, contain the same ingredients
     * and cost the same, even if their names are different
     *
     * @param another Recipe to be compared to.
     * @return True if the recipes are the same; return false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (this == another) {
            return true;
        }
        if (!(another instanceof Recipe)) {
            return false;
        }
        Recipe anotherRecipe = (Recipe) another;
        if (this.size != anotherRecipe.size) {
            return false;
        }
        boolean found = false;
        int matches = 0;
        for (Ingredient ingredient : this.ingredients) {
            found = false;
            for (Ingredient anotherIngredient : anotherRecipe.ingredients) {
                found = ingredient.equals(anotherIngredient);
                if (found) {
                    matches++;
                    break;
                }
            }
        }
        return matches == ingredients.length;
    }

    public enum Size {SMALL, REGULAR, LARGE}
}
