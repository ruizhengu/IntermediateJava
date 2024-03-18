package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

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

    public boolean equals(Object comparing) {
       //creating a boolean to be able to compare two recipes to find whether they have the same ingredients
        if (!(comparing instanceof Recipe) || comparing == null)
            return false;


        Recipe check = (Recipe) comparing;
        //if statements to check whether the length are not the same to return false as
        // if all the checks are false it will return true
        if ((this.ingredients.length != check.ingredients.length) && (this.getClass() != check.getClass())) {
            return false;
        }
        if ((this.size != check.size) && (this.getPrice() != check.getPrice())) {
            return false;
        }
            int checking = 0;
            for (int j = 0; this.ingredients.length > j; j++) {
                for (int i = 0; this.ingredients.length > i; i++) {
                    if (this.ingredients[j].getClass() == check.ingredients[i].getClass()) {
                        if (this.ingredients[j].getAmount() != check.ingredients[i].getAmount()) {
                            return false;
                        }
                        if (this.ingredients[j].getUnit() != check.ingredients[i].getUnit()) {
                            return false;
                        }
                        if (!this.ingredients[j].equals(check.ingredients[i])) {
                            return false;
                        }
                        checking++;
                    }
                }
            }
            if (checking != this.ingredients.length){
                return false;
            }

        return true;
    }
    }

