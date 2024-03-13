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
     * Checks whether two recipes are identical in every attribute other than name.
     * @param recipe1 first recipe being compared
     * @param recipe2 second recipe being compared
     * @return True if ingredients match and are all set, both the same size and cost  the same, false otherwise
     */
    public boolean equals(Recipe recipe1, Recipe recipe2) {


        /* Check recipes are same size and price, and that arrays have same length, if not return false */
        if (recipe1.size == recipe2.size
                && recipe1.price == recipe2.price
                && recipe1.ingredients.length == recipe2.ingredients.length) {

            /* Check if any ingredients are null in either recipe, if they are then return false */
            for (int i = 0; i < recipe1.ingredients.length; i++) {
                if (recipe1.ingredients[i] == null || recipe2.ingredients[i] == null) {
                    return false;
                }
            }

            /* Compare each term in first array to all terms in second:
                - if one of ingredient names match, check to see if units and amounts match
                - if they don't return false
                - if the number of successfully compared ingredients matches array length, return true
                - otherwise, return false
             */
            int comparedItems = 0;
            for (int x = 0; x < recipe1.ingredients.length; x++) {
                for (int y = 0; y < recipe2.ingredients.length; y++) {
                    if (recipe1.ingredients[x].equals(recipe2.ingredients[y])) {
                        comparedItems++;
                    }
                }
            }
            if (comparedItems == recipe1.ingredients.length) {
                return true;
            }
        }
        return false;
    }

}

