package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main (String [] args) {
        Cafe store = new Cafe();
        Recipe espresso = new Recipe("Espresso",1.5, Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE,3 );
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        }
        catch (Exception TooManyIngredientsException) {
            System.out.println("Too many ingredients in espresso recipe.");
        }
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        }
        catch (Exception TooManyIngredientsException) {
            System.out.println("Too many ingredients in Double Espresso recipe.");
        }
        try {
            largeSoyLatte.addIngredient(new Milk(50, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Coffee(30));
            largeSoyLatte.addIngredient(new Water(20));
        }
        catch (Exception TooManyIngredientsException) {
            System.out.println("Too many ingredients in Large Soy Latte recipe.");
        }
        store.addRecipe(espresso);
        store.addRecipe(doubleEspresso);
        store.addRecipe(largeSoyLatte);
        store.printMenu();
    }
}
