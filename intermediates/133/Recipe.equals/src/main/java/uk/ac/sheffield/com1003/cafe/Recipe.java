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

    //Added my own methods for task 5
    public Size getSize() { return size; }

    public int getIngredientNumber() { return ingredients.length; }


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

    //Method to check if two recipes are the same
    public boolean equals(Recipe recipe2){

        //Checking simpler things match
        if (this.getPrice() != recipe2.getPrice() || this.getSize() != recipe2.getSize() ||
        this.getIngredientNumber() != recipe2.getIngredientNumber()){
            return false;
        }


        //Checking to see if the ingredient objects are the same
        int checkSum = 0;
        for (int i=0; i < this.getIngredientNumber(); i++){
            for (int j=0; j< this.getIngredientNumber(); j++){
                if (this.ingredients[i].equals(recipe2.ingredients[j]))
                    checkSum++;
            }
        }
        if (checkSum == this.getIngredientNumber()){
            return true;
        }
        System.out.println("you fucked up");
        return false;
    }
}
