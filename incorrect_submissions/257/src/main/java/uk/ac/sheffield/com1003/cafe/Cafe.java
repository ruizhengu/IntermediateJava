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
        //convert the string parameter taken in, into a Recipe object
        Recipe recipeToRemove = findRecipe(recipeName);
        if (recipeToRemove != null) {
            //iterate through the menu array, so that if the recipe to remove is found, change its value to a null
            for(int i = 0; i< menu.length; i++) {
                if (menu[i] == recipeToRemove) {
                    System.out.println("Removing recipe: ");
                    System.out.println(menu[i] + " is removed");
                    menu[i] = null;
                }
            }
        } else {
            throw new RecipeNotFoundException("Sorry! Recipe is not found.");
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
        for (int i=indexNextOrderToServe; i < orders.length; i++) {
            //if order has not been served, and is not null, then print it out
            if (orders[i] != null) {
                System.out.println(orders[i]);
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
        //iterate through each element in the menu array and print out the non-null values
        for (Recipe recipe: getMenu()) {
            if (recipe != null) {
                System.out.println(recipe);
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
     * @return True if the recipe name exists in the menu and the amount paid is sufficcient; return false otherwise
     * @throws RecipeNotFoundException if the recipe name does not exist in the menu
     * @throws CafeOutOfCapacityException if the cafe cannot take any more orders and is out of capacity
     */
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException,
                                                                                            CafeOutOfCapacityException{
        //place order will only work if there is at least 1 recipe in the menu
        if (nRecipes >= 1)  {
            if (indexNextOrderToPlace >= orders.length) {
                throw new CafeOutOfCapacityException("Sorry! Cafe is out of capacity.");
            }
            //if recipe is found (not null) and amount paid is more than the price, Order object is created
            if (findRecipe(recipeName) != null) {
                if (amountPaid >= findRecipe(recipeName).getPrice()) {
                    Order order = new Order(findRecipe(recipeName), customerName, amountPaid);
                    //the Order object that was created, is stored in an Order array
                    orders[indexNextOrderToPlace] = order;
                    indexNextOrderToPlace++;
                    return true;
                } else {
                    System.out.println("Sorry! Price of drink is more than the amount paid.");
                }
            } else {
                throw new RecipeNotFoundException("Sorry! Recipe is not found.");
            }
        } else {
            System.out.println("No recipes in the menu. Cafe is not ready to serve.");
        }
        return false;
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
        /*if an order is placed, its indexNextOrderToPlace will be higher. When this is the case, increment the
        indexNextOrderToServe and return the updated served order*/
        if (indexNextOrderToServe < indexNextOrderToPlace) {
            orders[indexNextOrderToServe].serve();
            indexNextOrderToServe++;
            return orders[indexNextOrderToServe-1];
        } else {
            System.out.println("Sorry! No orders to serve.");
        }
        return null;
    }
}
