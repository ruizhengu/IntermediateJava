package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {

    /**
     * Finds add ingredients to specified recipe
     * @param recipe Recipe to add the ingredient to
     * @param ingredient1 First ingredient to add
     * @param ingredient2 Second ingredient to add
     */
    public static void addIngredientsToRecipe(Recipe recipe, Ingredient ingredient1, Ingredient ingredient2) {
        try {
            recipe.addIngredient(ingredient1);
            recipe.addIngredient(ingredient2);
        } catch (TooManyIngredientsException e) {
            System.out.println("More ingredients than expected.");
        }
    }

    /**
     * Finds add ingredients to specified recipe
     * @param recipe Recipe to add the ingredient to
     * @param ingredient1 First ingredient to add
     * @param ingredient2 Second ingredient to add
     * @param ingredient3 Third ingredient to add
     */
    public static void addIngredientsToRecipe(Recipe recipe, Ingredient ingredient1, Ingredient ingredient2,
                                              Ingredient ingredient3) {
        try {
            recipe.addIngredient(ingredient1);
            recipe.addIngredient(ingredient2);
            recipe.addIngredient(ingredient3);
        } catch (TooManyIngredientsException e) {
            System.out.println("More ingredients than expected.");
        }
    }

    /**
     * Place an order to the defined cafe with the defined details
     * @param cafeName Cafe to receive the order
     * @param recipeName Recipe to add to the order
     * @param customerName Customer name to be associated with the order
     * @param amountPaid Payment received for the order
     */
    public static void placingOrder(Cafe cafeName, String recipeName, String customerName, double amountPaid) {
        try {
            cafeName.placeOrder(recipeName, customerName, amountPaid);
        } catch (RecipeNotFoundException e) {
            System.out.println("Recipe name does not exist in the menu.");
        } catch (CafeOutOfCapacityException e) {
            System.out.println("Cafe cannot take any more orders and is out of capacity.");
        }
    }

    public static void main (String []args) {

        // PLEASE UNCOMMENT FOLLOWING CODE TO SEE A DEMONSTRATION OF MY CODE IN PROGRESS

        /*

        //Create a new instance of the Cafe class
        Cafe myCafe = new Cafe("Sheffield Cafe");

        //Create 5 new recipes
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL , 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe cappuccino = new Recipe("Cappuccino", 3, Recipe.Size.LARGE, 4);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        Recipe largeSoyLatte2 = new Recipe("Large Soy Latte2", 3, Recipe.Size.LARGE, 3);

        //Adding ingredients to my 5 new recipes
        addIngredientsToRecipe(espresso, new Coffee(), new Water());
        addIngredientsToRecipe(doubleEspresso, new Coffee(15), new Water(50));
        addIngredientsToRecipe(cappuccino, new Coffee(20), new Milk(200, Milk.Type.WHOLE),
                new Syrup(5, "Caramel"));
        addIngredientsToRecipe(largeSoyLatte, new Coffee(20), new Water(50),
                new Milk(200, Milk.Type.SOY));
        addIngredientsToRecipe(largeSoyLatte2, new Coffee(20), new Water(50),
                new Milk(200, Milk.Type.SOY));

        //Add new recipes to myCafe
        myCafe.addRecipe(espresso);
        myCafe.addRecipe(doubleEspresso);
        myCafe.addRecipe(cappuccino);
        myCafe.addRecipe(largeSoyLatte);

        //Demonstrating the .equals method for recipes
        boolean isLatteEqualToEspresso = largeSoyLatte.equals(espresso);
        boolean isLatteEqualToLatte = largeSoyLatte.equals(largeSoyLatte);
        boolean isLatteEqualToLatte2 = largeSoyLatte.equals(largeSoyLatte2);

        //Place two new orders
        placingOrder(myCafe, "Espresso", "John", 1.5);
        placingOrder(myCafe, "Double Espresso", "Mat", 5);

        myCafe.printMenu();

        //Showcasing the printPendingOrders and serveOrder method
        myCafe.printPendingOrders();
        myCafe.serveOrder();
        myCafe.printPendingOrders();

        //Showcasing the removeRecipe method
        myCafe.removeRecipe("Double Espresso");
        myCafe.printMenu();

        */
    }
}
