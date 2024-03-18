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

    public Size getSize(){
        return size;
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


    /*
     * recipes are equal if they're the same size, all ingredients are set, contain the same ingredients and cost the same
     * ingredients are the same if their name, units, amounts and other specific instance variables are the same
     * The name of the recipe does not need to be the same
     * Proposed method::
     * write an overriding method for each Ingredient so that they can be compared with other Ingredients using methods specific to their type
     * 
     */
    public boolean equals(Recipe compare){

        int matches = 0;
        /*
         *checks to see if every aspect of the Recipe and Ingredients are
         *equal using multiple condition If statement
         */
        if (size == compare.getSize() && price == compare.getPrice() 
          && ingredients.length == compare.ingredients.length && isReady()){
            for (int i = 0; i < ingredients.length; i++){
                for (int j = 0; j < compare.ingredients.length; j++){
                    if (ingredients[i].equals(compare.ingredients[j])){
                        matches++;
                    }
                }
            }
            if (matches == ingredients.length){
                return true;
            }
        }
        return false;
    }
}
