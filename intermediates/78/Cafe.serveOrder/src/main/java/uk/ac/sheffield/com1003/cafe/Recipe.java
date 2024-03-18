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

    //look into how to check if all the ingredients are set
    public boolean equals(Recipe recipe) {
        boolean equal = false;

        //Checks recipes are the same size and price
        if (recipe.size == this.size && recipe.price == this.price) {
            //iterates through the ingredients in the second recipe
            for (int x = 0; x < recipe.ingredients.length; x++) {

                //If an ingredient in the second recipe is not set it returns false
                if (recipe.ingredients[x] == null)
                    return false;

                //iterates through the ingredients in the first recipe
                for (int y = 0; y < this.ingredients.length; y++) {
                    //If an ingredient in the first recipe is not set it returns false
                    if (this.ingredients[y] == null)
                        return false;

                    //Compares the ingredients in recipes, if they are the same equals is set to true
                    if ((this.ingredients[y].getName() == recipe.ingredients[x].getName() && 
                            this.ingredients[y].getUnit() == recipe.ingredients[x].getUnit() && 
                                this.ingredients[y].getAmount() == recipe.ingredients[x].getAmount())) {
                        equal = true;
                    } 
                }

                //if a pass has been made an no ingredients match there is no point checking the rest of the recipe so returns false
                if (equal == false) return false;
            }
        } 

        //If the recipes are equal and the ingredients are equal aswell then equal will be true
        //If not the values of equal will be false 
        return equal;
    }
}
