package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.*;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {

    /**
    * This is the main function.
    * Initialise recipes, and add ingredients.
    * @throws RecipeNotFoundException will throw this execption if the recipe is not found
    * @exception TooManyIngredientsException try catch statement, 
    *  triggers when ingredients exceed the allocated number
    */

    public static void main(String[] args) throws RecipeNotFoundException {
        
        Cafe Cafe = new Cafe("Badr Cafe");

        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 4);

        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));

            largeSoyLatte.addIngredient(new Milk(100, Type.SOY));
            largeSoyLatte.addIngredient(new Coffee());
            largeSoyLatte.addIngredient(new Water());
            largeSoyLatte.addIngredient(new Syrup("Vanilla", 2));

        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }


        Cafe.addRecipe(espresso);
        
        Cafe.addRecipe(doubleEspresso);
        Cafe.addRecipe(largeSoyLatte); 

        Cafe.printMenu();
        
    }
}