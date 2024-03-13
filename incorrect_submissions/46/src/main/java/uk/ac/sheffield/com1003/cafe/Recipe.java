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
     * Sets x to 0, x is incremented every time two .toString methods of the ingredients match
     * Prices are compared first, then number of ingredients
     * Nested for loops used incase ingredients are in different order
     * if x = the number of ingredients in the target recipe then the two are the same
     * @toCompare is the Recipe name given to compare the target to
     * @return false if the two do not match and true if they do
     */
    public Boolean equals(Recipe toCompare){
        int x = 0;
        if (this.getPrice() == toCompare.getPrice()) {
            if (this.ingredients.length == toCompare.ingredients.length){
                for (int i = 0; i < this.ingredients.length; i++){
                    for (int z = 0; z < this.ingredients.length; i++){
                        if (this.ingredients[i].toString().compareTo(toCompare.ingredients[z].toString())==0){
                            x++;
                        }
                    }
                }
            }
        }
        if (x == this.ingredients.length){ return true; }
        else { return false; }
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
