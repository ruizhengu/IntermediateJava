package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

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

    @Override
    public String toString() {
        return name + " - " + price;
    }

    /**
     * Checks whether two recipes are equal. They are equal if they:
     * - Are the same 'size' (small, medium or large)
     * - Have the same price
     * - Have the exact same ingredients (e.g. if both recipes have different ammounts of ingredients, or have a
     *   different 'type' of milk, they are not equal)
     *
     * @param recipe Recipe to be compared with this recipe
     * @return True if they are equal
     */
    public Boolean equals(Recipe recipe) {
        // Checking if the ingredients are the same
        if (ingredients.length != recipe.ingredients.length) {
            return false;
        }
        // Create copies of the ingredients arrays as to not edit the originals
        Ingredient[] ingredients1 = Arrays.copyOf(ingredients, ingredients.length);
        Ingredient[] ingredients2 = Arrays.copyOf(recipe.ingredients, recipe.ingredients.length);
        // Sorts the arrays based on the ingredient names so that similar ingredients will be compared
        Arrays.sort(ingredients1, Comparator.comparing(Ingredient::getName));
        Arrays.sort(ingredients2, Comparator.comparing(Ingredient::getName));
        // Compares the ingredients
        for (int i = 0; i < ingredients1.length; i++) {
            if (!Objects.equals(ingredients1[i].toString(), ingredients2[i].toString())) {
                return false;
            }
        }
        // Compares if the recipes have the same size and price
        if (size != recipe.size || price != recipe.getPrice()) {
            return false;
        }
        return true ;
    }
}
