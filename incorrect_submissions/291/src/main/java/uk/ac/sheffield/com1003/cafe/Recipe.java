package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
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


    /**
     Checks if the recipe passed as a parameter is equal to another recipe.
     @param recipe the recipe to compare to this recipe
     @return true if the recipes are equal, false if not
     @throws RecipeNotFoundException if the provided recipe name does not exist
     */
    public boolean equals(Object recipe) {
        // Casting object to a Recipe object
        Recipe recipeToCompare = (Recipe) recipe;
        // check if the recipes have the same number of ingredients
        if (recipeToCompare==null)
            return false;

        // false if the object is not an instance of Recipe
        if (!(recipeToCompare instanceof Recipe))
            return false;

        // false if the two recipes have different number of ingredients
        if (this.ingredients.length != recipeToCompare.ingredients.length)
            return false;

        // false if the two recipes belong to different classes
        if (recipeToCompare.getClass() != this.getClass())
            return false;

        // false if the two recipes have different sizes
        if (recipeToCompare.size != this.size)
            return false;

        // checking if the recipes have the same price
        if (recipeToCompare.getPrice() != this.getPrice())
            return false;

        int counter = 0;
        // Looping over the ingredients in the first and second recipe
        for (int i = 0; i < this.ingredients.length; i++) {
            for (int j = 0; j < this.ingredients.length; j++) {
                //checking if the ingredients belong to the same class
                if (this.ingredients[i].getClass()==recipeToCompare.ingredients[j].getClass()) {

                    //checking if the ingredients have the same unit
                    if (this.ingredients[i].getUnit() != recipeToCompare.ingredients[j].getUnit()){
                        return false;
                    }

                    //checking if the ingredients have the same amount
                    if (this.ingredients[i].getAmount() != recipeToCompare.ingredients[j].getAmount()){
                        return false;
                    }

                    if (!this.ingredients[i].equals(recipeToCompare.ingredients[j])){
                        return false;

                    }
                    counter = counter +1;
                }

            }

        }
        //checking if the counter is different from the number of ingredients in the array
        if (counter != this.ingredients.length){
            return false;
        }

        // If none of the above conditions are met, then the two recipes are equal
        return true;
    }

}
