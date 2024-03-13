package uk.ac.sheffield.com1003.cafe;

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
     * Checks if two recipes are the same.
     * @return True if they have same recipe, size, ingredients and price.
     */
    public boolean equals(Recipe testRecipe) {
    	//check if testRecipe is null or belongs to Recipe
    	if (testRecipe == null || !(testRecipe instanceof Recipe)) {
    		return false;
    	}
    	
    	//check if both recipe has all the ingredients
    	if (!this.isReady() || !testRecipe.isReady()) {
    		return false;
    	}
    	
    	//check if the two recipe has same prize and size
    	if (this.price != testRecipe.price || this.size != testRecipe.size) {
    		return false;
    	}
    	
    	//check if two recipes have same number of ingredients.
    	if (this.ingredients.length != testRecipe.ingredients.length) {
    		return false;
    	}
    	
    	//check if each ingredients in the recipe contains in testRecipe
    	//and vice-versa.
    	for (int i = 0 ; i < this.ingredients.length; i++ ) {
    		Ingredient thisIngredient = this.ingredients[i];
    		Ingredient testIngredient = testRecipe.ingredients[i];
    		if (thisIngredient == null && testIngredient != null) {
    			return false;
    		} else if (thisIngredient != null && !thisIngredient.equals(testIngredient)) {
    			return false;
    		}
    	}
    	return true;
    }
}
