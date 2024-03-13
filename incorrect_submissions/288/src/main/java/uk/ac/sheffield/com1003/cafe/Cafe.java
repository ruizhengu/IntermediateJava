package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;

/**
 * A class representing a cafe, with a menu of recipes and orders placed by customers.
 */
public class Cafe {
    private String name;
    private Recipe[] menu;
    private Order[] orders;

    private int indexNextOrderToPlace;
    private int indexNextOrderToServe;
    private int nRecipes;
    private int nOrders;

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
        nOrders = 0;
    }

    /**
     * Returns greeting string
     *
     * @return "Welcome to <cafe name>"
     */
    public String greeting() {
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
        if (nRecipes >= menu.length) {
            return false;
        }
        menu[nRecipes] = newRecipe;
        nRecipes++;
        return true;
    }

    /**
     * Find recipe with given name and remove it from the menu.
     * Assumes there are no duplicated recipe names.
     *
     * @param recipeName Name of the recipe to be removed
     * @throws RecipeNotFoundException if the recipe with the given name is not found
     */
    public void removeRecipe(String recipeName) throws RecipeNotFoundException {
        // Loop through the menu array to find the recipe with the given name
        for (int i = 0; i < nRecipes; i++) {
            if (menu[i].getName().equals(recipeName)) {
                // If the recipe is found, shift all subsequent elements one index to the left
                for (int j = i; j < nRecipes - 1; j++) {
                    menu[j] = menu[j + 1];
                }
                // Set the last element to null and decrement the number of recipes
                menu[nRecipes - 1] = null;
                nRecipes--;
                return;
            }
        }
        // If the recipe is not found, throw a RecipeNotFoundException with an appropriate error message
        throw new RecipeNotFoundException("Recipe with name " + recipeName + " not found.");
    }

    /**
     * Returns the current list of recipes in the menu excluding empty/null elements
     *
     * @return Array of recipes contained in the menu (excluding nulls)
     */
    public Recipe[] getMenu() {
        Recipe[] actualMenu = new Recipe[nRecipes];
        for (int i = 0; i < nRecipes; i++) {
            actualMenu[i] = menu[i];
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
        // iterate through the orders from the index of the next order to serve to the index of the next order to place
        for (int i = indexNextOrderToServe; i < indexNextOrderToPlace; i++) {
            if (orders[i] != null) {
                // print the string representation of the order
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
        Recipe recipe = findRecipe(recipeName);
        if (recipe == null) {
            throw new RecipeNotFoundException("Recipe not found: " + recipeName);
        }
        if (indexNextOrderToPlace == orders.length) {
            throw new CafeOutOfCapacityException("Cafe out of capacity");
        }
        Order order = new Order(recipe, customerName, amountPaid);
        orders[indexNextOrderToPlace] = order;
        indexNextOrderToPlace++;
        return true;
    }

    /**
     * Find a recipe in the menu given a recipe name
     *
     * @param recipeName Name of the recipe to find
     * @return The recipe found or null otherwise
     */
    private Recipe findRecipe(String recipeName) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null && menu[i].getName().equals(recipeName))
                return menu[i];
        }
        return null;
    }

    /**
     * If there is an order to serve, serves it ({@link Order#serve()}) and increments {@link Cafe#indexNextOrderToServe}
     * @return The updated served order, or null of there is no order to serve.
     */
    public Order serveOrder() {
        if (indexNextOrderToServe == indexNextOrderToPlace) {
            return null;
        }
        Order order = orders[indexNextOrderToServe];
        order.serve();
        indexNextOrderToServe++;
        return order;
    }
}

