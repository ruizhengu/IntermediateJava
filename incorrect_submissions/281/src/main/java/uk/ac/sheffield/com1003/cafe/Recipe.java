package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    public enum Size {SMALL, REGULAR, LARGE}

    ;
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
     *
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
    public boolean equals(Object object) {
        // Checks if the same object is referenced
        if (this == object) return true;

        // Checks if the object is null
        if (object == null) return false;

        // Checks if the object is of the same class
        if (!(object instanceof Recipe)) return false;
        Recipe recipe = (Recipe) object;
        if (!this.size.equals(recipe.size)) return false;
        if (!(this.price == recipe.price)) return false;

        // Iterates through the array of ingredients within each recipe and compares them
        if (this.ingredients.length == recipe.ingredients.length) {
            for (Ingredient ingredient : this.ingredients) {
                boolean foundCopy = false;
                int counter = 0;
                // To ignore the order of the ingredients, foundCopy is used and exits the loop when a matching
                // ingredient has been found in both recipes.
                while (counter < recipe.ingredients.length && !foundCopy) {
                    // Using the overridden equals classes in each of the Ingredients subclasses
                    if (ingredient.equals(recipe.ingredients[counter])) {
                        foundCopy = true;
                    }
                    counter++;
                }
                if (!foundCopy) return false;
            }
        }

        return true;
    }
}
