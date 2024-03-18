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



    public boolean equals(Object obj) {
        // Cast obj to a Recipe object
        Recipe other = (Recipe) obj;

        // Check if both recipes are ready to be served
        if (this.isReady()&& other.isReady()) {

            // Check if the recipe names are equal
            if (this.name.equals(other.getName())) {

                // Check if the price, size, and ingredients are equal
                if (this.price == other.getPrice() &&
                        this.size == other.size &&
                        Arrays.equals(this.ingredients, other.ingredients)) {

                    // Loop through each ingredient and compare their toString representation
                    for (int i = 0; i < this.ingredients.length; i++) {
                        if (!this.ingredients[i].toString().equals(other.ingredients[i].toString()) ){

                            // If the toString representations are not equal, return false
                            return false;
                        }
                    }

                    // If all conditions are met, return true
                    return true;
                }

            } else {
                // Check if the price, size, and ingredients are equal
                if (this.price == other.getPrice() &&
                        this.size == other.size &&
                        Arrays.equals(this.ingredients, other.ingredients)) {

                    // Loop through each ingredient and compare their toString representation
                    for (int i = 0; i < this.ingredients.length; i++) {
                        if (!this.ingredients[i].toString().equals(other.ingredients[i].toString()) ) {

                            // If the toString representations are not equal, return false
                            return false;
                        }
                    }

                    // If all conditions are met, return true
                    return true;
                }
            }
        }

        // If any condition is not met, return false
        return false;
    }


}










