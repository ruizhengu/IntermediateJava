package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;

/** Represents a cafe */

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
        boolean recipeFound = false;
        int recipeIndex = 0;
        // Iterate through all the recipes on the menu.
        for (int i = 0; i < nRecipes; i++) {
            if ((this.menu[i].getName()).equals(recipeName)) {
                recipeFound = true;
                recipeIndex = i;
            }
        }

        // Throw RecipeNotFoundException if recipeFound is false.
        if (!recipeFound) {
            throw new RecipeNotFoundException();
        } else {
            // Remove the recipe if recipeFound is true.
            nRecipes--;
            menu[recipeIndex] = null;

            // Need to then shift back elements in front by one if not the last element.
            if (recipeIndex != (this.menu.length-1)) {
                for (int i = recipeIndex+1; i < this.menu.length; i++) {
                    menu[i-1] = menu[i];
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
        // Everything after and on indexNextOrderToServe is a pending order.
        for (int pendingOrderIndex = indexNextOrderToServe; pendingOrderIndex < orders.length; pendingOrderIndex++) {
            if (orders[pendingOrderIndex] == null) {
                break;
            } else {
                System.out.println(orders[pendingOrderIndex]);
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
        for (int i = 0; i < nRecipes; i++) {
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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws
            RecipeNotFoundException, CafeOutOfCapacityException {

        // Find the Recipe object for the recipeName.
        boolean recipeFound = false;
        Recipe associatedRecipeObject = null;
        for (int i = 0; i < nRecipes; i++) {
            if ((menu[i].getName()).equals(recipeName)) {
                associatedRecipeObject = menu[i];
                recipeFound = true;
            }
        }

        // Throw RecipeNotFoundException if associated recipe object not found.
        if (!recipeFound) {
            throw new RecipeNotFoundException();
        }

        // By here, recipe would be found, check that amount paid is sufficient.
        if (amountPaid >= associatedRecipeObject.getPrice()) {
            // Minimum conditions met to place the order.
            Order newOrder = new Order(associatedRecipeObject, customerName, amountPaid);

            // Check that capacity hasn't been exceeded; throw CafeOutOfCapacityException.
            // Otherwise place the order in orders[]
            if (indexNextOrderToPlace >= orders.length) {
                throw new CafeOutOfCapacityException();
            } else {
                orders[indexNextOrderToPlace] = newOrder;
                indexNextOrderToPlace++;
            }

            // return true since recipe exists and amount paid is sufficient.
            return true;
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
        // Check that the index doesn't go past the capacity.
        if (indexNextOrderToServe >= orders.length) {
            return null;
        } else {
            // Check if there are orders to serve.
            if (orders[indexNextOrderToServe] != null) {
                Order nextOrderToServe = orders[indexNextOrderToServe];
                indexNextOrderToServe++;
                return nextOrderToServe;
            } else {
                return null;
            }
        }
    }
}
