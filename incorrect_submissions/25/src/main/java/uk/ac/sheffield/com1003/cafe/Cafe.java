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
        return "Welcome to "+this.getName();
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
        if (findRecipe(recipeName) != null) {
            int removeIndex = 0;
            //Once we know the recipeName exists, we need to find its exact index in the array, cannot use indexOf as we are using .getName for each element
            for (int i = 0; i < this.nRecipes; i++) {
                if (this.menu[i].getName() == recipeName){
                    removeIndex = i;
                    break;
                    //Once the recipe is found, save the index and break from the loop to prevent uneccessary processing.
                }
            }

            //We want to remove the recipe that was requested as well as shift the entire menu elements down by one and decrease nRecipes
            //We do this by starting at the index we want to remove, then replace that position with the next element in the list, and continue till we are at the ened of the list.
            for (int i = removeIndex; i < this.nRecipes; i++){
                this.menu[i] = this.menu[i+1];
            }
            System.out.println("The recipe "+recipeName+" has been successfully removed!\n");

            //Once we have shifted all values. the last element will be duplicated so we need to set that to null and decrease nRecipes.
            this.menu[nRecipes] = null;
            this.nRecipes--;
            return;
        }
        throw new RecipeNotFoundException();
    }

    /**
     * Returns the current list of recipes in the menu excluding empty/null elements
     * 
     * @return Array of recipes contained in the menu (excluding nulls)
     */
    public Recipe[] getMenu() {
        Recipe[] actualMenu = new Recipe[nRecipes];
        int next = 0;
        for (int i = 0; i < this.menu.length; i++) {
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
        //The index should go to the indexNextOrderToPlace and not the lenght of orders as the array may not be full and so we want to only go as far as we have orders
        for (int i = 0; i < this.indexNextOrderToPlace; i++) {
            System.out.println(this.orders[i].toString());
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
        System.out.println(this.greeting());
        System.out.println("Menu");
        System.out.println("==========");
        for (int i = 0; i < nRecipes; i++) {
            System.out.println(menu[i].getName()+" - "+menu[i].getPrice());
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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException, CafeOutOfCapacityException {
        if (findRecipe(recipeName) != null) {
            //If the recipe is successfully found, check its price against the amount paid to ensure its enough
            if (amountPaid >= findRecipe(recipeName).getPrice()) {
                //If the next order to place is the same as the length of our orders array, then there is no more room for more orders so throw said exception
                if (this.indexNextOrderToPlace == this.orders.length) {
                    throw new CafeOutOfCapacityException();
                }
                //If there is space, add the order to the orders array and increment the index for next order.
                this.orders[indexNextOrderToPlace] = new Order(findRecipe(recipeName), customerName, amountPaid);
                this.indexNextOrderToPlace++;
                return true;
            } else {
                return false;
            }
        }
        throw new RecipeNotFoundException();
    }


    /**
     * Find a recipe in the menu given a recipe name
     * 
     * @param recipeName Name of the recipe to find
     * @return The recipe found or null otherwise
     */
    private Recipe findRecipe(String recipeName) {
        int i = 0;
        while (i < this.menu.length) {
            if (this.menu[i] != null && menu[i].getName().equals(recipeName))
                return this.menu[i];
            i++;
        }
        return null;
    }

    /**
     * If there is an order to serve, serves it ({@link Order#serve()}) and increments {@link Cafe#indexNextOrderToServe}
     * @return The updated served order, or null of there is no order to serve.
     */
    public Order serveOrder() {
        if (this.orders[this.indexNextOrderToServe] == null) {
            return null;
        }
        this.orders[this.indexNextOrderToServe].serve();
        this.indexNextOrderToServe++;
        //As we have already incremented the index we need to return the last one served so we just decrement said value to get the last order served.
        return this.orders[this.indexNextOrderToServe-1];
    }
}
