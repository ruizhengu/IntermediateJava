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
     * compares 2 recipies to check if they are equal
     * 
     * @param recipeTwo recipie to compare against the first
     * @return return a boolean value as to whether the recipies are equal
     */
    public Boolean equals(Recipe recipeTwo){
        //checks that prices are equal, the sizes are equal and that all ingredients are set in both.
        
        if  (!(
            price == recipeTwo.price &&
            size == recipeTwo.size   &&
            this.isReady() && recipeTwo.isReady()
            ))
        {
            return false;
        }
        System.out.println(this.isReady() + "  " + recipeTwo.isReady());
        //iterate over ingredients in first recipie and checks there is a matching ingredient in recipie 2
        for (Ingredient baseIngredient : ingredients){
            boolean matchingIngredient = false;

            for (Ingredient checkIngredient: recipeTwo.ingredients){
                if (baseIngredient.getClass() == checkIngredient.getClass()){

                    if(baseIngredient.equals(checkIngredient)){
                        matchingIngredient = true;
                    }
                }
            }
            if (matchingIngredient == false){
                return false;
            }
        }

        return true;
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
            if (ingredient == null){
                return false;
            }
        }
        return true;
    }
}
