package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;
import java.util.Objects;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;



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

    public boolean equals(Recipe two) {


        if ( (two == null) || ! (two instanceof Recipe)
           || (ingredients.length != two.ingredients.length )      //CHECK NUM OF INGREDIENTS
           || (getPrice() != two.getPrice() )                     //CHECK PRICES
           || (size  !=  two.size ) )                            //CHECK SIZES
             return false;

        int counter = 0;

        for (int i=0; i<(ingredients.length); i++) {                  //A WAY TO COMPARE TWO INGREDIENTS WITHOUT REGARDING
            for (int j = 0; j < (two.ingredients.length); j++) {     //THEIR POSITION IN THE ARRAY
                if (ingredients[i].getName() == two.ingredients[j].getName()) {
                    if ((ingredients[i].getName() == "Water") &&
                    ( ((Water)ingredients[i]).equals((Water)two.ingredients[j])) )
                        counter++;
                    if ((ingredients[i].getName() == "Coffee") &&
                    ( ((Coffee)ingredients[i]).equals((Coffee)two.ingredients[j]) ) )
                        counter++;
                    if  ((ingredients[i].getName() == "Milk") &&
                    ( ((Milk)ingredients[i]).equals((Milk)two.ingredients[j]) ) )
                      counter++;
                }
            }
        }

        if (counter == ingredients.length)
            return true;

        return false;
    }


}
