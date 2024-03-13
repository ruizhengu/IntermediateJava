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
    
    public Size getSize() {
    	return size;
    }


    /**
     * Add ingredient to recipe if it does not already exist.
     * If ingredient with the same name already exists, replace it with the new one.
     * @param ingredient Ingredient to be added to recipe.
     * @throws TooManyIngredientsException if the number of ingredients in the recipe would be exceeded
     */
    public void addIngredient(Ingredient ingredient) throws TooManyIngredientsException {
       //counts the number of ingredients initially in there and if there are any of the same name
       int numOfIngredients = 0;
       int indexOfSameName = -1;
       for (int i = 0; i < ingredients.length; i++) {
    	   if (ingredients[i] != null) {
    		   numOfIngredients++;
    	   }
    	   if (ingredients[i] != null && ingredients[i].getName() == ingredient.getName()) {
    		   indexOfSameName = i;
    	   }
       }
       
       //throws too many ingredients exception if there are already max ingredients
       if (numOfIngredients == ingredients.length) {
    	   throw new TooManyIngredientsException(ingredient);
       }
       
       //adds ingredient
       if (indexOfSameName > -1) {
    	   ingredients[indexOfSameName] = ingredient;
       }
       else {
    	   for (int i = 0; i < ingredients.length; i++) {
        	   if (ingredients[i] == null) {
        		   ingredients[i] = ingredient;
        		   break;
        	   }
           }
       }   
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
    
    
    public boolean equals(Recipe recipe2) {
    	//checks same size
    	if (this.getSize() != recipe2.getSize()) {
    		return false;
    	}
    	//checks same amount of ingredients
    	if (this.ingredients.length != recipe2.ingredients.length) {
    		return false;
    	}
    	//checks same ingredients
		if (!this.ingredients.equals(recipe2.ingredients)) {
			return false;
		}
		//checks for same price
    	if (this.getPrice() != recipe2.getPrice()) {
    		return false;
    	}
    	return true;
    }
}
