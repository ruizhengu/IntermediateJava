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

    public boolean equals(Recipe otherRecipe){
        if (ingredients.length != otherRecipe.ingredients.length ||
            size != otherRecipe.size ||
            price != otherRecipe.price) {
            return false;
        }
        boolean valid;
        //Validating all ingredients to all the other ingredients
        for (int i=0; i<ingredients.length; i++){
            valid = false;
            for (int n=0; n<otherRecipe.ingredients.length; n++){

                Ingredient thisIngredient = ingredients[i];
                Ingredient otherIngredient = otherRecipe.ingredients[n];
                //Makes sure all ingredients are set
                if (thisIngredient == null || otherIngredient == null){
                    return false;
                }

                if (thisIngredient.equals(otherIngredient)){
                    valid = true;
                }
            }
            if (!valid){
                return false;
            }
        }

        return true;
    }
}
