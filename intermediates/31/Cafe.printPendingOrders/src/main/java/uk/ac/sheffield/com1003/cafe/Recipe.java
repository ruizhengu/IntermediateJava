package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

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
     * Checks whether one recipe is equal to another recipe (i.e price, size, ingredients), regardless of name. 
     * @param another The recipe to be compared to.
     * @return True if the recipes are the same and false otherwise
     */
    public boolean equals(Recipe another){
        boolean equal = false;
        //compares their price, size, amount of ingredients and if they are set.
        if(getPrice() == another.getPrice() && size == another.size && ingredients.length == another.ingredients.length && isReady() && another.isReady()){  
            Ingredient[] ingredients1 = ingredients; 
            Ingredient[] ingredients2 = another.ingredients;
            int sameIngredients = 0;
            //compare each ingredient in one recipe to every one in the other
            for(int i=0;i<ingredients1.length;i++){
                for(int x=0;x<ingredients2.length;x++){
                    if(ingredients1[i] instanceof Milk && ingredients2[x] instanceof Milk){
                        if(((Milk)ingredients1[i]).equals((Milk)ingredients2[x])){
                            sameIngredients++;
                        }
                    }else if(ingredients1[i] instanceof Water && ingredients2[x] instanceof Water){
                        if(((Water)ingredients1[i]).equals((Water)ingredients2[x])){
                            sameIngredients++;
                        }
                    }else if(ingredients1[i] instanceof Coffee && ingredients2[x] instanceof Coffee){
                        if(((Coffee)ingredients1[i]).equals((Coffee)ingredients2[x])){
                            sameIngredients++;
                        }
                    }else if(ingredients1[i] instanceof Syrup && ingredients2[x] instanceof Syrup){
                        if(((Syrup)ingredients1[i]).equals((Syrup)ingredients2[x])){
                            sameIngredients++;
                        }
                    }
                }
            }
            if(sameIngredients == ingredients1.length){
                equal = true;
            }
        }
        return equal;
    }
}
