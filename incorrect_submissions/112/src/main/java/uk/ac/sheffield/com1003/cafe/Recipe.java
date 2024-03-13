package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;


/**
 * Recipe.java  12/03/2023
 * 
 * Modified by Lucas Madle
 */
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

    public Ingredient[] getIngredients() {
        return ingredients;
    }


    /** Check if all ingredients present */
    public boolean isReady() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient == null)
                return false;
        }
        return true;
    }

    private boolean compareIngredients(Ingredient[] other) {
        for (Ingredient i: ingredients) {
            Ingredient otherIngredient = null;
            for (Ingredient j: other) {
                if (i.getName() == j.getName())
                    otherIngredient = j;
            } 
            if (!i.equals(otherIngredient))
                return false;
        }
        return true;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Recipe.class)
            return false;

        Recipe otherRecipe = (Recipe) obj;
        if (otherRecipe.getSize() != size)
            return false;

        if (!otherRecipe.isReady() || !this.isReady())
            return false;
        
        if (otherRecipe.getPrice() != price)
            return false;

        return compareIngredients(otherRecipe.getIngredients());
    }
}
