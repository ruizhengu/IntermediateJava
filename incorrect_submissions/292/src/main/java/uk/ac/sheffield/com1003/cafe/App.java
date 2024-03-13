package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

public class App {

   public static void main(String[] args) throws Exception {

      // create a Cafe instance
      Cafe myCafe = new Cafe("My Cafe");

      // create three drink recipes to the menu
      Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
      espresso.addIngredient(new Coffee(8, false));
      espresso.addIngredient(new Water(30));
      espresso.isReady(); // check that recipe is ready for use
      myCafe.addRecipe(espresso); 

      Recipe doubleEspresso = new Recipe(
         "Double Espresso", 2.2, Size.REGULAR, 2);
      doubleEspresso.addIngredient(new Coffee(15));
      doubleEspresso.addIngredient(new Water(50));
      doubleEspresso.isReady();
      myCafe.addRecipe(doubleEspresso);

      Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
      largeSoyLatte.addIngredient(new Coffee(60));
      largeSoyLatte.addIngredient(new Milk(150, Type.SOY));
      largeSoyLatte.isReady();
      myCafe.addRecipe(largeSoyLatte);

      // print a greeting message & the list of full menu
      myCafe.printMenu();

      // implement placeOrder() & serveOrder()
      myCafe.placeOrder("Espresso", "Ji ah", 1.5);
      myCafe.serveOrder();
   }
}