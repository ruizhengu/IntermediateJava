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
            } else {
                i++;
            }
        }
        if (i < ingredients.length)
            ingredients[i] = ingredient;
        else {
            throw new TooManyIngredientsException();
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Size getSize() {
        return size;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    /**
     * Equals method checks if the recipes are identical.
     * If the recipe given is the same recipe of which this method is called, it returns true.
     * It checks for the price, size, and ingredients (which don't have to be stored in the same order) 
     * Returns false if any of the above are not the same.
     */
    public boolean equals(Object otherRecipe) {
        if (otherRecipe == this) {
            return true;
        }

        // makes sure that the given recipe is of the Recipe class
        if (!(otherRecipe instanceof Recipe)) {
            return false;
        }

        Recipe recipe2 = (Recipe) otherRecipe;

        if (this.price != recipe2.price || this.size != recipe2.size) { 
            return false;
           }
        
        Ingredient[] ingredients1 = this.getIngredients();
        Ingredient[] ingredients2 = recipe2.getIngredients();

        if (ingredients1.length != ingredients2.length) {
            return false;
        }

        // Nested for loop goes through each ingredient in the list of ingredients
        for (int i = 0; i < ingredients1.length; i++) {
            boolean foundMatch = false;
            for (int j = 0; j < ingredients2.length; j++) {
                if (ingredients1[i] != null && ingredients2[j] != null && 
                ingredients1[i].toString().equals(ingredients2[j].toString())) {
                    foundMatch = true;
                    break;
                }
            }
            if (!foundMatch) {
                return false;
            }
        }
        return true;
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
