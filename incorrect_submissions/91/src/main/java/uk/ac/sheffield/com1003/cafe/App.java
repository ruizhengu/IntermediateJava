package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;


public class App
{
    public static void main(String[] args)
    {
        try
        {
            //this section is what is asked for in task 1 (create three new recipe instances and
            // add them to the menu)
            Cafe javaCafe = new Cafe();

            Recipe espresso = new Recipe("Espresso", 1.5,
                    Recipe.Size.SMALL, 2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            javaCafe.addRecipe(espresso);
            System.out.println(espresso.getName() + " has been added to the menu." );
            System.out.println("");

            Recipe doubleEspresso = new Recipe("Double Espresso", 2.2,
                    Recipe.Size.REGULAR, 2);
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            javaCafe.addRecipe(doubleEspresso);
            System.out.println(doubleEspresso.getName() + " has been added to the menu." );
            System.out.println("");

            Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5,
                    Recipe.Size.LARGE, 3);
            largeSoyLatte.addIngredient(new Milk(15, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Water(130));
            largeSoyLatte.addIngredient(new Coffee(22));
            javaCafe.addRecipe(largeSoyLatte);
            System.out.println(largeSoyLatte.getName() + " has been added to the menu." );
            System.out.println("");

            //the rest is not asked for, but exists for testing the further tasks
            System.out.println("Menu with three recipes (before removal):");
            javaCafe.printMenu();
            System.out.println("");

            try {
                javaCafe.placeOrder("Double Espresso", "randomName", 2.4); }
            catch (RecipeNotFoundException e)
            { System.err.println("The recipe you are looking for does not exist."); }
            catch (CafeOutOfCapacityException ex)
            {System.err.println("The cafe cannot currently handle any more orders. Please come back" +
                   "when we're less busy.");}

            javaCafe.printPendingOrders();
            Order servedOrder = javaCafe.serveOrder();
            System.out.println("");
            System.out.println("Order Receipt:");
            servedOrder.printReceipt();
            System.out.println("");

             Recipe espressoWithDifferentName = new Recipe("EspressoWithDifferentName", 1.5,
                    Recipe.Size.SMALL, 2);
             espressoWithDifferentName.addIngredient(new Coffee());
             espressoWithDifferentName.addIngredient(new Water());

            System.out.println("It is " + espresso.equals(espressoWithDifferentName) + " that "
            + espresso.getName() + " and " + espressoWithDifferentName.getName()
                    + " are the same drink.");
            System.out.println("");
            System.out.println("It is " + espresso.equals(doubleEspresso) + " that "
                    + espresso.getName() + " and " + doubleEspresso.getName()
                    + " are the same drink.");
            System.out.println("");

            try { javaCafe.removeRecipe("Espresso"); }
            catch (RecipeNotFoundException e)
            {
                System.err.println("The recipe you are trying to delete does not exist.");
            }

            System.out.println("Menu with two recipes (after Espresso has been removed):");
            javaCafe.printMenu();
         }
         catch (TooManyIngredientsException e)
         {
             System.err.println("You have added more ingredients than there are currently" +
                    "specified in the recipe's declaration!");
         }
    }
}
