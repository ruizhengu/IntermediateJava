package uk.ac.sheffield.com1003.cafe;

import java.util.HashSet;
import java.util.Set;

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
     * Checks whether recipe is the same as another.
     * @return true if ingredients, price and size match and false otherwise
     */
    public boolean equals(Recipe recipe) {
    	// Ensure size and price match
    	if (size != recipe.size || price != recipe.price) {
    		return false;
    	}

		// Check if same number of ingredients
		if (ingredients.length != recipe.ingredients.length || !isReady() || !recipe.isReady())
			return false;
		
		for (Ingredient ingredient : ingredients) {
			boolean found = false;
			
			// Prevent two duplicates matching the same item in other ingredients
			Set<Integer> matched = new HashSet<Integer>();
			
			for (int i = 0; i < recipe.ingredients.length; i++) {
				Ingredient otherIngredient = recipe.ingredients[i];
				// Ignore if already matched this item
				if (matched.contains(i)) {
					continue;
				}
				
				if (ingredient.equals(otherIngredient)) {
					found = true;
					matched.add(i);
				}
			}
			
			// Return as soon as one ingredient not found
			if (!found) return false;
		}
		
		return true;
    }
}
