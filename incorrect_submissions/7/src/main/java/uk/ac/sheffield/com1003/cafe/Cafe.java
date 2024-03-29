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
        return "Welcome to " + this.getName();
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
     */

    public void removeRecipe(String recipeName) throws RecipeNotFoundException {

        Recipe removeRecipe = findRecipe(recipeName);
        if (removeRecipe == null) {
            throw new RecipeNotFoundException();
        } else {
            for (int i = 0; i < menu.length; i++) {
                if (menu[i] == removeRecipe) {
                    menu[i] = null;
                    System.out.println(recipeName + " has been removed from the menu.");
                }
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
        
        // For every element in "orders", if it's not null, and is indexed to serve, output as string.
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null && i >= indexNextOrderToServe) {
                String outputPending = orders[i].toString();
                System.out.println(outputPending);
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

        Recipe[] menu = getMenu();

        System.out.println("==========");
        System.out.println(greeting());
        System.out.println("Menu");
        System.out.println("==========");

        // For every element in "menu", output the name and the price
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null)
                System.out.println(menu[i].getName() + " - " + menu[i].getPrice());
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


        Recipe recipe = findRecipe(recipeName);
        
        // Checks if the next order to place is exeeding the max capacity of orders.  
        if (orders.length <= indexNextOrderToPlace ) {
            throw new CafeOutOfCapacityException();
        // Checks if the recipe exists (not null) and if the customer paid equal or greater than the price
        } else if (recipe != null && amountPaid >= recipe.getPrice()) { 
            orders[indexNextOrderToPlace] = new Order(recipe, customerName, amountPaid);
            return true;
        // If it is null, throw RecipeNotFoundException.
        } else if (recipe == null) {
            throw new RecipeNotFoundException();
        } else {
            return false;
        }
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

        // Checks if the order trying to be served exists (not null);
        // If it isn't null, then serve it using serve() and then increment the next order index. 
        if (orders[indexNextOrderToServe] != null) { 
            orders[indexNextOrderToServe].serve();
            indexNextOrderToServe++;
            // returns the updated served order which is at the index "indexNextOrderToServe - 1"
            // because the current indexNextOrderToServe is not the order that was just served 
            // due to the previous increment.
            return orders[indexNextOrderToServe - 1 ];
        } else {
            return null;
        }
    }
}
