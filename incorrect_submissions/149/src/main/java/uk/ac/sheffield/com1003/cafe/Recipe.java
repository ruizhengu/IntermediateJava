
package uk.ac.sheffield.com1003.cafe;

import java.util.ArrayList;
import java.util.List;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {

    public void make() {
    }

    public enum Size {SMALL, REGULAR, LARGE}

    ;

    private String name;
    private double price;
    private Size size;
    private int expectedNumIngredients;
    private Ingredient[] ingredients;


    public Recipe(String name, double price, Size size, int expectedNumIngredients) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.expectedNumIngredients = expectedNumIngredients;
    }

    public void addIngredient(Ingredient ingredient) throws TooManyIngredientsException {
        if (ingredients.length >= expectedNumIngredients) {
            throw new TooManyIngredientsException();
        }
        int i = 0;
        while (i < ingredients.length) {
            if (ingredients[i] == null || ingredients[i].equals(ingredient)) {
                ingredients[i] = ingredient;
                return;
            } else
                i++;
        }
    }

    public void addIngredient(Ingredient ingredient, int amount) throws TooManyIngredientsException {
        ingredient.setAmount(amount);
        addIngredient(ingredient);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Size getSize() {
        return size;
    }

    public boolean isReady() {
        return ingredients.length == expectedNumIngredients;
    }

    @Override/*This the task 5, it checks two recipes are equal based on their price, expected number of ingredients, size and lastly the type of ingredients */
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Recipe other = (Recipe) obj;
        return this.size == other.size
                && Double.compare(this.price, other.price) == 0
                && this.expectedNumIngredients == other.expectedNumIngredients
                && this.ingredients.equals(other.ingredients);
    }
}