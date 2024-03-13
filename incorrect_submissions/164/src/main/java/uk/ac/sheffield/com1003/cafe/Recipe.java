package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

/**
 * This class is used to instantiate Recipe objects.
 * Each recipe has a name, price, size and an array of ingredients.
 * Ingredients can be added to the ingredients array
 */
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

    // This new getter is needed so that the equals method can access the size of another object
    public Size getSize() {
        return size;
    }

    /**
     * A method to compare whether another object is equal to this recipe object
     * @param another the other object to be compared
     * @return a clear display of the relevant instance variables for this Syrup object
     */
    public boolean equals(Object another) {

        if (this == another)
            return true;

        if (! (another instanceof Recipe) )
            return false;

        Recipe otherRecipe = (Recipe)another;

        /* Check equality of length, price and size of the two recipes, and whether they are both ready
         * if any of these aren't true the recipes are not equal
         */

        if (otherRecipe != null &&
                this.ingredients.length == otherRecipe.ingredients.length &&
                (this.isReady() && otherRecipe.isReady()) &&
                this.price == otherRecipe.getPrice() &&
                this.size == otherRecipe.getSize()) {

            /* For every ingredient in the first recipe check each ingredient in the next recipe to see
             * if a match can be found, if it can't for any of them then we know the two recipes aren't
             * equal.
             */
            boolean match = true;
            int i = 0;
            while (i < ingredients.length && match) {
                match = false;
                for (int j = 0; j < otherRecipe.ingredients.length; j++) {
                    // Make use of the overridden equals method within each of the ingredients
                    if (otherRecipe.ingredients[j] != null &&
                            ingredients[i].equals(otherRecipe.ingredients[j])) {
                        match = true;
                    }
                }
                i++;
            }
            return match;
        }
        return false;

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
}
