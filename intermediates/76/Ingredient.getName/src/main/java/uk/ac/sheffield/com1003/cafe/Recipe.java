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
     * Checks if two recipes are the same
     *
     */
    public boolean recipeEquals(Recipe recipe){
        if (this.size != recipe.size){
            return false;
        }
        if (this.getPrice() != recipe.getPrice()){
            return false;
        }
        if (this.ingredients.length == recipe.ingredients.length){
            for (int i = 0; i < this.ingredients.length-2; i++){
                boolean match = false;
                int matchIndex = 0;
                for (int j = 0; j < recipe.ingredients.length-2; j++){
                    if (this.ingredients[i].getName() == recipe.ingredients[j].getName()){
                        match = true;
                        matchIndex = j;
                    }
                }

                if (match == false){
                    return false;
                }
                if (this.ingredients[i].getAmount() != recipe.ingredients[matchIndex].getAmount()) {
                    return  false;
                }
                if (this.ingredients[i].getUnit() != recipe.ingredients[matchIndex].getUnit()) {
                    return  false;
                }
                if(this.ingredients[i].getFlavour() != null && recipe.ingredients[matchIndex].getFlavour() != null && this.ingredients[i].getFlavour() != recipe.ingredients[matchIndex].getFlavour()){
                    return false;
                }
                if(this.ingredients[i].getType() != null && recipe.ingredients[matchIndex].getType() != null && this.ingredients[i].getType() != recipe.ingredients[matchIndex].getType()){
                    return false;
                }
                if(this.ingredients[i].getDecaf() != false && recipe.ingredients[matchIndex].getDecaf() != false && this.ingredients[i].getDecaf() != recipe.ingredients[matchIndex].getDecaf()){
                    return false;
                }

            }
        } else {
            return false;
        }


        return true;
    }
}
