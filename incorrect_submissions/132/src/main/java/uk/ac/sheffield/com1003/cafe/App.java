package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) throws RecipeNotFoundException, CafeOutOfCapacityException, TooManyIngredientsException {
        Cafe cafe = new Cafe();
        Recipe espresso = new Recipe("Espresso",1.5, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        cafe.addRecipe(espresso);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Coffee(15,false));
        doubleEspresso.addIngredient(new Water(50));
        cafe.addRecipe(doubleEspresso);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 4);
        largeSoyLatte.addIngredient(new Coffee());
        largeSoyLatte.addIngredient(new Water());
        largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
        cafe.addRecipe(largeSoyLatte);
        Recipe espresso2 = new Recipe("Espresso2",1.5, Recipe.Size.SMALL, 2);
        espresso2.addIngredient(new Water());
        espresso2.addIngredient(new Coffee());
        cafe.addRecipe(espresso2);
        cafe.printMenu();
        cafe.placeOrder("Espresso","Theo", 1.5);
        cafe.printPendingOrders();
        Order order = cafe.serveOrder();
        order.printReceipt();
        if (espresso.equals(espresso2)){
            System.out.println("yep");
        } else{
            System.out.println("nope");
        }
        cafe.removeRecipe("Espresso2");
    }
}
