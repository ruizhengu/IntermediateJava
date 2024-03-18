package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;

public class Cafe {
    private String name;
    private Recipe[] menu;
    private Order[] orders;

    private int indexNextOrderToPlace = 0;
    private int indexNextOrderToServe = 0;
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
        return "Welcome to " + getName();
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
     * @return Returns true if there is space in the menu and new recipe is
     *         successfully added; false otherwise
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
        
        // Finds the recipe by name that needs to be removed
        Recipe recipeToRemove = findRecipe(recipeName);
        if(recipeToRemove == null) {
            throw new RecipeNotFoundException();
        }

        // Go through the menu and find the recipe that was specified and remove it from the menu by setting its place to null
        int i = 0;
        while (i < menu.length) {
            if (menu[i] == recipeToRemove) {
                menu[i] = null;
                nRecipes--;
            } else {
                i++;
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
        StringBuffer sb = new StringBuffer();
        String lineBreak = System.getProperty("line.separator");
        sb.append("Pending Orders:");
        int i = indexNextOrderToServe;
        while (i < orders.length && orders[i] != null) {
            sb.append(lineBreak);
            sb.append(orders[i].toString());
            i++;
        }
        System.out.println(sb);
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
    };

    /**
     * Place an order for a given recipe name with a given amount of money.
     * 
     * @param recipeName   The name of the recipe being ordered
     * @param amountPaid   Money handed when placing order
     * @param customerName Name of customer placing order
     * @return True if the recipe name exists in the menu and the amount paid is
     *         sufficcient; return false otherwise
     * @throws RecipeNotFoundException    if the recipe name does not exist in the
     *                                    menu
     * @throws CafeOutOfCapacityException if the cafe cannot take any more orders
     *                                    and is out of capacity
     */
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws CafeOutOfCapacityException, RecipeNotFoundException {
        if (indexNextOrderToPlace >= orders.length)
            throw new CafeOutOfCapacityException();

        Recipe r = findRecipe(recipeName);
        if (r == null)
            throw new RecipeNotFoundException();

        if (r.getPrice() > amountPaid)
            return false;

        orders[indexNextOrderToPlace] = new Order(r, customerName, amountPaid);
        indexNextOrderToPlace++;
        return true;
    }

    // This is an overloaded method to accomodate for a special request argument in the order class
    public boolean placeOrder(String recipeName, String customerName, double amountPaid, String specialRequest)
            throws CafeOutOfCapacityException,
            RecipeNotFoundException {

        if (indexNextOrderToPlace < orders.length) {

            // Checks if the given recipe name exists
            Recipe recipe = findRecipe(recipeName);
            if (recipe == null) {
                throw new RecipeNotFoundException();
            }

            // Check if the recipe is ready to be used in the menu by calling the Recipe class method isReady
            if (!(recipe.isReady())) {
                System.out.println("The recipe is not ready to be used yet");
                return false;
            }

            // Checks if the amount paid is correct and places an order if it is. Otherwise returns false
            if (amountPaid >= recipe.getPrice()) {
                orders[indexNextOrderToPlace] = new Order(recipe, customerName, amountPaid, specialRequest);
                indexNextOrderToPlace += 1;
                return true;
            } else {
                System.out.println("This order costs more than what was given.");
                return false;
            }
        } else {
            throw new CafeOutOfCapacityException();  // throws exception if the cafe is out of capacity for orders
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
     * If there is an order to serve, serves it ({@link Order#serve()}) and
     * increments {@link Cafe#indexNextOrderToServe}
     * 
     * @return The updated served order, or null of there is no order to serve.
     */
    public Order serveOrder() {
        if (indexNextOrderToServe >= orders.length)
            return null;
        Order o = orders[indexNextOrderToServe];
        if (o == null)
            return null;
        o.serve();
        indexNextOrderToServe++;
        return o;
    }
}
