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

    /**
     * Compare two recipes, including all their ingredients, to eachother
     * 
     * @param compareRecipe Name of the recipe to compare to
     * @return True if they're equal, false if not.
     */
    public boolean equals(Recipe compareRecipe) {

        // Checks if all ingredients are set for the object we're comparing
        for (int i = 0; i < compareRecipe.ingredients.length; i++) { 
            if (compareRecipe.ingredients == null) {
                 return false;
            }
        }
            
        // For every ingredient, compare them (each ingredient is checked with eachother)
        for (int i = 0; i < ingredients.length; i++) {
            for (int j = 0; j < compareRecipe.ingredients.length; j++) {
                
                if (ingredients[i].toString().equals(compareRecipe.ingredients[j].toString())) {
                    // if they're equal, compare their size and price.
                    if (this.size == compareRecipe.size && this.price == compareRecipe.price) {
                        System.out.println("The Recipe's are equal to eachother.");
                        return true;
                    }
                } 
            }
        }
        System.out.println("The Recipe's are not equal to eachother.");
        return false;
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
}
