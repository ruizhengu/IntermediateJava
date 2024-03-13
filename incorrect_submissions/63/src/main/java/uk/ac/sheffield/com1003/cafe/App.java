package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException {

        //This is the part about the add recipe.
        Cafe cafe = new Cafe("Central Perk",5,4);
        Recipe Espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL,
                2);
        cafe.addRecipe(Espresso);
        Espresso.addIngredient(new Coffee(8));
        Espresso.addIngredient(new Water(30));

        Recipe DoubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR,
                2);
        cafe.addRecipe(DoubleEspresso);
        DoubleEspresso.addIngredient(new Coffee(15));
        DoubleEspresso.addIngredient(new Water(50));

        Recipe LargeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE,
                2);
        cafe.addRecipe(LargeSoyLatte);
        LargeSoyLatte.addIngredient(new Coffee(20));
        LargeSoyLatte.addIngredient(new Milk(80, Milk.Type.SOY));

        Recipe VanillaLatte = new Recipe("Vanilla Latte", 2.3, Recipe.Size.LARGE,
                3);
        cafe.addRecipe(VanillaLatte);
        VanillaLatte.addIngredient(new Coffee(20));
        VanillaLatte.addIngredient(new Milk(70, Milk.Type.WHOLE));
        VanillaLatte.addIngredient(new Syrup("Vanilla",10));

        //This is about removing recipe.
        cafe.removeRecipe("Double Espresso");

        //This is about printing out the menu.
        cafe.printMenu();

        //This is about placing order.
        cafe.placeOrder("Espresso","Jose",3);
        //cafe.placeOrder("Double Espresso","Jose",3);
        cafe.serveOrder();

        //This is about print the pending orders
        cafe.printPendingOrders();
        //compare with two recipe
        Espresso.equals(DoubleEspresso);



        try {
            cafe.placeOrder("Espresso","Jose",3);
        } catch (CafeOutOfCapacityException | RecipeNotFoundException  e) {
            System.out.println(e.getMessage());
        }


    }
}
