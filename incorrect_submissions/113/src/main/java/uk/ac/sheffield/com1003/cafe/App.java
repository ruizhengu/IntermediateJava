package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

/**
 * This instantiates a Cafe object, and then instantiates 3 Recipes which have their ingredients added to them.
 * It then adds these Recipes to the Cafe menu and prints this menu to the console.
 */
public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();

        Recipe esp = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Coffee espCoffee = new Coffee(8, false);
        Water espWater = new Water();

        Recipe doubleEsp = new
                Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Coffee doubleEspCoffee = new Coffee(15, false);
        Water doubleEspWater = new Water(50);

        Recipe latte = new
                Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        Coffee latteCoffee = new Coffee(15, false);
        Milk latteMilk = new Milk(50, Milk.Type.SOY);

        try {
            esp.addIngredient(espCoffee);
            esp.addIngredient(espWater);
            doubleEsp.addIngredient(doubleEspCoffee);
            doubleEsp.addIngredient(doubleEspWater);
            latte.addIngredient(latteCoffee);
            latte.addIngredient(latteMilk);
        } catch (TooManyIngredientsException e) {
            System.out.println("This recipe has reached it's max amount of ingredients!");
        }

        cafe.addRecipe(esp);
        cafe.addRecipe(esp);
        cafe.addRecipe(doubleEsp);
        cafe.addRecipe(latte);

        cafe.printMenu();
    }
}
