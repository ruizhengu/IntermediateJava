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
     * Check if two recipes are the same.
     * @param otherRecipe the compared recipe
     * @return Ture if they are the same size, cost, ingredients including units 
     *         and mounts, even if their names are different
     */
    public boolean equals(Recipe otherRecipe){
        if (otherRecipe == null || ! (otherRecipe instanceof Recipe))
            return false;

        if (this.size != otherRecipe.size 
            || this.price != otherRecipe.price 
                || ingredients.length != otherRecipe.ingredients.length){
                    return false;
        }

        boolean isSame = false;
        for (int i=0; i<ingredients.length; i++){
            Ingredient ingredient = ingredients[i];
            int j = 0;
            isSame = false;
                while (isSame == false){
                    Ingredient othIngredient = otherRecipe.ingredients[j];
                    if (ingredient.equals(othIngredient)){
                        isSame = true;
                    }else{
                        if (j == ingredients.length-1){
                            return false;
                        }
                        j++;
                    }
                }
        }
        return isSame;
    }
}
