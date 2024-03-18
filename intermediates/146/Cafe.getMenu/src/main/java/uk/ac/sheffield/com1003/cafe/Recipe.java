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
	 * Checks whether the given recipe is equal
	 * @param other recipe to check equality of
	 * @return True if equal to given parameter
	 */
	@Override
	public boolean equals(Object another) {
		//check instance type
		if (another == null || !(another instanceof Recipe))
			return false;
		
		Recipe other = (Recipe)another;
		
		//check size
		if(this.size != other.size)
			return false;
		//check ingredients
		if (this.ingredients.length != other.ingredients.length)
			return false;

		//check if all of the ingredients are not null and can be found in the other object
		for (int i = 0; i < this.ingredients.length; i++) {
			//all set check
			if (this.ingredients[i] == null || other.ingredients[i] == null)
				return false;
			
			//check to see whether the object contains a matching ingredient
			boolean containsSame = false;
			for (int j = 0; j < this.ingredients.length; j++) {
				if (this.ingredients[i].equals(other.ingredients[j])) {
					containsSame = true;
				}
			}
			if (!containsSame)
				return false;
		}
		
		//check price
		if (this.price != other.price) 
			return false;
		
		return true;
	}
}
