package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

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
     * Compares this recipe to the specified object for equality. Two recipes are considered equal
     * if they are the same size, contain the same ingredients (including units and amounts), and cost
     * the same, even if their names are different.
     * @param obj the object to compare this recipe against
     * @return true if the specified object is equal to this recipe, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) // if the objects are the same, they are equal
            return true;
        if (obj == null) // if the object being compared is null, they are not equal
            return false;
        if (getClass() != obj.getClass()) // if the objects are not of the same class, they are not equal
            return false;
        Recipe other = (Recipe) obj; // cast the object as a Recipe object
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) // compare the prices using doubleToLongBits to handle NaN values
            return false;
        if (size != other.size) // compare the sizes of the recipes
            return false;
        if (ingredients.length != other.ingredients.length) // check if the ingredients arrays are of the same length
            return false;
        for (int i = 0; i < ingredients.length; i++) { // loop through the ingredients arrays
            if (!ingredients[i].equals(other.ingredients[i])) { // compare each ingredient using the equals() method
                return false; // if any ingredient is not equal, the recipes are not equal
            }
        }
        return true; // if all comparisons pass, the recipes are equal
    }
}
