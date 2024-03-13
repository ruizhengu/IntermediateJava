package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

/** The Recipe class represents a collection of ingredients. */
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

    public boolean equals(Object obj) {
        // Task 5: Implement Recipe.equals

        if (!(obj instanceof Recipe))
            return false;

        if (obj == this)
            return true;

        Recipe other = (Recipe) obj;

        if (other.price != this.price || other.size != this.size)
            return false;

        if (other.ingredients.length != this.ingredients.length)
            return false;

        // If one of the recipes is not ready then they can't be equal
        if (!isReady() || !other.isReady())
            return false;

        // Check for ingredients added in a different order by counting the number of matches
        int matches = 0;
        for (Ingredient ingredient : ingredients) {
            for (Ingredient otherIngredient : other.ingredients) {
                // Calls the overridden equals method in the ingredient class
                if (ingredient.equals(otherIngredient))
                    matches++;
            }
        }

        if (matches != ingredients.length)
            return false;
        
        // Didn't find any differences
        return true;
    }
}
