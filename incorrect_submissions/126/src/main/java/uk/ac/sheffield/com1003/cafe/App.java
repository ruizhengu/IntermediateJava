package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.Cafe;

public class App {
     public static void main(String [] args) {
          /* Creating a new instance of the Cafe class */
          Cafe cafe = new Cafe() {
          };

          /* Creating new Recipe instances to add them to the recipe list */
          Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);

          /**
           * New instances of both Coffee and Water created with the correct parameters
           * New instances of Recipe and Milk have also bee created for special recipes
           */
          Coffee coffee = new Coffee(15, false);
          Water water = new Water(50);

          Recipe dEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);

          Milk soyMilk = new Milk(100, Milk.Type.SOY);

          Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);

          /* Using my instance of Cafe to add the recipes to the list */
          cafe.addRecipe(espresso);
          cafe.addRecipe(dEspresso);
          cafe.addRecipe(largeSoyLatte);


     }
}
