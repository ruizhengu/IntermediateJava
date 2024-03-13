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
    public Ingredient[] getIngredients() {
        return ingredients;
    }

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

    public boolean equals(Recipe recipe) {
        //initialises a counter to make sure every ingredient has been checked
        int counter = 0;
        //checks to see if there is array elements to check
        if (recipe.getIngredients()[0] == null && ingredients[0] == null) {
            return true;
        }
        if (recipe.getIngredients()[0] == null || ingredients[0] == null) {
            return false;
        }
        //loops through the ingredients of each recipe to check them
        for (int i = 0; i < recipe.getIngredients().length; i++) {
            for (int x = 0; i < ingredients.length; i++) {
                //checks to see if the ingredient is the same type
                if (ingredients[x].getName() == recipe.getIngredients()[i].getName()) {
                    //checks to see if the ingredient has the same values
                    if (ingredients[x].equals(recipe.getIngredients()[i])) {
                        counter++;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        //returns false if there are unmatched ingredients
        if (counter < ingredients.length-1) {
            return false;
        }
        else {
            return true;
        }
    }
}
