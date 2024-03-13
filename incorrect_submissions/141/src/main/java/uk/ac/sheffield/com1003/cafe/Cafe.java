package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;

public class Cafe {
    private String name;
    private Recipe[] menu;
    private Order[] orders;

    private int indexNextOrderToPlace;
    private int indexNextOrderToServe;
    private int nRecipes;
    
    private String greeting;

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
        return "Welcome to " + this.getName();
    }

    /**
     * Getter for cafe name
     * @return Cafe name
     */
    public String getName() {
        return name;
    }
    
    public int getNRecipes() {
    	return nRecipes;
    }
    
    public int getNextOrderToPlace() {
    	return indexNextOrderToPlace;
    }
    
    public int getNextOrderToServe() {
    	return indexNextOrderToServe;
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

    /**return
     * Find recipe with given name and remove it from the menu.
     * Assumes there are no duplicated recipe names.
     * @param recipeName Name of the recipe to be removed
     */
    
    /*created a new recipe object by passing the recipe name param into findRecipe()
    *if this object is null, throws the exception. If not loops through the menu, finds the recipe, deletes it
    */
    public void removeRecipe(String recipeName) throws RecipeNotFoundException{
        Recipe deletingRecipe = findRecipe(recipeName);
        if(deletingRecipe == null) {throw new RecipeNotFoundException(recipeName);}
        Recipe[] actualMenu = getMenu();
        boolean deleted = false;
        int i = 0;
        while(i > actualMenu.length && !deleted) {
        	if(actualMenu[i].getName() == deletingRecipe.getName()) {
        		actualMenu[i] = null;
        		deleted = true;
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
    
    //starts a loop at the next order to serve, iteratively prints each order until the next order to place is reached
    public void printPendingOrders() {
    	System.out.println("Pending Orders:");
    	for(int i = getNextOrderToServe(); i < getNextOrderToPlace(); i++)
    		System.out.println(orders[i].toString());
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
    	
    	//defines a line separator string to avoid repeating code//
        String lineSeparator = "==========";
        System.out.println(lineSeparator);
        System.out.println(this.greeting());
        System.out.println("Menu");
        System.out.println(lineSeparator);
        
        //iteratively prints out each menu item in specified format of name - price//
        for(int i = 0; i < this.getMenu().length; i++) {
        	System.out.println(this.getMenu()[i].getName() + " - " + this.getMenu()[i].getPrice());
        }
        System.out.println(lineSeparator);
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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException, CafeOutOfCapacityException{
    	Recipe recipe = this.findRecipe(recipeName);
    	
    	//checking if the recipe is null and if there is space to accommodate the order
    	//if these ifs are triggered, the appropriate exceptions are thrown//
    	if(recipe == null) 
    		throw new RecipeNotFoundException(recipeName);
    	if(getNextOrderToPlace() >= orders.length ) 
    		throw new CafeOutOfCapacityException(orders.length);
    	
    	//if no exceptions are thrown, checks that pay is sufficient, if it is then inserts a new order at the index of
    	//the next order to place, using the method parameters and previously defined recipe object as constructor params
    	if (amountPaid >= recipe.getPrice()){
    		orders[indexNextOrderToPlace] = new Order(recipe, customerName, amountPaid);
    		indexNextOrderToPlace++;
    		return true;
    	}else {
    		System.out.println("Insufficient pay.");
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
    	
    	//checks if the order to serve is null, if not then creates a new order object (so that it can be returned)
    	//and calls serve() on that order, and then returns the created object with same pointer as the served order in array
    	if(orders[getNextOrderToServe()] != null) {
    		Order orderToServe = orders[getNextOrderToServe()];
    		orderToServe.serve();
    		indexNextOrderToServe++;
    		return orderToServe;
    	}  
        return null;
    }
}
