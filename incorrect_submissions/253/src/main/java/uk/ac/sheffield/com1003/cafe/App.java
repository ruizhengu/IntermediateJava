package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
  
  public static void main(String[] args) throws TooManyIngredientsException,
                                                CafeOutOfCapacityException,
                                                RecipeNotFoundException {
    Cafe cafe = new Cafe();

    Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
    espresso.addIngredient(new Coffee());
    espresso.addIngredient(new Water());
    cafe.addRecipe(espresso);

    Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
    doubleEspresso.addIngredient(new Coffee(15));
    doubleEspresso.addIngredient(new Water(50));
    cafe.addRecipe(doubleEspresso);

    // I have no clue how to make a Latte.
    Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
    largeSoyLatte.addIngredient(new Milk(150, Type.SOY));
    largeSoyLatte.addIngredient(new Coffee(24));
    largeSoyLatte.addIngredient(new Water(90));
    cafe.addRecipe(largeSoyLatte);

    cafe.printMenu();
  }
  
}
