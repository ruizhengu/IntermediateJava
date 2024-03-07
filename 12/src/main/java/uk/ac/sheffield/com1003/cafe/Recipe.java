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

    public Size getSize() {
        return size;
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
     * Checks if two recipes are equal.
     * Two recipes are equal if:
     *    1- Same size 
     *    2- Ingredients are set 
     *    3- Same ingredients (including names, units, amounts, and specific instance variables)
     *    4- Same cost
     * @param recipe1 recipes to be evaluated against each other
     * @param recipe2 recipes to be evaluated against each other
     * @return True if the two recipes are equal (i.e. they satisfy the conditions above)
     */
    public boolean equals(Recipe recipe1, Recipe recipe2) {

        boolean sameIngredients = Arrays.deepEquals(recipe1.ingredients, recipe2.ingredients);
    
        if (recipe1.getSize() == recipe2.getSize() 
        && recipe1.getPrice() == recipe2.getPrice() 
        && sameIngredients && recipe1.isReady() && recipe2.isReady()) {

            return true;
        }
        
        return false;
    }
}
