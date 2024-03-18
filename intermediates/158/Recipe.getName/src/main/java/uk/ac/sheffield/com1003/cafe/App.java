package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
//import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
//import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
//import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    // Main Method
    public static void main(String[] args){
        Cafe myCafe = new Cafe("Aamir", 123, 3);

        // Create the myEspresso Recipe Object
        Recipe myEspresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        // Create the Double Espresso Recipe Object
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        // Create the Double Espresso Recipe Object
        Recipe soyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);


        // Add the ingredients to the Recipess
        try{
            // Espresso's Ingredients
            myEspresso.addIngredient(new Coffee(8, false));
            myEspresso.addIngredient(new Water(30));

            // Double Espresso's Ingredients
            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));
            // Large Soy Latte's Ingredients
            soyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
            // My Personal Ingredient to make the latte a bit more fluid!
            soyLatte.addIngredient(new Water(20));
        }
        catch (TooManyIngredientsException t){
            System.out.println("Exception");
        }

        // Load the recipes onto the Cafe Object
        myCafe.addRecipe(myEspresso);
        myCafe.addRecipe(doubleEspresso);
        myCafe.addRecipe(soyLatte);

    }
}
