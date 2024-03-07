package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;

import java.util.Arrays;

public class Cafe {
    private String name;
    private Recipe[] menu;
    private Order[] orders;

    private int indexNextOrderToPlace;
    private int indexNextOrderToServe;
    private int nRecipes;

    /**
     * Constructor that initialises name to "Cafe", menu
     * size to 10 and capacity (number of orders) to 100.
     */
    public Cafe() {
        this("Cafe");
    }

    /**
     * Constructor that takes cafe name as parameter, and 
     * initialises menu size to 10 and capacity (number of orders) to 100.
     */
    public Cafe(String name) {
        this(name, 10, 100);
    }

    /**
     * Constructor that takes the cafe name, menu size and
     * capacity (number of orders) as parameters.
     */
    public Cafe(String name, int sizeMenu, int orderCapacity) {
        this.name = name;
        menu = new Recipe[sizeMenu];
        orders = new Order[orderCapacity];
        indexNextOrderToPlace = 0;
        indexNextOrderToServe = 0;
        nRecipes = 0;
    }

    /**
     * Returns greeting string
     * @return "Welcome to <cafe name>"
     */
    public String greeting() {

        String name = this.getName();
        return "Welcome to " + name;
    }

    /**
     * Getter for cafe name
     * @return Cafe name
     */
    public String getName() {
        return name;
    }


    /**
     * Add the given recipe to the menu.
     * 
     * @param newRecipe Recipe to be added to menu
     * @return Returns true if there is space in the menu and new recipe is successfully added; false otherwise
     */
    public boolean addRecipe(Recipe newRecipe) {
        int i = 0;
        boolean added = false;
        while (i < menu.length && !added) {
            if (menu[i] == null) {
                menu[i] = newRecipe;
                nRecipes++;
                added = true;
            } else
                i++;
        }
        return added;
    }

    /**
     * Find recipe with given name and remove it from the menu.
     * Assumes there are no duplicated recipe names.
     * @param recipeName Name of the recipe to be removed
     *
     * Method iterates through each item on the menu to check the
     * specified recipe exists.
     * If it does exist, the index of the chosen recipe is stored
     * If it does not exist, the RecipeNotFoundException is thrown
     * All items of the menu except the recipe to be removed are moved to a temporary array
     * Original menu array is cleared
     * Values from the temporary array are moved back to the menu array
     */
    public void removeRecipe(String recipeName) throws RecipeNotFoundException {

        boolean recipeExists = false;
        int removalIndex = 0;

        for (int i = 0; i < menu.length; i++) { //iterates through each item on the menu

            if (menu[i] != null && menu[i].getName().equals(recipeName)) //Checks if recipe exists
            {
                recipeExists = true;
                removalIndex = i; //notes the index of the recipe to be removed
            }
        }
        if (!recipeExists) //If recipe has not been found on the menu
        {
            throw new RecipeNotFoundException("Item does not exists on the menu"); //Exception is thrown
        } else{

            System.out.println("Recipe " + menu[removalIndex].getName() + " has been removed from the menu");

            Recipe[] tempMenu = new Recipe[menu.length - 1]; //one less than original as an item is removed
            for(int x = 0; x < menu.length - 1; x++) {
                if(x != removalIndex) {
                    tempMenu[x] = menu[x]; //all elements which are not the one to be removed are stored in
                                           // a temporary array
                }
                menu[x] = null; //all elements become null
                menu[x] = tempMenu[x]; //menu is copied back without the removed element
            }

        }



    }

    /**
     * Returns the current list of recipes in the menu excluding empty/null elements
     * 
     * @return Array of recipes contained in the menu (excluding nulls)
     */
    public Recipe[] getMenu() {
        Recipe[] actualMenu = new Recipe[nRecipes];
        int next = 0;
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                actualMenu[next] = menu[i];
                next++;
            }
        }
        return actualMenu;
    }

    /**
     * Print a list of orders not yet served in the following format
     * Pending Orders:
     * <Output of call to {@link Order#toString()}; one pending order per line>
     */
    public void printPendingOrders() {
        boolean anyPendingOrders = false;

        System.out.println("Pending Orders:");

        //These are all orders that have been placed but not served (pending)
        for(int i = indexNextOrderToServe; i < indexNextOrderToPlace; i++)
        {
            System.out.println(orders[i]);
            anyPendingOrders = true;
        }

        if(!anyPendingOrders) { //if no pending orders were found
            System.out.println("There are currently no pending orders");
        }
    }

    /**
     * Print the full menu in the following format:
     * ==========
     * <Output of call to {@link Cafe#greeting()}>
     * Menu
     * ==========
     * <Recipe name> - <Recipe price> (one line per recipe)
     * ==========
     * Enjoy!
     */
    public void printMenu() {
        System.out.println("==========");
        System.out.println(greeting()); //prints the greeting
        System.out.println("Menu");
        System.out.println("==========");

        for (Recipe recipe : menu) {
            if (recipe != null) { //Only prints menu items that are defined
                System.out.print(recipe.getName()); //Prints name for menu item
                System.out.print(" - "); //Separator for price and name
                System.out.println(recipe.getPrice()); //Prints price for menu item then moves to new line
            }
        }

        System.out.println("==========");
        System.out.println("Enjoy!");
    }


    /**
     * Place an order for a given recipe name with a given amount of money.
     * 
     * @param recipeName The name of the recipe being ordered
     * @param amountPaid Money handed when placing order
     * @param customerName Name of customer placing order
     * @return True if the recipe name exists in the menu and the amount paid is sufficcient; return false otherwise
     * @throws RecipeNotFoundException if the recipe name does not exist in the menu
     * @throws CafeOutOfCapacityException if the cafe cannot take any more orders and is out of capacity
     */
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException,
            CafeOutOfCapacityException {

        boolean recipeFoundPriceEnough = false; //boolean to determine whether the recipe
                                                // has been found and the correct amount was paid
        boolean recipeExists = false; //boolean to determine if the recipe exists, used to throw an exception
        int recipeLocation = 0;

        //Check if cafe is at capacity
        if(indexNextOrderToPlace > (orders.length - 1)) //First order is at element 0 - so the 99th order is 100 total
        {
            throw new CafeOutOfCapacityException("Sorry, no more orders. The cafe is at capacity"); //throw exception
        }


        for(int i = 0; i < menu.length; i++) { //iterates through each item on the menu

            if (menu[i] != null && menu[i].getName().equals(recipeName)) //Checks if recipe exists
            {
                recipeExists = true;
            }

            if(menu[i] != null && menu[i].getName().equals(recipeName) //First checks that the index is not null and
                && menu[i].getPrice() <= amountPaid) { //then if the item at the index is the recipeName parameter and
                                            // then finally that the customer has at least enough money for the item


                recipeFoundPriceEnough = true; //Recipe has now been found on the menu and price is enough
                recipeLocation = i; //stores the index of the correct recipe
            }
        }

        if(!recipeExists) //recipe has not been found on menu
        {
            throw new RecipeNotFoundException("Item does not exists on the menu"); //Exception is thrown
        }

        //only places the order if the recipe exists on the menu and the customer has paid enough
        if(recipeFoundPriceEnough) {
            //adds an Order object to the array of Orders called orders
            //with the parameters of the chosen recipe, the customers name and the amount they paid
            orders[indexNextOrderToPlace] = new Order(menu[recipeLocation], customerName, amountPaid);
            indexNextOrderToPlace++; //next order pointer moves to next element of array
        }

        return recipeFoundPriceEnough;
    }

    /**
     * Find a recipe in the menu given a recipe name
     * 
     * @param recipeName Name of the recipe to find
     * @return The recipe found or null otherwise
     */
    private Recipe findRecipe(String recipeName) {
        int i = 0;
        while (i < menu.length) {
            if (menu[i] != null && menu[i].getName().equals(recipeName))
                return menu[i];
            i++;
        }
        return null;
    }

    /**
     * If there is an order to serve, serves it ({@link Order#serve()}) and increments {@link Cafe#indexNextOrderToServe}
     * @return The updated served order, or null of there is no order to serve.
     */
    public Order serveOrder() {

        System.out.print("Order has been served - ");
        System.out.println(orders[indexNextOrderToServe]);

        //serve order at index indexNextOrderToServe
        int returnIndexNextOrderToServe = indexNextOrderToServe; //temporarily store the current index value

        indexNextOrderToServe++; //original index value increments to the next order in the array

        orders[returnIndexNextOrderToServe].serve(); //serve is called on the index before it was incremented

        return orders[returnIndexNextOrderToServe]; //the updated served order is returned or null if there is no order
    }
}
