package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

/**
 * A class representing a recipe, which contains a name, a price, a size, and a
 * list of ingredients.
 */
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

    /**
     * Checks whether two recipes are equal based on their ingredients and price
     *
     * This method checks whether two recipe objects are equal by comparing 
     * their size,units and amounts of their ingredients, what type of milk
     *  it contains (if any),and the prices of the recipes.
     *
     * Equality of the recipes is not dependent on their names
     *
     * @param recipe recipe Object to be compared to the current recipe Object
     * @return true if recipes are the equal, false otherwise
     */

    public boolean equals(Recipe recipe) {

        if (
             this.size != recipe.size ||
             this.ingredients.length != recipe.ingredients.length
           ) {

            return false;
        }
        for (int i = 0; i < this.ingredients.length; i++) {

            // checking if the ingredients are set
            if (recipe.ingredients[i] == null) {
                return false;
            } 
            else {

                // checking if the ingredient have the same characteristics
                if ( !(
                        (this.ingredients[i].getName()
                            .equals(recipe.ingredients[i].getName())
                        ) &&

                        (this.ingredients[i].getUnit()
                            == recipe.ingredients[i] .getUnit()
                        )&&
                        
                        (this.ingredients[i].getAmount() 
                            == recipe.ingredients[i].getAmount()
                        )
                     )
                   ) {
                    return false;
                }

                // checking what type of milk it is
                if (
                     this.ingredients[i] instanceof Milk &&
                    recipe.ingredients[i] instanceof Milk
                   ) {

                    if (!(
                          ((Milk) this.ingredients[i]).getType() == 
                          ((Milk) recipe.ingredients[i]).getType()
                         )
                       ) {
                        return false;
                    }
                }
            }
        }
        return this.getPrice() == recipe.getPrice();
    }
}
