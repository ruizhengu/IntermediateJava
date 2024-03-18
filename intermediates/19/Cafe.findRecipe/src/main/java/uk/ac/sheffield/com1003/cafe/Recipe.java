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
     * Compares two Recipe instances; they are considered equal if they:
     * - Have the same price
     * - Have the same size
     * - Have the same ingredients
     * - All ingredients are set
     * @param other The other Recipe instance being compared
     * @return True if the recipes are equal
     */
    @Override
    public boolean equals(Object other) {
        // Check the other object is actually a Recipe instance
        if ((other == null) || !(other instanceof Recipe)) return false;
        Recipe otherRecipe = (Recipe) other;
        // Checks against price, size and length
        if (this.price != otherRecipe.price) return false;
        if (this.size != otherRecipe.size) return false;
        if (this.ingredients.length != otherRecipe.ingredients.length) return false;

        boolean otherHasIngredient;
        // Iterating over all the ingredients in the first Recipe,
        for (int i = 0; i < this.ingredients.length; i++) {
            // If an ingredient has not been set,
            if (this.ingredients[i] == null) {
                // The two recipes are not equal
                return false;
            }

            otherHasIngredient = false;
            // Iterating over all the ingredients in the second Recipe,
            for (int j = 0; j < otherRecipe.ingredients.length; j++) {
                // If an ingredient has not been set in the second recipe,
                if (otherRecipe.ingredients[j] == null) {
                    // The two recipes are not equal.
                    return false;
                }

                // If they share an ingredient, set otherHasIngredient to true
                if (otherRecipe.ingredients[j].equals(this.ingredients[i])) {
                    otherHasIngredient = true;
                    break;
                }
            }
            // If they do not share any ingredient, they are not equal
            if (!otherHasIngredient) return false;
        }
        return true;
    }
}
