package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args) {
        
        Cafe newcafe = new Cafe();
        
        /* Try and catch block to handle exceptions with error messages.  
         * Three drink Recipe instances created with their specific ingredients.
         */
        try {
           
            Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
    
            Recipe doubleespresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
            doubleespresso.addIngredient(new Coffee(15));
            doubleespresso.addIngredient(new Water(50));
    
            Recipe largesoylatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
            largesoylatte.addIngredient(new Milk(20,Type.SOY));
            largesoylatte.addIngredient(new Water());
            
            
            newcafe.addRecipe(espresso);
            newcafe.addRecipe(doubleespresso);
            newcafe.addRecipe(largesoylatte);
            
            // Calling methods from Cafe.java 
            newcafe.printMenu();

            newcafe.placeOrder("Espresso", "Amir", 1.5);
            newcafe.placeOrder("Double Espresso", "Ahnaf", 2.2);
            newcafe.placeOrder("Large Soy Latte", "Mierul", 2.5);

            newcafe.printPendingOrders();
        }
        
        catch (TooManyIngredientsException e) {
            System.err.println("Error! There are too many ingredients for this recipe: " + e.getRecipe().getName());
        }
        
        catch (RecipeNotFoundException e) {
            System.err.println("Error! " + e.getMessage());
        }
        
        catch (CafeOutOfCapacityException e) {
            System.err.println("Error! " + e.getMessage());
        }
    }
}
