package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    public enum Size {
        SMALL, REGULAR, LARGE
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
     * 
     * @param ingredient Ingredient to be added to recipe.
     * @throws TooManyIngredientsException if the number of ingredients in the
     *                                     recipe would be exceeded
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
     * @return True if all ingredients of the recipe have been added and false
     *         otherwise
     */
    public boolean isReady() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient == null)
                return false;
        }
        return true;
    }

    /**
     * 
     * Compares this Recipe object with another Recipe object to determine if they are equal.
     * 
     * Two recipes are considered equal if they have the same price, size, and ingredients.
     * 
     * @param other the Recipe object to compare this Recipe object with
     * 
     * @return true if the two Recipe objects are equal, false otherwise
     */
    public boolean equals(Recipe other) {
        if (!other.isReady() || !this.isReady()) {
            // Recipe is not ready
            return false;
        }

        if (price != other.price) {
            // Price is not equal
            return false;
        }

        if (size != other.size) {
            // Recipe size is not equal
            return false;
        }

        if (ingredients.length != other.ingredients.length) {
            // Unequal number of ingredients
            return false;
        }

        for (int i = 0; i < ingredients.length; i++) {
            boolean ingreEqual = false;
            for (int j = 0; j < other.ingredients.length; j++) {
                if (ingredients[i].equals(other.ingredients[j])) {
                    ingreEqual = true;
                }
            }
            if (ingreEqual == false) {
                // The ingredients are different
                return false;
            }
        }
        return true;
    }
}
