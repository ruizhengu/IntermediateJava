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

    /**
     * Compare all the ingredients of the recipe provided by customer with the ones that are in the recipe menu
     * Loop through ingredients of the recipe provided by customer and compare with the ingredients of
     * recipe in the recipe menu.
     * If the ingredient has same details such as name, units, amount, etc. noOfIngMatched will increase by one
     * If noOfIngMatched is equal to the length of ingredients in the recipe which means both recipes are same and
     * return true
     * @param recipe Object to be compared with the ones in recipe.
     */
    public boolean equals(Object recipe) {
        // To check if recipe is an instance of Recipe class
        if (recipe == null || ! (recipe instanceof Recipe)) {
            return false;
        }

        Recipe recipeMatching = (Recipe) recipe;

        if (recipeMatching.ingredients.length == this.ingredients.length){
            if (recipeMatching.size == this.size && recipeMatching.price == this.price) {
                int noOfIngMatched = 0;
                for (int i = 0; i < recipeMatching.ingredients.length; i++) {
                    for (int j = 0; j < this.ingredients.length; j++) {
                        if (recipeMatching.ingredients[i].equals(this.ingredients[j])) {
                            noOfIngMatched++;
                        }
                    }
                }
                if (noOfIngMatched == this.ingredients.length) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else
            return false;
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

    public String toString(){
        return getName() + " - " + getPrice();
    }
}
