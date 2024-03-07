package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;

/**
 * Cafe.java  12/03/2023
 * 
 * @author Lucas Madle
 */
public class Cafe {
    private String name;
    private Recipe[] menu;
    private Order[] orders;

    private int indexNextOrderToPlace;
    private int indexNextOrderToServe;
    private int nRecipes;
    
    private String underline = "==========";


    public Cafe() {
        this("Cafe");
    }

    public Cafe(String name) {
        this(name, 10, 100);
    }

    public Cafe(String name, int sizeMenu, int orderCapacity) {
        this.name = name;
        menu = new Recipe[sizeMenu];
        orders = new Order[orderCapacity];
        indexNextOrderToPlace = 0;
        indexNextOrderToServe = 0;
        nRecipes = 0;
    }

    public String greeting() {
        return "Welcome to " + name;
    }

    public String getName() {
        return name;
    }


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

    public void removeRecipe(String recipeName) throws RecipeNotFoundException {
        for (Recipe i: menu) {
            if (i != null && i.getName() == recipeName) {
                i = null;
                return;
            }
        }
        throw new RecipeNotFoundException();
    }

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

    public void printPendingOrders() {
        System.out.println("Pending Orders:");
        for (int i = indexNextOrderToServe; i < indexNextOrderToPlace; i++) {
            System.out.println(orders[i].toString());
        }
    }

    public void printMenu() {
        StringBuffer sb = new StringBuffer();
        String lineBreak = System.getProperty("line.separator");
        sb.append(underline);
        sb.append(lineBreak);
        sb.append(greeting());
        sb.append(lineBreak);
        sb.append("Menu");
        sb.append(lineBreak);
        sb.append(underline);
        sb.append(lineBreak);

        for (Recipe i: getMenu()) {
            String price = Double.toString(i.getPrice());
            sb.append(i.getName() + " - " + price);
            sb.append(lineBreak);
        }

        sb.append(underline);
        sb.append(lineBreak);
        sb.append("Enjoy!");

        System.out.print(sb);
    };


    public boolean placeOrder(String recipeName, String customerName, double amountPaid) throws Exception {
        if (indexNextOrderToPlace >= orders.length) 
            throw new CafeOutOfCapacityException();

        Recipe order = findRecipe(recipeName);
        if (order == null)
            throw new RecipeNotFoundException();

        if (amountPaid >= order.getPrice()) {
            orders[indexNextOrderToPlace] = new Order(order, customerName, amountPaid);
            indexNextOrderToPlace++;
            return true;
        }
        return false;
    }

    private Recipe findRecipe(String recipeName) {
        int i = 0;
        while (i < menu.length) {
            if (menu[i] != null && menu[i].getName().equals(recipeName))
                return menu[i];
            i++;
        }
        return null;
    }

    public Order serveOrder() {
        Order currentOrder = orders[indexNextOrderToServe];
        if (currentOrder != null)
            currentOrder.serve();
            indexNextOrderToServe++;
        
        return currentOrder;
    }
}
