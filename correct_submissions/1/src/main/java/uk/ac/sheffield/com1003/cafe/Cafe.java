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
        return "Welcome to " + name;
    }

    public String greetingSolution() {
        return "Welcome to " + name;
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
     *
     * @param recipeName Name of the recipe to be removed
     */
    public void removeRecipe(String recipeName) throws RecipeNotFoundException {
        int i = 0;
        boolean deleted = false;
        while (i < menu.length && !deleted) {
            if (menu[i] != null && menu[i].getName().equals(recipeName)) {
                menu[i] = null;
                deleted = true;
                nRecipes--;
            }
            i++;
        }
        if (!deleted)
            throw new RecipeNotFoundException();
    }

    public void removeRecipeSolution(String recipeName) throws RecipeNotFoundException {
        int i = 0;
        boolean deleted = false;
        while (i < menu.length && !deleted) {
            if (menu[i] != null && menu[i].getName().equals(recipeName)) {
                menu[i] = null;
                deleted = true;
                nRecipes--;
            }
            i++;
        }
        if (!deleted)
            throw new RecipeNotFoundException();
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
        // prints from next order to serve to only get the orders that haven't been served
        for (int i = indexNextOrderToServe; i < indexNextOrderToPlace; i++) {
            System.out.println(orders[i]);
        }
    }

    public void printPendingOrdersSolution() {
        System.out.println("Pending Orders:");
        // prints from next order to serve to only get the orders that haven't been served
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
        System.out.println("==========");
        System.out.println(greeting());
        System.out.println("Menu");
        System.out.println("==========");
        for (int i = 0; i < menu.length; i++) {
            // skips null values in case of gaps in the array from deleting a recipe/ empty slots
            if (menu[i] != null)
                System.out.println(menu[i].getName() + " - " + menu[i].getPrice());
        }
        System.out.println("==========");
        System.out.println("Enjoy!");
    }

    ;

    public void printMenuSolution() {
        System.out.println("==========");
        System.out.println(greeting());
        System.out.println("Menu");
        System.out.println("==========");
        for (int i = 0; i < menu.length; i++) {
            // skips null values in case of gaps in the array from deleting a recipe/ empty slots
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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid)
            throws RecipeNotFoundException, CafeOutOfCapacityException {
        if (findRecipe(recipeName) == null) {
            throw new RecipeNotFoundException();
        }
        if (indexNextOrderToPlace >= orders.length) {
            throw new CafeOutOfCapacityException();
        }
        // create order if they have paid enough and add it to array
        if (amountPaid >= findRecipe(recipeName).getPrice()) {
            orders[indexNextOrderToPlace] =
                    new Order(findRecipe(recipeName), customerName, amountPaid);
            indexNextOrderToPlace++;
            return true;
        }
        return false;
    }

    public boolean placeOrderSolution(String recipeName, String customerName, double amountPaid)
            throws RecipeNotFoundException, CafeOutOfCapacityException {
        if (findRecipe(recipeName) == null) {
            throw new RecipeNotFoundException();
        }
        if (indexNextOrderToPlace >= orders.length) {
            throw new CafeOutOfCapacityException();
        }
        // create order if they have paid enough and add it to array
        if (amountPaid >= findRecipe(recipeName).getPrice()) {
            orders[indexNextOrderToPlace] =
                    new Order(findRecipe(recipeName), customerName, amountPaid);
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
     *
     * @return The updated served order, or null of there is no order to serve.
     */
    public Order serveOrder() {
        // checks to see if there is an order than needs to be served
        if (indexNextOrderToServe < indexNextOrderToPlace) {
            orders[indexNextOrderToServe].serve();
            indexNextOrderToServe++;
            return orders[indexNextOrderToServe - 1];
        }
        return null;
    }

    public Order serveOrderSolution() {
        // checks to see if there is an order than needs to be served
        if (indexNextOrderToServe < indexNextOrderToPlace) {
            orders[indexNextOrderToServe].serve();
            indexNextOrderToServe++;
            return orders[indexNextOrderToServe - 1];
        }
        return null;
    }
}
