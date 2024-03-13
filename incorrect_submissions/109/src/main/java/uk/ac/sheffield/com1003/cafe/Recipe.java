package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    public enum Size {SMALL, REGULAR, LARGE}

    ;
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
            if (ingredient == null)
                return false;
        }
        return true;
    }

    /**
     * Checks whether two recipes are the same.
     * If both recipes have the same: ingredients; number of ingredients; size; readiness (both are ready) and price,
     * they are the same recipe.
     *
     * @param recipe
     * @return True if all the above criteria is met and false otherwise
     */

    public boolean equals(Recipe recipe) {
        int numOfSameIngredients = 0;
        boolean hasSameIngredients = false;

        if (this.ingredients.length != recipe.ingredients.length) {
            return false;
        }

        for (Ingredient thisRecipeIngredient : this.ingredients) {
            for (Ingredient thatRecipeIngredient : recipe.ingredients) {
                if (thisRecipeIngredient.equals(thatRecipeIngredient)) {
                    numOfSameIngredients++;
                }
            }
        }

        if (numOfSameIngredients == this.ingredients.length) {
            hasSameIngredients = true;
        }

        if (this.isReady() && recipe.isReady() && hasSameIngredients && this.getPrice() == recipe.getPrice()
                && this.size == recipe.size) {
            return true;
        } else {
            return false;
        }

    }
}