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
    public void removeRecipe(String recipeName) throws RecipeNotFoundException{
        // Implement solution to task 7 here
        if (findRecipe(recipeName) == null){
            throw new RecipeNotFoundException();
        }

        //Code to find the index of the recipe we want to delete
        int index = 0;
        for (int i=0; i < menu.length; i++){
            if(menu[i].equals(findRecipe(recipeName))){
                index = i;
                break;
            }
        }

        //Overwriting the code by shifting the array
        for (int i = index; i< menu.length; i++){

            if (i == menu.length-1){
                menu[menu.length-1] = null;
                break;
            }
            else
                menu[i] = menu[i+1];

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

        for (int i = indexNextOrderToServe; i<indexNextOrderToPlace; i++){
            System.out.println("Pending Orders:");
            System.out.println(orders[i].toString());
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

        Recipe[] menuArray = getMenu();
        for(int i=0; i< menuArray.length; i++){
            if (menuArray[i] != null)
            System.out.println(menuArray[i].getName() + " - " + menuArray[i].getPrice());
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

        //code to throw an exception if cafe is at capacity
        if (indexNextOrderToPlace > orders.length-1)
            throw new CafeOutOfCapacityException();

        int i = 0;
        boolean recipeFound = false;
        Recipe[] menuArray = getMenu();

        //Check to see if the recipe exists (I realised there was already a method for this :(   )
        while (i<menuArray.length && recipeFound == false){
            if (recipeName == menuArray[i].getName()){
                recipeFound = true;
            }
            else{
                i++;
            }
        }

        if (recipeFound == false)
            throw new RecipeNotFoundException();

        //If the recipe exists check to see if the customer can afford it
        if (recipeFound == true && amountPaid >= menuArray[i].getPrice()) {
            Order order = new Order(menuArray[i], customerName, amountPaid);
            orders[indexNextOrderToPlace] = order;
            indexNextOrderToPlace++;
            return true;
        }
        else
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

        if (orders[indexNextOrderToServe] != null) {
            indexNextOrderToServe++;
            return orders[indexNextOrderToServe - 1];
        }
        else
            return null;
    }
}
