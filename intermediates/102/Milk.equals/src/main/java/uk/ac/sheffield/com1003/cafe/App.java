package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main (String args[]) throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException {
        Cafe cafe = new Cafe();

        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Coffee coffee = new Coffee();
        Water water = new Water();
        espresso.addIngredient(coffee);
        espresso.addIngredient(water);

        cafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Coffee more_coffee = new Coffee(15);
        Water more_water = new Water(50);
        doubleEspresso.addIngredient(more_coffee);
        doubleEspresso.addIngredient(more_water);
        cafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        Coffee latteCoffee = new Coffee(20);
        Water latteWater = new Water(100);
        Milk soyMilk = new Milk(50);
        largeSoyLatte.addIngredient(latteCoffee);
        largeSoyLatte.addIngredient(latteWater);
        largeSoyLatte.addIngredient(soyMilk);
        cafe.addRecipe(largeSoyLatte);

        //cafe.printMenu();
        //boolean a = cafe.placeOrder("Espresso", "bob", 10);
        //boolean b = cafe.placeOrder("Double Espresso", "bob", 10);
        //boolean x = cafe.placeOrder("Large Soy Latte", "bob", 10);

        //cafe.serveOrder();
        //cafe.printPendingOrders();


        // test for equality
        Syrup s = new Syrup();

        Recipe de = new Recipe("de", 1.5, Size.SMALL, 3);
        Coffee c = new Coffee();
        Water w = new Water();
        de.addIngredient(w);
        de.addIngredient(s);
        de.addIngredient(c);
        cafe.addRecipe(de);

        Recipe EE = new Recipe("EEE", 1.5, Size.SMALL, 3);
        Coffee co = new Coffee();
        Water wa = new Water();
        EE.addIngredient(co);
        EE.addIngredient(s);
        EE.addIngredient(wa);
        cafe.addRecipe(EE);

        System.out.println("equals " + EE.equals(de));

    }
}
