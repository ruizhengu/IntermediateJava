package uk.ac.sheffield.com1003.cafe;

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
    /**
     * Checks if two recipes are equal. Two recipes are equal if they are the same size,
     * all ingredients are set, contain the same ingredients (including name, units and
     * amounts, and specific instance variables, e.g., Milk.type), and cost the same,
     * even if their names are different.
     *
     * @param obj The object to compare with.
     * @return true if the recipes are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Recipe) {
            Recipe otherRecipe = (Recipe) obj;
            if (this.size == otherRecipe.size
                    && this.getPrice() == otherRecipe.getPrice()
                    && this.getClass() == otherRecipe.getClass()
                    && this.ingredients == otherRecipe.ingredients) {
                for (int i = 0; i < this.ingredients.length; i++) {
                    for (int j = 0; j < otherRecipe.ingredients.length; j++){
                        if (this.ingredients[i].getClass() == otherRecipe.ingredients[j].getClass())
                            if (this.ingredients[i].getUnit() != otherRecipe.ingredients[j].getUnit()
                                    && this.ingredients[i].getAmount()!= otherRecipe.ingredients[j].getAmount()
                                    && !this.ingredients[i].equals(otherRecipe.ingredients[j]))

                                    return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

}

