package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class Recipe {
    public enum Size { SMALL, REGULAR, LARGE };
    private String name;
    private double price;
    private Size size;
    public Ingredient[] ingredients;

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
    //can't work out why this doesn't work//
    public void addIngredient(Ingredient ingredient) throws TooManyIngredientsException {
        int i = 0;
        while (i < ingredients.length) {
            if (ingredients[i] == null || ingredients[i].equals(ingredient)) {
                ingredients[i] = ingredient;
                return;
            } else
            	i++;
        }
        //I have no idea why this line doesn't get triggered by the test
        throw new TooManyIngredientsException(), this.ingredients.length);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    
    public String getSize() {
    	return this.size.name();
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
    
    /*for this I saw a nested while loop as necessary since recipes could have the same ingredients but in different positions, so need to check all indexes
    in one array against all indexes in other
    I suspect this is too complicated, but it's the only way of thoroughly checking that I could think of
    */
    public boolean equals(Object otherObject) {
    	
    	//standard checks for equality//
    	if(otherObject == null || ! (otherObject instanceof Recipe)){
    		return false;
    	}
    	if(otherObject == this) {
    		return true;
    	}
    	
    	//converting to recipe type then comparing recipe-specific variables size, price and number of ingredients//
    	Recipe otherRecipe = (Recipe)otherObject;
    	if(otherRecipe.getSize() == this.getSize() && otherRecipe.getPrice() == otherRecipe.getPrice() && otherRecipe.ingredients.length == this.ingredients.length){
    		
    		/*checking that both ingredients lists are the same; does so by going through each item of the ingredient list and comparing it
    		to each value in the other recipe's list(as recipes can have the same ingredients in different orders) by using a consistent boolean
    		called isPresent to stop the search whenever there is found to be inequality in the lists
    		also contains checks for null values at the start of each iteration
    		*/
    		boolean isPresent = true;
    		int i = 0;
    		while(i < this.ingredients.length && isPresent) {
    			if(this.ingredients[i] == null) {return false;}
    			isPresent = false;
    			int j = 0;
    			while(j < ingredients.length && !isPresent) {
        			if(this.ingredients[j] == null) {return false;}
    				isPresent = otherRecipe.ingredients[j] == this.ingredients[i] || ( //check that pointers are the same
    						otherRecipe.ingredients[j].getClass() == this.ingredients[i].getClass() && //check that the classes are the same (eg milk,coffee)
    						otherRecipe.ingredients[j].getName() == this.ingredients[i].getName() && //names
    						otherRecipe.ingredients[j].getAmount() == this.ingredients[i].getAmount() && //amounts
    						otherRecipe.ingredients[j].getUnit() == this.ingredients[i].getUnit() //units
    						);
    				
    				/*Milk and coffe-specific checks
    				 * Checks if the ingredient is both milk or coffee and if it is either, does a class-specific check
    				 * for milk checks that the milk type is the same, for coffee checks that the decaf bool is the same//
    				 */
    				if(isPresent) { 					
    					if(this.ingredients[i] instanceof Milk) {
    						if(((Milk) (otherRecipe.ingredients[i])).getType() != ((Milk) this.ingredients[i]).getType()) {
       							isPresent = false;
       						}
    					}			
    					else if(this.ingredients[i] instanceof Coffee) {
    						if(((Coffee) (otherRecipe.ingredients[i])).getDecaf() != ((Coffee) this.ingredients[i]).getDecaf()){
   								isPresent = false;
   							}					
    					}
    	    		}
    				j++;
    			}	
    			i++;
    		}
    		//at the end of the  loop, if any of the ingredients in array A weren't present in array B, isPresent will be false 
    		return isPresent;	
    	}		
    	//if the while loops are never entered, the if was false, the values were not equal, returns false
    	return false;	
    }
}
