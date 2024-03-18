/*
Written on 05/03/2023
 */
package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.Recipe;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args) {
        Cafe cafeNotts = new Cafe("Cafe Notts");

        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {
            System.out.println("The maximum number of ingredients for this recipe has been exceeded.");
        }

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            System.out.println("The maximum number of ingredients for this recipe has been exceeded.");
        }

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        try {
            largeSoyLatte.addIngredient(new Milk(75, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Coffee());
        } catch (TooManyIngredientsException e) {
            System.out.println("The maximum number of ingredients for this recipe has been exceeded.");
        }

        cafeNotts.addRecipe(espresso);
        cafeNotts.addRecipe(doubleEspresso);
        cafeNotts.addRecipe(largeSoyLatte);

        System.out.println();
        cafeNotts.printMenu();
        System.out.println();

        // Several examples to set up and test .placeOrder() method
        try {
            cafeNotts.placeOrder("Double Espresso", "Vishwas Kancharlapalli",
                    2.25, "Extra coffee");
        } catch (RecipeNotFoundException e) {
            System.out.println( " is a recipe that does not exist. Cannot place the order.");
        } catch (CafeOutOfCapacityException e) {
            System.out.println("The cafe is at maximum capacity. Cannot place the order.");
        }
        try {
            cafeNotts.placeOrder("Espresso", "Vishwas Kancharlapalli", 1.6);
        } catch (RecipeNotFoundException e) {
            System.out.println( " is a recipe that does not exist. Cannot place the order.");
        } catch (CafeOutOfCapacityException e) {
            System.out.println("The cafe is at maximum capacity. Cannot place the order.");
        }
        try {
            cafeNotts.placeOrder("Large Soy Latte", "Vishwas Kancharlapalli", 2.5);
        } catch (RecipeNotFoundException e) {
            System.out.println( " is a recipe that does not exist. Cannot place the order.");
        } catch (CafeOutOfCapacityException e) {
            System.out.println("The cafe is at maximum capacity. Cannot place the order.");
        }
        try {
            cafeNotts.placeOrder("Iced Tea", "Vishwas Kancharlapalli", 2.3);
        } catch (RecipeNotFoundException e) {
            System.out.println( " is a recipe that does not exist. Cannot place the order.");
        } catch (CafeOutOfCapacityException e) {
            System.out.println("The cafe is at maximum capacity. Cannot place the order.");
        }
        try {
            cafeNotts.placeOrder("Creme Brulee", "Vishwas Kancharlapalli", 2.6);
        } catch (RecipeNotFoundException e) {
            System.out.println( " is a recipe that does not exist. Cannot place the order.");
        } catch (CafeOutOfCapacityException e) {
            System.out.println("The cafe is at maximum capacity. Cannot place the order.");
        }
        System.out.println();

        // Block tests both Cafe.placeOrder() and Cafe.serveOrder()
        cafeNotts.printPendingOrders();
        System.out.println();
        cafeNotts.serveOrder();
        cafeNotts.serveOrder();
        System.out.println();
        cafeNotts.printPendingOrders();
        System.out.println();

        // Testing the Recipe.equals() method
        Recipe duplicateLargeSoyLatte = new Recipe("Different Name", 2.5,
                Recipe.Size.LARGE, 2);
        try {
            duplicateLargeSoyLatte.addIngredient(new Coffee());
            duplicateLargeSoyLatte.addIngredient(new Milk(75, Milk.Type.SKIMMED));
        } catch (TooManyIngredientsException e) {
            System.out.println("The maximum number of ingredients for this recipe has been exceeded.");
        }
        if (duplicateLargeSoyLatte.equals(largeSoyLatte)) {
            System.out.println("These are the same recipe.");
        } else {
            System.out.println("These are different recipes.");
        }
        System.out.println();

        Recipe newRec = new Recipe("New Syrup Recipe", 2.5, Recipe.Size.LARGE, 2);
        try {
            newRec.addIngredient(new Water());
            newRec.addIngredient(new Syrup("Golden"));
        } catch (TooManyIngredientsException e) {
            System.out.println("The maximum number of ingredients for this recipe has been exceeded.");
        }

        // Testing the new Syrup class and .removeRecipe()
        try {
            cafeNotts.removeRecipe("Double Espresso");
        } catch (RecipeNotFoundException e) {
            System.out.println(" is a recipe that does not exist.");
            System.out.println(", therefore cannot be removed.");
        }
        cafeNotts.addRecipe(newRec);
        try {
            cafeNotts.placeOrder("Espresso", "VK", 2.5, "Extra syrup");
        } catch (RecipeNotFoundException e) {
            System.out.println(" is a recipe that does not exist so cannot be placed");
        } catch (CafeOutOfCapacityException e) {
            System.out.println("Cafe is at maximum capacity");
        }
        cafeNotts.printPendingOrders();
        cafeNotts.printMenu();
    }
}