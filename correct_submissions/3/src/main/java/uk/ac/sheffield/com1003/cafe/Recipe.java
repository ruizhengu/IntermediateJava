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
     * Recipe is equal to another recipe is price, size of recipe match, and the recipes contain
     * the same ingredients by name, unit, amount, and unique attribute. The name of the recipe
     * need not be the same.
     * @param another The other recipe
     * @return whether they match
     */
    @Override
    public boolean equals(Object another) {
        // Task 5 - Guard clause to check if same object type since.
        // Using getClass over instanceof because Dr. Rojas said there are no subclasses.
        if (another == null || another.getClass() != Recipe.class || !isReady()) {
            return false;
        }

        // Guard clause to check if price, size and number of ingredients are at least the same
        Recipe other = (Recipe) another;
        if (other.price != price || other.size != size
                || ingredients.length != other.ingredients.length
                || !other.isReady()) {
            return false;
        }

        // Stores a record of the matches found to the other ingredients list
        boolean[] matchesFound = new boolean[ingredients.length];
        // loops through each ingredient comparing them to the other ingredient
        for (Ingredient ingredient : ingredients) {
            int j = 0;
            boolean matchFound = false;
            while (j < ingredients.length && !matchFound) {
                // if the other ingredient has already been matched, skip
                if (!matchesFound[j]) {
                    // if this ingredient matches the other ingredient, record the match
                    if (ingredient.equals(other.ingredients[j])) {
                        matchesFound[j] = true;
                        matchFound = true;
                    }
                }
                j++;
            }
            // If a match wasn't found for this ingredient, then the recipes don't match
            if (matchFound == false) {
                return false;
            }
        }
        // If we haven't returned yet, then the recipes match
        return true;
    }
}
