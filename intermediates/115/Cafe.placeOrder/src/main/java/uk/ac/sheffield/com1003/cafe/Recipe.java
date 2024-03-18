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
    
    /**
     * Checks whether 2 recipes are equal
     * @param r
     * @return True if the recipes have the same size, price, number of ingredients and ingredients (with the same amounts of each)
     */
    public boolean equals(Recipe r) {
    	boolean isEqualIngredient = true;
    	//evaluates if size and price are the same and if the ingredient arrays are filled
    	boolean isEqual = ((size == r.size) && (this.isReady() == r.isReady())
    				&& (getPrice() == r.getPrice()));
    	if((ingredients.length == r.ingredients.length) && isEqual) {	
    		/*double for loop to compare the entirety of the two arrays incase
    		the order of the ingredients are different*/
    		for(int i = 0; i < ingredients.length; i++) {
    			for(int j = 0; j < r.ingredients.length; j++) {
    				isEqualIngredient = ingredients[i].toString().equals(r.ingredients[j].toString());
    				//if a match is found for the ingredient no need to keep looping
    				if(isEqualIngredient) {
						break;
					}
    			}
    			//if one of the ingredients comes out as false at the end of 2nd loop, the 1st loop is broken
    			if(!isEqualIngredient) {
    				break;
    			}
    		}
    	}
    	//true if everything before is true
    	isEqual = isEqual && isEqualIngredient;
    	return isEqual;	
    }
}
