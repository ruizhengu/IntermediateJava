package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App  {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        Recipe espresso = new Recipe("Espresso",1.50,
                Recipe.Size.SMALL,2);
//trying and catching the ingredients to ensure that it does not exceed its ingredient limit.
        try {
            espresso.addIngredient(new Coffee(8));
        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }

        try {
            espresso.addIngredient(new Water(30));
        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }


        Recipe doubleEspresso = new Recipe("Double Espresso",
                2.20,Recipe.Size.REGULAR,2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }
        try {
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }


        Recipe soyLatte = new Recipe("Large Soy Latte",2.50,
                Recipe.Size.LARGE,3);
        try {
            soyLatte.addIngredient(new Coffee(15));
        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }
        try {
            soyLatte.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }
        try {
            soyLatte.addIngredient(new Milk(50, Milk.Type.SOY));
        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }
    cafe.addRecipe(espresso);
    cafe.addRecipe(doubleEspresso);
    cafe.addRecipe(soyLatte);

    cafe.printMenu();
        try {
            System.out.println(cafe.placeOrder("Espresso","Mernan",12.50));
        } catch (RecipeNotFoundException e) {
            throw new RuntimeException(e);
        } catch (CafeOutOfCapacityException e) {
            throw new RuntimeException(e);
        }
        cafe.printPendingOrders();

    }
}

