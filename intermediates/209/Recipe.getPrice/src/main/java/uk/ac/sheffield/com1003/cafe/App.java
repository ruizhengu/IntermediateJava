/**
 *  COM1003 Problem Sheet due 17th March 2023
 */

package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {

    public static void main(String[] args) {

        Cafe c = new Cafe();
        Recipe espresso = new Recipe("Espresso", 1.50, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.20, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.50, Recipe.Size.LARGE, 3);

        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Coffee(20));
            largeSoyLatte.addIngredient(new Water(30));
            largeSoyLatte.addIngredient(new Milk(40, Milk.Type.SOY));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients added.");
        }

        c.addRecipe(espresso);
        c.addRecipe(doubleEspresso);
        c.addRecipe(largeSoyLatte);

        c.printMenu();

    }
}
