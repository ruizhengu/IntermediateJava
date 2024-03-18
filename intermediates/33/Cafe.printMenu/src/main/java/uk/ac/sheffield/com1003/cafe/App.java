package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Unit;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static final int DEFAULT_CAFE_CAPACITY = 0;
    private static final Size size = null;
    private static final Type SOY = null;

    public static void main(String[] args) throws TooManyIngredientsException {

        // Create a new cafe instance
        Cafe cafe = new Cafe("Cafe");

        // Create the Espresso recipe

        Recipe espressoRecipe = new Recipe("Espresso", 1.5);
        espressoRecipe.addIngredient(new Coffee());
        espressoRecipe.addIngredient(new Water());
        cafe.addRecipe(espressoRecipe);

        // Create the Double Espresso recipe
        Cafe two = new Cafe("Double Espresso");
        Recipe doubleEspressoRecipe = new Recipe("Double Espresso", 2.2);
        doubleEspressoRecipe.addIngredient(new Coffee(15, false));
        doubleEspressoRecipe.addIngredient(new Water(50, true));
        cafe.addRecipe(doubleEspressoRecipe);

        // Create the Large Soy Latte recipe
        Recipe largeSoyLatteRecipe = new Recipe("Large Soy Latte", 2.5);
        largeSoyLatteRecipe.addIngredient(new Coffee());
        largeSoyLatteRecipe.addIngredient(new Water(100, true));
        largeSoyLatteRecipe.addIngredient(new Milk(200, SOY));
        cafe.addRecipe(largeSoyLatteRecipe);
        cafe.getMenu();
        // Print the menu
    }

    private Recipe[] orders;
    private int indexNextOrderToPlace;
    private int indexNextOrderToServe;
    //private String recipeName;

    public void Cafe(int capacity) {
        orders = new Recipe[capacity];
        indexNextOrderToPlace = 0;
        indexNextOrderToServe = 0;
    }

    public void placeOrder(String recipeName) throws RecipeNotFoundException, CafeOutOfCapacityException {
        Recipe recipe = findRecipe(recipeName);
        if (recipe == null) {
            throw new RecipeNotFoundException();
        }
        if (indexNextOrderToPlace == orders.length) {
            throw new CafeOutOfCapacityException();
        }
        orders[indexNextOrderToPlace] = recipe;
        indexNextOrderToPlace++;
        System.out.println("Order placed: " + recipe.getName());
    }

    public void serveOrder() {
        if (indexNextOrderToServe < indexNextOrderToPlace) {
            Recipe recipe = orders[indexNextOrderToServe];
            indexNextOrderToServe++;
            System.out.println("Order served: " + recipe.getName());
        } else {
            System.out.println("No orders to serve");
        }
    }

    public Recipe findRecipe(String recipeName) {
        return null;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Recipe other = (Recipe) obj;
        if (!Arrays.equals(orders, other.ingredients))
            return false;
        if (size != other.size)
            return false;
        return true;
    }

    public class Syrup extends Ingredient {
        private String flavour;

        public Syrup(String flavour, int amount, Unit unit) {
            super();
            this.flavour = flavour;
        }

        public Syrup(String flavour) {
            this(flavour, 0, Unit.ML);
        }

        public String getFlavour() {
            return flavour;
        }

        @Override
        public String toString() {
            return "Syrup [unit=" + getUnit() + ", amount=" + getAmount() + ", flavour=" + flavour + "]";
        }
    }
}