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

    public Size getSize() {return size;}

    public Ingredient[] getIngredients() {return ingredients;}

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
     * Checks if two recipes are the same bar name
     *
     * @param other The recipe to be compared
     * @return The recipes match of false otherwise
     */
    public boolean equals(Recipe other) {

        // Compare recipe sizes
        if (size != other.getSize()) {
            System.out.println("These recipes are not the same!");
            return false;
        }

        // Compare if recipes are ready
        if (!(isReady() && other.isReady())) {
            System.out.println("These recipes are not the same!");
            return false;
        }

        // Compare if recipes have the same number of ingredients
        if (ingredients.length != other.getIngredients().length) {
            System.out.println("These recipes are not the same!");
            return false;
        }

        // Check if all the ingredients are the same
        // The order of ingredients doesn't matter
        for (Ingredient ingredientA : ingredients) {
            boolean foundCurrentIngredient = false;

            for (Ingredient ingredientB : other.getIngredients()) {
                if (ingredientA.equals(ingredientB)) {
                    foundCurrentIngredient = true;
                    break;
                }
            }

            if (!foundCurrentIngredient) {
                System.out.println("These recipes are not the same!");
                return false;
            }

        }

        // Compare recipe prices
        if (price != other.getPrice()) {
            System.out.println("These recipes are not the same!");
            return false;
        }

        System.out.println("These recipes are the same!");
        return true;
    }
}
