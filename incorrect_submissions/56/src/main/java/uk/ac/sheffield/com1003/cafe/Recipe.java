package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    public enum Size {
        SMALL, REGULAR, LARGE
    };

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
     * 
     * @param ingredient Ingredient to be added to recipe.
     * @throws TooManyIngredientsException if the number of ingredients in the
     *                                     recipe would be exceeded
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
     * 
     * @return True if all ingredients of the recipe have been added and false
     *         otherwise
     */
    public boolean isReady() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient == null)
                return false;
        }
        return true;
    }

    /**
     * First checks the array sizes to see if they are the same
     * then sorts both arrays before making comparisons
     * This method compares two Recipe objects which i have called in as parameters
     * and returns true if they are equal.
     * It returns false if any of the conditions are false
     * Two Recipe objects are equal the conditions of size, units and amount(for
     * each ingredient) is the same
     * in the same order.
     * 
     * @param Recipe1 The first Recipe object to compare
     * @param Recipe2 The second Recipe object to compare
     * @return true if the Recipe objects are equal, false otherwise
     */
    public boolean equals(Recipe Recipe1, Recipe Recipe2) {
        boolean same = true;
        if (Recipe1.size != Recipe2.size) {
            same = false;
            System.out.println("different");
        } else if (Recipe1.ingredients.length == Recipe2.ingredients.length) {
            Arrays.sort(Recipe1.ingredients);
            Arrays.sort(Recipe2.ingredients);
            for (int i = 0; i < Recipe1.ingredients.length; i++) {
                if (!Recipe1.ingredients[i].getName().equals(Recipe2.ingredients[i].getName())) {
                    same = false;
                }
                if (!Recipe1.ingredients[i].getUnit().equals(Recipe2.ingredients[i].getUnit())) {
                    same = false;
                }
                if (Recipe1.ingredients[i].getAmount() != Recipe2.ingredients[i].getAmount()) {
                    same = false;
                }

            }
        }
        return same;

    }
}
