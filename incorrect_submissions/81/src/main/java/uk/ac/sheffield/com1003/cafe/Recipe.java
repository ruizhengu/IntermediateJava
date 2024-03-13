package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
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

    

    @Override
    public boolean equals(Object another) {



        if (!((Recipe)another).isReady()) {
            return false;
        }

        if (!isReady()) {
            return false;
        }


        if (size != ((Recipe)another).size) {
            return false;
        }


        if (price != ((Recipe)another).price) {
            return false;
        }


        if (ingredients.length != ((Recipe)another).ingredients.length) {
            return false;
        }


        for (int i=0; i<ingredients.length; i++) {
            
            Ingredient ing = ingredients[i];
            boolean Same = false;

            

            for (int a=0; a<((Recipe)another).ingredients.length; a++) {

                
                if (((Recipe)another).ingredients[a].getName() == ing.getName()) {


                    if (((Recipe)another).ingredients[a].getUnit() == ing.getUnit()) {
                        

                        if (((Recipe)another).ingredients[a].getAmount() == ing.getAmount()) {
                        

                            if (ing.getName() == "Coffee") {
                                                               
                                Same = true;

                            } else if (ing.getName() == "Syrup") {
                                Same = true;
                            } else if (ing.getName() == "Milk") {
                                Same = true;
                            } else {
                                Same = true;
                            }                        
                        }


                    }

                }
                

            }



            if (!Same) {
                return false;
            }
            

        }
        

        return true;
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
