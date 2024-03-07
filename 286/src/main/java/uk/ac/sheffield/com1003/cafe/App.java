package uk.ac.sheffield.com1003.cafe;

import java.util.concurrent.CountDownLatch;

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
        Cafe cafe = new Cafe();
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);
        try{
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Coffee());
            largeSoyLatte.addIngredient(new Milk(20, Type.SOY));
            cafe.printMenu();
            cafe.placeOrder("Espresso", "Jose", 3);
            cafe.placeOrder("Double Espresso", "phone", 3);
            cafe.placeOrder("Large Soy Latte", "Thu", 5);
            cafe.placeOrder("Large Soy Latte", "Shin", 5, "this is for sth");
            cafe.printPendingOrders();
            cafe.serveOrder();
            cafe.printPendingOrders();
            cafe.serveOrder();
            cafe.printPendingOrders();
            System.out.println(espresso.equals(doubleEspresso));
        }catch(TooManyIngredientsException ingredient){
            System.out.println(ingredient.getRecipeName() + " can take only " + ingredient.getNumOfIngredient() + " ingredients.");
        }catch(RecipeNotFoundException recipeName){
            System.out.println(recipeName.getRecipeName() + " is not in the Menu.");
        }catch(CafeOutOfCapacityException c){
            System.out.println("Cafe is out of capacity.");
        } 
    }
}
