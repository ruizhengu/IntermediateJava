package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

/**
 * A recipe is represented by the name of the recipe, e.g., “Large latte”, 
 * its price, size and the ingredients contained in the recipe.
 */

public class Recipe {
    public enum Size { SMALL, REGULAR, LARGE };
    private String name;
    private double price;
    private Size size;
    private Ingredient[] ingredients;

    /**
     * Constructor that takes recipe name and price as parameters, and 
     * initialises recipe size to regular and number of ingredients to 3.
     */
    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
        
    }

    /**
     * Constructor that takes recipe name, price, size, and
     * number of ingredients as parameters.
     */
    public Recipe(String name, double price, Size size, 
            int numberOfIngredients) {
        this.name = name;
        this.price = price;
        this.size = size;
        ingredients = new Ingredient[numberOfIngredients];
    }

    /**
     * Add ingredient to recipe if it does not already exist.
     * If ingredient with the same name already exists, replace it with the new 
     * one.
     * @param ingredient Ingredient to be added to recipe.
     * @throws TooManyIngredientsException if the number of ingredients in 
     * the recipe would be exceeded
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
     * Getter for recipe name
     * @return recipe name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for recipe price
     * @return recipe price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Checks whether recipe is ready to be used.
     * @return True if all ingredients of the recipe have been added and 
     * false otherwise
     */
    public boolean isReady() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient == null)
                return false;
        }
        return true;
    }

    /**
     * Checks whether another recipe is the same as this recipe.
     * @param another Recipe to be checked
     * @return True if size, ingredients, ready ingredients, and price
     * are the same; false otherwise
     */
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Recipe))
            return false;
        if (size.equals(((Recipe)another).size))
            if (ingredients.equals(((Recipe)another).ingredients))
                if (isReady() == ((Recipe)another).isReady())
                    if (getPrice() == ((Recipe)another).getPrice())
                        return true;
        return false;
    }
}
