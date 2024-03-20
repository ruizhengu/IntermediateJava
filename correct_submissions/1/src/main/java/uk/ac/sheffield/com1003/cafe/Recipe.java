package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;
import java.util.Objects;

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

    public boolean equals(Object objectTwo) {
        if (objectTwo == this)
            return true;
        // check if its a Recipe - if it is cast it to Recipe and carry out checks
        if (objectTwo == null || this.getClass() != objectTwo.getClass())
            return false;
        Recipe recipeTwo = (Recipe) objectTwo;
        if (!this.isReady() || !recipeTwo.isReady() ||
                ingredients.length != recipeTwo.ingredients.length) {
            return false;
        }
        // counts how many equal ingredients there are in each array
        int count = 0;
        for (Ingredient ingredientOne : ingredients) {
            for (Ingredient ingredientTwo : recipeTwo.ingredients) {
                if (ingredientOne.equals(ingredientTwo))
                    count++;
            }
        }
        // if the count == length it means for each ingredient there was a match in the other array 
        if (count == ingredients.length && size == recipeTwo.size && price == recipeTwo.price)
            return true;

        return false;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, price, size);
        result = 31 * result + Arrays.hashCode(ingredients);
        return result;
    }
}
