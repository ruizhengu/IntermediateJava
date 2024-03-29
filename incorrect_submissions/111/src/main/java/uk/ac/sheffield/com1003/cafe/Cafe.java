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
        return "Welcome to " + getName();
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
        // Check if recipe exists
        Recipe foundRecipe = findRecipe(recipeName);

        if (foundRecipe == null) {
            // Recipe not found, so return RecipeNotFoundError
            throw new RecipeNotFoundException();
        } else {
            // Recipe found and so delete from menu by looping over every item, and setting the one we are looking for
            // to null
            int menuIndex = 0;
            int foundMenuItemIndex = 0;

            // Loop over menu items until we find the item index
            for (Recipe menuItem : this.menu) {
                if (menuItem != null) {
                    if (menuItem.getName().equals(recipeName)) {
                        // We have found the menu item index
                        foundMenuItemIndex = menuIndex;
                    }
                }
                menuIndex++;
            }

            // Set the recipe to null to delete from array
            this.menu[foundMenuItemIndex] = null;
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
        for (int orderNumber = indexNextOrderToServe; orderNumber < indexNextOrderToPlace; orderNumber++)
            System.out.println(orders[orderNumber]);
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
        // Output out greeting
        System.out.println("==========");
        System.out.println(greeting());
        System.out.println("Menu");
        System.out.println("==========");

        // Output menu items and "Enjoy!"
        Recipe[] menu = getMenu();
        for (Recipe recipe : menu) {
            if (recipe != null) {
                System.out.print(recipe.getName());
                System.out.print(" - ");
                System.out.println(recipe.getPrice());
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
     * @return True if the recipe name exists in the menu and the amount paid is sufficient; return false otherwise
     * @throws RecipeNotFoundException if the recipe name does not exist in the menu
     * @throws CafeOutOfCapacityException if the cafe cannot take any more orders and is out of capacity
     */
    public boolean placeOrder(String recipeName, String customerName, double amountPaid)
            throws RecipeNotFoundException, CafeOutOfCapacityException {
        // Check if recipe exists, if not throw RecipeNotFoundException
        Recipe foundRecipe = findRecipe(recipeName);
        if (foundRecipe == null)
            throw new RecipeNotFoundException();

        // Check if the cafe is full, if it is then throw CafeOutOfCapacityException
        if (indexNextOrderToPlace == orders.length)
            throw new CafeOutOfCapacityException();

        // Check if amountPaid is correct, if so return True else return False
        if (foundRecipe.getPrice() <= amountPaid) {
            orders[indexNextOrderToPlace] = new Order(foundRecipe, customerName, amountPaid);
            indexNextOrderToPlace++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Place an order for a given recipe name with a given amount of money.
     *
     * @param recipeName The name of the recipe being ordered
     * @param amountPaid Money handed when placing order
     * @param customerName Name of customer placing order
     * @param specialRequest The text of the special request, e.g., "extra shot"
     * @return True if the recipe name exists in the menu and the amount paid is sufficient; return false otherwise
     * @throws RecipeNotFoundException if the recipe name does not exist in the menu
     * @throws CafeOutOfCapacityException if the cafe cannot take any more orders and is out of capacity
     */
    public boolean placeOrder(String recipeName, String customerName, double amountPaid, String specialRequest)
            throws RecipeNotFoundException, CafeOutOfCapacityException {
        // Check if recipe exists, if not throw RecipeNotFoundException
        Recipe foundRecipe = findRecipe(recipeName);
        if (foundRecipe == null)
            throw new RecipeNotFoundException();

        // Check if the cafe is full, if it is then throw CafeOutOfCapacityException
        if (indexNextOrderToPlace == orders.length)
            throw new CafeOutOfCapacityException();

        // Check if amountPaid is correct, if so return True else return False
        if (foundRecipe.getPrice() <= amountPaid) {
            orders[indexNextOrderToPlace] = new Order(foundRecipe, customerName, amountPaid, specialRequest);
            indexNextOrderToPlace++;
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
        if (indexNextOrderToServe == indexNextOrderToPlace)
            // No order in queue
            return null;
        else if (indexNextOrderToServe >= orders.length) {
            // There are more orders than the length of the queue, so return null as this can't happen
            return null;
        } else {
            // There is an order available, print the order, increase indexNextOrderToServer and return the order served
            System.out.println(orders[indexNextOrderToServe]);
            indexNextOrderToServe++;
            return orders[indexNextOrderToServe-1];
        }
    }
}
