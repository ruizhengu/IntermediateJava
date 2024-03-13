package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

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
     * Equals
     * Checks if two recipes are the same despite having different names
     * @param recipe that compares the two recipes
     * @return True if all the requirements of each subclass and if all the array elements are
     *          matched and false otherwise
     */

    public boolean equals(Object recipe) {
        if (isReady()) {
            //Compares the recipe passed into parameter to the original recipe
            if (recipe == this) {
                return true;
            }

            if (!(recipe instanceof Recipe)) {
                return false;
            }

            //Checks for size, price and length of array after casting the recipe object

            Recipe r = (Recipe) recipe;
            if (r.size == this.size && r.price == this.price && r.ingredients.length == this.ingredients.length) {
                //iterates through two loops and if an element of the first array does not match, the
                // loop is broken out of
                for (Ingredient ingredient1 : this.ingredients) {
                    boolean match = false;
                    for (Ingredient ingredient2 : r.ingredients) {
                        if (ingredient1.equals(ingredient2) ){
                            match = true;
                        }
                    }
                    if ( match == false ) {
                        return false;
                    }
                }
                return true;

            }
        }
        return false;
    }

    public String toString() {
        return getName() + " - " + getPrice();
    }
}
