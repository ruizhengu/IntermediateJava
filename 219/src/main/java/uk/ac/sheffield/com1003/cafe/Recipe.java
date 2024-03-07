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

    @Override
    public boolean equals(Object obj) {
        //Check that object is the same class
        if(obj == null || !(obj instanceof Recipe)){
            return false;
        }

        //Get object as recipe class
        Recipe other = (Recipe) obj;

        //Check size is equal
        if(this.size != other.size){
            return false;
        }

        //Check all ingredients are set
        for(Ingredient i : other.ingredients){
            if(i == null){
                return false;
            }
        }

        //Check ingredients are the same (including amounts)
        //For each ingredient in this recipe
        for(Ingredient i : this.ingredients){
            boolean ingredientFound = false;

            //Compare against ingredients in other recipe
            for(Ingredient j : other.ingredients){
                //Check ingredients match
                if(i.equals(j)){
                    ingredientFound = true;
                }
            }
            //Check if the ingredient was found
            if(!ingredientFound){
                return false;
            }
        }

        //Check cost is the same
        if(this.price != other.price){
            return false;
        }

        return true;
    }
}
