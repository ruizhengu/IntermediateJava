package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    // Task 1
    public static void main(String[] args) throws Exception{
        //creating the cafe
        Cafe cafe = new Cafe("David's Cafe", 3, 100);

        //adding recipe for double espresso
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.20, Recipe.Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Water(50));
        doubleEspresso.addIngredient(new Coffee(15));
        cafe.addRecipe(doubleEspresso);

        //adding recipe for single espresso
        Recipe espresso = new Recipe("Espresso", 1.50, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Water());
        espresso.addIngredient(new Coffee());
        cafe.addRecipe(espresso);

        //add recipe for large soy latte
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.50, Recipe.Size.LARGE, 3);
        largeSoyLatte.addIngredient(new Coffee(15));
        largeSoyLatte.addIngredient(new Water(50));
        largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
        cafe.addRecipe(largeSoyLatte);

        //simulating a order cycle
        cafe.printMenu();
        cafe.placeOrder("Large Soy Latte", "John", 2.50);
        cafe.printPendingOrders();
        cafe.serveOrder();
    }

}

