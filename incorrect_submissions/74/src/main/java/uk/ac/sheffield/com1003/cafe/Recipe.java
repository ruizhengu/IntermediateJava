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
     * Checks whether two recipes are the same
     * @return True if hey are the same size, all ingredients are set, 
     * contain the same ingredients (including name, units and amounts, 
     * and specific instance variables, e.g., Milk.type), 
     * and cost the same, even if their names are different.
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Recipe)) {
            return false;
        }
        Recipe anotherRecipe = (Recipe)another;
        if (size != anotherRecipe.size) return false;
        if (price != anotherRecipe.price) return false;
        if (ingredients.length != anotherRecipe.ingredients.length) return false;
        
        for (int selfIng = 0; selfIng < ingredients.length; ++selfIng) {
            boolean found = false;
            for (int anoIng = 0; anoIng < anotherRecipe.ingredients.length; ++anoIng) {
                if (ingredients[selfIng].equals(anotherRecipe.ingredients[anoIng])) {
                    found = true;
                    break;
                }
            }
            if (! found) return false;
        }
        return true;
    }
}
