package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args) {
        Cafe nero = new Cafe("Cafe Nero");
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        System.out.println("Created new recipe " + espresso.getName());
        Recipe dEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        System.out.println("Created new recipe " + dEspresso.getName());
        Recipe lSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        System.out.println("Created new recipe " + lSoyLatte.getName());
        try {
            //Adding default amounts of coffee and water to the Espresso
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            //Adding 15g of coffee and 50ml of Water to the double Espresso
            dEspresso.addIngredient(new Coffee(15));
            dEspresso.addIngredient(new Water(50));
            //Adding 100g of soy milk, 50ml of water, and 20g of Coffee to the soy latte
            lSoyLatte.addIngredient(new Milk(100, Type.SOY));
            lSoyLatte.addIngredient(new Water(50));
            lSoyLatte.addIngredient(new Coffee(20));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients");
            e.printStackTrace();
        }
        //Adding all recipies to Cafe menu
        nero.addRecipe(espresso);
        nero.addRecipe(dEspresso);
        nero.addRecipe(lSoyLatte);
        System.out.println("Added all ingredients to recipes");
        System.out.println("Added all recipes to Cafe");
        
        //print menu
        nero.printMenu();
        /*
         * The following represents a simulation run of the cafe testing a large
         * majority of its required functionality
         */

        System.out.println("Placing order 1 espresso for Tom");
        System.out.println("Placing order 1 Large Soy Latte for Susie\n");
        
        //Placing sample orders and printing pending orders
        try {
            nero.placeOrder("Espresso", "Tom", 1.5);
            nero.placeOrder("Large Soy Latte", "Susie", 2.5);
        } catch (RecipeNotFoundException e) {
            System.out.println("Recipe not found");
            e.printStackTrace();
        } catch (CafeOutOfCapacityException e) {
            System.out.println("Cafe is out of capacity");
            e.printStackTrace();
        }
        nero.printPendingOrders();
        //Serving both orders
        System.out.println("\nServing first order");
        nero.serveOrder();
        nero.printPendingOrders();
        System.out.println("\nServing Second order");
        nero.serveOrder();
        nero.printPendingOrders();
        //Testing the equals() methods
        System.out.println("\nA customer asks if the espresso is the same as dEspresso");
        Recipe [] menu = nero.getMenu();
        System.out.println(menu[0].equals(dEspresso));
        //Testing the removeRecipe() by removing double espresso
        System.out.println("The cafe wants to stop serving Double Espresso");
        try {
            nero.removeRecipe("Double Espresso");
        } catch (RecipeNotFoundException e) {
            System.out.println("Recipe not found");
            e.printStackTrace();
        }
        nero.printMenu();
        
        
        
    }
}
