package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
//import apple.laf.JRSUIConstants.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {

    public static void main(String[] args) throws RecipeNotFoundException {

        Cafe cafe = new Cafe();

        //Creating a new Recipe object for Espresso
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);

        try {

            // Adding Ingredients to the Espresso recipe
            espresso.addIngredient(new Coffee()); 
            espresso.addIngredient(new Water()); 

        // Exception handling for when there are too many ingredients found in a Recipe
        } catch (TooManyIngredientsException exception) {
            System.out.println("Error: Too many ingredients");
        }

        //Creating a new Recipe object for Double Espresso
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);


        try {

            // Adding specified amounts of Ingredients to the Double Espresso recipe
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));

        } catch (TooManyIngredientsException exception) {
            System.out.println("Error: Too many ingredients");
        }

        // Creating a new Recipe object for Large Soy Latte
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);

        try {

            // Adding specified amounts of Ingredients to the Large Soy Latte recipe
            largeSoyLatte.addIngredient(new Coffee(10));
            largeSoyLatte.addIngredient(new Water(30));
            largeSoyLatte.addIngredient(new Milk(30, Type.SOY));

        } catch (TooManyIngredientsException exception) {
            System.out.println("Error: Too many ingredients");
        }

        // Adding the new Recipes to the Cafe
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

    }

}