package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;

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
        return "Welcome to Central Perk";
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
     * @throws RecipeNotFoundException
     */
    public void removeRecipe(String recipeName) throws RecipeNotFoundException {

        // boolean value , true = recipeName does exist , false = recipeName does not exist
        boolean existOrNot = false;

        // for loop which checks if the recipeName exists in the menu
        for (int x = 0; x < menu.length; x++) {
            if (menu[x] == null) {
                continue;
            }
            else if (menu[x].getName().equals(recipeName)) {
                existOrNot = true;
            }
        }

        // if recipeName does not exist then an exception is thrown
        if (!existOrNot) {
            throw new RecipeNotFoundException();
        }

        // finds the recipe to be deleted from the menu and deletes it
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == null) {
                continue;
            }
            else if (menu[i].getName().equals(recipeName)) {
                menu[i] = null;
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

        System.out.println("Pending Orders:");
        // loops through orders menu and prints each order
        for (int i = 0; i < orders.length; i++) {

            if (orders[i] == null) {
                continue;
            }
            else {
                System.out.println(orders[i].toString());
            }
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
        System.out.println(greeting());
        System.out.println("Menu");
        System.out.println("==========");

        // loops through menu array and prints each items name and price
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                System.out.println(menu[i].getName() + " - " + menu[i].getPrice());
            }
        }

        System.out.println("==========");
        System.out.println("Enjoy!");

    };

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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException, CafeOutOfCapacityException {

        // boolean value , true = recipeName does exist , false = recipeName does not exist
        boolean existOrNot = false;

        // for loop which checks if the recipeName exists in the menu
        for (int x = 0; x < menu.length; x++) {
            if (menu[x] == null) {
                continue;
            }
            else if (menu[x].getName().equals(recipeName)) {
                existOrNot = true;
            }
        }

        // if recipeName does not exist then an exception is thrown
        if (!existOrNot) {
            throw new RecipeNotFoundException();
        }
        // if orders array cannot take any more orders then an exception is thrown
        if (indexNextOrderToPlace == orders.length || indexNextOrderToPlace == 100 ) {
            throw new CafeOutOfCapacityException();
        }

        // New instance of new order
        Order newOrder = new Order(findRecipe(recipeName), customerName, amountPaid);

        // For loop which places the order
        for (int y = 0; y < orders.length; y++) {

            // checks if customer has paid for the order
            if (existOrNot && amountPaid >= findRecipe(recipeName).getPrice()) {
                // places the order into the next free space in the array and returns true
                orders[indexNextOrderToPlace] = newOrder;
                indexNextOrderToPlace++;
                return true;
            }
        }

        return false;
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
     * @throws CafeOutOfCapacityException
     */
    public Order serveOrder() throws CafeOutOfCapacityException {

        // For loop which serves the order
        for (int x = 0; x < orders.length; x++) {

            // if selection which updates the order and then implements by 1 and then returns the updated order 
            if (orders[indexNextOrderToServe] != null) {
                if (indexNextOrderToServe == orders.length || indexNextOrderToServe == 100 ) {
                    throw new CafeOutOfCapacityException();
                }
                // updates the order
                orders[indexNextOrderToServe].serve();
                // increments the index by one
                indexNextOrderToServe++;
                // returns the order
                return orders[indexNextOrderToServe-1];
                
            }

        }

        return null;
    }
}


