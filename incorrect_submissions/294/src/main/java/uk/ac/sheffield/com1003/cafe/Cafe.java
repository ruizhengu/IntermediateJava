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
        
        // Initialize a flag variable to keep track of whether a recipe was removed
        boolean removedRecipe = false;

        // Loop through the menu array to find the recipe with the given name
        for (int i = 0; i < menu.length; i++) {

            // If a recipe with the given name is found, set the removed flag to true, remove the recipe from the menu, and break out of the loop
            if (menu[i] != null && menu[i].getName().equals(recipeName)) {
                removedRecipe = true;
                menu[i] = null;
                break;
            }
        }

        // If no recipe was removed, throw a RecipeNotFoundException
        if (!removedRecipe) {
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
        System.out.println("Pending Orders:");

        // Loop through the orders array to find pending orders
        for (int j = 0; j< orders.length; j++){

            // If the current order is not null, print its string representation using the toString() method
            if (orders[j] != null){
                System.out.println(orders[j].toString());
            } else {

                // If the current order is null, break out of the loop
                break;
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
        System.out.println(this.greeting());
        System.out.println("Menu");
        System.out.println("==========");

        // Get the menu array using the getMenu() method
        Recipe[] menu = this.getMenu();

        // Loop through the menu array and print the name and price of each recipe
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                System.out.print(menu[i].getName() + " - " );
                System.out.print(menu[i].getPrice());
                System.out.println();
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


    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException, CafeOutOfCapacityException {

        // Check if the recipe name exists in the menu
        Recipe recipe = findRecipe(recipeName);

        if (recipe != null && amountPaid >= recipe.getPrice()) {

            // Check if the cafe has reached its maximum capacity for orders
            if (indexNextOrderToPlace >= orders.length) {
                throw new CafeOutOfCapacityException();
            }
            // Place the order in the orders array at the appropriate index
            orders[indexNextOrderToPlace] = new Order(recipe, customerName, amountPaid);
            // Increment indexNextOrderToPlace for the next order
            indexNextOrderToPlace++;
            return true;
        } else {
            if (recipe == null) {
                throw new RecipeNotFoundException();
            }
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
     * @return The updated served order, or null if there is no order to serve.
     */
    public Order serveOrder() {

        // Check if there are any orders to serve
        if (indexNextOrderToServe >= indexNextOrderToPlace) {

            // no orders to serve
            return null;
        }

        // Get the next order to serve
        Order order = orders[indexNextOrderToServe];
        order.serve();

        // Increment the index for the next order to serve
        indexNextOrderToServe++;


        // Return the served order
        return order;
    }
}
