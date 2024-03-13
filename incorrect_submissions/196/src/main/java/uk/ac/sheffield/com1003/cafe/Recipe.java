package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    public enum Size { SMALL, REGULAR, LARGE };
    String name;
    private double price;
    private Size size;
    private Ingredient[] ingredients;

    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
        
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Recipe(String name, double price, Size size, int numberOfIngredients) {
        this.name = name;
        this.setPrice(price);
        this.size = size;
        ingredients = new Ingredient[numberOfIngredients - 1];
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
            }
            else i++;
        }
        throw new TooManyIngredientsException();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public boolean equals(Recipe recipe1, Recipe recipe2){
        if(recipe1.getPrice() != recipe2.getPrice()) return false;
        if(recipe1.size != recipe2.size) return false;
        if(recipe1.ingredients.equals(recipe2.ingredients)) return false;
        return true;
    }
    /**
     * Checks whether recipe is ready to be used.
     * @return True if all ingredients of the recipe have been added and false otherwise
     */
    public boolean isReady() {
        for (Ingredient ingredient :ingredients) {
            if (ingredient == null)
                return false;
        }
        return true;
    }
}
