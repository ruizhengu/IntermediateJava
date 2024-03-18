package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

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

    /**
     * [Task 1] Helper method to add multiple ingredients to a recipe,
     * displays a useful warning message if TooManyIngredientsException occurs.
     * @param ingredientsToAdd An array of ingredient instances to be added.
     */
    public void addIngredients(Ingredient[] ingredientsToAdd) {
        for (Ingredient ingredient : ingredientsToAdd) {
            try {
                addIngredient(ingredient);
            } catch (TooManyIngredientsException e) {
                System.out.println("WARNING - Attempted to add too many ingredients to recipe: \""
                        + name + "\", ingredient: \"" + ingredient.getName() + "\" was not added"
                );
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
     * Checks if two recipes are equal.
     * If they are the same size,
     * all ingredients are set, contain the same ingredients
     * (including name, units and amounts, and specific instance variables, e.g., Milk.type),
     * and cost the same, even if their names are different.
     * @param another Other recipe to compare
     * @return True if the recipes are equal
     */
    public boolean equals(Recipe another) {
        if (ingredients.length == another.ingredients.length
                && price == another.price
                && size == another.size
                && another.isReady()
                && isReady()
        ) {
            for (Ingredient ingredient: ingredients) {
                int i = ingredients.length-1;
                while (ingredient.getName() != another.ingredients[i].getName() && i >= 0) {
                    i--;
                }
                if (i != -1) {
                    // Ingredient of same name was found at index i
                    Ingredient anotherIngredient = another.ingredients[i];
                    if (!ingredient.equals(anotherIngredient)) {
                        // The ingredients' instance variables are not equal
                        return false;
                    }
                } else {
                    // Ingredient of same name not found
                    return false;
                }
            }
            return true;
        }
        return false;
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
