package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import java.net.CookieHandler;

public class App {


    public static void main(String[] args) {

        //Creating new cafe with three recipes.
        Cafe randomCafe = new Cafe("Big Cafe", 3, 100);
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);

        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));

            largeSoyLatte.addIngredient(new Milk(30, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Coffee(10));

        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }


        randomCafe.addRecipe(espresso);
        randomCafe.addRecipe(doubleEspresso);
        randomCafe.addRecipe(largeSoyLatte);

        randomCafe.printMenu();

    }
}


