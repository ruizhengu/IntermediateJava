package uk.ac.sheffield.com1003.cafe;

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
            if (ingredients[i] == null || ingredients[i].getName().equals(ingredient.getName())) {
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
     * Checks if this recipe has the same ingredients another recipe
     * @param recipe2 the recipe to be compared
     * @return True if the ingredients of the two recipes' ingredients are equal and false otherwise
     */
    public boolean equals(Recipe recipe2) {
        // Return true if same price, ingredients (units + amounts) and size
        // Names can differ

        if (!(this.getPrice() == recipe2.getPrice())) {
            return false;
        }

        if (!this.size.equals(recipe2.size)) {
            return false;
        }

        if (this.ingredients.length != recipe2.ingredients.length) {
            return false;
        }

//        If one of the recipes is ready and the other one isn't they cant' be equal so return false
        if ((this.isReady() && !recipe2.isReady()) || (!this.isReady() && recipe2.isReady())) {
            return false;
        }

//        Iterate over each ingredient in one recipe
//        Check if that ingredient exists in the other recipe with the same name, unit, amount, etc
//        and that if one ingredient is null the other ingredient must also be null to be equal

        for(Ingredient ingredient : ingredients) {
            boolean found = false;
            for(Ingredient ingredient1 : recipe2.ingredients) {
                if ((ingredient == null && ingredient1 == null)) {
                    found = true;
                } else if (ingredient != null && ingredient1 != null) {
                    if (ingredient.toString().equals(ingredient1.toString())) {
                        found = true;
                    }
                }
            }
            if (!found) {
                return false;
            }
        }

        return true;
    }
}
