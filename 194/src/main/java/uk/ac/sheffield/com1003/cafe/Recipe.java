package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

/**
 * Class that holds a recipe's ingredients and features.
 * @author milan
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
        if (i < ingredients.length) {
            ingredients[i] = ingredient;
            System.out.println(ingredient + " has been added to this recipe.");
        } else {
            throw new TooManyIngredientsException();
        }
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
    public boolean equals(Object another) {
        boolean ingredientMatchFound = false; //used as flag to mark when an ingredient is only present in one recipe
        if (another == null || ! (another instanceof Recipe)) {
            return false;
        } else {
            if (another instanceof Recipe) {
                if (((Recipe)another).size.equals(size) && ((Recipe)another).getPrice() == getPrice() &&
                        ((Recipe)another).isReady() && isReady()); {
                            if (((Recipe)another).ingredients.length == ingredients.length) {
                                Ingredient[] ingredientsToCompare = ((Recipe)another).ingredients;
                                for (int x = 0; x < ingredients.length; x++) {
                                    ingredientMatchFound = false;
                                    for (int y = 0; y < ingredients.length; y++) {
                                        if (ingredients[x].getName() == ingredientsToCompare[y].getName() &&
                                                ingredients[x].getUnit().equals(ingredientsToCompare[y].getUnit()) &&
                                                ingredients[x].getAmount() == ingredientsToCompare[y].getAmount()) {
                                            ingredientMatchFound = true;
                                            System.out.println(ingredients[x] + " is present in both recipes.");
                                        }
                                    }
                                    if (!ingredientMatchFound) {
                                       //ingredient match not found for this current one, so ingredient is only present
                                       //in one recipe
                                        System.out.println(ingredients[x] + " is present in ONLY ONE recipe.");
                                        return false;
                                    }
                                }
                                if (ingredientMatchFound) {
                                    return true;
                                    //when this flag remains true throughout iterations
                                }
                            }
                }
            }
        }
        return false; //when recipes arent same size, cost, etc.
    }
}
