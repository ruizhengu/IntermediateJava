package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.exceptions.*;


public class App {
    public static void main(String[] args) {

        Cafe myCafe = new Cafe("Central Perk", 4, 6);
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe soyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        Recipe bigSoyLatte = new Recipe("big boy Soy Latte", 2.5, Recipe.Size.LARGE, 3);

        try {

            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());


            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));

            soyLatte.addIngredient(new Coffee());
            soyLatte.addIngredient(new Water());
            soyLatte.addIngredient(new Milk(100, Milk.Type.SOY));

            bigSoyLatte.addIngredient(new Water());
            bigSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
            bigSoyLatte.addIngredient(new Coffee());


        } catch (TooManyIngredientsException e) {
        }


        myCafe.addRecipe(espresso);
        myCafe.addRecipe(doubleEspresso);
        myCafe.addRecipe(soyLatte);
        myCafe.addRecipe(bigSoyLatte);
        myCafe.printMenu();

        try {

            myCafe.placeOrder("Espresso", "Tom", 6);
            myCafe.placeOrder("Double Espresso", "Tom3", 6);


        } catch (RecipeNotFoundException e) {
        } catch (CafeOutOfCapacityException e) {
        }

        myCafe.printPendingOrders();


        if (soyLatte.equals(bigSoyLatte)) {
            System.out.println(" equal ");
        } else {
            System.out.println("not equal");
        }

        try {
            myCafe.removeRecipe("Large Soy Latte");
        } catch (RecipeNotFoundException e) {
        }

        myCafe.printMenu();


    }
}
