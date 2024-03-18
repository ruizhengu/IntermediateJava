package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) throws CafeOutOfCapacityException, RecipeNotFoundException, TooManyIngredientsException {
        Cafe cafe = new Cafe("Jvav");

        Recipe Espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        cafe.addRecipe(Espresso);
        Espresso.addIngredient(new Coffee());
        Espresso.addIngredient(new Water());

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        cafe.addRecipe(doubleEspresso);
        doubleEspresso.addIngredient(new Coffee(15));
        doubleEspresso.addIngredient(new Water(50));

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        cafe.addRecipe(largeSoyLatte);
        largeSoyLatte.addIngredient(new Coffee(10));
        largeSoyLatte.addIngredient(new Water(10));
        largeSoyLatte.addIngredient(new Milk(50, Type.SOY));

        cafe.printMenu();
    }
}
