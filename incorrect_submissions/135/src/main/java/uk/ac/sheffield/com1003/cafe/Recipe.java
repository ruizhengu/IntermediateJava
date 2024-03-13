package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

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
     * Checks whether the recipe is "equal" to another.
     * @param another is the other recipe
     * @return true if all factors but name matches
     */
    public boolean equals(Recipe another){
        if(this.size ==another.size){
            if(this.price == another.price){
                if(this.ingredients.length == another.ingredients.length){
                    int cor = 0; //correct matches of ingredient, if = length, then all equal.
                    for(int i = 0; i < this.ingredients.length; i++){
                        for(int j = 0;j< another.ingredients.length; j++){
//                            System.out.println("this.ingredients[" + i + "] = " + this.ingredients[i]);
//                            System.out.println("another.ingredients[" + j + "] = " + another.ingredients[j]);
                            if(this.ingredients[i].equals(another.ingredients[j])){

                                cor += 1;
                            }
                        }
                    }
                    return cor == this.ingredients.length;
                }
            }
        }
        return false;
    }
}
