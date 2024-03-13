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
     * Constructor that takes the name and price as parameters.
     */
    public Recipe(String name, double price)
    {
        this(name, price, Size.REGULAR, 3);
    }
    /**
     * Constructor that takes the name, price, size and numberOfIngredients as parameters and creates
     * a new ingredients array.
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
     * Returns the name variable.
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the price variable.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Checks whether recipe is ready to be used.
     * @return True if all ingredients of the recipe have been added and false otherwise
     */
    public boolean isReady()
    {
        for (Ingredient ingredient : ingredients) {
            if (ingredient == null)
                return false;
        }
        return true;
    }
    /**
     * Checks whether one recipe matches another.
     * @return True if both recipes contain the same ingredients and are the same size and price.
     */
    public boolean equals(Recipe matchRecipe)
    {
        int i = 0;

        if (isReady() && matchRecipe.isReady() && this.size == matchRecipe.size && this.price == matchRecipe.price &&
                ingredients.length == matchRecipe.ingredients.length)
        {
            for (Ingredient ingredient : this.ingredients)
            {
                for (Ingredient matchIngredient : matchRecipe.ingredients) //Iterates through all the ingredients
                {
                    if (ingredient.toString() == matchIngredient.toString())
                    {
                        i++;
                    }
                }
            }
            if (i == ingredients.length) //Checks all ingredients have been matched
            {
                return true;
            }
        }
        return false;
    }
}
