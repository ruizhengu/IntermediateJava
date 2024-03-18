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
     * Finds if there are two ingredients with the same name and if there is calls ingredientVariablesMatch on them
     * @param recipeComparedWith Recipe to be compared with
     * @return True if the ingredients have the same properties; return false otherwise
     */
    public boolean ingredientsMatch(Recipe recipeComparedWith) {
        boolean ingredientsMatch = true;
        for (Ingredient ingredient1 : ingredients) {
            boolean ingredientMatches = false;
            for (Ingredient ingredient2 : recipeComparedWith.ingredients) {
                //Runs ingredientVariablesMatch when two ingredients are the same in the recipe
                if (ingredient1.getName().equals(ingredient2.getName())) {
                    if (ingredient1.ingredientVariablesMatch(ingredient2))
                        ingredientMatches = true;
                }
            }
            if (!ingredientMatches)
                ingredientsMatch = false;
        }
        return ingredientsMatch;
    }

    /**
     * Check if two recipe are the same
     * Checks if all ingredients are set and checks if these values are the same:
     *      Size of the recipe
     *      Price of the recipe
     *      All the ingredients with the same variables
     * @param recipeComparedWith Recipe to be compared
     * @return True if the recipe are the same, otherwise return false
     */
    public boolean equals(Recipe recipeComparedWith) {
        boolean sameSize = this.size == recipeComparedWith.size;
        boolean samePrice = this.price == recipeComparedWith.price;
        boolean ingredientsAreSet = this.isReady() && recipeComparedWith.isReady();
        boolean sameAmountOfIngredients = this.ingredients.length == recipeComparedWith.ingredients.length;
        //Checks ingredients and returns true if everything else matches
        if (sameAmountOfIngredients) {
            boolean ingredientsMatch = ingredientsMatch(recipeComparedWith);
            return (sameSize && samePrice && ingredientsAreSet && ingredientsMatch);
        } else
            return false;
    }
}

