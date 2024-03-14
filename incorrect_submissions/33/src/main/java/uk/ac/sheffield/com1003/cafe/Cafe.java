package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;

public class Cafe {
    private String name;
    private static Recipe[] menu;
    private Order[] orders;

    private int indexNextOrderToPlace;
    private int indexNextOrderToServe;
    private static int nRecipes;

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
        return "TBC";
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
     * @param recipe Recipe to be added to menu
     * @return Returns true if there is space in the menu and new recipe is successfully added; false otherwise
     */
    public boolean addRecipe(Recipe recipe) {
        System.out.println("==================");
        System.out.println("Welcome to our cafe!");
        System.out.println("Here is our menu:");
        for (int i = 0; i < Recipe.length; ) {
            System.out.println(recipe.getName() + " - " + recipe.getPrice());
            return true;
        }
        System.out.println("==================");
        System.out.println("Enjoy!");
        System.out.println("Error: Menu is full. Recipe " + recipe.getName() + " not added.");
        return false;
    }

    /**
     * Find recipe with given name and remove it from the menu.
     * Assumes there are no duplicated recipe names.
     *
     * @param recipeName Name of the recipe to be removed
     */
    public void removeRecipe(String recipeName) throws RecipeNotFoundException {
        boolean found = false;
        for (int i = 0; i < indexNextOrderToPlace; i++) {
            if (equals(recipeName)) {
                found = true;
                // Shift all elements to the left, overwriting the deleted recipe
                for (int j = i; j < indexNextOrderToPlace - 1; j++) {
                    orders[j] = orders[j + 1];
                }
                // Decrement the number of recipes
                indexNextOrderToPlace--;
                break;
            }
        }
        throw new RecipeNotFoundException();
    }


    /**
     * Returns the current list of recipes in the menu excluding empty/null elements
     *
     * @return Array of recipes contained in the menu (excluding nulls)
     */
    public static Recipe[] getMenu() {
        Recipe[] actualMenu = new Recipe[nRecipes];
        int next = 0;
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                actualMenu[next] = menu[i];
                next++;
                return actualMenu;
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
        if (indexNextOrderToServe == indexNextOrderToPlace) {
            System.out.println("No pending orders.");
            return;
        }
        System.out.println("Pending orders:");
        for (int i = indexNextOrderToServe; i < indexNextOrderToPlace; i++) {
            System.out.println("Order #" + (i + 1) + ": " + orders[i].getRecipe().getName());
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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) {
        return false;
    }

    /**
     * Find a recipe in the menu given a recipe name
     *
     * @param recipeName Name of the recipe to find
     * @return The recipe found or null otherwise
     */
    static Recipe findRecipe(String recipeName) {
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
        return null;
    }

    public static Recipe addRecipe(String string) {
        return addRecipe(string);
    }

    public void printMenu() {
        StringBuffer sb = new StringBuffer();
        String lineBreak = System.getProperty("line.separator");
        String sectionSep = "==========" + lineBreak;
        sb.append(sectionSep);
        sb.append(greeting());
        sb.append(lineBreak);
        sb.append("Menu");
        sb.append(lineBreak);
        sb.append(sectionSep);
        for (Recipe recipe : menu) {
            if (recipe != null) {
                sb.append(recipe.getName());
                sb.append(" - ");
                sb.append(recipe.getPrice());
                sb.append(lineBreak);
            }
        }
        sb.append(sectionSep);
        sb.append("Enjoy!");
        System.out.println(sb);
    }

}
