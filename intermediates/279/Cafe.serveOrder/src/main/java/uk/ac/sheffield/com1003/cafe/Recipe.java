package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;
import java.util.Objects;

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
     * Check if two recipes are the same
     *
     * @param recipe Recipe to be compared
     * @return Returns true if two recipes are the same size, all ingredients are set, contain the same ingredients
     * (including name, units and amounts, and specific instance variables)
     * and cost the same; false otherwise
     */
    public boolean equals(Recipe recipe) {
        if (this.isReady() && recipe.isReady()) {
            Recipe newRecipe = (Recipe) recipe;
            if (price == newRecipe.price && this.size.equals(newRecipe.size)) {
                if (this.ingredients.length == newRecipe.ingredients.length) {
                    int sameIngredients = 0;
                    for(int i = 0; i < this.ingredients.length; i++) {
                        for(int z = 0; z < newRecipe.ingredients.length; z++) {
                            if (this.ingredients[i].equals(newRecipe.ingredients[z])){ sameIngredients++;}
                        }
                    }
                    if (sameIngredients == this.ingredients.length){
                        //These two recipe are same
                        return true;
                    }else {
                        //Ingredients are different
                        return false;
                    }
                }else {
                    //Number of ingredients are different
                    return false;
                }
            }
            else {
                //Size or price are different
                return false;
            }
        }
        else {
                //Recipe is not ready
                return false;
        }

    }
}
