package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;

/**
 * Class that represents a cafe having a menu of recipes and a list of orders.
 * @author github-classroom
 */
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
        return "Welcome to " + this.name;
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
        // Implement solution to task 7 here
        // Find recipe to remove
        Recipe recipeToRemove = findRecipe(recipeName);
        if (recipeToRemove == null) {
            // if recipe is not found, throw exception
            throw new RecipeNotFoundException();
        }

        // Remove recipe from menu
        int indexOfRemova = -1;
        boolean removed = false;
        for(int i = 0; i <menu.length; i++){
            if(menu[i] == recipeToRemove){
                menu[i] = null;
                indexOfRemova = i;
                nRecipes--;
                removed = true;
            }
        }

        // if recipe is found, shift all recipes down one
        if(removed){
            for(int i = indexOfRemova; i < menu.length - 1; i++){
                menu[i] = menu[i + 1];
            }
            menu[menu.length - 1] = null;
        }

        // change the size of menu array to nRecipes
        Recipe[] newMenu = new Recipe[nRecipes];
        System.arraycopy(menu, 0, newMenu, 0, nRecipes);
        menu = newMenu;

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
        // Loop through the orders array from the next order to serve to the next order to place
        for(int i = indexNextOrderToServe; i < indexNextOrderToPlace; i++){

            // Print the details of each pending order
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
        System.out.println(this.greeting());
        System.out.println("Menu");
        System.out.println("==========");
        for (Recipe recipe : this.getMenu()) {
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
     * @return True if the recipe name exists in the menu and the amount paid is sufficcient; return false otherwise
     * @throws RecipeNotFoundException if the recipe name does not exist in the menu
     * @throws CafeOutOfCapacityException if the cafe cannot take any more orders and is out of capacity
     */
    public boolean placeOrder(String recipeName, String customerName, double amountPaid)
            throws RecipeNotFoundException, CafeOutOfCapacityException {
        // Find the recipe in the menu
        Recipe recipeBeenFound = findRecipe(recipeName);
        if (recipeBeenFound == null) {
            throw new RecipeNotFoundException();
        }

        // Check if the customer has paid enough for the recipe
        if (amountPaid < recipeBeenFound.getPrice()) {

            return false;
        }

        // Check if the cafe has capacity for the order
        if (indexNextOrderToPlace >= orders.length) {
            throw new CafeOutOfCapacityException();
        }

        // Create a new order and add it to the orders array
        Order order = new Order(recipeBeenFound, customerName, amountPaid);
        orders[indexNextOrderToPlace++] = order;
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
        // Check if there is an order to serve
        if(indexNextOrderToServe < indexNextOrderToPlace){

            // Get the order to serve
            Order order = orders[indexNextOrderToServe];

            // Serve the order and increment the index for the next order to serve
            order.serve();
            indexNextOrderToServe++;

            // Return the served order
            return order;
        }

        // Return null if there are no orders to serve
        return null;
    }
}
