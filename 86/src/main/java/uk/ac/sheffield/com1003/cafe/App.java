package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        try {
            Cafe cafe = new Cafe("Central Perk", 3, 4);
            Recipe Espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            Espresso.addIngredient(new Coffee(8));
            Espresso.addIngredient(new Water(30));
            cafe.addRecipe(Espresso);

            Recipe DoubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
            DoubleEspresso.addIngredient(new Coffee(15));
            DoubleEspresso.addIngredient(new Water(50));
            cafe.addRecipe(DoubleEspresso);

            Recipe LargeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
            LargeSoyLatte.addIngredient(new Coffee(30));
            LargeSoyLatte.addIngredient(new Milk(60, Milk.Type.SOY));
            cafe.addRecipe(LargeSoyLatte);

            cafe.printMenu();
        } catch (TooManyIngredientsException e) {
        }
    }



}
