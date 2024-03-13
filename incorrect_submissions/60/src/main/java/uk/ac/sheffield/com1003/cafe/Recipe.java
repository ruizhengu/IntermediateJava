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
     * Constructor that takes recipe name and price as parameters,
     * initialises size to regular, number of ingredients to 3.
     */
    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
        
    }

    /**
     * Constructor that takes recipe name, price, size and number of ingredients as parameters.
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
     * Getter for recipe price
     * @return Recipe price
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Getter for recipe number of ingredients
     * @return Recipe number of ingredients
     */
    public int getNumOfIngredients() {
        return ingredients.length;
    }
    
    /**
     * Getter for recipe ingredients
     * @return Recipe ingredients array
     */
    public Ingredient[] getIngredients() {
        return ingredients;
    }
    
    /**
     * Getter for recipe size
     * @return Recipe size
     */
    public Size getSize() {
        return size;
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
     * Checks whether 2 recipes are the same
     * @return True if recipe's are identical, excluding the name
     */
    public boolean equals(Recipe recipe) {
        // if price, num of ingredients and size are the same
        if (price == recipe.getPrice() &&
                ingredients.length == recipe.getNumOfIngredients() &&
                size == recipe.getSize()) {
            int foundIngredientMatch = 0;
            // iterating all possible combinations to find ingredient matches
            for (int i = 0; i < ingredients.length; i++) {
                for (int j = 0; j < ingredients.length; j++) {
                    if (ingredients[i].equals(recipe.getIngredients()[j])) {
                        foundIngredientMatch++;
                    }
                }
            }
            // If the number of matches equals the number of ingredients
            if (foundIngredientMatch == ingredients.length) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
}
