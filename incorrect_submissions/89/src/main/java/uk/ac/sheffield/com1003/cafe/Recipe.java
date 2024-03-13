package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;

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
     * Gets a given ingredient in a recipe
     * @param name name of the ingredient
     * @return the ingredient or null if not found
     */
    public Ingredient getIngredient(String name) {
        // Iterate through the recipe's ingredients with linear search for the name
        for (Ingredient i : ingredients) {
            if (i.getName().equals(name)) {
                return i;
            }
        }

        return null;
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

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Recipe))
            return false;

        // Not equal if different sizes
        if (!size.equals(((Recipe)another).size)) {
            return false;
        }

        // Must have the same number of ingredients
        if (ingredients.length != ((Recipe) another).ingredients.length) {
            return false;
        }

        // All ingredients must be used
        if (!isReady() || !((Recipe) another).isReady()) {
            return false;
        }

        // Must be the same price
        if (getPrice() != ((Recipe) another).getPrice()) {
            return false;
        }

        for (Ingredient i : ingredients) {
            // Find the same ingredient of the same name in the other recipe
            // If it is null the ingredient is missing and therefore not equal
            Ingredient other = ((Recipe) another).getIngredient(i.getName());
            if (other == null) {
                return false;
            }

            // Use each ingredient's overridden equality check
            if (!other.equals(i)) {
                return false;
            }
        }

        // If all cases are true, recipes are equivalent
        return true;
    }
}
