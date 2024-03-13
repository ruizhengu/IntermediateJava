package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;

public class Cafe {
	
	//instance variables
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
        return "Welcome to "+ this.getName();
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
    	for(int j = 0; j<menu.length; j++) {
    		//no recipe found at that index
    		if(menu[j] == null) {
    			continue;
    		}
    		//Remove the given recipe if it exists by replacing with null
    		if(menu[j].getName().equals(recipeName)) {
    			menu[j] = null;
    		}
    	}
    	//Trying to delete a recipe that does not exist
    	throw new RecipeNotFoundException(recipeName);
   
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
        //Only print orders between the next order to serve and the last order placed
        int nPendingOrders = 0;
        for (int o = indexNextOrderToServe; o<indexNextOrderToPlace; o++) {

        	if(orders[o] != null) {
                nPendingOrders++;
        		System.out.println(orders[o].toString());
        	}
        }
        if (nPendingOrders == 0)
            System.out.println("No pending orders");
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
        for (int i = 0; i< getMenu().length; i++) {
        	//Print the menu from the array that has the exact number of items in the menu
        	System.out.println(getMenu()[i].getName()+ " - "+ getMenu()[i].getPrice());
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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException, 
                                                                                             CafeOutOfCapacityException{
    	//check whether the recipe exists in the menu
    	Recipe chosen = findRecipe(recipeName);

    	if (chosen == null) {
    		//no recipe found
    		throw new RecipeNotFoundException(recipeName);
    	}

    	//checking for capacity in the cafe
    	if(indexNextOrderToPlace < orders.length) {
    		//add order to the array
    		if (orders[indexNextOrderToPlace] == null && amountPaid >= chosen.getPrice()) {
    	       orders[indexNextOrderToPlace] =  new Order(chosen, customerName, amountPaid);
    	       indexNextOrderToPlace+=1;
    	       return true;
    	    }
    	}throw new CafeOutOfCapacityException(orders.length);
     }

    public boolean placeOrder(String recipeName, String customerName, double amountPaid, String specialRequest) throws RecipeNotFoundException,
            CafeOutOfCapacityException{
        //check whether the recipe exists in the menu
        Recipe chosen = findRecipe(recipeName);

        if (chosen == null) {
            //no recipe found
            throw new RecipeNotFoundException(recipeName);
        }

        //checking for capacity in the cafe
        if(indexNextOrderToPlace < orders.length) {
            //add order to the array
            if (orders[indexNextOrderToPlace] == null && amountPaid >= chosen.getPrice()) {
                orders[indexNextOrderToPlace] =  new Order(chosen, customerName, amountPaid, specialRequest);
                indexNextOrderToPlace+=1;
                return true;
            }
        }throw new CafeOutOfCapacityException(orders.length);
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
        	//checking for the recipe in the menu
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
    	//orders to serve are always behind the next oder to place
    	if (indexNextOrderToPlace > indexNextOrderToServe) {
    		if(orders[indexNextOrderToServe] != null) {
    			//serve the order
    		   orders[indexNextOrderToServe].serve();
    	       indexNextOrderToServe +=1;
    	       return orders[indexNextOrderToServe -1];
    	     }
    	}
        return null;
    }
}
