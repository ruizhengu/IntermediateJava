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

    public Size getSize() { return size; }

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

    public boolean equals(Recipe other) {
        if (size != other.getSize() || price != other.getPrice() || ingredients.length != other.ingredients.length)
            return false;

        // Iterate over every combination of between the two recipes, checking which ingredients have already been found
        // already. If an ingredient in this.ingredients doesn't find a match, return false
        boolean equalIngredients[] = new boolean[other.ingredients.length];
        for (Ingredient ingredient : ingredients) {
            if (ingredient != null) {
                boolean ingredientFound = false;

                for (int i = 0; i < ingredients.length; i++) {
                    Ingredient otherIngredient = other.ingredients[i];

                    // If the ingredient matches and hasn't already matched, mark the ingredient as matched in
                    // equalIngredients and go to the next ingredient
                    if (otherIngredient != null) {
                        if (ingredient.equals(otherIngredient) && !equalIngredients[i]) {
                            ingredientFound = true;
                            equalIngredients[i] = true;
                            break;
                        }
                    } else
                        return false;
                }

                // If no ingredient matches, return false
                if (!ingredientFound)
                    return false;
            } else
                return false;
        }

        return true;
    }
}
