package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {

    /**
     * main method to run the Cafe()
     * initialise and call methods on the main() body to see how the cafe works.
     */
    public static void main(String[] args)throws TooManyIngredientsException, 
                                                 CafeOutOfCapacityException,
                                                 RecipeNotFoundException {
        
        // creating cafe object
         Cafe cafe = new Cafe();
        // uncomment this andcomment above 'cafe' object to trigger CafeOutOfCapacityException
        // Cafe cafe = new Cafe("MyCafe", 10, 1);

        // listing of all recipes
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);

        Recipe tripleShots = new Recipe("Triple Shots", 4.0, Size.REGULAR, 3);
        Recipe largeSoyLatte2 = new Recipe("Large Soy Latte2", 2.5, Size.LARGE,2);

        // adding ingredients the recipes
        try {

            // uncomment this to trigged TooManyIngredientsException
            // espresso.addIngredient(new Milk(30));
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
    
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));

            largeSoyLatte.addIngredient(new Water(90));
            largeSoyLatte.addIngredient(new Coffee());
            largeSoyLatte.addIngredient(new Milk(Type.SOY));

            tripleShots.addIngredient(new Milk(40));
            tripleShots.addIngredient(new Water(90));
            tripleShots.addIngredient(new Syrup());
    
            largeSoyLatte2.addIngredient(new Milk());
            largeSoyLatte2.addIngredient(new Water(90));
            
        } catch (TooManyIngredientsException e) {
            System.out.println("Error while calling addIngredient()");
            System.exit(0);
        }

        // adding recipes to the cafe's menu
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(tripleShots);
        cafe.addRecipe(largeSoyLatte);
        cafe.addRecipe(largeSoyLatte2);

        // printing the cafe's menu
        cafe.printMenu();

        // try placing customer orders
        try {
            cafe.placeOrder("Espresso", "Afiq", 3);
            cafe.placeOrder("Double Espresso", "Afiq", 3);
        } catch (Exception e) {
            System.out.println("Error while calling placeOrder()");
            System.exit(0);
        }
        
        // printing pending orders
        System.out.println();
        cafe.printPendingOrders();
        System.out.println();

        // serving customer orders
        cafe.serveOrder();
        
        // printing pending orders
        cafe.printPendingOrders();
        System.out.println();
        
        // checking between 2 recipes either same or not
        Recipe recipe1 = espresso;
        Recipe recipe2 = largeSoyLatte;

        System.out.println("COMPARING: " + recipe1.getName() + " vs " + recipe2.getName());
        Boolean isSameRecipe = recipe1.equals(recipe2);
        System.out.println("SAME RECIPE: " + isSameRecipe);
        System.out.println();

        // removing recipe from menu
        try {
            cafe.removeRecipe("Large Soy Latte2");
            // uncomment below code to trigger RecipeNotFoundException()
            // cafe.removeRecipe("Large Soy Ljatte2");
        } catch (RecipeNotFoundException e) {
            System.out.println("Error while calling removeRecipe()");
            System.exit(0);
        }

        // reprinting cafe's menu to see the removed recipe
        cafe.printMenu();
        
    }
}
