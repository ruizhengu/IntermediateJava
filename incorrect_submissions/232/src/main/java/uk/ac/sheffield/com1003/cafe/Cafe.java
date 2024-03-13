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
        return "Welcome to Central Perk";
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
     * This is achieved by setting the position of the recipe in the array to null
     * Assumes there are no duplicated recipe names.
     * @param recipeName Name of the recipe to be removed
     * @throws RecipeNotFoundException if the recipe does not appear in the menu
     */
    public void removeRecipe(String recipeName) throws RecipeNotFoundException {
        for(int i = 0; i<menu.length; i++) {
            if (menu[i] != null && !(menu[i].getName().equals(recipeName))) {
                throw new RecipeNotFoundException();
            }
            if((menu[i] != null) && menu[i].getName().equals(recipeName)){
                menu[i] = null;
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
     *
     * this is achieved by looping through the orders array,
     * if there is an order at the index in the array it is printed
     */
    public void printPendingOrders() {
        System.out.println("Pending Orders:");
        for(int i = 0; i<orders.length; i++){
            if(orders[i] != null){
                System.out.println(orders[i].toString());
            }
        }
    }

    /**
     * This method prints the menu in the following format:
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
        for(int i = 0; i<menu.length; i++) {
            if (menu[i] != null) {
                System.out.print(menu[i].getName());
                System.out.println(" - " + menu[i].getPrice());
            }
        }
        System.out.println("==========");
        System.out.println("Enjoy!");
    };


    /**
     * This method will add an order to the orders array if the recipe appears on the menu and a sufficient amount of
     * money has been entered, the order is added to the array by looping through the orders array until an
     * empty position is found, the order is then added to the index of that empty position
     * 
     * @param recipeName The name of the recipe being ordered
     * @param amountPaid Money handed when placing order
     * @param customerName Name of customer placing order
     * @return True if the recipe name exists in the menu and the amount paid is sufficcient; return false otherwise
     * @throws RecipeNotFoundException if the recipe name does not exist in the menu
     * @throws CafeOutOfCapacityException if the cafe cannot take any more orders and is out of capacity, checks this by
     * comparing the index of the next order to place against the length of the orders array
     */
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException,
            CafeOutOfCapacityException {
        if(indexNextOrderToPlace >= orders.length)
            throw new CafeOutOfCapacityException();
        for(int i = 0; i<menu.length; i++){
            if(menu[i] != null && !(menu[i].getName().equals(recipeName))){
                throw new RecipeNotFoundException();
            }
            if((menu[i] != null) && menu[i].getName().equals(recipeName) && amountPaid >= menu[i].getPrice()){
                int j = 0;
                boolean added = false;
                while (j < orders.length && !added) {
                    if (orders[j] == null) {
                        orders[j] = new Order(menu[i],customerName,amountPaid);
                        indexNextOrderToPlace++;
                        added = true;
                    } else
                        j++;
                }
                return added;
            }
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
     * @return The updated served order with its time of serving, or null of there is no order to serve.
     */
    public Order serveOrder() {
        if(orders[indexNextOrderToServe] != null) {
            orders[indexNextOrderToServe].serve();
            indexNextOrderToServe++;
            return orders[indexNextOrderToServe-1];
        }
        return null;
    }
}
