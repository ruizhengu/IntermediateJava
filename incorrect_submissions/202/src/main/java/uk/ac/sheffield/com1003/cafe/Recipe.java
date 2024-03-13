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

    @Override
    public boolean equals(Object o) {
        // Check if the object is the same instance as this object
        if (o == this) {
            return true;
        }
        // Check if the object is an instance of Recipe
        if (!(o instanceof Recipe)) {
            return false;
        }
        // Cast the object to a Recipe instance
        Recipe r2 = (Recipe) o;
        // Check if the recipes have the same size and price
        if (this.size != r2.size || this.price != r2.price) {
            return false;
        }
        // Check if the recipes have the same number of ingredients
        if (this.ingredients.length != r2.ingredients.length) {
            return false;
        }
        // Check each ingredient in the recipe
        for (int i = 0; i < this.ingredients.length; i++) {
            if (!this.ingredients[i].equals(r2.ingredients[i])) {
                return false;
            }
        }
        // If all checks pass, the recipes are equal
        return true;
    }
}
