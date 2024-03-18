package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    public enum Size { SMALL, REGULAR, LARGE }
    private String name;
    private double price;
    private Size size;
    private Ingredient[] ingredients;

    /**
     * A constructor that takes parameters:
     * @param name Sets the name of the Recipe to the parameter value
     * @param price Sets the price of the Recipe to the parameter value
     * Initialises  size to REGULAR and numberOfIngredients to 3
     */
    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
        
    }

    /**
     * A constructor that takes parameters:
     * @param name Sets the name of the Recipe to the parameter value
     * @param price Sets the price of the Recipe to the parameter value
     * @param size Sets the size of the Recipe
     * @param numberOfIngredients Sets the number of ingredients
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
     * Getter for recipe name
     * @return Recipe name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for Recipe price
     * @return Recipe price
     */
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
     * Checks whether two recipes are the same
     * They are equal if they are the same size, ingredients are set, contain the same ingredients and cost the same
     * @param first First recipe to compare
     * @param second Second recipe to compare
     * @return True if compared equal; false if not
     */
    public boolean equals(Recipe first, Recipe second) {
        boolean recipesEqual = true;
        if (first.size != second.size) return false;
        if (first.ingredients == null || second.ingredients == null) return false;
        if (first.ingredients != second.ingredients) return false;
        return first.getPrice() == second.getPrice();
    }

}
