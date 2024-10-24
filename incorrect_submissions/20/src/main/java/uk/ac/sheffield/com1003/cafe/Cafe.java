package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;


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
     *
     * @return "Welcome to <cafe name>"
     */
    public String greeting() {
        return "Welcome to " + this.getName();
    }

    /**
     * Getter for cafe name
     *
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

    /**
     * iterates through menu index until null position is found, adds new recipe and number of recipe is incremented
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

    /**
     * Method to remove a recipe by setting corresponding element to null in menu array
     */
    public void removeRecipe(String recipeName) throws RecipeNotFoundException {
        int i = 0;
        while (i < menu.length) {
            if (menu[i] != null && findRecipe(recipeName) != null && menu[i].getName().equals((findRecipe(recipeName)).getName()))
                menu[i] = null;
            i++;
        }
        System.out.println("recipe not found");
    }

    /**
     * Returns the current list of recipes in the menu excluding empty/null elements
     *
     * @return Array of recipes contained in the menu (excluding nulls)
     */

    /**
     * initialize new array 'actualMenu', if current index 'menu ¥' is not null, the recipe object is added to actualMenu'
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
        for (int i = indexNextOrderToServe; i < indexNextOrderToPlace; i++) {
            System.out.println(orders[i]);
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
        //System.out.println("Menu to come soon. For guidance, see Javadoc above and TestCafe.testPrintMenu()");
        System.out.println("==========");
        System.out.println(this.greeting());
        System.out.println("Menu");
        System.out.println("==========");
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null)
                System.out.println(menu[i].getName() + " - " + menu[i].getPrice());
        }
        System.out.println("==========");
        System.out.println("Enjoy!");
    }

    ;


    /**
     * Place an order for a given recipe name with a given amount of money.
     *
     * @param recipeName   The name of the recipe being ordered
     * @param amountPaid   Money handed when placing order
     * @param customerName Name of customer placing order
     * @return True if the recipe name exists in the menu and the amount paid is sufficcient; return false otherwise
     * @throws RecipeNotFoundException    if the recipe name does not exist in the menu
     * @throws CafeOutOfCapacityException if the cafe cannot take any more orders and is out of capacity
     */
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException,
            CafeOutOfCapacityException {

        /**checks if the recipe exists in the cafe's menu*/
        if (findRecipe(recipeName) == null) {
            throw new RecipeNotFoundException();
        }
        /**checks if the cafe has enough capacity to take new orders, throws an exception if not*/
        if (orders.length <= indexNextOrderToPlace) {
            throw new CafeOutOfCapacityException();
        }
        /**if both checks pass, 'order' object is created and added to 'orders' array*/
        if (findRecipe(recipeName).getPrice() <= amountPaid) {
            orders[indexNextOrderToPlace] = new Order(findRecipe(recipeName), customerName, amountPaid);
            indexNextOrderToPlace++;
            return true;
        }

        return false;
    }

    /**
     * Find a recipe in the menu given a recipe name
     *
     * @param recipeName Name of the recipe to find
     * @return The recipe found or null otherwise
     */

    /**
     * checks if current index in 'menu' array matches 'recipeName' and returns if true
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

    /**
     * checking for orders at the current index, if present, 'serve' method is activated, then incremented to the next order
     */
//    public Order serveOrder() {
//
//        if (orders[indexNextOrderToServe] != null) {
//            orders[indexNextOrderToServe].serve();
//            indexNextOrderToServe++;
//
//            return orders[indexNextOrderToServe-1];
//        }
//
//        return null;
//    }

    public Order serveOrder() {
        if (indexNextOrderToServe >= orders.length ||
                orders[indexNextOrderToServe] == null) {
            return null;
        }
        orders[indexNextOrderToServe].serve();
        indexNextOrderToServe++;
        return orders[indexNextOrderToServe - 1];
    }
}
