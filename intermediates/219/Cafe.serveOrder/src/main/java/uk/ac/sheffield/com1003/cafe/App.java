package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;

public class App {

    public static void main(String[] args){
        Cafe cafe = new Cafe("Cafe Sheffield");

        //Adding recipes to menu:
        //Espresso
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

            cafe.addRecipe(espresso);
        } catch (TooManyIngredientsException e){
            System.out.println("Too many ingredients in recipe: Espresso");
        }

        //Double Espresso
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));

            cafe.addRecipe(doubleEspresso);
        } catch (TooManyIngredientsException e){
            System.out.println("Too many ingredients in recipe: Double Espresso");
        }

        //Large Soy Latte
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 4);
        try {
            largeSoyLatte.addIngredient(new Coffee());
            largeSoyLatte.addIngredient(new Water());
            largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Syrup());

            cafe.addRecipe(largeSoyLatte);
        } catch (TooManyIngredientsException e){
            System.out.println("Too many ingredients in recipe: Large Soy Latte");
        }

        //Output menu
        cafe.printMenu();

        //Placing an order
        try {
            //Orders
            cafe.placeOrder("Espresso", "Bob", 2);
        } catch (RecipeNotFoundException e) {
            System.out.println("Could not find the recipe you were trying to order in menu");
        } catch (CafeOutOfCapacityException e) {
            System.out.println("Cafe is out of capacity");
        }

        //Print pending orders
        cafe.printPendingOrders();

        //Serve an order
        cafe.serveOrder();

        //Removing a recipe
        try{
            cafe.removeRecipe("Double Espresso");
        } catch (RecipeNotFoundException e) {
            System.out.println("The recipe you were trying to remove cannot be found");
        }
    }
}
