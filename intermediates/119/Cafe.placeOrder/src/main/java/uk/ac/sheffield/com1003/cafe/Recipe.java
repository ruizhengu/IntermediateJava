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

    // Define a new equals method to avoid affecting the original equals method
    public boolean equals(Recipe otherRecipe) {
        /**
         * There may be some additional if statements
         * which are based on lower time complexity considerations
         */
        if (super.equals(otherRecipe))
            return true;

        if (this.ingredients.length != otherRecipe.ingredients.length)
            return false;

        if (this.price != otherRecipe.price)
            return false;
        
        if (!(this.isReady() && otherRecipe.isReady()))
            return false;
        
        if (this.size != otherRecipe.size)
            return false;
        
        /**
         * Coming to the worst case
         * Having to compare the difference in ingredients between two recipes
         */
        for (Ingredient secIngredients : otherRecipe.ingredients) {
            boolean flag = false;
            // Pick an ingredient and try to find it in the other Recipe object
            for (Ingredient firIngredients : this.ingredients)
                if (secIngredients.toString().equals(firIngredients.toString()))
                    flag = true;
            // If any ingredients cannot be found, means recipes are different
            if (!flag) return false;
        }

        return true;
    }
}
