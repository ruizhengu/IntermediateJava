package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;


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

    public boolean Equals(Recipe otherRecipe) {
        // checking if the current recipe is the same as the otherRecipe
        if (this == otherRecipe)
            return true;
//checking whether the name,size the price of the recipe are equal as the otherRecipe.
        if (this.getName().equals(otherRecipe.getName())) if (this.getPrice() == otherRecipe.getPrice()) {
            if (this.size == otherRecipe.size) {
                // Checking of the length of the array ingredients and comparing it with the length of the otherRecipe
                if (this.ingredients.length != otherRecipe.ingredients.length) {
                } else {
                    //if it is equal then it iterates through the array ingredients and checks if they are equal
                    for (int i = 0; i < this.ingredients.length; i++) {
                        if (!this.ingredients[i].equals(otherRecipe.ingredients[i])) {
                            return false;
                        }
                        //Checks if the current element in the ingredients array is an instance of Milk with the otherRecipe
                        if (this.ingredients[i] instanceof Milk && otherRecipe.ingredients[i] instanceof Milk) {
                            //Then checks with getType() if the types of milk are equal()
                            System.out.println(((Milk) this.ingredients[i]).getType() + " and " + ((Milk) otherRecipe.ingredients[i]).getType());
                            if (!((Milk)this.ingredients[i]).getType().equals(((Milk)otherRecipe.ingredients[i]).getType())) {
                            }
                        }

                        return true;
                    }
                }

            }
            return false;
        }
        return false;

    }
}













