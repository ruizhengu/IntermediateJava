package uk.ac.sheffield.com1003.cafe;

import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

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

    public Size getSize(){
        return size;
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
            throw new TooManyIngredientsException(ingredients.length, name);
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
    /* Checks if two recipe are the same by comparing the size,price, and the ingredients contained.*/
    public boolean equals(Object anotherRecipe){
        ArrayList<Object> involvingIngredients = new ArrayList<Object>(); // creating an ArrayList to add the equal ingredients for later checking
        if (size == ((Recipe)anotherRecipe).getSize()
            && ((Recipe)anotherRecipe).isReady()
            && price == ((Recipe)anotherRecipe).price){
                for (Ingredient ingredient : ingredients){ //looping through every ingredient in both recipes to compare
                    for (Ingredient objects : ((Recipe)anotherRecipe).ingredients){
                        if (ingredient.equals(objects)){
                            involvingIngredients.add(objects); 
                            System.out.println(involvingIngredients);
                        } 
                    }
                }
                for (Ingredient ingredient : ingredients){ //looping through ingredient array to check if the ingredients contained are in the ArrayList which means they are equal
                    if (involvingIngredients.contains(ingredient)){
                    }
                    else 
                        return false;
                }
                return true;
        }
        else
            return false;
    }
}

