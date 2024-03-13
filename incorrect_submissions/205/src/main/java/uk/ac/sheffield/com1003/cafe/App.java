package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
  /**
   * Creates 3 recipes for a cafe and adds to a menu then prints the menu.
   */
  public static void main(String[] args) throws TooManyIngredientsException {

    Cafe cafe = new Cafe();
    Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
    espresso.addIngredient(new Coffee());
    espresso.addIngredient(new Water());
    cafe.addRecipe(espresso);
    Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
    espresso.addIngredient(new Coffee(15));
    espresso.addIngredient(new Water(50));
    cafe.addRecipe(doubleEspresso);
    Recipe largeSoyLatte = new Recipe("Double Espresso", 2.5, Size.LARGE, 3);
    espresso.addIngredient(new Milk(150, Type.SOY));
    espresso.addIngredient(new Coffee());
    espresso.addIngredient(new Water());
    cafe.addRecipe(largeSoyLatte);
    cafe.printMenu();



    }
}
