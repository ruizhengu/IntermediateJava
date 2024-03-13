package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String args[]) {
        Cafe cafe = new Cafe();

        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (Exception e) {
            System.out.println("ERROR: Too many ingredients for espresso");
        }

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch (Exception e) {
            System.out.println("ERROR: Too many ingredients for double espresso");
        }

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 1);
        try {
            largeSoyLatte.addIngredient(new Milk(50, Milk.Type.SOY));
        } catch (Exception e) {
            System.out.println("ERROR: Too many ingredients for large soy latte");
        }

        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();

        try {
            cafe.placeOrder("Espresso", "AAAAAAAA", 5);
        } catch (Exception e) {

        }
    }
}
