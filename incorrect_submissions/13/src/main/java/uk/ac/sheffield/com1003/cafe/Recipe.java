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

    public boolean equals(Recipe otherRecipe) {

        int trueCounter = 0;

        if (this.size == otherRecipe.size) {

            /* if the sizes are the same, it will the check if any of the ingredients in the first recipe are null */
            for (int i = 0; i < this.ingredients.length; i++) {
                if (this.ingredients[i] == null) {return false;}
            }

            /* for every ingredient in the second recipe, we will now check if the ingredient is null and also if that
            ingredient matches any of the ingredients in the first recipe by using the toString() method */
            for (int i = 0; i < otherRecipe.ingredients.length; i++) {
                if (otherRecipe.ingredients[i] == null) {return false;}
                String otherRecipeIngredient = otherRecipe.ingredients[i].toString();

                for (int j = 0; j < this.ingredients.length; j++) {
                    if ((otherRecipeIngredient.compareTo(this.ingredients[j].toString())) == 0) {
                        trueCounter += 1;
                    }
                }
            }
        }

        /* finally checks if all ingredients were the same and if the prices are the same */
        if ((trueCounter == this.ingredients.length) && (this.getPrice() == otherRecipe.getPrice())) {return true;}
        else {return false;}

    }
}
