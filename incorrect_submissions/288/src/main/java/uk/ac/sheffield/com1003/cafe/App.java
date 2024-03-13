package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

public class App {
    public static void main(String[] args) {
        try {
        // Create a new Cafe instance
        Cafe myCafe = new Cafe("Rawan's Cafe");

        // Create the three drink Recipe instances
        Recipe espressoRecipe = new Recipe("Espresso", 1.5);
        espressoRecipe.addIngredient(new Coffee());
        espressoRecipe.addIngredient(new Water());

        Recipe doubleEspressoRecipe = new Recipe("Double Espresso", 2.2);
        doubleEspressoRecipe.addIngredient(new Coffee(15));
        doubleEspressoRecipe.addIngredient(new Water(50));

        Recipe largeSoyLatteRecipe = new Recipe("Large Soy Latte", 2.5);
        largeSoyLatteRecipe.addIngredient(new Coffee(30));
        largeSoyLatteRecipe.addIngredient(new Milk(40, Milk.Type.SOY));
        largeSoyLatteRecipe.addIngredient(new Water(20));

        // Add the drink recipes to the Cafe instance
        myCafe.addRecipe(espressoRecipe);
        myCafe.addRecipe(doubleEspressoRecipe);
        myCafe.addRecipe(largeSoyLatteRecipe);

        // Print the menu
        myCafe.printMenu();
        } catch (TooManyIngredientsException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
