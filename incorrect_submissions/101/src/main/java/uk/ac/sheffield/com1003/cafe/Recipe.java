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

    int i = 0;




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
        while (i < ingredients.length) {
            if (ingredients[i] == null || ingredients[i].equals(ingredient)) {
                ingredients[i] = ingredient;
                i++;
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

    public boolean equals(Recipe recipe) {
        if (recipe.size != size) {
            return false;
        }

        if (!recipe.isReady() || !isReady()) {
            return false;
        } else {
            boolean isEqual = true;
            if (recipe.ingredients.length != ingredients.length) {
                isEqual = false;
                return false;
            } else {
                for (int i = 0; i < recipe.ingredients.length; i++) {
                    boolean found = false;
                    for (int j = 0; j < ingredients.length; j++) {
                        if (recipe.ingredients[i].equals(recipe.ingredients[j])) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        isEqual = false;
                        break;
                    }
                }
                if (!isEqual){
                    return false;
                }
            }

        }
        if (price != recipe.getPrice()){
            return false;
        }
        return true;
    }
}
