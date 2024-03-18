package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

import java.util.Arrays;
import java.util.Objects;

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
     *
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
     *
     * @return True if all ingredients of the recipe have been added and false otherwise
     */
    public boolean isReady() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient == null)
                return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object oRecipe) {
        if (this == oRecipe) return true;
        if (oRecipe == null || getClass() != oRecipe.getClass()) return false;
        Recipe recipe = (Recipe) oRecipe;
        //going through the recipe and comparing the array elements individually by cross-referencing them one by one.

        if (recipe.size==this.size && recipe.name==this.name && recipe.price == this.price &&
                recipe.ingredients.length==this.ingredients.length)
            for (Ingredient in1 : ingredients){
                boolean compare = false;
                for (Ingredient in2 : ingredients){
                    if (in1.equals(in2)){
                        compare = true;
                    }
                if (compare = false){
                    return false;
                }
            return true;
                }
            }

        return false;
    }



    public String toString() {
        return "name= " + getName() + " - " + getPrice();
    }
}
