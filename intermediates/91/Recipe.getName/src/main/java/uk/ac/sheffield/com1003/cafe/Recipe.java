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
     * Compares whether two objects are equal
     * @return True if both objects are Recipes with equal variables besides name, false otherwise
     */
    public boolean equals(Object otherObject)
    {
        Recipe tempRecipe = (Recipe)otherObject;
        if (!(tempRecipe == null) && this.getPrice() == tempRecipe.getPrice() &&
                this.size == tempRecipe.size &&
                this.isReady() == tempRecipe.isReady() &&
                this.getClass() == tempRecipe.getClass()) {
            int matchingIngredientCount = 0;
            /* nested loop exists in case ingredients are of a different order to each other
            (they will still return equal if this is the case).*/
            for (int i = 0; i < this.ingredients.length; i++) {
                for (int j = 0; j < tempRecipe.ingredients.length; j++) {
                    if(this.ingredients[i].equals(tempRecipe.ingredients[j]) ) {
                        matchingIngredientCount = matchingIngredientCount + 1;
                    }
                }
            }
            if (matchingIngredientCount == ingredients.length) { return true; }
            else { return false; }
        }
        else { return false; }
    }


}
