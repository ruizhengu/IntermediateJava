package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.*;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

// Task 1 - Create a new class named App with a main method with the following three drink Recipe instances.
public class App {
    public static void main(String[] args) throws TooManyIngredientsException {
        // Create a Cafe instance
        Cafe cafe = new Cafe();

        // Create an Espresso recipe with ingredients, default amount of coffee and water
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());

        // Creates a Double Espresso recipe with different ingredient amounts of coffee and water
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Coffee(15));
        doubleEspresso.addIngredient(new Water(50));

        // Creates a Large Soy Latte recipe with different ingredient amounts of coffee, water and soy milk
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        largeSoyLatte.addIngredient(new Coffee(30));
        largeSoyLatte.addIngredient(new Water(60));
        largeSoyLatte.addIngredient(new Milk(60, Milk.Type.SOY));

        // Add the recipes to the cafe
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        // Print menu
        cafe.printMenu();
    }
}