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
    public Cafe(String name, int sizeMenu, int orderCapacity){
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
        String cafeName = this.getName();
        return ("Welcome to " + cafeName);
    }

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
    public void removeRecipe(String recipeName) throws RecipeNotFoundException{
        boolean found = false;

        /* if the menu item is not null and matches the name of the item we want to delete, set it to null and
        decrement the number of recipes */
        for (int i = 0; i < this.menu.length; i++) {
            if ((menu[i] != null) && (menu[i].getName() == recipeName)) {
                menu[i] = null;
                found = true;
                nRecipes --;
            }
        }
        /* throw an exception if we couldn't find the recipe */
        if (!found) {throw new RecipeNotFoundException();}
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
        /* prints all the orders in the order array between the next order to serve and the last order placed */
        System.out.println("Pending Orders:");
        for (int i = indexNextOrderToServe; i < indexNextOrderToPlace; i++) {
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

        Recipe[] actualMenu = this.getMenu();
        for (int i = 0; i < actualMenu.length; i++) {
            /* because the getMenu() method already checks if menu items are null, we don't need to do this here */
            System.out.println(actualMenu[i].getName() + " - " + actualMenu[i].getPrice());
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
            CafeOutOfCapacityException, RecipeNotFoundException{

        /* checks if the cafe is out of order capacity */
        if (indexNextOrderToPlace >= orders.length) {
            throw new CafeOutOfCapacityException();
        }

        Recipe[] actualMenu = this.getMenu();

        boolean isOnMenu = false;
        int recipeIndex = -1;
        /*checks if the recipe is on the menu, if so records the index of it in the array */
        for (int i = 0; i < actualMenu.length; i++) {
            if (recipeName == actualMenu[i].getName()) {
                isOnMenu = true;
                recipeIndex = i;
            }
        }

        /* throws an exception if the recipe couldn't be found */
        if (isOnMenu = false) { throw new RecipeNotFoundException(); }
        /* returns false if the amount paid is less than the price */
        if (amountPaid < actualMenu[recipeIndex].getPrice()) { return false; }

        /* adds the order to the order array */
        Order currentOrder = new Order(actualMenu[recipeIndex], customerName, amountPaid);
        orders[indexNextOrderToPlace] = currentOrder;
        indexNextOrderToPlace += 1;
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
        /* if there are any orders to serve, it serves the first one and returns it */
        if (indexNextOrderToServe < indexNextOrderToPlace) {
            indexNextOrderToServe += 1;
            orders[indexNextOrderToServe-1].serve();
            return orders[indexNextOrderToServe-1];
        }
        else {return null;}
    }
}
