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

    public Size getSize() {
        return size;
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
     * Checks whether two recipes are equal
     * @param other The recipe to compare against
     * @return True if they are the same size, all ingredients are set,
     *     contain the same ingredients (name, units, amounts, specific instance variables, e.g., Milk.type),
     *     and cost the same, even if their names are different
     */
    public boolean equals(Object other){
        // Check same object type
        if (!(other instanceof Recipe))
            return false;
        Recipe otherRecipe = (Recipe) other;

        // Check same size, cost, and number of ingredients
        if (getSize() != otherRecipe.getSize() || getPrice() != otherRecipe.getPrice() ||
                ingredients.length != otherRecipe.ingredients.length)
            return false;

        // Check if all ingredients are set
        if (!isReady() || !otherRecipe.isReady())
            return false;

        // Check if number of ingredients are the same
        if (ingredients.length != otherRecipe.ingredients.length)
            return false;

        // Check if all ingredients are the same
        // i.e. All ingredients in the first recipe exist in the second recipe
        // This assumes there are no duplicate ingredients (e.g. 20ml Water and another 20ml Water in the same recipe)
        for (Ingredient ingredient : ingredients) {
            boolean ingredientFound = false;
            for (Ingredient ingredient2 : otherRecipe.ingredients) {
                if (ingredient.equals(ingredient2)) {
                    ingredientFound = true;
                    break;
                }
            }
            if (!ingredientFound)
                return false;
        }

        // Couldn't find any differences
        return true;
    }

}
