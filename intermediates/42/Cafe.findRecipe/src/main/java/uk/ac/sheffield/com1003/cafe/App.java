package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.Recipe.Size;

public class App {

    public static void main (String [] args) throws TooManyIngredientsException, CafeOutOfCapacityException, RecipeNotFoundException {
        //defining the new cafe as an object of Cafe
        Cafe new_cafe = new Cafe("New Cafe",10,100);

        /*
         * creating 3 new recipes to new cafe: espresso,
         * double espresso & large soy latte
         */
        Recipe espresso = new Recipe("Espresso",1.5, Size.SMALL,2);
        espresso.addIngredient(new Coffee(8, false));
        espresso.addIngredient(new Water(30));

        Recipe double_espresso = new Recipe("Double Espresso",2.2, Size.REGULAR,2);
        double_espresso.addIngredient(new Coffee(15, false));
        double_espresso.addIngredient(new Water(50));

        Recipe l_soy_latte = new Recipe("Large Soy Latte", 2.5, Size.LARGE,3);
        l_soy_latte.addIngredient(new Milk(100, Milk.Type.SOY));
        l_soy_latte.addIngredient(new Coffee(8, false));
        l_soy_latte.addIngredient(new Water(30));

        //adding recipes to new cafe
        new_cafe.addRecipe(espresso);
        new_cafe.addRecipe(double_espresso);
        new_cafe.addRecipe(l_soy_latte);

        new_cafe.printMenu();

        new_cafe.placeOrder("Espresso", "Michael", 3);
        new_cafe.printPendingOrders();

        Recipe espresso2 = new Recipe("Espresso",1.5, Size.SMALL,2);
        espresso2.addIngredient(new Coffee(8, false));
        espresso2.addIngredient(new Water(15));

        //comparing two espresso's where the only difference is a change in amount of water
        //expecting a false result
        System.out.println(espresso.equals(espresso2));

        //making a syrup recipe using new syrup ingredient
        Recipe bunchOSyrup = new Recipe("Syrup Soup", 3, Size.REGULAR, 2);
        bunchOSyrup.addIngredient(new Syrup("Banana", 20));
        bunchOSyrup.addIngredient(new Water(30));

        new_cafe.addRecipe(bunchOSyrup);

        new_cafe.printMenu();

        //demonstrating new remove recipe method
        new_cafe.removeRecipe("Syrup Soup");

        new_cafe.printMenu();

    }
}
