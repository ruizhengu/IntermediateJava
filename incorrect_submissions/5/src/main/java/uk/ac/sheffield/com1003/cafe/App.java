package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args) {

        // Task 1

        // Creates the cafe
        Cafe cafe = new Cafe("Cafe Gijon");

        // Creates the Espresso drink
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);

        Ingredient [] ingredients1 = {
            new Coffee(),
            new Water()
        };

        try {
            espresso.addIngredient(ingredients1[0]);
            espresso.addIngredient(ingredients1[1]);
        } catch (TooManyIngredientsException exception) {
            System.err.println(exception + ": there are too many ingredients for the Espresso");
        }

        cafe.addRecipe(espresso);

        // Creates the Double Espresso drink
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);

        Ingredient [] ingredients2 = {
            new Coffee(15),
            new Water(50)
        };

        try {
            doubleEspresso.addIngredient(ingredients2[0]);
            doubleEspresso.addIngredient(ingredients2[1]);
        } catch (TooManyIngredientsException exception) {
            System.err.println(exception + ": there are too many ingredients for the Double Espresso");
        }

        cafe.addRecipe(doubleEspresso);

        // Creates the Large Soy Latte drink
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);

        Ingredient [] ingredients3 = {
            new Milk(30, Type.SOY),
            new Coffee(40)
        };

        try {
            largeSoyLatte.addIngredient(ingredients3[0]);
            largeSoyLatte.addIngredient(ingredients3[1]);
        } catch (TooManyIngredientsException exception) {
            System.err.println(exception + ": there are too many ingredients for the Large Soy Latte");
        }

        cafe.addRecipe(largeSoyLatte);

        // Task 2

        // Prints the cafe's menu
        cafe.printMenu();

    }
}
