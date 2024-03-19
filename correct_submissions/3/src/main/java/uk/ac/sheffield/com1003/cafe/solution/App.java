package uk.ac.sheffield.com1003.cafe.solution;

import uk.ac.sheffield.com1003.cafe.solution.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.solution.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.solution.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.solution.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.solution.ingredients.Water;

/**
 * Task 1 - Create an Espresso, Double Espresso and Soy Latte Recipe according to specification
 * and add it your cafe. Requires modifying default constructors in Coffee and Milk and adding
 * a new constructor to each that takes an integer amount as a parameter. Must produce meaningful
 * messages in its run.
 *
 * @version 1.3 16/03/2023
 * @since 0.1
 * @author unknown
 */
public class App {
  public static void main(String[] args) {
    // Task 1
    Cafe cafe = new Cafe("Ten Forward");
    System.out.println(cafe.getName() + " cafe created!");
    System.out.println();

    // Create and add Espresso to cafe
    Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
    System.out.println(espresso.getName() + " recipe created!");
    try {
      espresso.addIngredient(new Coffee());
      System.out.println("Coffee added to " + espresso.getName() + "!");
      espresso.addIngredient(new Water());
      System.out.println("Water added to " + espresso.getName() + "!");
      cafe.addRecipe(espresso);
      System.out.println(espresso.getName() + " added to menu of " + cafe.getName() + "!");
    } catch (TooManyIngredientsException e) {
      System.out.println("Too many ingredients were added to " + espresso.getName()
          + " recipe so ingredient was not added to " + espresso.getName());
    }
    System.out.println();

    // Create and add double Espresso to cafe
    Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
    System.out.println(doubleEspresso.getName() + " recipe created!");
    try {
      doubleEspresso.addIngredient(new Coffee(15));
      System.out.println("Coffee added to " + doubleEspresso.getName() + "!");
      doubleEspresso.addIngredient(new Water(50));
      System.out.println("Water added to " + doubleEspresso.getName() + "!");
      cafe.addRecipe(doubleEspresso);
      System.out.println(doubleEspresso.getName() + " added to menu of " + cafe.getName() + "!");
    } catch (TooManyIngredientsException e) {
      System.out.println("Too many ingredients were added to " + doubleEspresso.getName()
          + " recipe so ingredient was not added to " + doubleEspresso.getName());
    }
    System.out.println();

    // Create and add large Soy Latte to cafe
    Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
    System.out.println(largeSoyLatte.getName() + " recipe created!");
    try {
      largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
      System.out.println("Milk added to " + largeSoyLatte.getName() + "!");
      largeSoyLatte.addIngredient(new Coffee(50));
      System.out.println("Coffee added to " + largeSoyLatte.getName() + "!");
      largeSoyLatte.addIngredient(new Syrup());
      System.out.println("Syrup added to " + largeSoyLatte.getName() + "!");
      cafe.addRecipe(largeSoyLatte);
      System.out.println(largeSoyLatte.getName() + " added to menu of " + cafe.getName() + "!");
    } catch (TooManyIngredientsException e) {
      System.out.println("Too many ingredients were added to " + largeSoyLatte.getName()
          + " recipe so ingredient was not added to " + largeSoyLatte.getName());
    }
    System.out.println();

    // Task 2
    cafe.printMenu();
  }
}
