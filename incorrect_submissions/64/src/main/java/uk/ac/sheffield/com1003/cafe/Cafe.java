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

    //Added in to simplify instead of continually writing new sets
    //Similar to the usage in TestCafe.java
    public String lineSet() {
        return "==========";
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
        // Implement solution to task 7 here
        int i = nRecipes - 1;
        boolean removed = false;
        while (i > 0 && !removed) { //Works as a stack as the last item is push off

            if (menu[i].getName() == recipeName && menu[i] != null) {

                menu[i] = null;
                nRecipes--;
                removed = true;
            } else {
                i--;
            }
        }
        if (menu[i] != null && !removed) {
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
        String pendingOrders = "Pending Orders:\n";
        for (int i = 0; i < indexNextOrderToPlace; i++) {
            pendingOrders += orders[i].toString();
            if (indexNextOrderToPlace - 1 != i) {
                pendingOrders += "\n";
            }
        }
        System.out.println(pendingOrders);
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
        System.out.println(this.lineSet());
        System.out.println(this.greeting());
        System.out.println("Menu");
        System.out.println(this.lineSet());
        for (int i = 0; i < nRecipes; i++) {
            System.out.println(menu[i].getName() + " - " + menu[i].getPrice());
        }
        System.out.println(this.lineSet());
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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws CafeOutOfCapacityException,
            RecipeNotFoundException {
        boolean found = false;
        int currentSet = 0;
        Recipe currentRecipe = new Recipe("Default", 0.0);
        if (indexNextOrderToPlace < orders.length) {
            while (currentSet < menu.length && found == false) {
                if (menu[currentSet].getName() == recipeName) {
                    currentRecipe = menu[currentSet];
                    found = true;
                    if (amountPaid < menu[currentSet].getPrice()) { //Done to ensure price is listened to
                        try {
                            throw new TooLittleMoneyException();
                        } catch (TooLittleMoneyException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                currentSet++;
            }
            if (currentRecipe.getName() == "Default") {
                throw new RecipeNotFoundException();
            }
            Order currentOrder = new Order(currentRecipe, customerName, amountPaid);
            orders[indexNextOrderToPlace] = currentOrder;
            indexNextOrderToPlace++;
            return true;
        } else {
            throw new CafeOutOfCapacityException();
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
     *
     * @return The updated served order, or null of there is no order to serve.
     */
    public Order serveOrder() {
        if (orders[indexNextOrderToServe] != null) {
            orders[indexNextOrderToServe].serve();
            indexNextOrderToServe++;
            return orders[indexNextOrderToServe - 1];
        } else {
            return null;
        }
    }
}
