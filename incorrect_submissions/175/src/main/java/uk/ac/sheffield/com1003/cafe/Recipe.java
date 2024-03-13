package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    public enum Size { SMALL, REGULAR, LARGE };
    private String name;
    private double price;
    private Size size;
    private Ingredient[] ingredients;
    private int numberOfIngredients;

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
     * Checks if two recipes are the same.
     * @Return true if two recipes have the same size, ingredients and price.
     */

    @Override
    public boolean equals(Object recipe1) {
        // handles case where a recipe is compared with itself
        if (recipe1 == this) {
            return true;
        }
        // handles case where a recipe does not exist
        if (recipe1 == null) {
            return false;
        }
        // compare ingredients and their parameters
        boolean sameIngredients = false;
        Recipe recipe2 = (Recipe) recipe1;
        for (int i=0; i<this.ingredients.length; i++) {
            for (int j=0; j<recipe2.ingredients.length; j++) {
                if ((this.ingredients[i].equals(recipe2.ingredients[j])) && (this.ingredients[i].getAmount() == recipe2.ingredients[i].getAmount()) && (this.ingredients[i].getUnit().equals(recipe2.ingredients[i].getUnit()))) {
                    sameIngredients = true;
                    break;
                }
            }
        }
        if ((this.size == recipe2.size) && (sameIngredients) && (this.price == recipe2.price)) {
            return true;
        }
        else {
            return false;
        }
    }
}
