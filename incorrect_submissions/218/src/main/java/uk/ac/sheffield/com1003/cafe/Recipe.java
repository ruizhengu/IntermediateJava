package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Unit;

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
The equals method compares two Recipe objects to see if they are equal using the recipeCheck and ingredientCheck methods
@param type1 The first Recipe object to compare.
@param type2 The second Recipe object to compare.
@return True if the two Recipe objects have the same recipe and ingredients, false otherwise.
*/

    public boolean equals(Recipe type1, Recipe type2) {
        if ((recipeCheck(type1, type2)) && ingredientCheck(type1, type2)) {
            return true;
        }
        return false;
    }
    /**
    This method Checks if two given recipes are of the same size.
    @param type1 the first recipe
    @param type2 the second recipe
    @return if both recipes same size, it returns true otherwise false.
    */  
    public boolean recipeCheck(Recipe type1, Recipe type2) {
        if (type1.size == type2.size) {
            return true;
        } else {
            return false;
        }
    }
    /**
    Checks if two given recipes have the same ingredients with the same names, amounts and units, and the same price.
    @param type1 the first recipe
    @param type2 the second recipe
    @return if both recipes same size, name, amount, units and the same price, it returns true, otherwise false.
    */
    public boolean ingredientCheck(Recipe type1, Recipe type2) {
        if (type1.ingredients.length == type2.ingredients.length) {
            for (int i = 0; i < type1.ingredients.length; i++) {
                String name = type1.ingredients[i].getName();
                int amount = type1.ingredients[i].getAmount();
                Unit unit = type1.ingredients[i].getUnit();
                if (type1.price == (type2.price));

            if ((name.equals(type2.ingredients[i].getName())) && (amount == (type2.ingredients[i].getAmount())) 
            && (unit.equals(type2.ingredients[i].getUnit())))
                return true;
            }
        }
        return false;
    }
}
