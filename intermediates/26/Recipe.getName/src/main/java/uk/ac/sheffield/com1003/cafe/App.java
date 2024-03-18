package uk.ac.sheffield.com1003.cafe;

import java.io.Console;

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
 * Main application function of the program, generates a {@link Cafe} adds {@link Recipe}s to it.
*/
public class App {
    public static void main(String[] args) {
        
        //Task 1
        Cafe cafe = new Cafe("SpecialiTeas",5,100);
        
        Ingredient[] espressoIngredients = {new Coffee(), new Water()};
        initialiseRecipe(cafe, "Espresso", 1.5, Size.SMALL, espressoIngredients);
        
        Ingredient[] dEspressoIngredients = {new Coffee(15), new Water(50)};
        initialiseRecipe(cafe, "Double Espresso", 2.2, Size.REGULAR, dEspressoIngredients);

        Ingredient[] soyLateLIngredients = {new Coffee(15), new Water(10), new Milk(70,Type.SOY)};
        initialiseRecipe(cafe, "Large Soy Late", 2.5, Size.LARGE, soyLateLIngredients);

        //Task 2
        cafe.printMenu();

        //Task 3/4

        System.out.println();

        try{
            if(cafe.placeOrder("Double Espresso", "John Johnson", 2)){
                System.out.println("Begun working on order for John Johnson");
            }
            if(cafe.placeOrder("Espresso", "Amy Davis", 3)){
                System.out.println("Begun working on order for Amy Davis");
            }
            
        } catch (RecipeNotFoundException e) {
            System.out.println("That recipe does not exist.");
        } catch (CafeOutOfCapacityException e){
            System.out.println("The cafe cannot handle anymore orders.");
        }

        System.out.println();

        cafe.printPendingOrders();
        
        System.out.println();

        Order orderA = cafe.serveOrder();
        orderA.printReceipt();
        
        System.out.println();

        Order orderB = cafe.serveOrder();
        orderB.printReceipt();

        System.out.println();

        cafe.printPendingOrders();
        //Task 5

        System.out.println();

        initialiseRecipe(cafe, "Deluxe Espresso", 2.6, Size.SMALL, espressoIngredients);
        System.out.println("\"An Espresso is " + (cafe.getMenu()[0].equals(cafe.getMenu()[3]) ? "the same as" : "different to") + " a Deluxe Espresso\"");

        System.out.println();

        //Task 6

        Ingredient[] caramelMocha = {new Coffee(15), new Syrup(10,"Caramel"), new Milk(70,Type.SKIMMED)};
        initialiseRecipe(cafe, "Caramel Mocha", 3.1, Size.LARGE, caramelMocha);

        try{
            if(cafe.placeOrder("Caramel Mocha", "John Johnson", 3)){
                System.out.println("Begun working on order for John Johnson");
            }
        } catch (RecipeNotFoundException e) {
            System.out.println("That recipe does not exist.");
        } catch (CafeOutOfCapacityException e){
            System.out.println("The cafe cannot handle anymore orders.");
        }

        Order orderC = cafe.serveOrder();
        orderC.printReceipt();

        //Task 7

        System.out.println();
        
        try{
            cafe.removeRecipe("Espresso");
            System.out.println("Espresso removed from the menu.");
        } catch (RecipeNotFoundException e) {
            System.out.println("That recipe does not exist.");
        }

    }

    /**
     * Handles adding a recipe to a cafe.
     * @param cafe The cafe to add the recipe to.
     * @param name Name of the recioe
     * @param price Price of the recipe
     * @param size Size of the recipe
     * @param ingredients An array of ingredients needed for the recipe
     */
    static private void initialiseRecipe(Cafe cafe, String name, double price, Size size, Ingredient[] ingredients){
        Recipe recipe = new Recipe(name, price, size, ingredients.length);
        try {
            for (Ingredient ingredient : ingredients) {
                recipe.addIngredient(ingredient);    
            }
        } catch (TooManyIngredientsException e){
            System.out.println("Cannot add anymore ingredients to "+ name +".");
        }
        cafe.addRecipe(recipe);
    }
}
