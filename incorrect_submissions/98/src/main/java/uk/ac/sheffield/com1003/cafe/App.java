package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Cafe;
import uk.ac.sheffield.com1003.cafe.Recipe;
import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Unit;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.Order;

import java.util.Scanner;

public class App {

    /**
     * @param args
     * @throws TooManyIngredientsException
     */
    public static void main(String[] args) throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException {

        Cafe cafe = new Cafe();
        /**
         * an instance of the class Cafe is created and it uses the Cafe() constructor
         * which doesn't take any arguments to intialise the fields in the Cafe class to default vlaues
         */

        /**
         * After creating an instance of the Cafe class, a mneu is created with its default size = 10 and
         * the required drinks can be now added to the menu with their names, prices and from that
         * the ingredients of these drinks can be added
         */

        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Coffee espressoCoffee = new Coffee(8, false);
        Water espressoWater = new Water();
        espressoWater.getUnit();
        /**
         * Since the Water class is a sibling of the Ingredient class which has the
         * unit field , it can inherit it even when it is protected
         */

        espresso.addIngredient(espressoCoffee);
        espresso.addIngredient(espressoWater);
        cafe.addRecipe(espresso);

        /**
         * A Reciepe instance is created for the "Espersso" drink and it will be added to the menu
         * created in the Cafe instance
         */

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Coffee doubleEspressoCoffee = new Coffee(15);
        Water doubleEspressoWater = new Water(50);
        doubleEspressoWater.getUnit();
        doubleEspresso.addIngredient(doubleEspressoWater);
        doubleEspresso.addIngredient(doubleEspressoCoffee);
        cafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
        Water largeSoyLatterWater = new Water();
        Milk largeSoyLatteMilk = new Milk(15, Type.SOY);
        largeSoyLatterWater.getUnit();
        largeSoyLatte.addIngredient(largeSoyLatterWater);
        largeSoyLatte.addIngredient(largeSoyLatteMilk);
        cafe.addRecipe(largeSoyLatte);

        Cafe MenuPrinted = new Cafe();
        MenuPrinted.printMenu();
        // The menu is now printed with all the previous recipes that were added

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the Recipe Name");
        String recipeNameEntered = input.next();
        Recipe recipeNameToBeEntered = cafe.getRecipe(recipeNameEntered);

        // the recipe name is entered by the user and it is checked if it is found in the saved menu using the findRecipe method
        System.out.println("Please enter the Customer Name");
        String customerNameEntered = input.next();
        System.out.println("Please enter the Amount Paid");
        double amountPaidEntered = input.nextDouble();

        Order newOrderPlacedToBeAdded = new Order(recipeNameToBeEntered, customerNameEntered, amountPaidEntered);

        boolean orderPlacedSuccess = cafe.placeOrder(recipeNameToBeEntered.getName(), customerNameEntered, amountPaidEntered);

        if (orderPlacedSuccess) {
            System.out.println("Order is successfully added");

            int nextIndex = cafe.getIndexNextOrderToPlace();
            /*nextIndex variable gets the next available index in the orders[] array and the getIndexNextOrderToPlace() method
             * returns the current value of the private variable indexNextOrderToPlace so that the value in it is what the
             * nextIndex variable is referencing to
             */
            cafe.getOrders()[nextIndex] = newOrderPlacedToBeAdded;
            /*cafe.getOrders() adds the value in the variable nextIndex to the priavte orders array so that whenever the
             * nextIndex variable value change it is assigned in the orders array
             */
            cafe.incrementIndexNextOrderToPlace();
            /*cafe.getIndexNextOrderToPlace() is a method that returns the index of the next avaliable position
             * in the orders array and increment the value of the variable indexNextOrderToPlace
             */
            cafe.incrementIndexNextOrderToServe();
            /* this is calling the incrementIndexNextOrderToServe() that has been created in the Cafe class
             * to increment the indexNextOrderToServe private variable
             */
            cafe.serveOrder();
            // the cafe.serveOrder(); is called to serve the order that was just successfully added by the user

        } else {

            System.out.println("Order isn't added");

        }

        /*in this for loop the orderers that were placed successfully to be served will be printed out using the
         * printPendingOrders() method , cafe.getOrders().length was used to show the length of the orders array
         * and the toString() method was used to print out each element in the orders array with its specific details
         */
        for (int i = 0; i < cafe.getOrders().length; i++) {
            cafe.printPendingOrders();
            System.out.println(cafe.getOrders()[i].toString());

        }


    }


}
