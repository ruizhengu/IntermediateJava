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

    public static void equals(Recipe one, Recipe two){

        boolean i = false;

        String oneI = null;
        String twoI = null;
        double oneCost = one.getPrice();
        double twoCost = two.getPrice();
        String oneSize = one.size.name();
        String twoSize = two.size.name();

        boolean oneNotNull = true;
        boolean twoNotNull = true;

        for (Ingredient a : one.ingredients){
            if (a==null){
                oneNotNull = false;
            }
        }

        if (oneNotNull) {
            oneI = one.ingredients[0].toString();
        }

        for (Ingredient b : two.ingredients){
            if (b==null) {
                twoNotNull = false;
            }
        }

        if (twoNotNull) {
            twoI = two.ingredients[0].toString();
        }

        if (oneCost == twoCost && oneSize == twoSize && oneI != null && twoI!= null && oneI.equals(twoI)){
            i = true;
        }

        if (i) {
            System.out.println("They're the same recipe.");
        } else {
            System.out .println("They're are not the same recipe.");
        }
    }
}
