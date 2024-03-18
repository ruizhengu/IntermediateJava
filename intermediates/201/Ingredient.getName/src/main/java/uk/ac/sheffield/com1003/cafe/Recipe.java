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

    public static boolean equals(Recipe recipeOne, Recipe recipeTwo) {

        boolean recipesEqual;

        if(recipeOne.getPrice() == recipeTwo.getPrice() &&
                recipeOne.size == recipeTwo.size &&
                recipeOne.ingredients.length == recipeTwo.ingredients.length) {

            //Prices, size and number of ingredients are the same.
            //Now iterate through ingredients to check if all are equal
            //ingredients[] is an array of ingredients, check arrays are the same

            recipesEqual = true;
            for(int i = 0; i < recipeOne.ingredients.length; i++) //iterate through each ingredient in the first recipe
            {
                if(!recipeOne.ingredients[i].toString().equals(recipeTwo.ingredients[i].toString())) //if the ingredients are not equal
                {
                    recipesEqual = false;
                }
            }
        }
        else {
            recipesEqual = false; //either the price, size or number of ingredients is different
        }

        return recipesEqual;
    }
}
