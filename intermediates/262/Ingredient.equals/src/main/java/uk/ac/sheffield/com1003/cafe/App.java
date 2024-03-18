package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;

import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.exceptions.*;

public class App {

    public static void main(String[] args) {

        Cafe myCafe = new Cafe("joffray's cafe", 5, 10);
        try {


            //TASK 1
            //making espresso recipe with ingredients
            Recipe espresso = new Recipe("Espresso", 1.50, Size.SMALL, 2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

            //making double espresso recipe with ingredients
            Recipe doubleEspresso = new Recipe("Double Espresso", 2.20, Size.REGULAR, 2);
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));

            //making large soy latte recipe with ingredients
            Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.50, Size.LARGE, 3);
            largeSoyLatte.addIngredient(new Coffee(15));
            largeSoyLatte.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Milk(20, Type.SOY));

            //adding the recipes
            myCafe.addRecipe(espresso);
            myCafe.addRecipe(doubleEspresso);
            myCafe.addRecipe(largeSoyLatte);

            //printing initial menu
            myCafe.printMenu();

            //placing orders
            System.out.println("==========");
            myCafe.placeOrder("Large Soy Latte", "adam", 2.5);
            System.out.println("first order placed");
            System.out.println("==========");
            myCafe.placeOrder("Double Espresso", "eve", 3);
            System.out.println("second order placed");
            System.out.println("==========");
            myCafe.placeOrder("Espresso", "john", 2);
            System.out.println("third order placed");
            System.out.println("==========");

            //removing recipe
            myCafe.removeRecipe("Double Espresso");

            //the updated menu after removed items
            System.out.println("Updated menu");
            myCafe.printMenu();
            System.out.println("==========");

            //showing current order being served
            System.out.println("Order being served:");
            System.out.println(myCafe.serveOrder());
            System.out.println("==========");

            //showing orders that are left to be served
            myCafe.printPendingOrders();
            System.out.println("==========");

            //showing current order being served
            System.out.println("Order being served:");
            System.out.println(myCafe.serveOrder());
            System.out.println("==========");

            //showing orders that are now left to be served
            myCafe.printPendingOrders();
            System.out.println("==========");


        } catch (RecipeNotFoundException e) {
        } catch (CafeOutOfCapacityException e) {
        } catch (TooManyIngredientsException e) {
        }

    }

}
