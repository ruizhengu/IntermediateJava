package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

/**
 * Recipe class is used to create objects that represent recipes.
 * 
 * Recipes are composed of a name, price, size, and a list of ingredients.
 * The size of a recipe can be either small, regular, or large.
 * Methods are provided to add ingredients to recipes, check if recipes are ready to be used, and check if two recipes are equal.
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
     * Check if two recipes are equal by comparing their: size,number of ingredients, etc.
     *
     * The method isn't affected by the name of the recipe (i.e Recipes can have different names but still return true)
     *
     * @param otherRecipe Recipe to be compared to
     * @return Returns true if the recipes are the same; false otherwise
     */
    public boolean equals ( Recipe otherRecipe ) {

        boolean result = false;

        //Check if both recipes are the same size
        if ( this.size != otherRecipe.size ) {
            return result;
        }

        //Check if all ingredients are set
        if ( this.ingredients == null || otherRecipe.ingredients == null ) {
            return result;
        }

        //Check if recipes contain the same ingredients
        for ( int i = 0; i < ingredients.length; i++ ) {

            Ingredient thisIngredient = this.ingredients[i];
            Ingredient otherIngredient = otherRecipe.ingredients[i];

            if ( ( !thisIngredient.getName().equals ( otherIngredient.getName() ) ) ||
                    ( !thisIngredient.getUnit().equals ( otherIngredient.getUnit() ) ) ||
                    ( thisIngredient.getAmount() != otherIngredient.getAmount() ) ) {
                return result;
            }

            //Check if the recipes contain the milk ingredient and if they are of the same type
            if ( this.ingredients[i] instanceof Milk && otherRecipe.ingredients[i] instanceof Milk ){

                if ( !( ( (Milk) this.ingredients[i] ).getType() == ( (Milk) otherRecipe.ingredients[i] ).getType() ) ) {
                    return result;
                }
            }
        }

        //Check if recipes cost the same
        if ( this.getPrice() != otherRecipe.getPrice() ) {
            return result;
        }

        //If all the above checks pass, then the recipes are equal
        result = true;
        return result;
    }
}
