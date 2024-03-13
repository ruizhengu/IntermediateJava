package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    /**
     * Contains Cafe instance and tests all exception classes.
     * @author milan
     */
    public static void main(String args[]) {
        Cafe newCafe = new Cafe();
        try {
            Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            newCafe.addRecipe(espresso);
            espresso.addIngredient(new Coffee(8, false));
            espresso.addIngredient(new Water());

            Recipe doubleEspresso = new Recipe("Double Espresso",2.2,Recipe.Size.REGULAR,2);
            newCafe.addRecipe(doubleEspresso);
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));

            Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 1);
            largeSoyLatte.addIngredient(new Milk(50, Milk.Type.SOY));

            newCafe.printMenu();
            newCafe.printPendingOrders();

            //below throws TooManyIngredientsException
            Recipe justWater = new Recipe("Just Water", 1.5, Recipe.Size.SMALL, 1);
            justWater.addIngredient(new Water());
            justWater.addIngredient(new Coffee());

            //below throws RecipeNotFoundException
            newCafe.placeOrder("Kool Aid", "Milan", 3.5);

            //below throws CafeOutOfCapacityException
            Cafe anotherCafe = new Cafe("Milan's Cafe", 1, 0);
            Recipe justCoffee = new Recipe("Coffee", 1.5, Recipe.Size.SMALL, 1);
            justCoffee.addIngredient(new Coffee());
            anotherCafe.addRecipe(justCoffee);
            anotherCafe.placeOrder("Coffee","Milan", 1.5);

        } catch (TooManyIngredientsException exA) {
            System.out.println(exA);
        } catch (RecipeNotFoundException exB) {
            System.out.println(exB);
        } catch (CafeOutOfCapacityException exC) {
            System.out.println(exC);
        }

    }

}
