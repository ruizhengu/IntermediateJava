package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.App;
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
    // Adding the greeting function to be called when printing the menu
    public String greeting() {
        return "Welcome to "+getName();
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
    // task 7 to find whether the name given is equal to the recipe names and if found to remove it from the menu
    public void removeRecipe(String recipeName) throws RecipeNotFoundException{
        // creating a for loop to check each element to fulfil the task.
        boolean found = false;
        for (int i = 0; i <= menu.length; i++) {
            if (recipeName.equals(menu[i].getName()) == true) {
                menu[i] = null;
                found = true;
            }
        }
        if (found == false || recipeName == null) {
            throw new RecipeNotFoundException();
        }
        else {
            nRecipes--;
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
        // printing the pending orders by first creating a for loop to add orders to the maximum which is defined
        //printing all orders pending
        System.out.println("Pending Orders:");
        for (int j = 0; j<indexNextOrderToPlace; j++){
            System.out.println(orders[j].toString());
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
        // printing the menu based on requirement implemented a for loop to print each recipe
        System.out.println("==========");
        System.out.println(greeting());
        System.out.println("Menu");
        System.out.println("==========");
        for (int j =0; nRecipes > j; j++) {
            System.out.println(menu[j].getName() + " - " + menu[j].getPrice());
        }
        System.out.println("==========");
        System.out.println("Enjoy!");
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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException, CafeOutOfCapacityException {
       // checking whether the cafe orders will be out of capacity or not to throw the exception and introducing the exceptions with the constructor
        if (orders.length <= indexNextOrderToPlace ){
            throw new CafeOutOfCapacityException();
        }
        // checking whether payment is sufficent and name is correct to add order to an array to be used later
        for (int i=0; i <= menu.length; i++) {
            if (recipeName == menu[i].getName() && (amountPaid >= menu[i].getPrice())) {
                Order order = new Order (menu[i],customerName,amountPaid) ;
                orders[indexNextOrderToPlace]=order;
                indexNextOrderToPlace++;
                return true;
            }
            //name exception
            else if(recipeName != menu[i].getName()){
                throw new RecipeNotFoundException();
            }
            else {
                return false;
            }
        }
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
     * @return The updated served order, or null of there is no order to serve.
     */
    public Order serveOrder() {
    if (indexNextOrderToPlace<=indexNextOrderToServe){
        return null;
    }
    Order orderToServe = orders[indexNextOrderToServe];
            orderToServe.serve();
            indexNextOrderToServe++;
            return orderToServe;
    }
}
