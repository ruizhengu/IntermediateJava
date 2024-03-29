package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;

public class Cafe {
    private String name;
    private Recipe[] menu;
    private Order[] orders;

    private int indexNextOrderToPlace = 0;
    private int indexNextOrderToServe = 0;
    private int nRecipes = 0;
    private int sizeMenu;
    private int orderCapacity;

    /**
     * Constructor that initialises name to "Cafe", menu
     * size to 10 and capacity (number of orders) to 100.
     */
    public Cafe() {
        this("Cafe", 10, 100);
        this.orders = new Order[orderCapacity];
    }

    /**
     * Constructor that takes cafe name as parameter, and 
     * initialises menu size to 10 and capacity (number of orders) to 100.
     */
    public Cafe(String name) {
        this(name, 10, 100);
        this.orders = new Order[orderCapacity];
    }

    /**
     * Constructor that takes the cafe name, menu size and
     * capacity (number of orders) as parameters.
     */
    public Cafe(String name, int sizeMenu, int orderCapacity) {
        this.name = name;
        this.sizeMenu = sizeMenu;
        this.menu = new Recipe[sizeMenu];
        this.orderCapacity = orderCapacity;
        this.orders = new Order[orderCapacity];
    }

    /**
     * Returns greeting string
     * @return "Welcome to <cafe name>"
     */
    public String greeting() {
        return ("Welcome to " + this.name);
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
        menu = this.getMenu();
        boolean deleteRecipeFound = false;
        Recipe[] newMenu = new Recipe[menu.length -1];

        // loop through the menu array, creating a new menu
        // create the new menu the same, except all items after the
        // deleted recipe have their index decremented
        // then only update the menu if the removal item was found
        for (int i=0; i<menu.length; i++){
            if ((deleteRecipeFound == false) && (menu[i].getName() == recipeName)){
                deleteRecipeFound = true;
            }
            if (deleteRecipeFound){
                newMenu[i-1] = menu[i];
            } else{
                newMenu[i] = menu[i];
            }
        }

        if (deleteRecipeFound){
            this.menu = newMenu;
        }
        else{
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
        for (int i = this.indexNextOrderToServe; i < this.indexNextOrderToPlace; i++){
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
        Recipe[] menu = this.getMenu();
        for (Recipe r : menu){
            if (r != null){
                String menuLine = r.getName();
                menuLine = (menuLine + " - ");
                menuLine = (menuLine + Double.toString(r.getPrice()));
                System.out.println(menuLine);
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
                            throws RecipeNotFoundException, CafeOutOfCapacityException {
        Recipe recipeInMenu = this.findRecipe(recipeName);
        
        if (recipeInMenu == null){
            throw new RecipeNotFoundException();
        }
        if (this.indexNextOrderToPlace >= this.orderCapacity){
            throw new CafeOutOfCapacityException();
        }
        if (amountPaid > recipeInMenu.getPrice()){
            this.orders[indexNextOrderToPlace] = new Order(recipeInMenu, customerName, amountPaid);
            this.indexNextOrderToPlace++;
            return true;
        }
        else {return false;}
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
        this.orders[this.indexNextOrderToServe].serve();
        this.indexNextOrderToServe++;
        return  this.orders[this.indexNextOrderToServe -1];
    }
}
