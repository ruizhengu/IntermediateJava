package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

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
     * Compares 2 different recipe objects. Only works if the other recipe is ready (all ingredients set).
     * @param otherRecipe
     * @return True if they have the same ingredients, size, price; false if not
     */
    public boolean equals(Recipe otherRecipe) {
        // Can't be equal if all ingredients are not set yet
        if (!otherRecipe.isReady())
            return false;

        // Compare prices
        if (otherRecipe.getPrice() != this.getPrice())
            return false;

        // Compare sizes
        if (otherRecipe.size != this.size)
            return false;

        // For each ingredient in this recipe...
        for (Ingredient thisIng : ingredients) {
            // ...check if the other recipe contains the same ingredient
            boolean contains = false;
            for (Ingredient otherIng : otherRecipe.ingredients) {
                if (otherIng.equals(thisIng)) {
                    contains = true;
                }
            }

            if (!contains)
                return false;
        }

        return true;
    }
}
