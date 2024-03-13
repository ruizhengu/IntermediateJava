package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

public class App {
    public static void main(String[] args) {
        //Create an instance of the Cafe class
        Cafe cafe = new Cafe("Central Perk");

        //Adding New Recipes To The Menu

        //Adding Espresso Recipe
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        cafe.addRecipe(espresso);

        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients");
        }

        //Adding Double Espresso Recipe
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        cafe.addRecipe(doubleEspresso);

        try {
            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients");
        }

        //Adding the Large Soy Latte recipe
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        cafe.addRecipe(largeSoyLatte);

        try {
            largeSoyLatte.addIngredient(new Coffee(35, false));
            largeSoyLatte.addIngredient(new Water(130));
            largeSoyLatte.addIngredient(new Milk(40, Milk.Type.SOY));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients");
        }

        //Display the menu and welcome message
        cafe.printMenu();


        try {
            //test placing an order
            cafe.placeOrder("Large Soy Latte", "Tom", 5);
        } catch (RecipeNotFoundException e) {
            System.out.println("You dumb");
        } catch (CafeOutOfCapacityException e) {
            System.out.println("You still dumb");
        }

        //test printPendingOrders
        cafe.printPendingOrders();

        //test equals method
        doubleEspresso.equals(largeSoyLatte);

        //test remove method
        try {
            cafe.removeRecipe("Espresso");
        } catch (RecipeNotFoundException e) {
            System.out.println("No such recipe");
        }
        cafe.printMenu();

    }
}
