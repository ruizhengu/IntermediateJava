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

    public Ingredient[] getIngredients() {
        return ingredients;
    }
// the equals function for task 5
    public boolean equals(Recipe compareTo){
        //counter to count how many ingredients match
        int matches = 0;
        //Ensure they have the same price, size and number of ingredients before comparing ingredients
        if(this.price == compareTo.getPrice() && this.getIngredients().length == compareTo.getIngredients().length && this.size == compareTo.size){
            //compare each ingredient to all other ingredients, so that ingredients don't have to be in the samme order
            for (int i = 0; i < ingredients.length; i++) {
                for (int j = 0; j < ingredients.length; j++) {
                    if(ingredients[i] == compareTo.getIngredients()[j]){matches += 1;}
                }
            }
        }

        //The recipes are only the same if all ingredients match, so any less than that return false
        if(matches == ingredients.length){return true;}
        else{return false;}
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
