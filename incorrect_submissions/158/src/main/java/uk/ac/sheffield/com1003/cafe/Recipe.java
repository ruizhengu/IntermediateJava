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

    /**
     * A method that checks if two recipes are the same
     * Task 5
     */
    public boolean equals(Recipe recipe1){
        // Check if size is not the same
        if (this.size != recipe1.size) return false;
        // Check if ingredients are not ready
        else if (!this.isReady() || !recipe1.isReady()) return false;
        // Check if cost is same
        else if (price != recipe1.getPrice()) return false;

        List<Ingredient> ingredientList = Arrays.asList(ingredients);
        // Counter variable used to record no. of ingredient matches
        int counter = 0;
        // check if the no. of ingredients match
        if (ingredients.length == recipe1.ingredients.length){
            for (Ingredient ingredient: recipe1.ingredients){
                int index = ingredientList.indexOf(ingredient);
                // Check if ingredient type matches
                if (index != -1){
                    // Check if ingredient's names match
                    if (ingredientList.get(index).getName() == ingredient.getName()){
                        // Check if ingredient's units match
                        if(ingredientList.get(index).getUnit() == ingredient.getUnit()){
                            // Check if ingredient's amounts match
                            if (ingredientList.get(index).getAmount() == ingredient.getAmount()){
//                                System.out.println("Current instance: " + ingredientList.get(index).getName());
//                                System.out.println("Current instance: " + ingredientList.get(index).getAmount());
//                                System.out.println("Matching instance: " + ingredient.getName());
//                                System.out.println("Matching instance: " + ingredient.getAmount());
                                // CHECK INSTANCE
                                counter++;
                            }
                        }

                    }
                }
            }
        }

        // If no. of ingredient matches equals to no. of ingredients present
        if (counter == ingredients.length) return true;

        return false;
    }
}
