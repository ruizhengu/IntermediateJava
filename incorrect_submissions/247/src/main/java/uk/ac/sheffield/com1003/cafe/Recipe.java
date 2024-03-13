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
    
    public String toString() {
    	return this.getName();
    }
    
    
    /**
     * 
     * @param another A different recipe
     * @return true if the recipes are the same, and false otherwise.
     */
    public boolean equals(Recipe another) {
    	if (another == null || ! (another instanceof Recipe))
            return false;
    	if (this.size != another.size ||
    			this.price != another.price ||
    			this.ingredients.length != another.ingredients.length)
    		return false;
    	//Iterates through each ingredient and compares them, returns false if they are different
        for (Ingredient ingredient : this.ingredients) {
        	boolean match = false;
            for ( Ingredient otherIngredient : another.ingredients) {
            	if(ingredient.compare(otherIngredient))
            		match = true;
            }
            if (!match)
            	return false;
        }
    	return true;
    }
}
