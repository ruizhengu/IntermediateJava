package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;


public class Recipe {
	//enum declaration
    public enum Size { SMALL, REGULAR, LARGE };
    //instance variables
    private String name;
    private double price;
    private Size size;
    private Ingredient[] ingredients;

    //constructor1
    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
        
    }
    //constructor2
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
    
    //get name method
    public String getName() {
        return name;
    }
    //get price method
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
    
   @Override
    public boolean equals (Object givenRecipe) {
	   //Checks if the object is an instance of Recipe then casts it
	   if (givenRecipe instanceof Recipe) {
		   Recipe tester = (Recipe)givenRecipe;
		   //compares prices, size and number of ingredients
		   if(this.getPrice() == tester.getPrice() &&(this.ingredients.length == tester.ingredients.length) &&
			(this.size == tester.size)){	
			   
			   for(int j =0; j<ingredients.length; j++){
				   //for the recipe object
				   Ingredient h = this.ingredients[j];
				   //for the tester object
				   Ingredient k = tester.ingredients[j];
				   
				   if(h == null || k == null) {
					   return false;
				   }
				   //invokes equals methods of each of the ingredients
				   for(int i =0; i<ingredients.length; i++) {
					  if(h.equals(tester.ingredients[i])) {
						   return true;
					  }  
				   }	   
			   }
		   }
	   }  
	   return false;
   }
   
}
