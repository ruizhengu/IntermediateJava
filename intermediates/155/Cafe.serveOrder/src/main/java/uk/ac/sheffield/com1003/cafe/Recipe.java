package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

/** Represents a Recipe */

public class Recipe {
    public enum Size { SMALL, REGULAR, LARGE };
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
     * @return True if all ingredients of the recipe have been added and false otherwise
     */
    public boolean isReady() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient == null)
                return false;
        }
        return true;
    }

    /**
     * Checks whether a recipe is equal to another recipe.
     * @param recipe recipe to be compared with the current recipe.
     * @return True if recipes are equal.
     */
    public boolean equals(Recipe recipe) {
        boolean sameSize = this.size == recipe.size;

        // Check if the ingredients are the same

        // Need to first check if number of ingredients are same on both recipes.
        boolean sameIngredients = false; // initialise, value doesn't matter.
        if (this.ingredients.length != recipe.ingredients.length) {
            sameIngredients = false;
        } else {
            // No. of ingredients match; continue check.

            int noOfMatches = 0; // no. of matches must = length at the end.
            for (int i = 0; i < this.ingredients.length; i++) {
                for (int j = 0; j < recipe.ingredients.length; j++) {
                    if (this.ingredients[i].equals(recipe.ingredients[j])) {
                        // increment for each match.
                        noOfMatches++;
                    }
                }
            }

            if (noOfMatches == this.ingredients.length) {
                sameIngredients = true;
            } else {
                sameIngredients = false;
            }
        }

        // compile all the checks together.
        if (sameSize && (this.isReady()) && (recipe.isReady()) && sameIngredients &&
                (this.getPrice() == recipe.getPrice())) {
            return true;
        } else {
            return false;
        }
    }
}
