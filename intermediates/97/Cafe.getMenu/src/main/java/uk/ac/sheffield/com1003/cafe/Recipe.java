package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

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
     * Checks if two recipes are same despite having different names.
     * @param item from Recipe is compared against another recipe (newItem).
     * @return true if both recipes have the same ingredients, size, price and quantity or else false in any other case.
     */
    
    public boolean equals(Recipe item) {
    	if (item == null || ! (item instanceof Recipe))
			 return false;
    	
    	Recipe newItem = (Recipe) item;
    	
    	boolean ingredientsAreEqual = true;
    	
    	if (this.ingredients.length != newItem.ingredients.length)
    		return false;
    		
    	for (int i=0; i<ingredients.length; i++) {
    		if ((this.ingredients[i] != null && !this.ingredients[i].equals(newItem.ingredients[i])))
    			ingredientsAreEqual = false;
    	}
    	
    	if (this.price == newItem.price && this.size == newItem.size 
    			&& ingredientsAreEqual == true)
    		return true;
    	return false;	
    	
    	
    }
}
