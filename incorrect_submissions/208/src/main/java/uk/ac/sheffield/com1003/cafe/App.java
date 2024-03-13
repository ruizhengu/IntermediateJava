package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
/**
 * This is the App class.
 * It contains a main method which is the entry point for executing the entire program.
 */
public class App {

    public static void main(String[] args) {
        Cafe cafe = new Cafe();

        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } 
        catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients for espresso");
        }

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } 
        catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients for double espresso");
        }

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        try {
            largeSoyLatte.addIngredient(new Coffee(25));
            largeSoyLatte.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Milk(10, Type.SOY));
        } 
        catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients for large soy latte");
        }

        Recipe secondEspresso = new Recipe("secondEspresso", 1.5, Size.SMALL, 2);
        try {
            secondEspresso.addIngredient(new Coffee());
            secondEspresso.addIngredient(new Water());
        } 
        catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients for espresso");
        }

        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();

    }

}
