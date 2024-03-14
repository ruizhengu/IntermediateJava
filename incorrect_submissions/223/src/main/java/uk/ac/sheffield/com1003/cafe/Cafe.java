package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.Order;


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
     *
     * @return "Welcome to <cafe name>"
     */
    public String greeting() {
        return "Welcome to " + this.name;
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
        try {
            boolean recipeFound = false;
            Recipe recipe = findRecipe(recipeName);
            if (recipe == null) {
                throw new RecipeNotFoundException();// if findRecipe returns null it doesnt exist
            }
            int i = 0;
            while (i < menu.length && recipeFound == false) {//finding what the index of the recipe is
                if (menu[i] == recipe) {
                    menu[i] = null; //setting that recipe to null
                    nRecipes -= 1;
                    System.out.println("Recipe deleted: " + recipeName);
                    recipeFound = true; //stops the search
                } else {
                    i++;
                }
            }
        } catch (RecipeNotFoundException e) {
            System.out.println(e.getMessage());
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
        if (orders.length != 0) { //doesnt run if cafe capacity is 0
            for (int i = 0; i <= orders.length - 1; i++) {
                if (orders[i] != null) {//doesnt run if any orders are null (no orders left)
                    System.out.println(orders[i].toString());
                }
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
        menu = getMenu();
        for (int i = 0; i <= menu.length - 1; i++) {
            System.out.println(menu[i].getName() + " - " + menu[i].getPrice());
        }
        System.out.println("==========");
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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException, CafeOutOfCapacityException {

        //testing item exists
        menu = getMenu();
        boolean itemFound = false;
        if (orders.length == 0 || orders[orders.length - 1] != null) { //cafe full if final order is full in capacity
            throw new CafeOutOfCapacityException();
        } else {
            for (int i = 0; i <= menu.length - 1; i++) {
                if (recipeName == menu[i].getName()) { //finding the item in the menu
                    itemFound = true;
                    if (amountPaid >= menu[i].getPrice() && indexNextOrderToPlace != 100) { //checking they paid the correct amount
                        orders[indexNextOrderToPlace] = new Order(findRecipe(recipeName), customerName, amountPaid); //placing order
                        indexNextOrderToPlace += 1;//next order gets placed in next index
                        return true;
                    } else {
                        return false; //order doesnt exist
                    }
                }
            }
            if (itemFound == false) {
                throw new RecipeNotFoundException();
            }
        }
        return false;//if no return by now its not valid

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
        if (indexNextOrderToPlace != 0 && orders[indexNextOrderToServe] != null && indexNextOrderToServe != 100) { //index of placing order is always higher than serving
            orders[indexNextOrderToServe].serve();//serves the order
            indexNextOrderToServe += 1;//indexes for next order
            return orders[indexNextOrderToServe - 1];

        } else {
            return null;
        }
    }
}
