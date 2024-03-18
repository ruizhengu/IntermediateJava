package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args) {
        // Task1 - creat three new recipes
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);

        // add ingredients
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            System.out.println("Successful addition of espresso's ingredients");

            doubleEspresso.addIngredient(new Water(50));
            doubleEspresso.addIngredient(new Coffee(15));
            System.out.println("Successful addition of double espresso's ingredients");

            largeSoyLatte.addIngredient(new Milk(100, Type.SOY));
            largeSoyLatte.addIngredient(new Coffee());
            System.out.println("Successful addition of large soy latte's ingredients");
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }

        // creat a cafe
        Cafe cafe = new Cafe("Central Perk", 10, 100);

        // add three recipes
        cafe.addRecipe(largeSoyLatte);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(espresso);
        System.out.println("Successful addtion of recipes");

        // Task 2 - print cafe menu
        cafe.printMenu();

        // Task 5 - Compare the differences between the two recipes
        Recipe test1 = new Recipe("test1", 1);

        Recipe test2 = new Recipe("test2", 1, Size.REGULAR, 3);

        try {
            test1.addIngredient(new Coffee(100, true));
            test1.addIngredient(new Syrup());
            test1.addIngredient(new Milk());
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }

        try {
            test2.addIngredient(new Coffee(100, false));
            test2.addIngredient(new Milk());
            test2.addIngredient(new Syrup());
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }

        System.out.println(test1.equals(test2));

        // Task 7 - remove a recipe
        Cafe test = new Cafe();
        test.addRecipe(test2);
        test.addRecipe(test1);
        System.out.println("Before removing recipe test1 ");
        test.printMenu();
        try {
            test.removeRecipe("test1");
        } catch (RecipeNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("After removing recipe test1");
        test.printMenu();
    }
}
