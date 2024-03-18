package uk.ac.sheffield.com1003.cafe;

import java.lang.ProcessBuilder.Redirect.Type;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) {

        Cafe cafe = new Cafe();

        // Create recipe
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);

        // Add ingredient to recipe and catch the exception
        try{
            espresso.addIngredient(new Water());
            espresso.addIngredient(new Coffee());
            cafe.addRecipe(espresso);

            doubleEspresso.addIngredient(new Water(50));
            doubleEspresso.addIngredient(new Coffee(15));
            cafe.addRecipe(doubleEspresso);

            largeSoyLatte.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Coffee(15));
            largeSoyLatte.addIngredient(new Milk(100, uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type.SOY));
            cafe.addRecipe(largeSoyLatte);

        }catch (TooManyIngredientsException e){
            e.printStackTrace();
        }

        cafe.printMenu();
    }
}
