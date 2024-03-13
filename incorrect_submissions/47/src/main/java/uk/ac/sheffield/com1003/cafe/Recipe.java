package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
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

    public boolean equals(Recipe recipe) {
        // compare size
        if(size != recipe.size) return false;

        // compare price
        if(price != recipe.price) return false;

        // compareingredients
        // compare length
        if(ingredients.length != recipe.ingredients.length) return false;
        // compare name, unit and amount
        for(int i=0; i<ingredients.length; i++) { // assuming ingredients in same order
            if(ingredients[i].getName() != recipe.ingredients[i].getName() ||
                    ingredients[i].getUnit() != recipe.ingredients[i].getUnit() ||
                    ingredients[i].getAmount() != recipe.ingredients[i].getAmount()) return false;
            // compare instance-specific variables
            if(ingredients[i] instanceof Milk) {
                Milk.Type fType = ((Milk) ingredients[i]).getType();
                Milk.Type sType = ((Milk) recipe.ingredients[i]).getType();
                if(fType != sType) return false;
            }
            if(ingredients[i] instanceof Coffee) {
                boolean fdecaf = ((Coffee) ingredients[i]).getDecaf();
                boolean sdecaf = ((Coffee) recipe.ingredients[i]).getDecaf();
                if(fdecaf != sdecaf) return false;
            }
            if(ingredients[i] instanceof Syrup) {
                String fFlavour = ((Syrup) ingredients[i]).getFlavour();
                String sFlavour = ((Syrup) recipe.ingredients[i]).getFlavour();
                if(!fFlavour.equalsIgnoreCase(sFlavour)) return false;
            }
        }
        return true;
    }
}
