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

    public boolean equals(Recipe recipe){
        //Determine if two drinks are the same by comparing size, ingredient settings,
        // price and total number of ingredients
        if(recipe.size == this.size && recipe.isReady() == this.isReady() && recipe.getPrice() == this.getPrice() &&
                recipe.ingredients.length == this.ingredients.length){
            //Check the ingredients of the drink
            int sameIngredients = 0;
            //With nested loops, check for the same number of ingredients between the two drinks.
            for(int i = 0; i < recipe.ingredients.length; i++){
                for(int j = 0; j < recipe.ingredients.length; j++){
                    if (recipe.ingredients[i] == this.ingredients[j]){
                        sameIngredients = sameIngredients + 1;
                        //check name, units and amounts, and specific instance variables
                        if(recipe.ingredients[i].toString() != this.ingredients[j].toString()){
                            return false;
                        }
                    }
                }
            }
            //If sameIngredients cannot match the length of ingredients, it will prove that they are not the same
            if(sameIngredients == recipe.ingredients.length){
                return true;
            }
            return false;
        }
        return false;
    }


}
