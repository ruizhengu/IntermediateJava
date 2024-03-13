package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

/** My COM1003 Problem sheet submission.
 * @author Samuel Taseff
 */
public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();

        System.out.println("Instantiating recipes");

        /* Building the menu */
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe espresso2X = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);

        /* Supplying the ingredients */
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

            espresso2X.addIngredient(new Coffee(15));
            espresso2X.addIngredient(new Water(50));

            largeSoyLatte.addIngredient(new Coffee(1));
            largeSoyLatte.addIngredient(new Water(1));
            largeSoyLatte.addIngredient(new Milk(150000, Milk.Type.SOY));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients added to some recipe");
            System.out.println(e);
        }

        cafe.addRecipe(espresso);
        cafe.addRecipe(espresso2X);
        cafe.addRecipe(largeSoyLatte);

        System.out.println("Filled menu with recipes.");

        cafe.printMenu();
    }
}
