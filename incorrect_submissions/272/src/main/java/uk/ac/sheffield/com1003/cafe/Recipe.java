package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import javax.sql.rowset.CachedRowSet;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    public enum Size { SMALL, REGULAR, LARGE };
    private String name;
    private double price;
    private Size size;
    public Ingredient[] ingredients;

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
     * Compares self with other recipe
     * @return True if self and otherRecipe are the same.
     */
    public boolean equals(Recipe otherRecipe) {
        int ingredientsLen = ingredients.length;
        boolean[] otherRecipeIndexIsSame = new boolean[otherRecipe.ingredients.length];
        int otherRecipeIndex; // Initialize, will be the last iteration of inner for loop for "is same" check
        //Compare size and recipe price
        if (ingredientsLen != otherRecipe.ingredients.length || price != otherRecipe.price || 
        size != otherRecipe.size) { return false; }
        // Check for same ingredients
        for (int i = 0; i < ingredientsLen; i++) {
            Ingredient ingredient = ingredients[i];
            // Check for not set ingredients
            if (ingredient == null) { return false; }
            // Compare ingredient to other recipe's ingredients (same: name, unit, amount and specific instance variables)
            for (otherRecipeIndex = 0; otherRecipeIndex < ingredientsLen; otherRecipeIndex++) {
                // Ingredient is the same and it has not been already compared
                if (ingredient.equals(otherRecipe.ingredients[otherRecipeIndex]) && !otherRecipeIndexIsSame[otherRecipeIndex]) {
                    otherRecipeIndexIsSame[otherRecipeIndex] = true; // Marked as checked
                    otherRecipeIndex++; // Simulate end of loop
                    break; // Break loop as both ingredients are the same
                }
            }
            // Check if current ingredient was the same as an ingredient in other recipe
            if (otherRecipeIndexIsSame[otherRecipeIndex - 1] == false) { return false; }
        }
        return true; // Passed all checks (is the same)
    }
}
