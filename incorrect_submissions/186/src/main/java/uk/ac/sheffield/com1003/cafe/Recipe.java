package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    public enum Size { SMALL, REGULAR, LARGE };
    private String name;
    private double price;
    private Size size;
    private Ingredient[] ingredients;

    /**
     * Constructor makes a Recipe when only name and price are given
     * size is set to a regular size by default, this is used to compare recipes
     * numberOfIngredients IS the number of ingredients that can be added to the recipe, set to 3 by default, also used to compare recipes
     * @param name given name of recipe, this will be used to identify it
     * @param price is the cost that is used to find if the customer is paying enough, also used to compare recipes
     */
    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
        
    }

    /**
     * Constructor makes a Recipe when only name and price are given
     * @param name given name of recipe, this will be used to identify it
     * @param price is the cost that is used to find if the customer is paying enough
     * @param size has 3 options (REGULAR,SMALL,LARGE),this is used to compare recipes
     * @param ingredients the number of ingredients that can be added to the recipe, also used to compare recipes
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
     * Task 5
     * Compares if 2 recipies are equal, does this by checking price, size, existence of recipe and number of ingredients. 
     * If these pass it then checks all the ingredients are the same by comparing them.
     * 
     * Note ingredients[i] don't need all internal values checked as they won't return equal if anything is changed about them
     * This doesn't take into consideration equal ingredients in different postisions in the array
     */
    public boolean equals(Recipe another) {
        if (another != null && this.price == another.price 
            && this.size == another.size 
            && this.ingredients.length == another.ingredients.length){
            int i = 0;
            while (i < ingredients.length) {
                if (this.ingredients[i] != another.ingredients[i]) {
                    return false;
                }
                i++;
            }
            return true;
        } else {
            return false;
        }
    }
    
}
