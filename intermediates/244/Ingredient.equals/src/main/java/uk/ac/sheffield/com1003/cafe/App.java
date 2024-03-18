package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static String message;
    private Recipe[] menu;

    public void printMenu() {
        greeting();
        System.out.println("menu:");
        for (Recipe recipe : menu) {
            System.out.println(recipe);
        }
    }

    public void greeting() {
        System.out.println("Welcome to the Cafe!");
    }

    public class RecipeNotFoundException extends Exception {
        public RecipeNotFoundException() {
            super(message);
        }
    }

    public class CafeOutOfCapacityException extends Exception {
        public CafeOutOfCapacityException() {
            super(message);
        }
    }

    public class Cafe {
        private final int maxCapacity;
        private final Map<String, Integer> menu;
        private final String[] orders;
        private int indexNextOrderToPlace;
        private int indexNextOrderToServe;
        private Object size;
        private Object cost;
        private Object[] ingredients;

        public Cafe() {
            this(100);
        }

        public Cafe(int maxCapacity) {
            this.maxCapacity = maxCapacity;
            menu = new HashMap<>();
            orders = new String[maxCapacity];
            indexNextOrderToPlace = 0;
            indexNextOrderToServe = 0;
        }

        public void addToMenu(String item, int price) {
            menu.put(item, price);
        }

        public void placeOrder(String item) throws RecipeNotFoundException, CafeOutOfCapacityException {
            if (!menu.containsKey(item)) {
                throw new RecipeNotFoundException();
            }
            if (indexNextOrderToPlace >= maxCapacity) {
                throw new CafeOutOfCapacityException();
            }

            orders[indexNextOrderToPlace] = item;
            indexNextOrderToPlace++;
        }

        public void serveOrder() {
            if (indexNextOrderToServe < indexNextOrderToPlace) {
                orders[indexNextOrderToServe] = null;
                indexNextOrderToServe++;
            }
        }

        public void printPendingOrders() {
            System.out.println("Pending Orders:");
            for (int i = indexNextOrderToServe; i < indexNextOrderToPlace; i++) {
                System.out.println((i - indexNextOrderToServe + 1) + ". " + orders[i]);
            }
        }



        public void printMenu() {
        }

        public void addRecipe(Recipe latteRecipe) {
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // create cafe array
        uk.ac.sheffield.com1003.cafe.Cafe cafe = new uk.ac.sheffield.com1003.cafe.Cafe();

        // create espresso recipe
        Ingredient coffee = new Coffee();
        Ingredient water = new Water();
        Recipe espressoRecipe = new Recipe("Espresso", 1.5);
        try {
            espressoRecipe.addIngredient(coffee);
        } catch (TooManyIngredientsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            espressoRecipe.addIngredient(water);
        } catch (TooManyIngredientsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Add recipe to Cafe
        cafe.addRecipe(espressoRecipe);

        // create double espresso recipe
        Ingredient doubleEspressoCoffee = new Coffee();
        Ingredient doubleEspressoWater = new Water();
        Recipe doubleEspressoRecipe = new Recipe("Double Espresso", 2.2);
        try {
            doubleEspressoRecipe.addIngredient(doubleEspressoCoffee);
        } catch (TooManyIngredientsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            doubleEspressoRecipe.addIngredient(doubleEspressoWater);
        } catch (TooManyIngredientsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Add double espresso to cafe
        cafe.addRecipe(doubleEspressoRecipe);

        // create large soy latte recipe
        Ingredient soyMilk = new Milk();
        Ingredient espresso = new Coffee();
        Ingredient steamedMilk = new Milk();
        Ingredient foam = new Milk();
        Recipe latteRecipe = new Recipe("Large Soy Latte", 2.5);
        try {
            latteRecipe.addIngredient(espresso);
        } catch (TooManyIngredientsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            latteRecipe.addIngredient(soyMilk);
        } catch (TooManyIngredientsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            latteRecipe.addIngredient(steamedMilk);
        } catch (TooManyIngredientsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            latteRecipe.addIngredient(foam);
        } catch (TooManyIngredientsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // add large soy latte to Cafe
        cafe.addRecipe(latteRecipe);

        cafe.printMenu();

    }

}
