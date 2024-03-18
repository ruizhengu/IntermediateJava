package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
  public static void main(String [] args) throws TooManyIngredientsException {
    Cafe cafeOne = new Cafe();

    //Creates new recipe called Espresso
    Recipe Espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
    //Tries to add ingredients to recipe but will handle exceptions if thrown
    try {
      Espresso.addIngredient(new Coffee());
      Espresso.addIngredient(new Water());
    } catch (TooManyIngredientsException e) {
      System.out.println(e + " Too many Ingredients!");
    }
    cafeOne.addRecipe(Espresso);

    //Creates new recipe called Double Espresso
    Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
    //Tries to add ingredients to recipe but will handle exceptions if thrown
    try {
      doubleEspresso.addIngredient(new Coffee(15));
      doubleEspresso.addIngredient(new Water(50));
    } catch (TooManyIngredientsException e) {
      System.out.println(e + " Too many Ingredients!");
    }
    cafeOne.addRecipe(doubleEspresso);

    //Creates new recipe called Large Soy Latte
    Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
    //Tries to add ingredients to recipe but will handle exceptions if thrown
    try {
      largeSoyLatte.addIngredient(new Coffee());
      largeSoyLatte.addIngredient(new Milk(150, Type.SOY));
    } catch (TooManyIngredientsException e) {
      System.out.println(e + " Too many Ingredients!");
    }
    cafeOne.addRecipe(largeSoyLatte);

    cafeOne.printMenu();

    //Tries to place order and will handle any exceptions thrown
    try {
      cafeOne.placeOrder("Espresso", "Josh", 1.5);
    } catch (RecipeNotFoundException e) {
      System.out.println(e + "Recipe not found!");
    } catch (CafeOutOfCapacityException e) {
      System.out.println(e + "Cafe is out of Capacity");
    }

    try {
      cafeOne.placeOrder("Large Soy Latte", "Josh", 2.5);
    } catch (RecipeNotFoundException e) {
      System.out.println(e + "Recipe not found!");
    } catch (CafeOutOfCapacityException e) {
      System.out.println(e + "Cafe is out of Capacity!");
    }

    cafeOne.printPendingOrders();
  }
}
