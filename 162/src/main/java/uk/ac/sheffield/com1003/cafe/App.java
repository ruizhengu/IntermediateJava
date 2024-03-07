package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import static uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type.SOY;

public class App {

    //Recipe initialization
   private static Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL,2);
   private static Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR,2);
   private static Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE,3);

   public static void main(String[] args) throws TooManyIngredientsException {
       Cafe myCafe = new Cafe(); //creating cafe

      myCafe.addRecipe(espresso);//adding recipe and recipe details to the cafe
       espresso.addIngredient(new Coffee());
       espresso.addIngredient(new Water(50));

       myCafe.addRecipe(doubleEspresso);
       doubleEspresso.addIngredient(new Coffee(15));
       doubleEspresso.addIngredient(new Water(50));

       myCafe.addRecipe(largeSoyLatte);
       largeSoyLatte.addIngredient(new Coffee(15));
       largeSoyLatte.addIngredient(new Water(50));
       largeSoyLatte.addIngredient(new Milk(50,SOY));

       myCafe.printMenu();

    }
}
