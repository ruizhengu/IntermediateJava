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

    public Ingredient[] getIngredients() {
        return ingredients;
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

    public boolean equals(Recipe recipe) {
        int sameIngredients = 0;
        Ingredient[] comparedIngredients = recipe.getIngredients();
        if (this.size == recipe.size && this.getPrice() == recipe.getPrice()
                && this.ingredients.length == comparedIngredients.length) {
            // Iterate over all ingredients, if null, return false, if there is a match, add 1 to same ingredients
            for (int i = 0; i < this.ingredients.length; i++) {
                if (this.ingredients[i] == null) {
                    return false;
                }
                for (int j = 0; j < this.ingredients.length; j++) {
                    if (comparedIngredients[j] == null) {
                        return false;
                    }
                    if (this.ingredients[i].equals(comparedIngredients[j])) {
                        sameIngredients++;
                    }
                }
            }
            if (sameIngredients == this.ingredients.length) {
                return true;
            }
        }
        return false;
    };
}
