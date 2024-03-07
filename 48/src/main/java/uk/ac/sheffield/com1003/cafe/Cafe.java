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
        return "Welcome to " + this.name;
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
    public void removeRecipe(String recipeName) throws RecipeNotFoundException{
        // Implement solution to task 7 here
        Recipe toRemove = findRecipe(recipeName);
        if (toRemove == null)
            throw new RecipeNotFoundException(recipeName);
        for (int i = 0 ;i < menu.length; i++){
            if(menu[i] != null && menu[i].getName().equals(toRemove.getName())){
                menu[i] = null;
                break;
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
        //System.out.println("This is task 4");
        System.out.println("Pending Orders:");
        for (int i = indexNextOrderToServe ;i < indexNextOrderToPlace; i++)
            System.out.println(orders[i]);
            
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
        //System.out.println("Menu to come soon. For guidance, see Javadoc above and TestCafe.testPrintMenu()");
        System.out.println("==========\n" +
                            greeting() +
                         "\nMenu" +
                         "\n==========");
        int i = 0;
        Recipe[] realMenu = this.getMenu();
        for (Recipe r : realMenu) {
            if(r != null)
                System.out.println(r.getName() + " - " + r.getPrice());
        }
        System.out.println("==========\nEnjoy!");       
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
        //Test if the recipe is in the menu else throw RecipeNotFoundException
        
        Recipe orderedFood = findRecipe(recipeName);
        
        if(orderedFood == null)
            throw new RecipeNotFoundException("This recipe does not exist in our menu");

        //Test if cafe has remaining capacity else throw CafeOutOfCapacityException
        if(orders.length < 1)
            throw new CafeOutOfCapacityException("The cafe is at its maximum capacity");
        else{
            while(orders[indexNextOrderToPlace] != null)//Find index of first null item in the orders array (somewhat pointless but for safety)
                indexNextOrderToPlace++;
            if(indexNextOrderToPlace >= orders.length)
                throw new CafeOutOfCapacityException("The cafe is at its maximum capacity");
        }

        //Test order conditions and place order if conditions are true, else return false
        if(orderedFood != null && amountPaid >= orderedFood.getPrice()){
            orders[indexNextOrderToPlace] = new Order(orderedFood, customerName, amountPaid);
            indexNextOrderToPlace++;
            return true;
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
        if(orders[indexNextOrderToServe] == null)
            return null;
        return orders[indexNextOrderToServe++];

    }
}
