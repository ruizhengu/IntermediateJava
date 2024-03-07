package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class Cafe {
    private String name;
    private Recipe[] menu;
    private Order[] orders;

    private int indexNextOrderToPlace;//tail of queue
    private int indexNextOrderToServe;//head of queue
    private int nRecipes;//in menu

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
        return "Welcome to " + this.name;
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
        
        for (int i = 0;  i< menu.length; i++) {
            if (menu[i] != null && menu[i].getName().equals(recipeName)) {
                menu[i] = null;
                return;
            }
        }
        throw new RecipeNotFoundException();
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
        //System.out.println("This is task 4");
        //there's no way it's this easy
        System.out.println("Pending Orders:");
        for (Order pending: orders) {
            if (pending != null) {
                System.out.println(pending.toString());
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
        Recipe[] actualMenu = this.getMenu();
        //System.out.println("Menu to come soon. For guidance, see Javadoc above and TestCafe.testPrintMenu()");
        System.out.println("==========");
        System.out.println(greeting());
        System.out.println("Menu");
        System.out.println("==========");

        for (int i = 0; i < actualMenu.length; i++) {
            Recipe item = actualMenu[i];
            //int noOfMissing0s = String.valueOf(item.getPrice()).length() - (int)Math.log10(item.getPrice()) - 3;
            //I know I could use escape characters but I find this more readable
            System.out.print(item.getName() + " - " + item.getPrice());
            /*for (int j = 0; j <= noOfMissing0s; j++) {
                System.out.print("0");
            }*/
            System.out.println();
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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException, CafeOutOfCapacityException {
        Recipe namedRecipe = findRecipe(recipeName);
        if (namedRecipe.equals(null))//name not found
            throw new RecipeNotFoundException();
        if (orders.length < 1 || orders[indexNextOrderToPlace] != null)//no more slots
            throw new CafeOutOfCapacityException();
        //
        if (amountPaid >= namedRecipe.getPrice()) {
            orders[indexNextOrderToPlace] = new Order(namedRecipe, customerName, amountPaid);//place the order
            indexNextOrderToPlace = (indexNextOrderToPlace+1) % orders.length;//increment and loop the head tail index
            return true;
        }
        return false;
    }

    /**
     * @return matching Recipe with given name; return null if not found
     * I could theoretically make a template function fo all linear searches but that's not needed here
    int findOrderSlot() {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {//linear search for the name given
                return i;
            }
        }
        return -1;//not found
    }
    */

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
        Order toServe = orders[indexNextOrderToServe];
        if (toServe !=null) {
            orders[indexNextOrderToServe] = null;
            return toServe;
        }
        return null;
    }

    
    
}

class App {
    static Cafe cCafe;
    public static void main(String[] args){
        cCafe = new Cafe("The Cookie Cafe");
        Recipe curRecipe = new Recipe("Espresso", 1.5, Size.SMALL,2);
        addIngredients( new Ingredient[] {
            new Coffee(), new Water()
        }, curRecipe);

        curRecipe = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        addIngredients(new Ingredient[]{
            new Coffee(15), new Water(50)
        }, curRecipe);

        curRecipe = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        addIngredients(new Ingredient[] {
            new Milk(44,Type.SOY), new Water(), new Coffee()//I love being lazy but also this was the closest I could find online
        }, curRecipe);

        cCafe.printMenu();
        
        try {
            cCafe.placeOrder("Large Soy Latte", "Joe Mama", 10);
        } catch (Exception e) {
            System.out.println("fuck");
        }
        cCafe.printPendingOrders();


    }

    static void addIngredients(Ingredient[] ingredients, Recipe cuRecipe) {
        try {
            cuRecipe.addIngredient(new Water());
            cuRecipe.addIngredient(new Milk());
        } catch (TooManyIngredientsException e) {
            System.out.println("Oops, added too many ingredients :P");
        }
        cCafe.addRecipe(cuRecipe);
    }
}
