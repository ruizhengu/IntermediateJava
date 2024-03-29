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

    
    /**
     * Constructor that takes the recipe name and price
     * and initialises size to regular and number of ingredients to 3
     */
    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
        
    }
    
    /**
     * Constructor that takes the recipe name, price, size and
     * number of ingredients as parameters.
     */
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

    /**
     * Getter for recipe name
     * @return recipe name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for recipe price
     * @return recipe price
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Getter for recipe size
     * @return recipe size
     */
    public Size getSize()	{
    	return size;
    }
    
    /**
     * Getter for recipe ingredients
     * @return recipe ingredients in array
     */
    public Ingredient[] getIngredients()	{
    	return ingredients;
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
     * Checks whether two recipes are equal including ingredients 
     * and all instance variables except for recipe name
     * @return True if all recipes are equal (ignoring recipe name)
     */
    public boolean equals(Recipe comparisonRecipe)	{
    	
    	if (comparisonRecipe == null || !comparisonRecipe.isReady() || !this.isReady())
    		return false;
    	//first compraing number of ingredients, recipe size and cost
    	if (this.size == comparisonRecipe.getSize() && 
    			this.ingredients.length == comparisonRecipe.getIngredients().length &&
    				this.price == comparisonRecipe.getPrice())	{
    		
    		
    		int counter = 0;
    		//calls to the overridden equals ingredient method and adds to counter if equal
    		for (int i = 0; i < this.ingredients.length; i++)	{
    			for (int j = 0; j < comparisonRecipe.getIngredients().length; j++)	{
    				
    				if (this.ingredients[i].equals(comparisonRecipe.getIngredients()[j]))	{
    					counter++;  
    					break;
    				}
    				
    			}
    		}
    		
    		if (counter == this.ingredients.length)	{
    			return true;
    		}
    	}
    	return false;
    }
}
