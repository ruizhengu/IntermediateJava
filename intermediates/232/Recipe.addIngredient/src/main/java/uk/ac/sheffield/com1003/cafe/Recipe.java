package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

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
     * takes 2 recipes and compares their ingredients,
     * including instance variables that are specific to certain classes
     *
     * first checks if the recipes have the same number of ingredients,
     * if they do will loop through both arrays and check if they have the same name, the amounts of each ingredient is
     * the same and the units for each ingredient are the same,
     * if they are it will then check what class the ingredient is and check if the specific instance variables of those
     * classes from the 2 recipes are the same.
     *
     * @param recipe
     * @param otherRecipe
     * @return true if all the conditions are met, false otherwise
     */

    public boolean isSameIngredients(Recipe recipe, Recipe otherRecipe){
        if(recipe.ingredients.length == otherRecipe.ingredients.length) {
            for (int i = 0; i < recipe.ingredients.length; i++) {
                if (recipe.ingredients[i].getName() == otherRecipe.ingredients[i].getName()
                        && recipe.ingredients[i].getAmount() == otherRecipe.ingredients[i].getAmount()
                        && recipe.ingredients[i].getUnit() == otherRecipe.ingredients[i].getUnit()){
                    if(recipe.ingredients[i].getClass() == Coffee.class
                            && otherRecipe.ingredients[i].getClass() == Coffee.class){
                        Coffee coffeeTemp1 = (Coffee)recipe.ingredients[i];
                        Coffee coffeeTemp2 = (Coffee) otherRecipe.ingredients[i];
                        if(coffeeTemp1.isDecaf() && coffeeTemp2.isDecaf()){
                            return true;
                        }
                    }
                    if(recipe.ingredients[i].getClass() == Milk.class
                            && otherRecipe.ingredients[i].getClass() == Milk.class){
                        Milk milkTemp1 = (Milk)recipe.ingredients[i];
                        Milk milkTemp2 = (Milk)recipe.ingredients[i];
                        if(milkTemp1.getType() == milkTemp2.getType()){
                            return true;
                        }
                    }
                    if(recipe.ingredients[i].getClass() == Syrup.class
                            && otherRecipe.ingredients[i].getClass() == Syrup.class) {
                        Syrup syrupTemp1 = (Syrup) recipe.ingredients[i];
                        Syrup syrupTemp2 = (Syrup) recipe.ingredients[i];
                        if(syrupTemp1.getFlavour() == syrupTemp2.getFlavour()){
                            return true;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * compares 1 recipe to another checks if they are the same size, have the same price,
     * are ready and have the same ingredients
     *
     * @param recipe
     * @return true if they're the same size, have the same price and ingredients and are ready, false otherwise
     */

    public boolean equals(Recipe recipe) {
        if(this.size == recipe.size
                && this.price == recipe.price
                && (this.isReady() && recipe.isReady())
                && isSameIngredients(this ,recipe)){
            return true;
        }
        return false;
    }
}
