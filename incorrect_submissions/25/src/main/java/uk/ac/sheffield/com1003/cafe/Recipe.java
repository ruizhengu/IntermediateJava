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
            if (this.ingredients[i] == null) {
                this.ingredients[i] = ingredient;
                return;
            } else if (this.ingredients[i].getName() == ingredient.getName()) {
                this.ingredients[i] = ingredient;
                return;
            } else {
                i++;
            }
        }
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

    public boolean equals(Recipe compared_to_recipe){
        //Compare sizes first
        if (this.size == compared_to_recipe.size){
            //Then prices
            if (this.price == compared_to_recipe.price){
                //Fianlly a nested for loop to check every ingredient of recipe A to every ingredient of recipe B to ensure they are matching
                for (Ingredient first_ingredient : this.ingredients) {
                    boolean found = false;
                    for (Ingredient ingredient : compared_to_recipe.ingredients) {
                        if (first_ingredient.equals(ingredient)){
                            found = true;
                        }
                    }
                    //After each ingredient from A is checked. We need to ensure a similar ingredient was found, if not they arnt matching
                    if (!found){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
