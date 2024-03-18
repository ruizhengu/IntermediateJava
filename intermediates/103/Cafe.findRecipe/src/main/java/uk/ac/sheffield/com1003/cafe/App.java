package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) {

        System.out.println("Making Cafe Instance");
        Cafe cafe = new Cafe();
        /*
        An “Espresso”, which is a small beverage, costs £1.5,
         and is made with two
ingredients: Coffee (default amount 8gr),
and Water (default amount 30ml).
    public Recipe(String name, double price, Size size, int numberOfIngredients) {

         */
        System.out.println("Making 3 Recipes");
        Recipe espressoRecipe = new Recipe("Espresso",1.5, Recipe.Size.SMALL,2);
        Recipe doubleEspressoRecipe = new Recipe("Double Espresso",2.2, Recipe.Size.REGULAR,2);
        Recipe largeSoyLatteRecipe = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE,1);
        System.out.println(espressoRecipe);
        System.out.println(doubleEspressoRecipe);
        System.out.println(largeSoyLatteRecipe);
        System.out.println("-----------------------------------------------");
        try {

            System.out.println("Adding Ingredients in Espresso Recipe:");
            espressoRecipe.addIngredient(new Coffee());
            espressoRecipe.addIngredient(new Water());
            System.out.println(espressoRecipe);
            System.out.println();

            System.out.println("Adding Ingredients in Double Espresso Recipe");
            doubleEspressoRecipe.addIngredient(new Coffee(15));
            doubleEspressoRecipe.addIngredient(new Water(50));
            System.out.println(doubleEspressoRecipe);
            System.out.println();

            System.out.println("Adding Ingredients in large Soy Latte Recipe");
            largeSoyLatteRecipe.addIngredient(new Milk(Milk.Type.SOY));
            System.out.println(largeSoyLatteRecipe);
            System.out.println();
        } catch (TooManyIngredientsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------------------------------------------------------");
        System.out.println();
        System.out.println("Adding Recipes In cafe");
        cafe.addRecipe(espressoRecipe);
        cafe.addRecipe(doubleEspressoRecipe);
        cafe.addRecipe(largeSoyLatteRecipe);

        System.out.println("Printing Cafe Menu");
        cafe.printMenu();

        System.out.println("Placing Order with following details: ");
        //    public boolean placeOrder(String recipeName, String customerName, double amountPaid)

        try {
            cafe.placeOrder("Espresso","Abdul",200);
            cafe.placeOrder("Double Espresso","Abdul",330);
        } catch (RecipeNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (CafeOutOfCapacityException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        cafe.printPendingOrders();
        System.out.println();
        System.out.println("Serving order:");
        System.out.println(cafe.serveOrder());
        System.out.println();
        cafe.printPendingOrders();

        System.out.println();
        System.out.println("Removing Espresso Recipe");
        try {
            cafe.removeRecipe("Espresso");

        } catch (RecipeNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("____________________________");
        System.out.println("Printing Menu Again");
        cafe.printMenu();
    }
}
