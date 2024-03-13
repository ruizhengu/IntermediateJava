package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main (String [] args) throws TooManyIngredientsException {
        //create new café
        Cafe cafe = new Cafe();

        //add recipes for 3 drinks, and ingredients to these recipes
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Water());
        espresso.addIngredient(new Coffee());
        //add recipe to menu
        cafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Coffee(15));
        doubleEspresso.addIngredient(new Water(50));
        cafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        largeSoyLatte.addIngredient(new Milk(10, Milk.Type.SOY));
        largeSoyLatte.addIngredient(new Coffee());
        cafe.addRecipe(largeSoyLatte);

        //function from cafe class prints as a string
        cafe.printMenu();

        //Placing and serving orders with exception catching
        //ADDED TO TEST MY METHODS - NOT NECESSARY FOR PROGRAM TO FUNCTION
        try {
            cafe.placeOrder("Large Soy Latte", "Daniel", 2.5);
            cafe.placeOrder("Espresso", "Daniel", 2.5);
            cafe.printPendingOrders();
            cafe.serveOrder();
            cafe.printPendingOrders();
            cafe.removeRecipe("Large Soy Latte");
        }
        catch(RecipeNotFoundException notFoundError) {
            System.out.println(notFoundError.getRecipeName() + " was not found in the menu");
        }
        catch(CafeOutOfCapacityException capacityError) {
            System.out.println(capacityError.getErrorString());
        }
    }

}
