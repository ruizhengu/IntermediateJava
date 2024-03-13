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
        return ("Welcome to "+getName());
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
        // Implement solution to task 7 here
        boolean recipeExists = false;
        int counter = -1;
        for(Recipe i : menu){ //iterate through menu to find if recipe exists
            counter++;
            if(recipeName.equals(i.getName())) {
                menu[counter] = null; //replace the recipe on the menu with null
                recipeExists = true;
                break;
            }
        }
        if(recipeExists == false){
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
       for(Order next : orders){
            if(next != null) {
                System.out.println(next.toString());
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
        System.out.println("Menu\n" +
                "==========");
        Recipe[] items = getMenu();
        for(Recipe i : items){
            System.out.println(i.getName()+" - "+i.getPrice());
        }
        System.out.println("==========\n"+"Enjoy!");

    }


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
        int recipeNO = -1;
        int nameExist = -1;//initialise variable to keep track if recipe name is in menu
        double actualPrice = 0;
        Recipe[] items = getMenu();
        for(Recipe i : items){
            recipeNO ++;
            if(i.getName().equals(recipeName)) {
                actualPrice = i.getPrice(); //gets price of specific recipe
                nameExist++;
               break;
            }
        }
        if(indexNextOrderToPlace >= orders.length){//throws CafeOutOfCapacityException
            throw new CafeOutOfCapacityException();
        }
        if(recipeNO != -1){ //adding the order object to the array if it is correct
            Order currentOrder = new Order(items[recipeNO],customerName,amountPaid);
            orders[indexNextOrderToPlace] = currentOrder;
        }

        if(nameExist == -1){ //throws RecipeNotFoundException
            throw new RecipeNotFoundException();
        }
        else if((nameExist != -1)&&(actualPrice <= amountPaid)){
            indexNextOrderToPlace ++;
            return true;
        }
        else{
            indexNextOrderToPlace ++;
            return false;
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
     * If there is an order to serve, serves it ({@link Order#serve()}) and increments {@link Cafe#indexNextOrderToServe}
     * @return The updated served order, or null of there is no order to serve.
     */
    public Order serveOrder() {
        if(orders.length > 0){ //iterates through orders array if orders exist
            orders[indexNextOrderToServe].serve(); //calls serve method for every order
            indexNextOrderToServe ++; //index counter is incremented for next order
            return orders[indexNextOrderToServe-1];//comment
        }
        else {
            return null;
        }
    }

}
