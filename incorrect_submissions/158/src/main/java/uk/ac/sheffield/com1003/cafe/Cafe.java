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
        // Format Greeting
        String greeting = String.format("Welcome to %s", getName());
        return greeting;
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
        int index = -1;

        // DELETE: set the index of the requested recipeName in menu[] to null
        for (int i=0; i<getMenu().length; i++){
            if (menu[i] != null){
                if (menu[i].getName() == recipeName){
                    index = i;
                    menu[index] = null;
                    break;
                }

            }
        }

        // Define condition for RecipeNotFoundException
        if (index==-1) throw new RecipeNotFoundException();
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
        // Loop through each element in orders[] array
        System.out.println("Pending Orders:");
        // Identify the orders that are not served
        for (int i=indexNextOrderToServe; i<indexNextOrderToPlace; i++){
            // Exclude the orders that are null
            if (orders[i] != null){
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
       // Menu Output in Requested Format
        System.out.println("==========");
        System.out.println(greeting());
        System.out.println("Menu");
        System.out.println("==========");

        // Iterate through all recipe items and display name and prices appropriately
        Recipe[] recipes = getMenu();
        // Local variables used inside for loop
        String name;
        double price;
        for (int i=0; i<recipes.length; i++){
            if (recipes[i] != null){
                name = recipes[i].getName();
                price = recipes[i].getPrice();

                // Display info in an organised way
                System.out.println(name + " - " + price);
            }
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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException,
                                                                                                CafeOutOfCapacityException {
        // Define condition to throw RecipeNotFoundException
        if (findRecipe(recipeName) == null) throw new RecipeNotFoundException();

        // Define condition to throw CafeOutOfCapacityException
        if (indexNextOrderToPlace >= orders.length) throw new CafeOutOfCapacityException();

        // Loop through each recipe in the menu
        for (Recipe recipe: menu) {
            // Check if names are the same
            if (recipe.getName().equals(recipeName)) {
                // Check if paid amount is enough
                if (amountPaid >= recipe.getPrice()) {
                    // Place order in order array
                    orders[indexNextOrderToPlace] = new Order(recipe, customerName, amountPaid);
                    this.indexNextOrderToPlace++;
                    return true;
                }
                else{
                    break;
                }
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
     * @return The updated served order, or null of there is no order to serve.
     */
    public Order serveOrder() {
        Order servingOrder;
            // Check if index is at or below Cafe's capacity
            if (indexNextOrderToServe<=orders.length-1){
                // Check if order exists
                if(orders[indexNextOrderToServe]!=null) {
                    // Serve and increment index
                    servingOrder = orders[indexNextOrderToServe];
                    servingOrder.serve();
                    this.indexNextOrderToServe++;
                    return servingOrder;

                }
            }

        // Return null if index out of Capacity or if there is no order to serve
            return null;
    }
}
