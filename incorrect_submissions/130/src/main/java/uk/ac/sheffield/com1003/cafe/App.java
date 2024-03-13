package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) {

      try{
          // cafe instance
          Cafe cafe = new Cafe("Central Perk");
          // creating recipes
          Recipe espresso = new Recipe("Espresso",1.5, Recipe.Size.SMALL,2);
          Recipe doubleEspresso = new Recipe("Double Espresso",2.2, Recipe.Size.REGULAR,2);
          Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5, Recipe.Size.LARGE,1);

          //adding ingredients to coffee.
          espresso.addIngredient(new Coffee());
          espresso.addIngredient(new Water());

          //adding ingredients to double espresso.
          doubleEspresso.addIngredient(new Coffee(15));
          doubleEspresso.addIngredient(new Water(50));

          // adding ingredients to large soy latte.
          largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
          //adding water
          largeSoyLatte.addIngredient(new Water(75));

          // adding created recipes to the cafe.
          cafe.addRecipe(espresso);
          cafe.addRecipe(doubleEspresso);
          cafe.addRecipe(largeSoyLatte);

          //task 2
          cafe.printMenu();


      }catch(Exception ex){
          ex.printStackTrace();
      }


    }





}
