package uk.ac.sheffield.com1003.cafe;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.utils.Util;

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

    public Size getSize() { return size; }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    /**
     * Checks whether recipe is equal to the other recipe. It is equal if they are the same size,
     * all ingredients are set, contain the same ingredients and cost the same.
     *
     * @param secondRecipe Recipe which we want to compare
     * @return True if the passed Recipe is equal to the Recipe instance; otherwise false
     */
    public boolean equals(Recipe secondRecipe) {
        if(this.size != secondRecipe.getSize() || this.price != secondRecipe.getPrice()
                || this.ingredients.length != secondRecipe.getIngredients().length) return false;

        if(Arrays.stream(this.ingredients).anyMatch(Objects::isNull)
                || Arrays.stream(secondRecipe.getIngredients()).anyMatch(Objects::isNull)) return false;


        for(Ingredient secondIngredient : secondRecipe.getIngredients()) {
            if(!containsIngredient(secondIngredient)) return false;
        }

        return true;
    }

    /**
     * Check if the instance contains given ingredient
     *
     * @param ingredient Ingredient to be compared with ingredients
     *                  contained in an instance
     * @return Returns true if ingredient has the same fields values as at least one of the instance ingredients;
     * otherwise false
     */
    private boolean containsIngredient(Ingredient ingredient) {
        for(Ingredient entry : this.ingredients) {
            Map<Field, Object> entryFieldsMap = Util.getAllClassFields(entry);
            Map<Field, Object> ingredientFieldsMap = Util.getAllClassFields(ingredient);
            if(!entryFieldsMap.keySet().equals(ingredientFieldsMap.keySet())) continue;

            boolean areIngredientsEqual = true;
            for(Map.Entry<Field, Object> entryField : entryFieldsMap.entrySet()) {
                if(!entryField.getValue().equals(ingredientFieldsMap.get(entryField.getKey()))) {
                    areIngredientsEqual = false;
                    break;
                }
            }

            if(areIngredientsEqual) return true;
        }
        return false;
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
}
