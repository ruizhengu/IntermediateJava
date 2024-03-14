package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

import java.util.Arrays;
import java.util.List;

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

    @Override
    public boolean equals(Object obj){
        if(obj == null || ! (obj instanceof Recipe)){
            return false;
        }
        Recipe rObj = (Recipe) obj;
        if(rObj.getPrice() != this.getPrice()){
            return false;
        }


        if(rObj.ingredients.length == this.ingredients.length){
            // Check if ingredients have been set.
            int length = this.ingredients.length;
            if(rObj.ingredients[length - 1] == null) return false;
            if(this.ingredients[length - 1] == null) return false;
            // Compare each ingredient
            List<Ingredient> otherIng = Arrays.asList(rObj.ingredients);
            List<Ingredient> thisIng = Arrays.asList(this.ingredients);
            return otherIng.containsAll(thisIng);
        }
        return false;
    }

}
