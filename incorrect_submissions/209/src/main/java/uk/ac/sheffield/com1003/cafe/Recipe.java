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
     * Checks whether two recipes are equal based on a number of criterion
     * If the sizes are the same
     * If all ingredients are set
     * If the prices are the same
     * If the ingredients are the same (name, unit, amount)
     * @param another
     * @return True if the two recipes are equal (even if their names are not the same) and false otherwise
     */
    public boolean equals(Recipe another) {
        if ((another.size == size) && (ingredients.length > 0) && (another.price == price)) {
            for (int i = 0; i < ingredients.length; i++) {
                System.out.println(ingredients[i]);
                System.out.println(another.ingredients[i]);
                if ((ingredients[i] != null) && (another.ingredients[i] != null) &&
                        (ingredients[i].getName() == another.ingredients[i].getName()) &&
                        (ingredients[i].getUnit() == another.ingredients[i].getUnit()) &&
                        (ingredients[i].getAmount() == another.ingredients[i].getAmount()) &&
                        (another.isReady() == true)) {
                    return true;
                }
            }
        }
        return false;
    }
}
