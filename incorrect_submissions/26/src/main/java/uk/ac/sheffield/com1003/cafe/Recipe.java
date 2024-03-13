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

    public Size getSize() {
        return size;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
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

    public boolean equals(Object other){
        if (other == null || !(other instanceof Recipe)) { return false; }
        if (other == this) { return true; }
        Recipe otherRecipe = (Recipe)other;
        if (otherRecipe.getIngredients().length != this.ingredients.length) { return false; }

        if (otherRecipe.getPrice() != this.price) { return false; }
        if (otherRecipe.getSize() != this.size) { return false; }

        //For every ingredient in ingredients, make sure an identical ingredient exists in other.ingredients
        for (Ingredient ingredient : ingredients) {
            if (ingredient != null){
                Boolean foundMatch = false;
                for (Ingredient otherIngredient : otherRecipe.getIngredients()) {
                    if(otherIngredient == null) { return false; }
                    if(ingredient.toString().equals(otherIngredient.toString())) { foundMatch = true; }
                }
                if (!foundMatch) { return false; }
            } else {
                return false;
            }
        }
        
        return true;
    }
}
