package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;


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
        return ("Welcome to "+getName());
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
        //check the recipe exists
        if(findRecipe(recipeName) == null){
            System.out.println(recipeName+ " cannot be deleted as it doesn't exist");
            throw new RecipeNotFoundException();
        }
        else{
            //find recipe in menu and change it to null
            for (int i=0; i < menu.length; i++){
                if(menu[i].getName().equals(recipeName)){
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
        System.out.println("Pending Orders:");
        //iterates through orders array and outputs orders that have not been served
        for(int i=0; i<orders.length; i++){
            if(i >= indexNextOrderToServe){
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

        Recipe[] outputMenu = this.getMenu();

        System.out.println("==========");
        System.out.println(this.greeting());
        System.out.println("Menu");
        System.out.println("==========");

        for (int i=0; i < outputMenu.length; i++){
            System.out.println(outputMenu[i].getName()+ " - " +outputMenu[i].getPrice());
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
    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws RecipeNotFoundException, CafeOutOfCapacityException {
        //check if orders are full
        if(indexNextOrderToPlace >= orders.length){
            System.out.println(recipeName+ " cannot be added as cafe is full");
            throw new CafeOutOfCapacityException();
        }
        else{
            //check that the recipe exists
            if(findRecipe(recipeName) == null){
                System.out.println(recipeName+ " cannot be added as the recipe doesn't exist");
                throw new RecipeNotFoundException();
            }
            //if recipe is not null add it to the orders and increment next order
            else{
                Recipe recipe = findRecipe(recipeName);
                if (recipe.getPrice() <= amountPaid) {
                    orders[indexNextOrderToPlace] = new Order(recipe, customerName, amountPaid);
                    indexNextOrderToPlace ++;
                    return true;
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
        //checks an order has been placed
        if(indexNextOrderToPlace > 0){
            //serves the order, increments
            orders[indexNextOrderToServe].serve();
            indexNextOrderToServe ++;
            return orders[indexNextOrderToServe-1];
        }
        return null;
    }

    public Recipe createEspresso() throws TooManyIngredientsException {
        //creates and returns espresso recipe
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2 );
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        return espresso;

    }

    public Recipe createDoubleEspresso() throws TooManyIngredientsException{
        //creates and returns a double espresso recipe
        Recipe double_espresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        double_espresso.addIngredient(new Coffee(15));
        double_espresso.addIngredient(new Water(30));
        return double_espresso;

    }

    public Recipe createLargeSoyLatte() throws TooManyIngredientsException{
        //creates and returns a large soy latte recipe
        Recipe large_soy_latte = new Recipe("Large soy latte", 2.5, Recipe.Size.LARGE, 3);
        large_soy_latte.addIngredient(new Coffee(30));
        large_soy_latte.addIngredient(new Water(60));
        large_soy_latte.addIngredient(new Milk(10, Milk.Type.SOY ));
        return large_soy_latte;
    }
}
