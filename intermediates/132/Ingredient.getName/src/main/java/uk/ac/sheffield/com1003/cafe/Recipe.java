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

    // finds if two recipes are the same aside from name checks obvious differences then smaller ones in order to catch a false quicker
    public boolean equals(Recipe r2) {
        if ((this.size == r2.size) && (this.ingredients.length == r2.ingredients.length) && (this.getPrice() == r2.getPrice())){
            for (int i = 0; i<this.ingredients.length; i++){
                // if boolean remains false after checking through every ingredient in the other recipe then one ingredient
                // is different so the recipes are not the same
                boolean found = false;
                for (int j = 0; j<r2.ingredients.length; j++){
                    if (this.ingredients[i].getName() == r2.ingredients[j].getName()){
                        if ((this.ingredients[i].getUnit() == r2.ingredients[j].getUnit())&&(this.ingredients[i].getAmount() == r2.ingredients[j].getAmount())){
                            found = true;
                        }
                    }
                }
                if (!found){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
