package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

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
     * Checks if two recipes are fully equal.
     * First checks if they are the same size and price, and if all of their ingredients are set.
     * Then increments through their ingredients list to compare exact ingredient types, measurements, etc.
     * @param recipe
     * @return True if the recipes being compared are fully equal
     */
    public boolean equals(Recipe recipe) {
    	boolean currentValid;
    	int count = 0;
    	if (recipe.size == this.size && recipe.price == this.price && recipe.isReady() && this.isReady()) {
    		for (int i = 0; i < recipe.ingredients.length; i++) {
    			Ingredient currentIngredient = recipe.ingredients[i];
    			currentValid = false;
    			for (int j = 0; j < recipe.ingredients.length; j++) {
    				if (currentIngredient.getName() == this.ingredients[j].getName()) {
    					if (currentIngredient.getName() == "Water") {
    						if (((Water)currentIngredient).equalsW((Water)this.ingredients[j])) 
    							currentValid = true;	
    						}
    					else if (currentIngredient.getName() == "Coffee") {
    						if (((Coffee)currentIngredient).equalsC((Coffee)this.ingredients[j])) 
        						currentValid = true;    						
    						}
    					else {
    						if (((Milk)currentIngredient).equalsM((Milk)this.ingredients[j])) 
        						currentValid = true;    						
    						}
    					}
    				}
    			if (currentValid == true) 
    				count++;
    			}
    		if (count == recipe.ingredients.length)
    			return true;
    		else
    			return false;
    	}
    	else
    		return false;
    }
}
