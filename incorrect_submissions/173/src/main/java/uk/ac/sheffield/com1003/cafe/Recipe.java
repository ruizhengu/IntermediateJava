package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

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
    
    
    public boolean equals(Recipe recipe) {
    	
    	if ((this.size != recipe.size) || (this.price != recipe.price)) {
    		
    		return false; 
    		
    	}
    	
    	for (int i=0; i<this.ingredients.length; i++) {
    		if ((this.ingredients[i] == null) || (recipe.ingredients[i] == null)){
    			
    			return false;
    			
    		}
    		
    	}
    		
    	for (int i=0; i<this.ingredients.length; i++) {
    		boolean recipeFound = false;
    		
    		for (int j=0; j<recipe.ingredients.length; j++) {
    			
    			if (this.ingredients[i].getName().equals(recipe.ingredients[j].getName())){
    				recipeFound = true; 
    				
    				if ((this.ingredients[i].getAmount() == recipe.ingredients[j].getAmount()) && (this.ingredients[i].getUnit() == recipe.ingredients[j].getUnit())){
    					
    					if (this.ingredients[i] instanceof Milk) {
    						
    						if (((Milk)this.ingredients[i]).equals(((Milk)recipe.ingredients[j]))){
    							
    							return true;
    							
    						}
    						else {
    							
    							return false;
    						}
    						
    					}
    					
    					else 
    						return true;
    				}
    				
    				else {
    					
    					return false;
    	
    				}
    				
    			}
    			
    		}
    		
    		if (recipeFound == false) {
    			
    			return false;
    			
    		}
    		
    		
    	}
    	
		return false;
    	
    }
}
