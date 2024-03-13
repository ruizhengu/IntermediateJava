package uk.ac.sheffield.com1003.cafe;

import javax.print.attribute.standard.JobSheets;

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
    public static void main(String[] args) {
        Cafe cafe = new Cafe("Froth Creme");

        //Creating and adding an espresso recipe
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL,2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients have been added");
        }

        cafe.addRecipe(espresso);

        //Creating and adding a double espresso recipe
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients have been added");
        }

        cafe.addRecipe(doubleEspresso);

        //Creating and adding a large soy latte recipe
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        try {
            largeSoyLatte.addIngredient(new Coffee());
            largeSoyLatte.addIngredient(new Milk(100, Type.SOY));
            largeSoyLatte.addIngredient(new Syrup());
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients have been added");
        }

        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();

    }
}
