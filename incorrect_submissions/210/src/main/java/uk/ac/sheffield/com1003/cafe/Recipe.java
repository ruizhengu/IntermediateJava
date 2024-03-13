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
     * Checks if a recipe is the same as another recipe.
     * @param recipe the recipe to be compared.
     * @return True if they are the same size, all ingredients are set, contain the same ingredients
     * (including name, units and amounts, and specific instance variables), and cost the same, even
     * if their names are different.
     */
    public boolean equals(Recipe recipe) {

        // Task 5

        if (this.size != recipe.size)
            return false;

        if (this.price != recipe.price)
            return false;

        if (this.ingredients.length != recipe.ingredients.length)
            return false;

        if (! this.isReady())
            return false;

        if (! recipe.isReady())
            return false;

        // Comparing the ingredients' toString methods to check if they are the same even
        // if they are in a different order (Task 5)

        boolean matched;

        for (Ingredient ingredientA : this.ingredients) {

            matched = false;

            for (Ingredient ingredientB : recipe.ingredients) {

                if (ingredientA.toString().equals(ingredientB.toString()))
                    matched = true;
            }
            if (!matched)
                return false;

        }

        return true;

    }
}


