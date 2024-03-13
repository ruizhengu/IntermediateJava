package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {

    public static void main(String[] args) throws RecipeNotFoundException, CafeOutOfCapacityException, TooManyIngredientsException {

        Cafe cafe = new Cafe();

        // recipe list
        Recipe r1 = new Recipe ("Espresso",1.5, Recipe.Size.SMALL,2);
        Recipe r2 = new Recipe("Double Espresso", 2.2,Recipe.Size.REGULAR,2);
        Recipe r3 = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE,3);



        // add ingredients to recipe Espresso
        r1.addIngredient(new Water(5));
        r1.addIngredient(new Coffee(50,false));
        // add ingredients to recipe Double Espresso
        r2.addIngredient(new Water(50));
        r2.addIngredient(new Coffee(15,true));
        // add ingredients to recipe Large Soy Latte
        r3.addIngredient(new Milk(20,Milk.Type.SOY));
        r3.addIngredient(new Coffee(10,false));
        r3.addIngredient(new Syrup("Caramel"));

        //test
        Recipe test = new Recipe("Caramel Latte", 2.5, Recipe.Size.SMALL,2);
        test.addIngredient(new Water(60));
        test.addIngredient(new Coffee(50,false));

        // once recipe ready. add to menu
        cafe.addRecipe(r1);
        cafe.addRecipe(r2);
        cafe.addRecipe(r3);

        cafe.printMenu();

        //Try to place order and print pending orders after one order is served
        cafe.placeOrder("Espresso","Khaulah",1.5);
        cafe.serveOrder();
        cafe.placeOrder("Double Espresso","Lola",2.5);
        cafe.printPendingOrders();

        //check if the recipe is the same
        boolean checkEqualRecipe = r1.equals(test);
        System.out.println("Is recipe equals? : " + checkEqualRecipe);

    }
}
