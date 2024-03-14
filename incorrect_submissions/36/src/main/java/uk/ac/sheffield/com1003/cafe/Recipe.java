package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
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

    // Task 5
    public boolean equals(Object o){

        if (o == this){
            return true;
        }

        if (!(o instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) o;
        if (!this.size.equals(other.size)){
            return false;
        }

        // Use loop because cannot assume ingredients will be in the same order
        // if recipes have different number of ingredients, can exit loop early
        for (int i =0; i < this.ingredients.length; i++){
            Ingredient thisIngredient = this.ingredients[i];
            Ingredient otherIngredient = other.ingredients[i];

            if (!thisIngredient.getName().equals(otherIngredient.getName())) {
                return false;
            }
            if (!thisIngredient.getUnit().equals(otherIngredient.getUnit())) {
                return false;
            }
            if (thisIngredient.getAmount() != otherIngredient.getAmount()) {
                return false;
            }

            // Check for Water ingredient
            if (thisIngredient instanceof Water && otherIngredient instanceof Water){
                Water thisWater = (Water) thisIngredient;
                Water otherWater = (Water) otherIngredient;
                if (!thisWater.equals(otherWater)) {
                    return false;
                }
            }

            // Check for Coffee ingredient
            if (thisIngredient instanceof Coffee && otherIngredient instanceof Coffee){
                Coffee thisCoffee = (Coffee) thisIngredient;
                Coffee otherCoffee = (Coffee) otherIngredient;
                if (!thisCoffee.equals(otherCoffee)) {
                    return false;
                }
                if (thisCoffee.isDecaf() != otherCoffee.isDecaf()) {
                    return false;
                }

            }

            // Check for Milk ingredient
            if (thisIngredient instanceof Milk && otherIngredient instanceof Milk){
                Milk thisMilk = (Milk) thisIngredient;
                Milk otherMilk = (Milk) thisIngredient;
                if (!thisMilk.equals(otherMilk)) {
                    return false;
                }
                if (!thisMilk.getType().equals(otherMilk.getType())) {
                    return false;
                }
            }

            // Check for Syrup ingredient
            if (thisIngredient instanceof Syrup && otherIngredient instanceof Syrup) {
                Syrup thisSyrup = (Syrup) thisIngredient;
                Syrup otherSyrup = (Syrup) otherIngredient;
                if (!thisSyrup.equals(otherSyrup)) {
                    return false;
                }
                if (!thisSyrup.getFlavour().equals(otherSyrup.getFlavour())) {
                    return false;
                }
            }

        }

        // Check if the cost same
        if (this.price != other.price) {
            return false;
        }


        return true;

    }
}
