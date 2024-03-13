/**
 * App.java
 *This shows the cafe's menu and takes in order to serve them.
 *
 * @author AlAnood AlRiyami
 */
package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) {

        //Task 1 implemented here
        Cafe cafe = new Cafe("AlAnood's Cafe",5,5);

        //create a new recipe espresso to add to the cafe
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        }
        catch (TooManyIngredientsException e){
            System.out.println("Too many ingredient in this recipe");
        }
        cafe.addRecipe(espresso);

        //create a new recipe double espresso to add to the cafe
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Coffee coffeeDouble = new Coffee(15);
        Milk milkDouble = new Milk(50);
        try {
            doubleEspresso.addIngredient(coffeeDouble);
            doubleEspresso.addIngredient(milkDouble);
        }
        catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredient in this recipe");
        }
        cafe.addRecipe(doubleEspresso);

        //create a new recipe Large Soy to add to the cafe
        Recipe largeSoy = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        Milk soyMilk = new Milk(Milk.Type.SOY);
        try {
            largeSoy.addIngredient(new Coffee(23));
            largeSoy.addIngredient(new Water(15));
            largeSoy.addIngredient(soyMilk);
        }
        catch (TooManyIngredientsException e){
            System.out.println("Too many ingredient in this recipe");
        }
        cafe.addRecipe(largeSoy);

        //Task 2 implemented here
        cafe.printMenu();

        //placing orders and printing them
        try {
            cafe.placeOrder("Espresso", "AlAnood", 5);
            cafe.placeOrder("Double Espresso", "Sara", 4);
        }
        catch (RecipeNotFoundException name) {
            System.out.println(name + " is not found on the menu");
        }
        catch (CafeOutOfCapacityException orderNum) {
            System.out.println(orderNum + " limit the cafe is out of capacity");
        }
        cafe.printPendingOrders();

        try {
            cafe.removeRecipe("Espresso");
        }
        catch (RecipeNotFoundException e ){
            System.out.println(e);
        }
        cafe.printMenu();
    }
}
