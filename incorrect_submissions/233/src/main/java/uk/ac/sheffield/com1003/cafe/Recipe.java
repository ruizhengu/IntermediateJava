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
     * Checks if two recipes are equal
     * Recipes are equal if they have the same size, all ingredients are set, they contain the same ingredients (names, units, amounts, instace variables) and cost the same.
     * @returns True if the above conditions are met.
     * */
    public boolean equals(Recipe recipe){
        //check recipe size
        if (this.size == recipe.size) {
            //check if the recipes are complete
            if (this.isReady() && recipe.isReady()) {
                //loop through ingredients, check if they are all equal
                int length = this.ingredients.length;
                if (this.ingredients.length == recipe.ingredients.length){
                    boolean equalIngredients = false;
                    for (int i=0; i < length; i++) {
                        Ingredient ingredient1 = this.ingredients[i];
                        Ingredient ingredient2 = recipe.ingredients[i];
                        if (ingredient1.equals(ingredient2)) {
                            equalIngredients = true;
                        } else {
                            equalIngredients = false;
                        }
                    }

                    if (equalIngredients) {
                        //check if price is equal
                        if (this.getPrice() == recipe.getPrice()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
