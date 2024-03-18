package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    public enum Size {SMALL, REGULAR, LARGE};
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

    /**
     * Compares whether recipe is the same a given one.
     *
     * @return True if all ingredients of the recipe are the same as the on in the parameter
     * this includes size, price, amount, and unit.
     */
    @Override
    public boolean equals(Object object) {
        //check the class, size, price, and num of ingredients are the same
        if (object == null || !(object instanceof Recipe))
            return false;
        Recipe casting = (Recipe) object;
        if (casting.getPrice() != this.getPrice())
            return false;
        if (casting.getClass() != this.getClass())
            return false;
        if (casting.ingredients.length != this.ingredients.length)
            return false;
        if (casting.size != this.size)
            return false;

        //iterates over the ingredients of the recipe to check if amount and unit is the same
        //set a counter to compare if the all the ingredients are the same
        int ingCheck = 0;
        for (int i=0; i < this.ingredients.length; i++) {
            for (int j=0; j < casting.ingredients.length; j++) {
                if (this.ingredients[i].equals(casting.ingredients[j])) {
                    if (this.ingredients[i].getAmount() != casting.ingredients[j].getAmount()) {
                        return false;
                    }
                    if (this.ingredients[i].getUnit() != casting.ingredients[j].getUnit()) {
                        return false;
                    }
                    ingCheck++;
                }
            }
        }

        //check if the num of ingredients that are the same is the same as length
        if (ingCheck != this.ingredients.length) {
            return false;
        }
        return true;
    }
}
