package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

/**
 This class represents the main application for a cafe.
 It uses the Cafe, Recipe, Ingredient and exceptions classes
 It creates recipes and manages orders
 */
public class App   {
    public static void main (String[] args)   {

        // creating a new Cafe instance
        Cafe cafe = new Cafe("Shaikha's Cafe");

        //creating espresso object
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        // Adding Coffee and Water ingredients to the espresso Recipe object
        try {
            espresso.addIngredient(new Coffee(8));
            espresso.addIngredient(new Water(30));

        }
        catch ( TooManyIngredientsException e){
            // If Recipe object reached the maximum number of ingredients, print error message
            System.out.println("too many ingredients");

        }

        cafe.addRecipe(espresso);


        //creating doubleEspresso object
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

        }
        catch ( TooManyIngredientsException m){
            // If Recipe object reached the maximum number of ingredients, print error message
            System.out.println("too many ingredients");

        }
        cafe.addRecipe(doubleEspresso);

        //creating large soy latte object
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);

        try {
            largeSoyLatte.addIngredient(new Coffee(15));
            largeSoyLatte.addIngredient(new Water(5));
            largeSoyLatte.addIngredient(new Milk(20,Milk.Type.SOY));

        }
        catch ( TooManyIngredientsException a){
            // If Recipe object reached the maximum number of ingredients, print error message
            System.out.println("too many ingredients");

        }
        cafe.addRecipe(largeSoyLatte);

        //printing menu
        cafe.printMenu();

    }
}
