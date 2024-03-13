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
    
    public boolean isEqual(Recipe secondRecipe) { //Task 5 implementation
    	int i = 0;
    	int possibleEquals = 0;
    	while(i<this.ingredients.length) {
    		for(int j = 0;j< secondRecipe.ingredients.length;j++) {
    			if(this.ingredients[i] == null && secondRecipe.ingredients[j] == null) { 
    				// If both items are 10 ingredients long with only 3 non-null ingredients 
    				// they are still equal and must be counted as such
    				possibleEquals++;
    			}
    			else if (this.isReady() && secondRecipe.isReady()) { //Prevents null occurrences using the toString method
    				if(this.ingredients[i].toString().equals(secondRecipe.ingredients[j].toString())) {
        				possibleEquals++;
        			}
    			}
    		
    		}
    		i++;
    	}
    	if (possibleEquals == this.ingredients.length) { // Only equal given that all the possible values match
    		return true;
    	}
    	return false;
    }
    
    //Task 5 testing in App.java, used for clarity on differences without breaking JUnit tests
    public void testing(Recipe secondRecipe) { 
    	int i = 0;
    	while(i<this.ingredients.length) {
    		for(int j = 0;j< secondRecipe.ingredients.length;j++) {
    			if(this.ingredients[i].toString().equals(secondRecipe.ingredients[j].toString())) {
    				System.out.println("Current:" + this.ingredients[i].toString());
    				System.out.println("Other:" +secondRecipe.ingredients[i].toString());
    			}
    		}
    		i++;
    	}
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
}
