package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;
import java.util.Objects;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

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
     * @throws TooManyIngredientsException if the number of ingredients in the recipe would be exceeded.
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
     * @return True if all ingredients of the recipe have been added and false otherwise.
     */
    public boolean isReady() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient == null)
                return false;
        }
        return true;
    }

    /**
     * Check if two recipes are the same by checking if sizes, prices, ingredients, and instance methods are the same
     * Also check if all the ingredients are set.
     * If both recipes are the same then return true, else false.
     * @param otherRecipe A reference to the other recipe we want to compare to.
     */
    public boolean equals(Recipe otherRecipe) {
        // Check if sizes and prices are equal
        if (this.size == otherRecipe.size
                && this.getPrice() == otherRecipe.getPrice()
                && this.ingredients.length == otherRecipe.ingredients.length
        ) {
            // Check to see if the recipes are literally equal (same reference), if not then check if ingredients are set
            if (this != otherRecipe) {
                // Loop over each ingredient and see if its set, if not then return false
                for (int ingredientIndex = 0; ingredientIndex < this.ingredients.length; ingredientIndex++) {
                    if (this.ingredients[ingredientIndex] == null || otherRecipe.ingredients[ingredientIndex] == null)
                        return false;
                }
            }

            // Check if the ingredients are the same, if not then return false
            for (Ingredient thisIngredient : this.ingredients) {
                boolean found_match = false;
                for (Ingredient otherIngredient : otherRecipe.ingredients) {
                    if (thisIngredient.getName().equals(otherIngredient.getName())) {
                        if (thisIngredient.getUnit() == otherIngredient.getUnit()) {
                            if (thisIngredient.getAmount() == otherIngredient.getAmount()) {
                                found_match = true;
                            }
                        }
                    }
                }

                // Return false if no match was found for thisIngredient
                if (!found_match)
                    return false;
            }

            // Check specific instance variables for Milk.type and Coffee.decaf
            for (Ingredient thisIngredient : this.ingredients) {
                for (Ingredient otherIngredient : otherRecipe.ingredients) {
                    // Check if Milk.type is the same
                    if (thisIngredient instanceof Milk && otherIngredient instanceof Milk) {
                        if (((Milk) thisIngredient).getType() != ((Milk) otherIngredient).getType()) {
                            return false;
                        }
                    }

                    // Check if Coffee.decaf is the same
                    if (thisIngredient instanceof Coffee && otherIngredient instanceof Coffee) {
                        if (((Coffee) thisIngredient).getDecaf() != ((Coffee) otherIngredient).getDecaf())
                            return false;
                    }
                }
            }

            // Return true as all cases above passed
            return true;
        } else {
            return false;
        }
    }
}
