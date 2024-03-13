package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;
import java.util.Comparator;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

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

    public boolean equals(Object obj) {
        if (obj instanceof Recipe) {
            Recipe r = (Recipe) obj;
            if (this.size != r.size
                    || this.getPrice() != r.getPrice()
                    || this.ingredients.length != r.ingredients.length
                    || !this.isReady()
                    || !r.isReady())
                return false;

            // sort the two ingredient arrays by the name
            Arrays.sort(ingredients, new sortByName());
            Arrays.sort(r.ingredients, new sortByName());

            // compare
            for (int i = 0; i < ingredients.length; i++) {
                if (!ingredients[i].equals(r.ingredients[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * sortByName
     */
    public class sortByName implements Comparator<Ingredient> {
        @Override
        public int compare(Ingredient i1, Ingredient i2) {
            return i1.getName().compareTo(i2.getName());
        }
    }
}
