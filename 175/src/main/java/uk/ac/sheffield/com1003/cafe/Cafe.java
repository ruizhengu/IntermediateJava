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
    private static final int CAPACITY = 100;

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
     */
    public void removeRecipe(String recipeName) throws RecipeNotFoundException {
        Recipe recipeToRemove = null;
        int recipeToRemoveIndex = 0;
        for (int i=0; i< menu.length; i++) {
            // check if given recipe name corresponds with item in menu array
            if (menu[i].getName().equals(recipeName)) {
                // assign menu item to recipeToRemove variable, then immediately break out of loop
                recipeToRemove = menu[i];
                recipeToRemoveIndex = i;
                break;
            }
        }
        if (recipeToRemove == null) {
            throw new RecipeNotFoundException("Recipe not found: " + recipeName);
        }
        // remove menu item from array, then decrement index of other array items by one
        for (int i=0; i< menu.length-1; i++) {
            if (menu[i] == recipeToRemove) {
                for (int j=i; j<menu.length-1; j++) {
                    menu[j] = menu[j+1];
                }
                menu[menu.length-1] = null;
                break;
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
        System.out.println("Pending Orders: ");
        // iterate over orders that have not been served yet
        for (int i = indexNextOrderToPlace; i<indexNextOrderToServe; i++) {
            // print order details using toString method
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
        System.out.println(greeting());
        System.out.println("Menu");
        System.out.println("==========");
        Recipe[] menuItems = getMenu();
        for (int i=0; i< getMenu().length; i++) {
            System.out.println(menuItems[i].getName() + " - " + menuItems[i].getPrice());
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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException, CafeOutOfCapacityException {
        Cafe cafe = new Cafe();
        Recipe recipe = cafe.findRecipe(recipeName);
        // exceptions handled
        if (recipe == null) {
            throw new RecipeNotFoundException("Recipe not found: " + recipeName);
        }
        if (indexNextOrderToPlace >= CAPACITY) {
            throw new CafeOutOfCapacityException("The Cafe is experiencing a high volume of orders. Please wait. ");
        }
        // new instance of 'Order' created,
        Order customerOrder = new Order(recipe, customerName, amountPaid);
        //add customerOrder to orders array
         orders[indexNextOrderToPlace] = customerOrder;
         // increment the next order index by one
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
        // check if there are any outstanding orders to serve, return null if not
        if (indexNextOrderToServe >= indexNextOrderToPlace) {
            return null;
        }
        Order nextOrderToServe = orders[indexNextOrderToServe];
        nextOrderToServe.serve();
        indexNextOrderToServe++;
        return nextOrderToServe;
    }
}
