/**
* App.java
*
*
* 16/03/2023
*
* @author Mu'az bin Mohamad Nor Sazelim
*/

package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args) throws CafeOutOfCapacityException, RecipeNotFoundException {

        try {
            Cafe cafe = new Cafe();

            Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

            Recipe doubleEspresso = new Recipe("Double Espresso", 2.20, Size.REGULAR, 2);
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));

            Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.50, Size.LARGE, 3);
            largeSoyLatte.addIngredient(new Milk(150, Type.SOY));
            largeSoyLatte.addIngredient(new Coffee(20));
            largeSoyLatte.addIngredient(new Water(25));

            cafe.addRecipe(espresso);
            cafe.addRecipe(doubleEspresso);
            cafe.addRecipe(largeSoyLatte);

            cafe.printMenu();

        }

        catch (TooManyIngredientsException e) {
            System.out.println(e.getMessage());
        }

    }

}
