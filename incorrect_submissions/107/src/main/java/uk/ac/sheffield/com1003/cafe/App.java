/**
 * App.java
 *
 * @version 1.0 15/03/2023
 * @author Naseem Hoque
 */

package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) {
        /* Create a cafe object and populate its menu with new Recipes*/
        Cafe cafe = new Cafe("Cafe Nas", 10, 10);

        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Coffee(15, false));
            largeSoyLatte.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Milk(30, Milk.Type.SOY));
        } catch (TooManyIngredientsException e) {
            System.out.println("You have added too many ingredients!");
        }

        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);
    }
}
