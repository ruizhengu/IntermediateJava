package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) {
        //create cafe object
        Cafe cafe = new Cafe("JJ Cafe",5,5);

        //create recipe object for espresso
        Recipe espresso = new Recipe("Espresso",1.5, Recipe.Size.SMALL,2);
        //add ingredients to espresso and add espresso recipe to the menu
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            cafe.addRecipe(espresso);
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients added");
        }

        //create recipe object for double espresso
        Recipe doubleEspresso = new Recipe("Double Espresso",2.2, Recipe.Size.REGULAR,2);
        //add ingredients to doubleEspresso and add it to the menu
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            cafe.addRecipe(doubleEspresso);
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients added");
        }

        //create recipe object for large soy latte
        Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5, Recipe.Size.LARGE, 3);
        //add ingredients to large soy latte
        try {
            largeSoyLatte.addIngredient(new Coffee());
            largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Syrup(10, "Hazelnut"));
            cafe.addRecipe(largeSoyLatte);
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients added");
        }


        cafe.printMenu();

        //place 4 orders
        try {
            cafe.placeOrder("Espresso","Bob",2.5);
        } catch (CafeOutOfCapacityException e) {
            System.out.println(e);
        } catch (RecipeNotFoundException e) {
            System.out.println(e);
        }

        try {
            cafe.placeOrder("Espresso","Martin",3.5);
        } catch (CafeOutOfCapacityException e) {
            System.out.println(e);
        } catch (RecipeNotFoundException e) {
            System.out.println(e);
        }

        try {
            cafe.placeOrder("Double Espresso","Heidi",5);
        } catch (CafeOutOfCapacityException e) {
            System.out.println(e);
        } catch (RecipeNotFoundException e) {
            System.out.println(e);
        }

        try {
            cafe.placeOrder("Large Soy Latte","Beth",6);
        } catch (CafeOutOfCapacityException e) {
            System.out.println(e);
        } catch (RecipeNotFoundException e) {
            System.out.println(e);
        }

        //serve 2 orders
        cafe.serveOrder();
        cafe.serveOrder();

        //2 orders had been served so 2 orders remains on pending orders and should be printed
        cafe.printPendingOrders();

        System.out.println("Does espresso equal to Double espresso? " + espresso.equals(doubleEspresso));

        //remove Espresso recipe and then print menu to check if espresso is removed from the menu
        try {
            cafe.removeRecipe("Espresso");
        } catch (RecipeNotFoundException e) {
            System.out.println(e);
        }

        cafe.printMenu();

    }
}
