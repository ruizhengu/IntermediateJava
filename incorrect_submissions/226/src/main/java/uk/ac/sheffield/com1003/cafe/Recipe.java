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

    // Checks whether two recipes are equal (other than by name)
    public boolean equals(Recipe other) {

        int ingredientNum = this.ingredients.length;

        // Checks that both recipes require the same amount of ingredients, are the same price, and the same size
        if (other.ingredients.length != ingredientNum || other.getPrice() != this.getPrice() || other.size != this.size)
            return false;

        for(int i = 0; i < ingredientNum; i++){

            // Checks that both of the recipes have all of their ingredients set
            if (other.ingredients[i] == null || this.ingredients[i] == null)
                return false;

            for(int j = 0; j < ingredientNum; j++){

                // Checks that each ingredient contained in one recipe is contained in the other
                if (this.ingredients[i].getName().equals(other.ingredients[j].getName()))
                    if(!this.ingredients[i].equals(other.ingredients[j]))
                        return false;
            }
        }
        return true;
    }
}
