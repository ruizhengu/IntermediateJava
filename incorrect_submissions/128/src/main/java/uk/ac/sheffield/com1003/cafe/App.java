package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {

    public static void main(String[] args) {

        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 1);

        try {

            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));

            largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));

        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }

        Cafe cafe = new Cafe("Sams Cafe", 3, 2);
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();

        try {
            cafe.placeOrder("Espresso", "Soup", 5);
            cafe.placeOrder("Espresso", "Soup", 5);
            cafe.printPendingOrders();

        } catch (RecipeNotFoundException e) {
            System.out.println("Recipe not found!");
        } catch (CafeOutOfCapacityException e) {
            System.out.println("Cafe out of room!");
        }
    }
}
