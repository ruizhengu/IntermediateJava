package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;

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

    public boolean equals(Recipe otherRecipe) {
        // initialises counter/flag
        int sameIngredientsCounter = 0;
        // checks length
        if (this.ingredients.length != otherRecipe.ingredients.length)
            return false;
        // checks size and price
        if (this.size == otherRecipe.size && this.getPrice() == otherRecipe.getPrice()){
            // checks each ingredient independent of order
            for (int i = 0; i < this.ingredients.length; i++){
                for (int j = 0; j < this.ingredients.length; j++){
                    if (this.ingredients[i].equals(otherRecipe.ingredients[j])){
                        if (this.ingredients[i].getAmount() == otherRecipe.ingredients[j].getAmount() &&
                                this.ingredients[i].getUnit() == otherRecipe.ingredients[j].getUnit()) {
                            if (this.ingredients[i].getName().equals("Syrup")) {
                                // casts to syrup type to compare
                                Syrup thisSyrup = (Syrup)this.ingredients[i];
                                Syrup otherSyrup = (Syrup)otherRecipe.ingredients[j];
                                if (thisSyrup.getFlavour() == otherSyrup.getFlavour())
                                    sameIngredientsCounter++;
                            }
                            else if (this.ingredients[i].getName().equals("Milk")) {
                                // casts to milk type to compare
                                Milk thisMilk = (Milk)this.ingredients[i];
                                Milk otherMilk = (Milk)otherRecipe.ingredients[j];
                                if (thisMilk.getType() == otherMilk.getType())
                                    sameIngredientsCounter++; // must be same ingredient
                            }
                            else if (this.ingredients[i].getName().equals("Coffee")) {
                                // casts to coffee type to compare
                                Coffee thisCoffee = (Coffee)this.ingredients[i];
                                Coffee otherCoffee = (Coffee)otherRecipe.ingredients[j];
                                if (thisCoffee.getDecaf() == otherCoffee.getDecaf())
                                    sameIngredientsCounter++;
                            }
                            else
                                sameIngredientsCounter++; // must be same
                        }
                    }
                }
            }
            if (sameIngredientsCounter == this.ingredients.length) // if all ingredients the same...
                return true;
        }
        return false;
    }
}
