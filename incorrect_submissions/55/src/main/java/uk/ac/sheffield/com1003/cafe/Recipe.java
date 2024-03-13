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
    
//---------------------------------------------------------------------------------
//---------------------------------------------------------------------------------
    
    //implementing a getter method to get size of recipes for Task-5
    public Size getSize() {
    	return size;
    }
    
  //implementing equals method for task-5
    public boolean compareRecipes(Recipe recipe1, Recipe recipe2) {
		if (recipe1.getPrice() == recipe2.getPrice()) {
			if (recipe1.getSize() == recipe2.getSize()) {
				if (recipe1.isReady() == true) {
					if (recipe2.isReady() == true) {
						//System.out.println("Ingredients of recipe 1 and recipe 2 are set");
						System.out.print("The Prices and Size of the given recipes");
						System.out.println(" are the same same and ingredients are set");
					}
				}
			}
		} else {
			return false;
		}
			
		//check ingredients
    	for (int i=0; i<ingredients.length; i++) {
    		try {
				recipe1.addIngredient(ingredients[i]);
				recipe2.addIngredient(ingredients[i]);
				
			} catch (TooManyIngredientsException e) {
				e.printStackTrace();
			}
    	}
    	
		return false;
    }
    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------

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
