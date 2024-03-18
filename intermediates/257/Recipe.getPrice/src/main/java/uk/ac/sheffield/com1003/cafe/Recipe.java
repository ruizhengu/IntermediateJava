package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

public class Recipe {
    public enum Size { SMALL, REGULAR, LARGE };
    private String name;
    private double price;
    private Size size;
    private Ingredient[] ingredients;

    /**
     * Constructor that takes in name and price of recipe
     * initialises default size as regular and number of ingredients as 3
     * @param name name of the recipe
     * @param price price of the recipe
     */
    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
    }

    /**
     * Constructor that takes in name, size, price and number of ingredients as parameters
     * Initialises the name, price size and ingredients to its parameters
     * @param name name of the recipe
     * @param price price of the recipe
     * @param size size of the recipe
     * @param numberOfIngredients number of ingredients in the recipe
     */
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

    /**
     * Getter for recipe name
     * @return Recipe name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for Recipe price
     * @return Recipe price
     */
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
     * toString method to print out the name and price of the recipe
     * @return A String that is the name and price of recipe
     */
    public String toString() {
        return getName() + " - " + getPrice();
    }

    /**
     * equals() method to compare the object and the other object passed into the parameter of this method
     * Compares to see if size, price, number of ingredients and instance variables of the ingredients are the same
     * @param o The object to be compared
     * @return True if all the conditions are met and all the ingredients in the array are the same,or false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Recipe))
            return false;
        Recipe recipe = (Recipe) o;
        if ((recipe.price != price) || (size != recipe.size))
            return false;

        if (! isReady() || !recipe.isReady())
            return false;

        if (ingredients.length != recipe.ingredients.length)
            return false;

        for (int i=0; i<ingredients.length; i++) {
            boolean found = false;
            for (int j=0; j<ingredients.length; j++) {
                if (ingredients[i].equals(recipe.ingredients[j])) {
                    found = true;
                    break;
                }
            }
            if (! found)
                return false;
        }
        return true;
    }
}
