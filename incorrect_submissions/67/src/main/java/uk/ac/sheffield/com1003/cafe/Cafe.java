package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;

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
        this("Cafe",10, 100);
        indexNextOrderToPlace = 0;
        indexNextOrderToServe =0;
        nRecipes = 0;
    }

    /**
     * Constructor that takes cafe name as parameter, and 
     * initialises menu size to 10 and capacity (number of orders) to 100.
     */
    public Cafe(String name) {
        this(name, 10, 100);
        indexNextOrderToPlace = 0;
        indexNextOrderToServe =0;
        nRecipes = 0;
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
    //When you call the greeting() method it returns "Welcome to <cafe name>" string using the getName() method
    public String greeting() {
        return ("Welcome to " + getName());
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

        boolean added = false;

        //this checks if there is enough space for another recipe on the menu, and also if it is not already added,
        //if these are both true then add the new recipe to the menu
        while (nRecipes < menu.length && !added) {
            if (menu[nRecipes] == null) {
                menu[nRecipes] = newRecipe;
                nRecipes++;
                added = true;
            } else {
                break;
            }
        }
        return added;
    }

    /**
     * Find recipe with given name and remove it from the menu.
     * Assumes there are no duplicated recipe names.
     * @param recipeName Name of the recipe to be removed
     *
     **/
    public void removeRecipe(String recipeName) throws RecipeNotFoundException{ //takes String as param

        boolean recipeExists = false;

        for(Recipe r : menu){ //Checks if the user input (object) matches a recipe object
            if (r!=null){
                String rName = r.getName();
                if(recipeName.equals(rName)) {
                    recipeExists = true;
                }
            }
        }

        if (!recipeExists){ //if user input does not match it throws an exception
            throw new RecipeNotFoundException();
        }

        // This function deletes the requested recipe from menu array
        for(int i = 0; i<menu.length; i++) {
            if (menu[i] != null) {
                String sameRecipe = menu[i].getName();
                if (recipeName.equals(sameRecipe)) { //find name of recipe in array and sets it to null (deletes it)
                    menu[i] = null;
                }
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

        // This method will print all orders that haven't already been served
        System.out.println("Pending Orders:");
        for (int i = indexNextOrderToServe; i < indexNextOrderToPlace; i++) {
            System.out.println(orders[i]);
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
        System.out .println("==========");
        System.out.println(greeting());
        System.out.println("Menu");
        System.out.println("==========");
        //Iterating through Recipe[] array called menu, check it's not null, print its name and price
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                System.out.println(menu[i].getName() + " - " + menu[i].getPrice());
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
     * @return True if the recipe name exists in the menu and the amount paid is sufficient; return false otherwise
     * @throws RecipeNotFoundException if the recipe name does not exist in the menu
     * @throws CafeOutOfCapacityException if the cafe cannot take any more orders and is out of capacity
     */
    public boolean placeOrder (String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException,
            CafeOutOfCapacityException {

        //CafeOutOfCapacityException
        //if the index of the next order to place exceeds the length of order array (capacity) then it throws exception
        if(indexNextOrderToPlace >= orders.length) {
            throw new CafeOutOfCapacityException();
        }

        //checking if user input is a recipe that exists in menu
        boolean recipeFound = false;
        //Checking if the recipe exists and the amount paid is correct
        boolean recipeFoundAndCorrectAmountPaid = false;

        //iterates through array, gets objects name and compares to user input. If it matches, then get the price of
        //that recipe and compare to the amount paid by the customer. If the customer has paid enough then the order is
        //added to the orders array and true boolean is returned to the method

        for (Recipe item : menu) {

            if (item != null) {
                String itemName = item.getName();

                if (recipeName.equals(itemName)) {
                    recipeFound = true;
                    Double itemPrice = item.getPrice();
                    if (amountPaid >= itemPrice) {
                        orders[indexNextOrderToPlace++] = new Order(new Recipe(recipeName, itemPrice), customerName, amountPaid); // should it include the full constructor of recipe??
                        recipeFoundAndCorrectAmountPaid = true;
                    }
                    break;
                }
            }
        }
        //if user input is not a recipe that exists in menu then throws exception
        if (!recipeFound) {
            throw new RecipeNotFoundException();
        }

        return recipeFoundAndCorrectAmountPaid;
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
        //returns the index of the next order to serve and increments it each time to get the most up-to-date order
        if (orders[indexNextOrderToServe] != null) {
            orders[indexNextOrderToServe].serve();
            return orders[indexNextOrderToServe++];
        } else {
            return null;
        }
    }
}
