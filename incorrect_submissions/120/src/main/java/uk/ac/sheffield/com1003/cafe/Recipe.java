package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    public enum Size {
        SMALL, REGULAR, LARGE
    };

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
     * @throws TooManyIngredientsException if the number of ingredients in the
     *                                     recipe would be exceeded
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
     * @return True if all ingredients of the recipe have been added and false
     *         otherwise
     */
    public boolean isReady() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient == null)
                return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o2) {
        // Check the size, price, number of ingredients in each and if both recipes are
        // fully initialised

        Recipe recipe2 = (Recipe) o2;
        if (this.size != recipe2.size || this.price != recipe2.getPrice()
                || ingredients.length != recipe2.ingredients.length || !this.isReady() || !recipe2.isReady()) {
            return false;
        }
        // Go through each ingredients and check values are the same
        for (Ingredient i : ingredients) {
            boolean ingredientFound = false;
            for (Ingredient i2 : recipe2.ingredients) {
                // Check the name, units, amount, etc
                if (i.equals(i2)) {
                    ingredientFound = true;
                    break;
                }
            }
            // We must be able to match all ingredients
            if (!ingredientFound)
                return false;
        }
        // for loop has finished, hence all ingredients were found
        return true;
    }
}
