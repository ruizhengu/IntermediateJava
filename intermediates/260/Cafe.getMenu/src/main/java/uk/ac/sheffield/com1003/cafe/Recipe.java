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
     * Constructor that takes recipe name and recipe price as parameter, and 
     * initialises recipe size to Regular and number of ingredients to 3.
     */
    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
        
    }

    /**
     * Constructor that takes recipe name, recipe price, recipe size 
     * and number of ingredients as parameters
     */
    public Recipe(String name, double price, Size size, int numberOfIngredients) {
        this.name = name;
        this.price = price;
        this.size = size;
        ingredients = new Ingredient[numberOfIngredients];
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
     * Getter for recipe size
     * @return Recipe size
     */
    public Size getSize() {
        return size;
    }

    /**
     * Getter for recipe ingredients
     * @return Recipe Ingredients
     */
    public Ingredient[] getIngredients() {
        return ingredients;
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

    public boolean equals(Object o) {

        /* If statement below will try to Cast parameter into Recipe
        * Otherwise, will return false
        */
        if (o == null || ! (o instanceof Recipe))
            return false;
        Recipe recipe = (Recipe)o;
        
        /*Sequence below stores equivalence of Class attributes
        * Then returns false if any are not equal
        */
        boolean sameSize = (this.size == recipe.size);
        boolean sameNumIngredients = (this.ingredients.length == recipe.ingredients.length);
        boolean ingredientsSet = (this.isReady() && recipe.isReady());
        boolean samePrice = (this.price == recipe.price);

        if (!sameSize || !sameNumIngredients || !ingredientsSet || !samePrice) {
            return false;
        }

        /*Loop below will compare every ingredient in first recipe
        * to every ingredient in second recipe, if any don't match,
        * it will return false
        */
        for (int i = 0; i < this.ingredients.length; i++) {
            boolean ingredientFound = false;
            for (int j = 0; j < recipe.ingredients.length; j++) {
                if (this.ingredients[i].equals(recipe.ingredients[j])) {
                    ingredientFound = true;
                }
            }
            if (!ingredientFound) {
                return false;
            }
        }
    
        return true;
    }
}
