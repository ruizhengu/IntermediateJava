package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

import java.util.Objects;

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
        return "Welcome to Central Perk";
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
        int i = 0;
        //Check all recipes
        while (i < nRecipes) {
            //If wanted recipe is found make it's index equal to null
            if (menu[i] != null && menu[i].getName().equals(recipeName)) {
                menu[i] = null;
                nRecipes--;
                //Shift down by one each recipe following the wanted recipe
                //This will remove any gaps from the menu array
                while (i < nRecipes) {
                    menu[i] = menu[i + 1];
                    i++;
                }
                //Remove the last duplicate array
                menu[i] = null;
            }
            i++;
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
        int numberOfPendingOrders = indexNextOrderToPlace - indexNextOrderToServe;
        if (0 < numberOfPendingOrders) {
            System.out.println("Pending Orders:");
            //prints the not served orders
            for (int i = 0; i < numberOfPendingOrders; i++) {
                System.out.println(orders[indexNextOrderToPlace - 1 - i].toString());
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
        for (int i = 0; i < getMenu().length; i++) {
            System.out.println(getMenu()[i].getName() + " - " + getMenu()[i].getPrice());
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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws
            RecipeNotFoundException, CafeOutOfCapacityException {

        //Declare variables
        int maxOrders = this.orders.length;
        Recipe recipeProvided = findRecipe(recipeName);
        boolean isRecipeInMenu = recipeProvided != null;
        //throw exceptions
        if (maxOrders <= indexNextOrderToPlace)
            throw new CafeOutOfCapacityException();
        if (!isRecipeInMenu)
            throw new RecipeNotFoundException();

        boolean isThereSufficientPay = (recipeProvided.getPrice() <= amountPaid);
        //Return false if order can't be processed
        if (!isRecipeInMenu || !isThereSufficientPay)
            return false;

        //Process order
        orders[indexNextOrderToPlace] = new Order(recipeProvided, customerName, amountPaid);
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
     *
     * @return The updated served order, or null of there is no order to serve.
     */
    public Order serveOrder() {
        Order orderToServe = orders[indexNextOrderToServe];
        //return and serve order if there's an order to serve
        if (orderToServe != null)
            orderToServe.serve();
        indexNextOrderToServe++;
        return orderToServe;
    }
}
