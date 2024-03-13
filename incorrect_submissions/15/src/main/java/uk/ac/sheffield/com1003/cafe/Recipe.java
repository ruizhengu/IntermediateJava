package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

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

    public Ingredient[] getIngredients() {
        return null;
    }

    /**
     *Overrides the default equals method for comparing two Recipe objects. The comparison is based on the name, price and
     *the ingredients of the recipes.
     *@param obj the object to compare with this recipe.
     *@return true if the compared object is a Recipe object and has the same name, price, and ingredients as this recipe, false otherwise.
    */
    
    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Recipe)){
            return false;
        }

        Recipe other = (Recipe) obj;
        if (this.getName().equals(other.getName())){
            return false;
        }
        if (this.getPrice()!= other.getPrice()){
            return false;
        }
        if (this.ingredients.length != other.ingredients.length){
            return false;
        }
        for(int i = 0; i < ingredients.length; i++){
            if (!ingredients[i].equals(other.ingredients[i])){
                return false;

            }
        }
        return true;
    }
       
}
