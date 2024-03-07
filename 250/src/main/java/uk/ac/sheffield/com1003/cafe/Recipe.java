package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class Recipe {
    public enum Size {
        SMALL,
        REGULAR,
        LARGE
    };
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
        for (Ingredient ingredient: ingredients) {
            if (ingredient == null)
                return false;
        }
        return true;
    }

    /**
     * Compares two Recipe objects for equality.
     * @param recipe the Recipe object to be compared.
     * @return true if the two Recipe objects are equal, false otherwise.
     */
    public boolean equals(Recipe recipe) {

        // Checks if both recipes are ready, and hence, ready for comparison
        if (recipe.isReady() && this.isReady()) {

            // Checks if both recipes have the same number of ingredients
            if (recipe.ingredients.length == this.ingredients.length) {

                // Checks if both recipes cost the same
                if (recipe.price == this.price) {

                    // Checks if both recipes have the same size
                    if (recipe.size == this.size) {

                        // Checks if the ingredients of both recipes are the same
                        for (int i = 0; i < recipe.ingredients.length; i++) {
                            if (!(recipe.ingredients[i].equals(this.ingredients[i]))) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

}
