package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.CocoaPowder;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {

    public static void main(String args[]) throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException {
        //Task 1
        Cafe cafe = new Cafe("Central Perk", 3, 3);

        Recipe espresso = new Recipe("Espresso", 1.50, Recipe.Size.SMALL, 2);
        Coffee coffee = new Coffee();
        Water water = new Water();
        try {
            espresso.addIngredient(coffee);
            espresso.addIngredient(water);
        } catch (TooManyIngredientsException e) {
            throw e;
        }

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.20, Recipe.Size.REGULAR, 2);
        Coffee doubleCoffee = new Coffee(15, false);
        Water doubleWater = new Water(50);
        try {
            doubleEspresso.addIngredient(doubleCoffee);
            doubleEspresso.addIngredient(doubleWater);
        } catch (TooManyIngredientsException e) {
            throw e;
        }

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.50, Recipe.Size.LARGE, 3);
        Coffee soyCoffee = new Coffee(15, false);
        Milk soyMilk = new Milk(70, Milk.Type.SOY);
        CocoaPowder cocoa = new CocoaPowder(5);
        try {
            largeSoyLatte.addIngredient(soyCoffee);
            largeSoyLatte.addIngredient(soyMilk);
            largeSoyLatte.addIngredient(cocoa);
        } catch (TooManyIngredientsException e) {
            throw e;
        }

        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        //Task 2
        cafe.printMenu();

        //Task 3
        try{
            Boolean ordered = cafe.placeOrder("Espresso", "Fred", 1.50);
            if (!ordered){
                System.out.println("More money please");
            }
            else{
                System.out.println("Order placed!");
            }
        } catch (RecipeNotFoundException e){
            System.out.println("Recipe not found");
            throw e;
        } catch (CafeOutOfCapacityException e){
            System.out.println("Cafe is out of order capacity");
            throw e;
        }

        try{
            Boolean ordered = cafe.placeOrder("Espresso", "John", 1.50);
            if (!ordered){
                System.out.println("More money please");
            }
            else{
                System.out.println("Order placed!");
            }
        } catch (RecipeNotFoundException e){
            System.out.println("Recipe not found");
            throw e;
        } catch (CafeOutOfCapacityException e){
            System.out.println("Cafe is out of order capacity");
            throw e;
        }

        try{
            Boolean ordered = cafe.placeOrder("Large Soy Latte", "Daisy", 2.50);
            if (!ordered){
                System.out.println("More money please");
            }
            else{
                System.out.println("Order placed!");
                System.out.println();
            }
        } catch (RecipeNotFoundException e){
            System.out.println("Recipe not found");
            throw e;
        } catch (CafeOutOfCapacityException e){
            System.out.println("Cafe is out of order capacity");
            throw e;
        }

        //Task 4
        cafe.printPendingOrders();
        System.out.println();

        Order servedOrder0 = cafe.serveOrder();
        Order servedOrder1 = cafe.serveOrder();
        Order servedOrder2 = cafe.serveOrder();

        servedOrder0.serve();
        servedOrder1.serve();
        servedOrder2.serve();

        servedOrder0.printReceipt();
        System.out.println();
        servedOrder1.printReceipt();
        System.out.println();
        servedOrder2.printReceipt();
        System.out.println();

        //Task 5
        boolean value = doubleEspresso.equals(largeSoyLatte);
        System.out.println(value);
        boolean v2 = espresso.equals(doubleEspresso);
        System.out.println(v2);

        //Task 7
        try{
            cafe.removeRecipe("Espresso");
            System.out.println("Recipe removed");
        }catch (RecipeNotFoundException e){
            System.out.println("Recipe not found");
            throw e;
        }

        cafe.printMenu();

    }
}
