package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) throws RecipeNotFoundException, CafeOutOfCapacityException {
        Cafe cafe = new Cafe();

        //create an espresso recipe
        Recipe espressoRecipe = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            espressoRecipe.addIngredient(new Coffee());
            espressoRecipe.addIngredient(new Water());
        } catch (TooManyIngredientsException ex) {
            System.err.println("A " + ex.toString() + " has occurred!");
        }
        cafe.addRecipe(espressoRecipe);

        //create a double espresso recipe
        Recipe doubleEspressoRecipe = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleEspressoRecipe.addIngredient(new Coffee(15));
            doubleEspressoRecipe.addIngredient(new Water(50));
        } catch (TooManyIngredientsException ex) {
            System.err.println("A " + ex.toString() + " has occurred!");
        }
        cafe.addRecipe(doubleEspressoRecipe);

        //create a large soy latte recipe
        Recipe largeSoyRecipe = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        try {
            largeSoyRecipe.addIngredient(new Coffee(15));
            largeSoyRecipe.addIngredient(new Milk(75, Milk.Type.SOY));
        } catch (TooManyIngredientsException ex) {
            System.err.println("A " + ex.toString() + " has occurred!");
        }
        cafe.addRecipe(largeSoyRecipe);

        cafe.printMenu();

        cafe.placeOrder("Espresso", "Jose", 1.5);
        cafe.placeOrder("Espresso", "Alex", 3);
        cafe.printPendingOrders();
    }
}
