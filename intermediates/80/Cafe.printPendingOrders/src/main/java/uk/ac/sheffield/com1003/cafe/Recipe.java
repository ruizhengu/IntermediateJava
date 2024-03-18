package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class Recipe {
    public enum Size {SMALL, REGULAR, LARGE}

    ;
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
     *
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
     * @param comparedRecipe
     * @return true when the number of same ingredients "count" equals both the instance and compared instances' length
     * and both instances have the same recipe fields.
     * <p>
     * loops through one ingredient of comparedRecipe and compares it with every instance ingredient
     * if two ingredients are equal, the number of same ingredients "count" increments
     */
    public boolean equals(Recipe comparedRecipe) {
        boolean sameFields = false;
        if (this.price == comparedRecipe.price && this.size == comparedRecipe.size) {
            sameFields = true;
        }


        int count = 0;
        for (Ingredient i : this.ingredients) {
            for (Ingredient j : comparedRecipe.ingredients) {
                //In some cases, users may not put enough ingredients for the recipe requirements, return false if so.
                if (i == null || j == null) {
                    return false;
                }
                if (i.equals(j)) {
                    count++;
                }
            }
            if (count == comparedRecipe.ingredients.length && count == this.ingredients.length && sameFields) {
                return true;
            }
        }


        return false;
    }
}
