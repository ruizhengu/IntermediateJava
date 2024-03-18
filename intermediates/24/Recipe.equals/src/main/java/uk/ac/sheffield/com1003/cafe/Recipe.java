package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

/**
 * Class to represent a recipe for a drink
 * @author github-classroom
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
     * @param obj Object to be compared with this recipe
     * @return true if obj is a Recipe and has the price,
     *         size and ingredients(including name ,units and amounts) as this recipe
     *         else
     *         return false
     */
    @Override
    public boolean equals(Object obj) {
        // Check if obj is a reference to this object
        if (obj == this) {
            return true;
        }

        // Check if obj is null
        if (obj == null) {
            return false;
        }

        // Check if obj is an instance of Recipe
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        // Cast obj to Recipe
        Recipe recipe = (Recipe) obj;

        // Check if prices and sizes are equal
        if (this.price != recipe.price || this.size != recipe.size) {
            return false;
        }

        // Check if both recipes are ready
        if (!this.isReady() || !recipe.isReady()) {
            return false;
        }

        // Check if the number of ingredients is equal
        if (this.ingredients.length != recipe.ingredients.length) {
            return false;
        }

        // Create an array to track which ingredients match
        boolean[] successMatched = new boolean[recipe.ingredients.length];

        // Initialize the array to false
        for (int i = 0; i < successMatched.length; i++) {
            successMatched[i] = false;
        }

        // Check each ingredient in the recipe against this recipe's ingredients
        for (int i = 0; i < recipe.ingredients.length; i++) {
            for (int j = 0; j < this.ingredients.length; j++) {
                if (recipe.ingredients[i].equals(this.ingredients[j])) {
                    // Mark this ingredient as matched
                    successMatched[i] = true;
                }
            }
        }

        // Check if all ingredients matched
        boolean allMatched = true;
        for (int i = 0; i < recipe.ingredients.length; i++) {
            if (!successMatched[i]) {
                allMatched = false;
            }
        }

        return allMatched;
    }

}
