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
    

	@Override
    //method for Task 5, checking if two recipes are equal
    public boolean equals(Object other) {
        Recipe otherRecipe = (Recipe)other;

    	if ((this.size != otherRecipe.size)) {
    		return false;
    	}
    	
    	if (this.getPrice()!= otherRecipe.getPrice()) {
    		return false;
    	}
    	
    	if (this.ingredients.length != otherRecipe.ingredients.length) {
    		return false;
    	}
    	//search through array of ingredients, checking if they have equal properties to the other recipe's ingredients
    	for (int i=0;i<ingredients.length;i++) {
    		if (ingredients[i].getAmount() != otherRecipe.ingredients[i].getAmount()) {
    			return false;
    		}
    		if (ingredients[i].getUnit() != otherRecipe.ingredients[i].getUnit()) {
    			return false;
    		}
    		
    		if (ingredients[i].getName() != otherRecipe.ingredients[i].getName()) {
    			return false;
    		}
    	}
    	return true;
	
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
