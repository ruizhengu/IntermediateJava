package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    public enum Size {
        SMALL, REGULAR, LARGE
    };

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
     * 
     * @param ingredient Ingredient to be added to recipe.
     * @throws TooManyIngredientsException if the number of ingredients in the
     *                                     recipe would be exceeded
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
     * 
     * @return True if all ingredients of the recipe have been added and false
     *         otherwise
     */
    public boolean isReady() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient == null)
                return false;
        }
        return true;
    }

    public boolean equals(Object thing) {
        // return false if object passed is not a recipe
        if (thing == null || !(thing instanceof Recipe))
            return false;
        else {
            // confirmed thing to be a recipe, cast it into Recipe class
            Recipe other_recipe = (Recipe) thing;

            // return false if either of size, price and ingredient count is different
            if (size != other_recipe.size || price != other_recipe.price
                    || ingredients.length != other_recipe.ingredients.length)
                return false;
            else {
                // iterate through every ingredient and find corresponding ingredient in the
                // other recipe
                for (Ingredient i : ingredients) {
                    boolean has_equal_entry = false;
                    for (Ingredient j : other_recipe.ingredients) {
                        // iterate through the ingredients of the other recipe and find identical
                        // ingredient then break the finding loop if it finds one
                        if (i.equals(j)) {
                            has_equal_entry = true;
                            break;
                        }
                    }

                    // if a single ingredient doesn't match return false, else continue to other
                    // ingredient
                    if (has_equal_entry == false)
                        return false;
                }

                // if this code is reached that means all ingredients are identical
                return true;
            }
        }
    }

    public String toString() {
        String string = "Size: " + String.valueOf(size) + "\nName: " + name + "\nPrice: " + String.valueOf(price)
                + "\nIngredients: ";
        string += ingredients[0];
        if (ingredients.length > 1) {
            for (int i = 1; i < ingredients.length; i++) {
                string += ", " + ingredients[i];
            }
        }
        return string;
    }
}