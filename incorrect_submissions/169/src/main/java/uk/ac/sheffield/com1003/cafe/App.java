package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

import java.util.Scanner;

public class App {

    public static void main(String[] args)  {

        Cafe c  =  new Cafe("Central Perk",3,100);

        Recipe r1 = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            r1.addIngredient(new Coffee(8, false));
            r1.addIngredient(new Water());

        }catch  (TooManyIngredientsException e) {
            System.out.println("Too many ingredients");
        }

        Recipe r2 = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            r2.addIngredient(new Coffee(15));
            r2.addIngredient(new Water(50));
        }catch(TooManyIngredientsException e){
            System.out.println("Too many ingredients");
        }

        Recipe r3 = new Recipe("Large Soy Latte",2.5, Recipe.Size.LARGE,1);
        try{
            r3.addIngredient(new Milk(10, Milk.Type.SOY));
        }catch(TooManyIngredientsException e){
        System.out.println("Too many ingredients");
        }

        Recipe r4 = new Recipe("Syrup Coffee", 3, Recipe.Size.LARGE, 3);
        try {
            r4.addIngredient(new Coffee(10));
            r4.addIngredient(new Water(50));
            r4.addIngredient(new Syrup(30, Syrup.Type.VANILLA));
        }catch(TooManyIngredientsException e){
        System.out.println("Too many ingredients");
        }

        c.addRecipe(r1);
        c.addRecipe(r2);
        c.addRecipe(r3);
        c.printMenu();

        //I did this try and catch for each of the new order added to catch the exception from the code.

        try{
            c.placeOrder("double espresso", "Mark", 2); //Output will be Amount Not Sufficient

        } catch (CafeOutOfCapacityException e) {
        } catch (RecipeNotFoundException e) {
        }

        try{
            c.placeOrder("Soy Latte", "James", 3); //Output will be RecipeNotFound
        } catch (CafeOutOfCapacityException e) {
        } catch (RecipeNotFoundException e) {
        }

        //Added a for loop to test out the CafeOutOfCapacity bound with 100 orders, the system will break when it received the next order after 100th orders.
        for(int i=0;i<=100;i++) {
            try {
                c.placeOrder("Large Soy Latte", "Zack", 3); //Output will be CafeOutOfCapacity
            } catch (CafeOutOfCapacityException e) {
                break;
            } catch (RecipeNotFoundException e) {
            }
        }

        c.printPendingOrders();
        c.serveOrder();
        c.printPendingOrders();
        c.serveOrder();
        c.printPendingOrders();

        //removing Espresso from the menu and add a new menu, then print back the menu list
        try{
        c.removeRecipe("Espresso");
        } catch (RecipeNotFoundException e) {
            System.out.println("Recipe not found");
        }

        c.addRecipe(r4);
        c.printMenu();
    }
}
