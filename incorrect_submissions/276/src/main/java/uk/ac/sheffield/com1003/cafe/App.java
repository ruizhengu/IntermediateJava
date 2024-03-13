package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {

    public static void main(String[] args) throws TooManyIngredientsException {
        // Create a new Cafe instance
        Cafe cafe = new Cafe();

        // Create three Drink Recipe instances and add them to the Cafe Menu
        Recipe espresso = new Recipe("Espresso", 1.5);
        espresso.addIngredient(new Coffee(8, false)); // add 8g of coffee to espresso recipe
        espresso.addIngredient(new Water(30)); // add 30ml of water to espresso recipe
        cafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2);
        doubleEspresso.addIngredient(new Coffee(15)); // add 15g of coffee to double espresso recipe
        doubleEspresso.addIngredient(new Water(50)); // add 50ml of water to double espresso recipe
        cafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5);
        largeSoyLatte.addIngredient(new Coffee(10)); // add 10g of coffee to large soy latte recipe
        largeSoyLatte.addIngredient(new Water(50)); // add 50ml of water to large soy latte recipe
        largeSoyLatte.addIngredient(new Milk(150, Milk.Type.SOY)); // add 150ml of soy milk to large soy latte recipe
        cafe.addRecipe(largeSoyLatte);

        // Print the Cafe's menu
        cafe.printMenu();
    }
}


