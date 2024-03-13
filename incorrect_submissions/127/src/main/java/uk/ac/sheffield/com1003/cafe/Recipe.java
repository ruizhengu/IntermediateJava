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

    public Recipe(String name, double price, Size i, int numberOfIngredients) {
        this.name = name;
        this.price = price;
        this.size = i;
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
            if (ingredients[i] == null || ingredient.equals(ingredients[i])) {
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

    public Size getSize(){
        return size;
    }

    public Ingredient[] getIngredients(){
        return ingredients;
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

    //equals to check for ingredients(even in different orders)
    //also checks size and price
    @Override
    public boolean equals(Object other){
        if (!size.equals(((Recipe)other).getSize())) return false;
        if (this.price != ((Recipe)other).getPrice()) return false;
        if (ingredients.length != ((Recipe)other).getIngredients().length) return false;
        
        for(int i=0; i<ingredients.length;i++){
            Boolean compareResult = false;
            for(int j=0; j<ingredients.length;j++){
                if(ingredients[i].equals(((Recipe)other).getIngredients()[j])){
                    compareResult = true;   
                }
            if(compareResult == false) return false;
            }
        }
        return true;
    }
}
