package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;

    /**
     * Class that manages a café's menu, orders and other features (e.g., greeting).
     * @author milan
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
        return ("Welcome to " + getName());
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
                System.out.println(newRecipe.getName() + " has been added to menu.");
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
        int currentIndex = 0;
        for (Recipe rec : menu) {
            currentIndex++;
            if (rec.getName() == recipeName) {
                recipeFound = true;
                ArrayList<Recipe> listMenu = new ArrayList<Recipe>(Arrays.asList(menu)); //convert menu into ArrayList
                listMenu.remove(currentIndex);
                Recipe[] newMenu = new Recipe[listMenu.size()];
                newMenu = listMenu.toArray(newMenu); //copy all elements from listMenu into newMenu
                System.arraycopy(newMenu, 0, menu, 0, newMenu.length);
                //replace all elements in menu with the elements of newMenu
                System.out.println(recipeName + " has been removed from the menu.");
            }
        }
        if (!recipeFound) {
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
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null) {
                System.out.println(orders[i].toString());
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
        Recipe[] theMenu = getMenu();
        System.out.println("==========");
        System.out.println(greeting());
        System.out.println("Menu");
        System.out.println("==========");
        for (Recipe rec : theMenu) {
            System.out.println(rec.getName() + " - " + rec.getPrice());
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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException,
            CafeOutOfCapacityException {

        boolean recipeFound = false;
        if (indexNextOrderToPlace + 1 > orders.length) { // checks if maximum order count reached
            throw new CafeOutOfCapacityException();
        } else {
            for (int i = 0; i < orders.length; i++) {
                if ((menu[i].getName() == recipeName) && (menu[i].getPrice() <= amountPaid) && (menu[i] != null)) {
                    Order newOrder = new Order(menu[i], customerName, amountPaid);
                    orders[indexNextOrderToPlace] = newOrder;
                    System.out.println("Order #" + indexNextOrderToPlace + " has been placed for " + recipeName);
                    indexNextOrderToPlace++;
                    return true;
                }
            }
            if (!recipeFound) {
                throw new RecipeNotFoundException();
            }
        }
        return false;
    }


    public void checkMenuSize() {
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
        indexNextOrderToServe += 1;
            if (orders[indexNextOrderToServe] != null) {
                orders[indexNextOrderToServe].serve();
                System.out.println(orders[indexNextOrderToServe] + " has been served.");
                return orders[indexNextOrderToServe];
            } else {
                indexNextOrderToServe -= 1;
                return null;
            }
    }
}
