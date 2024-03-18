package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;

public class Recipe {
    public enum Size {SMALL, REGULAR, LARGE}

    ;
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
     *
     * @return True if all ingredients of the recipe have been added and false otherwise
     */
    public boolean isReady() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient == null)
                return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object other) {
        // checking if this object is equal to other objeect
        if (this == other) {
            return true;
        }

        if (!(other instanceof Recipe)) {
            return false;
        }

        Recipe recipe = (Recipe) other;

        if (recipe.getPrice() != this.price) {
            return false;
        }

        if (this.size != recipe.size) {
            return false;
        }

        // Get the two arrays of ingredients
        Ingredient[] ingredients1 = this.ingredients;
        Ingredient[] ingredients2 = recipe.ingredients;

        // Check if the two arrays have the same length
        if (ingredients1.length != ingredients2.length) {
            return false;
        }

        // Check if each ingredient in the first array is in the second array
        for (Ingredient ingredient1 : ingredients1) {
            boolean match = false;
            for (Ingredient ingredient2 : ingredients2) {
                if (ingredient1.equals(ingredient2)) {
                    match = true;
                    break;
                }
            }
            if (!match) {
                return false;
            }
        }

        // Check if each ingredient in the second array is in the first array
        for (Ingredient ingredient2 : ingredients2) {
            boolean match = false;
            for (Ingredient ingredient1 : ingredients1) {
                if (ingredient2.equals(ingredient1)) {
                    match = true;
                    break;
                }
            }
            if (match) {
                return false;
            }
        }

        // Check if all the ingredients have the same name, unit and amount
        for (int i = 0; i < ingredients1.length; i++) {
            Ingredient ingredient1 = ingredients1[i];
            Ingredient ingredient2 = ingredients2[i];

            if (!ingredient1.getName().equals(ingredient2.getName()) ||
                    ingredient1.getUnit() != ingredient2.getUnit() ||
                    ingredient1.getAmount() != ingredient2.getAmount()) {
                return false;
            }

            // check if they are both instances of milk and if they are the same type
            if (ingredient1 instanceof Milk && ingredient2 instanceof Milk) {
                Milk milk1 = (Milk) ingredient1;
                Milk milk2 = (Milk) ingredient2;
                if (milk1.getType() != milk2.getType()) {
                    return false;
                }
            }

            //check if they are both instances of syrup and if they are the same flavour
            if (ingredient1 instanceof Syrup && ingredient2 instanceof Syrup) {
                Syrup syrup1 = (Syrup) ingredient1;
                Syrup syrup2 = (Syrup) ingredient2;
                if (!syrup1.getFlavour().equals(syrup2.getFlavour())) {
                    return false;
                }
            }

            //check if they are both instances of coffee and if they are both decaf
            if (ingredient1 instanceof Coffee && ingredient2 instanceof Coffee){
                Coffee coffee1 = (Coffee) ingredient1;
                Coffee coffee2 = (Coffee) ingredient2;
                if (coffee1.getDecaf() != coffee2.getDecaf()){
                    return false;
                }
            }
            }
        return true;
        // If all ingredients match return true
        }
    }








