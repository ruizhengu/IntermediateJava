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
            if (ingredient == null) return false;
        }
        return true;
    }

    @Override//assumes the recipes are made with no redundancies
    public boolean equals(Object other) {
        //false if not a recipe (or null)
        if (other == null || !(other instanceof Recipe)) 
            return false;
        Recipe oth = (Recipe)other;
        //check they're the same length
        if (oth.ingredients.length != ingredients.length)
            return false;
        //check each ingredient for a match
        for (Ingredient ing: oth.ingredients) {
            if (!findIngredient(ing)) return false;
        }
        return true;
    }    

    boolean findIngredient(Ingredient toFind) {
        for (Ingredient iterator: ingredients) {
            //Ingredient iterator = ingredients[i];
            System.out.println(iterator);
            if (iterator != null) {
                if (iterator.equals(toFind) && iterator.getAmount() == toFind.getAmount() && iterator.getUnit() == toFind.getUnit())
                    return true;
            }
        }
        return false;
    }

}
