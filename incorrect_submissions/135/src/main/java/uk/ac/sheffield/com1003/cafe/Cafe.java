package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.Order;

import java.util.Objects;

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
        String s = "Welcome to " + this.name;
        return s;
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
        boolean found = false;
        for(int i = 0;i < menu.length;i++){
            if(recipeName.equals(menu[i].getName())){
                found = true;
                for(int j = i;j<menu.length;j++){
                    menu[j] = menu[j+1];
                }
                nRecipes -= 1; //Used for generating ActualMenu in getMenu()
            }
        }
        if(!found){
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
        for(int i=indexNextOrderToServe;i<indexNextOrderToPlace;i++){
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
        System.out.println(this.greeting());
        System.out.println("Menu");
        System.out.println("==========");

        Recipe[] ActualMenu = this.getMenu();
        for(int i=0;i < ActualMenu.length;i++){
            System.out.println(ActualMenu[i].getName() + " - " + ActualMenu[i].getPrice());
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
        //To use an exemption:
        //throw new RecipeNotFoundException;

        Recipe[] ActualMenu = this.getMenu();
        for(int i=0;i < ActualMenu.length;i++){
            if(indexNextOrderToPlace >= orders.length){   //length of order array = max capacity is reached.
                throw new CafeOutOfCapacityException();
            }else if(ActualMenu[i].getName() == recipeName){  //Recipe names match
                if(ActualMenu[i].getPrice() <= amountPaid){     //amount paid is sufficient
                    Order tmp = new Order(ActualMenu[i],customerName,amountPaid); //generate order based on current recipe
                    orders[indexNextOrderToPlace] = tmp;    //slot the order into the place of index
                    indexNextOrderToPlace ++;
                    return true;
                }else{
                    return false;
                }
            }else if(i == ActualMenu.length-1 && Objects.equals(ActualMenu[i].getName(), recipeName)) { //EOA & no matching name
                throw new RecipeNotFoundException();
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
    public Order serveOrder(){
        //To use an exemption:
        //throw new RecipeNotFoundException;
        if(orders[indexNextOrderToServe] != null && indexNextOrderToServe < indexNextOrderToPlace){
            orders[indexNextOrderToServe].serve();
//            System.out.println("==========");
//            orders[indexNextOrderToServe].printReceipt();
            indexNextOrderToServe ++;
            return orders[indexNextOrderToServe];
        }
        return null;
    }
}
