package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

/**
 * This class contains information about a specific recipe and methods to add ingredients,
 * check if it's the same as another recipe and check if it is full (aka. ready).
 */
public class Recipe {
    public enum Size { SMALL, REGULAR, LARGE };
    private String name;
    private double price;
    private Size size;
    private Ingredient[] ingredients;

    public Size getSize() {
        return size;
    }

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

    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Recipe))
            return false;

        if (!((Recipe)another).isReady() || !this.isReady())
            return false;

        if (((Recipe)another).getSize() != this.getSize())
            return false;

        boolean sameRecipe = true;
        boolean sameIngredient;

        int i = 0;
        while (sameRecipe && i < ingredients.length) {
            sameIngredient = false;

            int j = 0;
            while (!sameIngredient && j < ((Recipe)another).ingredients.length) {
                if (ingredients[i].equals(((Recipe)another).ingredients[j]))
                    sameIngredient = true;
                j++;
            }

            if (!sameIngredient)
                sameRecipe = false;

            i++;
        }


        return sameRecipe;
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
