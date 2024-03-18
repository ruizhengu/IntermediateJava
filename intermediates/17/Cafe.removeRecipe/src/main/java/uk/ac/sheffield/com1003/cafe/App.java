package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main (String[] args) throws TooManyIngredientsException{
        Cafe cafe = new Cafe("Annce's Coffee Shop");

        Recipe espresso = new Recipe("Espresso",1.5, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());

        Recipe doubleEspresso = new Recipe("Double Espresso",2.2, Recipe.Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Coffee(8));
        doubleEspresso.addIngredient(new Water(30));

        Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5, Recipe.Size.LARGE, 3);
        largeSoyLatte.addIngredient(new Coffee(12));
        largeSoyLatte.addIngredient(new Water(20));
        largeSoyLatte.addIngredient(new Milk(30, Milk.Type.SOY));

        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();


    }
}
