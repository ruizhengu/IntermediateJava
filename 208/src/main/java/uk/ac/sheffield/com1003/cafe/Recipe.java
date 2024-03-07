package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
/**
 * This class represents a Recipe.
 * It has attributes for its size, name, price and ingredients.
 */
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
            } 
            else
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
     * Checks whether recipe is equal to another
     * @return True if equal and false otherwise
     */
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Recipe)) {
            return false;
        }

        Recipe secondRecipe = (Recipe)another; // sets the object as a Recipe to be able to access Recipe attributes/methods
        
        if (size != secondRecipe.size) {
            return false;
        }
        // checks if all ingredients have been set for both
        if (!(this.isReady() && secondRecipe.isReady())){
            return false;
        }
        for (Ingredient ingredient: ingredients) {
            boolean sameIngredient = false;
            for (Ingredient secondIngredient: secondRecipe.ingredients) {
                // these for loops work together to check if each of the ingredients in recipe are in secondRecipe
                if (ingredient.equals(secondIngredient)) {
                    // if ingredient is found in secondRecipe break out of loop and check for next ingredient
                    sameIngredient = true;
                    break;
                }
            }

            if (!sameIngredient) {
                // if one of the ingredients doesn't equal any of the ingredients in second recipe, return false (not found)
                return false;
            }
        }

        if (price != secondRecipe.price) {
            return false;
        }
        
        return true;
    }

}
