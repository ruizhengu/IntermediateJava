package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

public class Recipe {
    public enum Size { SMALL, REGULAR, LARGE };
    public Size size;
    private String name;
    private double price;
    Ingredient[] ingredients;
    

    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
        
    }

    public Recipe(String name, double price, Size size, int numberOfIngredients) {
        this.name = name;
        this.price = price;
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

    /*Checks if two recipes are equal myedit */
    public boolean equals(Object other) {

        Recipe otherRecipe = (Recipe) other;
        if (other == null) {
            return false;
        }
        if (size != otherRecipe.size) {
            return false;
        }
        if (this.price != otherRecipe.price) {
            return false;
        }
        if (( this.ingredients).length != otherRecipe.ingredients.length) {
            return false;
        }
        for (int i = 0; i < ( this.ingredients).length; i++) {
            Ingredient thisIngredient = this.ingredients[i];
            Ingredient otherIngredient = otherRecipe.ingredients[i];
            if (!thisIngredient.name.equals(otherIngredient.name)) {
                return false;
            }
            if (thisIngredient.amount != otherIngredient.amount) {
                return false;
            }
            if (!thisIngredient.unit.equals(otherIngredient.unit)) {
                return false;
            }
            if (thisIngredient instanceof Milk && otherIngredient instanceof Milk) {
                Milk thisMilk = (Milk) thisIngredient;
                Milk otherMilk = (Milk) otherIngredient;
                if (!thisMilk.type.equals(otherMilk.type)) {
                    return false;
                }
            }
        }
        return true;
    }
}