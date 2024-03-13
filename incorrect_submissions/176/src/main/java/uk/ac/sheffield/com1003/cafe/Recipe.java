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
     * Checks if two recipes are the same.
     * @param recipeName Recipe that is going to be compared with
     * @return True if both recipes have the same size, all ingredients of the recipe have been added,
     *          contain the same ingredients, cost the same, and false otherwise
     */
    public boolean equals(Recipe recipeName) {
        // Having the variable sameNumberOfIngredients, ensures that
        // the recipes have EXACTLY the same ingredients, and not just SOME of the same ingredients
        int sameNumberOfIngredients = 0;
        for (Ingredient ingredient: ingredients){
            for (Ingredient ingredientToBeCompared: recipeName.ingredients){
                if (ingredient.equals(ingredientToBeCompared))
                    sameNumberOfIngredients++;
            }
        }

        if (this.size == recipeName.size &&
            this.isReady() && recipeName.isReady() &&
            this.ingredients.length == sameNumberOfIngredients &&
            this.getPrice() == recipeName.getPrice())

            return true;

        else
            return false;
    }
}
