package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
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
     * Compare if two recipes are the same by calling in the form
     * {@link Recipe}.{@link Recipe#equals(Recipe)}.
     *
     * @param recipe The name of the recipe that this
     * {@link Recipe} instance being compared with
     * @return True if the two recipes contains the same ingredients
     * and the prices are equal; return false otherwise
     */
    public boolean equals(Recipe recipe) {
        boolean[] ingredientsMatchArray = new boolean[this.ingredients.length];

        if (this.ingredients.length == recipe.ingredients.length) {
            for (int i=0; i<this.ingredients.length; i++) {
                int j=0;
                while (j < recipe.ingredients.length) {
                    if (this.ingredients[i].equals(recipe.ingredients[j])) {
                        ingredientsMatchArray[i] = true;
                        break;
                    }
                    j++;
                }
                // Boolean array will otherwise be set to false in this index by default
                if (ingredientsMatchArray[i] == false) {
                    return false; // because it means that at least one of the ingredients don't match
                }
            }
        } else {
            return false;
        }

        /*
        If it exits the block above that means all values in the truth array are true.
        Because 'return false' was not called above if the following code is to be executed.
        All that remains to satisfy this condition is if the recipe is not null and the prices are the equal
         */
        if (recipe.isReady() && recipe.getPrice() == this.getPrice()) {
            return true;
        }
        return false;
    }
}
