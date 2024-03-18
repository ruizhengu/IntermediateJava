package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;

/**
 * This class is used to instantiate Cafe objects.
 * Each cafe has a menu which recipes can be added to or removed from
 * They also have an array of orders that have been made at that cafe
 * Orders can be placed and served
 */
public class Cafe {
    private String name;
    private Recipe[] menu;
    private Order[] orders;

    private int indexNextOrderToPlace;
    private int indexNextOrderToServe;
    private int nRecipes;

    private int orderCapacity;

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
        this.orderCapacity = orderCapacity;
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
        /* Go through the occupied part of the list, after the recipe is found
         * all values must move one place to the left in the list
         */
        int i = 0;
        boolean found = false;
        while ((i < menu.length) && (menu[i] != null)) {
            if (found) {
                menu[i] = menu[i + 1];
            }
            if ((menu[i].getName()).equals(recipeName)) {
                found = true;
                menu[i] = menu[i + 1];
            }
            i++;
        }
        if (found) {
            this.nRecipes--;
        }
        else {
            System.out.println("The recipe " + recipeName + " cannot be removed because it is not on the menu");
            throw new RecipeNotFoundException();
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
        StringBuffer sb = new StringBuffer();
        String lineBreak = System.getProperty("line.separator");
        sb.append("Pending Orders:");
        int i = indexNextOrderToServe;
        while (i < orders.length && orders[i] != null) {
            sb.append(lineBreak);
            sb.append(orders[i].toString());
            i++;
        }
        System.out.println(sb);
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
        System.out.println(this.greeting());
        System.out.println("Menu");
        System.out.println("==========");
        for (Recipe recipe: this.getMenu()){
            System.out.println(recipe.getName() + " - " + recipe.getPrice());
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
     * @return True if the recipe name exists in the menu and the amount paid is sufficient; return false otherwise
     * @throws RecipeNotFoundException if the recipe name does not exist in the menu
     * @throws CafeOutOfCapacityException if the cafe cannot take any more orders and is out of capacity
     */
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws CafeOutOfCapacityException, RecipeNotFoundException {
        if (indexNextOrderToPlace >= orders.length)
            throw new CafeOutOfCapacityException();

        Recipe r = findRecipe(recipeName);
        if (r == null)
            throw new RecipeNotFoundException();

        if (r.getPrice() > amountPaid)
            return false;

        orders[indexNextOrderToPlace] = new Order(r, customerName, amountPaid);
        indexNextOrderToPlace++;
        return true;
    }

    /**
     * Place an order for a given recipe name with a given amount of money with a special request.
     * 
     * @param recipeName The name of the recipe being ordered
     * @param amountPaid Money handed when placing order
     * @param customerName Name of customer placing order
     * @param specialRequest The request made by the customer if a request has been made otherwise "none"
     * @return True if the recipe name exists in the menu and the amount paid is sufficient; return false otherwise
     * @throws RecipeNotFoundException if the recipe name does not exist in the menu
     * @throws CafeOutOfCapacityException if the cafe cannot take any more orders and is out of capacity
     */

    public boolean placeOrder(String recipeName, String customerName, double amountPaid, String specialRequest)
                                                throws RecipeNotFoundException, CafeOutOfCapacityException {
        Recipe recipe = findRecipe(recipeName);

        if (indexNextOrderToPlace == this.orderCapacity) {
            System.out.println("The cafe cannot take your order because it is out of capacity");
            throw new CafeOutOfCapacityException();
        }

        else if (recipe == null) {
            System.out.println("The order cannot be placed because the recipe " + recipeName + " is not on the menu");
            throw new RecipeNotFoundException();
        }

        /* If the cafe isn't out of capacity and the recipe is on the menu add a new order to the list
         *  only if enough money has been paid
         */
        else if (amountPaid >= recipe.getPrice()) {
            orders[indexNextOrderToPlace] = new Order(recipe, customerName, amountPaid, specialRequest);
            indexNextOrderToPlace++;
            return true;
        }
        else {
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
        if (indexNextOrderToServe >= orders.length)
            return null;
        Order o = orders[indexNextOrderToServe];
        if (o == null)
            return null;
        o.serve();
        indexNextOrderToServe++;
        return o;
    }
}
