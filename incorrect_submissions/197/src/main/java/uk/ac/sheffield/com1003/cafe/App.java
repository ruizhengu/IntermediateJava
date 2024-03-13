package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import static uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type.SOY;

public class App {

    public static void main (String[] Args) throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException {
        Cafe cafe = new Cafe();

        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL,  2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        cafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Coffee(15, false));
        doubleEspresso.addIngredient(new Water(50));
        cafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        largeSoyLatte.addIngredient(new Coffee());
        largeSoyLatte.addIngredient(new Milk(50, SOY));
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();

    }
}
