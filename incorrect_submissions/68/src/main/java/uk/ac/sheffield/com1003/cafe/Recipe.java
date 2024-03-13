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
     * Checks to see if this recipe is the same as another recipe
     * @return Returns true whether the other recipe is the same is this, false otherwise
     */
    public boolean equals(Recipe otherRecipe){

        //is ingredient size the same?
        if(ingredients.length != otherRecipe.ingredients.length){
            return false;
        }

        //are all ingredients set?
        if(!isReady() || !otherRecipe.isReady()){
            return false;
        }

        //is the cost the same?
        if(price != otherRecipe.getPrice()){
            return false;
        }

        //is the size (physical) of the recipe the same?
        if(!size.equals(otherRecipe.size)){
            return false;
        }

        //are all the ingredients the same? (same name, units, amounts, specific instance variables
        boolean fullMatch = true;
        int i = 0;
        while(fullMatch && i < ingredients.length){
            boolean ingredientMatch = false;
            int j = 0;
            while(!ingredientMatch && j < ingredients.length){

                //compare current ingredient with other recipe's ingredient "j"
                ingredientMatch = ingredients[i].equals(otherRecipe.ingredients[j]);
                j++;
            }

            //if all the other recipes ingredients check and no matches,
            //the recipes will never match.
            fullMatch = ingredientMatch;
            i++;
        }

        return fullMatch;
    }
}
