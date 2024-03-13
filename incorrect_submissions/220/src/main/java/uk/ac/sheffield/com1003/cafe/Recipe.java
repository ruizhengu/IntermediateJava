package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

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

    public boolean equals(Recipe otherRecipe) {
        //create an array for the other ingredients list
        Ingredient[] otherArray = otherRecipe.ingredients;
        //check the price and no. of ingredients are the same
        if (this.price == otherRecipe.price && this.ingredients.length == otherArray.length) {

            //create a count for the no. of ingredients that are the same
            int matchCount = this.ingredients.length;
            System.out.println("This is match count" + matchCount);
            //loop through both arrays
            for (int i = 0; i < this.ingredients.length; i++) {
                for (int m = 0; m < otherArray.length; m++) {
                    if (this.ingredients[i].toString().equals(otherArray[m].toString())) {
                        //if the ingredients, amounts, units, and other instance variables are the same reduce the count
                        matchCount -= 1;
                    }
                }
            }
            System.out.println("This is final match count" + matchCount);
            //if the count is zero all ingredients are the same and return true
            if (matchCount == 0) {
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
}
