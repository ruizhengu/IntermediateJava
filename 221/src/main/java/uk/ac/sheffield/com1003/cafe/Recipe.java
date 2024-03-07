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

    public boolean equals(Object obj) {
        if (obj == null || ! (obj instanceof Recipe)) { return false; }
        Recipe otherRecipe = (Recipe) obj;
        if (!size.equals(otherRecipe.size)) { return false; }
        if (price != otherRecipe.price) { return false; }
        // check ingredients are all set
        if (ingredients[ingredients.length -1] == null ||
                otherRecipe.ingredients[otherRecipe.ingredients.length -1] == null) {
            return false;
        }
        if (ingredients.length != otherRecipe.ingredients.length) { return false; }
        // check that ingredients are the same
        for (Ingredient i: ingredients) {
            boolean found = false;
            for (Ingredient o: otherRecipe.ingredients) {
                if (i.equals(o)) {
                    found = true;
                    break;
                }
            }
            if (!found) { return false;}
        }
        return true;
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
}
