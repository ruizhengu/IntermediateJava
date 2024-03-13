package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import static uk.ac.sheffield.com1003.cafe.Recipe.Size.*;
import static uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type.*;

public class App {

    public static void main(String[] args) throws TooManyIngredientsException,
            RecipeNotFoundException, CafeOutOfCapacityException {

      Cafe cafe = new Cafe(); //Create a new cafe Object

      //Create recipes for the Cafe

      //Recipe for espresso

      Recipe espresso = new Recipe("Espresso", 1.5, SMALL, 2);
      //Add ingredients
      espresso.addIngredient(new Coffee());
      espresso.addIngredient(new Water());
      cafe.addRecipe(espresso);


      //Recipe for double espresso

      Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, REGULAR, 2);
      Coffee doubleEspressoCoffee = new Coffee(15); //new instance of coffee for double espresso
      Water doubleEspressoWater = new Water(50); //new instance of water for double espresso
      //add ingredients to recipe object "doubleEspresso"
      doubleEspresso.addIngredient(doubleEspressoCoffee);
      doubleEspresso.addIngredient(doubleEspressoWater);
      //add doubleEspresso to menu
      cafe.addRecipe(doubleEspresso);



      //Recipe for Large Soy Latte

      Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, LARGE, 3);
      //Create ingredients
      Coffee largeSoyLatteCoffee = new Coffee(15);
      Water largeSoyLatteWater = new Water();
      Milk largeSoyLatteMilk = new Milk(300, SOY);
      //Add ingredients
      largeSoyLatte.addIngredient(largeSoyLatteCoffee);
      largeSoyLatte.addIngredient(largeSoyLatteWater);
      largeSoyLatte.addIngredient(largeSoyLatteMilk);
      //Add largeSoyLatte to menu
      cafe.addRecipe(largeSoyLatte);
      
      cafe.printMenu();
      }

    }
