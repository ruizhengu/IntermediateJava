package uk.ac.sheffield.com1003.cafe;


import org.aspectj.weaver.ast.Or;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.OrderNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;

import java.util.SimpleTimeZone;

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
        indexNextOrderToPlace = 0; //last
        indexNextOrderToServe = 0; //first
        nRecipes = 0;
    }

    /**
     * Returns greeting string
     *
     * @return "Welcome to <cafe name>"
     */
    public String greeting() {
        return "Welcome to " + this.getName();
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
     * @throws RecipeNotFoundException if the recipe name does not exist in the menu
     */
    public void removeRecipe(String recipeName) throws RecipeNotFoundException {
        Recipe recipeRemoval = this.findRecipe(recipeName);
        Recipe[] actualMenu = new Recipe[nRecipes - 1];
        int next = 0;
        for (int i = 0; i < nRecipes; i++) {
            if (menu[i] != null && menu[i] != recipeRemoval) {
                actualMenu[next] = menu[i];
                next++;
            }
        }
        nRecipes--;
        menu = actualMenu;
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

            if (menu[i].getName() != null) {
                System.out.print(menu[i].getName());
                System.out.print(" - ");
                System.out.println(menu[i].getPrice());
            }
        }
        System.out.println("==========");
        System.out.println("Enjoy!");
    }

    ;

    /**
     * Find a recipe in the menu given a recipe name
     *
     * @param recipeName Name of the recipe to find
     * @return The recipe found or null otherwise
     * @throws RecipeNotFoundException if the recipe name does not exist in the menu
     */
    private Recipe findRecipe(String recipeName) throws RecipeNotFoundException {
        int i = 0;
        while (i < menu.length) {
            if (menu[i] != null && menu[i].getName().equals(recipeName))
                return menu[i];
            i++;
        }
        throw new RecipeNotFoundException();
    }

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
        Recipe temp = this.findRecipe(recipeName);
        if (this.orders.length == indexNextOrderToPlace) {
            throw new CafeOutOfCapacityException();
        }
        if (temp.getPrice() > amountPaid) {
            return false;
        }
//        orders[indexNextOrderToPlace][0] = recipeName;
//        orders[indexNextOrderToPlace][1] = customerName;
//        orders[indexNextOrderToPlace][2] = String.valueOf(amountPaid);
        orders[indexNextOrderToPlace] = new Order(temp, customerName, amountPaid);
        indexNextOrderToPlace++;
        return true;
    }

    /**
     * Print a list of orders not yet served in the following format
     * Pending Orders:
     * <Output of call to {@link Order#toString()}; one pending order per line>
     */
    public void printPendingOrders() {
        System.out.println("Pending Orders:");
        StringBuffer sb = new StringBuffer();
        String lineBreak = System.getProperty("line.separator");
        for (int i = 0; i < indexNextOrderToPlace; i++) {
            sb.append(lineBreak);
            sb.append(orders[i].toString());
//            System.out.print("Order: ");
//            System.out.print(orders[i][0]);
//            System.out.print("; For: ");
//            System.out.print(orders[i][1]);
//            System.out.print("; Paid: ");
//            System.out.println(orders[i][2]);
        }
        System.out.println(sb);
    }

    /**
     * If there is an order to serve, serves it ({@link Order#serve()}) and increments {@link Cafe#indexNextOrderToServe}
     *
     * @return The updated served order, or null of there is no order to serve.
     * @throws OrderNotFoundException if the order is not found
     */
    public Order serveOrder() throws OrderNotFoundException {
        Order o = orders[indexNextOrderToServe];

//        if (orders[0][0] == null || orders[0][1] == null || orders[0][2] == null) {
//            throw new OrderNotFoundException();
//        }
//        System.out.print("Served Order: ");
//        System.out.print(orders[0][0]);
//        System.out.print(" Customer: ");
//        System.out.println(orders[0][1]);
//        System.out.print(" Paid: ");
//        System.out.println(orders[0][2]);
        indexNextOrderToPlace--;
//        for (int i = 0; i < indexNextOrderToPlace; i++) {
//            orders[i][0] = orders[i + 1][0];
//            orders[i][1] = orders[i + 1][1];
//            orders[i][2] = orders[i + 1][2];
//        }
        o.serve();
        return o;
    }

}
