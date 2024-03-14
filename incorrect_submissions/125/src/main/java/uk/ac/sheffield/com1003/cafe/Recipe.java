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

    @Override
    public boolean equals(Object other) {
        if (other != null && other instanceof Recipe) {
            Recipe otherRecipe = (Recipe) other;
            if (otherRecipe.size.equals(size) && otherRecipe.price == price) {
                if (otherRecipe.ingredients.length == ingredients.length) {

                    /*
                     * Here we compare each of our own ingredients with every ingredient
                     * in the other recipe, if one pass concludes without an equivalent ingredient, then they
                     * are not the same recipe.
                     */
                    for (int i1 = 0; i1 < ingredients.length; i1++) {
                        Ingredient ing1 = ingredients[i1];
                        boolean matched = false;

                        for (int i2 = 0; i2 < otherRecipe.ingredients.length; i2++) {
                            if (ing1.equals(otherRecipe.ingredients[i2])) {
                                matched = true;
                                break;
                            }
                        }

                        if (!matched) {
                            return false;
                        }
                    }

                    return true;
                }
            }
        }
        return false;
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
}
