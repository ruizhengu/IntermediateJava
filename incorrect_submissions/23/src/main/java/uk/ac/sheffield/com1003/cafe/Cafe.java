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
        return ( "Welcome to " + this.getName() );
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
        try {
            for (int i = 0; i < menu.length; i++) {
                Recipe currentRecipe = menu[i];
                if (recipeName == currentRecipe.getName()) {
                    menu[i] = null;
                } else {throw new RecipeNotFoundException();}
            }
        } catch (RecipeNotFoundException e) {
            System.out.println("Recipe not found by name in the menu");
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
        for (int i=indexNextOrderToServe; i < indexNextOrderToPlace; i++) {
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
        System.out.println("==========");
        System.out.println( this.greeting() );
        System.out.println("Menu");
        System.out.println("==========");
        for (int i=0; i<nRecipes; i++) {
            String recipeName = menu[i].getName();
            String recipePrice = Double.toString(menu[i].getPrice());

            System.out.println(recipeName + " - " + recipePrice);
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
    //
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException {
        boolean returnValue = false;
        Recipe foundRecipe = null;

        try {
            boolean recipeInMenu = false;

            for (int i=0; i< menu.length; i++) {
                Recipe menuRecipe = menu[i];
                if (menuRecipe != null) {
                    if (recipeName.equals(menuRecipe.getName())) { //check if such a recipe name is on the menu
                        if (amountPaid > menuRecipe.getPrice()) { //check if the amount paid is sufficient
                            returnValue = true;
                            recipeInMenu = true;
                            foundRecipe = menuRecipe;
                        }
                    }
                }
            }
            if (!recipeInMenu) {throw new RecipeNotFoundException();} //if the recipe is not in the menu throw exception

        } catch (RecipeNotFoundException e) {
            System.out.println("Recipe not on the menu");
        }

        if (returnValue) { //if the recipe is found and amount payed is sufficient
            try {
                if (indexNextOrderToPlace < menu.length) { //if there is space in the orders array then add order to the array
                    Order newOrder = new Order(foundRecipe, customerName, amountPaid);
                    orders[indexNextOrderToPlace] = newOrder;
                    indexNextOrderToPlace++; //and increment the index
                } else {
                    throw new CafeOutOfCapacityException();
                }

            } catch (CafeOutOfCapacityException e) {
                System.out.println("The cafe has reached it's maximum number of orders, no more can be placed currently");
            }
        }


        return returnValue;
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
        Order returnValue = null;
        Order currentOrderToServe = orders[indexNextOrderToServe];
        if (orders[indexNextOrderToServe] != null) {
            currentOrderToServe.serve();
            returnValue = currentOrderToServe;
            indexNextOrderToServe++;
        }
        return returnValue;
    }
}
