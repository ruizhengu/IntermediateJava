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
        return "Welcome to " + name;
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
        
        int index = 0; //initialise index variable that will store the index of the matching recipe
        boolean match = false; //initialise match variable that will throw an exception if false
        //loop through the menu array
        for(int i = 0; i < menu.length-1; i++){
            //if the a recipe match is found the "index" is set to the matching recipe index and match is set to true
            if(menu[i].getName().equals(recipeName)){
                index = i;
                match = true;
                //shifts all elements after the matching recipe to the left effectively deleting the recipe
                for(int j = index; j< menu.length-1;j++){
                    menu[j] = menu[j+1];
                }
                
            }
            //sets the last index to null since it is a duplicate recipe
            menu[menu.length-1] = null;
        }
        //if no matching recipe is found throw an exception
        if (match != true){
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
        //loops through the order array of only pending orders that haven't been served
        for(int i = indexNextOrderToServe; i< indexNextOrderToPlace; i++){
            //if an order exists then it will print the order
            if (orders[i] != null){
                System.out.println(orders[i].toString());
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
        for(Recipe recipe:menu){
            if (recipe != null){
                System.out.println(recipe.getName() + " - " + recipe.getPrice());
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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) 
        throws CafeOutOfCapacityException,RecipeNotFoundException 
        {
            //if the recipe is not found then it will throw a relevant exception
            Recipe recipe = findRecipe(recipeName);
            if (recipe == null){
                throw new RecipeNotFoundException();
            }
            //if the amount paid is less than the price of the recipe then it will return false
            if (amountPaid < recipe.getPrice()){
                return false;
            }
            //if the order is larger than the capacity of the cafe then it will throw an exception
            if (indexNextOrderToPlace >= orders.length){
                throw new CafeOutOfCapacityException();
            }
            //Creates a new order object and adds the order to the orders array then increments the placed orders by one
            Order order = new Order(recipe, customerName, amountPaid);
            orders[indexNextOrderToPlace] = order;
            indexNextOrderToPlace++;
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
        //accesses the orders array and finds the order that is to be served
        Order served = orders[indexNextOrderToServe];
        //if their is an order then it will serve it, increment the served orders and return that served order
        if (served != null){
            served.serve();
            indexNextOrderToServe++;
            return served;

        }
        //return nothing otherwise
        return null;
    }
}
