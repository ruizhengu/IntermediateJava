package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;

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
     *
     * @param ingredient Ingredient to be added to recipe.
     * @return
     * @throws TooManyIngredientsException if the number of ingredients in the recipe would be exceeded
     */
    public void addIngredient(Ingredient ingredient) throws TooManyIngredientsException {
        int i = 0;
        while (i < ingredients.length) {
            if (ingredients[i] == null || ingredients[i].equals(ingredient)) {
                ingredients[i] = ingredient;
                return;
            }
            else {
                i++;
            }
        }
        if (i < ingredients.length) {
            ingredients[i] = ingredient;
        }
        else {
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

    public boolean equals(Recipe comparison) {
        boolean check = true;       //Flag to return at the end. It is set to true at the start, then if a test fails, it is set to false
        Ingredient[] comparisonIngredient = comparison.ingredients;     //Making two local variables for the two arrays of ingredients, both used in the sorting algorithms.
        Ingredient[] ingredient = ingredients;
        Arrays.sort(ingredient, (v1, v2) -> v1.getName().compareTo(v2.getName()));      //Sorting the local arrays defined previously in the ingredient's Name order using Java's built in .sort() method 
        Arrays.sort(comparisonIngredient, (v1, v2) -> v1.getName().compareTo(v2.getName()));
        for (int count = 0; count < ingredient.length; count++) {
            System.out.println(ingredient.length);
            System.out.println(ingredient[count]);
        }
        if (size == comparison.size && price == comparison.price && ingredient.length == comparison.ingredients.length) {       //Checks the Recipe's instance variables to ensure they are the same first, as there is no point in running the rest of the comparisons if they are not
            for (int count=0; count < ingredient.length; count++) {
                Ingredient comparisonIngredientIndex = comparisonIngredient[count];     //Defining each element of both ingredient arrays (now sorted in name order so it should not matter which ingredient was added in what order)
                Ingredient ingredientIndex = ingredient[count];
                if (comparisonIngredientIndex.getName() != ingredientIndex.getName()) {
                    check = false;
                }
                else {
                    if (comparisonIngredientIndex.getAmount() != ingredientIndex.getAmount()) {     //Checks that the Ingredient's super-class instance variables, which all the ingredients share, are the same before proceeding onto the sub-class instance variables
                        check = false;
                    }
                    else {
                        if (comparisonIngredientIndex.getUnit() != ingredientIndex.getUnit()) {
                            check = false;
                        }
                    }
                }
                if (comparisonIngredientIndex.getName() == "Coffee" && ingredientIndex.getName() == "Coffee") {
                    Coffee ingredientCoffee = (Coffee) ingredientIndex;
                    Coffee comparisonIngredientCoffee = (Coffee) comparisonIngredientIndex;     //Checking that when the ingredients both are a coffee object, the unique instance variable "decaf" is the same for both recipes
                    if (ingredientCoffee.equals(comparisonIngredientCoffee) != true) {
                        check = false;
                    }
                }
                if (comparisonIngredientIndex.getName() == "Milk" && ingredientIndex.getName() == "Milk") {
                    Milk ingredientMilk = (Milk) ingredientIndex;
                    Milk comparisonIngredientMilk = (Milk) comparisonIngredientIndex;       //Checking that when the ingredients both are a milk object, the unique instance variable "type" is the same for both recipes
                    if (ingredientMilk.equals(comparisonIngredientMilk) != true) {
                        check = false;
                    }
                }
                if (comparisonIngredientIndex.getName() == "Syrup" && ingredientIndex.getName() == "Syrup") {
                    Syrup ingredientSyrup = (Syrup) ingredientIndex;
                    Syrup comparisonIngredientSyrup = (Syrup) comparisonIngredientIndex;        //Checking that when the ingredients both are a syrup object, the unique instance variable "flavour" is the same for both recipes
                    if (ingredientSyrup.equals(comparisonIngredientSyrup) != true) {
                        check = false;
                    }
                }
            }
        }
        else {
            check = false;      //If any of the if statements fail, the check boolean variable is always set to false. Only when no if statements run are two recipes the same
        }
        return check;       //Check variable is returned as a boolean value
    }
}

