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
     */
    public void removeRecipe(String recipeName) throws RecipeNotFoundException {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null && menu[i].getName().equals(recipeName)) {
                menu[i] = null;
                nRecipes--;
                return;
            }
        }
        throw new RecipeNotFoundException("Recipe not found: " + recipeName);

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

        //iterates over orders array from next order to serve to next order to place
        for (int i = indexNextOrderToServe; i < indexNextOrderToPlace; i++) {
            //prints out pending orders using toString method which displays order, customer name and price
                System.out.println(orders[i].toString());
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
        //print greeting from String greeting()
        System.out.println(greeting());
        System.out.println("Menu");
        System.out.println("==========");

        //loop over menu and print results
        for (Recipe recipe : this.menu) {
            //loop breaks if there are no more recipes to show
            if (recipe == null) {
                break;
            }
            //gets name and price of recipes and prints both
            System.out.println(recipe.getName() + " - " + recipe.getPrice());
        }
        System.out.println("==========");
        System.out.println("Enjoy!");
    }

    ;


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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid)
            throws RecipeNotFoundException, CafeOutOfCapacityException {
        Recipe recipe = findRecipe(recipeName);

        //if recipe is not found in the Recipe list, recipe not found exception is thrown
        if (recipe == null) {
            throw new RecipeNotFoundException("Recipe not found: " + recipeName);
        }

        //checks if the order is above the maximum capacity and throws exception if it is
        if (indexNextOrderToPlace >= this.orders.length) {
            throw new CafeOutOfCapacityException("Cafe is at maximum capacity");
        }

        //if order can be placed, adds order to pending orders ready to be served
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

        //if indexes are equal, no orders to serve and returns null value
        if (indexNextOrderToServe == indexNextOrderToPlace) {
            return null;
        }
        //order to be served is taken from the order array and calls serve() method
        //marks order as served and returns the served order
        Order serveOrder = orders[indexNextOrderToServe];
        serveOrder.serve();
        indexNextOrderToServe++;
        return serveOrder;
    }
}
