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

    // Checks if 2 recipes are equal
    public boolean equals(Object recipe) {
        if (recipe == null || recipe.getClass() != Recipe.class){
            return false;
        }

        // Checks if any of the recipies have not been added
        Recipe anotherRecipe = (Recipe)recipe;
        if (!(anotherRecipe.isReady() && this.isReady())){
            return false;
        }

        // // Checks the price, size and the ingredients of the recipies
        if (anotherRecipe.getPrice() == this.price && anotherRecipe.size == this.size){
            // Checks the ingredients of the recipies
            for (int i = 0; i < ingredients.length; i++){
                for (int j = 0; j < anotherRecipe.ingredients.length; j++) {
                    if ((this.ingredients[i].getClass() == anotherRecipe.ingredients[j].getClass()) 
                        && (!anotherRecipe.ingredients[j].equals(this.ingredients[i]))){
                        return false;
                    }
                }
            }
        } else {
            return false;
        }

        return true;
    }
}
