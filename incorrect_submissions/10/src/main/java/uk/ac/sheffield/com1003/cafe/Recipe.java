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
        //Loops through the ingredients and adds the ingredient to the recipe if it finds an empty element or one of the
        //same name
        int i = 0;
        while (i < ingredients.length) {
            if (ingredients[i] == null || ingredients[i].equals(ingredient)) {
                ingredients[i] = ingredient;
                return;
            } else
                i++;
        }
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

    public boolean equals(Recipe recipe1, Recipe recipe2) {
        //Sets two tests to false and one to true
        boolean test1 = false;
        boolean test2 = false;
        boolean test3 = true;
        //Checks if the size of the two recipes are the same and if so sets test 1 to true.
        if (recipe1.size == recipe2.size) {
            test1 = true;
        }
        //Then checks if the ingredients match and then sets the test to true if this is the case.
        if (recipe1.ingredients.length == recipe2.ingredients.length) {
            int numberMatching = 0;
            for (int i = 0; i < recipe1.ingredients.length; i++) {
                for (int j = 0; j < recipe2.ingredients.length; j++) {
                    if (recipe1.ingredients[i].equals(recipe2.ingredients[j])) {
                        numberMatching += 1;
                    }
                }
            }
            if (numberMatching == recipe1.ingredients.length) {
                test2 = true;
            }
        }
        //Checks if all the ingredients are set in the array and if they aren't it changes the test to false.
        for (int i = 0; i < recipe1.ingredients.length; i++) {
            if (recipe1.ingredients[i] == null) {
                test3 = false;
            }
        }
        for (int i = 0; i < recipe2.ingredients.length; i++) {
            if (recipe2.ingredients[i] == null) {
                test3 = false;
            }
        }
        //Then if all the tests are true then they are equal and if they aren't it is false.
        if (test3 && test2 && test1) {
            return true;
        } else {
            return false;
        }

    }
}
