package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.Recipe;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;



public class App {
  public static void main(String[] args) throws TooManyIngredientsException{
    // Create a new cafe
    Cafe cafe = new Cafe("Sheffield Cafe");

    //Create Espresso recipe & add  its ingredients
    Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
    espresso.addIngredient(new Coffee(8, false));
    espresso.addIngredient(new Water());
    cafe.addRecipe(espresso);


    //Add Double Espresso recipe & add  its ingredients
    Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
    doubleEspresso.addIngredient(new Coffee(15));
    doubleEspresso.addIngredient(new Water(50));
    cafe.addRecipe(doubleEspresso);


    // Add Large Soy Latte recipe & add  its ingredients
    Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
    largeSoyLatte.addIngredient(new Coffee(15, false));
    largeSoyLatte.addIngredient(new Milk(60, Milk.Type.SOY));
    cafe.addRecipe(largeSoyLatte);

    // Print the menu
    cafe.printMenu();

  }

}
