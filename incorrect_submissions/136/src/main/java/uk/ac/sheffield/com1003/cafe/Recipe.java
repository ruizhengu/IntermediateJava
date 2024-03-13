package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    public enum Size { SMALL, REGULAR, LARGE };
    private String name;
    private double price;
    private Size size;
    private Ingredient[] ingredients;


    /**
     * Constructors for recipes
     * @param name
     * @param price
     */
    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
        
    }

    /**
     * Constructor considering the ingredients
     * @param name
     * @param price
     * @param size
     * @param numberOfIngredients
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
	 *Checks whether a recipe is equal to another recipe.
	 *@return True (if flag==True) if the price, size, length and the ingredients are equal(regardless of order) even if
	 *		  recipe names are different.
	 *@return False if different recipes (regardless of name).
	 */
	  
    
    public boolean equals(Object obj) {
    	boolean flag = false;
        if (obj instanceof Recipe) {
            Recipe other = (Recipe) obj;
            if (price == other.price && size == other.size) {
            	flag = true;
                if (ingredients.length == other.ingredients.length) {
                	List<Ingredient> ingredientsList = Arrays.asList(ingredients);
                	List<Ingredient> otherIngredientsList = Arrays.asList(other.ingredients);

                	if (ingredientsList.containsAll(otherIngredientsList)) {
                	    flag = true;
                	}
                	else {
                		flag = false;
                	}

                } else {
                	flag = false;
                }
                
            }
            }
            

        return flag;
    }




}
