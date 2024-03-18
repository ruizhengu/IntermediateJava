package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;

public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();

        // Create a new recipe for an espresso
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        }
        catch (TooManyIngredientsException e) {
            System.out.println("Couldn't add ingredient to the Espresso recipe as maximum number of ingredients reached. Consider increasing numberOfIngredients.");
        }
        
        // Create a new recipe for a double espresso
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        }
        catch (TooManyIngredientsException e) {
            System.out.println("Couldn't add ingredient to the Double Espresso recipe as maximum number of ingredients reached. Consider increasing numberOfIngredients.");
        }

        // Create a new recipe for a large soy latte
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        try {
            largeSoyLatte.addIngredient(new Coffee(40));
            largeSoyLatte.addIngredient(new Milk(200, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Water(20));
        }
        catch (TooManyIngredientsException e) {
            System.out.println("Couldn't add ingredient to the Large Soy Latte recipe as maximum number of ingredients reached. Consider increasing numberOfIngredients.");
        }
        
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);
    }
}
