package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {


    public static void main(String[] args) {

        try {

                //Constants for values used
                final int ESPRESSO_INGREDIENTS = 2;
                final int DOUBLEESPRESSO_INGREDIENTS = 2;
                final int SOYLATTE_INGREDIENTS = 1;
                final int SIZE_MENU = 10;
                final int ORDER_CAPACITY = 100;
                final double ESPRESSO_PRICE = 1.5;
                final double DOUBLE_ESPRESSO_PRICE = 2.2;
                final double SOYLATTE_PRICE = 2.5;

                Cafe cafe = new Cafe("Central Perk", SIZE_MENU, ORDER_CAPACITY) ;

                //Recipe 1 task1
                Recipe espresso = new Recipe ("Espresso",ESPRESSO_PRICE, Size.SMALL, ESPRESSO_INGREDIENTS);
                espresso.addIngredient(new Coffee());
                espresso.addIngredient(new Water());
                cafe.addRecipe(espresso);

                //Recipe 2 task1
                Recipe doubleEspresso = new Recipe ("Double Espresso",DOUBLE_ESPRESSO_PRICE, Size.REGULAR, DOUBLEESPRESSO_INGREDIENTS);
                doubleEspresso.addIngredient(new Coffee(15));
                doubleEspresso.addIngredient(new Water(50));
                cafe.addRecipe(doubleEspresso);

                //Recipe 3 task1
                Recipe soyLatte = new Recipe ("Large Soy Latte",SOYLATTE_PRICE, Size.LARGE, SOYLATTE_INGREDIENTS);
                soyLatte.addIngredient(new Milk(50,Type.SOY));
                cafe.addRecipe(soyLatte);

                //Task 2 call print menu
                cafe.printMenu();



                // For TESTING .equals function, need to add test case

                 /* Recipe testEspresso = new Recipe ("Espresso",ESPRESSO_PRICE, Size.SMALL, ESPRESSO_INGREDIENTS);
                testEspresso.addIngredient(new Coffee());
                testEspresso.addIngredient(new Water());
                cafe.addRecipe(testEspresso);

                boolean a;
                a = testEspresso.equals(espresso);

                System.out.println("comparing Recipe Result : " + a);
 */

                // For TESTING for place order and serve
                 /* try {
                    cafe.placeOrder("Espresso", "Aryan", 3);
                    cafe.serveOrder();
                }
                catch (RecipeNotFoundException e){
                    System.out.println(e.getMessage());
                }
                catch ( CafeOutOfCapacityException e){
                    System.out.println(e.getMessage());
                } */



        }
        catch ( TooManyIngredientsException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
