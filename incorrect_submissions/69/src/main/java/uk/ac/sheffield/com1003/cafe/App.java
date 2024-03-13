package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

/**
 * Provides an interaction with the cafe class
 */
public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Coffee(25));
            largeSoyLatte.addIngredient(new Milk(200, Milk.Type.SOY));
        }
        catch (TooManyIngredientsException e) {
            System.out.println("You are trying to add too many ingredients");
        }
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);
        cafe.printMenu();
    }
}
