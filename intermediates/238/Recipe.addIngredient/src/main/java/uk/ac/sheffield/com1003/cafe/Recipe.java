/**
 * Recipe.java
 * This class represents a recipe that can be used to make a drink or food item in a cafe.
 * It contains the name, price, size, and ingredients required for the recipe.
 * @version 1.0 10/03/2023
 * @author Unknown
 */

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

    /**
     * Constructor for Recipe class that creates a recipe with a default size and no of ingredients.
     * @param name The name of the recipe.
     * @param price The price of the recipe.
     */
    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
        
    }

    /**
     * Constructor for Recipe class that creates a recipe with a specified size and number of ingredients.
     * @param name The name of the recipe.
     * @param price The price of the recipe.
     * @param size The size of the recipe.
     * @param numberOfIngredients The number of ingredients required for the recipe.
     */
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
        int count = 0;
        for (Ingredient i : ingredients) {
            if (i != null) {
                count++;
            }
        }
        if (count >= ingredients.length) {
            throw new TooManyIngredientsException();
        }
        for (int i = 0; i < ingredients.length; i++) {
            if (ingredients[i] == null) {
                ingredients[i] = ingredient;
                return;
            }
        }
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
     * Compares this Recipe object to the specified object for equality.
     * The result is true if the argument is not null and is a Recipe object that has the properties this Recipe object.
     * @param obj The object to compare this Recipe against
     * @return True if the given object represents an equal Recipe to this Recipe, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Recipe))
            return false;
        Recipe recipe = (Recipe) o;
        if ((recipe.price != price) || (size != recipe.size))
            return false;

        if (! isReady() || !recipe.isReady())
            return false;

        if (ingredients.length != recipe.ingredients.length)
            return false;

        for (int i=0; i<ingredients.length; i++) {
            boolean found = false;
            for (int j=0; j<ingredients.length; j++) {
                if (ingredients[i].equals(recipe.ingredients[j])) {
                    found = true;
                    break;
                }
            }
            if (! found)
                return false;
        }
        return true;
    }
}
