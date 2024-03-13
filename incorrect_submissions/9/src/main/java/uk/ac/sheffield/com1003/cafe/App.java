package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

/**
 * The App class is the running point of the program
 */
public class App {

    /**
     * The main method creates a Cafe object, adds some recipes to it, and prints the menu and pending orders.
     * @param args takes command line arguments
     */
    public static void main(String[] args) {
        // creates a new Cafe object
        Cafe cafe = new Cafe();

        /**
         * creates a new Recipe object for Espresso, adds ingredients to it, and adds it to the cafe's menu
         * if there are too many ingredients an exception is thrown but caught here
         */
        
        try{
            Ingredient coffee = new Coffee();
            Ingredient water = new Water();
            Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL,2);
            espresso.addIngredient(coffee);;
            espresso.addIngredient(water);
            cafe.addRecipe(espresso);
        }
        catch(TooManyIngredientsException e){
            System.err.println("Too many ingredients are in the recipe");
        }
        /**
         * creates a new Recipe object for doubleEspresso, adds ingredients to it, and adds it to the cafe's menu
         * if there are too many ingredients an exception is thrown but caught here
         */
        try{
            Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR,2);
            doubleEspresso.addIngredient(new Coffee(15,false));
            doubleEspresso.addIngredient(new Water(50));
            cafe.addRecipe(doubleEspresso);
        }
        catch(TooManyIngredientsException e){
            System.err.println("Too many ingredients are in the recipe");
        }

        /**
         * creates a new Recipe object for largeSoyLatte, adds ingredients to it, and adds it to the cafe's menu
         * if there are too many ingredients an exception is thrown but caught here
         */
        try{
            Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE,2);
            largeSoyLatte.addIngredient(new Milk(100, Type.SOY));
            largeSoyLatte.addIngredient(new Coffee(10, false));
            cafe.addRecipe(largeSoyLatte);
        }
        catch(TooManyIngredientsException e){
            System.err.println("Too many ingredients are in the recipe");
        }
        //prints the menu
        cafe.printMenu();
        
        
        


    }
}