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
    public String greeting() {return ("Welcome to " + this.name); }

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

    public void removeRecipe(String recipeName) throws RecipeNotFoundException {
        int i = 0;
        while (i < menu.length) {
            if (menu[i] != null && menu[i].getName().equals(recipeName)) {
                nRecipes--;
                menu[i] = null;
                return;
            } else
                i++;
        }
        throw new RecipeNotFoundException();
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

    public void printPendingOrders() {
        /**
         * Iterates through a list of pending orders
         * Outputs each order.toString, one per line
         */
        System.out.println("Pending Orders:");
        for(int x = indexNextOrderToServe;x<indexNextOrderToPlace;x++){
            System.out.println(orders[x].toString());
        }
    }



    public void printMenu() {
        /**
         * Calls and frames the greeting function
         * Iterates through each menu item using a list of recipes generated using the getMenu function and a for loop
         * Prints the Name and Price attributes seperated by a hyphen
         */
        System.out.println("==========");
        System.out.println(greeting());
        System.out.println("Menu");
        System.out.println("==========");
        Recipe realMenu[] = this.getMenu();
        for(int x = 0;x<realMenu.length;x++){
            System.out.println(realMenu[x].getName() + " - " + realMenu[x].getPrice());
        }
        System.out.println("==========");
        System.out.println("Enjoy!");
    };

    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException, CafeOutOfCapacityException {
        /**
         * Constructs a menu
         * Iterates through each recipe to check if the requested order is in the list
         * If not in list RecipeNotFoundException is thrown
         * Next checks if the cafe is at capacity if so a CafeOutOfCapacity Exception is thrown
         * If not the Order is made and placed and the index is incremented
         *
         */
        Recipe[] actualMenu = getMenu();
        for(int x = 0;x<actualMenu.length;x++) {
            if (recipeName == actualMenu[x].getName()) {
                if (orders.length <= indexNextOrderToPlace) throw new CafeOutOfCapacityException();
                else {
                    Order thisOrder = new Order(findRecipe(recipeName), customerName, amountPaid);
                    orders[indexNextOrderToPlace] = thisOrder;
                    indexNextOrderToPlace += 1;
                    return true;
                }
            }
        }
        throw new RecipeNotFoundException();
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

    public Order serveOrder() {
        /**
         * Checks if there are pending orders
         * Serves next order ,increments order and returns updated served order
         */
        if(indexNextOrderToServe < indexNextOrderToPlace) {
            orders[indexNextOrderToServe].serve();
            indexNextOrderToServe += 1;
            return orders[indexNextOrderToServe-1];
        }
        else{
            return null;
        }
    }
}
