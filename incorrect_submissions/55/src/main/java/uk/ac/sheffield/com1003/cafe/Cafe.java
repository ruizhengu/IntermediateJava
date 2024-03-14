package uk.ac.sheffield.com1003.cafe;

import java.time.LocalDateTime;
import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

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
        return "Welcome to " + name ; 
    }

    /**
     * Getter for cafe name
     * @return Cafe name
     */
    public String getName() {
        return name;
    }
    
//---------------------------------------------------------------------------------
//---------------------------------------------------------------------------------
    
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
    
//---------------------------------------------------------------------------------
//---------------------------------------------------------------------------------

    /**
     * Find recipe with given name and remove it from the menu.
     * Assumes there are no duplicated recipe names.
     * @param recipeName Name of the recipe to be removed
     */
    public void removeRecipe(String recipeName) throws RecipeNotFoundException {
    	if(findRecipe(recipeName) == null) {
			throw new RecipeNotFoundException();
		}
    	
    	for (int i=0; i<menu.length; i++) {
    		if (menu[i].getName() == recipeName) {
    			menu[i] = null ;
    			System.out.print(recipeName);
    			System.out.print(" has been successfully removed ");
    			System.out.println("from the menu.");
    		}
    		
    	}
    }
    
//---------------------------------------------------------------------------------
//---------------------------------------------------------------------------------

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
//---------------------------------------------------------------------------------
//---------------------------------------------------------------------------------
    
    /**
     * Print a list of orders not yet served in the following format
     * Pending Orders:
     * <Output of call to {@link Order#toString()}; one pending order per line>
     */
    public String toString() {
    	return "Order: " + recipeName + "; For: " + customerName + "; Paid: " + amountPaid;
    }
    
    public void printPendingOrders() {
    		System.out.println("Pending Orders:");
            System.out.println(toString());
    }
    
//---------------------------------------------------------------------------------
//---------------------------------------------------------------------------------

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
        for (int i=0; i<menu.length; i++ ) {
        	if (menu[i] != null) {
        		System.out.println(menu[i].getName() + " - " + menu[i].getPrice());
        	}
        }
        System.out.println("==========");
        System.out.println("Enjoy!");
    }
    
//---------------------------------------------------------------------------------
//---------------------------------------------------------------------------------
    
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
    
    //instance variables to get recipeName, customerName, amountPaid
    public String recipeName;
    public String customerName;
    public double amountPaid;
  
  
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException, CafeOutOfCapacityException{
    	this.recipeName = recipeName;
    	this.customerName= customerName;
    	this.amountPaid= amountPaid;
    	
    	for (int i=0; i<100; i++) {
    		if (findRecipe(recipeName) == null) {
    			throw new RecipeNotFoundException() ;
    		}
    		if (orders.length > 100  ) {
    			throw new CafeOutOfCapacityException() ;
    		}
    			if (findRecipe(recipeName) != null) {
        			if (amountPaid >= menu[i].getPrice()) {
        				indexNextOrderToPlace++ ;
        				return true;
        			}
        		}
        		if (amountPaid < menu[i].getPrice()) {
        			System.out.print("Either the recipe you have ordered isn't served");
    				System.out.print(" or the amount you have paid is insufficeint.");
        			return false;
        		}
    	}
    	return false;
    }
    
    //getters for placing order parameters to obtain recipe name, customer name, amount paid
    //used in serveOrder()
    public String getrecipeName() {
    	return recipeName;
    }
    public String getcustomerName() {
    	return customerName;
    }
    public double getamountPaid() {
    	return amountPaid;
    }
    
//---------------------------------------------------------------------------------
//---------------------------------------------------------------------------------
    
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
  
//---------------------------------------------------------------------------------
//---------------------------------------------------------------------------------
    
	/**
     * If there is an order to serve, serves it ({@link Order#serve()}) and increments {@link Cafe#indexNextOrderToServe}
     * @return The updated served order, or null of there is no order to serve.
     */
    public Order serveOrder() {
    	Recipe recipeOrdered = new Recipe("Espresso", 1.5, Size.SMALL, 2);
    		if (indexNextOrderToPlace != 0) {
    			Order order = new Order(recipeOrdered, customerName, amountPaid);
    			order.serve();
    			order.printReceipt();
    			indexNextOrderToServe++ ;
    			System.out.println(indexNextOrderToServe);
    		}
        return null;
    }
//---------------------------------------------------------------------------------
//---------------------------------------------------------------------------------   
  
	
}
