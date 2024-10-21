package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

import java.util.Arrays;

public class Recipe {

    public enum Size { SMALL, REGULAR, LARGE };
    private String name;
    private double price;
    private Size size;
    private Ingredient[] ingredients;

    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
    }

    public Recipe(String name, double price, Size size, Ingredient[] ingredients) {
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

    public void equals(Recipe theSecond) {
        int i=0;
        if(this.price==theSecond.price){
            if(this.size==theSecond.size){
                if (Arrays.equals(this.ingredients, theSecond.ingredients)){
                    System.out.println("They are same.");
                }else {
                    System.out.println("The ingredients are different.");
                }
            }else {
                if (Arrays.equals(this.ingredients, theSecond.ingredients)){
                    System.out.println("The sizes are different");
                }else{
                    System.out.println("The sizes and ingredients are different.");
                }
            }
        }else{
            if(this.size==theSecond.size){
                if (Arrays.equals(this.ingredients, theSecond.ingredients)){
                    System.out.println("The price are different.");
                }else {
                    System.out.println("The price and ingredients are different.");
                }
            }else {
                if(Arrays.equals(this.ingredients, theSecond.ingredients)){
                    System.out.println("The price and size are different.");
                }else {
                    System.out.println("They are all different.");
                }
            }
        }
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
}
