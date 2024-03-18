//Reuel Igbokwe

package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;

import static uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type.SOY;


public class App {
    public static void main(String[] args){

        Cafe cafe = new Cafe();

        //Creation of the recipe instances
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe dblEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe lrgSoyLatte = new Recipe("Large Soy Latte",2.5, Recipe.Size.LARGE, 3);

        // Tests the TooManyIngredients exception which wa having some issues at the start
        try {
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }

        try {
            dblEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException f) {
            f.printStackTrace();
        }

        try {
            lrgSoyLatte.addIngredient(new Milk(20, SOY));
            lrgSoyLatte.addIngredient(new Water(50));
            lrgSoyLatte.addIngredient(new Coffee(15, false));
        } catch (TooManyIngredientsException g) {
            g.printStackTrace();
        }

        // add Recipes instances to the menu and can now be accessed
        cafe.addRecipe(espresso);
        cafe.addRecipe(dblEspresso);
        cafe.addRecipe(lrgSoyLatte);

        //Prints menu of the available drinks
        cafe.printMenu();


        cafe.printPendingOrders();
        cafe.serveOrder();


    }
}
