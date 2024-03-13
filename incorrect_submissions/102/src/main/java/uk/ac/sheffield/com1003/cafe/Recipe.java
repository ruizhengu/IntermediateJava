package uk.ac.sheffield.com1003.cafe;

import java.nio.file.FileSystemAlreadyExistsException;
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

    public boolean equals(Recipe otherRecipe) {
        int numberOfSameIngredients = 0;

        // if both recipes have same size, price and number of ingredients
        if (this.size == otherRecipe.size && this.price == otherRecipe.price && this.ingredients.length == otherRecipe.ingredients.length) {

            //for every ingredient in (this) recipe
            for (int thisI = 0; thisI<this.ingredients.length; thisI++) {
                Ingredient thisIngredient = this.ingredients[thisI];

                //for every ingredient in (that) other recipe
                for (int otherI=0; otherI<otherRecipe.ingredients.length; otherI++) {
                    Ingredient thatIngredient = otherRecipe.ingredients[otherI];

                    // compare (this) ingredient with every (that) ingredient
                    if (thisIngredient != null && thatIngredient != null) {

                        if (thisIngredient.getClass() == thatIngredient.getClass() && 
                        thisIngredient.getAmount() == thatIngredient.getAmount() && 
                        thisIngredient.equals(thatIngredient)) {

                            // now increment variable below because the 2 ingredients are same.
                            numberOfSameIngredients++;
                        }       
                    }
                }
            }
        }

        // number of same ingredients is the length of the ingredients 
        // list when the 2 recipes are exactly the same...
        if (numberOfSameIngredients == this.ingredients.length)
            //... therefore, return true, indicating they are the same recipe.
            return true;
        else
            return false;
    }
}
