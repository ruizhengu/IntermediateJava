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
    
    public boolean equals(Recipe recipeToBeCompared) {
    	
    	if (this.size == recipeToBeCompared.size) {
    		boolean allIngredientsSet = true;
    		// Checks the array of ingredients is filled
    		for (int i = 0; i < this.ingredients.length; i++) {
    			if (this.ingredients[i] == null) {
    				allIngredientsSet = false;
    			}
    		}
    		// Checks the array of ingredients is filled
    		for (int h = 0; h < recipeToBeCompared.ingredients.length; h++) {
    			if (this.ingredients[h] == null) {
    				allIngredientsSet = false;
    			}
    			
    			if (allIngredientsSet == true) {
    				/**
    				 * Checks the arrays contain the same ingredients regardless of order.
    				 * Doesn't concern repeated ingredients as these are filtered out when adding ingredients. 
    				 * (Not possible to have two of the same ingredient in a recipe). 
    				 */
    				for (int j = 0; j < this.ingredients.length; j++) {
    					boolean ingredientMatchFound = false;
    					
    					for (int i = 0; i < recipeToBeCompared.ingredients.length; i++) {
    					
    						if (this.ingredients[j].getClass().equals(recipeToBeCompared.ingredients[i].getClass())) {
    							if (this.ingredients[j].equals(recipeToBeCompared.ingredients[i])) {
    								
    								ingredientMatchFound = true;
    								
    							}
    						}
    						
    						
    					}
    					
    					// Returns false if no matching ingredient is found
    					if (ingredientMatchFound == false) return false;
    					
    					
    				}
    			        // Returns true if all ingredients in array 1 have a matching ingredient in array 2
    					return true;
    				
    				
    			}
    		}
    	}
    	
    	return false;
    	
    }
}
