package uk.ac.sheffield.com1003.cafe;

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
            throw new TooManyIngredientsException("The amount of ingredients exceeds that of the pre-defined recipe!");
    }

    /**
     * Compares two Recipe objects to see if they're equal.
     * First checks the ingredients array in both Recipe objects to see if they are filled using the
     * {@link Recipe#isReady()} method, then checks if length of both ingredient arrays are the same; else return false.
     * Then, iterates through both ingredients arrays to check if the name, amount, unit and special
     * property of each ingredient matches up.
     *
     * @param another The other Recipe object that you would like to stage the comparison against
     * @return Returns true if the recipes' size, ingredients and prices are a complete match; return false otherwise
     */
    public boolean equals(Recipe another) {
        if (!this.isReady() || !another.isReady() || this.ingredients.length != another.ingredients.length) {
            return false;
        }

        // Implement a counter and increment by 1 per matching ingredient
        int sameIngredients = 0;
        for (Ingredient ingredient : this.ingredients) {
            for (Ingredient anotherIngredient : another.ingredients) {
                if(ingredient.equals(anotherIngredient)) {
                    sameIngredients++;
                }
            }
        }

        // Return true if number of matching ingredients is the same as the number of ingredients on either recipe,
        // as well as having the same size and price, otherwise return false if any of these conditions aren't met.
        return this.size.equals(another.size) && sameIngredients == this.ingredients.length
                && this.getPrice() == another.getPrice();
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
