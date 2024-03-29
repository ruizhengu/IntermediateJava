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
	private int numberOfIngredients;
	private int addedIngredients = 0;

    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
        
    }

    public Recipe(String name, double price, Size size, int numberOfIngredients) {
        this.name = name;
        this.price = price;
        this.size = size;
		this.numberOfIngredients = numberOfIngredients;
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
				addedIngredients++;
                return;
            } else
                i++;
        }
        if (i < ingredients.length) {
            ingredients[i] = ingredient;
			addedIngredients++;
		}
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

	public String toString() {
		return "Recipe [name=" + name + ", price=" + price + ", size=" + size + "]";
	}

	public boolean equals(Object another) {
		if (another == null || !(another instanceof Recipe)) {return false; }
		Recipe otherRecipe = (Recipe) another;

		// setup boolean variables that must be truthy
		boolean areSameSize = size == otherRecipe.size;
		boolean sameNumberOfIngredients = numberOfIngredients == otherRecipe.numberOfIngredients;
		boolean areSamePrice = price == otherRecipe.price;
		boolean areAllIngredientsSet = addedIngredients == numberOfIngredients &&
			otherRecipe.addedIngredients == otherRecipe.numberOfIngredients;

		if (!sameNumberOfIngredients || !areAllIngredientsSet) { return false; }

		// Assume true, try to disprove in below for loop
		boolean sameIngredients = true;
		for (int i = 0; i < ingredients.length; i++) {
			Ingredient ingredient = ingredients[i];
			Ingredient otherIngredient = otherRecipe.ingredients[i];
			if (ingredient.equals(otherIngredient))
				sameIngredients = false;
		}

		return areSameSize && areAllIngredientsSet && sameIngredients && areSamePrice;
	}
}
