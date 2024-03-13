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
     * Checks whether two recipes are the same.
     * @return True if recipes are (same size, same cost, all ingredients are set, and contain identical ingredients)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Recipe recipe = (Recipe) obj;
        if (this.size != recipe.size) {
            return false;
        }

        if (!(this.isReady() && recipe.isReady())) {
            return false;
        }

        if (this.price != recipe.price) {
            return false;
        }
        //iterates through both ingredient arrays, checking if an ingredient in the 1st array, exists in the 2nd
        for (int i = 0; i < ingredients.length; i++) {
            boolean match = false;

            for (int j = 0; j < recipe.ingredients.length; j++) {
                //series of checks to see if 2 ingredients are identical
                if (ingredients[i].getClass() == recipe.ingredients[j].getClass()) {

                    if (ingredients[i].getName().equals(recipe.ingredients[j].getName())) {

                        if (ingredients[i].getUnit() == recipe.ingredients[j].getUnit()) {

                            if (ingredients[i].getAmount() == recipe.ingredients[j].getAmount()) {

                                if (ingredients[i].getClass() == Coffee.class) {

                                    Coffee ingredientOne = (Coffee) ingredients[i];
                                    Coffee ingredientTwo = (Coffee) recipe.ingredients[j];
                                    if (ingredientOne.getDecaf() == ingredientTwo.getDecaf()) {
                                        match = true;
                                    }

                                } else if (ingredients[i].getClass() == Milk.class) {
                                    Milk ingredientOne = (Milk) ingredients[i];
                                    Milk ingredientTwo = (Milk) recipe.ingredients[j];
                                    if (ingredientOne.getType() == ingredientTwo.getType()) {
                                        match = true;
                                    }

                                } else if (ingredients[i].getClass() == Syrup.class) {
                                    Syrup ingredientOne = (Syrup) ingredients[i];
                                    Syrup ingredientTwo = (Syrup) recipe.ingredients[j];
                                    if (ingredientOne.getFlavour() == ingredientTwo.getFlavour()) {
                                        match = true;
                                    }

                                } else {
                                    match = true;
                                }
                            }
                        }
                    }
                }
            }
            if (!match) {
                return false;
            }
        }
        return true;
    }
}

