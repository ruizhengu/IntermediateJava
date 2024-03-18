package uk.ac.sheffield.com1003.cafe;

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
        //array start with 0
        ingredients = new Ingredient[numberOfIngredients - 1];
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

    public boolean equals(Recipe r){
        //check the recipes if they have the same price and the same number of ingredients
        if(r.isReady() ==  this.isReady() && r.getPrice() == this.getPrice() && r.ingredients.length == this.ingredients.length){
            int numberOfSameIngredients = 0;
            for(int m=0; m<this.ingredients.length; m++){
                for(int n=0; n<this.ingredients.length; n++){
                    //check if the same type of ingredient
                    if(r.ingredients[m].equals(this.ingredients[n])){
                        numberOfSameIngredients++;
                        //check the unit, amount and specific instance variables
                        if(!(r.ingredients[m].toString() == this.ingredients[n].toString())){
                            return false;
                        }
                    }
                }
            }
            //check if they have the same ingredients
            if (numberOfSameIngredients != this.ingredients.length){
                return false;
            }
            return true;
        }
        return false;

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
}
