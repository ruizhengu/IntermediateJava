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
     * Compares one recipe to another recipe.
     * if this recipe the recipe being compared has the same ingredients, price and size
     * and is also a Recipe object then it will return true
     * @param other the object to compare for equality
     * @return true if the other object is equal to this object otherwise it will return false
     */
    @Override
    public boolean equals(Object other) {

        //sets the "other" object to a Recipe object
        Recipe secondRecipe = (Recipe) other;
        //if they are the same then it will return true
        if (other == this){
            return true;
        }
        //if the other object is null then it will return false
        if (other == null){
            return false;
        }
        //if the other object isnt of the same class then it will return false
        if (getClass() != other.getClass()){
            return false;
        }
        //if the prices are not equal then it will return false
        if(this.price != secondRecipe.price){
            return false;
        }
        //if the sizes are not equal then it will return false
        if(this.size != secondRecipe.size){
            return false;
        }

        //if the ingredients array is not equal and its contents are not equal then it will return false
        if (!Arrays.equals(ingredients, secondRecipe.ingredients)) {
            return false;
        }

        //otherwise it will return true
        return true;
    }

}

