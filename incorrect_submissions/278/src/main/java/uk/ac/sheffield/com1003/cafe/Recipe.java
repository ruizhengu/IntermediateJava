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

    public boolean equals(Recipe a, Recipe b){
        int score = 0;
        if(!a.size.equals(b.size)){ //if size is not equal exits
            return false;
        }
        else if((a.getPrice()) != (b.getPrice())){//same price
            return false;
        }
        else if(a.ingredients.length != b.ingredients.length){//same amount of ingredients
            return false;
        }
        for(int i = 0; i < a.ingredients.length; i++){ //iterates through ingredients
            if(a.ingredients[i].getName() != b.ingredients[i].getName()){ //same ingredient
                return false;
            }
            else if(a.ingredients[i].getUnit() != b.ingredients[i].getUnit()){ //same unit of ingredient
                return false;
            }
            else if(a.ingredients[i].getAmount() != b.ingredients[i].getAmount()){ //same amount of ingredients
                return false;
            }
        }
        return true;
    }

}
