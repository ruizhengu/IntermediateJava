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

    public boolean equals(Object obj) { //Step 5
        //Two recipes are equal if they are the same size, all ingredients are set, contain the same ingredients (including name, units and amounts, and specific instance variables, e.g., Milk.type), and cost the same, even if their names are different.

        if (obj == this) { //SAME RECIPE
            return true;
        }
        if (!(obj instanceof Recipe)) {
            return false; //NOT a recipe
        }
        Recipe otherRecipe = (Recipe) obj;
        if (this.size!=otherRecipe.size || this.price!=otherRecipe.price) {
            return false;
        } else {
            if (this.ingredients.length != otherRecipe.ingredients.length) {
                return false;
            }
            for (Ingredient thisIngredient : this.ingredients) { //If ingredients are same but in different order
                boolean ingredientMATCH = false;
                for (Ingredient otherIngredient : otherRecipe.ingredients) {
                    if (thisIngredient.equals(otherIngredient)) {
                        ingredientMATCH = true;
                        break;
                    }
                }
                if (!ingredientMATCH) {
                    return false;
                }
            }
        }
        return true;
    }

}
