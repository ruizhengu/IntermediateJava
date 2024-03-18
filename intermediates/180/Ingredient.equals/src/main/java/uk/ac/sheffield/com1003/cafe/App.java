package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;


public class App {

    public static void main (String[] args) throws RecipeNotFoundException, CafeOutOfCapacityException {


        try {
            Cafe cafe = new Cafe();

            Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
            Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);

            espresso.addIngredient(new Water());
            espresso.addIngredient(new Coffee());
            doubleEspresso.addIngredient(new Water(50));
            doubleEspresso.addIngredient(new Coffee(15));
            largeSoyLatte.addIngredient(new Milk(65, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Coffee(20));

            cafe.addRecipe(espresso);
            cafe.addRecipe(doubleEspresso);
            cafe.addRecipe(largeSoyLatte);

            cafe.printMenu();

            cafe.placeOrder("Espresso", "Stacy", 5);
            cafe.printPendingOrders();
        }
        catch (TooManyIngredientsException e) {
            System.out.println(e.getMessage());
        }
//        catch (RecipeNotFoundException e){
//            System.out.println(e.getMessage());
//        }
//        catch (CafeOutOfCapacityException e){
//            System.out.println(e.getMessage());
//        }


    }


}
