package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

/**
 * The App class allows the cafe to be run and to add recipes to it.
 *
 * @author Yusuf Ibn Saifullah
 * @since 12-03-2023
 */
public class App {
  public static void main(String[] args) {
    Cafe sheffieldCafe = new Cafe();

    // Espresso recipe
    Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
    try {
      espresso.addIngredient(new Coffee());
      espresso.addIngredient(new Water());
    } catch (TooManyIngredientsException exception) {
      System.out.println(exception.getMessage());
    }

    sheffieldCafe.addRecipe(espresso);

    // Double Espresso recipe
    Recipe doubleEspresso = new Recipe("Double Espresso", 2.20, Size.REGULAR, 2);
    try {
      doubleEspresso.addIngredient(new Coffee(15));
      doubleEspresso.addIngredient(new Water(50));
    } catch (TooManyIngredientsException exception) {
      System.out.println(exception.getMessage());
    }

    sheffieldCafe.addRecipe(doubleEspresso);

    // Large Soy Latte recipe
    Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.50, Size.LARGE, 2);
    try {
      doubleEspresso.addIngredient(new Coffee(15));
      largeSoyLatte.addIngredient(new Milk(100, Type.SOY));
    } catch (TooManyIngredientsException exception) {
      System.out.println(exception.getMessage());
    }

    sheffieldCafe.addRecipe(largeSoyLatte);

    sheffieldCafe.printMenu();
  }
}
